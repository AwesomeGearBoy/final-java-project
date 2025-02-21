package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

public class AstroManager {
    final String ASTRO_SAVE_PATH = "savedata/astrodata/7dnb39dp.data";
    final String NAME_SAVE_PATH = "4783vfbu.data";
    final String BIRTHDAY_SAVE_PATH = "789gfuy8.data";
    final String SERIAL_SAVE_PATH = "8nd9weju.data";
    final String ADDRESS_SAVE_PATH = "8943bfhl.data";
    final String EMAIL_SAVE_PATH = "f0fejfj1.data";
    final String PHONE_SAVE_PATH = "gejs8eh3.data";
    final String PAY_RATE_SAVE_PATH = "39hf9ueu.data";
    final String WEIGHT_SAVE_PATH = "839hundi.data";
    final String CHILDREN_SAVE_PATH = "83hfbref.data";
    final String STATIS_SAVE_PATH = "782hdbco.data";
    Scanner input;
    SaveData save = new SaveData();
    ConsoleManager cons;
    boolean[] defaultAstro = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };

    public AstroManager(Scanner input, ConsoleManager cons) {
        this.input = input;
        this.cons = cons;
    }

    public void showMenu() {
        boolean menuRunning = true;
        int choice;
    
        do {
            cons.print("1. Add an astronaut");
            cons.print("2. Edit an astronaut");
            cons.print("3. Delete an astronaut");
            cons.print("4. Back to main menu");
    
            while (!input.hasNextInt()) {  // Validate integer input
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
            choice = input.nextInt();
            input.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    addAstronaut();
                    break;
                case 2:
                    editAstronaut();
                    break;
                case 3:
                    deleteAstronaut();
                    break;
                case 4:
                    menuRunning = false;
                    break;
                default:
                    cons.print("Invalid option. Please try again.");
                    break;
            }
        } while (menuRunning);
    }
    
    private void addAstronaut() {
        boolean[] astro = save.loadEncryptedBooleanArray(ASTRO_SAVE_PATH, defaultAstro);
        int count = -1;
    
        // Find first available slot
        for (int i = 0; i < astro.length; i++) {
            if (!astro[i]) {
                count = i;
                break;
            }
        }
    
        if (count == -1) {
            cons.print("Astronaut capacity reached.");
            return;
        }
    
        cons.print("Enter new astronaut's name: ");
        String name = input.nextLine();
    
        String birthday;
        while (true) {
            cons.print("Enter new astronaut's birthday (XX/XX/XXXX): ");
            birthday = input.nextLine();
            if (birthday.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                cons.print("Invalid format. Please try again.");
            }
        }
    
        Random rand = new Random();
        int serial = 1000 + rand.nextInt(9000); // Ensures serial is always 1000-9999
    
        cons.print("Enter astronaut's address: ");
        String address = input.nextLine();
    
        String email;
        while (true) {
            cons.print("Enter astronaut's email: ");
            email = input.nextLine();
            if (email.contains("@")) {
                break;
            } else {
                cons.print("Invalid email. Try again.");
            }
        }
    
        String phone;
        while (true) {
            cons.print("Enter astronaut's phone ((XXX)XXX-XXXX): ");
            phone = input.nextLine();
            if (phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                break;
            } else {
                cons.print("Invalid phone format. Try again.");
            }
        }
    
        cons.print("Enter astronaut's pay rate (e.g., 1500.50): ");
        while (!input.hasNextDouble()) {
            cons.print("Invalid input. Enter a valid pay rate:");
            input.next(); // Consume invalid input
        }
        double payRate = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print("Enter astronaut's weight in pounds: ");
        while (!input.hasNextDouble()) {
            cons.print("Invalid input. Enter a valid weight:");
            input.next(); // Consume invalid input
        }
        double weight = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print("Enter number of children: ");
        while (!input.hasNextInt()) {
            cons.print("Invalid input. Enter a valid number:");
            input.next(); // Consume invalid input
        }
        int numChildren = input.nextInt();
        input.nextLine(); // Consume newline
    
        String[] children = new String[numChildren];
        for (int i = 0; i < numChildren; i++) {
            cons.print("Enter name of child #" + (i + 1) + ": ");
            children[i] = input.nextLine();
        }
    
        cons.print("Enter astronaut's status (1 = In Space, 2 = On Earth): ");
        while (!input.hasNextInt()) {
            cons.print("Invalid input. Enter 1 or 2:");
            input.next(); // Consume invalid input
        }
        int statis = input.nextInt();
        input.nextLine(); // Consume newline
    
        // Mark astronaut slot as occupied
        astro[count] = true;
        save.saveEncryptedBooleanArray(ASTRO_SAVE_PATH, astro);
    
        // Save astronaut details
        String basePath = "savedata/astrodata/astro" + count;
        save.saveEncryptedString(basePath + NAME_SAVE_PATH, name);
        save.saveEncryptedString(basePath + BIRTHDAY_SAVE_PATH, birthday);
        save.saveEncryptedInt(basePath + SERIAL_SAVE_PATH, serial);
        save.saveEncryptedString(basePath + ADDRESS_SAVE_PATH, address);
        save.saveEncryptedString(basePath + EMAIL_SAVE_PATH, email);
        save.saveEncryptedString(basePath + PHONE_SAVE_PATH, phone);
        save.saveEncryptedDouble(basePath + PAY_RATE_SAVE_PATH, payRate);
        save.saveEncryptedDouble(basePath + WEIGHT_SAVE_PATH, weight);
        save.saveEncryptedStringArray(basePath + CHILDREN_SAVE_PATH, children);
        save.saveEncryptedInt(basePath + STATIS_SAVE_PATH, statis);
    
        cons.print("Astronaut saved as Astronaut #" + count + ". WRITE IT DOWN SOMEWHERE.");
    }

    private void editAstronaut() {
        boolean[] astro = save.loadEncryptedBooleanArray(ASTRO_SAVE_PATH, defaultAstro);
        int count = -1; // Initialize count to an invalid value
    
        cons.print("Which astronaut do you want to edit (1-15)?");
    
        while (true) {
            if (input.hasNextInt()) {
                count = input.nextInt();
                input.nextLine(); // Consume newline
    
                if (count >= 1 && count <= 15) {
                    count -= 1; // Convert to zero-based index
                    break;
                } else {
                    cons.print("Invalid choice. Please enter a number between 1 and 15.");
                }
            } else {
                cons.print("Invalid input. Please enter a valid number.");
                input.next(); // Consume invalid input
            }
        }

        if (astro[count] == false) {
            cons.print("No astronaut has been saved in this path yet!");
            return;
        }
    
        cons.print("Enter astronaut's name: ");
        String name = input.nextLine();
    
        String birthday;
        while (true) {
            cons.print("Enter astronaut's birthday (XX/XX/XXXX): ");
            birthday = input.nextLine();
            if (birthday.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                cons.print("Invalid format. Please try again.");
            }
        }
    
        int serial = save.loadEncryptedInt("savedata/astrodata/astro" + count + SERIAL_SAVE_PATH);
    
        cons.print("Enter astronaut's address: ");
        String address = input.nextLine();
    
        String email;
        while (true) {
            cons.print("Enter astronaut's email: ");
            email = input.nextLine();
            if (email.contains("@")) {
                break;
            } else {
                cons.print("Invalid email. Try again.");
            }
        }
    
        String phone;
        while (true) {
            cons.print("Enter astronaut's phone ((XXX)XXX-XXXX): ");
            phone = input.nextLine();
            if (phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                break;
            } else {
                cons.print("Invalid phone format. Try again.");
            }
        }
    
        cons.print("Enter astronaut's pay rate (e.g., 1500.50): ");
        while (!input.hasNextDouble()) {
            cons.print("Invalid input. Enter a valid pay rate:");
            input.next(); // Consume invalid input
        }
        double payRate = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print("Enter astronaut's weight in pounds: ");
        while (!input.hasNextDouble()) {
            cons.print("Invalid input. Enter a valid weight:");
            input.next(); // Consume invalid input
        }
        double weight = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print("Enter number of children: ");
        while (!input.hasNextInt()) {
            cons.print("Invalid input. Enter a valid number:");
            input.next(); // Consume invalid input
        }
        int numChildren = input.nextInt();
        input.nextLine(); // Consume newline
    
        String[] children = new String[numChildren];
        for (int i = 0; i < numChildren; i++) {
            cons.print("Enter name of child #" + (i + 1) + ": ");
            children[i] = input.nextLine();
        }
    
        cons.print("Enter astronaut's status (1 = In Space, 2 = On Earth): ");
        while (!input.hasNextInt()) {
            cons.print("Invalid input. Enter 1 or 2:");
            input.next(); // Consume invalid input
        }
        int statis = input.nextInt();
        input.nextLine(); // Consume newline

        String basePath = "savedata/astrodata/astro" + count;
        save.saveEncryptedString(basePath + NAME_SAVE_PATH, name);
        save.saveEncryptedString(basePath + BIRTHDAY_SAVE_PATH, birthday);
        save.saveEncryptedInt(basePath + SERIAL_SAVE_PATH, serial);
        save.saveEncryptedString(basePath + ADDRESS_SAVE_PATH, address);
        save.saveEncryptedString(basePath + EMAIL_SAVE_PATH, email);
        save.saveEncryptedString(basePath + PHONE_SAVE_PATH, phone);
        save.saveEncryptedDouble(basePath + PAY_RATE_SAVE_PATH, payRate);
        save.saveEncryptedDouble(basePath + WEIGHT_SAVE_PATH, weight);
        save.saveEncryptedStringArray(basePath + CHILDREN_SAVE_PATH, new String[0]); // Clear old data
        save.saveEncryptedStringArray(basePath + CHILDREN_SAVE_PATH, children);
        save.saveEncryptedInt(basePath + STATIS_SAVE_PATH, statis);

        cons.print("New Astronaut information has been saved successfully.");
    }

    private void deleteAstronaut() {
        int count = -1;
    
        cons.print("Which astronaut do you want to delete (1-15)?");
    
        while (true) {
            if (input.hasNextInt()) {
                count = input.nextInt();
                input.nextLine(); // Consume newline
    
                if (count >= 1 && count <= 15) {
                    count -= 1; // Convert to zero-based index
                    break;
                } else {
                    cons.print("Invalid choice. Please enter a number between 1 and 15.");
                }
            } else {
                cons.print("Invalid input. Please enter a valid number.");
                input.next(); // Consume invalid input
            }
        }
    
        boolean[] astro = save.loadEncryptedBooleanArray(ASTRO_SAVE_PATH, defaultAstro);
        if (!astro[count]) {
            cons.print("No astronaut exists at this slot.");
            return;
        }
    
        // Mark astronaut as deleted
        astro[count] = false;
        save.saveEncryptedBooleanArray(ASTRO_SAVE_PATH, astro);

        String basePath = "savedata/astrodata/astro" + count;
        save.saveEncryptedString(basePath + NAME_SAVE_PATH, "");
        save.saveEncryptedString(basePath + BIRTHDAY_SAVE_PATH, "");
        save.saveEncryptedInt(basePath + SERIAL_SAVE_PATH, 1234);
        save.saveEncryptedString(basePath + ADDRESS_SAVE_PATH, "");
        save.saveEncryptedString(basePath + EMAIL_SAVE_PATH, "");
        save.saveEncryptedString(basePath + PHONE_SAVE_PATH, "");
        save.saveEncryptedDouble(basePath + PAY_RATE_SAVE_PATH, 12.34);
        save.saveEncryptedDouble(basePath + WEIGHT_SAVE_PATH, 12.34);
        save.saveEncryptedStringArray(basePath + CHILDREN_SAVE_PATH, new String[0]);
        save.saveEncryptedInt(basePath + STATIS_SAVE_PATH, 1234);

        cons.print("Astronaut #" + (count + 1) + " has been deleted.");
    }
}
