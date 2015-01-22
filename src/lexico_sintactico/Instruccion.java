/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexico_sintactico;

/**
 *
 * @author pc
 */
public class Instruccion {
    
    String instruccion;//guarda el nombre de la instruccion: linea, circulo, rectangulo, color
    int[] numeros;//guarda los numeros correspondientes de cada instruccion

    public Instruccion() {
    }

    public Instruccion(String instruccion, int[] numeros) {
        this.instruccion = instruccion;
        this.numeros = numeros;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public int[] getNumeros() {
        return numeros;
    }
}
