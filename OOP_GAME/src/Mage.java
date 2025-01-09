
public class Mage extends Champion {

    private static int damage = 25;
    private static int hp = 70;

    public Mage(String name, int ID) {
        super(70, name, 25, ID, 35, 0, 0, 2, 3, 3, 1, 2, 1, "Mage");
    }

    public static void addChamp(String name, int ID) {
        Champion.champList.add(new Mage(name, ID));
    }

    @Override
    public void attackChamp(Champion target, int ability) {
        if (ability == 0) {
            try {
                Main.typeText(this.getName() + TerminalColors.RED+ " ATTACKED " + TerminalColors.RESET + target.getName(), 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (ability == 1) {
            try {
                Main.typeText(this.getName() + TerminalColors.RED+ " ATTACKED " + TerminalColors.RESET + target.getName() + TerminalColors.RED+ " USING FIREBALL! \n" + TerminalColors.RESET,30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (target.getUntouchableRoundsChamp() == 0) {
            if (target.getDamageTakenReduction() > 0) {
                int temp = this.getDamage() * target.getDamageTakenReduction() / 100;
                this.setDamage(temp);
                target.takeDamage(this.getDamage());
                this.setDamage(damage);
                try {
                    Main.typeText(target.getName() + TerminalColors.RED + " HAS A DAMAGE REDUCTION OF " + TerminalColors.RESET+target.getDamageTakenReduction() + "%!", 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                target.takeDamage(this.getDamage());
            }
        } else if (target.getUntouchableRoundsChamp() > 0) {
            try {
                Main.typeText(target.getName() + TerminalColors.RED+" HAS AN ABSROBENT SHIELD or DOODGE! " + TerminalColors.RESET, 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void useChampAbilities(Champion target, int choice) {
        if (target.getUntouchableRoundsChamp() == 0) {
            // FireBall: Ability that deals high damage to a single target
            if (choice == 1) {
                int totalDamage = damage + 10;
                this.setDamage(totalDamage);
                this.attackChamp(target, 1);
                this.setDamage(damage);
                // Restart cooldown counter to the default one
                this.setAbility1CoolDown(this.getAbility1DefaultCoolDown());
                this.setAbility1CurrentDuration(1);
            }
        }
    }

    @Override
    public void useChampAbilities(int choice) {
        // Mage shield: Ability that grants the mage a shield that absorbs damage for 2
        // turns
        if (choice == 2) {
            this.setUntouchableRoundsChamp(2);
            this.setAbility2CoolDown(this.getAbility2DefaultCoolDown());
            this.setAbility2CurrentDuration(2);
            System.out.println(this.getName() + " GETS AN ABSORBANT SHIELD USING MAGE SHIELD!");
        }
        // Heal: Ability that gains the champ 20HP and his allies
        else {
            int CurrentHp = this.getHP();
            this.setHP(CurrentHp + 20);
            this.setAbility3CoolDown(this.getAbility3DefaultCoolDown());
            this.setAbility3CurrentDuration(1);
            System.out.println(this.getName() + " GETS +20 HP USING HEAL!");
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
            } else {
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
                } else {
                    attackLowHp();
                }
            }
        }
    }

    public static void displayMenu() {
        System.out.println("[1] ATTACK CHAMPION");
        System.out.println("[2] USE ABILITY ON A CHAMPION");
        System.out.println("\t[2.1] FIREBALL");
        System.out.println("\t[2.2] MAGE SHIELD");
        System.out.println("\t[2.3] HEAL");
        System.out.println("[3] HELP(ABILITIES EXPLANATION)");
    }

    public static void explainAbilities() {
        System.out.println("==================================== HELP MENU ====================================");
        System.out.println("[1] FIREBALL: ");
        System.out.println("THE FIREBALL ABILITY IS AN ABILITY THAT DEALS HIGH DAMAGE TO A SINGLE TARGET");
        System.out.println("COOLDOWN: 2 TURNS | DURATION: 1 TURN");
        System.out.println("[2] MAGE SHIELD: ");
        System.out.println("THIS ABILITY GRANT THE MAGE A SHIELD THAT ABSORBS THE DAMAGE WITH 100%");
        System.out.println("COOLDOWN: 3 TURNS | DURATION: 2 TURN");
        System.out.println("[3] HEAL: ");
        System.out.println("THIS ABILITY GAINS THE MAGE AND A NEARBY ALLY 20HP");
        System.out.println("COOLDOWN: 3 TURNS | DURATION: 1 TURN");
        System.out.println("===================================================================================");
    }
}
