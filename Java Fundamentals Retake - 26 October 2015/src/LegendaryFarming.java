import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegendaryFarming_2 {
    static String obtained;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<String, Integer>(){{
            put("fragments", 0);
            put("shards", 0);
            put("motes", 0);

        }};
        TreeMap<String, Integer> junkMap = new TreeMap<>();
        boolean isResult = false;
        while (!isResult) {
            String text = input.nextLine();
            Pattern pattern = Pattern.compile("(?<quantity>\\d+)\\s+(?<material>[^\\s]+)");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String material = matcher.group("material").toLowerCase();
                Integer quantity = Integer.parseInt(matcher.group("quantity"));
                if (material.equals("fragments")
                        || material.equals("shards")
                        || material.equals("motes")) {
                    map.put(material, map.get(material) + quantity);
                    if (map.get(material) >= 250) {
                        obtained = material;
                        map.put(material, map.get(material) - 250);
                        isResult = true;
                        break;
                    }
                } else {
                    if (!junkMap.containsKey(material)) {
                        junkMap.put(material, 0);
                    }
                    junkMap.put(material, junkMap.get(material) + quantity);
                }
            }
        }
        System.out.printf("%s obtained!\n", obtainedItems());
        map.entrySet().stream()
                .sorted(Comparator.comparing(e-> -e.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        for (Map.Entry<String, Integer> entry : junkMap.entrySet()) {
            System.out.println(entry.getKey() +": "+ entry.getValue());
        }
    }

    private static String obtainedItems() {
        if (obtained.equals("fragments")){
            return "Valanyr";

        }else if (obtained.equals("shards")){
            return "Shadowmourne";

        }else if (obtained.equals("motes")){
            return "Dragonwrath";

        }
        return "There is no obtainedItems";
    }
}