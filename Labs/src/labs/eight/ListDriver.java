package labs.eight;
import java.util.*;
/**
 * This class performs tests on the extensions to the LinkedList class.
 *
 * @author William Kreahling
 * @version March 2012
 *
 * Modified by Scott Barlowe (checkExtract), April 2018
 */

/**
 * Driver to test Swapping, Reversing, and Cycling a <i>ListInterface</i>.
 */
public class ListDriver<E> {

    /** An array of lists to test for correctness */
    private ListInterface[] list;
    /** A scanner for use input */
    private Scanner scanIn;
    /** Default size */
    private final static int SIZE = 7;

    /**
     * <b>Default</b> constructor to create a list for testing.
     *
     * @param listFactory a list that implements the ListFactory interface.
     */
    public ListDriver() {
        this.list = new ListInterface[SIZE];
        for (int i = 0; i < list.length; ++i) {
            list[i] = new Linked<E>();
        }
        scanIn = new Scanner(System.in);
    }

    /**
     * Run Swap, cycle, and reverse tests on a set of lists.
     */
    public void drive() {
        checkSwap();
        checkReverse();
        checkCycle();
        //////////////////////
        checkExtract();
        /////////////////////
    }

    /**
     * Initialize lists to made up values for testing
     */
    @SuppressWarnings("unchecked")
    private void initSetOne() {
        assert list.length >= 3 : list.length;
        int index = 0;
        list[index].clear();
        list[index].add("Korra");
        list[index].add("Tenzin");
        list[index].add("Mako");

        list[++index].clear();
        list[index].add("Rick");
        list[index].add("Daryl");
        list[index].add("Maggie");
        list[index].add("Carol");

        list[++index].clear();
        list[index].add("Picadillo");
        list[index].add("Ham");
        list[index].add("Turkey");
        list[index].add("Yams");
        list[index].add("Green Been Casserole");
        list[index].add("Lamb");
        list[index].add("Pumpkin Pie");
        list[index].add("Hossenfeffer Stew");
    }

    /**
     * Initialize lists to made up values for testing.
     */
    @SuppressWarnings("unchecked")
    private void initSetTwo() {
        assert list.length >= 7 : list.length;
        int index = 3;
        list[index].clear();
        list[index].add("Alpha");
        list[index].add("Beta");
        list[index].add("Gamma");
        list[index].add("Delta");
        list[index].add("Epsilon");
        list[index].add("Zeta");
        list[index].add("Eta");

        list[++index].clear();
        list[index].add("Omega");
        list[index].add("Psi");
        list[index].add("Chi");
        list[index].add("Phi");
        list[index].add("Upsilon");
        list[index].add("Tau");
        list[index].add("Sigma");
        list[index].add("Rho");

        list[++index].clear();

        list[++index].clear();
        list[index].add("Eins");
    }

    /**
     * Try and perform an invalid swap.
     *
     * @param tList a Linked list containing elements to swap.
     */
    private void swapTestOne(Linked<E> tList) {
        System.out.println("****Test 1: Trying an invalid swap: list.swap(-1)");
        System.out.println("Before :");
        tList.display();

        try {
            tList.swap(-1);
            System.out.println("FAILED -- did not throw Exception ");
        }
        catch(NoSuchElementException nsee) {
            System.out.println("Conditionally Passed, check output");
        }
        System.out.println("After :");
        tList.display();
        System.out.println("\n");
    }

