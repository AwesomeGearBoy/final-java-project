package classes;

import java.util.*;

import AwesomeGearBoy.lib.*;

public class SpaceshipManager   {

        final String COUNT_SAVE_PATH = "savedata/shipdata/7dnb39dp.data";
        Scanner input;
        SaveData save = new SaveData();
        Debug cons;
        int count = save.loadEncryptedInt(COUNT_SAVE_PATH, 0);
        Spaceships[] spaceships = new Spaceships[10];


    public SpaceshipManager(Scanner input)  {
        this.input = input;
    }
        
        
        public void showMenu() {
            boolean menuRunning = true;
            int choice;
        
        
        do{
            cons.print("Welcome to the Spaceship Manager.");
            cons.print("1. Add a spaceship");
            cons.print("2. Edit a spaceship");
            cons.print("3. Delete a spaceship");
            cons.print("4. Back to main menu");         // TODO: Fix options
            choice = input.nextInt();

            if(choice > 4 || choice < 1)    {
                System.out.println("Please input a valid choice.");
            }
            input.nextLine();

            switch(choice)  {

                case 1:
                    // TODO: Add spaceship
                    addSpaceship();
                    break;
                case 2:
                    // TODO: Assign Astronauts

                    break;
                case 3:
                    // TODO: Delete spaceship

                    break;
                case 4:
                    // TODO: Fuel spaceship
                    fuelSpaceship();
                    break;
            }
            
        }   while(menuRunning);     // Using this to keep error away for now
}

        public void addSpaceship()   {
            // TODO: Add spaceship

            if(count >= spaceships.length)  {
                cons.print("Spaceship capcity has been exceeded.");
                return;
            }

            cons.print("Enter new spaceship name: ");
            String shipName = input.nextLine();

            cons.print("Enter the fuelcapcity(lbs): ");
            int fuelCapacity = input.nextInt();

            

        }

        public void fuelSpaceship()  {

            cons.print("Please select a ship to fuel.");

            

        }
}