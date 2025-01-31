// This file can be deleted before beginning the project, but it shows how to use everything in my library, sooo here we go

// Just like everything else, you need to first import the library and what you're looking for
import AwesomeGearBoy.lib.AnsiColors;
import AwesomeGearBoy.lib.SaveData;
import AwesomeGearBoy.lib.SleepTime;
import AwesomeGearBoy.lib.WebControl;
// These can also be written out like below:
// import AwesomeGearBoy.lib.*;

// Import Java scanner
import java.util.*;

public class AGBLibExample {
    public static void main(String[] args) {
        int choice; // Integer for user choice
        boolean systemRunning = true; // Create boolean for testing if the program should be running

        Scanner input = new Scanner(System.in); // Instantiate Scanner class

        AnsiColors color = new AnsiColors(); // Instantiate AnsiColors class
        SaveData save = new SaveData(); // Instantiate SaveData class
        SleepTime sleep = new SleepTime(); // Instantiate SleepTime class
        WebControl web = new WebControl(); // Instantiate WebControl class

        do {
            // Get a decision from user
            print(color.yellow() + color.blackBackground() + "Which action?" + color.reset()); 
            // As you can see, those colors at the beginning of this string will affect everything after them. You need to reset the colors after every use to avoid things that aren't supposed to be colored being colored.
            
            print("1. Countdown");
            print("2. Save to file");
            print("3. Load data");
            print("4. Open website");
            print("5. Exit");
            printSl("Make choice (1-4): ");
            choice = input.nextInt(); // Get user's choice

            // Use a switch-case statement to process choice
            switch (choice) {
                case 1: /// PROGRAM SLEEPING

                    // To create a countdown, you can put the program to sleep for a bit between counts.
                    // This for loop will run five times
                    for (int i = 5; i > 0; i--) {
                        print(i); // Prints number

                        // Below, I make it so that you are able to have the program "pause" for 1500 milliseconds
                        sleep.sleep(1500);

                        // If longer periods are needed, you can also use sleepMinutes() or sleepSeconds() for longer periods of time
                        // sleep() is the most specific method for this, however. For example: 1500 milliseconds = 1.5 seconds. You can't write that with sleepSeconds().
                    }

                    break; // Break the loop once finished

                case 2: /// SAVING AND LOADING DATA

                    String file;
                    input.nextLine(); // Consume leftover line

                    print("File to save to (will be saved in 'savedata' folder, must have file extension like .txt)?");
                    file = input.nextLine(); // Get what the file will be called
                    
                    print("Save what string?");
                    save.saveEncryptedVar("savedata/" + file, input.nextLine()); // Saves the next input to the file, encrypted so that it is not readable

                    // saveVar() is very generic, and can process variable if you don't know what type to do, but it's better to use saveString(), or saveInt(), or saveDouble()
                    // To load data later, you use loadString(), loadDouble(), loadInt(), etc.
                    // There is no loadVar()

                    break; // Break the loop once finished
                
                case 3: /// LOADING DATA

                    input.nextLine(); // Consume leftover line
                    print("Load data from what file (in 'savedata' folder)?");
                    String loadFile = input.nextLine(); // Get input
                    String load = save.loadEncryptedString("savedata/" + loadFile, "File does not exist");
                    print("Message from '" + loadFile + "': " + load); // Load the encrypted data; If file is non-existant the default is loaded, which in this case is "File does not exist."

                    break; // Break the loop once finished

                case 4: /// OPENING A WEBSITE

                    // Pretty simple. Just do this:
                    web.openWebpage("https://www.google.com/search?q=potato&sca_esv=c7459735fc04b658&udm=2&biw=1920&bih=945&sxsrf=AHTn8zrDFq5i94d-UH3InUCSuEX1a3_mNQ%3A1738187304774&ei=KKKaZ6f-LqmU5OMPwIPmwQ8&ved=0ahUKEwinsuqm9JuLAxUpCnkGHcCBOfgQ4dUDCBQ&uact=5&oq=potato&gs_lp=EgNpbWciBnBvdGF0bzINEAAYgAQYsQMYQxiKBTIOEAAYgAQYsQMYgwEYigUyChAAGIAEGEMYigUyCBAAGIAEGLEDMggQABiABBixAzIIEAAYgAQYsQMyChAAGIAEGEMYigUyCBAAGIAEGLEDMgoQABiABBhDGIoFMggQABiABBixA0jwDVAAWLcLcAB4AJABAJgBVaABxQOqAQE2uAEDyAEA-AEBmAIGoALkA8ICBBAjGCfCAhAQABiABBixAxhDGIMBGIoFmAMAkgcBNqAHhCM&sclient=img#vhid=afHHUFDs6G4XIM&vssid=mosaic");
                    
                    break; // Break the loop once finished

                case 5:
                    systemRunning = false; // Set systemRunning to false to close program
                    break; // Break the loop once finished

                default: // If there is no case, bad data must have came from the user
                    print("Insufficient data. Try again.");
                    break;
            }
        } while (systemRunning);

        print("Goodbye!");
        input.close(); // Close Scanner
        System.exit(0); // Exit program
    }

    public static void print() {
        System.out.println();
    }

    public static void print(String x) {
        System.out.println(x);
    }

    public static void print(int x) {
        System.out.println(x);
    }

    public static void printSl(String x) {
        System.out.print(x);
    }

    public static void printSl(int x) {
        System.out.print(x);
    }
}
