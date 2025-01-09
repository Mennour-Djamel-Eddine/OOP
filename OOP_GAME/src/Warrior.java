public class Warrior extends Champion {

   private static int damage = 14;
   private static int hp = 120;

   public Warrior(String name, int ID) {
      super(120, name, 14, ID, 0, 24,
       0, 4, 
       5, 5,
        1, 2, 
        2, "Warrior");
   }

   public static void addChamp(String name, int ID) {
      Champion.champList.add(new Warrior(name, ID));
   }

   @Override
   public void attackChamp(Champion target, int ability) {
      if (ability == 0) {
         try {
            Main.typeText(this.getName() + TerminalColors.RED +" ATTACKED " + target.getName() + TerminalColors.RESET, 30);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      } else if (ability == 1) {
         try {
            Main.typeText(this.getName() + TerminalColors.RED +" ATTACKED " + TerminalColors.RESET + target.getName() + TerminalColors.RED+ " USING SHIELD BASH!\n" + TerminalColors.RESET, 30);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      } else if (ability == 2) {
         try {
            Main.typeText(this.getName() + TerminalColors.RED +" ATTACKED "+ TerminalColors.RESET + target.getName() + TerminalColors.RED + "USING BATTLE CRY!\n" + TerminalColors.RESET, 30);
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
            System.out.println(target.getName() + " HAS A DAMAGE REDUCTION OF " + target.getDamageTakenReduction() + "%!");
         } else {
            target.takeDamage(this.getDamage());
         }
      } else if (target.getUntouchableRoundsChamp() > 0) {
         System.out.println(target.getName() + " HAS AN ABSROBENT SHIELD or DOODGE! ");
      }
   }

   @Override
   public void useChampAbilities(Champion target, int choice) {
      if (target.getUntouchableRoundsChamp() == 0) {
         if (choice == 1) { // Shield Bash: Moderate damage + Stun
            int abilityDamage = this.getDamage() * 75 / 100;
            this.setDamage(abilityDamage);
            attackChamp(target, 1);
            target.setBlockedRoundsChamp(1); // Stuns the target
            this.setDamage(damage); // Reset damage to default
            this.setAbility1CoolDown(this.getAbility1DefaultCoolDown());
            this.setAbility1CurrentDuration(1);

            System.out.println(this.getName() + " STUNS " + target.getName());
         } else if (choice == 2) { // Battle Cry: Increases damage temporarily
            this.setDamage(damage + 10);
            attackChamp(target, 2);
            this.setAbility2CurrentDuration(2);
            if (this.getAbility2CurrentDuration() == 0) {
               System.out.println(this.getAbility2CurrentDuration());
               this.setDamage(damage); // Reset damage to default   
            }
            this.setAbility2CoolDown(this.getAbility2DefaultCoolDown());
         }
      }
   }

   @Override
   public void useChampAbilities(int choice) {
      if (choice == 3) { // Fortify: Reduces damage taken
         this.setDamageTakenReduction(50); // 50% damage reduction
         this.setAbility3CoolDown(this.getAbility3DefaultCoolDown());
         this.setAbility3CurrentDuration(2);
      }
   }

   public int canFinishChamp() {
      for (int i = 0; i < champList.size(); i++) {
         Champion target = champList.get(i);
         if (target.getID() != this.getID()) {
            if (this.getAbility1CoolDown() == 0 && this.getAbility1CurrentDuration() <= 0
                  && this.getAbility1Damage() >= target.getHP()) {
               return i;
            } else if (this.getAbility2CoolDown() == 0 && this.getAbility2CurrentDuration() <= 0
                  && this.getAbility2Damage() >= target.getHP()) {
               return i;
            } else if (this.getAbility3CoolDown() == 0 && this.getAbility3CurrentDuration() <= 0
                  && this.getAbility3Damage() >= target.getHP()) {
               return i;
            } else if (this.getDamage() >= target.getHP()) {
               return i;
            }
         }
      }
      return -1;
   }

   public void finishChamp(int champIndex) {
      if (champIndex != -1) {
         Champion target = champList.get(champIndex);
         if (this.getAbility1Damage() > target.getHP() && this.getAbility1CoolDown() == 0) {
            useChampAbilities(target, 1);
         } else if (this.getAbility2Damage() > target.getHP() && this.getAbility2CoolDown() == 0) {
            useChampAbilities(target, 2);
         } else if (this.getAbility3Damage() > target.getHP() && this.getAbility3CoolDown() == 0) {
            useChampAbilities(3);
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
      } else if (this.getAbility2CoolDown() == 0) {
         Champion target = Champion.champList.get(minHPIndex);
         this.useChampAbilities(target, 2);
      } else {
         attackChamp(champList.get(minHPIndex), 0);
      }
   }

   @Override
   public void takeAction() {
      int mediumHP = hp * 50 / 100;
      if (this.getHP() > mediumHP) {
         int champIndex = canFinishChamp();
         if (champIndex != -1) {
            finishChamp(champIndex);
         } else {
            System.out.println("");
            attackLowHp();
         }
      } else if (this.getAbility3CoolDown() == 0) {
         useChampAbilities(3);
      } else {
         int champIndex = canFinishChamp();
         if (champIndex != -1) {
            finishChamp(champIndex);
         } else {
            System.out.println("");
            attackLowHp();
         }
      }
   }

   public static void displayMenu() {
      System.out.println("[1] ATTACK CHAMPION");
      System.out.println("[2] USE ABILITY ON A CHAMPION");
      System.out.println("\t[2.1] SHIELD BASH");
      System.out.println("\t[2.2] BATTLE CRY");
      System.out.println("\t[2.3] FORTIFY");
      System.out.println("[3] HELP (ABILITIES EXPLANATION)");
   }

   public static void explainAbilities() {
      System.out.println("==================================== HELP MENU ====================================");
      System.out.println("[1] SHIELD BASH: ");
      System.out.println("THIS ABILITY DEALS MODERATE DAMAGE AND STUNS THE TARGET FOR 1 ROUND");
      System.out.println("COOLDOWN: 3 TURNS | DURATION: 1 TURN");
      System.out.println("[2] BATTLE CRY: ");
      System.out.println("INCREASES THE WARRIOR'S ATTACK DAMAGE BY 10 FOR THE NEXT 2 ROUNDS");
      System.out.println("COOLDOWN: 4 TURNS | DURATION: 2 TURNS");
      System.out.println("[3] FORTIFY: ");
      System.out.println("REDUCES DAMAGE TAKEN BY 50% FOR THE NEXT 2 ROUNDS");
      System.out.println("COOLDOWN: 4 TURNS | DURATION: 2 TURNS");
      System.out.println("==================================================================================");
   }
}
