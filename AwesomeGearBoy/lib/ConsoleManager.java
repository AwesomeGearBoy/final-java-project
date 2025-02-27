package AwesomeGearBoy.lib;

/**
 * If you are like me, you dont want to constantly write {@code System.out.println()} every time you want to print to the console. Too much writing. We're programmers. We're lazy.
 * <p> The fix? Using the {@code Console} class.
 * 
 * <p>For example:
 * 
 * {@snippet :
 *     import AwesomeGearBoy.lib.*;
 * 
 *     public class HelloWorld {
 *         Console cons = new Console();
 *      
 *         cons.print("Hello, world!"); // Prints a new line, just like System.out.println()
 *         // To print normally, like System.out.print(), use Console.printSl(), which stands for "Print Same Line"
 *     }
 * }
 * 
 * <p> Enjoy using the easy way to print!
 */
public class ConsoleManager {
    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print() {
        System.out.println();
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(String x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(char x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(int x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(long x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(double x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(float x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(boolean x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void print(Object x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(String x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(char x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(int x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(long x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(double x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(float x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(boolean x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public void printSl(Object x) {
        System.out.print(x);
    }

    /**
     * Adds an indent to text.
     * @return An indent
     */
    public String indent() {
        int indentLevel = 4;
        String indent = "";
        for (int i = 0; i < indentLevel; i++) {
            indent += " ";
        }
        return indent;
    }
}
