import java.util.ArrayList;

/**
 * The ShowWeather class retrieves weather information from a MongoDB database and displays it.
 */
public class ShowWeather {
    /**
     * Retrieves weather information for multiple days for a given city and displays it.
     *
     * @param city The name of the city for which weather information is requested.
     */
    public static void multiWeather(String city, MongoDBFasad mongoDBFasad) {
        Dates day = new Dates();
        ArrayList<Weather> weathers = new ArrayList<>();
        final int TWO_DAYS = 2;
        final int ONE_DAY = 1;
        // todo make null checks instead of searching database twice
        if ((mongoDBFasad.findByCityAndDate(city, day.previousDay(TWO_DAYS)) != null)) {
            weathers.add(mongoDBFasad.findByCityAndDate(city, day.previousDay(TWO_DAYS)));
        }
        if ((mongoDBFasad.findByCityAndDate(city, day.previousDay(ONE_DAY)) != null)) {
            weathers.add(mongoDBFasad.findByCityAndDate(city, day.previousDay(ONE_DAY)));
        }
        weathers.add(mongoDBFasad.findByCityAndDate(city, day.todayDate()));
        weathers.add(mongoDBFasad.findByCityAndDate(city, day.comingDay(ONE_DAY)));
        weathers.add(mongoDBFasad.findByCityAndDate(city, day.comingDay(TWO_DAYS)));

        for (
                Weather weather : weathers) {
            System.out.println();
            System.out.println(weather);
        }
    }
}
