package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

public class SpaceshipManager   {
    // Final Strings
    final String SHIP_SAVE_PATH = "savedata/shipdata/s7wko92b.data";
    final String NAME_SAVE_PATH = "72gbedjj.data";
    final String ASSIGNED_SAVE_PATH = "savedata/shipdata/83h3urum.data";
    final String ASTRONAUTS_SAVE_PATH = "3ud83bd8.data";
    final String CAPACITY_SAVE_PATH = "cvy62md8.data";
    final String CURRENT_SAVE_PATH = "2vsyas8x.data";
    final String NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH = "savedata/shipdata/nudy3b38.data";
    Scanner input; // Scanner
    // Drewski's library
    SaveData save = new SaveData();
    SleepTime sleep = new SleepTime();
    AnsiColors ansi = new AnsiColors();
    ConsoleManager cons;

    // Integers
    int count;

    // Default boolean arrays
    boolean[] defaultAssigned = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
    boolean[] defaultSpaceship = { false, false, false, false, false, false, false, false, false, false };

    public SpaceshipManager(Scanner input, ConsoleManager cons)  {
        this.cons = cons; // Get console
        this.input = input; // Get Scanner
    }
         
    public void showMenu() {
        boolean menuRunning = true; // Set to running
        int choice;
        
        do {
            cons.print(ansi.purple() + ansi.blackBackground() + "\nWelcome to the Spaceship Manager." + ansi.reset());
            cons.print(ansi.blackBackground() + "1. Add a spaceship" + ansi.reset());
            cons.print(ansi.blackBackground() + "2. Assign astronauts" + ansi.reset());
            cons.print(ansi.blackBackground() + "3. Delete a spaceship" + ansi.reset());
            cons.print(ansi.blackBackground() + "4. Fuel a spaceship" + ansi.reset()); 
            cons.print(ansi.blackBackground() + "5. Launch a spaceship" + ansi.reset());
            cons.print(ansi.blackBackground() + "6. Back to main menu" + ansi.reset());
            cons.printSl(ansi.yellow() + ansi.blackBackground() + "Please make a selection:" + ansi.reset() + " "); // Get selection

            while (!input.hasNextInt()) {  // Validate integer input
                cons.print("Invalid input. Please enter a number.");
                input.next(); // Consume invalid input
            }
            choice = input.nextInt();
            input.nextLine(); // Consume newline
    
            switch (choice) { // Switch between choices
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
                    launchSpaceship();
                    break;
                case 6:
                    menuRunning = false;
                    break;
                default:
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid option. Please try again." + ansi.reset()); // Validate input
                    break;
            }
        }   while(menuRunning);
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
            cons.print(ansi.red() + ansi.blackBackground() + "Spaceship capacity reached." + ansi.reset());
            return;
        }
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter new Spaceship's name:" + ansi.reset() + " ");
        String name = input.nextLine(); // Get input
    
        cons.print(ansi.yellow() + ansi.blackBackground() + "Enter the Spaceship's fuel capacity (lbs):" + ansi.reset() + " ");
        while (!input.hasNextDouble()) {
            cons.print(ansi.red() + ansi.blackBackground() + "Invalid input, please enter a valid number." + ansi.reset());
            input.next();
        }
        double fuelCapacity = input.nextDouble(); // Get input
        input.nextLine(); // Consume newline
    
        String basicPath = "savedata/shipdata/ship" + (availableSlot + 1) + "/";
        save.saveEncryptedString(basicPath + NAME_SAVE_PATH, name);
        save.saveEncryptedDouble(basicPath + CAPACITY_SAVE_PATH, fuelCapacity);
    
        // Mark spaceship as used
        ship[availableSlot] = true;
        save.saveEncryptedBooleanArray(SHIP_SAVE_PATH, ship);
    
