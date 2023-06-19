package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class BlocoVerde extends Personagem{

    public BlocoVerde(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = false;
        this.bTransponivel = false;
        this.bFixo = true;
        this.bDestrutivo = true;
    }

    public void autoDesenho(){
        super.autoDesenho();
    }
    @Override
    public void colisao(Personagem p) {

    }
}
