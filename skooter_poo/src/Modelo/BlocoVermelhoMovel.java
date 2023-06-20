package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class BlocoVermelhoMovel extends Personagem{

    public BlocoVermelhoMovel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = false;
        this.bTransponivel = false;
        this.bFixo = false;
    }

    public void autoDesenho(){
        super.autoDesenho();
    }
    @Override
    public void colisao(Personagem p) {

    }
}
