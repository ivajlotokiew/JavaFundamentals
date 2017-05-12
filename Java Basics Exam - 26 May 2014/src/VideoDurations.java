import java.util.Scanner;

public class VideoDurations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputTime = input.nextLine();
        int sumMins = 0;
        int sumHours = 0;
        while (!inputTime.equals("End")){
            sumHours += Integer.parseInt(inputTime.split(":")[0]);
            sumMins += Integer.parseInt(inputTime.split(":")[1]);
            inputTime = input.nextLine();
        }
        float sum = sumMins/60.0f;
        sumMins = sumMins/60;
        sum = sum - sumMins;
        sum = sum * 0.6f;
        Double mins = (double)sumHours + sumMins + sum;
        String output = String.format("%.2f", mins);
        System.out.print(output.replace('.', ':'));
    }
}