import java.util.ArrayList;
import java.util.List;

public class Sector {
    private String nombre;
    private List<Sector> subsectores = new ArrayList<>();

    public Sector(String nombre) {
        this.nombre = nombre;
    }

    public void addSubsector(Sector subsector) {
        subsectores.add(subsector);
    }

    public List<Sector> obtenerTotalSubsectores() {
        List<Sector> lista = new ArrayList<>();
        obtenerTotalSubsectoresRec(this, lista);
        return lista;
    }

    private void obtenerTotalSubsectoresRec(Sector sector, List<Sector> acumulador) {
        for (Sector sub : sector.subsectores) {
            acumulador.add(sub);
            obtenerTotalSubsectoresRec(sub, acumulador);
        }
    }

    @Override
    public String toString() {
        return "Sector{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
