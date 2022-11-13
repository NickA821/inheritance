package labs.seven;

import java.util.Calendar;

/**
 * A utility class that provides a collection of static methods to access
 * the current hour, minute, second, AM/PM, and to cause the program to
 * pause for a specified number of seconds.
 *
 * @author Dr. Dalton
 * @author Dr. Kreahling
 * @version February 2, 2011, 2013, 2015, 2016, 2017
 */
public class TimeUtils {
    /** An object that enables us to access time information. */
    private static Calendar calendar = Calendar.getInstance();

    /**
     * Returns the current hour.
     *
     * @return the current hour.
     */
    public static int getCurrentHour() {
        int hour = calendar.get(Calendar.HOUR);
        if (hour == 0) {
            hour = 12;
        }
        return hour;
    }

    /**
     * Returns the current minute.
     *
     * @return the current minute.
     */
    public static int getCurrentMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * Returns the current second.
     *
     * @return the current second.
     */
    public static int getCurrentSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * Returns true if it is currently morning; false otherwise.
     *
     * @return true if it is currently morning; false otherwise.
     */
    public static boolean isMorning() {
        return calendar.get(Calendar.AM_PM) == Calendar.AM;
    }

    /**
     * Causes the program to pause for the specified number of seconds.
     *
     * @param seconds the number of seconds to pause.
     */
    public static void pause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException ex) {
            /* ignore */
        }
    }
}