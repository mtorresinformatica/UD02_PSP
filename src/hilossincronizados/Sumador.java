/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilossincronizados;

/**
 *
 * @author DAM
 */
public class Sumador extends Thread {

    private Contador c;

    public Sumador(String name, Contador c) {
        super(name);
        this.c = c;

    }

    @Override
    public void run() {
        // Ejecutar 300 veces con espera entre 50ms y 150ms
        for (int i = 0; i < 300; i++) {
            try {
                c.incrementa();
                Thread.sleep((long) (Math.random() * 100 + 50));
            } catch (InterruptedException ex) {
                // Nothing
            }
        }
    }
}
