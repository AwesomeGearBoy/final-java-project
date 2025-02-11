package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

public class AstroManager {
    final String COUNT_SAVE_PATH = "savedata/astrodata/7dnb39dp.data";
    Scanner input = new Scanner(System.in);
    SaveData save = new SaveData();
    Astronauts[] astro = new Astronauts[15];
    int count = save.loadEncryptedInt(COUNT_SAVE_PATH, 0);

    public AstroManager(Scanner input) {
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

        if (count < astro.length) {
            // TODO: Do stuff here. Look at Chapter 8.
        }
    }

    private void editAstronaut() {
        // pass
    }

    private void deleteAstronaut() {
        // pass
    }
}
