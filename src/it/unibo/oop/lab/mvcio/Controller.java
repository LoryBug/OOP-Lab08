package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * 
 */
public class Controller {
    JFileChooser chooser = new JFileChooser(".");
    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";
    private File dest = new File(HOME + SEPARATOR + DEFAULT_FILE);

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     */
   /* public void setCurrentFile(File file) {
        chooser.setSelectedFile(file);        
    }
    
     /* 2) A method for getting the current File
     */
    public File getCurrentFile() {
        return dest;
        }
    
    /* 3) A method for getting the path (in form of String) of the current File
     */
    
    public String getPath(){
        return dest.getPath();
    }
     /* 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     */
    public void save(final String s) throws IOException {
        try (PrintWriter out = new PrintWriter(dest)){
            out.println(s);
        }      
    }
    
    public void setDestination(final File file) {
        final File parent = file.getParentFile();
        if(parent.exists()) {
            dest = file;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder");
        }
        
    }
    
    public void setDestination(final String file) {
        setDestination(new File(file));
    }

}

