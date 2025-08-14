public class Main {
    public static void main(String[] args) {

        Expediente exp1 = new Expediente(01, "A", 001,  "primer expediente");
        Control cont1 = new Control("denominacion x");
        Control cont2 = new Control("denominacion y");
        Control cont3 = new Control("denominacion z");

        exp1.addControl(cont1);
        exp1.addControl(cont2);
        exp1.addControl(cont3);

        Expediente exp2 = new Expediente(02, "B", 002,  "segundo expediente");
        Expediente exp3 = new Expediente(03, "C", 003,  "tercer expediente");
        exp1.addExpediente(exp2);
        exp1.addExpediente(exp3);
    }
}
