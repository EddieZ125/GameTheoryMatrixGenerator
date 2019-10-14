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
    
    public static void ecuaciones(int m[][]){
        
        System.out.println("\ns.a.");
        System.out.println("Ecuaciones: ");
        
        for(int i = 0; i < m[0].length; i++){
            System.out.print("Ecuación para estrategia " +(i+1) + ": \t");
            
            for(int j = 0; j < m.length; j++){
                if(j == 0){
                    System.out.print(m[j][i]+"*X"+(j+1));   
                }else{
                    System.out.print("+"+m[j][i]+"*X"+(j+1));
                }
                
            }
            
            System.out.print("\t>= v");
            System.out.println("");
            
        }
        
        
        System.out.println("X1 + X2 + X3 + X4 = 1");
        System.out.println("X1 >= 0 \t X2 >= 0 \t X3 >= 0 \t X4 >= 0 \t v irrestricta");
        
    }
    
    public static int[][] refactorizar_matriz(int m[][], int x, int y, int tipo){
        
        int k=0;
        int aux[][] = new int[y][x];
        
        if(tipo == 0){
            
            for (int i = 0; i < m[0].length; i++) {
                if(m[0][i] != 0){
                    for (int j = 0; j < m.length; j++) {
                        aux[j][k] = m[j][i];
                    }
                    k++;
                }
            }
            return aux;
        }else{
            
            
        }
        return m;
    }
    public static void dominadas(int m[][]){
        
        int y, x;
        y = m.length;
        x = m[0].length;
        
        int aux[][] = new int[y][x];
        int auxB[][] = new int[y][x];
        
        aux = igualar(m);
        auxB = igualar(m);
        
        boolean flag = true; // false = filas, true = columnas
        boolean seguir = false;
        
        do{
            
            seguir = false;
            
            if(flag){ // Columnas
                System.out.println("\nDominadas de Columnas.");
                for (int i = 0; i < m[0].length; i++) {
                    for (int j = 0; j < m[0].length; j++) {
                        auxB = igualar(aux);
                        for (int k = 0; k < m.length; k++) {
                            auxB[k][j] = 0;
                            if(m[k][i] > m[k][j] || i==j){
                                break;
                            }else if((k+1) == m.length){
                                seguir = true;
                                flag = false;
                                System.out.println("Columna: "+(i+1)+" Domina a Columna: "+(j+1));
                                aux = igualar(auxB);
                            }
                        } 
                    }
                    
                }

                for(int i=0; i<m[0].length; i++){
                    if(aux[0][i] == 0){
                        x--;
                    }
                } 
                
                System.out.println("\nColumnas que quedan: "+x);
                
            }else{ // Filas
                
                System.out.println("\nDominadas de Filas.");
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m.length; j++) {
                        auxB = igualar(aux);
                        for (int k = 0; k < m[0].length; k++) {
                            auxB[j][k] = 0;
                            if(m[i][k] < m[j][k] || i==j){
                                break;
                            }else if(k == m[0].length){
                                seguir = true;
                                flag = true;
                                System.out.println("Fila: "+(i+1)+" Dominada por Fila: "+(j+1));
                                aux = igualar(auxB);
                            }
                        } 
                    }
                    
                }

                for(int i = 0; i<m.length; i++){
                    if(aux[i][0] == 0){
                        y--;
                    }
                }
                
                System.out.println("\nFilas que quedan: "+y);
            }
            
            System.out.println("Matriz resultante");
            ver_matriz(aux);
            System.out.println("\nMatriz factorizada");
            m = new int[aux.length][aux[0].length];
            m = igualar(refactorizar_matriz(aux, x, aux.length, 0));
            aux = new int[aux.length][aux[0].length];
            aux = igualar(m);
            ver_matriz(m);
            
        }while(seguir);
        
        ecuaciones(m);
    }
    
    public static int [][] igualar(int m[][]){
        
        int aux[][] = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                aux[i][j] = m[i][j];
            }
        }
        return aux;
    }
    
    public static void ver_matriz(int m[][]){
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args){
        String str = "123456";
        Permutador pe = new Permutador(str,str.length());
        List<String> jugadas;
        List<Equivalente> equivalentes;
        equivalentes = new ArrayList<>();
        int[] estrategiasA = {1,2,3,4,5};
        jugadas = pe.getJugadas();
        int[][] matriz;
        int[] valores;
        valores = new int[5];
        matriz = new int[estrategiasA.length][jugadas.size()];
        int a1, a2;
        boolean estaEnEquivalente;
        boolean noEsCero;
        
        
        for(int i = 0; i < estrategiasA.length; i++ ) {
            for(int j = 0; j < jugadas.size(); j++){
                a1 = 0;
                a2 = 0;
                for(int k = 0; k < 6; k++){
                    
                    if(Integer.toString(estrategiasA[i]).equals(jugadas.get(j).charAt(k)+"") 
                            || Integer.toString(estrategiasA[i]+1).equals(jugadas.get(j).charAt(k)+"")){
                        
                        if(a1==0){
                            a1 = 1;
                        }else{
                            a2 = k + 1;
                        }
                    }
                } 
                
                matriz[i][j] = a2; // aqui asigno valor a la casilla basicamente es 4 menos el numero de pasos totales hasta destruir el barco y como es para el jugador A el valor es negativo
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

                temporal.setValores(matriz[0][i],matriz[1][i],matriz[2][i],matriz[3][i],matriz[4][i]);


                for(int j = i+1; j < jugadas.size(); j++){
                    if(matriz[0][i] == matriz[0][j] 
                            && matriz[1][i] == matriz[1][j]
                            && matriz[2][i] == matriz[2][j]
                            && matriz[3][i] == matriz[3][j]
                            && matriz[4][i] == matriz[4][j]){
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
        System.out.print("\n\t");
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
        System.out.print("E:\t");
        for(int i = 0; i < equivalentes.size(); i++){
            valores = equivalentes.get(i).getValores();
            if(valores[4] >= 0){
                System.out.print(" ");
            }
            System.out.print(valores[4] + "\t");
        }
        

        
        System.out.println("\n\nEstrategias Dominadas");
        
        int m[][] = new int[valores.length][equivalentes.size()];
        int v[] = new int[valores.length];
        
        for (int i = 0; i < equivalentes.size(); i++) {
            v = equivalentes.get(i).getValores();
            for (int j = 0; j < valores.length; j++) {
                m[j][i] = v[j];
            }
        }
        
        dominadas(m);
                
        /*
        System.out.println("\ns.a.");
        System.out.println("Ecuaciones: ");
        
        for(int i = 0; i < equivalentes.size(); i++){
            valores = equivalentes.get(i).getValores();
            System.out.print("Ecuación para estrategia " +(i+1) + ": \t");
            noEsCero = false;
            for(int j = 0; j < 4; j++){
                if(valores[j]!=0){
                    
                    if(valores[j]>0 && noEsCero){
                        System.out.print("+");
                    }
                    if(valores[j]<0 && noEsCero){
                        System.out.print("");
                    }
                    noEsCero = true;
                    System.out.print(valores[j] + "*X" + (j+1));
                }
            }
            if(noEsCero){
                System.out.print("\t>= v");
                System.out.println("");
            }
        }
        
        
        System.out.println("X1 + X2 + X3 + X4 = 1");
        System.out.println("X1 >= 0 \t X2 >= 0 \t X3 >= 0 \t X4 >= 0 \t v irrestricta");
        */
        
        
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
