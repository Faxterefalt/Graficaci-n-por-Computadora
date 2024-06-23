package componentes.transformaciones;

import componentes.objetos3D.Objeto3D;

public class Transformaciones {

    public static void escalar(Objeto3D objeto, float factor) {
        objeto.escalar(factor);
    }

    public static void trasladar(Objeto3D objeto, float dx, float dy, float dz) {
        objeto.trasladar(dx, dy, dz);
    }

    public static void rotar(Objeto3D objeto, float angulo, char eje) {
        objeto.rotar(angulo, eje);
    }
}