        cons.print(ansi.purple() + ansi.blackBackground() + "Spaceship saved as Ship #" + (availableSlot + 1) + ansi.reset());
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
            cons.print(ansi.red() + ansi.blackBackground() + "ERROR: No astronauts exist!" + ansi.reset());
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
            cons.print(ansi.red() + ansi.blackBackground() + "There are no existing ships!" + ansi.reset());
            return;
        }
    
        // Select spaceship
        int shipIndex;
    
        while (true) {
            cons.printSl(ansi.yellow() + ansi.blackBackground() + "Which ship do you want to assign astronauts to? (1-10):" + ansi.reset() + " ");

            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
                
                if (shipIndex >= 0 && shipIndex < 10) {
                    if (ships[shipIndex] == true) {
                        break;
                    } else {
                        cons.print(ansi.red() + ansi.blackBackground() + "Ship does not exist!" + ansi.reset());
                    }
                } else {
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid choice. Please enter a number between 1 and 10." + ansi.reset());
                }
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a number." + ansi.reset());
                input.next(); // Consume invalid input
            }
        }
    
        // Select number of astronauts to assign
        int availableSpots = 15 - numbAstroAssigned;
        if (availableSpots <= 0) {
            cons.print(ansi.red() + ansi.blackBackground() + "No available slots for astronauts on this spaceship." + ansi.reset());
            return;
        }
    
        int astroCount;
        cons.print(ansi.yellow() + ansi.blackBackground() + "How many astronauts do you want to assign? (1-" + availableSpots + ")" + ansi.reset());
    
        while (true) {
            if (input.hasNextInt()) {
                astroCount = input.nextInt();
                input.nextLine(); // Consume newline

                if (numberOfExistingAstros < astroCount) {
                    cons.print(ansi.red() + ansi.blackBackground() + "There aren't enough astronauts!" + ansi.reset());
                } else {
                    if (astroCount >= 1 && astroCount <= availableSpots) {
                        break;
                    } else {
                        cons.print(ansi.red() + ansi.blackBackground() + "Invalid choice. Please enter a number between 1 and " + availableSpots + "." + ansi.reset());
                    }
                }
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a number." + ansi.reset());
                input.next(); // Consume invalid input
            }
        }
    
        // Assign astronauts
        boolean[] astro = astroManager.getAstronauts();
        int[] assignedAstronauts = new int[astroCount];
    
        for (int i = 0; i < astroCount; i++) {
            int astroNum;
            while (true) {
                cons.print(ansi.yellow() + ansi.blackBackground() + "Enter the number of Astronaut #" + (i + 1) + " (1-15):" + ansi.reset());
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
                                cons.print(ansi.red() + ansi.blackBackground() + "Astronaut #" + (astroNum + 1) + " is already assigned. Choose another." + ansi.reset());
                            }
                        } else {
                            cons.print(ansi.red() + ansi.blackBackground() + "Astronaut does not exist!" + ansi.reset());
                        }
                    } else {
                        cons.print(ansi.red() + ansi.blackBackground() + "Invalid astronaut number. Please enter a number between 1 and 15." + ansi.reset());
                    }
                } else {
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a number." + ansi.reset());
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
    
        cons.print(ansi.purple() + ansi.blackBackground() + astroCount + " astronauts successfully assigned to Ship #" + (shipIndex + 1) + "!");
    }    

    private void deleteSpaceship() {
        boolean[] ships = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);
    
        // Get valid spaceship selection
        int shipIndex;
        cons.print(ansi.yellow() + ansi.blackBackground() + "Which spaceship do you want to delete? (1-10)" + ansi.reset());
    
        while (true) {
            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
    
                if (shipIndex >= 0 && shipIndex < 10) {
                    break;
                } else {
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid choice. Please enter a number between 1 and 10." + ansi.reset());
                }
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a number." + ansi.reset());
                input.next(); // Consume invalid input
            }
        }
    
        // Check if the spaceship exists
        if (!ships[shipIndex]) {
            cons.print(ansi.red() + ansi.blackBackground() + "No spaceship exists in this slot." + ansi.reset());
            return;
        }
    
        cons.print(ansi.red() + ansi.blackBackground() + "Are you sure you want to delete Ship #" + (shipIndex + 1) + "? (y/n)" + ansi.reset());
        String confirmation = input.nextLine().toLowerCase();
        if (confirmation.equals("y")) {
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
                if (astroNum >= 0 && astroNum < assigned.length) {
                    assigned[astroNum] = false;
                }
                numbAstroAssigned--;
            }
        
            // Save updated astronaut assignments
            save.saveEncryptedInt(NUMBER_OF_ASTRONAUTS_ASSIGNED_SAVE_PATH, numbAstroAssigned);
            save.saveEncryptedBooleanArray(ASSIGNED_SAVE_PATH, assigned);
        
            // Clear spaceship data
            save.saveEncryptedIntArray(basePath + ASTRONAUTS_SAVE_PATH, new int[0]);
            save.saveEncryptedString(basePath + NAME_SAVE_PATH, "");
            save.saveEncryptedDouble(basePath + CAPACITY_SAVE_PATH, 0.0);
        
            cons.print(ansi.purple() + ansi.blackBackground() + "Spaceship #" + (shipIndex + 1) + " has been deleted." + ansi.reset());
        } else {
            cons.print(ansi.green() + ansi.blackBackground() + "Deletion cancelled." + ansi.reset());
        }
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
            cons.print(ansi.red() + ansi.blackBackground() + "There are no existing ships!" + ansi.reset());
            return;
        }

        int shipIndex;
    
        while (true) {
            cons.printSl(ansi.yellow() + ansi.blackBackground() + "Which ship do you want to refuel? (1-10):" + ansi.reset() + " ");

            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
                
                if (shipIndex >= 0 && shipIndex < 10) {
                    if (ships[shipIndex] == true) {
                        break;
                    } else {
                        cons.print(ansi.red() + ansi.blackBackground() + "Ship does not exist!" + ansi.reset());
                    }
                } else {
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid choice. Please enter a number between 1 and 10." + ansi.reset());
                }
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a number." + ansi.reset());
                input.next(); // Consume invalid input
            }
        }

        String basePath = "savedata/shipdata/ship" + (shipIndex + 1) + "/";
        double currentFuel = save.loadEncryptedDouble(basePath + CURRENT_SAVE_PATH, 0.0);
        double shipCapacity = save.loadEncryptedDouble(basePath + CAPACITY_SAVE_PATH);

        cons.print(ansi.yellow() + ansi.blackBackground() + "How much fuel are you putting in this ship?" + ansi.reset());
        double fuel;
        while (true) {
            if (input.hasNextDouble()) {
                fuel = input.nextDouble() + currentFuel;
    
                if (fuel > shipCapacity) {
                    if (fuel + currentFuel > shipCapacity) {
                        cons.print(ansi.red() + ansi.blackBackground() + "Too much fuel! Maximum capacity: " + (shipCapacity - currentFuel) + " lbs." + ansi.reset());
                        return;
                    }
                    cons.print(ansi.red() + ansi.blackBackground() + "Too much fuel!" + ansi.reset());
                    break;
                } else {
                    break;
                }
            }
        }

        currentFuel = fuel;

        save.saveEncryptedDouble(basePath + CURRENT_SAVE_PATH, currentFuel);
        cons.print(ansi.purple() + ansi.blackBackground() + save.loadEncryptedString(basePath + NAME_SAVE_PATH) + " was successfully refueled!" + ansi.reset());
    }

    private void launchSpaceship() {
        WebControl web = new WebControl();
        boolean[] ships = save.loadEncryptedBooleanArray(SHIP_SAVE_PATH, defaultSpaceship);

        int numberOfExistingShips = 0;
        for (boolean ship : ships) {
            if (ship) {
                numberOfExistingShips++;
            }
        }

        if (numberOfExistingShips <= 0) {
            cons.print(ansi.red() + ansi.blackBackground() + "There are no existing ships!" + ansi.reset());
            return;
        }

        int shipIndex;
    
        while (true) {
            cons.printSl(ansi.yellow() + ansi.blackBackground() + "Which ship do you want to launch? (1-10):" + ansi.reset() + " ");

            if (input.hasNextInt()) {
                shipIndex = input.nextInt() - 1; // Convert to zero-based index
                input.nextLine(); // Consume newline
                
                if (shipIndex >= 0 && shipIndex < 10) {
                    if (ships[shipIndex] == true) {
                        break;
                    } else {
                        cons.print(ansi.red() + ansi.blackBackground() + "Ship does not exist!" + ansi.reset());
                    }
                } else {
                    cons.print(ansi.red() + ansi.blackBackground() + "Invalid choice. Please enter a number between 1 and 10." + ansi.reset());
                }
            } else {
                cons.print(ansi.red() + ansi.blackBackground() + "Invalid input. Please enter a number." + ansi.reset());
                input.next(); // Consume invalid input
            }
        }

        String basePath = "savedata/shipdata/ship" + (shipIndex + 1) + "/";
        double currentFuel = save.loadEncryptedDouble(basePath + CURRENT_SAVE_PATH);
        String name = save.loadEncryptedString(basePath + NAME_SAVE_PATH);

        if (currentFuel < 300) {
            cons.print(ansi.red() + ansi.blackBackground() + name + " does not have enough fuel to launch! Each ship needs at least 300 lbs. to be safe!" + ansi.reset());
            return;
        }

        sleep.sleep(500);
        cons.print(ansi.yellow() + ansi.blackBackground() + "Initiating countdown to launch." + ansi.reset());
        sleep.sleep(500);
        cons.print(ansi.yellow() + ansi.blackBackground() + "Beginning countdown..." + ansi.reset());
        sleep.sleepSeconds(1);
        cons.print("10");
        web.openFile("assets/10.png");
        sleep.sleepSeconds(1);
        cons.print("9");
        web.openFile("assets/9.png");
        sleep.sleepSeconds(1);
        cons.print("8");
        web.openFile("assets/8.png");
        sleep.sleepSeconds(1);
        cons.print("7");
        web.openFile("assets/7.png");
        sleep.sleepSeconds(1);
        cons.print("6");
        web.openFile("assets/6.png");
        sleep.sleepSeconds(1);
        cons.print("5");
        web.openFile("assets/5.png");
        sleep.sleepSeconds(1);
        cons.print("4");
        web.openFile("assets/4.png");
        sleep.sleepSeconds(1);
        cons.print("3");
        web.openFile("assets/3.png");
        sleep.sleepSeconds(1);
        cons.print("2");
        web.openFile("assets/2.png");
        sleep.sleepSeconds(1);
        cons.print("1");
        web.openFile("assets/1.png");
        sleep.sleepSeconds(1);
        cons.print("BLAST OFF!");
        web.openFile("assets/BLAST_OFF.png");

        double speed = 0.0;
        double altitude = 0.0;
        double seconds = 0;

        while (altitude < 70000) {
            sleep.sleep(250);
            seconds += 0.25;
            currentFuel -= 0.5;
            speed += (0.5 * 7.5) - 2.4525;
            altitude += speed;

            if (altitude >= 70000) {
                altitude = 70000;
            }

            cons.print(ansi.yellow() + "Time (seconds): " + ansi.purple() + seconds + cons.indent() + ansi.yellow() + "Current Fuel: " + ansi.purple() + currentFuel + cons.indent() + ansi.yellow() + "Speed: " + ansi.purple() + speed + cons.indent() + ansi.yellow() + "Altitude: " + ansi.purple() + altitude + ansi.reset());
        }

        sleep.sleep(500);
        cons.print(ansi.blackBackground() + name + " has landed on the moon." + ansi.reset());
        sleep.sleep(500);
        cons.print(ansi.blackBackground() + "Beginning 30 second moonwalk..." + ansi.reset());
        
        for (int i = 0; i < 30; i++) {
            cons.print(ansi.blackBackground() + (30 - i) + " seconds left in moonwalk." + ansi.reset());
            sleep.sleepSeconds(1);
        }

        cons.print(ansi.yellow() + ansi.blackBackground() + "Moonwalk over. Astronauts have gone back to " + name + "." + ansi.reset());

        cons.print(ansi.blackBackground() + "Beginning descent back to earth..." + ansi.reset());
        seconds = 0;
        speed = 0;
        while (altitude > 0) {
            boolean parachute;

            if (altitude <= 10000) {
                parachute = true;
            } else {
                parachute = false;
            }

            sleep.sleep(250);

            if (!parachute) {
                seconds += 0.25;
                currentFuel -= 0.5;
                speed += (0.5 * 7.5) + 2.4525;
                altitude -= speed;
            } else {
                seconds += 0.25;
                speed = 7.0;
                altitude -= speed;
            }

            if (altitude <= 0) {
                altitude = 0;
            }

            cons.print(ansi.yellow() + "Time (seconds): " + ansi.purple() + seconds + cons.indent() + ansi.yellow() + "Current Fuel: " + ansi.purple() + currentFuel + cons.indent() + ansi.yellow() + "Speed: " + ansi.purple() + speed + cons.indent() + ansi.yellow() + "Altitude: " + ansi.purple() + altitude + ansi.reset());
        }

        cons.print(ansi.purple() + ansi.blackBackground() + "Mission has been successful!" + ansi.reset());
        sleep.sleep(500);

        save.saveEncryptedDouble(basePath + CURRENT_SAVE_PATH, currentFuel);
    }
}
