/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofosComensalesV2;

/**
 *
 * @author DAM
 */
public class App {
    
    public static void main(String[] args) {
        Mesa m = new Mesa(5);
        for (int i = 1; i <= 5; i++) {
            Filosofo f = new Filosofo(m, i);
            f.start();
        }
    }
}