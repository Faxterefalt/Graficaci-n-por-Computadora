package raytracing;

import componentes.luz.Luz;
import componentes.objetos3D.Objeto3D;
import componentes.objetos3D.Esfera;
import java.awt.image.BufferedImage;
import java.util.List;

public class RayTracer {
    private Escena escena;
    private Camara camara;

    public RayTracer(Escena escena, Camara camara) {
        this.escena = escena;
        this.camara = camara;
    }

    public BufferedImage renderizar(int ancho, int alto) {
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                float[] color = trazarRayo(x, y, ancho, alto);
                int rgb = ((int) color[0] << 16) | ((int) color[1] << 8) | (int) color[2];
                imagen.setRGB(x, y, rgb);
            }
        }
        return imagen;
    }

    private float[] trazarRayo(int x, int y, int ancho, int alto) {
        // Configurar el origen y dirección del rayo
        float ndcX = (x + 0.5f) / ancho * 2 - 1;
        float ndcY = 1 - (y + 0.5f) / alto * 2;
        float dirX = ndcX;
        float dirY = ndcY;
        float dirZ = -1;

        // Normalizar la dirección del rayo
        float length = (float) Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        dirX /= length;
        dirY /= length;
        dirZ /= length;

        // Trazar el rayo contra cada objeto en la escena
        float[] color = {0, 0, 0}; // Color por defecto (negro)
        float minDistancia = Float.MAX_VALUE;
        for (Objeto3D objeto : escena.getObjetos()) {
            if (objeto instanceof Esfera) {
                Esfera esfera = (Esfera) objeto;
                float[] interseccion = intersecarEsfera(esfera, camara.getX(), camara.getY(), camara.getZ(), dirX, dirY, dirZ);
                if (interseccion != null) {
                    float distancia = distancia(camara.getX(), camara.getY(), camara.getZ(), interseccion[0], interseccion[1], interseccion[2]);
                    if (distancia < minDistancia) {
                        minDistancia = distancia;
                        color = esfera.getColor().toArray();
                    }
                }
            }
        }

        return color;
    }

    private float[] intersecarEsfera(Esfera esfera, float ox, float oy, float oz, float dx, float dy, float dz) {
        float cx = esfera.getX();
        float cy = esfera.getY();
        float cz = esfera.getZ();
        float radio = esfera.getRadio();

        // Resolver la ecuación cuadrática para intersección rayo-esfera
        float a = dx * dx + dy * dy + dz * dz;
        float b = 2 * (dx * (ox - cx) + dy * (oy - cy) + dz * (oz - cz));
        float c = (ox - cx) * (ox - cx) + (oy - cy) * (oy - cy) + (oz - cz) * (oz - cz) - radio * radio;

        float discriminante = b * b - 4 * a * c;
        if (discriminante >= 0) {
            float t1 = (-b + (float) Math.sqrt(discriminante)) / (2 * a);
            float t2 = (-b - (float) Math.sqrt(discriminante)) / (2 * a);
            float t = Math.min(t1, t2);
            if (t > 0) {
                return new float[]{ox + t * dx, oy + t * dy, oz + t * dz};
            }
        }
        return null;
    }

    private float distancia(float x1, float y1, float z1, float x2, float y2, float z2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
    }
}
