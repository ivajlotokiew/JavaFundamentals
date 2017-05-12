import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numRecords = Integer.parseInt(input.nextLine());
        TreeMap<Integer, Map<String, Integer>> mainMap = new TreeMap<>();
        TreeMap<String, Integer> innerMap = new TreeMap<>();
        Pattern pattern = Pattern.compile("\\d+\\s*\\/\\s*(?<month>\\d+)" +
                ".*?\\s+(?<user>[A-Za-z]+)\\s+(?<distance>\\d+)");
        for (int i = 0; i < numRecords; i++) {
            String data = input.nextLine();
            Matcher matcher = pattern.matcher(data);
            while (matcher.find()) {
                int month = Integer.parseInt(matcher.group("month"));
                String user = matcher.group("user");
                int distance = Integer.parseInt(matcher.group("distance"));
                if (!mainMap.containsKey(month)) {
                    innerMap = new TreeMap<>();
                    innerMap.put(user, distance);
                    mainMap.put(month, innerMap);
                } else {
                    innerMap = (TreeMap<String, Integer>) mainMap.get(month);
                    if (!innerMap.containsKey(user)) {
                        innerMap.put(user, distance);
                    } else {
                        innerMap.put(user, innerMap.get(user) + distance);
                    }
                    mainMap.put(month, innerMap);
                }
            }
        }
        for (Map.Entry<Integer, Map<String, Integer>> entry : mainMap.entrySet()) {
            String outputLine = entry.getKey() + ": ";
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet())
                outputLine += innerEntry.getKey() + "(" + innerEntry.getValue() + "), ";
            outputLine = outputLine.substring(0, outputLine.length() - 2);
            System.out.println(outputLine);

        }
    }
}