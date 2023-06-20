package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Personagem implements Serializable {

    protected ImageIcon iImage;
    public String bDirecao = "Down";
    protected Posicao pPosicao;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected boolean bColetavel;
    protected boolean bDestrutivo; //característica dos blocos
    protected boolean bFixo; //característica dos blocos

    protected Personagem(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = false;
        this.bMortal = false;
        this.bColetavel = false;
        this.bDestrutivo = false;
        this.bFixo = true;
        atualizaImagem(sNomeImagePNG);
    }

    public Posicao getPosicao() {
        /*TODO: Retirar este método para que objetos externos nao possam operar --> POR QUÊ?
         diretamente sobre a posição do Personagem*/
        return pPosicao;
    }

    public void atualizaImagem(String sNomeImagePNG){
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public boolean isbTransponivel() {
        return bTransponivel;
    }
    public String isbDirecao(){return bDirecao;}
    public boolean isbMortal(){ return bMortal;}
    public boolean isbColetavel(){return bColetavel;}
    public boolean isbDestrutivo(){return bDestrutivo;}
    public boolean isbFixo(){return bFixo;}

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }

    public boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;
    }
    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
    public abstract void colisao(Personagem p);
}
