package labs.seven;

public class ClockTester {
    private int passes;
    private int failures;

    public void runTests() {
        passes   = 0;
        failures = 0;

        System.out.print("========================================");
        System.out.println("========================================");
        System.out.println("Testing class Clock");
        System.out.print("========================================");
        System.out.println("========================================");

        testConstruction();
        testTick();
        testSetMethods();
        testEquals();
        testCompareTo();

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
        System.out.println("\nTesting ClockModel constructors");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Clock c;

        c = new Clock();
        test(c.toString().equals("12:00:00 AM"),
                "A newly created clock's time is \"12:00:00 AM\": "
                        + c.toString());


        c = new Clock(11, 59, 59);
        test(c.toString().equals("11:59:59 AM"),
                "A newly created clock's time is \"11:59:59 AM\": "
                        + c.toString());
    }


    private void testTick() {
        System.out.println("\nTesting tick()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Clock c = new Clock(11, 59, 59);
        c.tick();
        test(c.toString().equals("12:00:00 PM"),
                "11:59:59 AM + tick() = 12:00:00 PM");
    }

    private void testSetMethods() {
        System.out.println("\nTesting set methods");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Clock c = new Clock();

        c.setHour(1);
        test(c.toString().equals("1:00:00 AM"),
                "After setHour(1), clock's time is \"1:00:00 AM\": "
                        + c.toString());

        c.setMinute(4);
        test(c.toString().equals("1:04:00 AM"),
                "After setMinute(0), clock's time is \"1:04:00 AM\": "
                        + c.toString());

        c.setSecond(59);
        test(c.toString().equals("1:04:59 AM"),
                "After setSecond(59), clock's time is \"1:04:59 AM\": "
                        + c.toString());

        c.toggleAmPm();
        test(c.toString().equals("1:04:59 PM"),
                "After toggleAmPm(), clock's time is \"1:04:59 PM\": "
                        + c.toString());
    }

    private void testEquals() {
        System.out.println("\nTesting equals");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Clock c1 = new Clock(12, 0, 0);
        Clock c2 = new Clock(12, 0, 0);
        Clock c3 = new Clock(1,  0, 0);
        Clock c4 = new Clock(12, 1, 0);
        Clock c5 = new Clock(12, 0, 1);
        Clock c6 = new Clock(12, 0, 0, "PM");

        test(c1.equals(c1),
                "A clock should be equal to itself: " + c1.equals(c1));
        test(c1.equals(c2),
                "A clock should be equal to an equal clock: " + c1.equals(c2));
        test(!c1.equals(c3),
                "A clock should not equal a clock with a different hour: "
                        + c1.equals(c3));
        test(!c1.equals(c4),
                "A clock should not equal a clock with a different minute: "
                        + c1.equals(c4));
        test(!c1.equals(c5),
                "A clock should not equal a clock with a different second: "
                        + c1.equals(c5));
        test(!c1.equals(c6),
                "A clock should not equal a clock with a different AM/PM: "
                        + c1.equals(c6));
    }

    private void testCompareTo() {
        System.out.println("\nTesting compareTo");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Clock c1 = new Clock(1, 0, 0);
        Clock c2 = new Clock(1, 0, 0, "PM");
        Clock c3 = new Clock(13, 0, 0, "TWO4");

        test(c1.compareTo(c2) < 0,
                "c1 should be less than c2--> " + c1.toString() + " : " + c2.toString() + " --> " +
                        + (c1.compareTo(c2)));
        test(c1.compareTo(c3) < 0,
                "c1 should be less than c3--> " + c1.toString() + " : " + c3.toString() + " --> " +
                        + (c1.compareTo(c2)));
        c1.toggleAmPm();
        test(c1.compareTo(c2) == 0,
                "c1 should be equal to c2--> " + c1.toString() + " : " + c2.toString() + " --> " +
                        + (c1.compareTo(c2)));
        c3.toggleAmPm();
        test(c1.compareTo(c3) < 0,
                "c1 should be less than c3--> " + c1.toString() + " : " + c3.toString() + " --> " +
                        + (c1.compareTo(c2)));
    }




    public static void main(String[] args) {
        ClockTester tester = new ClockTester();
        tester.runTests();

    }
}
