import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import componentes.objetos3D.Objeto3D;
import componentes.objetos3D.Esfera;
import raytracing.Color;

public class ModeladorApp extends JPanel {
    private JPanel herramientasPanel;
    private VisualizacionPanel visualizacionPanel;
    private ArrayList<Objeto3D> objetos3D;
    private Esfera esferaSeleccionada = null;
    private int offsetX, offsetY;

    public ModeladorApp(ArrayList<Objeto3D> objetos3D) {
        this.objetos3D = objetos3D;
        setLayout(new BorderLayout());

        //herramientas de modelado
        herramientasPanel = new JPanel();
        herramientasPanel.setLayout(new GridLayout(4, 2));  

        String[] objetos = { "Esfera", "Plano", "Luz" };

        JComboBox<String> objetosComboBox = new JComboBox<>(objetos);

        JButton agregarObjetoBtn = new JButton("Agregar Objeto");
        agregarObjetoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //agregar un objeto al modelador
                String objetoSeleccionado = (String) objetosComboBox.getSelectedItem();
                agregarObjeto(objetoSeleccionado);
            }
        });

        herramientasPanel.add(objetosComboBox);
        herramientasPanel.add(agregarObjetoBtn);

        //diferenciar objetos 
        JButton colorPickerBtn = new JButton("Seleccionar Color");
        herramientasPanel.add(colorPickerBtn);

        colorPickerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.Color colorSeleccionado = JColorChooser.showDialog(null, "Seleccione un Color", java.awt.Color.WHITE);
                if (colorSeleccionado != null) {
                  
                    if (!objetos3D.isEmpty()) {
                        Color nuevoColor = new Color(colorSeleccionado.getRed(), colorSeleccionado.getGreen(), colorSeleccionado.getBlue());
                        objetos3D.get(objetos3D.size() - 1).setColor(nuevoColor);
                        visualizacionPanel.repaint();
                    }
                }
            }
        });

        add(herramientasPanel, BorderLayout.WEST);

        //modelador
        visualizacionPanel = new VisualizacionPanel(objetos3D);
        add(visualizacionPanel, BorderLayout.CENTER);
    }

    private void agregarObjeto(String tipoObjeto) {
        if (tipoObjeto.equals("Esfera")) {
            // ingresar el radio
            String radioStr = JOptionPane.showInputDialog(null, "Ingrese el radio de la esfera:", "Agregar Esfera", JOptionPane.QUESTION_MESSAGE);
            if (radioStr != null && !radioStr.isEmpty()) {
                try {
                    float radio = Float.parseFloat(radioStr);
                    Esfera esfera = new Esfera(100, 100, 0, radio, new Color(255, 0, 0)); // Tamaño, posición y color predeterminados
                    objetos3D.add(esfera);
                    visualizacionPanel.repaint(); // Redibujar para mostrar el nuevo objeto
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El radio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Añadir lógica para otros tipos de objetos si es necesario
        }
    }

    // panel de visualización
    class VisualizacionPanel extends JPanel {
        private ArrayList<Objeto3D> objetos3D;

        public VisualizacionPanel(ArrayList<Objeto3D> objetos3D) {
            this.objetos3D = objetos3D;

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    for (Objeto3D obj : objetos3D) {
                        if (obj instanceof Esfera) {
                            Esfera esfera = (Esfera) obj;
                            int radio = (int) esfera.getRadio();
                            int esferaX = (int) esfera.getX();
                            int esferaY = (int) esfera.getY();
                            if (x >= esferaX && x <= esferaX + radio * 2 && y >= esferaY && y <= esferaY + radio * 2) {
                                esferaSeleccionada = esfera;
                                offsetX = x - esferaX;
                                offsetY = y - esferaY;
                                break;
                            }
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    esferaSeleccionada = null;
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (esferaSeleccionada != null) {
                        int x = e.getX() - offsetX;
                        int y = e.getY() - offsetY;
                        esferaSeleccionada.setX(x);
                        esferaSeleccionada.setY(y);
                        repaint();
                    }
                }
            });
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

            //gradiente radial
            Point2D center = new Point2D.Float(x + radio, y + radio);
            float radius = radio;
            float[] dist = {0.0f, 1.0f};
            java.awt.Color[] colors = {color.brighter(), color.darker()};
            RadialGradientPaint gradient = new RadialGradientPaint(center, radius, dist, colors);

            //esfera con el gradiente
            g2d.setPaint(gradient);
            g2d.fillOval(x, y, radio * 2, radio * 2);
        }
    }
}
