package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class BlocoVermelho extends Personagem{

    public BlocoVermelho(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = false;
        this.bTransponivel = false;
    }

    public void autoDesenho(){
        super.autoDesenho();
    }
    @Override
    public void colisao(Personagem p) {

    }
}
