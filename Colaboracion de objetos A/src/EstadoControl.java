import java.util.ArrayList;

public class EstadoControl {
    private long id;
    private Boolean aprobado;
    private ArrayList<Control> listaControles = new ArrayList<>();

    public EstadoControl(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void addControl(Control control) {
        if (!listaControles.contains(control)) {
            listaControles.add(control);
        }
    }

    @Override
    public String toString() {
        return "EstadoControl{" +
                "aprobado=" + aprobado +
                '}';
    }
}
