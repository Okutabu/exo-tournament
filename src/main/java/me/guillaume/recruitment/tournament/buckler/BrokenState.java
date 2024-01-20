package me.guillaume.recruitment.tournament.buckler;

import me.guillaume.recruitment.tournament.characters.Character;
import me.guillaume.recruitment.tournament.weapons.Weapon;

public class BrokenState implements BucklerState {
    public void block(Character protectedCharacter, Weapon weapon) {
        // Buckler is broken, no effect
    }
    public BucklerState nextState() {
        return this; // The state remains broken
    }

    @Override
    public boolean isBroken(){
        return true;
    }
    @Override
    public boolean isIneffective(){
        return false;
    }
    @Override
    public boolean isEffective(){return false;}

}