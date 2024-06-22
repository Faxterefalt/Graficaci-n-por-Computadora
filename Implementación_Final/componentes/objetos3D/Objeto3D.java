package Implementación_Final.componentes.objetos3D;


public abstract class Objeto3D {
    protected float x, y, z;

    public Objeto3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public abstract void escalar(float factor);
    public abstract void trasladar(float dx, float dy, float dz);
    public abstract void rotar(float angulo, char eje);

    @Override
    public String toString() {
        return "Objeto3D{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
