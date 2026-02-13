import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.printf("\nIngresa tu nombre: ");
        String nombre = teclado.next();
        System.out.printf("\nHola %s%n", nombre);
        System.out.print("\nIngresa el cupo de tu tarjeta: ");
        double limiteCredito = teclado.nextDouble();

        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limiteCredito);

        int salir = 1;
        while (salir != 0) {
            System.out.print("\nIngresa la descripción de la compra: ");
            String descripcion = teclado.next();

            System.out.print("Ingresa el valor de la compra: ");
            // double valor = Double.valueOf(teclado.next());   Double.valueOf convierte el String (teclado.next()) a un objeto Double, luego se asigna a double
            double valor = teclado.nextDouble();    // Esta línea de código es recomendada por chat copilot. Es más simple yeficiente para leer números decimales del teclado

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("¡Compra realizada!");
                System.out.print("\nIngresa 0 para salir o 1 para continuar:");
                salir = teclado.nextInt();
            } else {
                System.out.println("\n¡Saldo insuficiente!");
                salir = 0;
            }
        }

        System.out.println("\n************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(tarjeta.getListaDeCompras());
        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.printf(compra.getDescripcion() + ": $%,.2f%n", compra.getValor());
        }
        System.out.println("\n************************");
        
        System.out.printf("\nSaldo de la tarjeta: $%,.2f%n \n", tarjeta.getSaldoActual());

        teclado.close();
    }
}
