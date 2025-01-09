public class displayChampions {
    public static void displayChampions_4(Champion champ1, Champion champ2, Champion champ3, Champion champ4) {
        System.out.println("                          ========= TEAM 1 ========");
        System.out.println("                          | CHAMP NAME: " + champ1.getName());
        System.out.println("                          | CHAMP HP: " + champ1.getHP());
        System.out.println("                          | ABILITY 1 INFO: COOLDOWN: " + champ1.getAbility1CoolDown() + " DURATION: " + champ1.getAbility1CurrentDuration());
        System.out.println("                          | ABILITY 2 INFO: COOLDOWN: " + champ1.getAbility2CoolDown() + " DURATION: " + champ1.getAbility2CurrentDuration());
        System.out.println("                          | ABILITY 3 INFO: COOLDOWN: " + champ1.getAbility3CoolDown() + " DURATION: " + champ1.getAbility3CurrentDuration());
        System.out.println("");

        System.out.println("========= TEAM 2 ========                                        ========= TEAM 3 ========");
        System.out.printf("| CHAMP NAME: %-50s | CHAMP NAME: %-50s\n", champ2.getName(), champ3.getName());
        System.out.printf("| CHAMP HP: %-50d | CHAMP HP: %-50d\n", champ2.getHP(), champ3.getHP());
        System.out.printf("| ABILITY 1 INFO: COOLDOWN: %d DURATION: %d | ABILITY 1 INFO: COOLDOWN: %-6d DURATION: %-6d\n", champ2.getAbility1CoolDown(), champ2.getAbility1CurrentDuration(), champ3.getAbility1CoolDown(), champ3.getAbility1CurrentDuration());
        System.out.printf("| ABILITY 2 INFO: COOLDOWN: %d DURATION: %d | ABILITY 2 INFO: COOLDOWN: %-6d DURATION: %-6d\n", champ2.getAbility2CoolDown(), champ2.getAbility2CurrentDuration(), champ3.getAbility2CoolDown(), champ3.getAbility2CurrentDuration());
        System.out.printf("| ABILITY 3 INFO: COOLDOWN: %d DURATION: %d | ABILITY 3 INFO: COOLDOWN: %-6d DURATION: %-6d\n", champ2.getAbility3CoolDown(), champ2.getAbility3CurrentDuration(), champ3.getAbility3CoolDown(), champ3.getAbility3CurrentDuration());
        System.out.println("");

        System.out.println("                          ========= TEAM 4 ========");
        System.out.println("                          | CHAMP NAME: " + champ4.getName());
        System.out.println("                          | CHAMP HP: " + champ4.getHP());
        System.out.println("                          | ABILITY 1 INFO: COOLDOWN: " + champ4.getAbility1CoolDown() + " DURATION: " + champ4.getAbility1CurrentDuration());
        System.out.println("                          | ABILITY 2 INFO: COOLDOWN: " + champ4.getAbility2CoolDown() + " DURATION: " + champ4.getAbility2CurrentDuration());
        System.out.println("                          | ABILITY 3 INFO: COOLDOWN: " + champ4.getAbility3CoolDown() + " DURATION: " + champ4.getAbility3CurrentDuration());
        System.out.println("");
    }

    public static void displayChampions_3(Champion champ1, Champion champ2, Champion champ3) {
        System.out.println("                          ========= TEAM 1 ========");
        System.out.println("                          | CHAMP NAME: " + champ1.getName());
        System.out.println("                          | CHAMP HP: " + champ1.getHP());
        System.out.println("                          | ABILITY 1 INFO: COOLDOWN: " + champ1.getAbility1CoolDown() + " DURATION: " + champ1.getAbility1CurrentDuration());
        System.out.println("                          | ABILITY 2 INFO: COOLDOWN: " + champ1.getAbility2CoolDown() + " DURATION: " + champ1.getAbility2CurrentDuration());
        System.out.println("                          | ABILITY 3 INFO: COOLDOWN: " + champ1.getAbility3CoolDown() + " DURATION: " + champ1.getAbility3CurrentDuration());
        System.out.println("");

        System.out.println("========= TEAM 2 ========                                        ========= TEAM 3 ========");
        System.out.printf("| CHAMP NAME: %-50s | CHAMP NAME: %-50s\n", champ2.getName(), champ3.getName());
        System.out.printf("| CHAMP HP: %-50d | CHAMP HP: %-50d\n", champ2.getHP(), champ3.getHP());
        System.out.printf("| ABILITY 1 INFO: COOLDOWN: %-6d DURATION: %-6d | ABILITY 1 INFO: COOLDOWN: %-6d DURATION: %-6d\n", champ2.getAbility1CoolDown(), champ2.getAbility1CurrentDuration(), champ3.getAbility1CoolDown(), champ3.getAbility1CurrentDuration());
        System.out.printf("| ABILITY 2 INFO: COOLDOWN: %-6d DURATION: %-6d | ABILITY 2 INFO: COOLDOWN: %-6d DURATION: %-6d\n", champ2.getAbility2CoolDown(), champ2.getAbility2CurrentDuration(), champ3.getAbility2CoolDown(), champ3.getAbility2CurrentDuration());
        System.out.printf("| ABILITY 3 INFO: COOLDOWN: %-6d DURATION: %-6d | ABILITY 3 INFO: COOLDOWN: %-6d DURATION: %-6d\n", champ2.getAbility3CoolDown(), champ2.getAbility3CurrentDuration(), champ3.getAbility3CoolDown(), champ3.getAbility3CurrentDuration());
        System.out.println("");
    }

    public static void displayChampions_2(Champion champ1, Champion champ2) {
        System.out.println("                          ========= TEAM 1 ========");
        System.out.println("                          | CHAMP NAME: " + champ1.getName());
        System.out.println("                          | CHAMP HP: " + champ1.getHP());
        System.out.println("                          | ABILITY 1 INFO: COOLDOWN: " + champ1.getAbility1CoolDown() + " DURATION: " + champ1.getAbility1CurrentDuration());
        System.out.println("                          | ABILITY 2 INFO: COOLDOWN: " + champ1.getAbility2CoolDown() + " DURATION: " + champ1.getAbility2CurrentDuration());
        System.out.println("                          | ABILITY 3 INFO: COOLDOWN: " + champ1.getAbility3CoolDown() + " DURATION: " + champ1.getAbility3CurrentDuration());
        System.out.println("");

        System.out.println("========= TEAM 2 ========");
        System.out.println("| CHAMP NAME: " + champ2.getName());
        System.out.println("| CHAMP HP: " + champ2.getHP());
        System.out.println("| ABILITY 1 INFO: COOLDOWN: " + champ2.getAbility1CoolDown() + " DURATION: " + champ2.getAbility1CurrentDuration());
        System.out.println("| ABILITY 2 INFO: COOLDOWN: " + champ2.getAbility2CoolDown() + " DURATION: " + champ2.getAbility2CurrentDuration());
        System.out.println("| ABILITY 3 INFO: COOLDOWN: " + champ2.getAbility3CoolDown() + " DURATION: " + champ2.getAbility3CurrentDuration());
        System.out.println("");
    }
}

