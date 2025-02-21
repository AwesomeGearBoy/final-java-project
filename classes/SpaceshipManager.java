package classes;
import java.util.*;
import AwesomeGearBoy.lib.*;



public class SpaceshipManager   {

        final String COUNT_SAVE_PATH = "savedata/shipdata/ ";
        Scanner input;
        SaveData save = new SaveData();
        ConsoleManager cons;
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
            cons.print("2. Assign astronauts");
            cons.print("3. Delete a spaceship");
            cons.print("4. Back to main menu");         // TODO: Fix options
            choice = input.nextInt();

            if(choice > 4 || choice < 1)    {
                System.out.println("Please input a valid choice.");
            }
            input.nextLine();

            switch(choice)  {

                case 1:
                    // TODO: Edit addS paceship
                    addSpaceship();
                    break;
                case 2:
                    // TODO: Assign Astronauts

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

        public void deleteSpaceship()   {
            if(count <= 0)  {
                cons.print("Cannot delete spaceships.");
            }

            cons.print("Select a spaceship to delete (1-10).");
            cons.print();       //  TODO: array list of ships
            s = input.nextLine();        //  TODO: add input varible 
        }

        public void fuelSpaceship()  {

            cons.print("Please select a ship to fuel (1-10).");
            for(int i = 0; i < spaceships.size(); i++)
            cons.print();       //  TODO: array list of ships
            s = input.nextLine();        // TODO: add the input varible

            

        }
}