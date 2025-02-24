package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

public class SpaceshipManager   {

        final String SHIP_SAVE_PATH = "savedata/shipdata/s7wko92b.data";
        final String NAME_SAVE_PATH = "72gbedjj.data";
        final String ASSIGNED_SAVE_PATH = "83h3urum.data";
        final String CAPACITY_SAVE_PATH = "cvy62md8.data";
        final String CURRENT_SAVE_PATH = "2vsyas8x.data";
        Scanner input;
        SaveData save = new SaveData();
        ConsoleManager cons;
        int count = save.loadEncryptedInt(SHIP_SAVE_PATH, 0);
        boolean[] defaultAssigned = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
        boolean[] defaultSpaceship = {false, false, false, false, false, false, false, false, false, false};


    public SpaceshipManager(Scanner input)  {
        this.input = input;
    }
        
        
        public void showMenu() {
            boolean menuRunning = true;
            int choice;
        
        
        do{
            cons.print("Welcome to the Spaceship Manager.");
            cons.print("1. Add a spaceship");
            cons.print("2. Assign astronauts");
            cons.print("3. Delete a spaceship");
            cons.print("4. Fuel a spaceship");         // TODO: Fix options
            choice = input.nextInt();

            if(choice > 4 || choice < 1)    {
                System.out.println("Please input a valid choice.");
            }
            input.nextLine();

            switch(choice)  {

                case 1:
                    // TODO: Edit add Spaceship
                    addSpaceship();
                    break;
                case 2:
                    // TODO: Assign Astronauts
                    assignAstronauts();
                    break;
                case 3:
                    // TODO: Edit deleteSpaceship
                    deleteSpaceship();
                    break;
                case 4:
                    // TODO: Edit fuelSpaceship
                    fuelSpaceship();
                    break;
            }
            
        }   while(menuRunning);     // Using this to keep error away for now
}

        private void addSpaceship()   {
            // TODO: Add spaceship


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
            input.next();

            String basicPath = "savedata/shipdata/ship" + count + "/";
            save.saveEncryptedString(basicPath + NAME_SAVE_PATH, name);
            save.saveEncryptedDouble(basicPath + CAPACITY_SAVE_PATH, fuelCapacity);
        }

        private void assignAstronauts()  {
            AstroManager astroManager = new AstroManager(input, cons);
            boolean[] astro = astroManager.getAstronauts();
            boolean[] assigned = save.loadEncryptedBooleanArray(ASSIGNED_SAVE_PATH, defaultAssigned);

            int count = -1; // Initialize count to an invalid value
    
            cons.print("Which ship do you want to assign to (1-10)?");
        
            while (true) {
                if (input.hasNextInt()) {
                    count = input.nextInt();
                    input.nextLine(); // Consume newline
        
                    if (count >= 1 && count <= 10) {
                        count -= 1; // Convert to zero-based index
                        break;
                    } else {
                        cons.print("Invalid choice. Please enter a number between 1 and 10.");
                    }
                } else {
                    cons.print("Invalid input. Please enter a valid number.");
                    input.next(); // Consume invalid input
                }
            }

            cons.print("How many astronauts do you want to assign to this ship (1-15)?");
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

            String[] astronauts = new String[count];
            for (int i = 0; i < count; i++) {
                cons.print("What astronaut do you want to assign to this ship (Astonaut #" + (i + 1) + ")?");
                cons.printSl("Enter the number if the Astronaut to assign: ");
                astronauts[i] = input.nextLine();
                input.next();
            }
        }

        private void deleteSpaceship()   {

            while(true) {
                if(input.hasNextInt())  {
                    count = input.nextInt();
                    input.nextLine();

                    if  (count >= 1 && count <= 10) {
                        count -= 1;
                        break;
                    }   else    {
                            cons.print("Invalid choice. Please enter a number between 1 and 10.");
                    }
                }   else{
                    cons.print("Invalid input. Please enter valid number.");
                    input.next();
                }

            }
        }

        private void fuelSpaceship()  {

            cons.print("Please select a ship to fuel (1-10).");
            for(int i = 0; i < ship.length(); i++)
            cons.print();       //  TODO: array list of ships
            s = input.nextLine();        // TODO: add the input varible

            

        }
}