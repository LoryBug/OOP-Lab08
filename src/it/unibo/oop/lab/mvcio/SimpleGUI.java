package it.unibo.oop.lab.mvcio;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import it.unibo.oop.lab.iogui.BadIOGUI;

public final class SimpleGUI {

    private final JFrame frame = new JFrame("Note");

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) It has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextArea with a button "Save" right
     * below (see "ex02.png" for the expected result). SUGGESTION: Use a JPanel with
     * BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The program asks the controller to save the file if the button "Save" gets
     * pressed.
     * 
     * Use "ex02.png" (in the res directory) to verify the expected aspect.
     */

    /**
     * builds a new {@link SimpleGUI}.
     * @throws InterruptedException 
     */
    public SimpleGUI() throws InterruptedException {
        final JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        jp.add(save, BorderLayout.SOUTH);
        jp.add(textArea);
     
        frame.setContentPane(jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        
        //action listener
        save.addActionListener(new ActionListener() {
            public void actionPerformed (final ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(frame, "Do you really want to save?",
                        "Save", JOptionPane.YES_NO_CANCEL_OPTION);
               
            }
        });
    }
    public static void main(final String... args) throws InterruptedException {
        new SimpleGUI();
    }

}

/* 1) Add a JTextField and a button "Browse..." on the upper part of the
* graphical interface.
* Suggestion: use a second JPanel with a second BorderLayout, put the panel
* in the North of the main panel, put the text field in the center of the
* new panel and put the button in the line_end of the new panel.
* 
* 2) The JTextField should be non modifiable. And, should display the
* current selected file.
* 
* 3) On press, the button should open a JFileChooser. The program should
* use the method showSaveDialog() to display the file chooser, and if the
* result is equal to JFileChooser.APPROVE_OPTION the program should set as
* new file in the Controller the file chosen. If CANCEL_OPTION is returned,
* then the program should do nothing. Otherwise, a message dialog should be
* shown telling the user that an error has occurred (use
* JOptionPane.showMessageDialog()).
* 
* 4) When in the controller a new File is set, also the graphical interface
* must reflect such change. Suggestion: do not force the controller to
* update the UI: in this example the UI knows when should be updated, so
* try to keep things separated.
*/

