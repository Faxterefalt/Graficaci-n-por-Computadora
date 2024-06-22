package Implementación_Final.componentes.luz;

public class Luz {
    private float x, y, z;

    public Luz(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public float getZ() { return z; }
    public void setZ(float z) { this.z = z; }

    @Override
    public String toString() {
        return "Luz{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}