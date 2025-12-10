import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nIngrese cupo de la tarjeta: ");
        double limiteCredito = teclado.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limiteCredito);

        int salir = 1;
        while(salir != 0){
            System.out.print("\nIngrese descripción de la compra: ");
            String descripcion = teclado.next();

            System.out.print("Ingrese el valor de la compra: ");
            double valor = Double.valueOf(teclado.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("¡Compra realizada!");
                System.out.print("\nIngrese 0 para salir o 1 para continuar:");
                salir = teclado.nextInt();
            } else {
                System.out.println("\n¡Saldo insuficiente!");
                salir = 0;
            }
        }

        System.out.println("\n************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.printf(compra.getDescripcion() + ": $%,1.2f%n", compra.getValor());
        }
        System.out.println("\n************************");
        System.out.printf("\nSaldo de la tarjeta: $%,.2f%n \n", tarjeta.getSaldoActual());
    }
}
