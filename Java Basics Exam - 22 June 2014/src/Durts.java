import java.util.Scanner;
import java.util.stream.Stream;

public class Durts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int coordX = input.nextInt();
        int coordY = input.nextInt();
        input.nextLine();
        int radius = Integer.parseInt(input.nextLine());
        int numsPairs = Integer.parseInt(input.nextLine());
        int[] arrayPairs = Stream.of(input.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int leftXborder = coordX - radius;
        int rightXborder = coordX + radius;
        int downYborder = coordY - radius;
        int upYborder = coordY + radius;
        for (int i = 0; i < arrayPairs.length - 1; i += 2) {
            int x = arrayPairs[i];
            int y = arrayPairs[i + 1];
            if ((x < leftXborder + radius / 2 && y < downYborder + radius / 2)
                    || (x < leftXborder + radius / 2 && y > upYborder - radius / 2)
                    || (x > rightXborder - radius / 2 && y < downYborder + radius / 2)
                    || (x > rightXborder - radius / 2 && y > upYborder - radius / 2)) {
                System.out.println("no");
                continue;
            } else {
                if (x >= leftXborder && x <= rightXborder
                        && y >= downYborder && y <= upYborder) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
