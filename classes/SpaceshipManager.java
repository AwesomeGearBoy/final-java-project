package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

public class SpaceshipManager   {
    final String SHIP_SAVE_PATH = "savedata/shipdata/s7wko92b.data";
    final String NAME_SAVE_PATH = "72gbedjj.data";
    final String ASSIGNED_SAVE_PATH = "savedata/shipdata/83h3urum.data";
    final String ASTRONAUTS_SAVE_PATH = "3ud83bd8.data";
    final String CAPACITY_SAVE_PATH = "cvy62md8.data";
    final String CURRENT_SAVE_PATH = "2vsyas8x.data";
    final String NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH = "savedata/shipdata/nudy3b38.data";
    Scanner input;
    SaveData save = new SaveData();
    SleepTime sleep = new SleepTime();
    ConsoleManager cons;
    int count;
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

    private void addSpaceship() {
        boolean[] ship = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);
        int availableSlot = -1;
    
        // Find first available slot
        for (int i = 0; i < ship.length; i++) {
            if (!ship[i]) {
                availableSlot = i;
                break;
            }
        }
    
        if (availableSlot == -1) {
            cons.print("Spaceship capacity reached.");
            return;
        }
    
        cons.print("Enter new Spaceship's name: ");
        String name = input.nextLine();
    
        cons.print("Enter the Spaceship's fuel capacity (lbs): ");
        while (!input.hasNextDouble()) {
            cons.print("Invalid input, please enter a valid number.");
            input.next();
        }
        double fuelCapacity = input.nextDouble();
        input.nextLine(); // Consume newline
    
        String basicPath = "savedata/shipdata/ship" + (availableSlot + 1) + "/";
        save.saveEncryptedString(basicPath + NAME_SAVE_PATH, name);
        save.saveEncryptedDouble(basicPath + CAPACITY_SAVE_PATH, fuelCapacity);
    
        // Mark spaceship as used
        ship[availableSlot] = true;
        save.saveEncryptedBooleanArray(SHIP_SAVE_PATH, ship);
    