    /**
     * Try and perform an invalid swap.
     *
     * @param tList a Linked list containing elements to swap.
     */
    private void swapTestTwo(Linked<E> tList) {
        System.out.println("***Test 2: Trying an invalid swap " +
                "list.swap(3)");
        System.out.println("Before :");
        tList.display();

        try {
            tList.swap(3);
            System.out.println("FAILED -- did not throw Exception ");
        }
        catch(NoSuchElementException nsee) {
            System.out.println("Conditionally Passed, check output ");
        }

        System.out.println("After :");
        tList.display();
        System.out.println();
    }
    /**
     * Try and perform an valid swap.
     *
     * @param tList a Linked list containing elements to swap.
     */
    private void swapTestThree(Linked<E> tList) {
        System.out.println("***Test 3: Trying a valid swap list.swap(1)");
        System.out.println("Before:");
        tList.display();

        try {
            tList.swap(1);
            System.out.println("Conditionally Passed, check output");
        }
        catch(NoSuchElementException nsee) {
            System.out.println("FAILED -- did not throw Exception ");
        }

        System.out.println("After:");
        tList.display();
        System.out.println();
    }
    /**
     * Try and perform an valid swap.
     *
     * @param tList a Linked list containing elements to swap.
     */
    private void swapTestFour(Linked<E> tList) {
        System.out.println("***Test 4: Trying a valid swap " +
                "list.swap(1)");
        System.out.println("Before:");
        tList.display();

        try {
            tList.swap(1);
            System.out.println("Conditionally Passed, check output");
        }
        catch(NoSuchElementException nsee) {
            System.out.println("FAILED -- did not throw Exception ");
        }

        System.out.println("After:");
        tList.display();
        System.out.println();

    }
    /**
     * Try and perform an valid swap.
     *
     * @param tList a Linked list containing elements to swap.
     */
    private void swapTestFive(Linked<E> tList) {
        System.out.println("***Test 5: Trying a valid swap " +
                "list.swap(2)");
        System.out.println("Before:");
        tList.display();

        try {
            tList.swap(2);
            System.out.println("Conditionally Passed, check output");
        }
        catch(NoSuchElementException nsee) {
            System.out.println("FAILED -- did not throw Exception ");
        }

        System.out.println("After:");
        tList.display();
        System.out.println();
    }
    /**
     * Try and perform an valid swap.
     *
     * @param tList a Linked list containing elements to swap.
     */
    private void swapTestSix(Linked<E> tList) {
        System.out.println("***Test 6: Trying a valid swap " +
                "list.swap(1)");
        System.out.println("Before:");
        tList.display();

        try {
            tList.swap(1);
            System.out.println("Conditionally Passed, check output");
        }
        catch(NoSuchElementException nsee) {
            System.out.println("FAILED -- did not throw Exception ");
        }

        System.out.println("After:");
        tList.display();
        System.out.println();
    }
    /**
     * Try and perform an valid swap.
     *
     * @param tList a Linked list containing elements to swap.
     */
    private void swapTestSeven(Linked<E> tList) {
        System.out.println("***Test 7: Trying a invalid swap " +
                "list.swap(3) -- list is size 3");
        System.out.println("Before:");
        tList.display();

        try {
            tList.swap(3);
            System.out.println("FAILED -- did not throw Exception ");
        }
        catch(NoSuchElementException nsee) {
            System.out.println("Conditionally Passed, check output");
        }

        System.out.println("After:");
        tList.display();
        System.out.println();
    }
    /**
     * Perform swap tests.
     */
    @SuppressWarnings("unchecked")
    public void checkSwap() {
        this.initSetOne();
        this.initSetTwo();

        System.out.println("Testing swap");

        swapTestOne((Linked<E>)list[0]);
        swapTestTwo((Linked<E>)list[0]);
        swapTestThree((Linked<E>)list[0]);

        System.out.print("Press any key to continue > ");
        scanIn.next();

        swapTestFour((Linked<E>)list[1]);
        swapTestFive((Linked<E>)list[1]);
        swapTestSix((Linked<E>)list[1]);

        System.out.print("Press any key to continue > ");
        scanIn.next();

        swapTestSeven((Linked<E>)list[0]);

        System.out.print("Press any key to continue > ");
        scanIn.next();
    }
    /**
     * Reverse lists.
     *
     * @param temp a Linked list containing elements to swap.
     */
    private void reverseTestOne(Linked<E> temp) {
        System.out.println("List  is ");
        temp.display();
        System.out.println();

        System.out.println("List after reverse is now");
        temp.reverse();
        temp.display();
        System.out.println();

        System.out.println("Reversing list a second time");
        System.out.println("List is now");
        temp.reverse();
        temp.display();
        System.out.println();
    }
    /**
     * Reverse lists.
     *
     * @param temp a Linked list containing elements to swap.
     */
    private void reverseTestTwo(Linked<E> temp) {
        System.out.println("List is:");
        temp.display();
        System.out.println();

        System.out.println("List after reverse " +
                "(list is even length)");
        temp.reverse();
        temp.display();
        System.out.println();
    }
    /**
     * Reverse lists.
     *
     * @param temp a Linked list containing elements to swap.
     */
    private void reverseTestThree(Linked<E> temp) {
        System.out.println("List is:");
        temp.display();
        System.out.println();

        System.out.println("List after reverse " +
                "(list is odd length)");
        temp.reverse();
        temp.display();
        System.out.println();
    }
    /**
     * Reverse lists.
     *
     * @param temp a Linked list containing elements to swap.
     */
    private void reverseTestFour(Linked<E> temp) {
        System.out.println("Reversing a list of length 0");
        temp.reverse();
        temp.display();
        System.out.println();
    }
    /**
     * Reverse lists.
     *
     * @param temp a Linked list containing elements to swap.
     */
    private void reverseTestFive(Linked<E> temp) {
        System.out.println("Reversing a list of length 1");
        temp.reverse();
        temp.display();
        System.out.println();
    }

