import java.util.ArrayList;
import java.util.List;

public class Expediente {
    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String ambito;

    private ArrayList<Expediente> listaExpedientes = new ArrayList<>();
    private ArrayList<Control> listaControles = new ArrayList<>();

    public Expediente(int id, String letra, int numero, String descripcion) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public ArrayList<Expediente> getListaExpedientes() {
        return listaExpedientes;
    }

    public void setListaExpedientes(ArrayList<Expediente> listaExpedientes) {
        this.listaExpedientes = listaExpedientes;
    }

    public ArrayList<Control> getListaControles() {
        return listaControles;
    }

    public void setListaControles(ArrayList<Control> listaControles) {
        this.listaControles = listaControles;
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
        acumulador.add(exp);

        for (Expediente e : exp.listaExpedientes) {
            listaExpedientesRecursivo(e, acumulador);
        }
    }

    @Override
    public String toString() {
        return "Expediente{" +
                "ID=" + id +
                ", numero=" + numero +
                ", letra='" + letra + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", controles=" + listaControles +
                ", expedientesHijos=" + listaExpedientes.size() +
                '}';
    }
}
