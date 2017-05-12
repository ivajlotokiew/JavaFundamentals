import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinySporebat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int health = 5800;
        int sporebat = 30;
        int glowcaps = 0;
        String data = input.nextLine();
        while (!data.equals("Sporeggar")) {
            Pattern pattern = Pattern.compile("(?<enemies>.*[^\\d])(?<money>\\d+)");
            Matcher matcher = pattern.matcher(data);
            while (matcher.find()) {
                char[] demage = matcher.group("enemies").toCharArray();
                int proffit = Integer.parseInt(matcher.group("money"));
                for (char c : demage) {
                    if (c == 'L') {
                        health += 200;
                    } else {
                        health -= c;
                    }
                    if (health <= 0) {
                        System.out.printf("Died. Glowcaps: %d", glowcaps);
                        return;
                    }
                }
                glowcaps += proffit;
            }
            // .....................
            data = input.nextLine();
        }
        System.out.printf("Health left: %d\n", health);
        if (glowcaps >= 30) {
            System.out.printf("Bought the sporebat. Glowcaps left: %d", glowcaps - sporebat);
        } else {
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", sporebat - glowcaps);
        }
    }
}