    /**
     * Perform Reverse tests.
     */
    @SuppressWarnings("unchecked")
    public void checkReverse() {
        initSetOne();
        initSetTwo();
        Scanner scanIn = new Scanner(System.in);

        System.out.println("Testing reverse");
        reverseTestOne((Linked<E>)list[2]);

        System.out.print("Press any key to continue > ");
        scanIn.next();

        reverseTestTwo((Linked<E>)list[4]);
        reverseTestThree((Linked<E>)list[3]);
        System.out.print("Press any key to continue > ");
        scanIn.next();

        reverseTestFour((Linked<E>)list[5]);

        reverseTestFive((Linked<E>)list[6]);
    }
    /**
     * Cycle elements within a list.
     *
     * @param temp a Linked list containing elements to cycle.
     */
    private void cycleTestOne(Linked<E> temp) {
        System.out.println("--------------------------------");
        System.out.println("Cycling list  once");
        temp.display();
        System.out.println();
        temp.cycle();
        temp.display();
    }
    /**
     * Cycle elements within a list.
     *
     * @param temp a Linked list containing elements to cycle.
     */
    private void cycleTestTwo(Linked<E> temp) {
        System.out.println("--------------------------------");
        System.out.println("Cycling list three times");
        temp.display();
        temp.cycle();
        temp.cycle();
        temp.cycle();
        System.out.println();
        temp.display();
    }
    /**
     * Cycle elements within a list.
     *
     * @param temp a Linked list containing elements to cycle.
     */
    private void cycleTestThree(Linked<E> temp) {
        System.out.println("--------------------------------");
        System.out.println("Cycle a list of length 0");
        temp.display();
        System.out.println();
        try {
            temp.cycle();
        }
        catch(NoSuchElementException nsee) {
            System.out.println("Passed: " + nsee.getMessage());
        }
        temp.display();
        System.out.println();
    }
    /**
     * Cycle elements within a list.
     *
     * @param temp a Linked list containing elements to cycle.
     */
    private void cycleTestFour(Linked<E> temp) {
        System.out.println("--------------------------------");
        System.out.println("Cylce a list of length 1");
        temp.display();
        System.out.println();
        temp.cycle();
        temp.display();
        System.out.println();
    }
    /**
     * Perform cycle tests.
     */
    @SuppressWarnings("unchecked")
    public void checkCycle() {
        System.out.print("Press (C)ontinue or (Q)uit > ");
        String junk = scanIn.next();
        if (junk.toLowerCase().equals("q"))
            return;
        initSetOne();
        initSetTwo();
        cycleTestOne((Linked<E>)list[0]);
        System.out.print("Press any key to continue > ");
        scanIn.next();

        cycleTestTwo((Linked<E>)list[1]);
        cycleTestThree((Linked<E>)list[5]);
        cycleTestFour((Linked<E>)list[6]);
    }

    /**
     * Perform extract tests.
     */
    public void checkExtract(){
        System.out.println("\n\nTesting extract(2, 5)...\n");

        Linked<String> oL = new Linked<String>();
        oL.add("Red");
        oL.add("Blue");
        oL.add("Green");
        oL.add("Yellow");
        oL.add("Orange");
        oL.add("Purple");
        oL.add("Tan");
        oL.add("Teal");

        oL.display();
        System.out.println("\n");
        oL.extract(0, 5);
        oL.display();

        System.out.println("\n\nTesting extract(0, 5)...\n");

        oL.display();
        System.out.println("\n");
        oL.extract(0, 5);
        oL.display();

        System.out.println("\n\nTesting extract(2, 7)...\n");

        oL.display();
        System.out.println("\n");
        oL.extract(2, 7);
        oL.display();

        System.out.println("\n\nTesting extract(2,8)...\n");

        oL.display();
        System.out.println("\n");
        oL.extract(2, 8);
        oL.display();


    }


    /**
     * Main method within the driver.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        ListDriver<String> driver;

        driver = new ListDriver<String>();
        System.out.print("Testing LinkedList... ");
        driver.drive();
        System.out.println("done.");
    }
} // end ListDriver
