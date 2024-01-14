import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The KeyReader class reads key-value pairs from a properties file.
 */
public class KeyReader {

    Properties properties;

    /**
     * Constructs a KeyReader object and loads key-value pairs from the properties file.
     * The properties file should be named "usr.cfg" and located in the current directory.
     * If the file cannot be loaded, a RuntimeException is thrown.
     */
    public KeyReader() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("usr.cfg");
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the value associated with the "usr" key from the properties file.
     *
     * @return The value associated with the "usr" key, or null if the key is not found.
     */
    public String getUsr() {
        return properties.getProperty("usr");
    }

    /**
     * Retrieves the value associated with the "pw" key from the properties file.
     *
     * @return The value associated with the "pw" key, or null if the key is not found.
     */
    public String getPW() {
        return properties.getProperty("pw");
    }

    /**
     * Retrieves the value associated with the "adr" key from the properties file.
     *
     * @return The value associated with the "adr" key, or null if the key is not found.
     */
    public String getAdr() {
        return properties.getProperty("adr");
    }
}
