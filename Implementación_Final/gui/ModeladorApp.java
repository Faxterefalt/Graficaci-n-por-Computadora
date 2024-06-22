package Implementación_Final.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class ModeladorApp extends JPanel {
    public ModeladorApp() {
        setLayout(new BorderLayout());

        // Panel para las herramientas de modelado
        JPanel herramientasPanel = new JPanel();
        JButton agregarEsferaBtn = new JButton("Agregar Esfera");
        JButton agregarPlanoBtn = new JButton("Agregar Plano");
        JButton agregarLuzBtn = new JButton("Agregar Luz");

        herramientasPanel.add(agregarEsferaBtn);
        herramientasPanel.add(agregarPlanoBtn);
        herramientasPanel.add(agregarLuzBtn);

        add(herramientasPanel, BorderLayout.NORTH);

        // Panel para la visualización del modelador
        JPanel visualizacionPanel = new JPanel();
        add(visualizacionPanel, BorderLayout.CENTER);

        // Eventos para los botones
        agregarEsferaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //agregar una esfera al modelador
            }
        });

        agregarPlanoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // agregar un plano al modelador
            }
        });

        agregarLuzBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // agregar una luz al modelador
            }
        });
    }
}