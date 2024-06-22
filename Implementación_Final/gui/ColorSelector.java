
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorSelector {
    public void showDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Seleccionar Color");
        dialog.setSize(600, 400);
        dialog.setLayout(new BorderLayout());

        // Panel de selección de colores RGB
        JColorChooser colorChooser = new JColorChooser();
        dialog.add(colorChooser, BorderLayout.CENTER);

        // Panel de selección de colores CMYK
        JPanel cmykPanel = createCMYKPanel();
        dialog.add(cmykPanel, BorderLayout.SOUTH);

        // Botón de selección
        JButton selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = colorChooser.getColor();
                // Aquí puedes hacer algo con el color seleccionado RGB
                System.out.println("Color RGB seleccionado: " + selectedColor);

                // Obtén el color CMYK seleccionado
                Color cmykColor = getCMYKColorFromInputs(cmykPanel);
                if (cmykColor != null) {
                    System.out.println("Color CMYK seleccionado: " + cmykColor);
                }

                dialog.dispose();
            }
        });

        dialog.add(selectButton, BorderLayout.NORTH);

        dialog.setModal(true);
        dialog.setVisible(true);
    }

    private JPanel createCMYKPanel() {
        JPanel cmykPanel = new JPanel();
        cmykPanel.setLayout(new GridLayout(5, 2));

        JLabel cLabel = new JLabel("C: ");
        JTextField cField = new JTextField();
        JLabel mLabel = new JLabel("M: ");
        JTextField mField = new JTextField();
        JLabel yLabel = new JLabel("Y: ");
        JTextField yField = new JTextField();
        JLabel kLabel = new JLabel("K: ");
        JTextField kField = new JTextField();

        cmykPanel.add(cLabel);
        cmykPanel.add(cField);
        cmykPanel.add(mLabel);
        cmykPanel.add(mField);
        cmykPanel.add(yLabel);
        cmykPanel.add(yField);
        cmykPanel.add(kLabel);
        cmykPanel.add(kField);

        return cmykPanel;
    }

    private Color getCMYKColorFromInputs(JPanel cmykPanel) {
        Component[] components = cmykPanel.getComponents();
        double c = 0, m = 0, y = 0, k = 0;
        try {
            c = Double.parseDouble(((JTextField) components[1]).getText()) / 100.0;
            m = Double.parseDouble(((JTextField) components[3]).getText()) / 100.0;
            y = Double.parseDouble(((JTextField) components[5]).getText()) / 100.0;
            k = Double.parseDouble(((JTextField) components[7]).getText()) / 100.0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese valores válidos para CMYK.");
            return null;
        }

        int r = (int) ((1 - c) * (1 - k) * 255);
        int g = (int) ((1 - m) * (1 - k) * 255);
        int b = (int) ((1 - y) * (1 - k) * 255);

        return new Color(r, g, b);
    }
}

