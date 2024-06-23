import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.RadialGradientPaint;
import componentes.objetos3D.Objeto3D;
import componentes.objetos3D.Esfera;
import raytracing.Color;

public class ModeladorApp extends JPanel {
    private JPanel herramientasPanel;
    private VisualizacionPanel visualizacionPanel;
    private ArrayList<Objeto3D> objetos3D = new ArrayList<>();

    public ModeladorApp() {
        setLayout(new BorderLayout());

        // Panel para las herramientas de modelado
        herramientasPanel = new JPanel();
        herramientasPanel.setLayout(new GridLayout(4, 2));  // Ajustar según sea necesario

        String[] objetos = { "Esfera", "Plano", "Luz" };

        JComboBox<String> objetosComboBox = new JComboBox<>(objetos);

        JButton agregarObjetoBtn = new JButton("Agregar Objeto");
        agregarObjetoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar un objeto al modelador
                String objetoSeleccionado = (String) objetosComboBox.getSelectedItem();
                agregarObjeto(objetoSeleccionado);
            }
        });

        herramientasPanel.add(objetosComboBox);
        herramientasPanel.add(agregarObjetoBtn);

        // Colores para diferenciar objetos (opcional)
        JButton colorPickerBtn = new JButton("Seleccionar Color");
        herramientasPanel.add(colorPickerBtn);

        colorPickerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.Color colorSeleccionado = JColorChooser.showDialog(null, "Seleccione un Color", java.awt.Color.WHITE);
                if (colorSeleccionado != null) {
                    // Aquí podrías establecer el color del último objeto agregado o de uno seleccionado
                    // Esto es solo un ejemplo, necesitarías una forma de seleccionar un objeto específico
                    if (!objetos3D.isEmpty()) {
                        Color nuevoColor = new Color(colorSeleccionado.getRed(), colorSeleccionado.getGreen(), colorSeleccionado.getBlue());
                        objetos3D.get(objetos3D.size() - 1).setColor(nuevoColor);
                        visualizacionPanel.repaint();
                    }
                }
            }
        });

        add(herramientasPanel, BorderLayout.WEST);

        // Panel para la visualización del modelador
        visualizacionPanel = new VisualizacionPanel(objetos3D);
        add(visualizacionPanel, BorderLayout.CENTER);
    }

    private void agregarObjeto(String tipoObjeto) {
        if (tipoObjeto.equals("Esfera")) {
            Esfera esfera = new Esfera(100, 100, 0, 50, new Color(255, 0, 0)); // Tamaño, posición y color predeterminados
            objetos3D.add(esfera);
        } else {
            // Añadir lógica para otros tipos de objetos si es necesario
        }
        visualizacionPanel.repaint(); // Redibujar para mostrar el nuevo objeto
    }

    // Clase interna para el panel de visualización
    class VisualizacionPanel extends JPanel {
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
            java.awt.Color color = esfera.getColor().toAWTColor();

            // Crear un gradiente radial
            Point2D center = new Point2D.Float(x + radio, y + radio);
            float radius = radio;
            float[] dist = {0.0f, 1.0f};
            java.awt.Color[] colors = {color.brighter(), color.darker()};
            RadialGradientPaint gradient = new RadialGradientPaint(center, radius, dist, colors);

            // Dibujar la esfera con el gradiente
            g2d.setPaint(gradient);
            g2d.fillOval(x, y, radio * 2, radio * 2);
        }
    }
}
