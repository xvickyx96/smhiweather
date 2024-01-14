import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JsonToDoc {

    public void docMaker (String json, String city, MongoDBFasad mongoDBFasad) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Root root = objectMapper.readValue(json, Root.class);

            LocalDate today = LocalDate.now();
            String date = today.toString(); // yyyy-mm-dd
            LocalTime time = LocalTime.now(); // hh:mm:ss
            int h = time.getHour();
            String currentTime = String.valueOf(h);


            List<TimeSeries> filteredTimeList = new ArrayList<>();
            for (TimeSeries timeSeriesData : root.getTimeSeries()) {
                if (timeSeriesData.getValidTime().endsWith("T12:00:00Z")) {
                    filteredTimeList.add(timeSeriesData);
                }
            }

            List<TimeSeries> todayTimeList = new ArrayList<>();
            String searchTime = date + "T" + currentTime + ":00:00Z";
            for (TimeSeries timeSeriesData : root.getTimeSeries()) {
                if (timeSeriesData.getValidTime().startsWith(searchTime)) {
                    todayTimeList.add(timeSeriesData);
                }
            }

            getAllInfo(todayTimeList, city, mongoDBFasad);
            getAllInfo(filteredTimeList, city, mongoDBFasad);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Denna metod skapar en document med infon som hämtas från API:et, och lägger in den i databasen.
    private void getAllInfo (List<TimeSeries> todayTimeSeries, String city, MongoDBFasad mongoDBFasad) {
        for (TimeSeries timeSeriesData : todayTimeSeries) {
            String validTime = timeSeriesData.getValidTime();
            String[] timeParts = validTime.split("T");

            Document doc = new Document("date", timeParts[0])
                    .append("time", timeParts[1])
                    .append("city", city)
                    .append("temperature", getTemp(timeSeriesData))
                    .append("windDirection", getWindDirection(timeSeriesData))
                    .append("windSpeed", getWindSpeed(timeSeriesData))
                    .append("weatherDescription", getWeatherDescription(timeSeriesData));

            if (mongoDBFasad.documentExists(doc)) {
                mongoDBFasad.updateOne(doc);
            }else {
                mongoDBFasad.insertOne(doc);
            }
        }
    }

    // Denna metod söker för windDirection i en lista.
    private double getWindDirection (TimeSeries timeSeriesData) {
        Parameter windDirectionParameter = getParameterByName(timeSeriesData, "wd");
        if (windDirectionParameter != null) {
            List<Double> windDirectionValues = windDirectionParameter.getValues();
            if (!windDirectionValues.isEmpty()) {
                return windDirectionValues.get(0);
            }
        }
        return 0;
    }

    // Denna metod söker för windSpeed i en lista.
    private double getWindSpeed(TimeSeries timeSeriesData) {
        Parameter windSpeedParameter = getParameterByName(timeSeriesData, "ws");
        if (windSpeedParameter != null) {
            List<Double> windSpeedValues = windSpeedParameter.getValues();
            if (!windSpeedValues.isEmpty()) {
                return windSpeedValues.get(0);
            }
        }
        return 0;
    }

    // Denna metod söker för temperatur i en lista.
    private double getTemp(TimeSeries timeSeriesData) {
        Parameter temperatureParameter = getParameterByName(timeSeriesData, "t");
        if (temperatureParameter != null) {
            List<Double> temperatureValues = temperatureParameter.getValues();
            if (!temperatureValues.isEmpty()) {
                return temperatureValues.get(0);
            }
        }
        return 0;
    }

    // Denna metod söker för väder beskrivning i en lista.
    private String getWeatherDescription (TimeSeries timeSeriesData){

        Parameter weatherDescriptionParameter = getParameterByName(timeSeriesData, "Wsymb2");
        if (weatherDescriptionParameter != null) {
            List<Double> weatherDescriptionValues = weatherDescriptionParameter.getValues();
            if (!weatherDescriptionValues.isEmpty()) {
                double number = weatherDescriptionValues.get(0);
                return getWeatherDescription(number);
            }
        }
        return null;
    }

    // Denna metod hämtar ut en parameter från en lista av parametrar.
    private Parameter getParameterByName(TimeSeries timeSeries, String parameterName) {
        List<Parameter> parameters = timeSeries.getParameters();
        for (Parameter parameter : parameters) {
            if (parameter.getName().equals(parameterName)) {
                return parameter;
            }
        }
        return null;
    }
    // När man söker på Wsymb2 så får man en siffra som beskriver vädret. Denna metod översätter siffran till en beskrivning.
    private String getWeatherDescription(double number) {
        return switch ((int) number) {
            case 1 -> "Clear sky";
            case 2 -> "Nearly clear sky";
            case 3 -> "Variable cloudiness";
            case 4 -> "Halfclear sky";
            case 5 -> "Cloudy sky";
            case 6 -> "Overcast";
            case 7 -> "Fog";
            case 8 -> "Light rain showers";
            case 9 -> "Moderate rain showers";
            case 10 -> "Heavy rain showers";
            case 11 -> "Thunderstorm";
            case 12 -> "Light sleet showers";
            case 13 -> "Moderate sleet showers";
            case 14 -> "Heavy sleet showers";
            case 15 -> "Light snow showers";
            case 16 -> "Moderate snow showers";
            case 17 -> "Heavy snow showers";
            case 18 -> "Light rain";
            case 19 -> "Moderate rain";
            case 20 -> "Heavy rain";
            case 21 -> "Thunder";
            case 22 -> "Light sleet";
            case 23 -> "Moderate sleet";
            case 24 -> "Heavy sleet";
            case 25 -> "Light snowfall";
            case 26 -> "Moderate snowfall";
            case 27 -> "Heavy snowfall";
            default -> "Invalid weather number";
        };
    }

}
