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
    AnsiColors ansi = new AnsiColors();
    boolean[] defaultAstro = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };

    public AstroManager(Scanner input, ConsoleManager cons) {
        this.input = input;
        this.cons = cons;
    }

    public void showMenu() {
        boolean menuRunning = true;
        int choice;
    
        do {
            cons.print(ansi.purple() + ansi.blackBackground() + "\nWelcome to the astronaut manager." + ansi.reset());
            cons.print(ansi.blackBackground() + "1. Add an astronaut" + ansi.reset());
            cons.print(ansi.blackBackground() + "2. Edit an astronaut" + ansi.reset());
            cons.print(ansi.blackBackground() + "3. Delete an astronaut" + ansi.reset());
            cons.print(ansi.blackBackground() + "4. Back to main menu" + ansi.reset());
            cons.printSl(ansi.yellow() + ansi.blackBackground() + "Make selection (1-4):" + ansi.reset() + " ");
    
            while (!input.hasNextInt()) {  // Validate integer input
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a number." + ansi.reset());
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
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid option. Please try again." + ansi.reset());
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
            cons.print(ansi.red() + ansi.blackBackground() + "Astronaut capacity reached." + ansi.reset());
            return;
        }
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter new astronaut's name:" + ansi.reset() + " ");
        String name = input.nextLine();
    
        String birthday;
        while (true) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter new astronaut's birthday (XX/XX/XXXX):" + ansi.reset() + " ");
            birthday = input.nextLine();
            if (birthday.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid format. Please try again." + ansi.reset());
            }
        }
    
        Random rand = new Random();
        int serial = 1000 + rand.nextInt(9000); // Ensures serial is always 1000-9999
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's address:" + ansi.reset() + " ");
        String address = input.nextLine();
    
        String email;
        while (true) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's email:" + ansi.reset() + " ");
            email = input.nextLine();
            if (email.contains("@")) {
                break;
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid email. Try again." + ansi.reset());
            }
        }
    
        String phone;
        while (true) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's phone ((XXX)XXX-XXXX):" + ansi.reset() + " ");
            phone = input.nextLine();
            if (phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                break;
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid phone format. Try again." + ansi.reset());
            }
        }
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's pay rate (e.g., 1500.50):" + ansi.reset() + " ");
        while (!input.hasNextDouble()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter a valid pay rate:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        double payRate = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's weight in pounds:" + ansi.reset() + " ");
        while (!input.hasNextDouble()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter a valid weight:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        double weight = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter number of children:" + ansi.reset() + " ");
        while (!input.hasNextInt()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter a valid number:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        int numChildren = input.nextInt();
        input.nextLine(); // Consume newline
    
        String[] children = new String[numChildren];
        for (int i = 0; i < numChildren; i++) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter name of child #" + (i + 1) + ":" + ansi.reset() + " ");
            children[i] = input.nextLine();
        }
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's status (1 = In Space, 2 = On Earth):" + ansi.reset() + " ");
        while (!input.hasNextInt()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter 1 or 2:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        int statis = input.nextInt();
        input.nextLine(); // Consume newline
    
        // Mark astronaut slot as occupied
        astro[count] = true;
        save.saveEncryptedBooleanArray(ASTRO_SAVE_PATH, astro);
    
        count++;
        // Save astronaut details
        String basePath = "savedata/astrodata/astro" + count + "/";
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
    
        cons.print(ansi.purple() + ansi.blackBackground() + "Astronaut saved as Astronaut #" + count + ". WRITE IT DOWN SOMEWHERE." + ansi.reset());
    }

    private void editAstronaut() {
        boolean[] astro = save.loadEncryptedBooleanArray(ASTRO_SAVE_PATH, defaultAstro);
        int count = -1; // Initialize count to an invalid value
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Which astronaut do you want to edit (1-15)?" + ansi.reset());
    
        while (true) {
            if (input.hasNextInt()) {
                count = input.nextInt();
                input.nextLine(); // Consume newline
    
                if (count >= 1 && count <= 15) {
                    count -= 1; // Convert to zero-based index
                    break;
                } else {
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid choice. Please enter a number between 1 and 15." + ansi.reset());
                }
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a valid number." + ansi.reset());
                input.next(); // Consume invalid input
            }
        }

        if (astro[count] == false) {
            cons.print(ansi.red() + ansi.blackBackground() + "No astronaut has been saved in this path yet!" + ansi.reset());
            return;
        }
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's name:" + ansi.reset() + " ");
        String name = input.nextLine();
    
        String birthday;
        while (true) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's birthday (XX/XX/XXXX):" + ansi.reset() + " ");
            birthday = input.nextLine();
            if (birthday.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid format. Please try again." + ansi.reset());
            }
        }
    
        int serial = save.loadEncryptedInt("savedata/astrodata/astro" + count + SERIAL_SAVE_PATH);
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's address:" + ansi.reset() + " ");
        String address = input.nextLine();
    
        String email;
        while (true) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's email:" + ansi.reset() + " ");
            email = input.nextLine();
            if (email.contains("@")) {
                break;
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid email. Try again." + ansi.reset());
            }
        }
    
        String phone;
        while (true) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's phone ((XXX)XXX-XXXX):" + ansi.reset() + " ");
            phone = input.nextLine();
            if (phone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                break;
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid phone format. Try again." + ansi.reset());
            }
        }
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's pay rate (e.g., 1500.50):" + ansi.reset() + " ");
        while (!input.hasNextDouble()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter a valid pay rate:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        double payRate = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's weight in pounds:" + ansi.reset() + " ");
        while (!input.hasNextDouble()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter a valid weight:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        double weight = input.nextDouble();
        input.nextLine(); // Consume newline
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter number of children:" + ansi.reset() + " ");
        while (!input.hasNextInt()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter a valid number:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        int numChildren = input.nextInt();
        input.nextLine(); // Consume newline
    
        String[] children = new String[numChildren];
        for (int i = 0; i < numChildren; i++) {
            cons.print(ansi.yellow() + ansi.blackBackground() + "Enter name of child #" + (i + 1) + ":" + ansi.reset() + " ");
            children[i] = input.nextLine();
        }
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter astronaut's status (1 = In Space, 2 = On Earth):" + ansi.reset() + " ");
        while (!input.hasNextInt()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Enter 1 or 2:" + ansi.reset() + " ");
            input.next(); // Consume invalid input
        }
        int statis = input.nextInt();
        input.nextLine(); // Consume newline

        count++;
        String basePath = "savedata/astrodata/astro" + count + "/";
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

        cons.print(ansi.purple() + ansi.blackBackground() + "New Astronaut information has been saved successfully." + ansi.reset());
    }

    private void deleteAstronaut() {
        int count = -1;
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Which astronaut do you want to delete (1-15)?" + ansi.reset());
    
        while (true) {
            if (input.hasNextInt()) {
                count = input.nextInt();
                input.nextLine(); // Consume newline
    
                if (count >= 1 && count <= 15) {
                    count -= 1; // Convert to zero-based index
                    break;
                } else {
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid choice. Please enter a number between 1 and 15." + ansi.reset());
                }
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a valid number." + ansi.reset());
                input.next(); // Consume invalid input
            }
        }
    
        boolean[] astro = save.loadEncryptedBooleanArray(ASTRO_SAVE_PATH, defaultAstro);
        if (!astro[count]) {
            cons.print(ansi.red() + ansi.blackBackground() + "No astronaut exists at this slot." + ansi.reset());
            return;
        }

        cons.print(ansi.red() + ansi.blackBackground() + "Are you sure you want to delete Ship #" + (count + 1) + "? (y/n)" + ansi.reset());
        String confirmation = input.nextLine().toLowerCase();
        if (confirmation.equals("y")) {
            // Mark astronaut as deleted
            astro[count] = false;
            save.saveEncryptedBooleanArray(ASTRO_SAVE_PATH, astro);

            count++;
            String basePath = "savedata/astrodata/astro" + count + "/";
            save.saveEncryptedString(basePath + NAME_SAVE_PATH, "");
            save.saveEncryptedString(basePath + BIRTHDAY_SAVE_PATH, "");
            save.saveEncryptedInt(basePath + SERIAL_SAVE_PATH, 0);
            save.saveEncryptedString(basePath + ADDRESS_SAVE_PATH, "");
            save.saveEncryptedString(basePath + EMAIL_SAVE_PATH, "");
            save.saveEncryptedString(basePath + PHONE_SAVE_PATH, "");
            save.saveEncryptedDouble(basePath + PAY_RATE_SAVE_PATH, 0);
            save.saveEncryptedDouble(basePath + WEIGHT_SAVE_PATH, 0);
            save.saveEncryptedStringArray(basePath + CHILDREN_SAVE_PATH, new String[0]);
            save.saveEncryptedInt(basePath + STATIS_SAVE_PATH, 0);

            cons.print(ansi.purple() + ansi.blackBackground() + "Astronaut #" + count + " has been deleted." + ansi.reset());
        } else {
            cons.print(ansi.green() + ansi.blackBackground() + "Deletion cancelled." + ansi.reset());
        }
    }

    public boolean[] getAstronauts() {
        boolean[] astro = save.loadEncryptedBooleanArray(ASTRO_SAVE_PATH, defaultAstro);
        return astro;
    }
}
