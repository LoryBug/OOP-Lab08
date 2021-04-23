package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;
import it.unibo.oop.lab.mvcio.SimpleGUI;



public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame("Note");
    
    public static void main(final String... args) {
 
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        
    }

    /*
     * TODO: Starting from the application in mvcio:
     */
    public SimpleGUIWithFileChooser(final Controller ctrl) {
        
        
//JPanel1
        final JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        jp.add(save, BorderLayout.SOUTH);
        jp.add(textArea,BorderLayout.CENTER );
//JPanel2
        final JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        final JTextField textField = new JTextField(ctrl.getPath());
        final JButton browse = new JButton("Browse..");
        jp2.add(browse, BorderLayout.LINE_END);
        jp2.add(textField, BorderLayout.CENTER);
        jp.add(jp2,BorderLayout.NORTH);
 //frame
        frame.setContentPane(jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        ;
        
 //action listener
        save.addActionListener(new ActionListener() {
            public void actionPerformed (final ActionEvent e) {
                try {
                    ctrl.save(textArea.getText());
                } catch(IOException exc) {
                    
                    JOptionPane.showMessageDialog(null, exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        
        browse.addActionListener(new ActionListener (){
            public void actionPerformed (final ActionEvent e ) {
                final JFileChooser fc = new JFileChooser("Choose where to save");   
                fc.setSelectedFile(ctrl.getCurrentFile());
                final int result = fc.showSaveDialog(frame);
                switch (result) {
                case JFileChooser.APPROVE_OPTION:
                    final File newDest = fc.getSelectedFile();
                    ctrl.setDestination(newDest);
                    textField.setText(newDest.getPath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, result, "Meh!", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

       

        
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

}
