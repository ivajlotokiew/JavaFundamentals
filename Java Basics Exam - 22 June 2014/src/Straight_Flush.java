import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StraightFlush {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine().replace(',', ' ')
                .replaceAll("J", "11").replaceAll("Q", "12")
                .replaceAll("K", "13").replaceAll("A", "14");
        boolean isResult = false;
        Pattern patternS = Pattern.compile("\\d+S");
        List numsS = new ArrayList<Integer>();
        Matcher matcher = patternS.matcher(inputText);
        int counter = 4;
        while (matcher.find()) {
            numsS.add(Integer.parseInt(matcher.group().replace('S', ' ').trim()));
        }
        Collections.sort(numsS);
        int currentNum;
        String straightFlushS = "";
        for (int i = 0; i < numsS.size(); i++) {
            straightFlushS = "" + numsS.get(i) + "S, ";
            currentNum = (Integer) numsS.get(i);
            for (int j = 0; j < numsS.size(); j++) {
                if (currentNum == (Integer) numsS.get(j) - 1) {
                    straightFlushS += numsS.get(j) + "S, ";
                    currentNum = (Integer) numsS.get(j);
                    counter--;
                    if (counter == 0) {
                        System.out.println("[" + straightFlushS.substring(0, straightFlushS.length() - 2)
                                .replaceAll("11", "J").replaceAll("12", "Q")
                                .replaceAll("13", "K").replaceAll("14", "A") + "]");
                        isResult = true;
                    }
                }
            }
            straightFlushS = "";
            counter = 4;
        }

        Pattern patternH = Pattern.compile("\\d+H");
        List numsH = new ArrayList<Integer>();
        Matcher matcherH = patternH.matcher(inputText);
        counter = 4;
        while (matcherH.find()) {
            numsH.add(Integer.parseInt(matcherH.group().replace('H', ' ').trim()));
        }
        Collections.sort(numsH);
        String straightFlushH = "";
        for (int i = 0; i < numsH.size(); i++) {
            straightFlushH = "" + numsH.get(i) + "H, ";
            currentNum = (Integer) numsH.get(i);
            for (int j = 0; j < numsH.size(); j++) {
                if (currentNum == (Integer) numsH.get(j) - 1) {
                    straightFlushH += numsH.get(j) + "H, ";
                    currentNum = (Integer) numsH.get(j);
                    counter--;
                    if (counter == 0) {
                        System.out.println("[" + straightFlushH.substring(0, straightFlushH.length() - 2)
                                .replaceAll("11", "J").replaceAll("12", "Q")
                                .replaceAll("13", "K").replaceAll("14", "A") + "]");
                        isResult = true;

                    }
                }
            }
            straightFlushH = "";
            counter = 4;
        }


        Pattern patternD = Pattern.compile("\\d+D");
        List numsD = new ArrayList<Integer>();
        Matcher matcherD = patternD.matcher(inputText);
        counter = 4;
        while (matcherD.find()) {
            numsD.add(Integer.parseInt(matcherD.group().replace('D', ' ').trim()));
        }
        Collections.sort(numsD);
        String straightFlushD = "";
        for (int i = 0; i < numsD.size(); i++) {
            straightFlushD = "" + numsD.get(i) + "D, ";
            currentNum = (Integer) numsD.get(i);
            for (int j = 0; j < numsD.size(); j++) {
                if (currentNum == (Integer) numsD.get(j) - 1) {
                    straightFlushD += numsD.get(j) + "D, ";
                    currentNum = (Integer) numsD.get(j);
                    counter--;
                    if (counter == 0) {
                        System.out.println("[" + straightFlushD.substring(0, straightFlushD.length() - 2)
                                .replaceAll("11", "J").replaceAll("12", "Q")
                                .replaceAll("13", "K").replaceAll("14", "A") + "]");
                        isResult = true;

                    }
                }
            }
            straightFlushD = "";
            counter = 4;
        }


        Pattern patternC = Pattern.compile("\\d+C");
        List numsC = new ArrayList<Integer>();
        Matcher matcherC = patternC.matcher(inputText);
        counter = 4;
        while (matcherC.find()) {
            numsC.add(Integer.parseInt(matcherC.group().replace('C', ' ').trim()));
        }
        Collections.sort(numsC);
        String straightFlushC = "";
        for (int i = 0; i < numsC.size(); i++) {
            straightFlushC = "" + numsC.get(i) + "C, ";
            currentNum = (Integer) numsC.get(i);
            for (int j = 0; j < numsC.size(); j++) {
                if (currentNum == (Integer) numsC.get(j) - 1) {
                    straightFlushC += numsC.get(j) + "C, ";
                    currentNum = (Integer) numsC.get(j);
                    counter--;
                    if (counter == 0) {
                        System.out.println("[" + straightFlushC.substring(0, straightFlushC.length() - 2)
                                .replaceAll("11", "J").replaceAll("12", "Q")
                                .replaceAll("13", "K").replaceAll("14", "A") + "]");
                        isResult = true;

                    }
                }
            }
            straightFlushC = "";
            counter = 4;
        }
        if (!isResult){
            System.out.println("No Straight Flushes");
        }
    }
}