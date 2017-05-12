import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Biggest_3PrimeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String textWihtNums = input.nextLine();
        List<Integer> natNums = new ArrayList<>();
        String onlyPosititveNums = "";
        String[] escapeNegativeNums = textWihtNums.split("(?<negative>\\(\\s*-\\d*\\s*\\))");
        for (String escapeNegativeNum : escapeNegativeNums) {
            onlyPosititveNums += escapeNegativeNum;
        }
        Pattern pattern = Pattern.compile("(?<nums>\\d+)");
        Matcher matcher = pattern.matcher(onlyPosititveNums);
        while (matcher.find()) {
            int currentNum = Integer.parseInt(matcher.group("nums"));
            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(currentNum); i++) {
                if (currentNum % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                natNums.add(currentNum);
            }
        }
        Collections.sort(natNums);
        int sum = 0;
        if (natNums.size() < 3) {
            System.out.printf("No");
            return;
        } else {
            for (int i = natNums.size() - 1; i >= natNums.size() - 3; i--) {

                sum += natNums.get(i);
            }
        }
        System.out.println(sum);
    }
}