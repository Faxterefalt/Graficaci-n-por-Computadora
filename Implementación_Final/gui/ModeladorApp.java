package Implementación_Final.gui;

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
import java.awt.Color;
import Implementación_Final.componentes.objetos3D.Objeto3D;


public class ModeladorApp extends JPanel {
    private JPanel herramientasPanel;
    private JPanel visualizacionPanel;
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

        add(herramientasPanel, BorderLayout.WEST);

        colorPickerBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Color colorSeleccionado = JColorChooser.showDialog(null, "Seleccione un Color", Color.WHITE);
        if (colorSeleccionado != null) {
            // Aquí podrías establecer el color del último objeto agregado o de uno seleccionado
            // Esto es solo un ejemplo, necesitarías una forma de seleccionar un objeto específico
            if (!objetos3D.isEmpty()) {
                objetos3D.get(objetos3D.size() - 1).setColor(colorSeleccionado);
                visualizacionPanel.repaint();
            }
        }
    }
});

        // Panel para la visualización del modelador
        visualizacionPanel = new VisualizacionPanel();
        add(visualizacionPanel, BorderLayout.CENTER);
    }

    private void agregarObjeto(String tipoObjeto) {
        objetos3D.add(new Objeto3D(tipoObjeto, Color.WHITE)); // Color por defecto
        visualizacionPanel.repaint(); // Redibujar para mostrar el nuevo objeto
    }

    // Clase interna para el panel de visualización
    class VisualizacionPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar objetos 3D aquí
        }
    }
}