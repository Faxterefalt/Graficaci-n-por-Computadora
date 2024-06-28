import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import componentes.objetos3D.Objeto3D;
import raytracing.Camara;
import raytracing.Escena;
import raytracing.RayTracer;
import java.util.ArrayList;

public class RayTracingApp extends JPanel {
    private JButton ejecutarBtn;
    private ArrayList<Objeto3D> objetos3D;

    public RayTracingApp(ArrayList<Objeto3D> objetos3D) {
        this.objetos3D = objetos3D;
        setLayout(new BorderLayout());

        ejecutarBtn = new JButton("Ejecutar RayTracing");
        ejecutarBtn.addActionListener(e -> renderizarImagen());
        add(ejecutarBtn, BorderLayout.CENTER);
    }

    private void renderizarImagen() {
        // Crear una escena y agregar los objetos 3D actuales
        Escena escena = new Escena();
        for (Objeto3D obj : objetos3D) {
            escena.agregarObjeto(obj);
        }

        // Configurar la cámara
        Camara camara = new Camara(0, 0, -5, 0, 0, 0); // Ajustar posición y dirección de la cámara según sea necesario

        // Crear el raytracer y renderizar la imagen
        RayTracer rayTracer = new RayTracer(escena, camara);
        BufferedImage imagen = rayTracer.renderizar(800, 600);

        // Guardar la imagen como un archivo .png
        try {
            ImageIO.write(imagen, "png", new File("output.png"));
            JOptionPane.showMessageDialog(this, "Imagen generada correctamente: output.png", "RayTracing Completado", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
