package Modelo;

import java.util.Random;

public class RoboVerde extends Personagem{
    private int timer = 0;
    public RoboVerde(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
        this.bTransponivel = true;
    }

    public void autoDesenho(){
        if (timer == 10){
            Random rand = new Random();
            int iDirecao = rand.nextInt(4);

            //Direita
            if (iDirecao == 0) {
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() + 1);
                validaPosicao();
                this.atualizaImagem("roboVerdeR.png");
            }
            //Baixo
            else if (iDirecao == 1) {
                this.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                validaPosicao();
                this.atualizaImagem("roboVerdeD.png");
            }
            //Esquerda
            else if (iDirecao == 2) {
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
                validaPosicao();
                this.atualizaImagem("roboVerdeL.png");
            }
            //Cima
            else {
                this.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                validaPosicao();
                this.atualizaImagem("roboVerdeU.png");
            }
            timer = 0;
        }
        timer++;
        super.autoDesenho();
    }


    @Override
    public void colisao(Personagem p) {

    }
}
