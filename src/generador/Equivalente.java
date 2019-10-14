/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thestrength
 */
public class Equivalente {

    private List<String> estrategia;
    private int[] valores;

    public Equivalente() {
        estrategia = new ArrayList<>();
        valores = new int[5];
    }

    public List<String> getEstrategia() {
        return estrategia;
    }


    public int[] getValores() {
        return valores;
    }

    public void setValores(int a, int b, int c, int d, int e) {
        this.valores[0] = a;
        this.valores[1] = b;
        this.valores[2] = c;
        this.valores[3] = d;
        this.valores[4] = e;
    }
    
    public void addEstrategia(String str){
        if(!estrategia.contains(str)){
            estrategia.add(str);
        }
    }
    
    public boolean valorIgual(int[] temp){
        return this.valores[0] == temp[0] 
                && this.valores[1] == temp[1] 
                && this.valores[2] == temp[2] 
                && this.valores[3] == temp[3]
                && this.valores[4] == temp[4];
    }
    
}
