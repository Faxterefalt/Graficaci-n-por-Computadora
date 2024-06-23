package componentes.objetos3D;

import raytracing.Color;

public class Esfera extends Objeto3D {
    private float radio;

    public Esfera(float x, float y, float z, float radio, Color color) {
        super(x, y, z, color);
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public void escalar(float factor) {
        radio *= factor;
    }

    @Override
    public void trasladar(float dx, float dy, float dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    @Override
    public void rotar(float angulo, char eje) {
        // Implementación de rotación para la esfera (si es necesario)
    }

    @Override
    public String toString() {
        return "Esfera{" + "radio=" + radio + ", x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
