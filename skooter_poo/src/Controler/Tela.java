package Controler;

import Auxiliar.*;
import Modelo.Personagem;
import Modelo.Skoot;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    public Skoot skoot;
    private Music musica;
    public ArrayList<Personagem> faseAtual;
    public ControleDeJogo cj = new ControleDeJogo();
    public Graphics g2;

    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<Personagem>();
        String soundtrack = "soundtrack.wav";
        music(soundtrack);
    }

    public boolean ehPosicaoValida(Posicao p){
        return cj.ehPosicaoValida(this.faseAtual, p);
    }
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    public void paint(Graphics gOld) {

        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário de fundo in-game*/
        if (Fases.faseCounter == 0 || Fases.faseCounter == 5){
            try {
                /*Desenha a tela de menu*/
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + Fases.bg);
                g2.drawImage(newImage, 0, 0, null);
            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            for (int i = 0; i < Consts.RES; i++) {
                for (int j = 0; j < Consts.RES; j++) {
                    try {
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + Fases.bg);
                        g2.drawImage(newImage,
                                j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                    } catch (IOException ex) {
                        Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            this.cj.processaTudo(faseAtual);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                skoot.bDestruidor = false;
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                skoot.bDirecao = "Neutral";
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                skoot.bDirecao = "Neutral";
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                skoot.bDirecao = "Neutral";
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                skoot.bDirecao = "Neutral";
            }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.faseAtual.clear();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            skoot.bDirecao = "Up";
            skoot.atualizaImagem("skoot_atualiizado_U.png");
            skoot.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            skoot.bDirecao = "Down";
            skoot.atualizaImagem("skoot_atualizado.png");
            skoot.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            skoot.bDirecao = "Left";
            skoot.atualizaImagem("skoot_atualizado_L.png");
            skoot.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            skoot.bDirecao = "Right";
            skoot.atualizaImagem("skoot_atualizado_R.png");
            skoot.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            this.proximaFase();
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (Fases.faseCounter != 0)
                this.saveGame();
        }else if (e.getKeyCode() == KeyEvent.VK_L) {
            if (Fases.faseCounter != 0)
                this.loadGame();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (Fases.faseCounter == 0) {
                this.proximaFase();
            } else skoot.bDestruidor = true;
        }


        this.setTitle("-> Cell: " + (skoot.getPosicao().getColuna()) + ", "
                + (skoot.getPosicao().getLinha()));

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void music(String soundtrack){
        if (musica == null){
            try {
                String currentPath = new java.io.File(".").getCanonicalPath();
                String soundtrackPath = currentPath + Consts.PATH_SOUND + soundtrack;
                musica = new Music(soundtrackPath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    };
    public void musicClose(){
        if (musica != null){
            musica.pause();
            musica = null;
        }
    }
    public void proximaFase() {
        if (skoot != null){
            skoot.setPosicao(0, 7);
        }
        Fases.proximaFase();
        faseAtual.clear();
        if (Fases.faseCounter != 5){
            faseAtual.addAll(Fases.primeiraFase());
            skoot = (Skoot) faseAtual.get(faseAtual.size() - 1);
        }
    }

    public void saveGame(){
        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            String savePath = currentPath + File.separator + "src" + File.separator + "Save.txt";
            FileWriter fileWriter = new FileWriter(savePath, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(skoot.vidas);
            printWriter.println(Fases.faseCounter);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void loadGame(){
        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            String savePath = currentPath + File.separator + "src" + File.separator + "Save.txt";
            FileReader fileReader = new FileReader(savePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String buffer = "";
            buffer = bufferedReader.readLine();
            skoot.vidas = Integer.parseInt(buffer);
            buffer = bufferedReader.readLine();
            Fases.faseCounter = Integer.parseInt(buffer) - 1;
            proximaFase();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         //this.skoot.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        //repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    static class Finaliza extends TimerTask {
        @Override
        public void run() {
            Timer timer = new Timer();
            System.exit(0);
        }
    }

    public void gameOver() {
        Timer timer = new Timer();
        timer.schedule(new Finaliza(), 7000);
    }

}
