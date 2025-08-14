public class Articulo {
    private int codigo;
    private String denominacion;
    private double precio;
    private String unidadMedida;

    public Articulo(int codigo, String denominacion, double precio, String unidadMedida) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
    }

    public int getCodigo() { return codigo; }
    public String getDenominacion() { return denominacion; }
    public double getPrecio() { return precio; }
    public String getUnidadMedida() { return unidadMedida; }

    public static Articulo obtenerArticuloPorCodigo(String codigo) {
        for (int i = 0; i < Main.articulos.length; i++) {
            if (codigo.equals(Main.articulos[i][0])) {
                return new Articulo(
                        Integer.parseInt(Main.articulos[i][0]),
                        Main.articulos[i][1],
                        Double.parseDouble(Main.articulos[i][2]),
                        Main.articulos[i][3]
                );
            }
        }
        return null;
    }
}
