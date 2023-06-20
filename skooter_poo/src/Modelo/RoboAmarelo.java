package Modelo;

import java.util.Random;

public class RoboAmarelo extends Personagem {
    private int timer = -50;

    public RoboAmarelo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
        this.bTransponivel = true;
    }

    public void autoDesenho() {
        if (timer == 10) {
            Random rand = new Random();
            int iDirecao = rand.nextInt(4);

            //Direita
            if (iDirecao == 0) {
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() + 1);
                validaPosicao();
                this.atualizaImagem("roboAmareloR.png");
            }
            //Baixo
            else if (iDirecao == 1) {
                this.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                validaPosicao();
                this.atualizaImagem("roboAmareloD.png");
            }
            //Esquerda
            else if (iDirecao == 2) {
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
                validaPosicao();
                this.atualizaImagem("roboAmareloL.png");
            }
            //Cima
            else {
                this.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                validaPosicao();
                this.atualizaImagem("roboAmareloU.png");
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
