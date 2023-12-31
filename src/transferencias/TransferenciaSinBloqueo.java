/*
 * Desarrollar un sistema para transferencias bancarias. Para realizar una
 * transferencia de una cuenta c1 a una cuenta c2, debe conseguirse el acceso
 * en exclusiva a ambas cuentas, ya que, mientras se está realizando la 
 * transferencia, ningún otro poceso debe acceder a ninguna de las dos cuentas,
 * ni siquiera para consultar su saldo.
 */
package transferencias;

/**
 *
 * @author DAM
 */
class GestorTransferencias {

    public static boolean transferencia(Cuenta c1, Cuenta c2, int cantidad) {
        Cuenta cuentaMenor, cuentaMayor;
        if (c1.getNumCuenta().compareTo(c2.getNumCuenta()) < 0) {
            cuentaMenor = c1;
            cuentaMayor = c2;
        } else {
            cuentaMenor = c2;
            cuentaMayor = c1;
        }
        boolean result = false;
        synchronized (cuentaMenor) {
            synchronized (cuentaMayor) {
                if (c1.getSaldo() >= cantidad) {
                    c1.sacar(cantidad);
                    c2.ingresar(cantidad);
                    System.out.println(c1.getSaldo());
                    result = true;
                }
            }
        }
        return result;
    }
}

class Cuenta {

    int saldo;
    final String numCuenta;

    public Cuenta(String numCuenta, int saldoInicial) {
        this.saldo = saldoInicial;
        this.numCuenta = numCuenta;
    }

    public synchronized int getSaldo() {
        return this.saldo;
    }

    public synchronized void ingresar(int cantidad) {
        this.saldo += cantidad;
    }

    public synchronized void sacar(int cantidad) {
        this.saldo -= cantidad;
    }

    public String getNumCuenta() {
        return this.numCuenta;
    }
}

class Hilo implements Runnable {

    Cuenta c1, c2;
    String nomHilo;

    Hilo(Cuenta c1, Cuenta c2, String nomHilo) {
        this.c1 = c1;
        this.c2 = c2;
        this.nomHilo = nomHilo;
    }

    @Override
    public void run() {
        int cantidad = 10;
        int numTransf = 0;
        for (int i = 0; i < 10000; i++) {
            if (GestorTransferencias.transferencia(c1, c2, cantidad)) {
                numTransf++;
            }
            System.out.printf("**** FIN de %s, %d transferencias hechas de %s a %s.\n",
                    this.getNomHilo(),
                    numTransf,
                    c1.getNumCuenta(),
                    c2.getNumCuenta());
        }
    }

    public String getNomHilo() {
        return nomHilo;
    }
}

class TransferenciaSinBloqueo {

    public static void main(String[] args) {
        Cuenta c1 = new Cuenta("ES1512345678901234567890", 12500);
        Cuenta c2 = new Cuenta("ES4578901234567890123456", 23400);
        System.out.printf("Saldo inicial de %s: %d\n", c1.getNumCuenta(), c1.getSaldo());
        System.out.printf("Saldo inicial de %s: %d\n", c2.getNumCuenta(), c2.getSaldo());
        System.out.println("----------------------------------");    // Dos hilos: uno hace transferencias de c1 a c2, otro de c2 a c1    

        Thread h1 = new Thread(new Hilo(c1, c2, "H1"));
        Thread h2 = new Thread(new Hilo(c2, c1, "H2"));
        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("---------------------------------------");
        System.out.printf("Saldo final %s: %d\n", c1.getNumCuenta(), c1.getSaldo());
        System.out.printf("Saldo final %s: %d\n", c2.getNumCuenta(), c2.getSaldo());
    }
}
