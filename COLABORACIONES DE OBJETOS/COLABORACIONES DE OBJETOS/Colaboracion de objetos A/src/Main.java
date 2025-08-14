public class Main {
    public static void main(String[] args) {

        EstadoControl estadoAprobado = new EstadoControl(true);
        EstadoControl estadoNoAprobado = new EstadoControl(false);

        Expediente exp1 = new Expediente(1, "A", 1, "primer expediente");
        Control cont1 = new Control("denominacion x", true, estadoAprobado);
        Control cont2 = new Control("denominacion y", false, estadoNoAprobado);
        Control cont3 = new Control("denominacion z", true, estadoAprobado);

        exp1.addControl(cont1);
        exp1.addControl(cont2);
        exp1.addControl(cont3);

        Expediente exp2 = new Expediente(2, "B", 2, "segundo expediente");
        Expediente exp3 = new Expediente(3, "C", 3, "tercer expediente");
        exp1.addExpediente(exp2);
        exp2.addExpediente(exp3);

        System.out.println("Carátula: " + exp1.getCaratulaExpediente());
        System.out.println("Controles obligatorios: " + exp1.getControlesObligatorios());
        System.out.println("Todos los controles obligatorios aprobados?: " + exp1.getEstadoControles());
        System.out.println("Lista recursiva de expedientes: " + exp1.listaExpedientes());
    }
}
