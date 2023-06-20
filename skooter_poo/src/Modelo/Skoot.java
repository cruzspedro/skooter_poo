package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.ControleDeJogo;
import Controler.Tela;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Skoot extends Personagem implements Serializable{
    public int itens = 0;
    public int vidas = 3;
    public boolean movel = true;
    public boolean bDestruidor = false;
    public Skoot(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }
    @Override
    public boolean validaPosicao(){
        if (!movel){
            this.voltaAUltimaPosicao();
            return false;
        }
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;
    }

    public boolean isbDestruidor(){return bDestruidor;}
    
    public boolean moveUp() {
        if(super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        if(super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        if(super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft())
            return validaPosicao();
        return false;
    }

    @Override
    public void colisao(Personagem p) {

    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}
