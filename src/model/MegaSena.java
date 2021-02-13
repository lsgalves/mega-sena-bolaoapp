/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lsgalves
 */
public class MegaSena {

    private List<Integer> numberDrawn;
    private List<Integer> numberWin = new ArrayList<>(6);
    private List<List<Integer>> bolao = new ArrayList<>();
    private List<List<Integer>> quina = new ArrayList<>();
    private List<List<Integer>> quadra = new ArrayList<>();

    public MegaSena(List<Integer> numberDraw) {
        this.numberDrawn = numberDraw;
    }

    public List<Integer> getNumberDrawn() {
        return Collections.unmodifiableList(numberDrawn);
    }

    public List<Integer> getNumberWin() {
        this.setNumberWin();
        return Collections.unmodifiableList(numberWin);
    }

    public void setBolao(List<Integer> bolao) {
        this.bolao.add(bolao);
    }
    
    public boolean haveBolao(){
        return !this.bolao.isEmpty();
    }

    public void setNumberWin() {
        this.bolao.forEach(l -> {
            List<Integer> cont = new ArrayList<>();
            l.forEach(n -> {
                if (this.numberDrawn.contains(n))
                    cont.add(n);

                if (cont.size() == 6)
                    this.numberWin = cont;
            });
        });
    }

    public void getBolao() {
        this.bolao.forEach(System.out::println);
    }

    public static Integer sorteio(List<Integer> numeros) {
        Random rand = new Random();
        int a;
        a = rand.nextInt(60);
        if (numeros.contains(a) || a == 0)
            sorteio(numeros);
        else
            numeros.add(a);

        return numeros.get(numeros.size() - 1);
    }

    public void setQuina() {
        this.quina.clear();
        this.bolao.forEach(l -> {
            List<Integer> cont = new ArrayList<>();
            for(int i = 0; i < l.size(); i++){
                if (this.numberDrawn.contains(l.get(i))) {
                    cont.add(l.get(i));
                }

                if(i == l.size()-1){
                    if (cont.size() == 5){
                        this.quina.add(cont);
                    }
                }
            }
        });
    }

    public void setQuadra() {
        this.quadra.clear();
        this.bolao.forEach(l -> {
            List<Integer> cont = new ArrayList<>();
            for(int i = 0; i < l.size(); i++){
                if (this.numberDrawn.contains(l.get(i))) {
                    cont.add(l.get(i));
                }

                if(i == l.size()-1){
                    if (cont.size() == 4){
                        this.quadra.add(cont);
                    }
                }
            }
        });
    }

    public List<List<Integer>> getQuina() {
        return Collections.unmodifiableList(quina);
    }
    
    public List<List<Integer>> getQuadra() {
        return Collections.unmodifiableList(quadra);
    }

}