        cons.print("Spaceship saved as Ship #" + (availableSlot + 1));
    }    

    private void assignAstronauts() {
        AstroManager astroManager = new AstroManager(input, cons);
        int numbAstroAssigned = save.loadEncryptedInt(NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH, 0);
        boolean[] ships = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);
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

        // Count existing ships
        int numberOfExistingShips = 0;
        for (boolean ship : ships) {
            if (ship) {
                numberOfExistingShips++;
            }
        }

        if (numberOfExistingShips <= 0) {
            cons.print("There are no existing ships!");
            return;
        }
    
        // Select spaceship
        int shipIndex;
    
        while (true) {
            cons.printSl("Which ship do you want to assign astronauts to? (1-10): ");

            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
                
                if (shipIndex >= 0 && shipIndex < 10) {
                    if (ships[shipIndex] == true) {
                        break;
                    } else {
                        cons.print("Ship does not exist!");
                    }
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

                if (numberOfExistingAstros < astroCount) {
                    cons.print("There aren't enough astronauts!");
                } else {
                    if (astroCount >= 1 && astroCount <= availableSpots) {
                        break;
                    } else {
                        cons.print("Invalid choice. Please enter a number between 1 and " + availableSpots + ".");
                    }
                }
            } else {
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
        }
    
        // Assign astronauts
        boolean[] astro = astroManager.getAstronauts();
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
                        
                        if (astro[astroNum] == true) {
                            if (!assigned[astroNum]) {
                                assignedAstronauts[i] = astroNum;
                                assigned[astroNum] = true;
                                break; // Valid astronaut assigned, exit loop
                            } else {
                                cons.print("Astronaut #" + (astroNum + 1) + " is already assigned. Choose another.");
                            }
                        } else {
                            cons.print("Astronaut does not exist!");
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

    // TODO: Ask for confirmation
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
        boolean[] ships = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);

        int numberOfExistingShips = 0;
        for (boolean ship : ships) {
            if (ship) {
                numberOfExistingShips++;
            }
        }

        if (numberOfExistingShips <= 0) {
            cons.print("There are no existing ships!");
            return;
        }

        int shipIndex;
    
        while (true) {
            cons.printSl("Which ship do you want to refuel? (1-10): ");

            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
                
                if (shipIndex >= 0 && shipIndex < 10) {
                    if (ships[shipIndex] == true) {
                        break;
                    } else {
                        cons.print("Ship does not exist!");
                    }
                } else {
                    cons.print("Invalid choice. Please enter a number between 1 and 10.");
                }
            } else {
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
        }

        String basePath = "savedata/shipdata/ship" + (shipIndex + 1) + "/";
        double currentFuel = save.loadEncryptedDouble(basePath + CURRENT_SAVE_PATH, 0.0);
        double shipCapacity = save.loadEncryptedDouble(basePath + CAPACITY_SAVE_PATH);

        cons.print("How much fuel are you putting in this ship?");
        double fuel;
        while (true) {
            if (input.hasNextDouble()) {
                fuel = input.nextDouble() + currentFuel;
    
                if (fuel > shipCapacity) {
                    cons.print("Too much fuel!");
                } else {
                    break;
                }
            }
        }

        currentFuel = fuel;

        save.saveEncryptedDouble(basePath + CURRENT_SAVE_PATH, currentFuel);
        cons.print(save.loadEncryptedString(basePath + NAME_SAVE_PATH) + " was successfully refueled!");
    }

    @SuppressWarnings("unused") // TODO: REMOVE THIS EVENTUALLY
    private void launchSpaceship() {
        // TODO: This.
        boolean[] ships = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);

        int numberOfExistingShips = 0;
        for (boolean ship : ships) {
            if (ship) {
                numberOfExistingShips++;
            }
        }

        if (numberOfExistingShips <= 0) {
            cons.print("There are no existing ships!");
            return;
        }

        int shipIndex;
    
        while (true) {
            cons.printSl("Which ship do you want to launch? (1-10): ");

            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
                
                if (shipIndex >= 0 && shipIndex < 10) {
                    if (ships[shipIndex] == true) {
                        break;
                    } else {
                        cons.print("Ship does not exist!");
                    }
                } else {
                    cons.print("Invalid choice. Please enter a number between 1 and 10.");
                }
            } else {
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
        }

        String basePath = "savedata/shipdata/ship" + (shipIndex + 1) + "/";
        int[] def = {};
        int[] assignedAstro = save.loadEncryptedIntArray(basePath + ASSIGNED_SAVE_PATH, def);
        double currentFuel = save.loadEncryptedDouble(basePath + CURRENT_SAVE_PATH);
        String name = save.loadEncryptedString(basePath + NAME_SAVE_PATH);

        if (assignedAstro.length == 0) {
            cons.print("There are no assigned astronauts to " + name);
        }

        if (currentFuel < 12000) {
            cons.print(name + " does not have enough fuel to launch! Each ship needs at least 12000 lbs. to be safe!");
            return;
        }

        sleep.sleep(500);
        cons.print("Initiating countdown to launch.");
        sleep.sleep(500);
        cons.print("Beginning countdown...");
        sleep.sleepSeconds(1);
        cons.print("10");
        sleep.sleepSeconds(1);
        cons.print("9");
        sleep.sleepSeconds(1);
        cons.print("8");
        sleep.sleepSeconds(1);
        cons.print("7");
        sleep.sleepSeconds(1);
        cons.print("6");
        sleep.sleepSeconds(1);
        cons.print("5");
        sleep.sleepSeconds(1);
        cons.print("4");
        sleep.sleepSeconds(1);
        cons.print("3");
        sleep.sleepSeconds(1);
        cons.print("2");
        sleep.sleepSeconds(1);
        cons.print("1");
        sleep.sleepSeconds(1);
        cons.print("BLAST OFF!");

        // TODO: Down here!
        double speed = 0.0;
        double altitude = 0.0;
        double seconds = 0;

        while (altitude < 70000) {
            sleep.sleep(250);
            seconds += 0.25;
            currentFuel -= 0.5;
            speed += 15;
            altitude += speed;

            if (altitude >= 70000) {
                altitude = 70000;
            }

            cons.print("Time (seconds): " + seconds + cons.indent() + "Current Fuel: " + currentFuel + cons.indent() + "Altitude: " + altitude);
        }

        sleep.sleep(500);
        cons.print(name + " has landed on the moon.");
        sleep.sleep(500);
        cons.print("Beginning 30 second moonwalk...");
        
        for (int i = 0; i < 30; i++) {
            cons.print((30 - i) + " seconds left in spacewalk.");
            sleep.sleepSeconds(1);
        }

        cons.print("Moonwalk over. Astronauts have gone back to " + name + ".");

        seconds = 0;
        while (altitude > 0) {
            sleep.sleep(250);
            seconds += 0.25;
            currentFuel -= 0.5;
            altitude -= 15;

            if (altitude >= 70000) {
                altitude = 70000;
            }

            cons.print("Time (seconds): " + seconds + cons.indent() + "Current Fuel: " + currentFuel + cons.indent() + "Altitude: " + altitude);
        }
    }
}
