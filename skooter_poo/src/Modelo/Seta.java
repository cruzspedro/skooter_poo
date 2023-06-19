package Modelo;

public class Seta extends Personagem{
    public Seta(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = true;
    }

    public void autoDesenho(){
        super.autoDesenho();
    }


    @Override
    public void colisao(Personagem p) {

    }
}
