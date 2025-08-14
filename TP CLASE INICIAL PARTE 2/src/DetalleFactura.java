public class DetalleFactura {
    private double cantidad;
    private double subTotal;
    private Articulo articulo;

    public DetalleFactura(double cantidad, Articulo articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.subTotal = cantidad * articulo.getPrecio();
    }

    public double getCantidad() { return cantidad; }

    public double getSubTotal() { return subTotal; }

    public Articulo getArticulo() { return articulo; }

    @Override
    public String toString() {
        return articulo.getCodigo() + "  " +
                articulo.getDenominacion() + "  " +
                articulo.getPrecio() + "  " +
                cantidad + "  " +
                subTotal;
    }
}
