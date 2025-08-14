import java.util.ArrayList;

public class Expediente {
    private int PK;
    private String letra;
    private int numero;
    private String descripcion;
    private String ambito;

    private Expediente expediente;
    private ArrayList<Expediente> listaExpedientes = new ArrayList();
    private ArrayList<Control> listaControls = new ArrayList();


    //


    public Expediente(int PK, String letra, int numero, String descripcion) {
        this.PK = PK;
        this.letra = letra;
        this.numero = numero;
        this.descripcion = descripcion;
    }
    public void addControl(Control control) {
        listaControls.add(control);
    }

    public void addExpediente(Expediente expediente) {
        listaExpedientes.add(expediente);
    }

    public String getCaratulaExpediente() {
        return expediente.numero + "-" + expediente.letra + "-" + expediente.descripcion + "-" + expediente.descripcion;
    }

    public String getControlesObligatorios() {
        String lista = "";
        String newItem;
        for (Control c : listaControls) {
            newItem = c.getDenominacion();
            lista = lista + ", " + newItem;
        }
        return lista + ".";
    }

    public ArrayList<Expediente> getListaExpedientes() {
        ArrayList<Expediente> listaE = new ArrayList();
        for (Expediente e : listaExpedientes) {
            listaE.add(e);
        }
        return listaE;
    }
}
