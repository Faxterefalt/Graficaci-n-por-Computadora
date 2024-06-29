package componentes.objetos3D;
import raytracing.Vector3D;

public class Sphere {
    public Vector3D center;
    public double radius;
    public Vector3D color;

    public Sphere(Vector3D center, double radius, Vector3D color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }
}
