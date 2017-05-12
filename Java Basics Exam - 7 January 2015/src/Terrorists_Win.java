import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        StringBuilder inputText = new StringBuilder();
        inputText.append(text);
        StringBuilder inputTextCopy = new StringBuilder();
        inputTextCopy.append(inputText);
        ArrayList<String> dataBuffer = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\|(?<bomb>[^|]*)\\|");
        Matcher matches = pattern.matcher(inputTextCopy);
        while (matches.find()) {
            dataBuffer.add(matches.group("bomb"));
            int sum = 0;
            int bombArea = 0;
            for (int i = 0; i < dataBuffer.size(); i++) {
                char[] sumSymbols = dataBuffer.get(i).toCharArray();
                for (int j = 0; j < sumSymbols.length; j++) {
                    sum += sumSymbols[j];
                }
                bombArea = sum % 10;
            }
            int index = inputText.indexOf("|");
            if (index != -1) {

                if (index - bombArea >= 0 && index + matches.group().length() + bombArea < inputText.length()) {
                    inputText = inputText.replace(index - bombArea, index + matches.group().length() + bombArea,
                            new String(new char[matches.group().length() + 2 * bombArea]).replace("\0", "."));
                }else if (index - bombArea < 0 && index + matches.group().length() + bombArea < inputText.length()) {
                    inputText = inputText.replace(0, index + matches.group().length() + bombArea,
                            new String(new char[matches.group().length() + bombArea]).replace("\0", "."));
                }else if (index - bombArea >= 0 && index + matches.group().length() + bombArea >= inputText.length()) {
                    inputText = inputText.replace(index - bombArea, inputText.length(),
                            new String(new char[matches.group().length() + bombArea]).replace("\0", "."));
                }else if (index - bombArea < 0 && index + matches.group().length() + bombArea >= inputText.length()) {
                    inputText = inputText.replace(0, inputText.length(),
                            new String(new char[matches.group().length()]).replace("\0", "."));
                }
            }
            dataBuffer.clear();
        }

        System.out.println(inputText);

    }
}

