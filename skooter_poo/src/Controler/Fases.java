package Controler;

import Auxiliar.Desenho;
import Modelo.*;

import java.util.ArrayList;

public class Fases {

    public static int faseCounter = 0;
    public static String bg = "telaMenu.png";
    public static Skoot skoot = new Skoot("skoot_atualizado.png");

    public static void reiniciaFase() {
        faseCounter--;
        Desenho.acessoATelaDoJogo().proximaFase();
    }

    public static void proximaFase() {
        faseCounter++;
        if (faseCounter == 5) {
            telaFinal();
        } else {
            seletorFase(faseCounter);
            bg = "bg" + faseCounter + ".png";
        }
    }

    public static void telaFinal() {
        if (Desenho.acessoATelaDoJogo().skoot.vidas > 0) {
            bg = "telaFinal.png";
            Desenho.acessoATelaDoJogo().faseAtual.clear();
            Desenho.acessoATelaDoJogo().musicClose();
            Desenho.acessoATelaDoJogo().music("parabains.wav");
            Desenho.acessoATelaDoJogo().gameOver();
        } else {
            bg = "telaPerdeu.png";
            Desenho.acessoATelaDoJogo().faseAtual.clear();
            Desenho.acessoATelaDoJogo().musicClose();
            Desenho.acessoATelaDoJogo().music("ohNo.wav");
            Desenho.acessoATelaDoJogo().gameOver();
        }

    }

    private static void seletorFase(int faseCounter) {
        switch (faseCounter) {
            case 1 -> primeiraFase();
            case 2 -> segundaFase();
            case 3 -> terceiraFase();
            case 4 -> quartaFase();
            case 5 -> quintaFase();
        }
    }
    

    public static ArrayList<Personagem> primeiraFase() {
        ArrayList<Personagem> fase = new ArrayList<>();


        Coletavel berry1 = new Coletavel("uva.png");
        berry1.setPosicao(0, 0);
        fase.add(berry1);

        Coletavel berry2 = new Coletavel("limao.png");
        berry2.setPosicao(0, 10);
        fase.add(berry2);

        Coletavel berry3 = new Coletavel("cereja.png");
        berry3.setPosicao(10, 10);
        fase.add(berry3);

        Coletavel berry4 = new Coletavel("morango.png");
        berry4.setPosicao(10, 0);
        fase.add(berry4);

        skoot.setPosicao(7, 7);
        fase.add(skoot);

        return fase;

    }

    public void telaInicial() {
        bg = "telaMenu.png";
    }

    public static ArrayList<Personagem> segundaFase() {
        ArrayList<Personagem> fase = new ArrayList<>();

        Seta seta1 = new Seta("setaUp.png");
        seta1.setPosicao(3, 7);
        seta1.bDirecao = "Up";
        fase.add(seta1);

        BlocoVerdeMovel blocoVerde1 = new BlocoVerdeMovel("blocoVerdeMovel.png");
        blocoVerde1.setPosicao(faseCounter, faseCounter);
        fase.add(blocoVerde1);

        BlocoVermelhoMovel blocoVerde2 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde2.setPosicao(faseCounter + 1, faseCounter + 1);
        fase.add(blocoVerde2);

        BlocoVermelhoMovel blocoVerde3 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde3.setPosicao(faseCounter + 2, faseCounter + 2);
        fase.add(blocoVerde3);

        BlocoVermelhoMovel blocoVerde4 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde4.setPosicao(faseCounter + 3, faseCounter + 3);
        fase.add(blocoVerde4);

        BlocoVermelhoMovel blocoVerde5 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde5.setPosicao(faseCounter + 4, faseCounter + 4);
        fase.add(blocoVerde5);

        BlocoVermelhoMovel blocoVerde6 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde6.setPosicao(faseCounter + 5, faseCounter + 5);
        fase.add(blocoVerde6);

        BlocoVermelhoMovel blocoVerde7 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde7.setPosicao(faseCounter + 6, faseCounter + 6);
        fase.add(blocoVerde7);

        BlocoVermelhoMovel blocoVerde8 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde8.setPosicao(faseCounter + 7, faseCounter + 7);
        fase.add(blocoVerde8);

        BlocoVermelho blocoVerde9 = new BlocoVermelho("blocoVermelho.png");
        blocoVerde9.setPosicao(faseCounter + 8, faseCounter + 8);
        fase.add(blocoVerde9);

        RoboVerde bh1 = new RoboVerde("roboVerdeD.png");
        bh1.setPosicao(5, 8);
        fase.add(bh1);

        Coletavel berry1 = new Coletavel("morango.png");
        berry1.setPosicao(0, 0);
        fase.add(berry1);

        Coletavel berry2 = new Coletavel("morango.png");
        berry2.setPosicao(4, 12);
        fase.add(berry2);

        Coletavel berry3 = new Coletavel("morango.png");
        berry3.setPosicao(12, 12);
        fase.add(berry3);

        Skoot skoot = new Skoot("skoot_atualizado.png");
        skoot.setPosicao(0, 7);
        fase.add(skoot);

        return fase;
    }

