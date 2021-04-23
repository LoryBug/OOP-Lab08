package it.unibo.oop.lab.simplegui;

import javax.swing.*;
import java.awt.*;

public class MyPanel {
    
    final JFrame frame = new JFrame("BoxLayout");
    private static final int PROPORTION = 5;
    
    
    public MyPanel(){
     
        final JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp,0));
        final JButton center = new JButton("centro");
        jp.add(center, BorderLayout.CENTER);
        frame.setContentPane(jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
        
    private void display() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
   
    
    
    
    public static void main(String[] args) {
        new MyPanel().display();
        
    }
























}