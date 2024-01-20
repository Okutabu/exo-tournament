package me.guillaume.recruitment.tournament.buckler;

import me.guillaume.recruitment.tournament.characters.Character;
import me.guillaume.recruitment.tournament.weapons.Weapon;

public class IneffectiveBlockState implements BucklerState {
    private Buckler buckler;
    public IneffectiveBlockState(Buckler buckler) {
        this.buckler = buckler;
    }
    public void block(Character protectedCharacter, Weapon weapon) {
        protectedCharacter.setImmunityToDamage(false);
    }
    public BucklerState nextState() {
        if (buckler.getBreakResistance() == 0){
            return new BrokenState();
        }
        else{
            return new EffectiveBlockState(buckler);
        }

    }

    @Override
    public String getName() {
        return "InnefectiveBlocking";
    }

    @Override
    public boolean isBroken(){
        return false;
    }
    @Override
    public boolean isIneffective(){
        return true;
    }
    @Override
    public boolean isEffective(){return false;}
}