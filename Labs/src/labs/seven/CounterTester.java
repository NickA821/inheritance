package labs.seven;

public class CounterTester {
    private final static double EPSILON = 1E-6;

    private int passes;
    private int failures;


    public void runTests() {
        passes   = 0;
        failures = 0;

        System.out.print("========================================");
        System.out.println("========================================");
        System.out.println("Testing class Counter");
        System.out.print("========================================");
        System.out.println("========================================");

        testConstruction();
        testIncrement();
        testDecrement();
        testSetValue();
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
        System.out.println("\nTesting new Counter(5, 2, 7)");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Counter c = new Counter(5, 2, 7);

        test(c.getValue() == 5,
                "Value of newly created counter should be 5: " + c.getValue());
        test(c.getMinValue() == 2,
                "Minimum value of newly created counter should be 2: "
                        + c.getMinValue());
        test(c.getMaxValue() == 7,
                "Maximum value of newly created counter should be 7: "
                        + c.getMaxValue());
        test(!c.hasRolledOver(),
                "A newly created counter should not have rolled over (false): "
                        + c.hasRolledOver());
    }

    private void testIncrement() {
        System.out.println("\nTesting increment");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Counter c = new Counter(5, 2, 7);

        c.increment();
        test(c.getValue() == 6,
                "Value after increment should be 6: " + c.getValue());
        test(c.getMinValue() == 2,
                "Minimum value after increment should be 2: "
                        + c.getMinValue());
        test(c.getMaxValue() == 7,
                "Maximum value after increment should be 7: "
                        + c.getMaxValue());
        test(!c.hasRolledOver(),
                "Increment should not have caused a roll over (false): "
                        + c.hasRolledOver());

        c.increment();
        test(c.getValue() == 7,
                "Value after increment should be 7: " + c.getValue());
        test(!c.hasRolledOver(),
                "Increment should not have caused a roll over (false): "
                        + c.hasRolledOver());

        c.increment();
        test(c.getValue() == 2,
                "Value after increment should be 2: " + c.getValue());
        test(c.hasRolledOver(),
                "Increment should have caused a roll over (true): "
                        + c.hasRolledOver());

        c.increment();
        test(c.getValue() == 3,
                "Value after increment should be 3: " + c.getValue());
        test(!c.hasRolledOver(),
                "Increment should not have caused a roll over (false): "
                        + c.hasRolledOver());
    }

    private void testDecrement() {
        System.out.println("\nTesting decrement");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Counter c = new Counter(5, 2, 7);


        c.decrement();
        test(c.getValue() == 4,
                "Value after decrement should be 4: " + c.getValue());
        test(c.getMinValue() == 2,
                "Minimum value after decrement should be 2: "
                        + c.getMinValue());
        test(c.getMaxValue() == 7,
                "Maximum value after decrement should be 7: "
                        + c.getMaxValue());
        test(!c.hasRolledOver(),
                "Decrement should not have caused a roll over (false): "
                        + c.hasRolledOver());

        c.decrement();
        test(c.getValue() == 3,
                "Value after decrement should be 3: " + c.getValue());
        test(!c.hasRolledOver(),
                "Decrement should not have caused a roll over (false): "
                        + c.hasRolledOver());

        c.decrement();
        test(c.getValue() == 2,
                "Value after decrement should be 2: " + c.getValue());
        test(!c.hasRolledOver(),
                "Decrement should not have caused a roll over (false): "
                        + c.hasRolledOver());

        c.decrement();
        test(c.getValue() == 7,
                "Value after decrement should be 7: " + c.getValue());
        test(c.hasRolledOver(),
                "Decrement should have caused a roll over (true): "
                        + c.hasRolledOver());

        c.decrement();
        test(c.getValue() == 6,
                "Value after decrement should be 6: " + c.getValue());
        test(!c.hasRolledOver(),
                "Decrement should not have caused a roll over (false): "
                        + c.hasRolledOver());
    }

    private void testSetValue() {
        System.out.println("\nTesting setValue");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Counter c = new Counter(5, 2, 7);

        c.setValue(3);
        test(c.getValue() == 3,
                "Value after setValue(3) should be 3: " + c.getValue());
        test(!c.hasRolledOver(),
                "setValue() should not have caused a roll over (false): "
                        + c.hasRolledOver());

        c.decrement();
        c.decrement();

        c.setValue(5);
        test(c.getValue() == 5,
                "Value after setValue(5) should be 5: " + c.getValue());
        test(!c.hasRolledOver(),
                "setValue() should clear the rolled over flag (false): "
                        + c.hasRolledOver());
    }

    private void testEquals() {
        System.out.println("\nTesting equals");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Counter c1 = new Counter(5, 2, 7);
        Counter c2 = new Counter(5, 2, 7);
        Counter c3 = new Counter(4, 2, 7);
        Counter c4 = new Counter(5, 3, 7);
        Counter c5 = new Counter(5, 2, 6);
        Counter c6 = new Counter(2, 2, 7);

        test(c1.equals(c1),
                "A counter is equal to itself (true): " + c1.equals(c1));
        test(c1.equals(c2),
                "Two equal counters are equal (true): " + c1.equals(c2));
        test(c2.equals(c1),
                "Two equal counters are equal (true): " + c2.equals(c1));
        test(!c1.equals(c3),
                "Two counters who differ by value are not equal (false): "
                        + c1.equals(c3));
        test(!c1.equals(c4),
                "Two counters who differ by min value are not equal (false): "
                        + c1.equals(c4));
        test(!c1.equals(c5),
                "Two counters who differ by max value are not equal (false): "
                        + c1.equals(c5));

        c1.setValue(2);
        c1.decrement();
        test(!c1.equals(c6),
                "Two counters who differ by rolled over flag are not equal\n"
                        + "        (false): " + c1.equals(c6));
    }


    private void testCompareTo() {
        System.out.println("\nTesting compareTo");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");
        Counter c1 = new Counter(5, 2, 7);
        Counter c2 = new Counter(5, 3, 7);
        Counter c3 = new Counter(5, 4, 9);
        Counter c4 = new Counter(8, 6, 11);

        test(c1.compareTo(c2) > 0,
                "c1, should be greater than c2:  " + (c1.compareTo(c2)));
        test(c2.compareTo(c3) < 0,
                "c2, should be less than c3:  " + (c2.compareTo(c3)));
        test(c3.compareTo(c1) == 0,
                "c3, should be equal to c1:  " + (c3.compareTo(c1)));
        test(c1.compareTo(c3) == 0,
                "c1, should be equal to c3:  " + (c1.compareTo(c3)));
        test(c3.compareTo(c4) < 0,
                "c3, should be less than c4:  " + (c3.compareTo(c4)));
        test(c4.compareTo(c3) > 0,
                "c4, should be greater than c3:  " + (c4.compareTo(c3)));

    }

    public static void main(String[] args) {
        CounterTester tester = new CounterTester();
        tester.runTests();
    }

}
