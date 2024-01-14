import java.time.LocalDate;

/**
 * The Dates class provides methods for handling date operations.
 */
public class Dates {

    LocalDate localDate;

    /**
     * Constructs a Dates object with the current date.
     */
    public Dates() {
        this.localDate = LocalDate.now();
    }

    /**
     * Retrieves the current date.
     *
     * @return The current date in string format.
     */
    public String todayDate() {
        return String.valueOf(LocalDate.now());
    }

    /**
     * Retrieves the date a specified number of days ago from the current date.
     *
     * @param daysAgo The number of days ago from the current date.
     * @return The date in string format.
     */
    public String previousDay(int daysAgo) {
        return String.valueOf(localDate.minusDays(daysAgo));
    }

    /**
     * Retrieves the date a specified number of days ahead from the current date.
     *
     * @param nextDay The number of days ahead from the current date.
     * @return The date in string format.
     */
    public String comingDay(int nextDay) {
        return String.valueOf(localDate.plusDays(nextDay));
    }

}
