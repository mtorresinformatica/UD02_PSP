/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofosComensales;

/**
 *
 * @author DAM
 * @link https://es.frwiki.wiki/wiki/D%C3%AEner_des_philosophes
 */
public class App 
{
    public static void main( String[] args )
    {
        int peso = 5;
        int numero = 5;
        Tenedor[] tenedores = new Tenedor[numero];
        Filosofo[] filosofos = new Filosofo[numero];
        for (int i = 0; i < numero; i++) {
            tenedores[i] = new Tenedor();
        }
        for (int i = 0; i < numero; i++) {
            // Solo funciona con notify, no con notifyAll
            filosofos[i] = new Filosofo(tenedores[i], tenedores[(i+1)%numero],i,peso);
            filosofos[i].start();
            
            // Para romper el interbloqueo circular si usamos notifyAll
            /*
             if (i < (numero - 1)) {
                filosofos[i] = new Filosofo(tenedores[i], tenedores[i+1],i,peso);
                filosofos[i].start();
            }else{
               filosofos[i] = new Filosofo(tenedores[0], tenedores[i],i,peso);
               filosofos[i].start();
            }
            */

        }
    }
}