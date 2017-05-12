import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CognateWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> collectWords = new ArrayList<>();
        String[] cognateWords = input.nextLine().trim().split("[^A-Za-z]+");
        collectWords.addAll(Arrays.asList(cognateWords));
        collectWords = collectWords.stream().distinct().collect(Collectors.toList());
        boolean isResult = false;
        for (int i = 0; i < collectWords.size(); i++) {
            for (int j = 0; j < collectWords.size() - 1; j++) {
                for (int k = j + 1; k < collectWords.size(); k++) {
                    if (collectWords.get(i).equals(collectWords.get(j) + collectWords.get(k))) {
                        System.out.printf("%s|%s=%s\n", collectWords.get(j), collectWords.get(k), collectWords.get(i));
                        isResult = true;
                    } else if (collectWords.get(i).equals(collectWords.get(k) + collectWords.get(j))) {
                        System.out.printf("%s|%s=%s\n", collectWords.get(k), collectWords.get(j), collectWords.get(i));
                        isResult = true;
                    }
                }
            }
        }
        if (!isResult){
            System.out.println("No");
        }
    }
}