import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DozensOfEggs {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int sumEggs = 0;
        List<String> arrEggsCount = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String eggsCount = input.nextLine();
            arrEggsCount.addAll(Arrays.asList(eggsCount.split("\\s+")));
            if (arrEggsCount.get(1).equals("eggs")) {
                sumEggs += Integer.parseInt(arrEggsCount.get(0));
            }else {
                sumEggs += Integer.parseInt(arrEggsCount.get(0)) * 12;
            }

            arrEggsCount = new ArrayList<>();
        }
        System.out.printf("%d dozens + %d eggs", sumEggs/12, sumEggs%12);
    }
}