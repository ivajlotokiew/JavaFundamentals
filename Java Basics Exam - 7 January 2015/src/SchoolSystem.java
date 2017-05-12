import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchoolSystem {
    static double average;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numsStats = Integer.parseInt(input.nextLine());
        TreeMap<String, TreeMap<String, ArrayList<Integer>>> map = new TreeMap<>();
        Pattern pattern = Pattern.compile
                ("(?<name>[A-Z][A-Za-z]+\\s+[A-Z][A-Za-z]+)\\s+(?<subj>[^\\s]+)\\s+(?<score>\\d+)");
        for (int i = 0; i < numsStats; i++) {
            String infoStudent = input.nextLine();
            Matcher matcher = pattern.matcher(infoStudent);
            while (matcher.find()){
                String nameStudent = matcher.group("name");
                String subject = matcher.group("subj");
                int score = Integer.parseInt(matcher.group("score"));
                if (!map.containsKey(nameStudent)){
                    map.put(nameStudent, new TreeMap<>());
                }
                if (!map.get(nameStudent).containsKey(subject)){
                    map.get(nameStudent).put(subject, new ArrayList<Integer>());
                }
                map.get(nameStudent).get(subject).add(score);
            }
        }
        for (Map.Entry<String, TreeMap<String, ArrayList<Integer>>> entry: map.entrySet()){
            String output = entry.getKey() + ": [";
            for (Map.Entry<String, ArrayList<Integer>> innerEntry: entry.getValue().entrySet()){
                for (int s: innerEntry.getValue()) {
                    average += s;
                }
                average /= innerEntry.getValue().size();

                output += innerEntry.getKey() + " - " + String.format("%.2f", average) + ", ";
                average = 0;
            }
            System.out.println(output.substring(0, output.length()-2) + "]");
            average = 0;
        }
    }
}