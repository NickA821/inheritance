package labs.seven;

/**
 * This class models a clock.
 *
 * @author Dr. Kreahling
 * @version Modified 2017
 */

public class ClockModel implements Comparable<ClockModel> {
    /** The value of the smallest 12-hour hour. */
    private final static int MIN_HOUR   =  1;

    /** The value of the largest 12-hour hour.  */
    private final static int MAX_HOUR   = 12;

    /** The value of the largest 24-hour hour.  */
    private final static int MAX_TWENTY = 23;

    /** The value of the smallest 24-hour hour. */
    private final static int MIN_TWENTY =  0;

    /** The value of the smallest minute.       */
    private final static int MIN_MINUTE =  0;

    /** The value of the largest minute.        */
    private final static int MAX_MINUTE = 59;

    /** The value of the smallest second.       */
    private final static int MIN_SECOND =  0;

    /** The value of the largest second.        */
    private final static int MAX_SECOND = 59;


    /** A counter representing the time's hour. */
    private Counter hours;

    /** A counter representing the time's minutes. */
    private Counter minutes;

    /** A counter representing the time's seconds. */
    private Counter seconds;

    /** Represents whether the time is in the morning, evening, or is a 24-hour clock. */
    private TimeOfDay meridies;


    /**
     * Creates a new <code>ClockModel</code> based on the specified parameters.
     *
     * @param hour      The initial hour this model represents.
     * @param minute    The initial minute this model represents.
     * @param second    The initial second this model represents.
     * @param type      "AM", "PM", or "24".
     */
    public ClockModel(int hour, int minute, int second, String type) {
        this.hours = new Counter(hour, 1, 12);
        this.minutes = new Counter(minute, 0, 59);
        this.seconds = new Counter(second, 0, 59);
        this.meridies = TimeOfDay.valueOf(type);
    }

    public ClockModel(int hour, int minute, int second) {
        this.hours = new Counter(hour, 1, 12);
        this.minutes = new Counter(minute, 0, 59);
        this.seconds = new Counter(second, 0, 59);
    }

    /**
     * Advances this clock model by one second.  If advancing the clock by a second causes the
     * seconds to roll over, the minutes get advanced.  If advancing the minutes causes them to
     * roll over, the hours get advanced.  If advancing the hours causes it to change to MAX_HOUR,
     * then the clock goes from morning to afternoon or vice versa.
     */
    public void tock() {
        this.seconds.increment();
        if (this.seconds.hasRolledOver()) {
            this.minutes.increment();
            if (this.minutes.hasRolledOver()) {
                this.hours.increment();
                if (this.getHour() == MAX_HOUR) {
                    if (this.meridies.ordinal() == 1) {
                        this.meridies = TimeOfDay.AM;
                    }
                    else if (this.meridies.ordinal() == 0) {
                        this.meridies = TimeOfDay.PM;
                    }
                }
            }
        }
    }

    /**
     * Get the current hour this model represents.
     *
     * @return The current hour this model represents.
     */
    public int getHour() {
        return hours.getValue();
    }

    /**
     * Gets the current hour this model represents as a String.
     *
     * @return The current hour this model represents as a String.
     */
    public String getHourAsString() {
        return Integer.toString(hours.getValue());
    }

    /**
     * Updates the current hour this model represents.
     *
     * @precondition The specified hour must be a valid hour (i.e., between
     *               1 and 12 inclusive).
     *
     * @param hour The new hour.
     */
    public void setHour(int hour) {
        this.hours.setValue(hour);
    }

    /**
     * Get the current minute this model represents.
     *
     * @return The current minute this model represents.
     */
    public int getMinute() {
        return minutes.getValue();
    }

    /**
     * Gets the current minute this model represents as a String.  If the
     * minute is less than 10, the returned string has a &quot;0&quot;
     * prepended to it.
     *
     * @return The current minute this model represents as a String.
     */
    public String getMinuteAsString() {
        final int MIN_DIGITS = 2;
        return padWithZeros(minutes.getValue(), MIN_DIGITS);
    }

    /**
     * Updates the current minute this model represents.
     *
     * @precondition The specified minute must be a valid minute (i.e., between
     *               0 and 59 inclusive).
     *
     * @param minute The new minute.
     */
    public void setMinute(int minute) {
        this.minutes.setValue(minute);
    }

    /**
     * Get the current second this model represents.
     *
     * @return The current second this model represents.
     */
    public int getSecond() {
        return seconds.getValue();
    }

    /**
     * Gets the current second this model represents as a String.  If the
     * second is less than 10, the returned string has a &quot;0&quot;
     * prepended to it.
     *
     * @return The current second this model represents as a String.
     */
    public String getSecondAsString() {
        final int MIN_DIGITS = 2;
        return padWithZeros(seconds.getValue(), MIN_DIGITS);
    }

