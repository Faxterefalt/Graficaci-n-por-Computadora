import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import componentes.objetos3D.Objeto3D;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ray Tracing Modelador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);  
        
        // Crear la lista de objetos 3D compartida
        ArrayList<Objeto3D> objetos3D = new ArrayList<>();
        
        // Crear instancias de los paneles, pasando la lista compartida
        JPanel modeladorPanel = new ModeladorApp(objetos3D);
        JPanel rayTracingPanel = new RayTracingApp(objetos3D); 
        
        frame.setLayout(new BorderLayout());
        frame.add(modeladorPanel, BorderLayout.CENTER);
        frame.add(rayTracingPanel, BorderLayout.EAST); 
        frame.setVisible(true);
    }
}
