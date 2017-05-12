import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs_Second {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String rowData = input.nextLine();
        Pattern pattern = Pattern.compile("IP=(?<IP>[^\\s]+)\\s+message=\\s*.*?user=\\s*(?<user>.*)");
        TreeMap<String, LinkedHashMap<String, Integer>> mainMap = new TreeMap<>();
        while (!rowData.equals("end")) {
            Matcher matcher = pattern.matcher(rowData);
            while (matcher.find()) {
                String user = matcher.group("user");
                String IP = matcher.group("IP");
                if (!mainMap.containsKey(user)) {
                    mainMap.put(user, new LinkedHashMap<>());
                }
                if (!mainMap.get(user).containsKey(IP)) {
                    mainMap.get(user).put(IP, 0);
                }
                int curCount = mainMap.get(user).get(IP) + 1;
                mainMap.get(user).put(IP, curCount);
            }
            rowData = input.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : mainMap.entrySet()) {
            String outline = entry.getKey() + ":\n";

            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                outline += innerEntry.getKey() + " => " + innerEntry.getValue() + ", ";
            }
            System.out.println(outline.substring(0, outline.length() - 2) + ".");
        }
    }
}