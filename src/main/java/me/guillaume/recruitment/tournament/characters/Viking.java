package me.guillaume.recruitment.tournament.characters;

import me.guillaume.recruitment.tournament.weapons.Axe;

public class Viking extends Character{

    public Viking(){
        hitPoints = 120;
        weapon = new Axe();
        immunityToDamage = false;
    }

    @Override
    public Viking equip(String equipment) {
        super.equip(equipment);
        return this;
    }


}
