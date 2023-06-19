package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class Coletavel extends Personagem{

    public Coletavel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = true;
        this.bColetavel = true;
    }

    public void autoDesenho(){
        super.autoDesenho();
    }
    @Override
    public void colisao(Personagem p) {

    }
}