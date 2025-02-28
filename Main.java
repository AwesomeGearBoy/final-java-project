import java.util.*;

import AwesomeGearBoy.lib.*;
import classes.*;

public class Main {
    public static void main(String[] args) {
        // Save paths
        final String FIRST_TIME_RUN_SAVE_PATH = "savedata/system/3h7fj46.data";
        final String PASSWORD_SAVE_PATH = "savedata/system/8c093jl.data";

        // Constant Strings
        final String ADMIN_PASSWORD = "sf,om234";

        // Drewski's library
        ConsoleManager cons = new ConsoleManager();
        AnsiColors ansi = new AnsiColors();
        SaveData save = new SaveData();
        SleepTime sleep = new SleepTime();

        // Java utitlities
        Scanner input = new Scanner(System.in);

        // Strings
        String password = save.loadEncryptedString(PASSWORD_SAVE_PATH, "xxxxxxxx"); // Load the password. If file does not exist, the default value is "xxxxxxxx"

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
                    cons.print(ansi.red() + ansi.blackBackground() + "Too many attempts!" + ansi.reset());
                    sleep.sleep(800); // Let them read the mistake they've made
                    cons.print(ansi.red() + ansi.blackBackground() + "Closing program..." + ansi.reset());
                    input.close(); // Close input
                    System.exit(0); // Exit program
                }

                cons.printSl(ansi.yellow() + ansi.blackBackground() + "Enter password:" + ansi.reset() + " "); // Ask for input
                inp = input.nextLine(); // Get input

                if (inp.equals(save.unencryptString(ADMIN_PASSWORD))) { // If admin password is entered, reset password
                    password = resetPassword();
                } else if (!inp.equals(password) && !inp.equals(ADMIN_PASSWORD)) { // Else add to counter and print message
                    counter += 1; // Add to counter
                    if (counter < 6) { // Only print attempts if there are attempts left
                        cons.print(ansi.red() + ansi.blackBackground() + "Incorrect password entered. " + (6 - counter) + " attempts left." + ansi.reset());
                    }
                }
            } while(!inp.equals(password) && !inp.equals(save.unencryptString(ADMIN_PASSWORD))); // Repeat if input is not equal to password
        }

        do {
            int choice;
            // Main menu
            cons.print(ansi.purple() + ansi.blackBackground() + "\nPlease make a selection for what to do:" + ansi.reset());
            cons.print(ansi.blackBackground() + "1. Astronauts menu" + ansi.reset());
            cons.print(ansi.blackBackground() + "2. Spaceship menu" + ansi.reset());
            cons.print(ansi.blackBackground() + "3. Show credits" + ansi.reset());
            cons.print(ansi.blackBackground() + "4. Quit program" + ansi.reset());
            cons.printSl(ansi.yellow() + ansi.blackBackground() + "Please make a selection:" + ansi.reset() + " ");

            while (!input.hasNextInt()) {  // Validate integer input
                cons.printSl(ansi.red() + ansi.blackBackground() + "Invalid input. Please make a selection:" + ansi.reset() + " ");
                input.next(); // Consume invalid input
            }
            choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) { // Switch between menues
                case 1:
                    AstroManager astro = new AstroManager(input, cons);
                    astro.showMenu();
                    break;
                case 2:
                    SpaceshipManager ship = new SpaceshipManager(input, cons);
                    ship.showMenu();
                    break;
                case 3:
                    // Credits
                    cons.print(ansi.green() + ansi.blackBackground() + "\nPrograming done by: Drew \"Drewki\" Schroeder and Teagen Revercomb" + ansi.reset());
                    cons.print(ansi.blue() + ansi.blackBackground() + "Graphics done by: Kiefer Beck" + ansi.reset());
                    cons.print(ansi.red() + ansi.blackBackground() + "UML Diagram done by: Jon Rotunno" + ansi.reset());
                    break;
                case 4:
                    cons.print(ansi.green() + ansi.blackBackground() + "Goodbye!" + ansi.reset()); // 
                    input.close(); // Close scanner
                    System.exit(0); // Exit
                    break;
                default:
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid option. Please try again." + ansi.reset()); // Validate input
                    break;
            }
        } while (true);
    }

    /**
     * If necessary, resets the password and creates a new one
     * @return New password
     */
    private static String resetPassword() {
        ConsoleManager cons = new ConsoleManager();
        final String PASSWORD_SAVE_PATH = "savedata/system/8c093jl.data"; // Password save path
        AnsiColors ansi = new AnsiColors(); // Instantiate AnsiColors
        SaveData save = new SaveData(); // Instantiate Savedata

        String newPassword = randomizePassword(); // Randomizes the new password

        // Print out new password so that user can write it down.
        cons.print(ansi.red() + ansi.blackBackground() + "PASSWORD TO PROGRAM (MAKE SURE TO WRITE DOWN): " + ansi.purple() + newPassword + ansi.reset());
        
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
