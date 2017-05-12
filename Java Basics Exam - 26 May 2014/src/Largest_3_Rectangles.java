import java.util.Scanner;

public class Largest3Rectangles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String rectangle = input.nextLine().replaceAll("[^\\d]+", " ");
        String[] arrayRectangle = rectangle.trim().split("\\s+");
        int[] numsRect = new int[arrayRectangle.length];


        for (int i = 0; i < arrayRectangle.length; i++) {
            numsRect[i] = Integer.parseInt(arrayRectangle[i]);
        }
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i <= arrayRectangle.length - 6; i += 2) {
            currentSum = numsRect[i] * numsRect[i + 1]
                    + numsRect[i + 2] * numsRect[i + 3]
                    + numsRect[i + 4] * numsRect[i + 5];
            if (maxSum < currentSum) {
                maxSum = currentSum;
                index = i;
            }
        }
/*        System.out.printf("%d*%d + %d*%d + %d*%d = %d",
                numsRect[index], numsRect[index + 1],
                numsRect[index + 2], numsRect[index + 3],
                numsRect[index + 4], numsRect[ + 5], maxSum);*/
        System.out.println(maxSum);
    }
}