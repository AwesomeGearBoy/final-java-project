package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

public class AstroManager {
    final String COUNT_SAVE_PATH = "savedata/astrodata/7dnb39dp.data";
    Scanner input;
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
                    addAstronaut();
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
        Random rand = new Random();
        
        if (count >= astro.length) {
            print("Astronaut capacity reached.");
            return;
        }
    
        print("Enter new astronaut's name: ");
        String name = input.nextLine();
    
        String birthday;
        while (true) {
            print("Enter new astronaut's birthday (XX/XX/XXXX): ");
            birthday = input.nextLine();
    
            if (birthday.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                print("Your input is invalid. Please try again.");
            }
        }
        
        int serial;
        do {
            serial = rand.nextInt(10000); // Generates 0000-9999
        } while (serial < 1000);
    
        print("Enter astronaut's address: ");
        String address = input.nextLine();
    
        String email;
        while (true) {
            print("Enter astronaut's email: ");
            email = input.nextLine();
            if (email.contains("@")) {
                break;
            } else {
                print("Invalid email. Try again.");
            }
        }
    
        String phone;
        while (true) {
            print("Enter astronaut's phone ((XXX)XXX-XXXX): ");
            phone = input.nextLine();
            if (phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                break;
            } else {
                print("Invalid phone format. Try again.");
            }
        }
    
        print("Enter astronaut's pay rate (e.g., 1500.50): ");
        double payRate = input.nextDouble();
        input.nextLine(); // Consume newline
    
        print("Enter astronaut's weight in pounds: ");
        double weight = input.nextDouble();
        input.nextLine(); // Consume newline
    
        print("Enter number of children: ");
        int numChildren = input.nextInt();
        input.nextLine(); // Consume newline
    
        String[] children = new String[numChildren];
        for (int i = 0; i < numChildren; i++) {
            print("Enter name of child #" + (i + 1) + ": ");
            children[i] = input.nextLine();
        }
    
        print("Enter astronaut's status (1 = In Space, 2 = On Earth): ");
        int statis = input.nextInt();
        input.nextLine(); // Consume newline
    
        astro[count] = new Astronauts(name, birthday, serial, address, email, phone, payRate, weight, children, statis);
        count++;
        save.saveEncryptedInt(COUNT_SAVE_PATH, count);
        save.saveEncryptedString("savedata/astrodata/astro" + count, name);
        save.saveEncryptedString("savedata/astrodata/astro" + count, birthday);
        save.saveEncryptedInt("savedata/astrodata/astro" + count, serial);
        save.saveEncryptedString("savedata/astrodata/astro" + count, address);
        save.saveEncryptedString("savedata/astrodata/astro" + count, email);
        save.saveEncryptedString("savedata/astrodata/astro" + count, phone);
        save.saveEncryptedDouble("savedata/astrodata/astro" + count, payRate);
        save.saveEncryptedDouble("savedata/astrodata/astro" + count, weight);
        save.saveEncryptedString("savedata/astrodata/astro" + count, children); // TODO: Add arrays to SaveData class.
        save.saveEncryptedInt("savedata/astrodata/astro" + count, statis);
    }

    private void editAstronaut() {
        // pass
    }

    private void deleteAstronaut() {
        // pass
    }
}
