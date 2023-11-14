/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lectoresEscritores;

/**
 *
 * @author DAM
 * @link https://es.frwiki.wiki/wiki/Probl%C3%A8me_des_lecteurs_et_des_r%C3%A9dacteurs
 */
public class App {
    public static void main( String[] args )
    {
        RecursoLectorEscritor RW = new RecursoLectorEscritor();
        int veces = 7;
        Lector l1= new Lector(1,veces, RW);
        l1.start();
        Lector l2= new Lector(2,veces, RW);
        l2.start();
        Escritor e1= new Escritor(1,veces, RW);
        e1.start();
        Escritor e2= new Escritor(2,veces, RW);
        e2.start();
    }
    
}
