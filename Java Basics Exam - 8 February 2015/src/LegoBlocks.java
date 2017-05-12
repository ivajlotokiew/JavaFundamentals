import java.util.Scanner;


public class LegoBlocks_2 {
    static int isEquals;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nums = Integer.parseInt(input.nextLine());
        int sumCells = 0;
        boolean isResult = false;
        int[][] firstArray = new int[nums][];
        int[][] secondArray = new int[nums][];

        for (int i = 0; i < nums; i++) {
            String[] firstBuffer = input.nextLine().trim().split("\\s+");
            firstArray[i] = new int[firstBuffer.length];
            for (int j = 0; j < firstBuffer.length; j++) {
                firstArray[i][j] = Integer.parseInt(firstBuffer[j]);
                sumCells++;
            }
        }
        for (int i = 0; i < nums; i++) {
            String[] secondBuffer = input.nextLine().trim().split("\\s+");
            secondArray[i] = new int[secondBuffer.length];
            for (int j = 0; j < secondBuffer.length; j++) {
                secondArray[i][j] = Integer.parseInt(secondBuffer[j]);
                sumCells++;
            }
        }

        isEquals = firstArray[0].length + secondArray[0].length;
        for (int i = 1; i < nums; i++) {
            if (isEquals == firstArray[i].length + secondArray[i].length) {
                isResult = true;
            } else {
                System.out.printf("The total number of cells is: %d\n", sumCells);
                return;
            }
        }
        if (isResult) {
            secondArray = reverseSecondMatrix(secondArray);
            printConcatArrays(firstArray, secondArray);
        }

    }

    private static void printConcatArrays(int[][] firstArray, int[][] secondArray) {
        int count = 0;
        for (int i = 0; i < firstArray.length; i++) {
            String output = "[";

            for (int j = 0; j < isEquals; j++) {
                while (j < firstArray[i].length) {
                    output += firstArray[i][j] + ", ";
                    j++;
                }
                output += secondArray[i][count] + ", ";
                count++;
            }
            System.out.println(output.substring(0, output.length() - 2) + "]");
            count = 0;
        }
    }

    private static int[][] reverseSecondMatrix(int[][] secondMatrix) {
        int[][] reverseArray = new int[secondMatrix.length][];
        for (int i = 0; i < secondMatrix.length; i++) {
            int index = secondMatrix[i].length - 1;
            reverseArray[i] = new int[index + 1];
            for (int j = 0; j < secondMatrix[i].length; j++) {
                reverseArray[i][index] = secondMatrix[i][j];
                index--;
            }
        }
        return reverseArray;
    }
}