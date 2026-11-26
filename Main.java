public class Main {
    public static void main(String[] args) {
        Sensor s1 = new Sensor("S01", "Temperatura", 24.5, true);
        Sensor s2 = new Sensor("S02", "Presión", 1.8, true);
        Sensor s3 = new Sensor("S03", "Humedad", 65.0, false);
        Sensor s4 = new Sensor("S04", "Caudal", 12.4, true);

        SistemaControl sistema = new SistemaControl();
        System.out.println("Estado inicial: " + sistema.mostrarSensores());

        sistema.agregarSensor(s1);
        sistema.agregarSensor(s2);
        sistema.agregarSensor(s3);
        sistema.agregarSensor(s4);

        System.out.println(sistema.mostrarSensores());
        System.out.println("Sensores activos: " + sistema.contarSensoresActivos());
        System.out.printf("Promedio de lecturas: %.2f%n", sistema.calcularPromedioLecturas());

        Sensor encontrado = sistema.buscarSensor("S01");
        System.out.println("Buscar S01: " + (encontrado != null ? encontrado.mostrarInformacion() : "No encontrado"));

        System.out.println("Buscar S99: " + sistema.buscarSensor("S99"));
        System.out.println("Eliminar S03: " + sistema.eliminarSensor("S03"));
        System.out.println("Eliminar S99: " + sistema.eliminarSensor("S99"));

        Sensor mayor = sistema.obtenerMayorLectura();
        System.out.println("Mayor lectura: " + (mayor != null ? mayor.mostrarInformacion() : "Ninguno"));
    }
}
