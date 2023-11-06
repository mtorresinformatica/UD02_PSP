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
public class Restador implements Runnable {

    private Contador c;
    private String name;

    public Restador(String name, Contador c) {
        // Restador doesn't extend Thread, so it cannot call the Thread constructor
        // super(name);
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        // Ejecutar 300 veces con espera entre 50ms y 150ms
        for (int i = 0; i < 300; i++) {
            try {
                c.decrementa();
                System.out.println(Thread.currentThread().getName() + " " + c.valor());
                Thread.sleep((long) (Math.random() * 100 + 50));
            } catch (InterruptedException ex) {
                // Nothing
            }
        }
    }
}
