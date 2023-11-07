/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilossincronizados;


/**
 *
 * @author DAM
 */
public class MemoriaCompartida {

    public static void main(String[] args) throws InterruptedException {
        // Inicializar el objeto Contador
        Contador c = new Contador(100);

        // Crear y lanzar 2 hilos (Sumador + Restador)
        Sumador s1 = new Sumador("Sumador1", c);
        Restador r1 = new Restador("Restador1", c);
        Thread h1 = new Thread(r1);

        s1.start();
        h1.start();

        // El hilo principal espera a que los hilos s1 y r1 terminen
        s1.join();
        h1.join();

        System.out.println("El valor final de c es " + c.valor());

    }
}
