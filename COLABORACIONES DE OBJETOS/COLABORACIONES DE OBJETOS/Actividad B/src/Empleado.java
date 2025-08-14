import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;

    private RegimenHorario regimenHorario;
    private ArrayList<Asistencia> asistencias = new ArrayList<>();
    private ArrayList<Tardanza> tardanzas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegimenHorario getRegimenHorario() {
        return regimenHorario;
    }

    public void setRegimenHorario(RegimenHorario regimenHorario) {
        this.regimenHorario = regimenHorario;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(ArrayList<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public ArrayList<Tardanza> getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(ArrayList<Tardanza> tardanzas) {
        this.tardanzas = tardanzas;
    }

    // Punto B.2
    public List<Asistencia> getAsistenciaXMesXAnio(int mes, int anio){
        List<Asistencia> resultado = new ArrayList<>();
        for(Asistencia asistencia: asistencias){
            if(asistencia.getFecha().getMonthValue() == mes &&
                    asistencia.getFecha().getYear() == anio){
                resultado.add(asistencia);
            }
        }
        return resultado;
    }

    // Punto B.3
    public List<Tardanza> getDiasConTardanza(int mes, int anio){
        List<Asistencia> asistenciasFiltradas = getAsistenciaXMesXAnio(mes, anio);
        List<Tardanza> resultado = new ArrayList<>();

        for(Asistencia asistencia : asistenciasFiltradas){
            int horaIngreso = regimenHorario.getHoraIngreso();
            int minutoIngreso = regimenHorario.getMinutoIngreso();

            int minutosRegimen = horaIngreso * 60 + minutoIngreso;
            int minutosAsistencia = asistencia.getHora() * 60 + asistencia.getMinuto();

            if(minutosAsistencia > minutosRegimen + 15){
                Tardanza tardanza = new Tardanza();
                tardanza.setId(asistencia.getId());
                tardanza.setTipo(asistencia.getTipo());
                tardanza.setFecha(asistencia.getFecha());
                tardanza.setHora(asistencia.getHora());
                tardanza.setMinuto(asistencia.getMinuto());
                tardanza.setEmpleado(this);

                tardanzas.add(tardanza);
                resultado.add(tardanza);
            }
        }
        return resultado;
    }
}
