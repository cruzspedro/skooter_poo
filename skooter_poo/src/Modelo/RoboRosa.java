package Modelo;

import java.util.Random;

public class RoboRosa extends Personagem {
    private int timer = -50;

    public RoboRosa(String sNomeImagePNG) {
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
                this.atualizaImagem("roboRosaR.png");
            }
            //Baixo
            else if (iDirecao == 1) {
                this.setPosicao(pPosicao.getLinha() + 1, pPosicao.getColuna());
                validaPosicao();
                this.atualizaImagem("roboRosaD.png");
            }
            //Esquerda
            else if (iDirecao == 2) {
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
                validaPosicao();
                this.atualizaImagem("roboRosaL.png");
            }
            //Cima
            else {
                this.setPosicao(pPosicao.getLinha() - 1, pPosicao.getColuna());
                validaPosicao();
                this.atualizaImagem("roboRosaU.png");
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
