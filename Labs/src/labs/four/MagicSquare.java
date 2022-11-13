package four;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
import java.util.Arrays;
public class MagicSquare {

    // ---------Instance Variables---------
    private int[][] initArray;
    private int size;



    // ---------First Constructor---------
    public MagicSquare(int size) {
        initArray = new int[size][size];
        this.size = size;

    }

    // ---------Second Constructor---------
    public MagicSquare(int[][] array) {
        this.initArray = array;
        this.size = array.length;
    }

    // ---------Method to Change Array Size via new instance---------
    public void setSize(int size) {
        this.initArray = new int[size][size];
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Pick the size of your array: ");
        int newLength = (int)scanner.nextInt();
        int[][] changedArray = new int[newLength][newLength];
        for (int i = 0; i < newLength && i < array.length; i++) {
            for (int j = 0; j < changedArray[i].length && j < array[i].length; j++) {
                changedArray[i][j] = array[i][j];
            }
        }*/
    }

    // ---------Method to get Size ---------
    public int getSize() {
        return initArray.length;
    }

    // ---------Method to get Input/fill square---------
    public void userFill() {
        Scanner fill = new Scanner(System.in);
        for (int i = 0; i < initArray.length; i++) {
            for (int j = 0; j < initArray[i].length; j++) {
                System.out.println("Please enter a number to fill the square with: ");
                int nextNum = fill.nextInt();
                this.initArray[i][j] = nextNum;
            }
        }
    }

    // ---------Method to Randomly Fill a Square---------
    public void randomFill(int upperBound) {
        for (int i = 0; i < this.initArray.length; i++) {
            for (int j = 0; j < this.initArray[i].length; j++) {
               int randNum = (int)Math.round(Math.random() * upperBound);
               this.initArray[i][j] = randNum;
            }
        }
    }

    // ---------Method to Format/Return Array via String---------
    public String toString(/*int[][] finalArray*/) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.initArray.length; i++) {
            for (int j = 0; j < this.initArray[i].length; j++) {
                String display = String.valueOf(this.initArray[i][j]);
                if (this.initArray[i][j] < 10) {
                    result.append("[0").append(display).append("]");
                }
                else result.append("[").append(display).append("]");
            }
            result.append("\n");
        }
        return result.toString();
    }


    public int rowSum(int rowNum) {

        int rowSum = 0;
        for (int i = 0; i < this.initArray[0].length; i++) {
            rowSum += this.initArray[rowNum][i];
        }
        return rowSum;
    }

    public int colSum(int colNum) {
        int colSum = 0;
        for (int i = 0; i < this.initArray[0].length; i++) {
            colSum += this.initArray[i][colNum];
        }
        return colSum;
    }

    public int firstDiag(int diagNum) {
        int firstDiagSum = 0;
        for (int i = 0; i < this.initArray[0].length; i++) {
            firstDiagSum += this.initArray[i][i];
        }
        return firstDiagSum;
    }

    public int secondDiag(int diagNum) {
        int secondDiagSum = 0;
        for (int i = this.initArray.length - 1; i > 0; i--) {
            for (int j = 0; j < this.initArray[i].length; j++) {
                secondDiagSum += this.initArray[i][j];
            }
        }
        return secondDiagSum;
    }

    public boolean isMagic() {
        boolean is = true;

        for (int i = 1; i < this.initArray.length; i++) {
            if (rowSum(i) != rowSum(i - 1)) {
                is = false;
            }
            else if (colSum(i) != colSum(i - 1)) {
                is = false;
            }
            else if (firstDiag(i) != firstDiag(i - 1)) {
                is = false;
            }
            else if (secondDiag(i) != secondDiag(i - 1)) {
                is = false;
            }
        }
        return is;
    }


        // ---------Main Method---------
        public static void main(String[] args) {
            int[][] realSquare = {{1, 0, 2}, {2, 1, 0}, {0, 1, 2}};
            MagicSquare test = new MagicSquare(realSquare);
            System.out.println(test.getSize());
            test.setSize(10);
            System.out.println(Arrays.deepToString(test.initArray));
            System.out.println(test.getSize());





        }



    }

