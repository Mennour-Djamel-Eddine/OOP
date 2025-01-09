import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void typeText(String text, int delay) throws InterruptedException {
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

    private static void survivalMenu() throws InterruptedException, IOException {
        typeText(TerminalColors.BLUE
                + "============================= SURVIVAL MODE MENU: =============================\n", 30);
        typeText("\t[1] ADD YOUR CHAMPION\n", 30);
        typeText("\t[2] ADD CHAMPIONS (BOT)\n", 30);
        typeText("\t\t[2.1] ADD A MAGE\n", 30);
        typeText("\t\t[2.2] ADD A THIEF\n", 30);
        typeText("\t\t[2.3] ADD A WARRIOR\n", 30);
        typeText("\t[3] START GAME\n", 30);
        typeText("\t[4] EXIT SURVIVAL MODE\n", 30);
        typeText("===============================================================================\n"
                + TerminalColors.RESET, 30);
    }

    private static void survivalMenuWithoutAnimation() {
        System.out.println(TerminalColors.BLUE
                + "============================= SURVIVAL MODE MENU: =============================");
        System.out.println("\t[1] ADD YOUR CHAMPION");
        System.out.println("\t[2] ADD CHAMPIONS (BOT)");
        System.out.println("\t\t[2.1] ADD A MAGE");
        System.out.println("\t\t[2.2] ADD A THIEF");
        System.out.println("\t\t[2.3] ADD A WARRIOR");
        System.out.println("\t[3] START GAME");
        System.out.println("\t[4] EXIT SURVIVAL MODE");
        System.out.println("==============================================================================="
                + TerminalColors.RESET);
    }

    private static void updateCooldownCounter() {
        for (int i = 0; i < Champion.champList.size(); i++) {
            if (Champion.champList.get(i).getAbility1CoolDown() > 0) {
                int currentCooldown = Champion.champList.get(i).getAbility1CoolDown();
                Champion.champList.get(i).setAbility1CoolDown(currentCooldown - 1);

            }
            if (Champion.champList.get(i).getAbility2CoolDown() > 0) {
                int currentCooldown = Champion.champList.get(i).getAbility2CoolDown();
                Champion.champList.get(i).setAbility2CoolDown(currentCooldown - 1);

            }
            if (Champion.champList.get(i).getAbility3CoolDown() > 0) {
                int currentCooldown = Champion.champList.get(i).getAbility3CoolDown();
                Champion.champList.get(i).setAbility3CoolDown(currentCooldown - 1);
            }
        }
    }

    private static void updateAbilitiesDuration() {
        for (int i = 0; i < Champion.champList.size(); i++) {
            if (Champion.champList.get(i).getAbility1CurrentDuration() > 0) {
                int currentDuration = Champion.champList.get(i).getAbility1CurrentDuration();
                Champion.champList.get(i).setAbility1CurrentDuration(currentDuration - 1);

            }
            if (Champion.champList.get(i).getAbility2CurrentDuration() > 0) {
                int currentDuration = Champion.champList.get(i).getAbility2CurrentDuration();
                Champion.champList.get(i).setAbility2CurrentDuration(currentDuration - 1);

            }
            if (Champion.champList.get(i).getAbility3CurrentDuration() > 0) {
                int currentDuration = Champion.champList.get(i).getAbility3CurrentDuration();
                Champion.champList.get(i).setAbility3CurrentDuration(currentDuration - 1);
            } else if (Champion.champList.get(i).getAbility3CurrentDuration() == 0
                    && Champion.champList.get(i).getType().equals("Warrior")) {
                Champion.champList.get(i).setDamageTakenReduction(0);
            }
        }
    }

    private static void updateChampionsStatus() {
        for (int i = 0; i < Champion.champList.size(); i++) {
            if (Champion.champList.get(i).isAlive() == false) {
                // remove the champion from the Champions List
                Champion.champList.remove(i);
                i--;
            }
        }
    }

    private static void updateBlockedUntouched_Champs() {
        for (int i = 0; i < Champion.champList.size(); i++) {
            if (Champion.champList.get(i).getBlockedRoundsChamp() > 0) {
                int current = Champion.champList.get(i).getBlockedRoundsChamp();
                Champion.champList.get(i).setBlockedRoundsChamp(current - 1);
            }
            if (Champion.champList.get(i).getUntouchableRoundsChamp() > 0) {
                int current = Champion.champList.get(i).getUntouchableRoundsChamp();
                Champion.champList.get(i).setUntouchableRoundsChamp(current - 1);
            }
        }
    }

    private static void updateGameStatus() {
        updateCooldownCounter();
        updateAbilitiesDuration();
        updateChampionsStatus();
        updateBlockedUntouched_Champs();
    }

    public static int generateRandomGift(int increaseChanceRate, String field)
            throws InterruptedException, IOException {
        int min = 1;
        int max = 200;

        Random random = new Random();
        int number = random.nextInt(min, max);

        if (increaseChanceRate == 0) {
            if (number >= 1 && number <= 20) {
                typeText(TerminalColors.GREEN + "YOU'VE GOT A SHIELD OF 15 HP!\n" + TerminalColors.RESET, 30);
                return 1;
            } else if (number >= 21 && number >= 40) {
                typeText(TerminalColors.GREEN + "YOU'VE GOT A DOODGE!\n" + TerminalColors.RESET, 30);
                return 2;
            } else if (number >= 100 && number <= 114) {
                typeText(TerminalColors.GREEN + "YOU'VE GOT A LEVEL PROMOITON!\n" + TerminalColors.RESET, 30);
                return 3;
            } else if (number >= 150 && number <= 156) {
                typeText(TerminalColors.GREEN + "YOU'VE GOT A SECOND LIFE CHANCE! \nYOU WILL RESPOWN WITH 50% HP\n"
                        + TerminalColors.RESET, 30);
                return 4;
            } else {
                typeText(TerminalColors.BLUE + "YOU'VE GOT NOTHING THIS TURN! BETTER LUCK NEXT TIME.\n"
                        + TerminalColors.RESET, 30);
                return -1;
            }
        } else if (increaseChanceRate == 10) {
            if (field.equals("DOODGE")) {
                if (number >= 1 && number <= 20) {
                    typeText(TerminalColors.GREEN + "YOU'VE GOT A SHIELD OF 15 HP!\n" + TerminalColors.RESET, 30);
                    return 1;
                } else if (number >= 21 && number >= 60) {
                    typeText(TerminalColors.GREEN + "YOU'VE GOT A DOODGE!\n" + TerminalColors.RESET, 30);
                    return 2;
                } else if (number >= 100 && number <= 114) {
                    typeText(TerminalColors.GREEN + "YOU'VE GOT A LEVEL PROMOITON!\n" + TerminalColors.RESET, 30);
                    return 3;
                } else if (number >= 150 && number <= 156) {
                    typeText(TerminalColors.GREEN + "YOU'VE GOT A SECOND LIFE CHANCE! \nYOU WILL RESPOWN WITH 50% HP\n"
                            + TerminalColors.RESET, 30);
                    return 4;
                } else {
                    typeText(TerminalColors.BLUE + "YOU'VE GOT NOTHING THIS TURN! BETTER LUCK NEXT TIME."
                            + TerminalColors.RESET, 30);
                    return -1;
                }
            } else {
                System.out.println(
                        TerminalColors.RED + "YOU ARE NOT ALLOWED! ONLY THE THIEF WHO CAN INCREASE HIS DOODGE CHANCES!"
                                + TerminalColors.RESET);
            }
        }
        return 1;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        GameIntro.displayIntro();
        Thread.sleep(1000);
        int choice;
        int ID = 242400;
        int UserCharID = -1;
        int maxPlayers = 3;

        do {
            clearConsole();
            GameIntro.displayMenu();
            typeText("Enter Your Choice: ", 50);
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice <= 0 || choice > 4) {
                System.out.println(TerminalColors.RED + "INVALID INPUT. PLEASE TRY AGAIN!" + TerminalColors.RESET);
            }
        } while (choice <= 0 || choice > 4);

        switch (choice) {
            case 1:
                String choice_1;
                boolean userHasChamp = false;
                clearConsole();
                survivalMenu();

                do {
                    typeText("ENTER YOUR CHOICE: ", 50);
                    choice_1 = scanner.nextLine();

                    if (choice_1.equals("1")) {
                        if (userHasChamp == false) {
                            typeText(TerminalColors.BLUE + "\t[1] ADD A MAGE\n" + TerminalColors.RESET, 30);
                            typeText(TerminalColors.BLUE + "\t[2] ADD A THIEF\n" + TerminalColors.RESET, 30);
                            typeText(TerminalColors.BLUE + "\t[3] ADD A WARRIOR\n" + TerminalColors.RESET, 30);

                            typeText("ENTER YOUR CHOICE: ", 30);
                            int temp = scanner.nextInt();
                            scanner.nextLine();

                            if (temp == 1) {
                                typeText("ENTER YOUR CHAMPION NAME: ", 30);
                                String name = scanner.nextLine();

                                UserCharID = ID;
                                Mage.addChamp(name, ID);
                                ID++;
                                userHasChamp = true;
                                typeText(TerminalColors.GREEN + "CHAMPION ADDED SUCCESSFULLY!\n" + TerminalColors.RESET,
                                        30);
                                Thread.sleep(1000);
                            } else if (temp == 2) {
                                typeText("ENTER YOUR CHAMPION NAME: ", 30);
                                String name = scanner.nextLine();

                                UserCharID = ID;
                                Thief.addChamp(name, ID);
                                ID++;
                                userHasChamp = true;
                                typeText("CHAMPION ADDED SUCCESSFULLY!", 30);
                                Thread.sleep(1000);
                            } else if (temp == 3) {
                                typeText("ENTER YOUR CHAMPION NAME: ", 30);
                                String name = scanner.nextLine();

                                UserCharID = ID;
                                Warrior.addChamp(name, ID);
                                ID++;
                                userHasChamp = true;
                                typeText(TerminalColors.GREEN + "CHAMPION ADDED SUCCESSFULLY!" + TerminalColors.RESET,
                                        30);
                                Thread.sleep(1000);
                            }
                        } else {
                            typeText(
                                    TerminalColors.RED + "YOU HAVE SELECTED A CHAMPION ALREADY!" + TerminalColors.RESET,
                                    30);
                            Thread.sleep(2000);
                        }
                    } else if (maxPlayers != 0) {
                        if (choice_1.equals("2.1")) {
                            String name;
                            typeText("ENTER CHAMPION NAME: ", 50);
                            name = scanner.nextLine();
    
                            Mage.addChamp(name, ID);
                            ID++;
                            maxPlayers --;
                            typeText(TerminalColors.GREEN + "CHAMPION ADDED SUCCESSFULLY!" + TerminalColors.RESET, 30);
                            Thread.sleep(1000);
                        } else if (choice_1.equals("2.2")) {
                            String name;
                            typeText("ENTER CHAMPION NAME: ", 50);
    
                            name = scanner.nextLine();
    
                            Thief.addChamp(name, ID);
                            ID++;
                            maxPlayers --;
                            typeText(TerminalColors.GREEN + "CHAMPION ADDED SUCCESSFULLY!" + TerminalColors.RESET, 30);
                            Thread.sleep(1000);
                        } else if (choice_1.equals("2.3")) {
                            String name;
                            typeText("ENTER CHAMPION NAME: ", 50);
                            name = scanner.nextLine();
    
                            Warrior.addChamp(name, ID);
                            ID++;
                            maxPlayers --;
                            typeText(TerminalColors.GREEN + "CHAMPION ADDED SUCCESSFULLY!" + TerminalColors.RESET, 30);
                            Thread.sleep(1000);
                        }
                    } else if (maxPlayers == 0){
                        typeText(TerminalColors.RED + "YOU CANNOT ADD MORE THAN 3 BOTS! \n"+ TerminalColors.RESET, 30);
                        Thread.sleep(1000);
                    }
                    clearConsole();
                    survivalMenuWithoutAnimation();
                } while (!choice_1.equals("3") && !choice_1.equals("4"));

                if (choice_1.equals("3")) {
                    // Start the game
                    int round = 0;
                    int UserCharIndex = Champion.searchChamp(UserCharID);

                    if (UserCharIndex != -1) {
                        // ! START GAME
                        do {
                            if (round != 0) {
                                updateGameStatus();
                            }
                            clearConsole();
                            typeText("=============================== Round " + round
                                    + ": ==============================\n", 30);
                            System.out.println("");
                            for (int i = 0; i < Champion.champList.size(); i++) {
                                clearConsole();
                                System.out.println("=============================== Round " + round
                                        + ": ==============================\n");
                                System.out.println("");
                                if (Champion.champList.get(i).getBlockedRoundsChamp() > 0) {
                                    typeText(Champion.champList.get(i).getName() + TerminalColors.RED
                                            + " IS BLOCKED THIS ROUND! \n" + TerminalColors.RESET, i);
                                } else {
                                    if (Champion.champList.size() == 4) {
                                        displayChampions.displayChampions_4(Champion.champList.get(0),
                                                Champion.champList.get(1), Champion.champList.get(2),
                                                Champion.champList.get(3));
                                    } else if (Champion.champList.size() == 3) {
                                        displayChampions.displayChampions_3(Champion.champList.get(0),
                                                Champion.champList.get(1), Champion.champList.get(2));
                                    } else if (Champion.champList.size() == 2) {
                                        displayChampions.displayChampions_2(Champion.champList.get(0),
                                                Champion.champList.get(1));
                                    }

                                    typeText("" + Champion.champList.get(i).getName() + " TURN\n", 30);

                                    if (round % 2 == 0) {
                                        int temp = generateRandomGift(0, "");
                                        if (temp == 1) {
                                            int current = Champion.champList.get(i).getHP();
                                            Champion.champList.get(i).setHP(current + 15);
                                        } else if (temp == 2) {
                                            Champion.champList.get(i).setUntouchableRoundsChamp(1);
                                        } else if (temp == 3) {
                                            int current = Champion.champList.get(i).getLevel();
                                            Champion.champList.get(i).setLevel(current + 1);
                                        }
                                    }
                                    if (i == UserCharIndex) {
                                        // Player (Not Bot)
                                        switch (Champion.champList.get(i).getType()) {
                                            case "Mage":
                                                String temp;
                                                do {
                                                    Mage.displayMenu();
                                                    typeText("ENTER YOUR CHOICE: ", 30);
                                                    temp = scanner.nextLine();
                                                    if (temp.equals("1")) {
                                                        int index;
                                                        do {
                                                            String targetName;
                                                            typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                            targetName = scanner.nextLine();
                                                            index = Champion.searchChamp(targetName);
                                                            if (index == -1) {
                                                                typeText(TerminalColors.RED
                                                                        + "INVLALID NAME! PLEASE TRY AGAIN."
                                                                        + TerminalColors.RESET, index);
                                                            }
                                                        } while (index == -1);
                                                        Champion.champList.get(UserCharIndex)
                                                                .attackChamp(Champion.champList.get(index), 0);
                                                        typeText(Champion.champList.get(UserCharIndex).getName()
                                                                + TerminalColors.RED + " ATTACKED "
                                                                + TerminalColors.RESET
                                                                + Champion.champList.get(index).getName()
                                                                + "\n", 30);
                                                    } else if (temp.equals("2.1")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility1CoolDown() == 0) {
                                                            int index;
                                                            do {
                                                                String targetName;
                                                                typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                                targetName = scanner.nextLine();
                                                                index = Champion.searchChamp(targetName);
                                                                if (index == -1) {
                                                                    typeText(TerminalColors.RED
                                                                            + "INVLALIDE NAME! PLEASE TRY AGAIN."
                                                                            + TerminalColors.RESET,
                                                                            index);
                                                                }
                                                            } while (index == -1);
                                                            Champion.champList.get(UserCharIndex).useChampAbilities(
                                                                    Champion.champList.get(index), 1);

                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                    + Champion.champList.get(UserCharIndex)
                                                                            .getAbility1CoolDown()
                                                                    + " MORE TURNS! \n" + TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("2.2")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility2CoolDown() == 0
                                                                || Champion.champList.get(UserCharID)
                                                                        .getAbility2Duration() > 0) {
                                                            Champion.champList.get(UserCharIndex).useChampAbilities(2);
                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                    + Champion.champList.get(UserCharIndex)
                                                                            .getAbility2CoolDown()
                                                                    + " MORE TURNS! \n" + TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("2.3")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility3CoolDown() == 0) {
                                                            Champion.champList.get(UserCharIndex).useChampAbilities(3);
                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                    + Champion.champList.get(UserCharIndex)
                                                                            .getAbility3CoolDown()
                                                                    + " MORE TURNS! \n" + TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("3")) {
                                                        Mage.explainAbilities();
                                                    }
                                                } while (temp.equals("3"));
                                                break;
                                            case "Warrior":
                                                do {
                                                    Warrior.displayMenu();
                                                    typeText("ENTER YOUR CHOICE: ", 30);
                                                    temp = scanner.nextLine();
                                                    if (temp.equals("1")) {
                                                        int index;
                                                        do {
                                                            String targetName;
                                                            typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                            targetName = scanner.nextLine();
                                                            index = Champion.searchChamp(targetName);
                                                            if (index == -1) {
                                                                typeText(TerminalColors.RED
                                                                        + "INVALID NAME! PLEASE TRY AGAIN."
                                                                        + TerminalColors.RESET, index);
                                                            }
                                                        } while (index == -1);
                                                        Champion.champList.get(UserCharIndex)
                                                                .attackChamp(Champion.champList.get(index), 0);
                                                    } else if (temp.equals("2.1")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility1CoolDown() == 0) {
                                                            int index;
                                                            do {
                                                                String targetName;
                                                                typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                                targetName = scanner.nextLine();
                                                                index = Champion.searchChamp(targetName);
                                                                if (index == -1) {
                                                                    typeText(TerminalColors.RED
                                                                            + "INVALID NAME! PLEASE TRY AGAIN."
                                                                            + TerminalColors.RESET, index);
                                                                }
                                                            } while (index == -1);
                                                            Champion.champList.get(UserCharIndex).useChampAbilities(
                                                                    Champion.champList.get(index), 1);

                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                    + Champion.champList.get(UserCharIndex)
                                                                            .getAbility1CoolDown()
                                                                    + " MORE TURNS! \n" + TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("2.2")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility2CoolDown() == 0
                                                                || Champion.champList.get(UserCharID)
                                                                        .getAbility2Duration() > 0) {
                                                            int index;
                                                            do {
                                                                String targetName;
                                                                typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                                targetName = scanner.nextLine();
                                                                index = Champion.searchChamp(targetName);
                                                                if (index == -1) {
                                                                    typeText(TerminalColors.RED
                                                                            + "INVALID NAME! PLEASE TRY AGAIN."
                                                                            + TerminalColors.RESET, index);
                                                                }
                                                            } while (index == -1);
                                                            Champion.champList.get(UserCharIndex).useChampAbilities(
                                                                    Champion.champList.get(index), 2);
                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                            + Champion.champList.get(UserCharIndex)
                                                                                    .getAbility2CoolDown()
                                                                            + " MORE TURNS! \n" + TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("2.3")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility3CoolDown() == 0) {
                                                            Champion.champList.get(UserCharIndex).useChampAbilities(3);
                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                            + Champion.champList.get(UserCharIndex)
                                                                                    .getAbility3CoolDown()
                                                                            + " MORE TURNS! \n"+ TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("3")) {
                                                        Warrior.explainAbilities();
                                                    }
                                                } while (temp.equals("3"));
                                                break;
                                            case "Thief":
                                                do {
                                                    Thief.displayMenu();
                                                    typeText("ENTER YOUR CHOICE: ", 30);
                                                    temp = scanner.nextLine();
                                                    if (temp.equals("1")) {
                                                        int index;
                                                        do {
                                                            String targetName;
                                                            typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                            targetName = scanner.nextLine();
                                                            index = Champion.searchChamp(targetName);
                                                            if (index == -1) {
                                                                typeText(TerminalColors.RED +"INVALID NAME! PLEASE TRY AGAIN!"+ TerminalColors.RESET, index);
                                                            }
                                                        } while (index == -1);
                                                        Champion.champList.get(UserCharIndex)
                                                                .attackChamp(Champion.champList.get(index), 0);
                                                    } else if (temp.equals("2.1")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility1CoolDown() == 0
                                                                || Champion.champList.get(UserCharID)
                                                                        .getAbility1Duration() > 0) {
                                                            int index;
                                                            do {
                                                                String targetName;
                                                                typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                                targetName = scanner.nextLine();
                                                                index = Champion.searchChamp(targetName);
                                                                if (index == -1) {
                                                                    typeText(TerminalColors.RED +"INVALID NAME! PLEASE TRY AGAIN." + TerminalColors.RESET, index);
                                                                }
                                                            } while (index == -1);

                                                            Champion.champList.get(UserCharIndex).useChampAbilities(
                                                                    Champion.champList.get(index), 1);
                                                            typeText(Champion.champList.get(UserCharIndex).getName()
                                                                    +TerminalColors.GREEN + " GETS AN ABSORB SHIELD FOR THE NEXT " + TerminalColors.RESET
                                                                    + Champion.champList.get(UserCharIndex)
                                                                            .getAbility1CurrentDuration()
                                                                    + " TURNS \n", 30);

                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                            + Champion.champList.get(UserCharIndex)
                                                                                    .getAbility1CoolDown()
                                                                            + " MORE TURNS! \n" + TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("2.2")) {
                                                        Champion.champList.get(UserCharIndex).useChampAbilities(2);
                                                    } else if (temp.equals("2.3")) {
                                                        if (Champion.champList.get(UserCharIndex)
                                                                .getAbility3CoolDown() == 0
                                                                || Champion.champList.get(UserCharID)
                                                                        .getAbility3Duration() > 0) {
                                                            int index;
                                                            do {
                                                                String targetName;
                                                                typeText("ENTER THE NAME OF THE TARGET: ", 30);
                                                                targetName = scanner.nextLine();
                                                                index = Champion.searchChamp(targetName);
                                                                if (index == -1) {
                                                                    typeText(TerminalColors.RED +"INVALID NAME! PLEASE TRY AGAIN." + TerminalColors.RESET, index);
                                                                }
                                                            } while (index == -1);

                                                            Champion.champList.get(UserCharIndex).useChampAbilities(
                                                                    Champion.champList.get(index), 3);

                                                        } else {
                                                            typeText(TerminalColors.RED +
                                                                    "ABILITY ON COOLDOWN. YOU HAS TO WAIT "
                                                                            + Champion.champList.get(UserCharIndex)
                                                                                    .getAbility1CoolDown()
                                                                            + " MORE TURNS! \n" + TerminalColors.RESET,
                                                                    30);
                                                        }
                                                    } else if (temp.equals("3")) {
                                                        Mage.explainAbilities();
                                                    }
                                                } while (temp.equals("3"));
                                                break;
                                            default:
                                                typeText(TerminalColors.RED + "INVALID CHOICE PLEASE TRY AGAIN! \n" + TerminalColors.RESET, 30);
                                                break;
                                        }
                                    }
                                    // Bot turn
                                    else {
                                        // Simple AI logic to control BOTs
                                        Champion.champList.get(i).takeAction();
                                    }
                                    Thread.sleep(3000);
                                }

                            }
                            round++;
                            Thread.sleep(3000); // 3 seconds sleep
                        } while (Champion.champList.get(UserCharIndex).isAlive() == true);
                    }
                }
                break;
            case 2:

                break;
            case 3:
                typeText("YOU'VE EXIT THE GAME! SEE YOU NEXT TIME", 50);
                System.out.println("");
                Thread.sleep(50);
                break;
            default:
                typeText(TerminalColors.RED + "INVALID CHOICE! PLEASE TRY AGAIN.\n" + TerminalColors.RESET, 50);
                break;
        }

        scanner.close();
    }
}
