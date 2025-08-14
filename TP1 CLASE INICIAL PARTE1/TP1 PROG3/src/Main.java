import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Factura factura = new Factura();

        System.out.print("Ingrese la fecha de la factura: ");
        factura.setFecha(sc.nextLine());

        System.out.print("Ingrese el numero de la factura: ");
        factura.setNroFactura(sc.nextLong());
        sc.nextLine();

        System.out.print("Ingrese la razon social: ");
        factura.setRazonSocial(sc.nextLine());

        System.out.print("Ingrese el cuit: ");
        factura.setCuitCliente(sc.nextLong());
        sc.nextLine();

        factura.setTipoPago(verificarTipoPago());

        int articulosFacturar = validarArticulosFacturar();

        factura.establecerItemsFactura(articulosFacturar);

        for (int i = 0; i < articulosFacturar; i++) {
            System.out.println("\nArtículo número " + (i + 1));

            String[] filaArticulo;
            String codigo;


            do {
                System.out.print("Ingrese el código del artículo: ");
                codigo = sc.nextLine();
                filaArticulo = buscarCodigo(codigo);
                if (filaArticulo == null) {
                    System.out.println("El código ingresado es incorrecto. Intente nuevamente.");
                }
            } while (filaArticulo == null);

            factura.agregarItemsFactura(filaArticulo, i);

            // Cantidad
            String cantidadFacturar = verificarCantidad(codigo);
            factura.agregarCantidadFactura(cantidadFacturar, i);

            factura.agregarSubTotal(i);
        }

        factura.agregarMontoTotalItems();
        factura.agregarRecargo();
        factura.agregarMontoFinal();
        
        System.out.println("\n===== TICKET A PAGAR =====");
        System.out.println("Cliente: " + factura.getRazonSocial());
        System.out.println("Fecha:   " + factura.getFecha());
        System.out.println("Numero:  " + factura.getNroFactura());
        System.out.println("TipoPago:" + factura.getTipoPago());
        System.out.println("\nCodigo  Item        Precio   Cantidad   Subtotal");
        factura.obtenerItems();
        System.out.println("\nTotal Items: " + factura.getMontoTotalItems());
        System.out.println("Recargo:     " + factura.getRecargo());
        System.out.println("Total Final: " + factura.getMontoFinal());
    }

    public static String verificarCantidad(String codigo) {
        Scanner sc = new Scanner(System.in);
        String unidad = "";
        for (String[] art : CalculoFactura.articulos) {
            if (codigo.equalsIgnoreCase(art[0])) {
                unidad = art[3];
            }
        }

        while (true) {
            try {
                if (unidad.equalsIgnoreCase("U")) {
                    System.out.print("Ingrese la cantidad (entero): ");
                    int cantidad = sc.nextInt();
                    if (cantidad > 0) return String.valueOf(cantidad);
                } else {
                    System.out.print("Ingrese la cantidad (decimal): ");
                    double cantidad = sc.nextDouble();
                    if (cantidad > 0) return String.valueOf(cantidad);
                }
                System.out.println("Cantidad inválida, intente nuevamente.");
            } catch (Exception e) {
                System.out.println("Entrada incorrecta, vuelva a intentar.");
                sc.nextLine();
            }
        }
    }

    public static String[] buscarCodigo(String codigo) {
        for (String[] art : CalculoFactura.articulos) {
            if (codigo.equalsIgnoreCase(art[0])) {
                System.out.println("Artículo encontrado: " + art[1]);
                return art;
            }
        }
        return null;
    }

    public static String verificarTipoPago() {
        Scanner sc = new Scanner(System.in);
        String tipoPago;
        do {
            System.out.print("Ingrese el tipo de pago (C/TC/TD): ");
            tipoPago = sc.nextLine();
        } while (!(tipoPago.equalsIgnoreCase("C") ||
                tipoPago.equalsIgnoreCase("TC") ||
                tipoPago.equalsIgnoreCase("TD")));
        return tipoPago;
    }

    public static int validarArticulosFacturar() {
        Scanner sc = new Scanner(System.in);
        int cant;
        do {
            System.out.print("Ingrese la cantidad de artículos a facturar: ");
            cant = sc.nextInt();
        } while (cant <= 0);
        return cant;
    }
}

