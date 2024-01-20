package me.guillaume.recruitment.tournament.characters;

import me.guillaume.recruitment.tournament.weapons.Weapon;

public interface Fighter {

    public void engage(Fighter opponent);

    public void takeDamage(int damageTaken, Weapon weapon);
    public int hitPoints();
}
