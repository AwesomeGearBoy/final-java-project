package AwesomeGearBoy.lib;
import java.io.*;

/**
 * A class that can save and load data to a file.
 * <p>
 * Use methods like saveString() or saveInt() to save data to file.
 * <p>
 * Load from these files by using methods such as loadString() or loadInt() respectively.
 * <p>Example:
 * {@snippet :
 *      public class Example {
 *          public static void main(String[] args) {
 *              String hello = "HelloWorld";
 *              SaveData save = new SaveData();
 *              
 *              save.saveString("example.txt", hello); // Saves String data
 *              
 *              String newHello = save.loadString("example.txt"); // Loads String data.
 *          }
 *      }
 * }
 * <p>
 * Enjoy the easy way to writing and reading from file!
 */

public class SaveData {
    /**
     * Saves a String data type to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The String to save.
     */
    public void saveString(String filePath, String variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(variable);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves an int data type to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The int to save.
     */
    public void saveInt(String filePath, int variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Integer.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves a double data type to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The double to save.
     */
    public void saveDouble(String filePath, double variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Double.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves a float data type to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The float to save.
     */
    public void saveFloat(String filePath, float variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Float.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves a boolean data type to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The boolean to save.
     */
    public void saveBoolean(String filePath, boolean variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Boolean.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves most variable data types to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     */
    public void saveVar(String filePath, String variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(variable);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves most variable data types to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     */
    public void saveVar(String filePath, int variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Integer.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves most variable data types to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     */
    public void saveVar(String filePath, double variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Double.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves most variable data types to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     */
    public void saveVar(String filePath, float variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Float.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Saves most variable data types to a file.
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     */
    public void saveVar(String filePath, boolean variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(Boolean.toString(variable));
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * Loads a String data type from a file.
     * @param filePath The file path to load from.
     * @return The String data from specified file.
     */
    public String loadString(String filePath) {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = line;
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads an int data type from a file.
     * @param filePath The file path to load from.
     * @return The int data from specified file.
     */
    public int loadInt(String filePath) {
        int result = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Integer.parseInt(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a double data type from a file.
     * @param filePath The file path to load from.
     * @return The double data from specified file.
     */
    public double loadDouble(String filePath) {
        double result = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Double.parseDouble(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a float data type from a file.
     * @param filePath The file path to load from.
     * @return The float data from specified file.
     */
    public float loadFloat(String filePath) {
        float result = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Float.parseFloat(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a boolean data type from a file.
     * @param filePath The file path to load from.
     * @return The boolean data from specified file.
     */
    public boolean loadBoolean(String filePath) {
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Boolean.parseBoolean(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }
}
