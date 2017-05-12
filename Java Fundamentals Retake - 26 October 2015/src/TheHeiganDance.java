import java.util.Scanner;

public class HeiganDance {
    static double demageToHeigan;
    static double heiganArmor = 3000000;
    static int playerRow = 7;
    static int playerCol = 7;
    static int player = 1;
    static int[][] heiganChamber = new int[15][15];
    static int playerArmor = 18500;
    static boolean playerDied = false;
    static boolean heiganDied = false;
    static boolean isClaud = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        demageToHeigan = Double.parseDouble(input.nextLine());
        while (true) {
            String[] spellHeigan = input.nextLine().trim().split("\\s+");
            String spell = spellHeigan[0];
            int spellcoordRow = Integer.parseInt(spellHeigan[1]);
            int spellcoordCol = Integer.parseInt(spellHeigan[2]);
            if (isClaud){
                playerArmor -=3500;
                if (playerArmor<0){
                    playerDied = true;
                }
            }
            isClaud = false;
            heiganArmor -=  demageToHeigan;
            if (heiganArmor < 0){
                heiganDied = true;
            }
            spellSpread(spellcoordRow, spellcoordCol);
            isPlayerDemaged(spell);
            heiganChamber = new int[15][15];
            if (playerDied && !heiganDied){
                System.out.printf("Heigan: %.2f\n", heiganArmor);
                System.out.printf("Player: Killed by %s\n", spell);
                System.out.printf("Final position: %d, %d\n", playerRow, playerCol);
                break;
            }else if(!playerDied && heiganDied){
                System.out.println("Heigan: Defeated!");
                System.out.printf("Player: %d\n", playerArmor);
                System.out.printf("Final position: %d, %d\n", playerRow, playerCol);
                break;
            }else if (playerDied && heiganDied){
                System.out.println("Both player Died!");
                break;
            }
        }
    }

    private static void isPlayerDemaged(String spell) {
        int playerUpRow = Math.max(playerRow - 1, 0);
        int playerDownRow = Math.min(playerRow + 1, heiganChamber[0].length - 1);
        int playerLeftCol = Math.max(playerCol - 1, 0);
        int playerRightCol = Math.min(playerCol + 1, heiganChamber.length - 1);
        if (heiganChamber[playerRow][playerCol] == 2) {
            if (heiganChamber[playerUpRow][playerCol] == 2) {
                if (heiganChamber[playerRow][playerRightCol] == 2) {
                    if (heiganChamber[playerDownRow][playerCol] == 2) {
                        if (heiganChamber[playerRow][playerLeftCol] == 2) {
                            if (spell.equals("Cloud")){
                                playerArmor -= 3500;
                                isClaud = true;
                            }else {
                                playerArmor -= 6000;
                            }
                            if (playerArmor < 0){
                                playerDied = true;
                            }
                        } else {
                            playerCol = playerLeftCol;
                        }
                    } else {
                        playerRow = playerDownRow;
                    }
                } else {
                    playerCol = playerRightCol;
                }
            } else {
                playerRow = playerUpRow;
            }
        }
    }

    private static void spellSpread(int spellcoordRow, int spellcoordCol) {
        int coordRowDown = Math.min(spellcoordRow + 1, heiganChamber[0].length - 1);
        int coordRowUp = Math.max(spellcoordRow - 1, 0);
        int coordColRight = Math.min(spellcoordCol + 1, heiganChamber.length - 1);
        int coordColLeft = Math.max(spellcoordCol - 1, 0);
        heiganChamber[spellcoordRow][spellcoordCol] = 2;
        heiganChamber[spellcoordRow][coordColLeft] = 2;
        heiganChamber[spellcoordRow][coordColRight] = 2;
        heiganChamber[coordRowUp][spellcoordCol] = 2;
        heiganChamber[coordRowDown][spellcoordCol] = 2;
        heiganChamber[coordRowDown][coordColRight] = 2;
        heiganChamber[coordRowDown][coordColLeft] = 2;
        heiganChamber[coordRowUp][coordColLeft] = 2;
        heiganChamber[coordRowUp][coordColRight] = 2;
    }
}