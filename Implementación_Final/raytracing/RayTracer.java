package raytracing;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class RayTracer {
    private Escena escena;
    private Camara camara;

    public RayTracer(Escena escena, Camara camara) {
        this.escena = escena;
        this.camara = camara;
    }

    public BufferedImage renderizar(int ancho, int alto) {
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                double[] direccion = calcularDireccionRayo(i, j, ancho, alto);
                Color color = calcularColor(camara.getPosicion(), direccion, 0);
                imagen.setRGB(i, alto - j - 1, color.getRGB());
            }
        }

        return imagen;
    }

    private double[] calcularDireccionRayo(int i, int j, int ancho, int alto) {
        double x = (i - ancho / 2.0) / ancho;
        double y = (j - alto / 2.0) / alto;
        double z = 1.0; // Vector dirección en Z

        return norma(new double[]{x, y, z});
    }

    private double[] norma(double[] vector) {
        double norm = Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1] + vector[2] * vector[2]);
        return new double[]{vector[0] / norm, vector[1] / norm, vector[2] / norm};
    }

    private Color calcularColor(double[] origen, double[] direccion, int profundidad) {
        // Aquí va la lógica del trazador de rayos para calcular el color
        // Simulación de color simple por ahora
        return new Color(255, 255, 255);
    }
}
