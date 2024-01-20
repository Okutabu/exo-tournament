package me.guillaume.recruitment.tournament.characters;

import me.guillaume.recruitment.tournament.Armor;
import me.guillaume.recruitment.tournament.buckler.Buckler;
import me.guillaume.recruitment.tournament.weapons.Handsword;

import java.util.Objects;

public class Swordsman extends Character{

    private String activeTrait;
    private int poisonStacks;
    public Swordsman(){
        hitPoints = 100;
        weapon = new Handsword();
        immunityToDamage = false;
    }
    public Swordsman(String trait){
        this();
        if(Objects.equals(trait, "Vicious")){
            activeTrait = "Vicious";
            poisonStacks = 2;
        }
    }


    @Override
    public Swordsman equip(String equipment) {
        super.equip(equipment);
        return this;
    }
    @Override
    public int getDamageEveryBlow() {
        int damage = getBaseDamage();
        if (armor!=null){
            damage = Armor.debuffDamage(damage);
        }
        if ((Objects.equals(activeTrait, "Vicious")) && poisonStacks > 0){
            poisonStacks -= 1;
            int POISON_DAMAGE = 20;
            damage = damage+ POISON_DAMAGE;
        }
        return damage;
    }

    public Buckler getBuckler(){
        return buckler;
    }

}
