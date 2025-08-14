import java.util.ArrayList;

public class Control {
    private int id;
    private String denominacion;
    private Boolean esObligatorio;

    private ArrayList<Expediente> listaExpedientes= new ArrayList<>();
    private EstadoControl estadoControl;

    //


    public Control(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDenominacion() {
        return denominacion;
    }
}