    /**
     * Updates the current second this model represents.
     *
     * @precondition The specified second must be a valid second (i.e., between
     *               0 and 59 inclusive).
     *
     * @param second The new second.
     */
    public void setSecond(int second) {
        this.seconds.setValue(second);
    }

    /**
     * Returns a String representing whether this model represents a time
     * in the morning, afternoon, or if it is a twenty-four hour clock.  If the model is a
     * 24-hour clock it returns &quot;24&quot;, if it represents a 12 hour clock and it
     * represents a time in the morning, this method returns &quot;AM&quot;; otherwise it returns
     * &quot;PM&quot;.
     *
     * @return "AM", "PM", or "24" depending on if this model represents a time in
     *         the morning or afternoon, or a 24 hour clock.
     */
    public String getMeridies() {
        return meridies.getSuffix();
    }

    /**
     * returns true if the clock is a 12 hour clock and it is in the AM.
     * @return true if this is a 12-hour clock and it is in the morning, false otherwise.
     */
    public boolean isMorning() {
        return this.meridies == TimeOfDay.AM;
    }

    /**
     * Set the which type of clock we have. If this is a 12-hour clock,
     * we will set this to AM or PM. If this is a 24 hour clock we will set the value to 24.
     * @param type which type of clock, 24, AM, or PM
     */
    public void setMeridies(String type) {
        switch(type) {
            case "AM":
            case "am":
                meridies = TimeOfDay.AM;
                break;
            case "PM":
            case "pm":
                meridies = TimeOfDay.PM;
                break;
            case "24":
            default:
                meridies = TimeOfDay.TWO4;
                break;
        }
    }

    /**
     * Compares this <code>ClockModel</code> object to another object.  If the
     * specified object is a <code>ClockModel</code>, and if it has the same
     * state as this object, the method returns true; otherwise, it returns
     * false.
     *
     * @param other An object to which to compare
     *
     * @return true if other is a <code>ClockModel</code> that has the same
     *         state as this object; false otherwise.
     */

    public boolean equals(ClockModel other) {
        boolean isEqual = false;
        if (this.hours.equals(other.hours) && this.minutes.equals(other.minutes) && this.seconds.equals(other.seconds) &&
        this.meridies.equals(other.meridies)) {
            isEqual = true;
        }
        return isEqual;
    }

    /**
     * Compares this object with the specified object for order. Returns a negative integer, zero,
     * or a positive integer as this object is less than, equal to, or greater than the specified
     * object.
     * @param other the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object is less than, equal
     * to, or greater than the specified object.
     */
    public int compareTo(ClockModel other) {
        int finTotal = 0;
        int insTimeTotal = ((this.getSecond()) + (60 * this.getMinute()) + (3600 * this.getHour()));
        int othTimeTotal = ((other.getSecond()) + (60 * other.getMinute()) + (3600 * other.getHour()));
        if (this.meridies.ordinal() == other.meridies.ordinal()) {
            if (insTimeTotal > othTimeTotal) {
                finTotal = 1;
            }
            else if (insTimeTotal < othTimeTotal) {
                finTotal = -1;
            }
        }
        else if (this.meridies.ordinal() > other.meridies.ordinal()) {
            finTotal = 1;
        }
        else if (this.meridies.ordinal() < other.meridies.ordinal()) {
            finTotal = -1;
        }

        return finTotal;
    }



    /**
     * Takes a number and a minimum number of digits, and returns a string  that is at least
     * minDigits long.  If the length of the string containing value is less than minDigits,
     * zeros are prepended to that string until it reaches the length of minDigits.
     *
     * @param value The value to convert to a String.
     * @param minDigits The minimum length of the returned String.
     *
     * @return A string of length minDigit containing value, prepending by
     *         zeros if necessary.
     */
    private String padWithZeros(int value, int minDigits) {
        String strValue = Integer.toString(value);

        while (strValue.length() < minDigits) {
            strValue = "0" + strValue;
        }
        return strValue;
    }

    /**
     *  An enumeration modeling the time of day, or 24 hour clock
     */
    enum TimeOfDay {
        AM("AM", 12), PM("PM", 12), TWO4("", 24);

        /**
         * Number of hours before the clock numbers reset.
         */
        private final int hours;
        /**
         * THe value to be printed as hours. Note: print an empty string is we are a 24-hour
         * clock.
         */
        private final String suffix;

        /**
         * Create a TimeOfDay enumeration
         * @param time AM, PM, or ""
         * @param value how many hours before the clock hours reset.
         */
        private TimeOfDay(String time, int value) {
            hours = value;
            suffix = time;
        }

        /**
         * Max number of hours before a reset.
         * @return Max number of hours before a reset.
         */
        public int getHours() {

            return hours;
        }

        /**
         *
         * @return the String AM, PM, or 24
         */
        public String getSuffix() {
            return suffix;
        }
    };
}
