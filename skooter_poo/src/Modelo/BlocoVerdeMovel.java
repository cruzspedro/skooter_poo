package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class BlocoVerdeMovel extends Personagem{

    public BlocoVerdeMovel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = false;
        this.bTransponivel = false;
        this.bDestrutivo = true;
        this.bFixo = false;
    }

    public void autoDesenho(){
        super.autoDesenho();
    }
    @Override
    public void colisao(Personagem p) {

    }
}
