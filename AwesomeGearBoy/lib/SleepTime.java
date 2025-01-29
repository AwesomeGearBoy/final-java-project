package AwesomeGearBoy.lib;

/**
 * SleepTime is a class that holds methods that allow you to have the program "sleep" in a way.
 * <p>
 * The program will be dormant for however long you specify it to. This means that nothing will run during the sleeping period. After it is done sleeping, it will run the next bit of code afterwards.
 */

public class SleepTime {
    /**
     * Allows the program to "sleep" for the amount of milliseconds specified.
     * @param milliseconds Amount of milliseconds specified.
     */
    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException excp) {
            System.err.println("Sleep interrupted: " + excp.getMessage());
        }
    }

    /**
     * Allows the program to "sleep" for the amount of seconds specified.
     * @param seconds Amount of seconds specified.
     */
    public void sleepSeconds(int seconds) {
        try {
            Thread.sleep((seconds * 1000));
        } catch (InterruptedException excp) {
            System.err.println("Sleep interrupted: " + excp.getMessage());
        }
    }

    /**
     * Allows the program to "sleep" for the amount of minutes specified.
     * @param minutes Amount of minutes specified.
     */
    public void sleepMinutes(int minutes) {
        try {
            Thread.sleep((minutes * 60000));
        } catch (InterruptedException excp) {
            System.err.println("Sleep interrupted: " + excp.getMessage());
        }
    }
}
