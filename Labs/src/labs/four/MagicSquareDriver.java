package four;

public class MagicSquareDriver {
    /**The number of tests conducted**/
    private static int tests = 0;
    /**The number of tests passed**/
    private static int tests_passed = 0;
    /**The number of tests failed**/
    private static int tests_failed = 0;

    /**A valid ms**/
    private static int[][] grid1 = {{1,1,1},{1,1,1},{1,1,1}};//v
    /**A valid ms**/
    private static int[][] grid2 = {{1,0,2},{2,1,0},{0,1,2}};//v
    /**A valid ms**/
    private static int[][] grid3 = {{4,9,2},{3,5,7},{8,1,6}};//v
    /**An invalid ms**/
    private static int[][] grid4 = {{1,1,1},{2,1,1},{0,1,1}};//i
    /**A valid large ms**/
    private static int[][] grid5 = {{16,3,2,13},{5,10,11,8},{9,6,7,12},{4,15,14,1}};//v
    /**An invalid large ms**/
    private static int[][] grid6 = {{16,3,2,13},{5,11,11,8},{9,6,7,12},{4,15,4,1}};//i

    /**
     * Conduct all the tests to check the MagicSquare class works.
     */
    public static void doTests() {

        //Test the girds can be detected as magic or not correctly.
        magicTest(grid1,true);
        magicTest(grid2,false);
        magicTest(grid3,true);
        magicTest(grid4,false);
        magicTest(grid5,true);
        magicTest(grid6,false);

        //Test the getSize works well.
        MagicSquare ms1 = new MagicSquare(5);
        testSize(ms1,5);

        //Test the setSize works to make bigger.
        ms1.setSize(10);
        testSize(ms1,10);

        //Test the setSize works to make smaller.
        ms1.setSize(2);
        testSize(ms1,2);

        //Manual test does not pass or fail you need to check it.
        tests++;
        System.out.println("\nTest " + tests + " testing randomFill");
        ms1.setSize(5);
        ms1.randomFill(100);
        System.out.println(ms1.toString());
        if(ms1.isMagic())
            System.out.println("This is Magic");
        else
            System.out.println("This is not magic");


        //Manual test does not pass or fail you need to use it.
        tests++;
        System.out.println("\nTest " + tests + " testing userFill");
        MagicSquare ms2 = new MagicSquare(3);
        ms2.userFill();
        System.out.println(ms2.toString());

        if(ms2.isMagic())
            System.out.println("This is Magic");
        else
            System.out.println("This is not magic");

    }//end do tests

    /**
     * Display the test results on screen.
     */
    public static void displayResults() {

        System.out.println("\nTEST RESULTS\n========================");
        System.out.println("Tests Passed: " + tests_passed);
        System.out.println("Test Failed: " + tests_failed);
        System.out.println("Other tests " + 2);
    }//end display results;

    /**
     * Test that the size of a MagicSquare object can be established
     * correctly.
     * @param ms The magic square object to check.
     * @param size The size that should be detected.
     */
    public static void testSize(MagicSquare ms, int size) {
        tests++;
        System.out.println("Test " + tests + " - Testing size of " + size);

        //Count success or failure
        if( ms.getSize() == size){
            System.out.println("Test passed!");
            tests_passed++;
        }
        else {
            System.out.println("Test failed!");
            tests_failed++;
        }

    }//end testSize

    /**
     * Peforms a test to make sure the MagicSquare object properly
     * detects magic squares.
     * @param array The array to place in the magic square.
     * @param valid Should the array be detected as a magic square.
     */
    public static void magicTest(int[][] array, boolean valid) {

        tests ++;

        MagicSquare msq = new MagicSquare(array);

        System.out.println("Test " + tests + "\n" + msq.toString());

        //is it magic
        if(msq.isMagic())
            System.out.println("This is Magic");
        else
            System.out.println("This is not magic");


        //Count success and failure.
        if (msq.isMagic() == valid) {
            tests_passed++;
            System.out.println("Test passed!");

        }else {
            tests_passed--;
            System.out.println("Test failed!");
        }

    }//end magic test

    /**
     * Conduct the tests and dislay the result.
     * @param args Not used.
     */
    public static void main(String[] args) {
        doTests();
        displayResults();

    }//end main

}//end class

