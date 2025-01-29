package AwesomeGearBoy.lib;

/**
 * This object allows you to customize colors used in printing out text in the terminal by using ANSI Color Codes.
 * <p>
 * Call to the color and/or background, and all text after it will be that color/background.
 * <p>
 * After done with those colors, be sure to reset!
 * 
 * <p>For example:
 * {@snippet :
 *      public class HelloWorld {
 *          public static void main(String[] args) {
 *              AnsiColors ansi = new AnsiColors;
 *              System.out.println(ansi.yellow() + ansi.blackBackground() + "Hello, World!" + ansi.reset());
 *          }
 *      }
 * }
 * 
 * <p>This will print out a message saying "Hello, World!"
 * <p>Only difference is that it will be yellow with a black background.
 * <p>Enjoy!
*/

public class AnsiColors {
    /**
     * Resets the color of the text.
    */
    public String reset() {
        final String ANSI_RESET = "\u001B[0m";
        return ANSI_RESET;
    }


    /**
     * Changes the color of the text to black.
    */
    public String black() {
        final String ANSI_BLACK = "\u001B[30m";
        return ANSI_BLACK;
    }

    /**
     * Changes the color of the text to red.
    */
    public String red() {
        final String ANSI_RED = "\u001B[31m";
        return ANSI_RED;
    }

    /**
     * Changes the color of the text to green.
    */
    public String green() {
        final String ANSI_GREEN = "\u001B[32m";
        return ANSI_GREEN;
    }

    /**
     * Changes the color of the text to yellow.
    */
    public String yellow() {
        final String ANSI_YELLOW = "\u001B[33m";
        return ANSI_YELLOW;
    }

    /**
     * Changes the color of the text to blue.
    */
    public String blue() {
        final String ANSI_BLUE = "\u001B[34m";
        return ANSI_BLUE;
    }

    /**
     * Changes the color of the text to purple.
    */
    public String purple() {
        final String ANSI_PURPLE = "\u001B[35m";
        return ANSI_PURPLE;
    }

    /**
     * Changes the color of the text to cyan.
    */
    public String cyan() {
        final String ANSI_CYAN = "\u001B[36m";
        return ANSI_CYAN;
    }

    /**
     * Changes the color of the text to white.
    */
    public String white() {
        final String ANSI_WHITE = "\u001B[37m";
        return ANSI_WHITE;
    }


    /**
     * Changes the color of the background of the text to black.
    */
    public String blackBackground() {
        final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        return ANSI_BLACK_BACKGROUND;
    }

    /**
     * Changes the color of the background of the text to red.
    */
    public String redBackground() {
        final String ANSI_RED_BACKGROUND = "\u001B[41m";
        return ANSI_RED_BACKGROUND;
    }

    /**
     * Changes the color of the background of the text to green.
    */
    public String greenBackground() {
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        return ANSI_GREEN_BACKGROUND;
    }

    /**
     * Changes the color of the background of the text to yellow.
    */
    public String yellowBackground() {
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        return ANSI_YELLOW_BACKGROUND;
    }

    /**
     * Changes the color of the background of the text to blue.
    */
    public String blueBackground() {
        final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        return ANSI_BLUE_BACKGROUND;
    }

    /**
     * Changes the color of the background of the text to purple.
    */
    public String purpleBackground() {
        final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        return ANSI_PURPLE_BACKGROUND;
    }

    /**
     * Changes the color of the background of the text to cyan.
    */
    public String cyanBackground() {
        final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        return ANSI_CYAN_BACKGROUND;
    }
    
    /**
     * Changes the color of the background of the text to white.
    */
    public String whiteBackground() {
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        return ANSI_WHITE_BACKGROUND;
    }
}
