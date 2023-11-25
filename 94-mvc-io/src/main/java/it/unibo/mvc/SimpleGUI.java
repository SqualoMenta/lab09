package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller cntr = new SimpleController();

    public SimpleGUI() {
        final JTextField title = new JTextField();
        final JTextArea body = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");
        final JPanel pane = new JPanel(new BorderLayout());
        final JPanel endPage = new JPanel(new BorderLayout());

        pane.add(title, BorderLayout.NORTH);
        pane.add(body, BorderLayout.CENTER);
        endPage.add(showHistory, BorderLayout.LINE_START);
        endPage.add(print, BorderLayout.LINE_END);
        pane.add(endPage, BorderLayout.SOUTH);
        frame.add(pane);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 3, sh / 3);

        title.setVisible(true);
        body.setVisible(true);
        print.setVisible(true);
        showHistory.setVisible(true);
        endPage.setVisible(true);
        pane.setVisible(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(e -> {
            cntr.setString(title.getText());
            cntr.print();
        });
        showHistory.addActionListener(e -> {
            for (String i : cntr.getHistory()) {
                body.append(i + '\n');
            }
        });
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }

}
