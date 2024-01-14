import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class provides a simple way to retrieve weather data from the Swedish Meteorological and Hydrological Institute (SMHI) API.
 * It requires the org.json:json:20230227 library.** To use this class, create a new instance with the desired longitude and latitude coordinates, then call the getWeatherReport() method.
 * The method will return an object representing the weather data at the given coordinates.
 * Example usage:
 * SmhiAPI api = new SmhiAPI("59.3293", "18.0686");
 * Weather report = api.getWeatherReport();
 * Note: The getWeatherReport() method currently returns a placeholder Weather object, which should be updated to reflect the actual data returned by the SMHI API.
 **/

public class SmhiAPI {
    private String latitude;
    private String longitude;

    /**
     * Creates a new SmhiAPI object with the specified longitude and latitude coordinates.
     *
     * @param longitude The longitude coordinate of the location for which to retrieve weather data.
     * @param latitude  The latitude coordinate of the location for which to retrieve weather data.
     */
    public SmhiAPI(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Retrieves the weather report for the location specified in the SmhiAPI object.
     *
     * @return A String representing the weather data for the specified location.
     */
    public String getWeatherReport() throws IOException {

        // todo change Weather to actual object
        String apiUrl = "https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/" + this.longitude + "/lat/" + this.latitude + "/data.json";
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Checks that the connection is successful otherwise throws http error
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) { // HTTP status code 200 for successful requests
            throw new RuntimeException("HTTP error " + responseCode);
        }

        StringBuilder response = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}

