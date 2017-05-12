import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Character> beforTheNumber = new ArrayList<>();
        List<Integer> theNumber = new ArrayList<>();
        List<Character> afterTheNumber = new ArrayList<>();
        double sum = 0.00;
        String text = input.nextLine();
        Pattern pattern = Pattern.compile("(?<front>[^\\d\\s]+)(?<num>[^\\D\\s]+)(?<back>[^\\d\\s]+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            char front = matcher.group("front").charAt(0);
            double num = Double.parseDouble(matcher.group("num"));
            char back = matcher.group("back").charAt(0);

            if (Character.isUpperCase(front)) {
                sum += num / (front - 64);
                if (Character.isUpperCase(back)) {
                    sum -= back - 64;
                } else {
                    sum += back - 96;
                }

            } else {
                sum += num * (front - 96);
                if (Character.isUpperCase(back)) {
                    sum -= back - 64;
                } else {
                    sum += back - 96;
                }
            }
        }
        System.out.printf("%.2f", sum);
    }
}