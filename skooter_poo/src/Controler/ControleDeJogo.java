package Controler;

import Auxiliar.Desenho;
import Modelo.Personagem;
import Modelo.Skoot;
import auxiliar.Posicao;

import java.util.ArrayList;
import java.util.Objects;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e) {
        for (Personagem personagem : e) {
            personagem.autoDesenho();
        }
    }

    public void processaTudo(ArrayList<Personagem> umaFase) {
        Skoot skoot = (Skoot) umaFase.get(umaFase.size() - 1);
        Personagem pIesimoPersonagem;
        for (int i = 0; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);

            //Mesma posicao
            if (skoot.getPosicao().igual(pIesimoPersonagem.getPosicao())) {

                //Morte do Skoot
                if (pIesimoPersonagem.isbMortal()) {
                    skoot.vidas--;
                    if (skoot.vidas == 0) {
                        Fases.faseCounter = 4;
                        Desenho.acessoATelaDoJogo().proximaFase();
                    }
                    Fases.reiniciaFase();
                }

                //Movimento da seta
                if (pIesimoPersonagem.isbTransponivel())
                    if (!pIesimoPersonagem.isbColetavel())
                        if (!("Down".equals(pIesimoPersonagem.isbDirecao()) && "Up".equals(skoot.isbDirecao())
                                || "Up".equals(pIesimoPersonagem.isbDirecao()) && "Down".equals(skoot.isbDirecao())
                                || "Right".equals(pIesimoPersonagem.isbDirecao()) && "Left".equals(skoot.isbDirecao())
                                || "Left".equals(pIesimoPersonagem.isbDirecao()) && "Right".equals(skoot.isbDirecao()))) {
                            skoot.movel = true;
                            switch (pIesimoPersonagem.isbDirecao()) {
                                case "Up" -> skoot.moveUp();
                                case "Down" -> skoot.moveDown();
                                case "Right" -> skoot.moveRight();
                                case "Left" -> skoot.moveLeft();
                            }
                        } else {
                            skoot.movel = false;
                        }

            }

            //Blocos
            if ((skoot.getPosicao().getColuna() == pIesimoPersonagem.getPosicao().getColuna() + 1) && (skoot.getPosicao().getLinha() == pIesimoPersonagem.getPosicao().getLinha()) ||
                    (skoot.getPosicao().getColuna() == pIesimoPersonagem.getPosicao().getColuna() + -1) && (skoot.getPosicao().getLinha() == pIesimoPersonagem.getPosicao().getLinha()) ||
                    (skoot.getPosicao().getLinha() == pIesimoPersonagem.getPosicao().getLinha() + 1) && (skoot.getPosicao().getColuna() == pIesimoPersonagem.getPosicao().getColuna()) ||
                    (skoot.getPosicao().getLinha() == pIesimoPersonagem.getPosicao().getLinha() - 1) && (skoot.getPosicao().getColuna() == pIesimoPersonagem.getPosicao().getColuna())) {

                //Destrói bloco verde
                if (skoot.isbDestruidor() && pIesimoPersonagem.isbDestrutivo()) {
                    umaFase.remove(pIesimoPersonagem);
                }

                //Move bloco não fixo
                if (!pIesimoPersonagem.isbFixo()) {
                    if (pIesimoPersonagem.getPosicao().getLinha() == skoot.getPosicao().getLinha()) {
                        if (pIesimoPersonagem.getPosicao().getColuna() == skoot.getPosicao().getColuna() + 1) {
                            if (Objects.equals(skoot.bDirecao, "Right")) {
                                pIesimoPersonagem.setPosicao(pIesimoPersonagem.getPosicao().getLinha(), pIesimoPersonagem.getPosicao().getColuna() + 1);
                                skoot.moveRight();
                            }
                        } else {
                            if (Objects.equals(skoot.bDirecao, "Left")) {
                                pIesimoPersonagem.setPosicao(pIesimoPersonagem.getPosicao().getLinha(), pIesimoPersonagem.getPosicao().getColuna() - 1);
                                skoot.moveLeft();
                            }
                        }

                    }
                    if (pIesimoPersonagem.getPosicao().getColuna() == skoot.getPosicao().getColuna()) {
                        if (pIesimoPersonagem.getPosicao().getLinha() == skoot.getPosicao().getLinha() - 1) {
                            if (Objects.equals(skoot.bDirecao, "Up")) {
                                pIesimoPersonagem.setPosicao(pIesimoPersonagem.getPosicao().getLinha() - 1, pIesimoPersonagem.getPosicao().getColuna());
                                skoot.moveUp();
                            }
                        } else {
                            if (Objects.equals(skoot.bDirecao, "Down")) {
                                pIesimoPersonagem.setPosicao(pIesimoPersonagem.getPosicao().getLinha() + 1, pIesimoPersonagem.getPosicao().getColuna());
                                skoot.moveDown();
                            }
                        }

                    }
                }
            }
            //Coleta os berries/coletáveis
            if (pIesimoPersonagem.isbColetavel()) {
                if (skoot.getPosicao().igual(pIesimoPersonagem.getPosicao())) {
                    umaFase.remove(pIesimoPersonagem);
                    skoot.itens++;
                    if (skoot.itens == 4) {
                        Desenho.acessoATelaDoJogo().proximaFase();
                    }
                }
            }
        }
    }

    /*Retorna true se a posicao p é válida para Skoot com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p) {
        Personagem pIesimoPersonagem;
        for (int i = 0; i < umaFase.size() - 1; i++) {
            pIesimoPersonagem = umaFase.get(i);
            if (!pIesimoPersonagem.isbTransponivel()) {
                if (pIesimoPersonagem.getPosicao().igual(p)) {
                    return false;
                }
            }
        }
        return true;
    }
}
