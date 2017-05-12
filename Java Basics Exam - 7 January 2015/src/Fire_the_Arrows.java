import java.util.Scanner;

public class Fire_the_Arrows {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rowSize = input.nextInt();
        input.nextLine();
        char[][] matrixSymb = new char[rowSize][];
        String name = null;
        for (int row = 0; row < rowSize; row++) {
            name = input.nextLine();
            matrixSymb[row] = new char[name.length()];
            for (int col = 0; col < name.length(); col++) {
                matrixSymb[row][col] = name.charAt(col);
            }
        }
        int counter = rowSize * 2;
        while (counter >= 0) {
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < name.length(); col++) {
                    ArowsMoves(row, col, matrixSymb);
                }
            }
            counter--;
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < name.length(); j++) {
                System.out.print(matrixSymb[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void ArowsMoves(int row, int col, char[][] matrixSymb) {
        int minRow = Math.max(row - 1, 0);
        int minCol = Math.max(col - 1, 0);
        int maxRow = Math.min(row + 1, matrixSymb.length - 1);
        int maxCol = Math.min(col + 1, matrixSymb[row].length - 1);

        if (matrixSymb[row][col] == '<') {
            if (matrixSymb[row][minCol] == 'o') {
                matrixSymb[row][minCol] = '<';
                matrixSymb[row][col] = 'o';
            }
        } else if (matrixSymb[row][col] == '>') {
            if (matrixSymb[row][maxCol] == 'o') {
                matrixSymb[row][maxCol] = '>';
                matrixSymb[row][col] = 'o';
            }
        } else if (matrixSymb[row][col] == '^') {
            if (matrixSymb[minRow][col] == 'o') {
                matrixSymb[minRow][col] = '^';
                matrixSymb[row][col] = 'o';
            }
        } else if (matrixSymb[row][col] == 'v') {
            if (matrixSymb[maxRow][col] == 'o') {
                matrixSymb[maxRow][col] = 'v';
                matrixSymb[row][col] = 'o';
            }
        }
    }
}