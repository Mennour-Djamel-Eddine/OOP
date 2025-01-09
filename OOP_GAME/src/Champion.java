import java.util.ArrayList;

public abstract class Champion {
    private int HP;
    private String name;
    private int damage;
    private int level;
    private int exp;
    private int ID;
    private final String type;

    private int ability1Damage;
    private int ability1CoolDown;
    private int ability1DefaultCoolDown;
    private int ability1Duration;
    private int ability1CurrentDuration;

    private int ability2Damage;
    private int ability2DefaultCoolDown;
    private int ability2CoolDown;
    private int ability2Duration;
    private int ability2CurrentDuration;

    private int ability3Damage;
    private int ability3DefaultCoolDown;
    private int ability3CoolDown;
    private int ability3Duration;
    private int ability3CurrentDuration;

    private int blockedRoundsChamp; // if an enemy champ uses a stone ability, the current champ will be blocked for n rounds
    private int untouchableRoundsChamp; // if the champ uses an obserb shield or doodge, he'll be untouchable for n rounds

    private int damageTakenReduction;

    public static ArrayList <Champion> champList = new ArrayList<>();

    // Constructor
    public Champion(int hp, String name, int damage, int ID, int ability1Damage, int ability2Damage,
         int ability3Damage, int ability1DefaultCoolDown, int ability2DefaultCoolDown, int ability3DefaultCoolDown,
         int ability1Duration, int ability2Duration, int ability3Duration, String type) {
        
        this.HP = hp;
        this.name = name;
        this.damage = damage;
        this.level = 0;
        this.exp = 0;
        this.ID = ID;

        this.ability1Damage = ability1Damage;
        this.ability2Damage = ability2Damage;
        this.ability3Damage = ability3Damage;

        this.ability1DefaultCoolDown = ability1DefaultCoolDown;
        this.ability2DefaultCoolDown = ability2DefaultCoolDown;
        this.ability3DefaultCoolDown = ability3DefaultCoolDown;

        this.ability1CoolDown = 0;
        this.ability2CoolDown = 0;
        this.ability3CoolDown = 0;

        this.ability1Duration = ability1Duration;
        this.ability2Duration = ability2Duration;
        this.ability3Duration = ability3Duration;

        this.ability1CurrentDuration = 0;
        this.ability2CurrentDuration = 0;
        this.ability3CurrentDuration = 0;

        this.blockedRoundsChamp = 0;
        this.untouchableRoundsChamp = 0;

        this.type = type;

        this.damageTakenReduction = 0;
    }
    // Getters and Setters
    public int getHP() {
        return HP;
    }
    public void setHP(int hp) {
        HP = hp;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getID() {
        return this.ID;
    }
    public int getAbility1Damage() {
        return ability1Damage;
    }
    public int getAbility2Damage() {
        return ability2Damage;
    }
    public int getAbility3Damage() {
        return ability3Damage;
    }
    public int getAbility1CoolDown() {
        return ability1CoolDown;
    }
    public int getAbility1DefaultCoolDown() {
        return ability1DefaultCoolDown;
    }
    public int getAbility2DefaultCoolDown() {
        return ability2DefaultCoolDown;
    }
    public int getAbility2CoolDown() {
        return ability2CoolDown;
    }
    public int getAbility3DefaultCoolDown() {
        return ability3DefaultCoolDown;
    }
    public int getAbility3CoolDown() {
        return ability3CoolDown;
    }
    public void setAbility1CoolDown(int ability1CoolDown) {
        this.ability1CoolDown = ability1CoolDown;
    }
    public void setAbility2CoolDown(int ability2CoolDown) {
        this.ability2CoolDown = ability2CoolDown;
    }
    public void setAbility3CoolDown(int ability3CoolDown) {
        this.ability3CoolDown = ability3CoolDown;
    }
    public int getAbility1Duration() {
        return ability1Duration;
    }
    public int getAbility2Duration() {
        return ability2Duration;
    }
    public int getAbility3Duration() {
        return ability3Duration;
    }
    public int getBlockedRoundsChamp() {
        return blockedRoundsChamp;
    }
    public void setBlockedRoundsChamp(int blockedRoundsChamp) {
        this.blockedRoundsChamp = blockedRoundsChamp;
    }
    public int getUntouchableRoundsChamp() {
        return untouchableRoundsChamp;
    }
    public void setUntouchableRoundsChamp(int untouchableRoundsChamp) {
        this.untouchableRoundsChamp = untouchableRoundsChamp;
    }
    public int getAbility1CurrentDuration() {
        return ability1CurrentDuration;
    }
    public void setAbility1CurrentDuration(int ability1CurrentDuration) {
        this.ability1CurrentDuration = ability1CurrentDuration;
    }
    public int getAbility2CurrentDuration() {
        return ability2CurrentDuration;
    }
    public void setAbility2CurrentDuration(int ability2CurrentDuration) {
        this.ability2CurrentDuration = ability2CurrentDuration;
    }
    public int getAbility3CurrentDuration() {
        return ability3CurrentDuration;
    }
    public void setAbility3CurrentDuration(int ability3CurrentDuration) {
        this.ability3CurrentDuration = ability3CurrentDuration;
    }
    public String getType() {
        return type;
    }
    public int getDamageTakenReduction() {
        return damageTakenReduction;
    }
    public void setDamageTakenReduction(int damageTakenReduction) {
        this.damageTakenReduction = damageTakenReduction;
    }
    public void setAbility1Duration(int ability1Duration) {
        this.ability1Duration = ability1Duration;
    }
    public void setAbility2Duration(int ability2Duration) {
        this.ability2Duration = ability2Duration;
    }
    public void setAbility3Duration(int ability3Duration) {
        this.ability3Duration = ability3Duration;
    }

    public boolean isAlive() {
        return this.getHP() > 0;
    }
    public void takeDamage(int damage) {
        int hp = this.getHP();
        this.setHP(hp - damage);
    }
    public static int searchChamp(int champID) {
        for (int i = 0; i < champList.size(); i++) {
            if (champList.get(i).getID() == champID) {
                return i;
            }
        }
        return -1;
    }

    public static int searchChamp(String champName) {
        for (int i = 0; i < champList.size(); i++) {
            if (champList.get(i).getName().equals(champName)) {
                return i;
            }
        }
        return -1;
    }

    public abstract void useChampAbilities(Champion target, int choice);
    public abstract void useChampAbilities(int choice);
    public abstract void takeAction();
    public abstract void attackChamp(Champion target, int ability);
}
