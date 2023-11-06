/**
 * ESTA CLASE IMPRIME POR CONSOLA UN N�MERO PRIMO MAYOR QUE EL N�MERO
 * QUE SE LE HA PROPORCIONADO A TRAV�S DEL CONSTRUCTOR
 */
package runnable;

/**
 * @author DAM
 *
 */
public class PrimoRunnable implements Runnable {

	private long minimo;
	
	public PrimoRunnable(long minimo) {
		this.minimo = minimo;
	}
	
	@Override
	public void run() {
		long n = minimo;
		while(!testPrimalidad(n)) {
			System.out.printf("%d no es primo %n", n);
			++n;
		}
		
		System.out.printf("El n�mero primo es %d %n", n);
	}
	
	/*
	 * Método que nos permite verificar si un número es
	 * primo revisando si tiene divisores hasta n/2
	 * OJO es fácil de implementar, pero ineficiente para 
	 * números grandes
	 */
	public static boolean testPrimalidad(long n) {
		
		boolean continuar = true;
		boolean esPrimo = true;
		long divisor = 2;
		do {
			if (n % divisor == 0) {
				continuar = false;
				esPrimo = false;
			} else
				++divisor;			
				
		} while (continuar && divisor <= (n/2));
		
		return esPrimo;
	}

}
