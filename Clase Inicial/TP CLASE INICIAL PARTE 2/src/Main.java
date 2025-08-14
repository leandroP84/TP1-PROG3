import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static String[][] articulos = {
            {"100", "Azucar", "20", "U"},
            {"101", "Leche", "30", "U"},
            {"102", "Aceite", "50", "U"},
            {"103", "Sal", "45", "U"},
            {"104", "Fideos", "15", "U"},
            {"105", "Arroz", "28", "U"},
            {"106", "Galletas", "26", "U"},
            {"107", "Carne Molida", "220", "Kg"},
            {"108", "Shampoo", "42", "U"},
            {"109", "Queso Mantecoso", "178", "Kg"},
            {"110", "Jamon Cocido", "320", "Kg"},
            {"111", "Naranjas", "80", "Kg"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Cliente
        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese su numero:");
        int numero = sc.nextInt();

        System.out.println("Ingrese su cuit:");
        long cuit = sc.nextLong();
        sc.nextLine();

        Cliente cliente1 = new Cliente();
        cliente1.setRazonSocial(nombre);
        cliente1.setNumero(numero);
        cliente1.setCuit(cuit);

        //Factura
        System.out.println("Ingrese la letra de la factura:");
        String letra = sc.nextLine();

        System.out.println("Ingrese el numero de la factura:");
        int nroFact = sc.nextInt();
        sc.nextLine();

        Factura factura1 = new Factura();
        factura1.setLetra(letra);
        factura1.setNumero(nroFact);
        factura1.setFecha(LocalDate.now());
        factura1.setCliente(cliente1);

        factura1.agregarTipoPago();

        //Articulo
        System.out.println("Ingrese la cantidad de artículos a facturar:");
        int cantArticulos;
        do {
            cantArticulos = sc.nextInt();
            if (cantArticulos <= 0) {
                System.out.println("La cantidad debe ser mayor a 0. Ingrese nuevamente:");
            }
        } while (cantArticulos <= 0);

        for (int i = 0; i < cantArticulos; i++) {
            System.out.println("\nArtículo " + (i + 1) + ":");
            Articulo art = null;

            // Aca lo buscamos
            do {
                System.out.println("Ingrese el código del artículo:");
                String cod = sc.next();
                art = Articulo.obtenerArticuloPorCodigo(cod);
                if (art == null) {
                    System.out.println("Código no válido, intente nuevamente.");
                }
            } while (art == null);

            // aca tenemos la cantidad
            double cantidad = 0;
            boolean valida = false;
            do {
                System.out.println("Ingrese la cantidad a facturar (" + art.getUnidadMedida() + "):");
                if (art.getUnidadMedida().equalsIgnoreCase("U")) {
                    if (sc.hasNextInt()) {
                        cantidad = sc.nextInt();
                        if (cantidad > 0) valida = true;
                    } else {
                        System.out.println("Debe ingresar un número entero.");
                        sc.next();
                    }
                } else {
                    if (sc.hasNextDouble()) {
                        cantidad = sc.nextDouble();
                        if (cantidad > 0) valida = true;
                    } else {
                        System.out.println("Debe ingresar un número decimal.");
                        sc.next();
                    }
                }
            } while (!valida);

            DetalleFactura detalle = new DetalleFactura(cantidad, art);
            factura1.getDetalleFacturas().add(detalle);
        }

        //calcular detalles
        factura1.calcularTotales();

        //terminamos imprimiendo la factura
        System.out.println("\n===== TICKET A PAGAR =====");
        System.out.println("Cliente: " + cliente1.getRazonSocial());
        System.out.println("Fecha: " + factura1.getFecha());
        System.out.println("Numero: " + factura1.getNumero());
        System.out.println("Tipo Pago: " + factura1.getTipoPago());
        System.out.println("\nCódigo  Artículo          Precio  Cantidad  Subtotal");

        for (DetalleFactura d : factura1.getDetalleFacturas()) {
            System.out.println(d);
        }

        System.out.println("\nTotal Items: " + factura1.getTotalItems());
        System.out.println("Recargo: " + factura1.getRecargo());
        System.out.println("Total Final: " + factura1.getTotalFinal());
    }
}
