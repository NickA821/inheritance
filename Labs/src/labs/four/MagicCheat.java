package labs.four;

import java.util.Scanner;
public class MagicCheat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Give an odd number: "); //5
        int n = scanner.nextInt();
        int[][] magicSquare = new int[n][n];

        int number = 1;
        int row = 0;
        int column = n / 2;  // 2
        int curr_row;
        int curr_col;
        while (number <= n * n) {    //while 1 <= 25
            magicSquare[row][column] = number;  //magicSquare[0][2] = 1
            number++;  // 2
            curr_row = row; // 0
            curr_col = column; // 2
            row -= 1; // -1
            column += 1; // 3
            if (row == -1) {
                row = n - 1; // 4
            }
            if (column == n) {
                column = 0;
            }
            if (magicSquare[row][column] != 0) {
                row = curr_row + 1; //
                column = curr_col;
                if (row == -1) {
                    row = n - 1;
                }
            }
        }

        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare.length; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }

}
