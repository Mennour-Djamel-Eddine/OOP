import java.io.IOException;

public class Thief extends Champion {

    private static int damage = 19;
    private static int hp = 90;

    public Thief(String name, int type) {
        super(90, name, 19, type, 38, 0, 10, 3, 4, 4, 2, 3, 2, "Thief");
    }

    public static void addChamp(String name, int ID) {
        Champion.champList.add(new Thief(name, ID));
    }

    @Override
    public void attackChamp(Champion target, int ability) {
        if (ability == 0) {
            try {
                Main.typeText(this.getName() + TerminalColors.RED + " ATTACKED " + TerminalColors.RESET + target.getName(), 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (ability == 1) {
            try {
                Main.typeText(this.getName() + TerminalColors.RED + " ATTACKED " + TerminalColors.RESET  + target.getName() + TerminalColors.RED+ " USING BACK STAB" + TerminalColors.RESET, 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (ability == 3) {
            try {
                Main.typeText(this.getName() + TerminalColors.RED + " ATTACKED "+ TerminalColors.RESET + target.getName() + TerminalColors.RED + " USING STEAL" + TerminalColors.RESET, 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (target.getUntouchableRoundsChamp() == 0) {
            if (target.getDamageTakenReduction() > 0) {
                int temp = this.getDamage() * target.getDamageTakenReduction() / 100;
                this.setDamage(temp);
                this.takeDamage(this.getDamage());
                this.setDamage(damage);
                System.out.println(target.getName() + " HAS A DAMAGE REDUCTION OF " + target.getDamageTakenReduction() + "%!");
            } else {
                target.takeDamage(this.getDamage());
            }

        } else if (target.getUntouchableRoundsChamp() > 0) {
            System.out.println(target.getName() + " HAS AN ABSROBENT SHIELD or DOODGE! ");
        }
    }

    public void useChampAbilities(Champion target, int choice) {
        if (target.getUntouchableRoundsChamp() == 0) {
            if (choice == 1) {
                int meduimHP = hp * 50 / 100;
                if (target.getHP() <= meduimHP) {
                    // IF the thief uses any ability it doubles the damage by 2;
                    int currentDamage = 2 * damage;
                    this.setDamage(currentDamage);
                    this.attackChamp(target, 1);
                    this.setDamage(damage);
                    this.setAbility1CoolDown(this.getAbility1DefaultCoolDown());
                    this.setAbility1CurrentDuration(1);
                } else {
                    this.attackChamp(target, 1);
                }
            } else if (choice == 3) {
                int stealHP = 10;
                this.setDamage(stealHP);
                this.attackChamp(target, 3);
                this.setDamage(damage);
                int currentChampHP = this.getHP();
                this.setHP(currentChampHP + stealHP);
                this.setAbility3CoolDown(this.getAbility3DefaultCoolDown());
                this.setAbility3CurrentDuration(1);
            }
        }
    }

    public void useChampAbilities(int choice) {
        if (choice == 2) {
            // Increase the chance of getting a doodge in the next 2 rounds
            try {
                Main.generateRandomGift(10, "DOODGE");
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            this.setAbility2CoolDown(this.getAbility2DefaultCoolDown());
            this.setAbility1CurrentDuration(2);
            System.out.println(this.getName() + " INCREASES HIS CHANCE TO GET A DOODGE USING EVADE!");
        }
    }

    public int canFinishCahmp() {
        for (int i = 0; i < champList.size(); i++) {
            if (champList.get(i).getID() != this.getID()) {
                if (this.getAbility1CoolDown() == 0 || this.getAbility1CurrentDuration() > 0) {
                    if (this.getAbility1Damage() >= champList.get(i).getHP()) {
                        return i;
                    }
                } else if (this.getAbility2CoolDown() == 0 || this.getAbility2CurrentDuration() > 0) {
                    if (this.getAbility2Damage() >= champList.get(i).getHP()) {
                        return i;
                    }
                } else if (this.getAbility3CoolDown() == 0 || this.getAbility3CurrentDuration() > 0) {
                    if (this.getAbility3Damage() >= champList.get(i).getHP()) {
                        return i;
                    }
                } else if (this.getDamage() >= champList.get(i).getHP()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void finishChamp(int champIndex) {
        if (champIndex != -1) {
            if (this.getAbility1Damage() > champList.get(champIndex).getHP()) {
                if (this.getAbility1CoolDown() == 0) {
                    useChampAbilities(champList.get(champIndex), 1);
                }
            } else if (this.getAbility2Damage() > champList.get(champIndex).getHP()) {
                if (this.getAbility2CoolDown() == 0) {
                    useChampAbilities(2);
                }
            } else if (this.getAbility3Damage() > champList.get(champIndex).getHP()) {
                if (this.getAbility3CoolDown() == 0) {
                    useChampAbilities(champList.get(champIndex), 3);
                }
            }
        }
    }

    public void attackLowHp() {
        int minHPIndex = -1;
        for (int i = 0; i < champList.size(); i++) {
            if (champList.get(i).getID() != this.getID()) {
                if (minHPIndex == -1 || champList.get(i).getHP() < champList.get(minHPIndex).getHP()) {
                    minHPIndex = i;
                }
            }
        }
        if (this.getAbility1CoolDown() == 0) {
            Champion target = Champion.champList.get(minHPIndex);
            this.useChampAbilities(target, 1);
        } else if (this.getAbility3CoolDown() == 0) {
            Champion target = Champion.champList.get(minHPIndex);
            this.useChampAbilities(target, 3);
        } else {
            attackChamp(champList.get(minHPIndex), 0);
        }
    }

    @Override
    public void takeAction() {
        int meduimHP = hp * 50 / 100;
        if (this.getHP() > meduimHP) {
            // Finish champ
            int champIndex = canFinishCahmp();
            if (champIndex != -1) {
                finishChamp(champIndex);
            }
            // Attacking the lowest HP champion
            else {
                attackLowHp();
            }
        } else {
            if (this.getAbility3CoolDown() == 0) {
                this.useChampAbilities(3);
            } else if (this.getAbility2CoolDown() == 0) {
                this.useChampAbilities(2);
            } else {
                // Finish champ
                int champIndex = canFinishCahmp();
                if (champIndex != -1) {
                    finishChamp(champIndex);
                }
                // Attacking the lowest HP champion
                else {
                    attackLowHp();
                }
            }
        }
    }

    public static void displayMenu() {
        System.out.println("[1] ATTACK CHAMPION");
        System.out.println("[2] USE ABILITY ON A CHAMPION");
        System.out.println("\t[2.1] BACK STAB");
        System.out.println("\t[2.2] EVADE");
        System.out.println("\t[2.3] STEAL");
        System.out.println("[3] HELP (ABILITIES EXPLANATION)");
    }

    public static void explainAbilities() {
        System.out.println("==================================== HELP MENU ====================================");
        System.out.println("[1] BACK STAB: ");
        System.out.println("DEALS DOUBLE DAMAGE IF THE TARGET IS BELOW 50% HP");
        System.out.println("COOLDOWN: 2 TURNS | DURATION: 1 TURN");
        System.out.println("[2] EVADE: ");
        System.out.println("INCREASES THE CHANCE OF GETTING A DOODGE FOR THE NEXT 2 TURNS");
        System.out.println("COOLDOWN: 4 TURNS | DURATION: 2 TURNS");
        System.out.println("[3] STEAL: ");
        System.out.println("STEAL 10 HP FROM THE TARGET");
        System.out.println("COOLDOWN: 3 TURNS | DURATION: 1 TURNS");
        System.out.println("==================================================================================");
    }
}
