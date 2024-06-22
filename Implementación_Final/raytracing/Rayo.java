package Implementación_Final.raytracing;

public class Rayo {
    private float origenX, origenY, origenZ;
    private float direccionX, direccionY, direccionZ;

    public Rayo(float origenX, float origenY, float origenZ, float direccionX, float direccionY, float direccionZ) {
        this.origenX = origenX;
        this.origenY = origenY;
        this.origenZ = origenZ;
        this.direccionX = direccionX;
        this.direccionY = direccionY;
        this.direccionZ = direccionZ;
    }

    public float getOrigenX() {
        return origenX;
    }

    public float getOrigenY() {
        return origenY;
    }

    public float getOrigenZ() {
        return origenZ;
    }

    public float getDireccionX() {
        return direccionX;
    }

    public float getDireccionY() {
        return direccionY;
    }

    public float getDireccionZ() {
        return direccionZ;
    }
}