    public static ArrayList<Personagem> terceiraFase() {

        ArrayList<Personagem> fase = new ArrayList<>();

        Seta seta1 = new Seta("setaUp.png");
        seta1.setPosicao(3, 7);
        seta1.bDirecao = "Up";
        fase.add(seta1);

        BlocoVerdeMovel blocoVerde1 = new BlocoVerdeMovel("blocoVerdeMovel.png");
        blocoVerde1.setPosicao(faseCounter, faseCounter);
        fase.add(blocoVerde1);

        BlocoVermelhoMovel blocoVerde2 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde2.setPosicao(faseCounter + 1, faseCounter + 1);
        fase.add(blocoVerde2);

        BlocoVermelhoMovel blocoVerde3 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde3.setPosicao(faseCounter + 2, faseCounter + 2);
        fase.add(blocoVerde3);

        BlocoVermelhoMovel blocoVerde4 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde4.setPosicao(faseCounter + 3, faseCounter + 3);
        fase.add(blocoVerde4);

        BlocoVermelhoMovel blocoVerde5 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde5.setPosicao(faseCounter + 4, faseCounter + 4);
        fase.add(blocoVerde5);

        BlocoVermelhoMovel blocoVerde6 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde6.setPosicao(faseCounter + 5, faseCounter + 5);
        fase.add(blocoVerde6);

        BlocoVermelhoMovel blocoVerde7 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde7.setPosicao(faseCounter + 6, faseCounter + 6);
        fase.add(blocoVerde7);

        BlocoVermelhoMovel blocoVerde8 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde8.setPosicao(faseCounter + 7, faseCounter + 7);
        fase.add(blocoVerde8);

        BlocoVermelho blocoVerde9 = new BlocoVermelho("blocoVermelho.png");
        blocoVerde9.setPosicao(faseCounter + 8, faseCounter + 8);
        fase.add(blocoVerde9);

        RoboVerde bh1 = new RoboVerde("roboVerdeD.png");
        bh1.setPosicao(5, 8);
        fase.add(bh1);

        Coletavel berry1 = new Coletavel("morango.png");
        berry1.setPosicao(0, 0);
        fase.add(berry1);

        Coletavel berry2 = new Coletavel("morango.png");
        berry2.setPosicao(4, 12);
        fase.add(berry2);

        Coletavel berry3 = new Coletavel("morango.png");
        berry3.setPosicao(12, 12);
        fase.add(berry3);

        Skoot skoot = new Skoot("skoot_atualizado.png");
        skoot.setPosicao(0, 7);
        fase.add(skoot);

        return fase;
    }

