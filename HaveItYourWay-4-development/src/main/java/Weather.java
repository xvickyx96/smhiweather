import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class Weather {
    private String city;
    private String date;
    private String time;
    private double temperature;
    private double windSpeed;
    private double windDirection;
    private String weatherDescription;

    public Weather(String city, String date, String time, double temperature, double windSpeed, double windDirection, String weatherDescription) {
        this.city = city;
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.weatherDescription = weatherDescription;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public static Weather fromDocument(Document doc) {
        return new Weather(
                doc.getString("city"),
                doc.getString("date"),
                doc.getString("time"),
                doc.getDouble("temperature"),
                doc.getDouble("windSpeed"),
                doc.getDouble("windDirection"),
                doc.getString("weatherDescription")
        );
    }

    public Document toDocument(SmhiAPI gbg) {
        return new Document()
                .append("city", city)
                .append("date", date)
                .append("temperature", temperature)
                .append("windSpeed", windSpeed)
                .append("windDirection", windDirection);
    }

    public static Weather fromJson(String Json) throws JSONException {
        JSONObject obj = new JSONObject(Json);
        return new Weather(
                obj.getString("city"),
                obj.getString("date"),
                obj.getString("time"),
                obj.getDouble("temperature"),
                obj.getDouble("windSpeed"),
                obj.getDouble("windDirection"),
                obj.getString("weatherDescription"));
    }

    public String toJson() {
        return new JSONObject((Map) this).toString();
    }

    @Override
    public String toString() {
        return city + ", " + date + ", " + time +
                "\nTemperature: " + temperature + "C, Sky: " + weatherDescription +
                "\nwind speed " + windSpeed + "m/s, wind direction " + windDirection + " " +
                (windDirection < 22.5 ? ("North") : windDirection < 67.5 ? "North East" : windDirection < 112.5 ? "East" : windDirection < 157.5 ? "South East" : windDirection < 202.5 ? "South" : windDirection < 247.5 ? "South West" : windDirection < 292.5 ? "West" : windDirection < 337.5 ? "North West" : windDirection < 360.0 ? "North" : "3D chess");
    }
}

