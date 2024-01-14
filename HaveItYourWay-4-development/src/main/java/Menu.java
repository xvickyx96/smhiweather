import java.io.IOException;
import java.util.Scanner;
public class Menu {
    public void menyStart () throws IOException {

        //
        System.out.println("Välkommen till väderprognosen!");
        System.out.println("Välj stad: ");
        System.out.println("1. Stockholm");
        System.out.println("2. Göteborg");
        System.out.println("3. Malmö");
        System.out.println("4. Uppsala");
        System.out.println("5. Linköping");
        System.out.println("6. Örebro");
        System.out.println("7. Västerås");
        System.out.println("8. Helsingborg");
        System.out.println("9. Norrköping");
        System.out.println("10. Borås");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String city;
        String lat;
        String lon;
        switch (choice) {
            case 1:
                city = Städer.STOCKHOLM;
                lat = "59.3293";
                lon = "18.0686";
                break;
            case 2:
                city = Städer.GÖTEBORG;
                lat = "57.7089";
                lon = "11.9746";
                break;
            case 3:
                city = Städer.MALMÖ;
                lat = "55.6049";
                lon = "13.0038";
                break;
            case 4:
                city = Städer.UPPSALA;
                lat = "59.8586";
                lon = "17.6389";
                break;
            case 5:
                city = Städer.LINKÖPING;
                lat = "58.4108";
                lon = "15.6214";
                break;
            case 6:
                city = Städer.ÖREBRO;
                lat = "59.2741";
                lon = "15.206";
                break;
            case 7:
                city = Städer.VÄSTERÅS;
                lat = "59.611";
                lon = "16.5456";
                break;
            case 8:
                city = Städer.HELSINGBORG;
                lat = "56.0465";
                lon = "12.6944";
                break;
            case 9:
                city = Städer.NORRKÖPING;
                lat = "58.5877";
                lon = "16.1924";
                break;
            case 10:
                city = Städer.BORÅS;
                lat = "57.721";
                lon = "12.9394";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }


        System.out.println("You chose: " + city);
        SmhiAPI smhiAPI = new SmhiAPI(lon, lat);
        String json = smhiAPI.getWeatherReport();
        MongoDBFasad mongoDBFasad = new MongoDBFasad();
        JsonToDoc jsonToDoc = new JsonToDoc();
        jsonToDoc.docMaker(json, city, mongoDBFasad);
        ShowWeather.multiWeather(city, mongoDBFasad);
        mongoDBFasad.close();
    }
}
