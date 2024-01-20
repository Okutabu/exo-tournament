package me.guillaume.recruitment.tournament;

public class Armor extends Equipment{

    public static final int DAMAGE_DEBUFF = 1;
    public static final int DAMAGE_REDUCTION = 3;
    private String name;
    public Armor(){
        name = "Armor";
    }

    public static int debuffDamage(int damageThatShouldBeDealt){
        return damageThatShouldBeDealt - DAMAGE_DEBUFF;
    }
    public static int damageAfterArmorResistance(int damageThatShouldBeReceived){
        return damageThatShouldBeReceived - DAMAGE_REDUCTION;
    }
}
