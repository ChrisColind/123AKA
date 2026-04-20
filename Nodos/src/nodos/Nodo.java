/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author Rogelio
 */
// Archivo: Nodo.java
public class Nodo {
    int dato;
    Nodo siguiente;
    
    // Constructor
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
