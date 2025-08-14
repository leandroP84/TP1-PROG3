import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear empleado
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan Pérez");
        empleado.setCuit(20300123456L);
        empleado.setEmail("juanperez@mail.com");

        // Crear régimen horario: ingreso 8:00
        RegimenHorario regimen = new RegimenHorario();
        regimen.setHoraIngreso(8);
        regimen.setMinutoIngreso(0);
        regimen.setHoraEgreso(17);
        regimen.setMinutoEgreso(0);
        regimen.setEmpleado(empleado);

        empleado.setRegimenHorario(regimen);

        // Crear asistencias (mes 8 -> Agosto 2025)
        Asistencia a1 = new Asistencia();
        a1.setId(1);
        a1.setTipo("Normal");
        a1.setFecha(LocalDateTime.of(2025, 8, 10, 7, 55));
        a1.setHora(7);
        a1.setMinuto(55);
        a1.setEmpleado(empleado);

        Asistencia a2 = new Asistencia();
        a2.setId(2);
        a2.setTipo("Normal");
        a2.setFecha(LocalDateTime.of(2025, 8, 11, 8, 20)); // 20 min tarde
        a2.setHora(8);
        a2.setMinuto(20);
        a2.setEmpleado(empleado);

        Asistencia a3 = new Asistencia();
        a3.setId(3);
        a3.setTipo("Normal");
        a3.setFecha(LocalDateTime.of(2025, 8, 12, 9, 0)); // 1 hora tarde
        a3.setHora(9);
        a3.setMinuto(0);
        a3.setEmpleado(empleado);

        // Agregar asistencias al empleado
        empleado.getAsistencias().add(a1);
        empleado.getAsistencias().add(a2);
        empleado.getAsistencias().add(a3);

        // ---- Probar métodos ----
        System.out.println(">>> Asistencias Agosto 2025:");
        List<Asistencia> asistenciasAgosto = empleado.getAsistenciaXMesXAnio(8, 2025);
        for (Asistencia a : asistenciasAgosto) {
            System.out.println("Asistencia ID: " + a.getId() +
                    " Fecha: " + a.getFecha() +
                    " Hora: " + a.getHora() + ":" + a.getMinuto());
        }

        System.out.println("\n>>> Tardanzas Agosto 2025:");
        List<Tardanza> tardanzasAgosto = empleado.getDiasConTardanza(8, 2025);
        for (Tardanza t : tardanzasAgosto) {
            System.out.println("Tardanza ID: " + t.getId() +
                    " Fecha: " + t.getFecha() +
                    " Hora: " + t.getHora() + ":" + t.getMinuto());
        }
    }
}
