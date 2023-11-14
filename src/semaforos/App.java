/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author manueltorres
 */
public class App {
    public static void main( String[] args ) throws InterruptedException {
        Semaphore sema = new Semaphore(2);

        // Mejor lanzarlas con un Executer
        Hilo h1 = new Hilo(sema);
        Hilo h2 = new Hilo(sema);
        Hilo h3 = new Hilo(sema);

        h1.start();
        h2.start();
        h3.start();

        h3.join();
        System.out.println("h3 terminado" );
        h1.join();
        System.out.println("h1 terminado" );
        h2.join();
        System.out.println("h2 terminado" );

    }
}