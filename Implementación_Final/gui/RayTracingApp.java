package Implementación_Final.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class RayTracingApp extends JPanel {
    private JLabel imagenLabel;

    public RayTracingApp() {
        setLayout(new BorderLayout());

        // Botón para iniciar el ray tracing
        JButton renderizarBtn = new JButton("Ejecutar Ray Tracing");
        add(renderizarBtn, BorderLayout.NORTH);

        // Etiqueta para mostrar la imagen renderizada
        imagenLabel = new JLabel();
        add(imagenLabel, BorderLayout.CENTER);

        // Evento para el botón de renderizado
        renderizarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ejecutar el ray tracing y mostrar la imagen resultante
                BufferedImage imagen = renderizarImagen();
                if (imagen != null) {
                    imagenLabel.setIcon(new ImageIcon(imagen));
                }
            }
        });
    }

    private BufferedImage renderizarImagen() {
        // Crear una escena y agregar objetos
        Escena escena = new Escena();
        // ... agregar objetos a la escena ...

        // Crear el ray tracer y renderizar la escena
        RayTracer rayTracer = new RayTracer(escena);
        return rayTracer.renderizar(400, 300); // Tamaño de la imagen de salida
    }
}