package AwesomeGearBoy.lib;

import java.awt.*;
import java.io.*;
import java.net.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class simplifies opening up a webpage from the browser by simply allowing you to type in String data with the link.
 */

public class WebControl {
    /**
     * Opens up a webpage in the default browser.
     * @param link The String data to the link of the website.
    */
    public void openWebpage(String link) {
        if (Desktop.isDesktopSupported()) {
            Desktop desk = Desktop.getDesktop();
            try {
                URI uri = new URI(link);
                desk.browse(uri);
            } catch (IOException excp) {
                excp.printStackTrace();
            } catch (URISyntaxException excp) {
                excp.printStackTrace();
            }
        }
    }

    public void openImage(String path, int WindowX, int WindowY) {
        ImageIcon imageIcon = new ImageIcon(path);
        JLabel label = new JLabel(imageIcon);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowX, WindowY);
        
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }

    public void openImage(String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        JLabel label = new JLabel(imageIcon);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}
