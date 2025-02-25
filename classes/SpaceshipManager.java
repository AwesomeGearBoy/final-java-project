package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

// TODO: There is a problem with this class involving saving data in addSpaceship(). Consistantly saving to 'ship1' folder.
public class SpaceshipManager   {
    final String SHIP_SAVE_PATH = "savedata/shipdata/s7wko92b.data";
    final String NAME_SAVE_PATH = "72gbedjj.data";
    final String ASSIGNED_SAVE_PATH = "savedata/shipdata/83h3urum.data";
    final String ASTRONAUTS_SAVE_PATH = "3ud83bd8.data";
    final String CAPACITY_SAVE_PATH = "cvy62md8.data";
    final String CURRENT_SAVE_PATH = "2vsyas8x.data";
    final String NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH = "nudy3b38.data";
    Scanner input;
    SaveData save = new SaveData();
    ConsoleManager cons;
    int count = save.loadEncryptedInt(SHIP_SAVE_PATH, 0);
    boolean[] defaultAssigned = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
    boolean[] defaultSpaceship = { false, false, false, false, false, false, false, false, false, false };

    public SpaceshipManager(Scanner input, ConsoleManager cons)  {
        this.cons = cons;
        this.input = input;
    }
         
    public void showMenu() {
        boolean menuRunning = true;
        int choice;
        
        do {
            cons.print("Welcome to the Spaceship Manager.");
            cons.print("1. Add a spaceship");
            cons.print("2. Assign astronauts");
            cons.print("3. Delete a spaceship");
            cons.print("4. Fuel a spaceship"); 
            cons.print("5. Back to main menu");
            cons.printSl("Please make a selection: ");

            while (!input.hasNextInt()) {  // Validate integer input
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
            choice = input.nextInt();
            input.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    addSpaceship();
                    break;
                case 2:
                    assignAstronauts();
                    break;
                case 3:
                    deleteSpaceship();
                    break;
                case 4:
                    fuelSpaceship();
                    break;
                case 5:
                    menuRunning = false;
                    break;
                default:
                    cons.print("Invalid option. Please try again.");
                    break;
            }                    // Error fixed :) - Drewski
        }   while(menuRunning);     // Using this to keep error away for now
    }

    private void addSpaceship()   {
        boolean[] ship = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);
        int count = -1;
        
        // Find first available slot
        for (int i = 0; i < ship.length; i++) {
            if (!ship[i]) {
                count = i;
                break;
            }
        }
        
        if (count == -1) {
            cons.print("Spaceship capacity reached.");
            return;
        }
        
        cons.print("Enter new Spaceship's name: ");
        String name;
        name = input.nextLine();
            

        cons.print("Enter the Spaceship's fuel capacity (lbs): ");
        while   (!input.hasNextDouble())   {
            cons.print("Invalid input, please enter a valid number.");
            input.next();
        }
        double fuelCapacity = input.nextDouble();
        input.nextLine();
        String basicPath = "savedata/shipdata/ship" + (count + 1) + "/";
        save.saveEncryptedString(basicPath + NAME_SAVE_PATH, name);
        save.saveEncryptedDouble(basicPath + CAPACITY_SAVE_PATH, fuelCapacity);

