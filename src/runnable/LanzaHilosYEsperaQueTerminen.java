package lanzahilosyesperaqueterminen;

import java.util.Random;

/* 
El siguiente programa lanza dos hilos. Cada uno de ellos hace pausas de duración aleatoria 
de ente 10 y 500 ms, utilizando el método sleep de la clase Thread. El hilo principal utiliza 
el método join para esperar a que terminen los dos hilos lanzados, por lo que siempre terminará 
el último. Los dos métodos anteriores pausan la ejecución del hilo, y durante ese periodo de tiempo 
se podría interrumpir. Si esto sucede, se lanzaría una InterruptedException, que se captura para 
mostrar un mensaje
*/


class Hilo implements Runnable {

  private final String nombre;

  Hilo(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public void run() {
    System.out.printf("Hola, soy el hilo: %s.\n", this.nombre);
    for (int i = 0; i < 5; i++) {
      Random r = new Random();
      int pausa = 10 + r.nextInt(500 - 10);
      System.out.printf("Hilo: %s hace pausa de %d ms.\n", this.nombre, pausa);
      try {
        Thread.sleep(pausa);
      } catch (InterruptedException e) {
        System.out.printf("Hilo %s interrumpido.\n", this.nombre);
      }
    }
    System.out.printf("Hilo %s terminado.\n", this.nombre);
  }

}

public class LanzaHilosYEsperaQueTerminen {

  public static void main(String[] args) {

    Thread h1 = new Thread(new Hilo("H1"));
    Thread h2 = new Thread(new Hilo("H2"));
    h1.start();
    h2.start();
    try {
      h1.join();
      h2.join();
    } catch (InterruptedException ex) {
      System.out.println("Hilo principal interrumpido.");
    }
    System.out.println("Hilo principal terminado.");
  }
}
