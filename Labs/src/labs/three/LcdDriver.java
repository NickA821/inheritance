package three;

/**
 * Driver (AKA Tester for three.LcdDisplay).
 * @author William Kreahling
 * @version January 23
 */
public class LcdDriver {
    /** Total number of tests run */
    private int numTests;
    /** Number of tests passed */
    private int testsPassed;

    /**
     * Set up all the tests
     */
    public LcdDriver() {
        // Not a typical constructer; this originally was part of a larger program.
        this.clear();
    }

    /**
     * Reset test counts.
     */
    private void clear() {
        this.numTests       = 0;
        this.testsPassed    = 0;
    }

    /**
     * Run a selection of tests on three.LcdDisplay.
     */
    public void go() {
        this.clear();
        String br = "---------------------------------------------------------------";

        LcdDisplay display = new LcdDisplay(21375);

        int displayValue;
        testAnswer(375, display.getDisplayValue(), "375", display.toString());


        display.setDisplayValue(8575);

        System.out.println(br);
        testAnswer(575, display.getDisplayValue(), "575", display.toString());

        display.setDisplayValue(987654);

        System.out.println(br);
        testAnswer(654, display.getDisplayValue(), "654", display.toString());

        display.setDisplayValue(149);
        System.out.println(br);
        testAnswer(149, display.getDisplayValue(), "149", display.toString());


        display = new LcdDisplay(21375);
        System.out.println(br);
        testAnswer(375, display.getDisplayValue(), "375", display.toString());


        System.out.println();
        System.out.println(br);
        System.out.println("******** TESTS PASSED ==> " + testsPassed + "/" + numTests);
        System.out.println(br);

    }

    /**
     * Tests integer and string results against expected outcomes.
     * @param iCorrect Correct answer in number format
     * @param iAnswer  Supplied answer in number format (caclulated)
     * @param correct  correct answer for 'display'
     * @param answer   supplied answer for 'display'
     *
     * @return true if both tests pass, false otherwise
     */
    private boolean testAnswer(int iCorrect, int iAnswer, String correct, String answer) {
        this.numTests++;
        boolean result = false;
        String message = "(int) Expected " + iCorrect + " : Supplied " + iAnswer + "\n";
        message += "        (str) Expected \"" + correct + "\" : Supplied \"" + answer + "\"";

        if (correct.equals(answer) && iCorrect == iAnswer) {
            testsPassed++;
            result = true;
            message = "PASSED: " + message;

        } else {
            message = "FAILED: " + message;
        }
        System.out.println(message);
        return result;
    }

    /**
     * Entry point for the program.
     * @param args not used.
     */
    public static void main(String[] args) {
        LcdDriver driver = new LcdDriver();
        driver.go();
    }

}