        cons.print("Spaceship saved as Ship #" + (count + 1));
    }

    private void assignAstronauts() {
        AstroManager astroManager = new AstroManager(input, cons);
        int numbAstroAssigned = save.loadEncryptedInt(NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH, 0);
        boolean[] astronauts = astroManager.getAstronauts();
        boolean[] assigned = save.loadEncryptedBooleanArray(ASSIGNED_SAVE_PATH, defaultAssigned);
    
        // Count existing astronauts
        int numberOfExistingAstros = 0;
        for (boolean astro : astronauts) {
            if (astro) {
                numberOfExistingAstros++;
            }
        }
    
        if (numberOfExistingAstros <= 0) {
            cons.print("ERROR: No astronauts exist!");
            return;
        }
    
        // Select spaceship
        int shipIndex;
        cons.print("Which ship do you want to assign astronauts to? (1-10)");
    
        while (true) {
            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
    
                if (shipIndex >= 0 && shipIndex < 10) {
                    break;
                } else {
                    cons.print("Invalid choice. Please enter a number between 1 and 10.");
                }
            } else {
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
        }
    
        // Select number of astronauts to assign
        int availableSpots = 15 - numbAstroAssigned;
        if (availableSpots <= 0) {
            cons.print("No available slots for astronauts on this spaceship.");
            return;
        }
    
        int astroCount;
        cons.print("How many astronauts do you want to assign? (1-" + availableSpots + ")");
    
        while (true) {
            if (input.hasNextInt()) {
                astroCount = input.nextInt();
                input.nextLine(); // Consume newline
    
                if (astroCount >= 1 && astroCount <= availableSpots) {
                    break;
                } else {
                    cons.print("Invalid choice. Please enter a number between 1 and " + availableSpots + ".");
                }
            } else {
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
        }
    
        // Assign astronauts
        int[] assignedAstronauts = new int[astroCount];
    
        for (int i = 0; i < astroCount; i++) {
            int astroNum;
            while (true) {
                cons.print("Enter the number of Astronaut #" + (i + 1) + " (1-15):");
    
                if (input.hasNextInt()) {
                    astroNum = input.nextInt();
                    input.nextLine(); // Consume newline
    
                    if (astroNum >= 1 && astroNum <= 15) {
                        astroNum--; // Convert to zero-based index
    
                        if (!assigned[astroNum]) {
                            assignedAstronauts[i] = astroNum;
                            assigned[astroNum] = true;
                            break; // Valid astronaut assigned, exit loop
                        } else {
                            cons.print("Astronaut #" + (astroNum + 1) + " is already assigned. Choose another.");
                        }
                    } else {
                        cons.print("Invalid astronaut number. Please enter a number between 1 and 15.");
                    }
                } else {
                    cons.print("Invalid input. Please enter a number.");
                    input.next(); // Consume invalid input
                }
            }
        }
    
        // Update save data
        numbAstroAssigned += astroCount;
        String basePath = "savedata/shipdata/ship" + (shipIndex + 1) + "/";
    
        save.saveEncryptedInt(NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH, numbAstroAssigned);
        save.saveEncryptedIntArray(basePath + ASTRONAUTS_SAVE_PATH, assignedAstronauts);
        save.saveEncryptedBooleanArray(ASSIGNED_SAVE_PATH, assigned);
    
        cons.print(astroCount + " astronauts successfully assigned to Ship #" + (shipIndex + 1) + "!");
    }    

    private void deleteSpaceship() {
        boolean[] ships = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);
    
        // Get valid spaceship selection
        int shipIndex;
        cons.print("Which spaceship do you want to delete? (1-10)");
    
        while (true) {
            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
    
                if (shipIndex >= 0 && shipIndex < 10) {
                    break;
                } else {
                    cons.print("Invalid choice. Please enter a number between 1 and 10.");
                }
            } else {
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
        }
    
        // Check if the spaceship exists
        if (!ships[shipIndex]) {
            cons.print("No spaceship exists in this slot.");
            return;
        }
    
        // Mark spaceship as deleted
        ships[shipIndex] = false;
        save.saveEncryptedBooleanArray(SHIP_SAVE_PATH, ships);
    
        // Prepare paths for deletion
        String basePath = "savedata/shipdata/ship" + (shipIndex + 1) + "/";
        int numbAstroAssigned = save.loadEncryptedInt(NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH, 0);
        boolean[] assigned = save.loadEncryptedBooleanArray(ASSIGNED_SAVE_PATH, defaultAssigned);
        int[] astronauts = save.loadEncryptedIntArray(basePath + ASTRONAUTS_SAVE_PATH, new int[0]); // Default to empty array
    
        // Unassign astronauts from this spaceship
        for (int astroNum : astronauts) {
            assigned[astroNum] = false;
            numbAstroAssigned--;
        }
    
        // Save updated astronaut assignments
        save.saveEncryptedInt(NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH, numbAstroAssigned);
        save.saveEncryptedBooleanArray(ASSIGNED_SAVE_PATH, assigned);
    
        // Clear spaceship data
        save.saveEncryptedIntArray(basePath + ASTRONAUTS_SAVE_PATH, new int[0]);
        save.saveEncryptedString(basePath + NAME_SAVE_PATH, "");
        save.saveEncryptedDouble(basePath + CAPACITY_SAVE_PATH, 0.0);
    
        cons.print("Spaceship #" + (shipIndex + 1) + " has been deleted.");
    }    

    private void fuelSpaceship()  {
        // TODO: This.
    }

    // Could be done in here rather than main
    @SuppressWarnings("unused")
    private void launchSpaceship() {
        // pass for now
    }
}
