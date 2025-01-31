import java.util.*;
import java.io.*;

import AwesomeGearBoy.lib.*;
// import classes;      We will need this once we do have classes in the 'classes' folder.

public class Main {
    public static void print() {
        System.out.println();
    }

    public static void print(String x) {
        System.out.println(x);
    }

    public static void print(int x) {
        System.out.println(x);
    }

    public static void printSl(String x) {
        System.out.print(x);
    }

    public static void printSl(int x) {
        System.out.print(x);
    }

    public static void main(String[] args) {
        final String FIRST_TIME_RUN_SAVE_PATH = "savedata/3h7fj46.data";
        final String PASSWORD_SAVE_PATH = "savedata/8c093jl.data";

        AnsiColors ansi = new AnsiColors();
        SaveData save = new SaveData();
        SleepTime sleep = new SleepTime();
        Scanner input = new Scanner(System.in);
        String password = save.loadEncryptedString(PASSWORD_SAVE_PATH, "xxxxxxxx");
        boolean firstTimeRun = save.loadEncryptedBoolean(FIRST_TIME_RUN_SAVE_PATH, true);

        if (firstTimeRun == true) {
            password = randomizePassword();
            print(ansi.red() + ansi.blackBackground() + "PASSWORD TO PROGRAM (MAKE SURE TO WRITE DOWN): " + ansi.purple() + password + ansi.reset());
            save.saveEncryptedString(PASSWORD_SAVE_PATH, password);
            save.saveEncryptedBoolean(FIRST_TIME_RUN_SAVE_PATH, false);
        } else if (firstTimeRun == false) {
            String inp;
            int counter = 1;

            do {
                if (counter >= 6) {
                    print(ansi.red() + ansi.blackBackground() + "Too many attempts!" + ansi.reset());
                    sleep.sleep(800);
                    print(ansi.red() + ansi.blackBackground() + "Closing program..." + ansi.reset());
                    input.close();
                    System.exit(0);
                }

                print("Password: " + password); // Delete this eventually!
                printSl(ansi.yellow() + ansi.blackBackground() + "Enter password:" + ansi.reset() + " ");
                inp = input.nextLine();
                counter += 1;
            } while(!inp.equals(password));
        }

        // TODO: Main code
        print("Main code here!");
    }

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
