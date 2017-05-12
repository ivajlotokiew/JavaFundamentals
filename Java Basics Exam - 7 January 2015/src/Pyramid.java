import java.util.Arrays;
import java.util.Scanner;

public class Pyramid_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = Integer.parseInt(input.nextLine());
        int currentNumb = Integer.parseInt(input.nextLine().trim());
        boolean isResult = false;
        String output = currentNumb + ", ";
        for (int i = 1; i < rows; i++) {
            String[] pyramid = input.nextLine().trim().split("\\s+");
            int[] sortedArray = Arrays.asList(pyramid).stream()
                    .mapToInt(Integer::parseInt)
                    .sorted().toArray();
            isResult = false;
            for (int j = 0; j < sortedArray.length; j++) {
                if (currentNumb < sortedArray[j]) {
                    currentNumb = sortedArray[j];
                    output += sortedArray[j] + ", ";
                    isResult = true;
                    break;
                }
            }
            if (!isResult) {
                currentNumb++;
            }
        }
        System.out.println(output.substring(0, output.length() - 2));
    }
}