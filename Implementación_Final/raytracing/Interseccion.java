package Implementación_Final.raytracing;

import componentes.objetos3D.Objeto3D;

public class Interseccion {
    private Objeto3D objeto;
    private float distancia;

    public Interseccion(Objeto3D objeto, float distancia) {
        this.objeto = objeto;
        this.distancia = distancia;
    }

    public Objeto3D getObjeto() {
        return objeto;
    }

    public float getDistancia() {
        return distancia;
    }
}