package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    public SimpleGUI(Controller controller) {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    controller.writeOnFile(textArea.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
            
        });

        this.frame.setContentPane(panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);

        final Dimension screeSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setSize((int) screeSize.getWidth() / 2, (int) screeSize.getHeight() / 2);
        this.frame.setLocationByPlatform(true);
    }

    public void show() {
        this.frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.show();
    }
}
