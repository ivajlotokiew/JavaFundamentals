import java.util.Scanner;

public class AddingAngles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nums = Integer.parseInt(input.nextLine());
        int[] numsArray = new int[nums];
        int sum = 0;
        boolean isResult = false;
        for (int i = 0; i < nums; i++) {
            numsArray[i] = input.nextInt();
        }

        for (int i = 0; i < nums - 2; i++) {
            for (int j = i + 1; j < nums - 1; j++) {
                for (int k = j + 1; k < nums; k++) {
                    sum = numsArray[i] + numsArray[j] + numsArray[k];
                    if (sum % 360 == 0) {
                        System.out.printf("%d + %d + %d = %d degrees\n", numsArray[i], numsArray[j], numsArray[k], sum);
                        isResult = true;
                    }
                    sum = 0;
                }
            }
        }
        if (!isResult){
            System.out.print("No");
        }
    }
}