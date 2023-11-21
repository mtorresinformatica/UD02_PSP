/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidorcola;

/**
 *
 * @author DAM
 */
class Cola {

    private int numero;
    private boolean disponible;

//    public int get() {
//        //inicialmente cola vacia
//        if (disponible) //hay número en la cola
//        {
//            disponible = false; //se pone cola vacía
//            return numero; //se devuelve
//        }
//
//        return -1; //no hay número disponible, cola vacía
//    }
    synchronized int get(){
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        //visualizar número
        disponible = false;
        notify();
        return numero;
    }
    
    //Clases Thread-safe o seguras
    
//     synchronized int get()throws InterruptedException{
//        while (!disponible) {
//                wait();
//            }
//        //visualizar número
//        disponible = false;
//        notify();
//        return numero;
//    }
    

//    public void put(int valor) {
//        numero = valor; //coloca valor en la cola
//        disponible = true; //disponible para consumir, cola llena
//    }
//     
     
    synchronized void put(int valor) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        numero = valor;
        disponible = true;
        //visualizar número
        notify();
    }
     
    //Clase Thread-safe o segura
//     synchronized void put(int valor) throws InterruptedException {
//        while (disponible) {
//                wait();
//            }
//        numero = valor;
//        disponible = true;
//        //visualizar número
//        notify();
//    }
}

class Productor extends Thread {

    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i); //pone el número
            System.out.println(i + "=>Productor : " + n + ", produce : " + i);
           
        }
    }
}

class Consumidor extends Thread {

    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get(); //recoge el número
            System.out.println(i + "=>Consumidor: " + n + ", consume: " + valor);
        }
       
    }
}

public class ProductorConsumidorCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c = new Consumidor(cola, 1);
        p.start();
        c.start();
    }

}
