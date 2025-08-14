import java.util.Arrays;

public class Factura {
    private String fecha;
    private long nroFactura;
    private String razonSocial;
    private long cuitCliente;
    private String tipoPago;
    private double montoTotalItems;
    private double recargo;
    private double montoFinal;
    private String[][] itemsFactura;

    public Factura() {
    }

    public void establecerItemsFactura(int cantidad) {
        this.itemsFactura = new String[cantidad][5];
    }

    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public long getNroFactura() { return nroFactura; }


    public void setNroFactura(long nroFactura) { this.nroFactura = nroFactura; }

    public String getRazonSocial() { return razonSocial; }

    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public long getCuitCliente() { return cuitCliente; }

    public void setCuitCliente(long cuitCliente) { this.cuitCliente = cuitCliente; }

    public String getTipoPago() { return tipoPago; }

    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }

    public double getMontoTotalItems() { return montoTotalItems; }

    public void setMontoTotalItems(double montoTotalItems) { this.montoTotalItems = montoTotalItems; }

    public double getRecargo() { return recargo; }

    public void setRecargo(double recargo) { this.recargo = recargo; }

    public double getMontoFinal() { return montoFinal; }

    public void setMontoFinal(double montoFinal) { this.montoFinal = montoFinal; }

    public String[][] getItemsFactura() { return itemsFactura; }

    public void setItemsFactura(String[][] itemsFactura) { this.itemsFactura = itemsFactura; }

    public void agregarItemsFactura(String[] filaArticulo, int filaDestino) {
        for (int i = 0; i < filaArticulo.length; i++) {
            this.itemsFactura[filaDestino][i] = filaArticulo[i];
        }
    }

    public void agregarCantidadFactura(String cantidad, int filaDestino) {
        this.itemsFactura[filaDestino][3] = cantidad;
    }

    public void agregarSubTotal(int filaDestino) {
        double precio = Double.parseDouble(this.itemsFactura[filaDestino][2]);
        double cantidad = Double.parseDouble(this.itemsFactura[filaDestino][3]);
        this.itemsFactura[filaDestino][4] = String.valueOf(precio * cantidad);
    }

    public void agregarMontoTotalItems() {
        montoTotalItems = 0;
        for (String[] fila : this.itemsFactura) {
            montoTotalItems += Double.parseDouble(fila[4]);
        }
    }

    public void agregarRecargo() {
        if (this.tipoPago.equalsIgnoreCase("C")) {
            this.recargo = 0;
        } else if (this.tipoPago.equalsIgnoreCase("TD")) {
            this.recargo = this.montoTotalItems * 0.05;
        } else if (this.tipoPago.equalsIgnoreCase("TC")) {
            this.recargo = this.montoTotalItems * 0.10;
        }
    }

    public void agregarMontoFinal() {
        this.montoFinal = this.montoTotalItems + this.recargo;
    }

    public void obtenerItems() {
        for (String[] fila : this.itemsFactura) {
            System.out.printf("%-6s %-12s %-8s %-9s %-10s%n",
                    fila[0], fila[1], fila[2], fila[3], fila[4]);
        }
    }

    @Override
    public String toString() {
        return "Factura{" +
                "fecha='" + fecha + '\'' +
                ", nroFactura=" + nroFactura +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuitCliente=" + cuitCliente +
                ", tipoPago='" + tipoPago + '\'' +
                ", montoTotalItems=" + montoTotalItems +
                ", recargo=" + recargo +
                ", montoFinal=" + montoFinal +
                ", itemsFactura=" + Arrays.deepToString(itemsFactura) +
                '}';
    }
}

