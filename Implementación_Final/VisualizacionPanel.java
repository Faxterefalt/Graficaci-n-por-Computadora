import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.RadialGradientPaint;
import java.util.ArrayList;
import componentes.objetos3D.Objeto3D;
import componentes.objetos3D.Esfera;
import java.awt.Color;
public class VisualizacionPanel extends JPanel {
    private ArrayList<Objeto3D> objetos3D;

    public VisualizacionPanel(ArrayList<Objeto3D> objetos3D) {
        this.objetos3D = objetos3D;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Objeto3D obj : objetos3D) {
            if (obj instanceof Esfera) {
                Esfera esfera = (Esfera) obj;
                drawSphere(g2d, esfera);
            }
        }
    }

    private void drawSphere(Graphics2D g2d, Esfera esfera) {
        int x = (int) esfera.getX();
        int y = (int) esfera.getY();
        int radio = (int) esfera.getRadio();
        Color color = esfera.getColor();

        // Crear un gradiente radial
        Point2D center = new Point2D.Float(x + radio, y + radio);
        float radius = radio;
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {color.brighter(), color.darker()};
        RadialGradientPaint gradient = new RadialGradientPaint(center, radius, dist, colors);

        // Dibujar la esfera con el gradiente
        g2d.setPaint(gradient);
        g2d.fillOval(x, y, radio * 2, radio * 2);
    }
}
