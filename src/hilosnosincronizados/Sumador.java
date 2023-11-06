/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosnosincronizados;

/**
 *
 * @author DAM
 */
public class Sumador extends Thread {

    private Contador c;

    public Sumador(String name, Contador c) {
        // To set the thread name we can access the Thread class constructor
        super(name);
        this.c = c;
    }

    @Override
    public void run() {
        // Ejecutar 300 veces con espera entre 50ms y 150ms
        for (int i = 0; i < 300; i++) {
            try {
                c.incrementa();
                System.out.println(Thread.currentThread().getName() + " " + c.valor());
                Thread.sleep((long) (Math.random() * 100 + 50));
            } catch (InterruptedException ex) {
                // Nothing
            }
        }
    }
}
