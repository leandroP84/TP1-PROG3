import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
    private String letra;
    private int numero;
    private double recargo;
    private String tipoPago;
    private double totalItems;
    private double totalFinal;
    private LocalDate fecha;
    private Cliente cliente;
    private ArrayList<DetalleFactura> detalleFacturas = new ArrayList<>();

    public String getLetra() { return letra; }

    public void setLetra(String letra) { this.letra = letra; }

    public int getNumero() { return numero; }

    public void setNumero(int numero) { this.numero = numero; }

    public double getRecargo() { return recargo; }

    public void setRecargo(double recargo) { this.recargo = recargo; }

    public String getTipoPago() { return tipoPago; }

    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }

    public double getTotalItems() { return totalItems; }

    public void setTotalItems(double totalItems) { this.totalItems = totalItems; }

    public double getTotalFinal() { return totalFinal; }

    public void setTotalFinal(double totalFinal) { this.totalFinal = totalFinal; }

    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public ArrayList<DetalleFactura> getDetalleFacturas() { return detalleFacturas; }

    public void setDetalleFacturas(ArrayList<DetalleFactura> detalleFacturas) { this.detalleFacturas = detalleFacturas; }

    public void agregarTipoPago() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String tipoP;
        boolean condicion = false;
        System.out.println("Ingrese el tipo de pago (C, TC, TD):");
        do {
            tipoP = sc.nextLine();
            if (tipoP.equalsIgnoreCase("C") || tipoP.equalsIgnoreCase("TC") || tipoP.equalsIgnoreCase("TD")) {
                System.out.println("Tipo de pago valido");
                condicion = true;
            } else {
                System.out.println("Tipo de pago no valido. Vuelva a ingresarlo:");
            }
        } while (!condicion);
        this.tipoPago = tipoP;
    }

    public void calcularTotales() {
        totalItems = 0;
        for (DetalleFactura d : detalleFacturas) {
            totalItems += d.getSubTotal();
        }

        switch (tipoPago.toUpperCase()) {
            case "C" -> recargo = 0;
            case "TD" -> recargo = totalItems * 0.05;
            case "TC" -> recargo = totalItems * 0.10;
        }
        totalFinal = totalItems + recargo;
    }
}

