/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.maxpq;

/**
 *
 * @author ACER
 */
public class MAXpQ<Key extends Comparable<Key>> {

    private Key queue[];
    private int size;

    public MAXpQ(int max) {
        queue = (Key[]) new Comparable[max + 1]; //max + 1 porque el espacio 0 no se usará
        size = 0;
    }

    public MAXpQ(Key[] a) {
        size = 0; // toma el tamaño del arreglo   
        queue = (Key[]) new Comparable[a.length + 1]; // + 1 porque el espacio 0 no se usará
        for (int i = 0; i < a.length; i++) { //agrega todos los elementos, de 0
            if (a[i] != null) { 
                this.insert(a[i]);
            } else {
                break;
            }
        }
    }

    public void insert(Key v) {
        if (size != queue.length - 1) {
            size++;
            queue[size] = v;
            swim(size);
        } else {
            System.out.println("Elimine un elemento para agregar otro.");
        }
    }

    public void swim(int ind) {
        if (ind != 1) {  //Esto porque si ind == 0, habra error en less
            int index = ind / 2; //se calcula el indice del padre
            if (less(queue[index], queue[ind])) { //si el padre es menor que el hijo, hace el intercambio
                exch(ind, index);
                swim(index); //lo vuelve a llamar, para seguir revisando con los siguientes padres
            }
        }
    }

    public void sink(int k) {//recibe el indice del que quiere revisar sus hijos
        int index = k * 2;  //almacena el valor del primer hijo en index
        if (index <= size) { //revisa que si exista ese indice
            if (less(queue[k], queue[index])) { //si el padre es menor los intercambia y vuelve a llamar sink.
                exch(index, k);
                sink(index);
            }
            if (k * 2 + 1 <= size) {  //si no se cumple con el hijo anterior, mira que el siguiente hijo exista 
                if (less(queue[k], queue[index + 1])) {
                    exch(index + 1, k);
                    sink(index + 1);
                }
            }
        }
    }

    public void print() {
        System.out.println("");
        for (Key key : queue) {
            System.out.println("-" + key);
        }
        System.out.println("");
    }

    public void exch(int index1, int index2) {
        Key temp = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = temp;
    }

    public boolean less(Key v1, Key v2) {
        return v1.compareTo(v2) < 0;
    }

    public Key max() {
        return queue[1];
    }

    public Key delMax() {
        Key temp = queue[1];
        exch(1, size); //se hace el intercambio del max por el último
        queue[size] = null; // se elimina el max, ahora ultimo
        size--;
        sink(1); //como el que estaba de último paso a ser primero, hay que bajarlo a la posicion correspondiente
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int size() {
        return size;
    }

}
