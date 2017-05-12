import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GandalfStash {
    public static void main(String[] args) {
        Scanner consoleReadLine = new Scanner(System.in);
        int moodGandalf = consoleReadLine.nextInt();
        consoleReadLine.nextLine();
        String inputFood = consoleReadLine.nextLine();
        Pattern pattern = Pattern.compile("([A-Za-z]+)");
        Matcher match = pattern.matcher(inputFood);
        int sumHappiness = moodGandalf;
        while (match.find()) {
            switch (match.group().toLowerCase()) {
                case "cram":
                    sumHappiness += 2;
                    break;
                case "lembas":
                    sumHappiness += 3;
                    break;
                case "apple":
                    sumHappiness += 1;
                    break;
                case "melon":
                    sumHappiness += 1;
                    break;
                case "honeycake":
                    sumHappiness += 5;
                    break;
                case "mushrooms":
                    sumHappiness += -10;
                    break;
                default:
                    sumHappiness += -1;
                    break;
            }
        }
        if (sumHappiness < -5) {
            System.out.println(sumHappiness);
            System.out.println("Angry");
        } else if (sumHappiness >= -5 && sumHappiness < 0) {
            System.out.println(sumHappiness);
            System.out.println("Sad");
        } else if (sumHappiness >= 0 && sumHappiness < 15) {
            System.out.println(sumHappiness);
            System.out.println("Happy");
        } else if (sumHappiness >15) {
            System.out.println(sumHappiness);
            System.out.println("Special JavaScript mood");
        }
    }
}