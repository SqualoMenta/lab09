package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("SimpleGUIWithFileChoser");
    private final Controller cntr = new Controller();

    public SimpleGUIWithFileChooser() {
        JTextField txt = new JTextField();
        JTextArea printedOnFile = new JTextArea();
        JButton browse = new JButton("Browse");
        JPanel canvas = new JPanel(new BorderLayout());
        JPanel secondJPanel = new JPanel(new BorderLayout());
        JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(printedOnFile, BorderLayout.CENTER);
        canvas.add(secondJPanel, BorderLayout.NORTH);
        secondJPanel.add(txt, BorderLayout.CENTER);
        secondJPanel.add(browse, BorderLayout.LINE_END);
        txt.setEditable(false);
        txt.setText(cntr.getPath());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 3, sh / 3);

        save.setVisible(true);
        txt.setVisible(true);
        browse.setVisible(true);
        secondJPanel.setVisible(true);
        canvas.setVisible(true);
        frame.setVisible(true);

        browse.addActionListener(e -> {
            JFileChooser fileChose = new JFileChooser();
            int saveDialog = fileChose.showSaveDialog(frame);
            if (saveDialog == JFileChooser.APPROVE_OPTION) {
                cntr.setFile(fileChose.getSelectedFile());
                txt.setText(cntr.getPath());
            } else if (saveDialog != JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(secondJPanel, "An error has occurred", "WRONG",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        save.addActionListener(e -> {
            try {
                cntr.printOnFile(printedOnFile.getText());
            } catch (IOException a) {
                System.err.println(a.getMessage());
            }
            return;
        });
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser();
    }

}
