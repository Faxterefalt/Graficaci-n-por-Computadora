package Implementación_Final.raytracing;

import componentes.objetos3D.Objeto3D;
import componentes.luz.Luz;

import java.util.ArrayList;
import java.util.List;

public class Escena {
    private List<Objeto3D> objetos;
    private List<Luz> luces;

    public Escena() {
        this.objetos = new ArrayList<>();
        this.luces = new ArrayList<>();
    }

    public void agregarObjeto(Objeto3D objeto) {
        objetos.add(objeto);
    }

    public void agregarLuz(Luz luz) {
        luces.add(luz);
    }

    public List<Objeto3D> getObjetos() {
        return objetos;
    }

    public List<Luz> getLuces() {
        return luces;
    }
}