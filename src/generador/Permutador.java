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
public final class Permutador {

    
    private final List<String> jugadas;
    public Permutador(String str, int size) 
    { 
      jugadas = new ArrayList<>();
      permutar(str,0,size-1);
    } 

    private void permutar(String str, int l, int r) {
        if (l == r){
            jugadas.add(str);
        }
        
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permutar(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
  
    private String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }

    public List<String> getJugadas() {
        return jugadas;
    }
    
    
}
