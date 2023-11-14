/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lectoresEscritores;

import java.util.Random;

/**
 *
 * @author DAM
 */
public class Escritor extends Thread {
    int veces;
    int escritor;
    RecursoLectorEscritor RW;
    private final Random generator = new Random();

    public Escritor(int escritor, int veces, RecursoLectorEscritor RW) {
        this.escritor=escritor;
        this.veces = veces;
        this.RW = RW;
    }
    @Override
    public void run() {
        for (int i = 0; i<veces; i++) {
            try {
                Thread.sleep(generator.nextInt(500));
            } catch (InterruptedException e) {
                System.err.println("Error en escritor");
            }
            RW.escribir(escritor);
    }
  }
}