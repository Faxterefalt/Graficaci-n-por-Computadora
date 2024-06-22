package Implementación_Final.componentes.objetos3D;

public class Esfera extends Objeto3D {
    private float radio;

    public Esfera(float x, float y, float z, float radio) {
        super(x, y, z);
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