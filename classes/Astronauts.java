package classes;

import java.util.*;

public class Astronauts {
    String name;
    String birthday; // XX/XX/XXXX
    int serial; // Auto incremented
    String address;
    String email; // Must contain @
    String phone; // (XXX)XXX-XXXX
    double payRate; // $X,XXX.XX
    double weight; // In pounds
    String[] children;
    int statis; // (1 = In Space) (2 = On Earth)
    Scanner input;

    public Astronauts(Scanner input) {
        this.input = input;
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public static void print() {
        System.out.println();
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public static void print(String x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public static void print(int x) {
        System.out.println(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public static void printSl(String x) {
        System.out.print(x);
    }

    /**
     * Simplifies printing to console.
     * @param x String to be printed
     */
    public static void printSl(int x) {
        System.out.print(x);
    }

    public void showMenu() {
        boolean menuRunning = true;
        int choice;

        do {
            print("1. Add an astronaut");
            print("2. Edit an astronaut");
            print("3. Delete an astronaut");
            print("4. Back to main menu");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    // TODO: addAstronaut()
                    break;
                case 2:
                    // TODO: editAstronaut()
                    break;
                case 3:
                    // TODO: deleteAstronaut()
                    break;
                case 4:
                    menuRunning = false;
                    break;
                default:
                    print("Invalid option. Please try again.");
                    break;
            }
        } while(menuRunning);
    }

    private void addAstronaut() {

    }

    private void editAstronaut() {

    }

    private void deleteAstronaut() {
        
    }
}
