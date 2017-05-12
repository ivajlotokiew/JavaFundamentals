import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScript {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int res = N % 52;
        char symb = ' ';
        if (res >= 1 && res <= 26) {
            symb = ((char) (res + 96));
        }else if(res == 0){
            symb = ((char) (res + 38));
        }
        else {
            symb = ((char) (N + 38));
        }
        String text = input.nextLine();
        String concatText = "";
        while (!text.equals("End")) {
            concatText += text;
            text = input.nextLine();
        }
        String rgx = "" + symb + symb;
        Pattern pattern = Pattern.compile("(" + rgx + ")(?<contains>.*?)\\1");
        Matcher matcher = pattern.matcher(concatText);
        while (matcher.find()) {
            System.out.println(matcher.group("contains"));
        }
    }
}