package me.guillaume.recruitment.tournament.buckler;

import me.guillaume.recruitment.tournament.characters.Character;
import me.guillaume.recruitment.tournament.weapons.Weapon;

public interface BucklerState {
    void block(Character protectedCharacter, Weapon weapon);
    BucklerState nextState();

    boolean isBroken();
    boolean isIneffective();
    boolean isEffective();

}
