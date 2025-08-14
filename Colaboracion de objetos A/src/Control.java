import java.util.ArrayList;

public class Control {
    private int id;
    private String denominacion;
    private Boolean esObligatorio;
    private ArrayList<Expediente> listaExpedientes = new ArrayList<>();
    private EstadoControl estadoControl;

    public Control(String denominacion, Boolean esObligatorio, EstadoControl estadoControl) {
        this.denominacion = denominacion;
        this.esObligatorio = esObligatorio;
        this.estadoControl = estadoControl;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public Boolean getEsObligatorio() {
        return esObligatorio;
    }

    public EstadoControl getEstadoControl() {
        return estadoControl;
    }

    public void addExpediente(Expediente exp) {
        if (!listaExpedientes.contains(exp)) {
            listaExpedientes.add(exp);
        }
    }

    @Override
    public String toString() {
        return "Control{" +
                "denominacion='" + denominacion + '\'' +
                ", esObligatorio=" + esObligatorio +
                ", aprobado=" + (estadoControl != null ? estadoControl.getAprobado() : "N/A") +
                '}';
    }
}

