package me.guillaume.recruitment.tournament.characters;

import me.guillaume.recruitment.tournament.buckler.Buckler;
import me.guillaume.recruitment.tournament.weapons.Handsword;

public class Swordsman extends Character{

    public Swordsman(){
        hitPoints = 100;
        weapon = new Handsword();
        baseDamageEveryBlow = weapon.getDamage();
        immunityToDamage = false;
    }

    public int hitPoints(){
        return hitPoints;
    }
    @Override
    public Swordsman equip(String equipment) {
        super.equip(equipment);
        return this;
    }

    public Buckler getBuckler(){
        return buckler;
    }

}
