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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setEsObligatorio(Boolean esObligatorio) {
        this.esObligatorio = esObligatorio;
    }

    public ArrayList<Expediente> getListaExpedientes() {
        return listaExpedientes;
    }

    public void setListaExpedientes(ArrayList<Expediente> listaExpedientes) {
        this.listaExpedientes = listaExpedientes;
    }

    public void setEstadoControl(EstadoControl estadoControl) {
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

