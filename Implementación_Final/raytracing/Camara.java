package raytracing;

public class Camara {
    private float x, y, z;
    private float lookAtX, lookAtY, lookAtZ;

    public Camara(float x, float y, float z, float lookAtX, float lookAtY, float lookAtZ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.lookAtX = lookAtX;
        this.lookAtY = lookAtY;
        this.lookAtZ = lookAtZ;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public float getZ() { return z; }
    public void setZ(float z) { this.z = z; }

    public float getLookAtX() { return lookAtX; }
    public void setLookAtX(float lookAtX) { this.lookAtX = lookAtX; }

    public float getLookAtY() { return lookAtY; }
    public void setLookAtY(float lookAtY) { this.lookAtY = lookAtY; }

    public float getLookAtZ() { return lookAtZ; }
    public void setLookAtZ(float lookAtZ) { this.lookAtZ = lookAtZ; }
}
