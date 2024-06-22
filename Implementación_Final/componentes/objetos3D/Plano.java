package Implementación_Final.componentes.objetos3D;
public class Plano extends Objeto3D {
    private float ancho, alto;

    public Plano(float x, float y, float z, float ancho, float alto) {
        super(x, y, z);
        this.ancho = ancho;
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    @Override
    public void escalar(float factor) {
        ancho *= factor;
        alto *= factor;
    }

    @Override
    public void trasladar(float dx, float dy, float dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    @Override
    public void rotar(float angulo, char eje) {
        // implementación de rotación para el plano (si es necesario)
    }

    @Override
    public String toString() {
        return "Plano{" + "ancho=" + ancho + ", alto=" + alto + ", x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}