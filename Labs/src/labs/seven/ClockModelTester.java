package labs.seven;

public class ClockModelTester {
    private int passes;
    private int failures;

    public void runTests() {
        passes   = 0;
        failures = 0;

        System.out.print("========================================");
        System.out.println("========================================");
        System.out.println("Testing class ClockModel");
        System.out.print("========================================");
        System.out.println("========================================");

        testConstruction();
        //testSetMethods();
        //testTock();
        //testEquals();
        //testCompareTo();

        System.out.print("========================================");
        System.out.println("========================================");
        System.out.println("Tests executed:    " + (passes + failures));
        System.out.println("     Successful:   " + passes);
        System.out.println("     Unsuccessful: " + failures);
    }

    public int getPasses() {
        return passes;
    }

    public int getFailures() {
        return failures;
    }

    /**
     * A helper method that increments the pass/fail counters and prints
     * an appropriate message based on the value of the specified condition.
     *
     * @param condition A condition for which to test.  If the condition is
     *        true, the test passed; otherwise, it fails.
     * @param message A message to print indicating the context for the test.
     */
    private void test(boolean condition, String message) {
        if (condition) {
            System.out.println("PASSED: " + message);
            passes = passes + 1;
        } else {
            System.out.println("FAILED: " + message);
            failures = failures + 1;
        }
    }

    private void testConstruction() {
        System.out.println("\nTesting new ClockModel(5, 3, 2, false)");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        ClockModel m = new ClockModel(5, 3, 2, "PM");


        test(m.getHour() == 5,
                "Hour is 5: " + m.getHour());
        test(m.getHourAsString().equals("5"),
                "Hour as a String is \"5\": " + m.getHourAsString());

        test(m.getMinute() == 3,
                "Minute is 3: " + m.getMinute());
        test(m.getMinuteAsString().equals("03"),
                "Minute as a String is \"03\": " + m.getMinuteAsString());

        test(m.getSecond() == 2,
                "Second is 2: " + m.getSecond());
        test(m.getSecondAsString().equals("02"),
                "Minute as a String is \"02\": " + m.getSecondAsString());

        test(!m.isMorning(),
                "Time should not be morning (false): " + m.isMorning());

        test(m.getMeridies().equals("PM"),
                "AM/PM should be PM: " + m.getMeridies());
    }

    private void testSetMethods() {
        System.out.println("\nTesting set methods");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        ClockModel m = new ClockModel(5, 3, 2, "PM");

        m.setHour(12);
        test(m.getHour() == 12,
                "Hour is 12: " + m.getHour());
        test(m.getHourAsString().equals("12"),
                "Hour as a String is \"12\": " + m.getHourAsString());
        test(m.getMinute() == 3,
                "Minute is 3: " + m.getMinute());
        test(m.getSecond() == 2,
                "Second is 2: " + m.getSecond());
        test(!m.isMorning(),
                "Is it morning? (false): " + m.isMorning());
        test(m.getMeridies().equals("PM"),
                "AM/PM should be PM: " + m.getMeridies());

        m.setMinute(13);
        test(m.getMinute() == 13,
                "Minute after setMinute(13) is 13: " + m.getMinute());
        test(m.getMinuteAsString().equals("13"),
                "Minute as a String is \"13\": " + m.getMinuteAsString());
        test(m.getHour() == 12,
                "Hour is 12: " + m.getHour());
        test(m.getSecond() == 2,
                "Second is 2: " + m.getSecond());
        test(!m.isMorning(),
                "Is it morning? (false): " + m.isMorning());

        m.setSecond(0);
        test(m.getSecond() == 0,
                "Second after setSecond(0) is 0: " + m.getSecond());
        test(m.getSecondAsString().equals("00"),
                "Second as a String is \"00\": " + m.getSecondAsString());
        test(m.getMinute() == 13,
                "Minute is 13: " + m.getMinute());
        test(m.getHour() == 12,
                "Hour is 12: " + m.getHour());
        test(!m.isMorning(),
                "Is it morning? (false): " + m.isMorning());

        m.setMeridies("AM");
        test(m.isMorning(),
                "Is it morning after setMorning(true)? (true): " + m.isMorning());
        test(m.getMeridies().equals("AM"),
                "AM/PM should be AM: " + m.getMeridies());
        test(m.getSecond() == 0,
                "Second  is 0: " + m.getSecond());
        test(m.getMinute() == 13,
                "Minute is 13: " + m.getMinute());
        test(m.getHour() == 12,
                "Hour is 12: " + m.getHour());
    }

