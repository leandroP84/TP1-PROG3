import java.util.ArrayList;
import java.util.List;

public class Expediente {
    private int PK;
    private String letra;
    private int numero;
    private String descripcion;
    private String ambito;

    private ArrayList<Expediente> listaExpedientes = new ArrayList<>();
    private ArrayList<Control> listaControles = new ArrayList<>();

    public Expediente(int PK, String letra, int numero, String descripcion) {
        this.PK = PK;
        this.letra = letra;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public void addControl(Control control) {
        listaControles.add(control);
        control.addExpediente(this);
    }

    public void addExpediente(Expediente expediente) {
        listaExpedientes.add(expediente);
    }

    // A.1
    public String getCaratulaExpediente() {
        return numero + "-" + letra + "-" + descripcion;
    }

    // A.2
    public String getControlesObligatorios() {
        StringBuilder lista = new StringBuilder();
        for (Control c : listaControles) {
            if (c.getEsObligatorio()) {
                if (lista.length() > 0) lista.append(", ");
                lista.append(c.getDenominacion());
            }
        }
        return lista.toString();
    }

    // A.3
    public boolean getEstadoControles() {
        for (Control c : listaControles) {
            if (c.getEsObligatorio() && !c.getEstadoControl().getAprobado()) {
                return false;
            }
        }
        return true;
    }

    // A.4
    public List<Expediente> listaExpedientes() {
        List<Expediente> acumulador = new ArrayList<>();
        listaExpedientesRecursivo(this, acumulador);
        return acumulador;
    }

    private void listaExpedientesRecursivo(Expediente exp, List<Expediente> acumulador) {
        for (Expediente e : exp.listaExpedientes) {
            acumulador.add(e);
            listaExpedientesRecursivo(e, acumulador);
        }
    }

    @Override
    public String toString() {
        return "Expediente{" +
                "PK=" + PK +
                ", numero=" + numero +
                ", letra='" + letra + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", controles=" + listaControles +
                ", expedientesHijos=" + listaExpedientes.size() +
                '}';
    }
}
