public class Actividad {
    private int codigo;
    private int anio;
    private double puntosAsignados;
    private String descripcion;

    public Actividad(int codigo, int anio, double puntosAsignados, String descripcion) {
        this.codigo = codigo;
        this.anio = anio;
        this.puntosAsignados = puntosAsignados;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAnio() {
        return anio;
    }

    public double getPuntosAsignados() {
        return puntosAsignados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "codigo=" + codigo +
                ", anio=" + anio +
                ", puntos=" + puntosAsignados +
                ", desc='" + descripcion + '\'' +
                '}';
    }
}
