package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

/**
 * This class is a simple application that writes a random number on a file.
 * 
 * This application does not exploit the model-view-controller pattern, and as
 * such is just to be used to learn the basics, not as a template for your
 * applications.
 * 
 * PATH was changed in order to put .txt in a place where is more accesible
 */
public class BadIOGUI {

    private static final String TITLE = "A very simple GUI application";
    // private static final String PATH = System.getProperty("user.home")
    // + File.separator
    // + BadIOGUI.class.getSimpleName() + ".txt";
    private static final String PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator
            + BadIOGUI.class.getSimpleName() + ".txt";
    private static final int PROPORTION = 5;
    private final Random randomGenerator = new Random();
    private final JFrame frame = new JFrame(TITLE);

    /**
     * Creates a new BadIOGUI.
     */
    public BadIOGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JButton write = new JButton("Write on file");
        canvas.add(write, BorderLayout.CENTER);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Ex 01.01
         */
        final JPanel horzPanel = new JPanel();
        horzPanel.setLayout(new BoxLayout(horzPanel, BoxLayout.LINE_AXIS));
        frame.remove(canvas);
        frame.setContentPane(horzPanel);
        horzPanel.add(write, BoxLayout.X_AXIS);
        /*
         * Ex 01.02
         */
        final JButton read = new JButton("Read");
        horzPanel.add(read);
        read.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try (final BufferedReader br = new BufferedReader(new FileReader(PATH))) {
                    System.out.println(br.readLine());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, "Scrivere il file prima di leggerlo", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        /*
         * Handlers
         */
        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                /*
                 * This would be VERY BAD in a real application.
                 * 
                 * This makes the Event Dispatch Thread (EDT) work on an I/O
                 * operation. I/O operations may take a long time, during which
                 * your UI becomes completely unresponsive.
                 */
                try (PrintStream ps = new PrintStream(PATH, StandardCharsets.UTF_8)) {
                    ps.print(randomGenerator.nextInt());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
        });
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
        frame.pack();
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
        new BadIOGUI().display();
    }
}
