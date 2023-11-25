package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("SimpleGui");
    private final Controller cntr = new Controller();

    public SimpleGUI() {
        JTextArea txt = new JTextArea();
        JButton save = new JButton("Save");
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(txt, BorderLayout.CENTER);
        pane.add(save, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 3, sh / 3);

        save.addActionListener(e -> {
            try {
                cntr.printOnFile(txt.getText());
            } catch (IOException a) {
                System.err.println(a.getMessage());
            }
            return;
        });

        save.setVisible(true);
        txt.setVisible(true);
        pane.setVisible(true);
        frame.add(pane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }

}
