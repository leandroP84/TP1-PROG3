//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona("Juan Pérez");
        p1.addActividad(new Actividad(101, 2024, 10.5, "Curso de Java"));
        p1.addActividad(new Actividad(102, 2024, 5.0, "Taller de Python"));
        p1.addActividad(new Actividad(101, 2023, 8.0, "Curso de Java"));
        p1.addActividad(new Actividad(103, 2024, 7.5, "Charla de Ciberseguridad"));

        System.out.println("Total puntos asignados: " + p1.totalPuntosAsignados());
        System.out.println("Total puntos para código 101: " + p1.totalPuntosAsignados(101));
        System.out.println("Total puntos para código 101 en 2024: " + p1.totalPuntosAsignados(101, 2024));

        Sector s1 = new Sector("Tecnología");
        Sector s2 = new Sector("Desarrollo");
        Sector s3 = new Sector("Infraestructura");
        Sector s4 = new Sector("Backend");
        Sector s5 = new Sector("Frontend");

        s1.addSubsector(s2);
        s1.addSubsector(s3);
        s2.addSubsector(s4);
        s2.addSubsector(s5);

        System.out.println("\nSubsectores de Tecnología:");
        for (Sector sub : s1.obtenerTotalSubsectores()) {
            System.out.println("- " + sub);
        }
    }
}
