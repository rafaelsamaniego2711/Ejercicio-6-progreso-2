import java.util.ArrayList;

public class SistemaControl {
    private ArrayList<Sensor> sensores;

    public SistemaControl() {
        sensores = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        if (sensor != null) {
            sensores.add(sensor);
        }
    }

    public Sensor buscarSensor(String codigo) {
        if (codigo == null) {
            return null;
        }
        for (Sensor s : sensores) {
            if (codigo.equals(s.getCodigo())) {
                return s;
            }
        }
        return null;
    }

    public boolean eliminarSensor(String codigo) {
        Sensor encontrado = buscarSensor(codigo);
        if (encontrado != null) {
            return sensores.remove(encontrado);
        }
        return false;
    }

    public double calcularPromedioLecturas() {
        if (sensores.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Sensor s : sensores) {
            suma += s.getLectura();
        }
        return suma / sensores.size();
    }

    public int contarSensoresActivos() {
        int activos = 0;
        for (Sensor s : sensores) {
            if (s.isActivo()) {
                activos++;
            }
        }
        return activos;
    }

    public Sensor obtenerMayorLectura() {
        if (sensores.isEmpty()) {
            return null;
        }
        Sensor mayor = sensores.get(0);
        for (Sensor s : sensores) {
            if (s.getLectura() > mayor.getLectura()) {
                mayor = s;
            }
        }
        return mayor;
    }

    public String mostrarSensores() {
        if (sensores.isEmpty()) {
            return "No hay sensores registrados.";
        }
        String lista = "";
        for (Sensor s : sensores) {
            lista += s.mostrarInformacion() + "\n";
        }
        return lista;
    }
}
