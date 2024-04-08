/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maxpq;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        MAXpQ cola = new MAXpQ(7);
        cola.isEmpty();
        cola.insert("p");
        cola.print();
        cola.insert("q");
        cola.print();
        cola.insert("e");
        cola.print();
        cola.delMax();
        cola.print();
        cola.insert("x");
        cola.print();
        cola.insert("a");
        cola.print();
        cola.insert("m");
        cola.print();
        cola.delMax();
        cola.print();
        cola.insert("p");
        cola.print();
        cola.insert("l");
        cola.print();
        cola.insert("e");
        cola.print();
        cola.delMax();
        cola.print();
        
        System.out.println("--------------");
        Integer enteros[] = {1,2,3,4,5,6,7,8, 9, 10};
        MAXpQ cola2 = new MAXpQ(enteros);
        cola2.print();
        System.out.println("-------------");
        
        MAXpQ cola3 = new MAXpQ(2);
        cola3.insert("a");
        cola3.insert("b");
        cola3.insert("c");
    }
}
