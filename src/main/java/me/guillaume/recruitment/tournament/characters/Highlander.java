package me.guillaume.recruitment.tournament.characters;

import me.guillaume.recruitment.tournament.weapons.Greatsword;

public class Highlander extends Character{


    public Highlander(){
        hitPoints = 150;
        weapon = new Greatsword();
        baseDamageEveryBlow = weapon.getDamage();
        immunityToDamage = false;
    }

    @Override
    public int hitPoints() {
        return hitPoints;
    }

    @Override
    public Highlander equip(String equipment) {
        super.equip(equipment);
        return this;
    }

}
