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
public class Generador {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        String str = "12345";
        Permutador pe = new Permutador(str,str.length());
        List<String> jugadas;
        List<Equivalente> equivalentes;
        equivalentes = new ArrayList<>();
        int[] estrategiasA = {1,2,3,4};
        jugadas = pe.getJugadas();
        int[][] matriz;
        int[] valores;
        valores = new int[4];
        matriz = new int[estrategiasA.length][jugadas.size()];
        int a1, a2;
        boolean estaEnEquivalente;
        
        
        for(int i = 0; i < estrategiasA.length; i++ ) {
            for(int j = 0; j < jugadas.size(); j++){
                a1 = 0;
                a2 = 0;
                for(int k = 0; k < 5; k++){
                    
                    if(Integer.toString(estrategiasA[i]).equals(jugadas.get(j).charAt(k)+"") 
                            || Integer.toString(estrategiasA[i]+1).equals(jugadas.get(j).charAt(k)+"")){
                        
                        if(a1==0){
                            a1 = 1;
                        }else{
                            a2 = k + 1;
                        }
                    }
                } 
                
                matriz[i][j] = -(4-a2); // aqui asigno valor a la casilla basicamente es 4 menos el numero de pasos totales hasta destruir el barco y como es para el jugador A el valor es negativo
            }
        }

        for(int i = 0; i < jugadas.size(); i++){
            estaEnEquivalente = false;
            for(int j = 0; j < equivalentes.size(); j++){
                if(equivalentes.get(j).getEstrategia().contains(jugadas.get(i))){
                    estaEnEquivalente = true;
                }
            }
            
            if(!estaEnEquivalente){

                Equivalente temporal = new Equivalente();

                temporal.addEstrategia(jugadas.get(i));

                temporal.setValores(matriz[0][i],matriz[1][i],matriz[2][i],matriz[3][i]);


                for(int j = i+1; j < jugadas.size(); j++){
                    if(matriz[0][i] == matriz[0][j] 
                            && matriz[1][i] == matriz[1][j]
                            && matriz[2][i] == matriz[2][j]
                            && matriz[3][i] == matriz[3][j]){
                        /*System.out.println("------------------------------------------");
                        System.out.println("Valor de i = " + i + "   Valor de j = " + j);
                        System.out.println("Las estrategias " + jugadas.get(i) 
                                + " y " + jugadas.get(j) + " son equivalentes");
                        System.out.println("Valores en i: " + matriz[0][i] + " "
                                + matriz[1][i] + " " + matriz[2][i] + " " + matriz[3][i] + " ");
                        System.out.println("Valores en j: " + matriz[0][j] + " "
                                + matriz[1][j] + " " + matriz[2][j] + " " + matriz[3][j] + " ");*/
                        temporal.addEstrategia(jugadas.get(j));

                    }
                }
                equivalentes.add(temporal);
            }
        }
        
        
        
        int estrategiasTotales = 0;
        
        for(int i = 0; i < equivalentes.size(); i++){
            System.out.println("Estrategia: " + (i+1) + "\t" + equivalentes.get(i).getEstrategia());
            estrategiasTotales += equivalentes.get(i).getEstrategia().size();
            /*System.out.println("Valores:");
            valores = equivalentes.get(i).getValores();
            System.out.println("A: " + valores[0]);
            System.out.println("B: " + valores[1]);
            System.out.println("C: " + valores[2]);
            System.out.println("D: " + valores[3]);*/
        }
        
        System.out.println("Numero de estrategias totales: " + estrategiasTotales);
        System.out.println("Numero de instancias de equivalentes: " + equivalentes.size());
        System.out.print("\t");
        for(int i = 0; i < equivalentes.size(); i++){
            System.out.print(" "+(i+1)+"\t");
        }
        System.out.println("");
        System.out.print("A:\t");
        for(int i = 0; i < equivalentes.size(); i++){
            valores = equivalentes.get(i).getValores();
            if(valores[0] >= 0){
                System.out.print(" ");
            }
            System.out.print(valores[0] + "\t");
        }
        
        System.out.println("");
        System.out.print("B:\t");
        for(int i = 0; i < equivalentes.size(); i++){
            valores = equivalentes.get(i).getValores();
            if(valores[1] >= 0){
                System.out.print(" ");
            }
            System.out.print(valores[1] + "\t");
        }
        System.out.println("");
        System.out.print("C:\t");
        for(int i = 0; i < equivalentes.size(); i++){
            valores = equivalentes.get(i).getValores();
            if(valores[2] >= 0){
                System.out.print(" ");
            }
            System.out.print(valores[2] + "\t");
        }
        System.out.println("");
        System.out.print("D:\t");
        for(int i = 0; i < equivalentes.size(); i++){
            valores = equivalentes.get(i).getValores();
            if(valores[3] >= 0){
                System.out.print(" ");
            }
            System.out.print(valores[3] + "\t");
        }
        System.out.println("");

        /*for(int i = 0; i < jugadas.size(); i++){
            System.out.print(jugadas.get(i));
            if(i < jugadas.size()-1){
                System.out.print("\t");
            }
        }
        
        System.out.println("");
        
        /*for(int i = 0; i < estrategiasA.length; i++){
            for(int j = 0; j < jugadas.size() ; j++){
                if(matriz[i][j]==0){
                    System.out.print(" ");
                          
                }
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println("Numero de estrategias jugador B: " + jugadas.size());*/

    
    }
      

}
