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
     * <p>Saves a String just like saveString(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using loadEncryptedString().
     * @param filePath The save path to the file to write to.
     * @param variable The String to save.
     * @see saveString()
     * @see loadEncryptedString()
     */
    public void saveEncryptedString(String filePath, String variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(variable);
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves an integer just like saveInt(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using loadEncryptedInt().
     * @param filePath The save path to the file to write to.
     * @param variable The int to save.
     * @see saveInt()
     * @see loadEncryptedInt()
     */
    public void saveEncryptedInt(String filePath, int variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Integer.toString(variable));
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves a double just like saveDouble(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using loadEncryptedDouble().
     * @param filePath The save path to the file to write to.
     * @param variable The double to save.
     * @see saveDouble()
     * @see loadEncryptedDouble()
     */
    public void saveEncryptedDouble(String filePath, double variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Double.toString(variable));
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves a float just like saveFloat(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using loadEncryptedFloat().
     * @param filePath The save path to the file to write to.
     * @param variable The float to save.
     * @see saveFloat()
     * @see loadEncryptedFloat()
     */
    public void saveEncryptedFloat(String filePath, float variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Float.toString(variable));
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves a boolean just like saveBoolean(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using loadEncryptedBoolean().
     * @param filePath The save path to the file to write to.
     * @param variable The boolean to save.
     * @see saveBoolean()
     * @see loadEncryptedBoolean()
     */
    public void saveEncryptedBoolean(String filePath, boolean variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Boolean.toString(variable));
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    public void saveEncryptedVar(String filePath, String variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(variable);
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves a variable just like saveVar(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using the correct loading method (ex. loadEncryptedString(), loadEncryptedInt(), etc).
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     * @see saveVar()
     * @see loadEncryptedString()
     * @see loadEncryptedInt()
     */
    public void saveEncryptedVar(String filePath, int variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Integer.toString(variable));
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves a variable just like saveVar(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using the correct loading method (ex. loadEncryptedString(), loadEncryptedInt(), etc).
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     * @see saveVar()
     * @see loadEncryptedString()
     * @see loadEncryptedInt()
     */
    public void saveEncryptedVar(String filePath, double variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Double.toString(variable));
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves a variable just like saveVar(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using the correct loading method (ex. loadEncryptedString(), loadEncryptedInt(), etc).
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     * @see saveVar()
     * @see loadEncryptedString()
     * @see loadEncryptedInt()
     */
    public void saveEncryptedVar(String filePath, float variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Float.toString(variable));
            writer.write(encr);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
    }

    /**
     * <p>Saves a variable just like saveVar(), but encrypts the data making it unreadable to anyone looking at the file. 
     * <p>You can load the data by using the correct loading method (ex. loadEncryptedString(), loadEncryptedInt(), etc).
     * @param filePath The save path to the file to write to.
     * @param variable The variable to save.
     * @see saveVar()
     * @see loadEncryptedString()
     * @see loadEncryptedInt()
     */
    public void saveEncryptedVar(String filePath, boolean variable) {
        try {
            FileWriter writer = new FileWriter(filePath);
            String encr = encryptString(Boolean.toString(variable));
            writer.write(encr);
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
     * Loads a String data type from a file.
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The String data from specified file.
     */
    public String loadString(String filePath, String def) {
        String result = def;
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
     * Loads an int data type from a file.
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The int data from specified file.
     */
    public int loadInt(String filePath, int def) {
        int result = def;
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
     * Loads a double data type from a file.
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The double data from specified file.
     */
    public double loadDouble(String filePath, double def) {
        double result = def;
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
        float result = 0.0f;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Float.parseFloat(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a float data type from a file.
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The float data from specified file.
     */
    public float loadFloat(String filePath, float def) {
        float result = def;
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

    /**
     * Loads a boolean data type from a file.
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The boolean data from specified file.
     */
    public boolean loadBoolean(String filePath, boolean def) {
        boolean result = def;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Boolean.parseBoolean(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a String encrypted by saveEncryptedString().
     * @param filePath The file path to load from.
     * @return The unencrypted String data from the specified file.
     * @see saveEncryptedString()
     */
    public String loadEncryptedString(String filePath) {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = unencryptString(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a String encrypted by saveEncryptedString().
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The unencrypted String data from the specified file.
     * @see saveEncryptedString()
     */
    public String loadEncryptedString(String filePath, String def) {
        String result = def;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = unencryptString(line);
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads an int encrypted by saveEncryptedInt().
     * @param filePath The file path to load from.
     * @return The unencrypted int data from the specified file.
     * @see saveEncryptedInt()
     */
    public int loadEncryptedInt(String filePath) {
        int result = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Integer.parseInt(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads an int encrypted by saveEncryptedInt().
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The unencrypted int data from the specified file.
     * @see saveEncryptedInt()
     */
    public int loadEncryptedInt(String filePath, int def) {
        int result = def;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Integer.parseInt(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a double encrypted by saveEncryptedDouble().
     * @param filePath The file path to load from.
     * @return The unencrypted double data from the specified file.
     * @see saveEncryptedDouble()
     */
    public double loadEncryptedDouble(String filePath) {
        double result = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Double.parseDouble(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a double encrypted by saveEncryptedDouble().
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The unencrypted double data from the specified file.
     * @see saveEncryptedDouble()
     */
    public double loadEncryptedDouble(String filePath, double def) {
        double result = def;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Double.parseDouble(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a float encrypted by saveEncryptedFloat().
     * @param filePath The file path to load from.
     * @return The unencrypted float data from the specified file.
     * @see saveEncryptedFloat()
     */
    public float loadEncryptedFloat(String filePath) {
        float result = 0.0f;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Float.parseFloat(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a float encrypted by saveEncryptedFloat().
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The unencrypted float data from the specified file.
     * @see saveEncryptedFloat()
     */
    public float loadEncryptedFloat(String filePath, float def) {
        float result = def;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Float.parseFloat(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a boolean encrypted by saveEncryptedBoolean().
     * @param filePath The file path to load from.
     * @return The unencrypted boolean data from the specified file.
     * @see saveEncryptedBoolean()
     */
    public boolean loadEncryptedBoolean(String filePath) {
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Boolean.parseBoolean(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    /**
     * Loads a boolean encrypted by saveEncryptedBoolean().
     * @param filePath The file path to load from.
     * @param def The default value if file does not exist
     * @return The unencrypted boolean data from the specified file.
     * @see saveEncryptedBoolean()
     */
    public boolean loadEncryptedBoolean(String filePath, boolean def) {
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            result = Boolean.parseBoolean(unencryptString(line));
        } catch (IOException | NumberFormatException excp) {
            excp.printStackTrace();
        }
        return result;
    }

    private String encryptString(String x) {
        StringBuilder encrypted = new StringBuilder(x);
    
        for (int i = 0; i < encrypted.length(); i++) {
            if (encrypted.charAt(i) == '`') {
                encrypted.setCharAt(i, '1');
            } else if (encrypted.charAt(i) == '1') {
                encrypted.setCharAt(i, '2');
            } else if (encrypted.charAt(i) == '2') {
                encrypted.setCharAt(i, '3');
            } else if (encrypted.charAt(i) == '3') {
                encrypted.setCharAt(i, '4');
            } else if (encrypted.charAt(i) == '4') {
                encrypted.setCharAt(i, '5');
            } else if (encrypted.charAt(i) == '5') {
                encrypted.setCharAt(i, '6');
            } else if (encrypted.charAt(i) == '6') {
                encrypted.setCharAt(i, '7');
            } else if (encrypted.charAt(i) == '8') {
                encrypted.setCharAt(i, '9');
            } else if (encrypted.charAt(i) == '9') {
                encrypted.setCharAt(i, '0');
            } else if (encrypted.charAt(i) == '0') {
                encrypted.setCharAt(i, '-');
            } else if (encrypted.charAt(i) == '-') {
                encrypted.setCharAt(i, '=');
            } else if (encrypted.charAt(i) == '=') {
                encrypted.setCharAt(i, '`');
            } else if (encrypted.charAt(i) == 'q') {
                encrypted.setCharAt(i, 'w');
            } else if (encrypted.charAt(i) == 'w') {
                encrypted.setCharAt(i, 'e');
            } else if (encrypted.charAt(i) == 'e') {
                encrypted.setCharAt(i, 'r');
            } else if (encrypted.charAt(i) == 'r') {
                encrypted.setCharAt(i, 't');
            } else if (encrypted.charAt(i) == 't') {
                encrypted.setCharAt(i, 'y');
            } else if (encrypted.charAt(i) == 'y') {
                encrypted.setCharAt(i, 'u');
            } else if (encrypted.charAt(i) == 'u') {
                encrypted.setCharAt(i, 'i');
            } else if (encrypted.charAt(i) == 'i') {
                encrypted.setCharAt(i, 'o');
            } else if (encrypted.charAt(i) == 'o') {
                encrypted.setCharAt(i, 'p');
            } else if (encrypted.charAt(i) == 'p') {
                encrypted.setCharAt(i, '[');
            } else if (encrypted.charAt(i) == '[') {
                encrypted.setCharAt(i, ']');
            } else if (encrypted.charAt(i) == ']') {
                encrypted.setCharAt(i, '\\');
            } else if (encrypted.charAt(i) == '\\') {
                encrypted.setCharAt(i, 'q');
            } else if (encrypted.charAt(i) == 'a') {
                encrypted.setCharAt(i, 's');
            } else if (encrypted.charAt(i) == 's') {
                encrypted.setCharAt(i, 'd');
            } else if (encrypted.charAt(i) == 'd') {
                encrypted.setCharAt(i, 'f');
            } else if (encrypted.charAt(i) == 'f') {
                encrypted.setCharAt(i, 'g');
            } else if (encrypted.charAt(i) == 'g') {
                encrypted.setCharAt(i, 'h');
            } else if (encrypted.charAt(i) == 'h') {
                encrypted.setCharAt(i, 'j');
            } else if (encrypted.charAt(i) == 'j') {
                encrypted.setCharAt(i, 'k');
            } else if (encrypted.charAt(i) == 'k') {
                encrypted.setCharAt(i, 'l');
            } else if (encrypted.charAt(i) == 'l') {
                encrypted.setCharAt(i, ';');
            } else if (encrypted.charAt(i) == ';') {
                encrypted.setCharAt(i, '\'');
            } else if (encrypted.charAt(i) == '\'') {
                encrypted.setCharAt(i, 'a');
            } else if (encrypted.charAt(i) == 'z') {
                encrypted.setCharAt(i, 'x');
            } else if (encrypted.charAt(i) == 'x') {
                encrypted.setCharAt(i, 'c');
            } else if (encrypted.charAt(i) == 'c') {
                encrypted.setCharAt(i, 'v');
            } else if (encrypted.charAt(i) == 'v') {
                encrypted.setCharAt(i, 'b');
            } else if (encrypted.charAt(i) == 'b') {
                encrypted.setCharAt(i, 'n');
            } else if (encrypted.charAt(i) == 'n') {
                encrypted.setCharAt(i, 'm');
            } else if (encrypted.charAt(i) == 'm') {
                encrypted.setCharAt(i, ',');
            } else if (encrypted.charAt(i) == ',') {
                encrypted.setCharAt(i, '.');
            } else if (encrypted.charAt(i) == '.') {
                encrypted.setCharAt(i, '/');
            } else if (encrypted.charAt(i) == '/') {
                encrypted.setCharAt(i, 'z');
            } else if (encrypted.charAt(i) == '~') {
                encrypted.setCharAt(i, '!');
            } else if (encrypted.charAt(i) == '!') {
                encrypted.setCharAt(i, '@');
            } else if (encrypted.charAt(i) == '@') {
                encrypted.setCharAt(i, '#');
            } else if (encrypted.charAt(i) == '#') {
                encrypted.setCharAt(i, '$');
            } else if (encrypted.charAt(i) == '$') {
                encrypted.setCharAt(i, '%');
            } else if (encrypted.charAt(i) == '%') {
                encrypted.setCharAt(i, '^');
            } else if (encrypted.charAt(i) == '^') {
                encrypted.setCharAt(i, '&');
            } else if (encrypted.charAt(i) == '&') {
                encrypted.setCharAt(i, '*');
            } else if (encrypted.charAt(i) == '*') {
                encrypted.setCharAt(i, '(');
            } else if (encrypted.charAt(i) == '(') {
                encrypted.setCharAt(i, ')');
            } else if (encrypted.charAt(i) == ')') {
                encrypted.setCharAt(i, '_');
            } else if (encrypted.charAt(i) == '_') {
                encrypted.setCharAt(i, '+');
            } else if (encrypted.charAt(i) == '+') {
                encrypted.setCharAt(i, '~');
            } else if (encrypted.charAt(i) == 'Q') {
                encrypted.setCharAt(i, 'W');
            } else if (encrypted.charAt(i) == 'W') {
                encrypted.setCharAt(i, 'E');
            } else if (encrypted.charAt(i) == 'E') {
                encrypted.setCharAt(i, 'R');
            } else if (encrypted.charAt(i) == 'R') {
                encrypted.setCharAt(i, 'T');
            } else if (encrypted.charAt(i) == 'T') {
                encrypted.setCharAt(i, 'Y');
            } else if (encrypted.charAt(i) == 'Y') {
                encrypted.setCharAt(i, 'U');
            } else if (encrypted.charAt(i) == 'U') {
                encrypted.setCharAt(i, 'I');
            } else if (encrypted.charAt(i) == 'I') {
                encrypted.setCharAt(i, 'O');
            } else if (encrypted.charAt(i) == 'O') {
                encrypted.setCharAt(i, 'P');
            } else if (encrypted.charAt(i) == 'P') {
                encrypted.setCharAt(i, '{');
            } else if (encrypted.charAt(i) == '{') {
                encrypted.setCharAt(i, '}');
            } else if (encrypted.charAt(i) == '}') {
                encrypted.setCharAt(i, '|');
            } else if (encrypted.charAt(i) == '|') {
                encrypted.setCharAt(i, 'Q');
            } else if (encrypted.charAt(i) == 'A') {
                encrypted.setCharAt(i, 'S');
            } else if (encrypted.charAt(i) == 'S') {
                encrypted.setCharAt(i, 'D');
            } else if (encrypted.charAt(i) == 'D') {
                encrypted.setCharAt(i, 'F');
            } else if (encrypted.charAt(i) == 'F') {
                encrypted.setCharAt(i, 'G');
            } else if (encrypted.charAt(i) == 'G') {
                encrypted.setCharAt(i, 'H');
            } else if (encrypted.charAt(i) == 'H') {
                encrypted.setCharAt(i, 'J');
            } else if (encrypted.charAt(i) == 'J') {
                encrypted.setCharAt(i, 'K');
            } else if (encrypted.charAt(i) == 'K') {
                encrypted.setCharAt(i, 'L');
            } else if (encrypted.charAt(i) == 'L') {
                encrypted.setCharAt(i, ':');
            } else if (encrypted.charAt(i) == ':') {
                encrypted.setCharAt(i, '"');
            } else if (encrypted.charAt(i) == '"') {
                encrypted.setCharAt(i, 'A');
            } else if (encrypted.charAt(i) == 'Z') {
                encrypted.setCharAt(i, 'X');
            } else if (encrypted.charAt(i) == 'X') {
                encrypted.setCharAt(i, 'C');
            } else if (encrypted.charAt(i) == 'C') {
                encrypted.setCharAt(i, 'V');
            } else if (encrypted.charAt(i) == 'V') {
                encrypted.setCharAt(i, 'B');
            } else if (encrypted.charAt(i) == 'B') {
                encrypted.setCharAt(i, 'N');
            } else if (encrypted.charAt(i) == 'N') {
                encrypted.setCharAt(i, 'M');
            } else if (encrypted.charAt(i) == 'M') {
                encrypted.setCharAt(i, '<');
            } else if (encrypted.charAt(i) == '<') {
                encrypted.setCharAt(i, '>');
            } else if (encrypted.charAt(i) == '>') {
                encrypted.setCharAt(i, '?');
            } else if (encrypted.charAt(i) == '?') {
                encrypted.setCharAt(i, 'Z');
            } else if (encrypted.charAt(i) == ' ') {
                encrypted.setCharAt(i, ' ');
            } else {
                encrypted.setCharAt(i, '>');
            }
        }

        return encrypted.toString();
    }

    private String unencryptString(String x) {
        StringBuilder unencrypted = new StringBuilder(x);

        for (int i = 0; i < x.length(); i++) {
            if (unencrypted.charAt(i) == '=') {
                unencrypted.setCharAt(i, '-');
            } else if (unencrypted.charAt(i) == '-') {
                unencrypted.setCharAt(i, '0');
            } else if (unencrypted.charAt(i) == '0') {
                unencrypted.setCharAt(i, '9');
            } else if (unencrypted.charAt(i) == '9') {
                unencrypted.setCharAt(i, '8');
            } else if (unencrypted.charAt(i) == '8') {
                unencrypted.setCharAt(i, '7');
            } else if (unencrypted.charAt(i) == '7') {
                unencrypted.setCharAt(i, '6');
            } else if (unencrypted.charAt(i) == '6') {
                unencrypted.setCharAt(i, '5');
            } else if (unencrypted.charAt(i) == '5') {
                unencrypted.setCharAt(i, '4');
            } else if (unencrypted.charAt(i) == '4') {
                unencrypted.setCharAt(i, '3');
            } else if (unencrypted.charAt(i) == '3') {
                unencrypted.setCharAt(i, '2');
            } else if (unencrypted.charAt(i) == '2') {
                unencrypted.setCharAt(i, '1');
            } else if (unencrypted.charAt(i) == '1') {
                unencrypted.setCharAt(i, '`');
            } else if (unencrypted.charAt(i) == '`') {
                unencrypted.setCharAt(i, '=');
            } else if (unencrypted.charAt(i) == '\\') {
                unencrypted.setCharAt(i, ']');
            } else if (unencrypted.charAt(i) == ']') {
                unencrypted.setCharAt(i, '[');
            } else if (unencrypted.charAt(i) == '[') {
                unencrypted.setCharAt(i, 'p');
            } else if (unencrypted.charAt(i) == 'p') {
                unencrypted.setCharAt(i, 'o');
            } else if (unencrypted.charAt(i) == 'o') {
                unencrypted.setCharAt(i, 'i');
            } else if (unencrypted.charAt(i) == 'i') {
                unencrypted.setCharAt(i, 'u');
            } else if (unencrypted.charAt(i) == 'u') {
                unencrypted.setCharAt(i, 'y');
            } else if (unencrypted.charAt(i) == 'y') {
                unencrypted.setCharAt(i, 't');
            } else if (unencrypted.charAt(i) == 't') {
                unencrypted.setCharAt(i, 'r');
            } else if (unencrypted.charAt(i) == 'r') {
                unencrypted.setCharAt(i, 'e');
            } else if (unencrypted.charAt(i) == 'e') {
                unencrypted.setCharAt(i, 'w');
            } else if (unencrypted.charAt(i) == 'w') {
                unencrypted.setCharAt(i, 'q');
            } else if (unencrypted.charAt(i) == 'q') {
                unencrypted.setCharAt(i, '\\');
            } else if (unencrypted.charAt(i) == '\'') {
                unencrypted.setCharAt(i, ';');
            } else if (unencrypted.charAt(i) == ';') {
                unencrypted.setCharAt(i, 'l');
            } else if (unencrypted.charAt(i) == 'l') {
                unencrypted.setCharAt(i, 'k');
            } else if (unencrypted.charAt(i) == 'k') {
                unencrypted.setCharAt(i, 'j');
            } else if (unencrypted.charAt(i) == 'j') {
                unencrypted.setCharAt(i, 'h');
            } else if (unencrypted.charAt(i) == 'h') {
                unencrypted.setCharAt(i, 'g');
            } else if (unencrypted.charAt(i) == 'g') {
                unencrypted.setCharAt(i, 'f');
            } else if (unencrypted.charAt(i) == 'f') {
                unencrypted.setCharAt(i, 'd');
            } else if (unencrypted.charAt(i) == 'd') {
                unencrypted.setCharAt(i, 's');
            } else if (unencrypted.charAt(i) == 's') {
                unencrypted.setCharAt(i, 'a');
            } else if (unencrypted.charAt(i) == 'a') {
                unencrypted.setCharAt(i, '\'');
            } else if (unencrypted.charAt(i) == '/') {
                unencrypted.setCharAt(i, '.');
            } else if (unencrypted.charAt(i) == '.') {
                unencrypted.setCharAt(i, ',');
            } else if (unencrypted.charAt(i) == ',') {
                unencrypted.setCharAt(i, 'm');
            } else if (unencrypted.charAt(i) == 'm') {
                unencrypted.setCharAt(i, 'n');
            } else if (unencrypted.charAt(i) == 'n') {
                unencrypted.setCharAt(i, 'b');
            } else if (unencrypted.charAt(i) == 'b') {
                unencrypted.setCharAt(i, 'v');
            } else if (unencrypted.charAt(i) == 'v') {
                unencrypted.setCharAt(i, 'c');
            } else if (unencrypted.charAt(i) == 'c') {
                unencrypted.setCharAt(i, 'x');
            } else if (unencrypted.charAt(i) == 'x') {
                unencrypted.setCharAt(i, 'z');
            } else if (unencrypted.charAt(i) == 'z') {
                unencrypted.setCharAt(i, '/');
            } else if (unencrypted.charAt(i) == '+') {
                unencrypted.setCharAt(i, '_');
            } else if (unencrypted.charAt(i) == '_') {
                unencrypted.setCharAt(i, ')');
            } else if (unencrypted.charAt(i) == ')') {
                unencrypted.setCharAt(i, '(');
            } else if (unencrypted.charAt(i) == '(') {
                unencrypted.setCharAt(i, '*');
            } else if (unencrypted.charAt(i) == '*') {
                unencrypted.setCharAt(i, '&');
            } else if (unencrypted.charAt(i) == '&') {
                unencrypted.setCharAt(i, '^');
            } else if (unencrypted.charAt(i) == '^') {
                unencrypted.setCharAt(i, '%');
            } else if (unencrypted.charAt(i) == '%') {
                unencrypted.setCharAt(i, '$');
            } else if (unencrypted.charAt(i) == '$') {
                unencrypted.setCharAt(i, '#');
            } else if (unencrypted.charAt(i) == '#') {
                unencrypted.setCharAt(i, '@');
            } else if (unencrypted.charAt(i) == '@') {
                unencrypted.setCharAt(i, '!');
            } else if (unencrypted.charAt(i) == '!') {
                unencrypted.setCharAt(i, '~');
            } else if (unencrypted.charAt(i) == '~') {
                unencrypted.setCharAt(i, '+');
            } else if (unencrypted.charAt(i) == '|') {
                unencrypted.setCharAt(i, '}');
            } else if (unencrypted.charAt(i) == '}') {
                unencrypted.setCharAt(i, '{');
            } else if (unencrypted.charAt(i) == '{') {
                unencrypted.setCharAt(i, 'P');
            } else if (unencrypted.charAt(i) == 'P') {
                unencrypted.setCharAt(i, 'O');
            } else if (unencrypted.charAt(i) == 'O') {
                unencrypted.setCharAt(i, 'I');
            } else if (unencrypted.charAt(i) == 'I') {
                unencrypted.setCharAt(i, 'U');
            } else if (unencrypted.charAt(i) == 'U') {
                unencrypted.setCharAt(i, 'Y');
            } else if (unencrypted.charAt(i) == 'Y') {
                unencrypted.setCharAt(i, 'T');
            } else if (unencrypted.charAt(i) == 'T') {
                unencrypted.setCharAt(i, 'R');
            } else if (unencrypted.charAt(i) == 'R') {
                unencrypted.setCharAt(i, 'E');
            } else if (unencrypted.charAt(i) == 'E') {
                unencrypted.setCharAt(i, 'W');
            } else if (unencrypted.charAt(i) == 'W') {
                unencrypted.setCharAt(i, 'Q');
            } else if (unencrypted.charAt(i) == 'Q') {
                unencrypted.setCharAt(i, '|');
            } else if (unencrypted.charAt(i) == '"') {
                unencrypted.setCharAt(i, ':');
            } else if (unencrypted.charAt(i) == ':') {
                unencrypted.setCharAt(i, 'L');
            } else if (unencrypted.charAt(i) == 'L') {
                unencrypted.setCharAt(i, 'K');
            } else if (unencrypted.charAt(i) == 'K') {
                unencrypted.setCharAt(i, 'J');
            } else if (unencrypted.charAt(i) == 'J') {
                unencrypted.setCharAt(i, 'H');
            } else if (unencrypted.charAt(i) == 'H') {
                unencrypted.setCharAt(i, 'G');
            } else if (unencrypted.charAt(i) == 'G') {
                unencrypted.setCharAt(i, 'F');
            } else if (unencrypted.charAt(i) == 'F') {
                unencrypted.setCharAt(i, 'D');
            } else if (unencrypted.charAt(i) == 'D') {
                unencrypted.setCharAt(i, 'S');
            } else if (unencrypted.charAt(i) == 'S') {
                unencrypted.setCharAt(i, 'A');
            } else if (unencrypted.charAt(i) == 'A') {
                unencrypted.setCharAt(i, '"');
            } else if (unencrypted.charAt(i) == '?') {
                unencrypted.setCharAt(i, '>');
            } else if (unencrypted.charAt(i) == '>') {
                unencrypted.setCharAt(i, '<');
            } else if (unencrypted.charAt(i) == '<') {
                unencrypted.setCharAt(i, 'M');
            } else if (unencrypted.charAt(i) == 'M') {
                unencrypted.setCharAt(i, 'N');
            } else if (unencrypted.charAt(i) == 'N') {
                unencrypted.setCharAt(i, 'B');
            } else if (unencrypted.charAt(i) == 'B') {
                unencrypted.setCharAt(i, 'V');
            } else if (unencrypted.charAt(i) == 'V') {
                unencrypted.setCharAt(i, 'C');
            } else if (unencrypted.charAt(i) == 'C') {
                unencrypted.setCharAt(i, 'X');
            } else if (unencrypted.charAt(i) == 'X') {
                unencrypted.setCharAt(i, 'Z');
            } else if (unencrypted.charAt(i) == 'Z') {
                unencrypted.setCharAt(i, '?');
            } else if (unencrypted.charAt(i) == ' ') {
                unencrypted.setCharAt(i, ' ');
            } else {
                unencrypted.setCharAt(i, '?');
            }
        }

        return unencrypted.toString();
    }
}
