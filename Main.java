import java.util.*;
import java.io.*;

import AwesomeGearBoy.lib.*;
// import classes;      We will need this once we do have classes in the 'classes' folder.

public class Main {
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

    public static void main(String[] args) {
        // Save paths
        final String FIRST_TIME_RUN_SAVE_PATH = "savedata/3h7fj46.data";
        final String PASSWORD_SAVE_PATH = "savedata/8c093jl.data";

        // Constant Strings
        final String ADMIN_PASSWORD = "admin123";

        // Constant Integers
        // Constant Doubles
        // Constant Floats
        // Constant Booleans

        // Drewski's library
        AnsiColors ansi = new AnsiColors();
        SaveData save = new SaveData();
        SleepTime sleep = new SleepTime();

        // Java utitlities
        Scanner input = new Scanner(System.in);

        // Strings
        String password = save.loadEncryptedString(PASSWORD_SAVE_PATH, "xxxxxxxx"); // Load the password. If file does not exist, the default value is "xxxxxxxx"

        // Integers
        // Doubles
        // Floats

        // Booleans
        boolean firstTimeRun = save.loadEncryptedBoolean(FIRST_TIME_RUN_SAVE_PATH, true); // Load if it is the first time ran. If file does not exist, it assumes that it is the first time running the program.

        // Main code begins here

        // Password control
        if (firstTimeRun == true) { // If first run is true, create a new password
            password = resetPassword();
            save.saveEncryptedBoolean(FIRST_TIME_RUN_SAVE_PATH, false); // Save new password to file
        } else if (firstTimeRun == false) { // Else look for password
            String inp; // String for user's input
            int counter = 1; // Counter for number of attempts

            do {
                if (counter >= 6) { // If five attempts are passed, close the program
                    print(ansi.red() + ansi.blackBackground() + "Too many attempts!" + ansi.reset());
                    sleep.sleep(800); // Let them read the mistake they've made
                    print(ansi.red() + ansi.blackBackground() + "Closing program..." + ansi.reset());
                    input.close(); // Close input
                    System.exit(0); // Exit program
                }

                print("Password: " + password); // TODO: Delete this eventually!
                printSl(ansi.yellow() + ansi.blackBackground() + "Enter password:" + ansi.reset() + " "); // Ask for input
                inp = input.nextLine(); // Get input

                if (inp.equals(ADMIN_PASSWORD)) { // If admin password is entered, reset password
                    password = resetPassword();
                } else if (!inp.equals(password) && !inp.equals(ADMIN_PASSWORD)) { // Else add to counter and print message
                    counter += 1; // Add to counter
                    if (counter < 6) { // Only print attempts if there are attempts left
                        print(ansi.red() + ansi.blackBackground() + "Incorrect password entered. " + (6 - counter) + " attempts left." + ansi.reset());
                    }
                }
            } while(!inp.equals(password) && !inp.equals(ADMIN_PASSWORD)); // Repeat if input is not equal to password
        }

        // TODO: Main code
        print("Main code here!");
    }

    /**
     * If necessary, resets the password and creates a new one
     * @return New password
     */
    private static String resetPassword() {
        final String PASSWORD_SAVE_PATH = "savedata/8c093jl.data"; // Password save path
        AnsiColors ansi = new AnsiColors(); // Instantiate AnsiColors
        SaveData save = new SaveData(); // Instantiate Savedata

        String newPassword = randomizePassword(); // Randomizes the new password

        // Print out new password so that user can write it down.
        print(ansi.red() + ansi.blackBackground() + "PASSWORD TO PROGRAM (MAKE SURE TO WRITE DOWN): " + ansi.purple() + newPassword + ansi.reset());
        
        save.saveEncryptedString(PASSWORD_SAVE_PATH, newPassword); // Save new password to file
        return newPassword; // Return new password
    }

    /**
     * Randomizes an 8 character string to serve as a password
     * @return A random password.
     */
    private static String randomizePassword() {
        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Character set
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length()); // Generate a random index
            randomString.append(chars.charAt(randomIndex)); // Append the character at that index
        }
        
        return randomString.toString();
    }
}
