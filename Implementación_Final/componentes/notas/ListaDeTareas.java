package Implementación_Final.componentes.notas;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTareas {
    private List<Tarea> tareas;

    public ListaDeTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Tarea tarea : tareas) {
            sb.append(tarea.toString()).append("\n");
        }
        return sb.toString();
    }
}