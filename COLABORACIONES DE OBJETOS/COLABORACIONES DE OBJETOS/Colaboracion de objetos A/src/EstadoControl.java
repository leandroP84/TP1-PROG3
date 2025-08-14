import java.util.ArrayList;

public class EstadoControl {
    private long id;
    private Boolean aprobado;
    private ArrayList<Control> listaControles = new ArrayList<>();

    public EstadoControl(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public ArrayList<Control> getListaControles() {
        return listaControles;
    }

    public void setListaControles(ArrayList<Control> listaControles) {
        this.listaControles = listaControles;
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