    public static ArrayList<Personagem> quartaFase() {
        ArrayList<Personagem> fase = new ArrayList<>();

        Seta seta1 = new Seta("setaUp.png");
        seta1.setPosicao(3, 7);
        seta1.bDirecao = "Up";
        fase.add(seta1);

        BlocoVerdeMovel blocoVerde1 = new BlocoVerdeMovel("blocoVerdeMovel.png");
        blocoVerde1.setPosicao(faseCounter, faseCounter);
        fase.add(blocoVerde1);

        BlocoVermelhoMovel blocoVerde2 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde2.setPosicao(faseCounter + 1, faseCounter + 1);
        fase.add(blocoVerde2);

        BlocoVermelhoMovel blocoVerde3 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde3.setPosicao(faseCounter + 2, faseCounter + 2);
        fase.add(blocoVerde3);

        BlocoVermelhoMovel blocoVerde4 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde4.setPosicao(faseCounter + 3, faseCounter + 3);
        fase.add(blocoVerde4);

        BlocoVermelhoMovel blocoVerde5 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde5.setPosicao(faseCounter + 4, faseCounter + 4);
        fase.add(blocoVerde5);

        BlocoVermelhoMovel blocoVerde6 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde6.setPosicao(faseCounter + 5, faseCounter + 5);
        fase.add(blocoVerde6);

        BlocoVermelhoMovel blocoVerde7 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde7.setPosicao(faseCounter + 6, faseCounter + 6);
        fase.add(blocoVerde7);

        BlocoVermelhoMovel blocoVerde8 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde8.setPosicao(faseCounter + 7, faseCounter + 7);
        fase.add(blocoVerde8);

        BlocoVermelho blocoVerde9 = new BlocoVermelho("blocoVermelho.png");
        blocoVerde9.setPosicao(faseCounter + 8, faseCounter + 8);
        fase.add(blocoVerde9);

        RoboVerde bh1 = new RoboVerde("roboVerdeD.png");
        bh1.setPosicao(5, 8);
        fase.add(bh1);

        Coletavel berry1 = new Coletavel("morango.png");
        berry1.setPosicao(0, 0);
        fase.add(berry1);

        Coletavel berry2 = new Coletavel("morango.png");
        berry2.setPosicao(4, 12);
        fase.add(berry2);

        Coletavel berry3 = new Coletavel("morango.png");
        berry3.setPosicao(12, 12);
        fase.add(berry3);

        Skoot skoot = new Skoot("skoot_atualizado.png");
        skoot.setPosicao(0, 7);
        fase.add(skoot);

        return fase;
    }

    public static ArrayList<Personagem> quintaFase() {
        ArrayList<Personagem> fase = new ArrayList<>();

        Seta seta1 = new Seta("setaUp.png");
        seta1.setPosicao(3, 7);
        seta1.bDirecao = "Up";
        fase.add(seta1);

        BlocoVerdeMovel blocoVerde1 = new BlocoVerdeMovel("blocoVerdeMovel.png");
        blocoVerde1.setPosicao(faseCounter, faseCounter);
        fase.add(blocoVerde1);

        BlocoVermelhoMovel blocoVerde2 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde2.setPosicao(faseCounter + 1, faseCounter + 1);
        fase.add(blocoVerde2);

        BlocoVermelhoMovel blocoVerde3 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde3.setPosicao(faseCounter + 2, faseCounter + 2);
        fase.add(blocoVerde3);

        BlocoVermelhoMovel blocoVerde4 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde4.setPosicao(faseCounter + 3, faseCounter + 3);
        fase.add(blocoVerde4);

        BlocoVermelhoMovel blocoVerde5 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde5.setPosicao(faseCounter + 4, faseCounter + 4);
        fase.add(blocoVerde5);

        BlocoVermelhoMovel blocoVerde6 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde6.setPosicao(faseCounter + 5, faseCounter + 5);
        fase.add(blocoVerde6);

        BlocoVermelhoMovel blocoVerde7 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde7.setPosicao(faseCounter + 6, faseCounter + 6);
        fase.add(blocoVerde7);

        BlocoVermelhoMovel blocoVerde8 = new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        blocoVerde8.setPosicao(faseCounter + 7, faseCounter + 7);
        fase.add(blocoVerde8);

        BlocoVermelho blocoVerde9 = new BlocoVermelho("blocoVermelho.png");
        blocoVerde9.setPosicao(faseCounter + 8, faseCounter + 8);
        fase.add(blocoVerde9);

        RoboVerde bh1 = new RoboVerde("roboVerdeD.png");
        bh1.setPosicao(5, 8);
        fase.add(bh1);

        Coletavel berry1 = new Coletavel("morango.png");
        berry1.setPosicao(0, 0);
        fase.add(berry1);

        Coletavel berry2 = new Coletavel("morango.png");
        berry2.setPosicao(4, 12);
        fase.add(berry2);

        Coletavel berry3 = new Coletavel("morango.png");
        berry3.setPosicao(12, 12);
        fase.add(berry3);

        Skoot skoot = new Skoot("skoot_atualizado.png");
        skoot.setPosicao(0, 7);
        fase.add(skoot);

        return fase;
    }

}
