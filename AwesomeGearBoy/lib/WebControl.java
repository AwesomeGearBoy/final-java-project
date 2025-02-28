package AwesomeGearBoy.lib;

import java.awt.*;
import java.io.*;
import java.net.*;

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

    /**
     * Opens a file in your project. Any file.
     * @param filePath
     */
    public void openFile(String filePath) {
        if (Desktop.isDesktopSupported()) {
            Desktop desk = Desktop.getDesktop();
            try {
                File file = new File(filePath);
                if (file.exists()) {
                    desk.open(file);
                } else {
                    System.out.println("File not found: " + filePath);
                }
            } catch (IOException excp) {
                excp.printStackTrace();
            }
        }
    }
}
