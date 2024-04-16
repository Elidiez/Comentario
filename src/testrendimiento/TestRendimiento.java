/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package testrendimiento; // Declaración del paquete

import java.util.LinkedList; // Importación de la clase LinkedList
import java.util.ArrayList; // Importación de la clase ArrayList
import java.util.Random; // Importación de la clase Random

/**
 * Clase para probar el rendimiento entre LinkedList y ArrayList en Java.
 * 
 * @author Eli
 */
public class TestRendimiento
{
    private final LinkedList<Byte> listaEnlazada; // Declaración de una lista enlazada
    private final ArrayList<Byte> lista; // Declaración de un ArrayList

    /**
     * Constructor para objetos de la clase TestRendimiento.
     */
    public TestRendimiento()
    {
        listaEnlazada = new LinkedList<>(); // Inicialización de la lista enlazada
        lista = new ArrayList<>(); // Inicialización del ArrayList
    }

    /**
     * Método para cargar elementos en ambas listas.
     */
    public void cargar(){
        long inicio = System.nanoTime(); 
        for (int i= 0; i< 30000;i++){ // Bucle para cargar elementos en la lista enlazada
            listaEnlazada.addLast((byte)i); // Agrega el elemento al final de la lista enlazada
        }
        long fin = System.nanoTime(); 
        System.out.println("Carga de ListaEnlada  " + (fin-inicio)); // Muestra el tiempo de carga de la lista enlazada
        inicio = System.nanoTime(); 
        for (int i= 0; i< 30000;i++){ // Bucle para cargar elementos en el ArrayList
            lista.add((byte) i); 
        }
        fin = System.nanoTime(); 
        System.out.println("Carga de ArrayList  " + (fin-inicio)); // Muestra el tiempo de carga del ArrayList
    }

    /**
     * Método para eliminar el primer elemento de ambas listas.
     */
    public void eliminarPrimeros(){
        long inicio = System.nanoTime(); 
        listaEnlazada.removeFirst(); 
        long fin = System.nanoTime();
        System.out.println("Quitar primero de ListaEnlada  " + (fin-inicio)); // Muestra el tiempo para eliminar el primer elemento de la lista enlazada
        inicio = System.nanoTime();
        lista.remove(0); 
        fin = System.nanoTime(); 
        System.out.println("Quitar primero de ArrayList  " + (fin-inicio)); // Muestra el tiempo para eliminar el primer elemento del ArrayList
    }

    /**
     * Método para eliminar el último elemento de ambas listas.
     */
    public void eliminarUltimos(){
        int ultimo = listaEnlazada.size()-1; // Índice del último elemento de la lista enlazada
        long inicio = System.nanoTime(); 
        listaEnlazada.removeLast(); 
        long fin = System.nanoTime(); 
        System.out.println("Quitar ultimo de ListaEnlada  " + (fin-inicio)); // Muestra el tiempo para eliminar el último elemento de la lista enlazada
        inicio = System.nanoTime(); 
        lista.remove(ultimo); 
        fin = System.nanoTime(); 
        System.out.println("Quitar ultimo de ArrayList  " + (fin-inicio)); // Muestra el tiempo para eliminar el último elemento del ArrayList
    }

    /**
     * Método para eliminar un elemento en una posición intermedia de ambas listas.
     * 
     * @param posicion La posición del elemento a eliminar.
     */
    public void eliminarIntermedios(int posicion){
        if (listaEnlazada.size()>posicion) { // Verifica si la posición es válida en la lista enlazada
            long inicio = System.nanoTime(); 
            listaEnlazada.remove((Integer) posicion); // Elimina el elemento en la posición dada de la lista enlazada
            long fin = System.nanoTime(); 
            System.out.println("Quitar " + posicion + " de ListaEnlada  " + (fin-inicio)); // Muestra el tiempo para eliminar el elemento en la posición dada de la lista enlazada
            inicio = System.nanoTime();
            lista.remove(posicion); // Elimina el elemento en la posición dada del ArrayList
            fin = System.nanoTime();
            System.out.println("Quitar " + posicion + " de ArrayList  " + (fin-inicio)); // Muestra el tiempo para eliminar el elemento en la posición dada del ArrayList
        }
    }

    /**
     * Método principal que prueba el rendimiento de las listas.
     * 
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args){
        TestRendimiento test = new TestRendimiento(); // Crea una instancia de TestRendimiento
        test.cargar(); // Carga elementos en ambas listas
        test.eliminarPrimeros(); 
        test.eliminarUltimos(); 
        Random r = new Random(); 
        int posicion =  0; // Variable para almacenar la posición a eliminar
        int contador = 0; // Contador de iteraciones
        while(contador<5){ 
            posicion= r.nextInt(0,15000); // Genera una posición aleatoria entre 0 y 15000
            test.eliminarIntermedios(posicion); // Elimina un elemento en la posición aleatoria de ambas listas
            contador++; // Incrementa el contador
        }
        test.lista.removeAll(test.listaEnlazada); // Elimina todos los elementos de lista que están en listaEnlazada
    }
}
