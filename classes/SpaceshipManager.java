package classes;
import java.util.*;

public class SpaceshipManager   {
    public static void main(String[] args)  {

        Spaceships[] spaceships = new Spaceships[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Spaceship Manager.");
        int choice;
        int count = 0;  // For number of spaceships, makes sure it doesn't make too many

        do{
            System.out.println("\nMenu:");
            System.out.println();   // TODO: Add options
            choice = input.nextInt();

            if(choice > 4 || choice < 1)    {
                System.out.println("Please input a valid choice.");
            }
            input.nextLine();

            switch(choice)  {

                case 1:
                    // TODO: Add spaceship
                    
                    break;
                case 2:
                    // TODO: Assign Astronauts

                    break;
                case 3:
                    // TODO: Delete spaceship

                    break;
                case 4:
                    // TODO: Fuel spaceship

                    break;
            }
            
        }   while(choice != 4);     // Using 4 for now, can change

input.close();
}
}