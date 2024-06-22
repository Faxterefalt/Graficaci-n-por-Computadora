package Implementación_Final.raytracing;

public class Material {
    private Color color;
    private float reflectividad;

    public Material(Color color, float reflectividad) {
        this.color = color;
        this.reflectividad = reflectividad;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getReflectividad() {
        return reflectividad;
    }

    public void setReflectividad(float reflectividad) {
        this.reflectividad = reflectividad;
    }
}