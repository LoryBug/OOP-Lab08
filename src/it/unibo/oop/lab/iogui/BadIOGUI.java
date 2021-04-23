package it.unibo.oop.lab.iogui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.io.input.ReaderInputStream;

/**
 * This class is a simple application that writes a random number on a file.
 * 
 * This application does not exploit the model-view-controller pattern, and as
 * such is just to be used to learn the basics, not as a template for your
 * applications.
 */
public class BadIOGUI {

    private static final String TITLE = "A very simple GUI application";
    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + BadIOGUI.class.getSimpleName() + ".txt";
    private static final int PROPORTION = 5;
    private final Random rng = new Random();
    private final JFrame frame = new JFrame(TITLE);
    private Path path = Paths.get(PATH);
    

    /**
     * 
     */
    public BadIOGUI() {
       // final JPanel canvas = new JPanel();
        //canvas.setLayout(new BorderLayout());
        final JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, 0));
        final JButton write = new JButton("Write on file");
        jp.add(write, BorderLayout.CENTER);
        final JButton read = new JButton("Read");
        jp.add(read, BorderLayout.CENTER);
        frame.setContentPane(jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                
                try (PrintStream ps = new PrintStream(PATH)) {
                    ps.print(rng.nextInt());
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });
        
        read.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                List<String> lines = null;
                try {
                    lines = Files.readAllLines(path);
                } catch (IOException e1) {
                                       e1.printStackTrace();
                }
                lines.forEach(System.out::println);

                
            }
        });
        
    }

    private void display() {

       // final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        //final int sw = (int) screen.getWidth();
        //final int sh = (int) screen.getHeight();
        //frame.setSize(sw / PROPORTION, sh / PROPORTION);
       
       
        frame.setLocationByPlatform(true);
        
        
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(final String... args) {
       new BadIOGUI().display();
    }
}
