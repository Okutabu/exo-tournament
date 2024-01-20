package me.guillaume.recruitment.tournament.buckler;

import me.guillaume.recruitment.tournament.Equipment;
import me.guillaume.recruitment.tournament.characters.Character;
import me.guillaume.recruitment.tournament.weapons.Weapon;

public class Buckler extends Equipment {

    private BucklerState state;


    private int breakResistance;
    public Buckler(){
        breakResistance = 3;
        name = "Buckler";
        state = new EffectiveBlockState(this);
    }
    public void block(Character protectedCharacter, Weapon weapon){
        state.block(protectedCharacter, weapon);
        state = state.nextState();
    }

    public int getBreakResistance() {
        return breakResistance;
    }

    public void reduceBreakResistance() {
        breakResistance -= 1;
        if(breakResistance < 0) breakResistance = 0;
    }

    public BucklerState getState() {
        return state;
    }
}
