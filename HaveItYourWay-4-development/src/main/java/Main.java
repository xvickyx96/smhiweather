
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {

        Menu obj = new Menu();
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        obj.menyStart();
    }
}