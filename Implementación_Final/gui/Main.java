package Implementación_Final.gui;
import javax.swing.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ray Tracing Modelador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel modeladorPanel = new ModeladorApp();
        JPanel rayTracingPanel = new RayTracingApp();

        frame.setLayout(new BorderLayout());
        frame.add(modeladorPanel, BorderLayout.WEST);
        frame.add(rayTracingPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }
}