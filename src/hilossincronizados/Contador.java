/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilossincronizados;

/**
 *
 * @author DAM
 */
public class Contador {

    private int c = 0;
    boolean ahoraSumador = true;

    public Contador(int c) {
        this.c = c;
        ahoraSumador = true;
    }

    public synchronized void incrementa() {
        while (!ahoraSumador) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }

        // El hilo hace su tarea
        c++;
        System.out.println(Thread.currentThread().getName() + " " +  valor());
        
        // Cambia el estado y avisa al resto de hilos por si alguno puede seguir
        ahoraSumador = false;
        notifyAll();

    }

    public synchronized void decrementa() {
        while (ahoraSumador) {
            try {
                wait();
            } catch (InterruptedException ex) { }
        }

        // El hilo hace su tarea
        c--;
        System.out.println(Thread.currentThread().getName() + " " +  valor());
        
        // Cambia el estado y avisa al resto de hilos por si alguno puede seguir
        ahoraSumador = true;
        notifyAll();
    }

    public int valor() {
        return c;
    }
}