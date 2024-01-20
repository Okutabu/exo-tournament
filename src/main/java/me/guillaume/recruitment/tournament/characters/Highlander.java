package me.guillaume.recruitment.tournament.characters;

import me.guillaume.recruitment.tournament.Armor;
import me.guillaume.recruitment.tournament.weapons.Greatsword;

import java.util.Objects;

public class Highlander extends Character{

    private String activeRank;
    private final int berserkTreshold;
    public Highlander(){
        hitPoints = 150;
        weapon = new Greatsword();
        immunityToDamage = false;
        // Highlander goes berserk when HP reaches 30% of total
        berserkTreshold = hitPoints * 3 / 10;
    }
    public Highlander(String rank){
        this();
        if(Objects.equals(rank, "Veteran")){
            activeRank = "Veteran";
        }
    }
    @Override
    public int getDamageEveryBlow() {
        int damage = getBaseDamage();
        if (armor!=null){
            return Armor.debuffDamage(damage);
        }
        if (Objects.equals(activeRank, "Veteran") && hitPoints()<berserkTreshold){
            return damage * 2;
        }else{
            return damage;
        }
    }

    @Override
    public Highlander equip(String equipment) {
        super.equip(equipment);
        return this;
    }

}
