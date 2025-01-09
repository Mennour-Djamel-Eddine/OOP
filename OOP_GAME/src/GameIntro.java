import java.io.IOException;

public class GameIntro {

    public static void displayIntro() throws InterruptedException {
        clearConsole();
        System.out.println("\n\n\n\n\n\n");
        System.out.println("");
        typeText(TerminalColors.YELLOW + "\t\t==================================================================================\n", 10);
        typeText(TerminalColors.CYAN + "\t\t                             Developed By: Mennour Djamel Eddine\n", 50);
        typeText(" \t\t                         WELCOME TO MY MINI-GAME PROGRAMMED IN JAVA\n", 50);
        typeText(TerminalColors.YELLOW+"\t\t==================================================================================\n" + TerminalColors.RESET, 10);
        Thread.sleep(100);
    }

    public static void displayMenu() throws InterruptedException {
        // Simulate typing effect for the game menu
        typeText(TerminalColors.BLUE +"=================================== GAME MENU: ===================================\n", 50);
        typeText("       [1] START SURVIVAL GAME\n", 50);
        typeText("       [2] HOW TO PLAY THE GAME (EXPLANATION)\n", 50);
        typeText("       [3] EXIT GAME\n", 50);
        typeText("===================================================================================\n" +TerminalColors.RESET, 10);
    }

    private static void typeText(String text, int delay) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delay);
        }
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error clearing the console.");
        }
    }
}
