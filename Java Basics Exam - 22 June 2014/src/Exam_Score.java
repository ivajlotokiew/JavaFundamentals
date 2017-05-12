import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.nextLine();
        input.nextLine();
        input.nextLine();
        String inputText = input.nextLine().replace("|", " ").trim();
        Pattern pattern = Pattern.compile("(?<name>[A-Za-a][\\sA-Za-z]+?)\\s+(?<score>\\d+)\\s+(?<grade>\\d?\\.\\d+)");
        TreeMap<Integer, TreeMap<String, Double>> map = new TreeMap<>();
        while (!inputText.replace("-", " ").trim().equals("")){
            Matcher matcher = pattern.matcher(inputText);
            while (matcher.find()){
                String name = matcher.group("name");
                int score = Integer.parseInt(matcher.group("score"));
                double grade = Double.parseDouble(matcher.group("grade"));
                if (!map.containsKey(score)){
                    map.put(score, new TreeMap<>());
                }
                if (!map.get(score).containsKey(name)){
                    map.get(score).put(name, grade);
                }
            }
            inputText = input.nextLine().replace("|", " ").trim();
        }
        int counter = 0;
        double avg = 0.0;
        for (Map.Entry<Integer, TreeMap<String, Double>> entry: map.entrySet()){
            String output = entry.getKey() + " -> [";
            for (Map.Entry<String, Double> innerEntry: entry.getValue().entrySet()){
                output += innerEntry.getKey() + ", ";
                avg += innerEntry.getValue();
                counter++;
            }
            System.out.printf("%s]; avg=%.2f\n", output.substring(0, output.length() -2), avg/counter);
            avg = 0.0;
            counter = 0;
        }
    }
}