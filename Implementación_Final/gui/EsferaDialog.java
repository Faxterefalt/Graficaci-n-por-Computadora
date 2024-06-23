import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import raytracing.Color;
import componentes.objetos3D.Esfera;

public class EsferaDialog extends JDialog {
    private JTextField radioField;
    private JTextField posXField;
    private JTextField posYField;
    private JTextField posZField;
    private JColorChooser colorChooser;
    private boolean confirmed = false;

    public EsferaDialog() {
        setTitle("Agregar Esfera");
        setSize(600, 600);
        setLayout(new BorderLayout());

        JPanel fieldsPanel = new JPanel(new GridLayout(4, 2));
        
        fieldsPanel.add(new JLabel("Radio:"));
        radioField = new JTextField();
        fieldsPanel.add(radioField);

        fieldsPanel.add(new JLabel("Posición X:"));
        posXField = new JTextField();
        fieldsPanel.add(posXField);

        fieldsPanel.add(new JLabel("Posición Y:"));
        posYField = new JTextField();
        fieldsPanel.add(posYField);

        fieldsPanel.add(new JLabel("Posición Z:"));
        posZField = new JTextField();
        fieldsPanel.add(posZField);

        add(fieldsPanel, BorderLayout.NORTH);

        colorChooser = new JColorChooser();
        add(colorChooser, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton confirmarBtn = new JButton("Confirmar");
        confirmarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = true;
                setVisible(false);
            }
        });
        buttonPanel.add(confirmarBtn);

        JButton cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                setVisible(false);
            }
        });
        buttonPanel.add(cancelarBtn);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public Esfera createEsfera() {
        float radio = Float.parseFloat(radioField.getText());
        float posX = Float.parseFloat(posXField.getText());
        float posY = Float.parseFloat(posYField.getText());
        float posZ = Float.parseFloat(posZField.getText());
        java.awt.Color awtColor = colorChooser.getColor();
        Color color = new Color(awtColor.getRed(), awtColor.getGreen(), awtColor.getBlue());

        return new Esfera(posX, posY, posZ, radio, color);
    }
}
