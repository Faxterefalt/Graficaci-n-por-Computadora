public class Camara {
    private double[] posicion;
    private double[] objetivo;

    public Camara(double[] posicion, double[] objetivo) {
        this.posicion = posicion;
        this.objetivo = objetivo;
    }

    public double[] getPosicion() {
        return posicion;
    }

    public double[] getObjetivo() {
        return objetivo;
    }
}