    private void testTock() {
        System.out.println("\nTesting tock()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        ClockModel m;

        m = new ClockModel(12, 0, 0, "AM");
        m.tock();
        test(m.getHour() == 12,
                "12:00:00 AM + tock(), hour is still 12: " + m.getHour());
        test(m.getMinute() == 0,
                "12:00:00 AM + tock(), minute is still 0: " + m.getMinute());
        test(m.getSecond() == 1,
                "12:00:00 AM + tock(), second is 1: " + m.getSecond());
        test(m.isMorning(),
                "12:00:00 AM + tock(), is still morning: " + m.isMorning());

        m = new ClockModel(12, 0, 59, "AM");
        m.tock();
        test(m.getHour() == 12,
                "12:00:59 AM + tock(), hour is still 12: " + m.getHour());
        test(m.getMinute() == 1,
                "12:00:59 AM + tock(), minute is 1: " + m.getMinute());
        test(m.getSecond() == 0,
                "12:00:59 AM + tock(), second is 0: " + m.getSecond());
        test(m.isMorning(),
                "12:00:59 AM + tock(), is still morning: " + m.isMorning());

        m.tock();
        test(m.getHour() == 12,
                "12:00:59 AM + tock() + tock(), hour is still 12: " + m.getHour());
        test(m.getMinute() == 1,
                "12:00:59 AM + tock() + tock(), minute is 1: " + m.getMinute());
        test(m.getSecond() == 1,
                "12:00:59 AM + tock() + tock(), second is 1: " + m.getSecond());
        test(m.isMorning(),
                "12:00:59 AM + tock() + tock(), is still morning: "
                        + m.isMorning());

        m = new ClockModel(11, 59, 59, "AM");
        m.tock();
        test(m.getHour() == 12,
                "11:59:59 AM + tock(), hour is 12: " + m.getHour());
        test(m.getMinute() == 0,
                "11:59:59 AM + tock(), minute is 0: " + m.getMinute());
        test(m.getSecond() == 0,
                "11:59:59 AM + tock(), second is 0: " + m.getSecond());
        test(!m.isMorning(),
                "11:59:59 AM + tock(), is still morning: " + m.isMorning());

        m.tock();
        test(m.getHour() == 12,
                "11:59:59 AM + tock() + tock(), hour is 12: " + m.getHour());
        test(m.getMinute() == 0,
                "11:59:59 AM + tock() + tock(), minute is 0: " + m.getMinute());
        test(m.getSecond() == 1,
                "11:59:59 AM + tock() + tock(), second is 1: " + m.getSecond());
        test(!m.isMorning(),
                "11:59:59 AM + tock() + tock(), is still morning: "
                        + m.isMorning());

        m = new ClockModel(12, 59, 59, "AM");
        m.tock();
        test(m.getHour() == 1,
                "12:59:59 AM + tock(), hour is 1: " + m.getHour());
        test(m.getMinute() == 0,
                "12:59:59 AM + tock(), minute is 0: " + m.getMinute());
        test(m.getSecond() == 0,
                "12:59:59 AM + tock(), second is 0: " + m.getSecond());
        test(m.isMorning(),
                "12:59:59 AM + tock(), is still morning: " + m.isMorning());
    }

    private void testEquals() {
        System.out.println("\nTesting equals");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        ClockModel m1 = new ClockModel(12,  0,  0, "AM");
        ClockModel m2 = new ClockModel(12,  0,  0, "AM");
        ClockModel m3 = new ClockModel( 1,  0,  0, "AM");
        ClockModel m4 = new ClockModel(12, 30,  0, "AM");
        ClockModel m5 = new ClockModel(12,  0, 59, "AM");
        ClockModel m6 = new ClockModel(12,  0,  0, "PM");

        test(m1.equals(m1),
                "Is a clock model equal to itself: " + m1.equals(m1));
        test(m1.equals(m2),
                "Is a clock model equal to an equal model: " + m1.equals(m2));
        test(!m1.equals(m3),
                "Is a clock model equal to one differing in hours: "
                        + m1.equals(m3));
        test(!m1.equals(m4),
                "Is a clock model equal to one differing in minutes: "
                        + m1.equals(m4));
        test(!m1.equals(m5),
                "Is a clock model equal to one differing in seconds: "
                        + m1.equals(m5));
        test(!m1.equals(m6),
                "Is a clock model equal to one differing in AM/PM: "
                        + m1.equals(m6));
    }

    private void testCompareTo() {
        System.out.println("\nTesting compareTo");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        ClockModel m1 = new ClockModel(5, 3, 2, "PM");
        ClockModel m2 = new ClockModel(5, 3, 2, "AM");
        ClockModel m3 = new ClockModel(5, 3, 2, "TWO4");
        ClockModel m4 = new ClockModel(5, 57, 57, "TWO4");

        test(m1.compareTo(m2) > 0,
                "m1 should be greater than m2: " + (m1.compareTo(m2)));
        test(m2.compareTo(m1) < 0,
                "m2 should be less than m1: " + (m2.compareTo(m1)));
        test(m1.compareTo(m3) < 0,
                "m1 should be less than m3: " + (m1.compareTo(m3)));

        m3.setMinute(57);
        m3.setSecond(58);
        test(m4.compareTo(m3) < 0,
                "m4 should be less than m3: " + (m4.compareTo(m3)));
        m4.tock();
        test(m4.compareTo(m3) == 0,
                "m4 should be equal to m3: " + (m4.compareTo(m3)));
        m4.setMinute(58);
        test(m4.compareTo(m3) > 0,
                "m4 should be greater then m3: "  + (m4.compareTo(m3)));
    }




    public static void main(String[] args) {
        ClockModelTester tester = new ClockModelTester();
        tester.runTests();
    }
}
