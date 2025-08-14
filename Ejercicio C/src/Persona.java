import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private List<Actividad> actividades = new ArrayList<>();

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void addActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public double totalPuntosAsignados() {
        double total = 0;
        for (Actividad act : actividades) {
            total += act.getPuntosAsignados();
        }
        return total;
    }

    public double totalPuntosAsignados(int codigo) {
        double total = 0;
        for (Actividad act : actividades) {
            if (act.getCodigo() == codigo) {
                total += act.getPuntosAsignados();
            }
        }
        return total;
    }

    public double totalPuntosAsignados(int codigo, int anio) {
        double total = 0;
        for (Actividad act : actividades) {
            if (act.getCodigo() == codigo && act.getAnio() == anio) {
                total += act.getPuntosAsignados();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", actividades=" + actividades +
                '}';
    }
}
