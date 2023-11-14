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
public class Lector extends Thread{
    int veces;
    int lector;
    RecursoLectorEscritor RW;
    private final Random generator = new Random();

    public Lector(int lector, int veces, RecursoLectorEscritor RW) {
        this.veces = veces;
        this.lector= lector;
        this.RW = RW;
    }
    @Override
    public void run() {
        for (int i = 0; i<veces; i++) {
	try {
            Thread.sleep(generator.nextInt(500));
        }catch (InterruptedException e) {
            System.err.println("Error en lector");
        }
        RW.leer(lector);
    }
  }
    
}