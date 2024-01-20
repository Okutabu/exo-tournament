package me.guillaume.recruitment.tournament.buckler;


import me.guillaume.recruitment.tournament.characters.Character;
import me.guillaume.recruitment.tournament.weapons.Axe;
import me.guillaume.recruitment.tournament.weapons.Weapon;

public class EffectiveBlockState implements BucklerState {
    private Buckler buckler;

    public EffectiveBlockState(Buckler buckler) {
        this.buckler = buckler;
    }
    public void block(Character protectedCharacter, Weapon weapon) {
        protectedCharacter.setImmunityToDamage(true);
        if (weapon instanceof Axe) {
            buckler.reduceBreakResistance();
        }


    }
    public BucklerState nextState() {
        return new IneffectiveBlockState(buckler);

    }

    @Override
    public String getName() {
        return "EffectivelyBlocking";
    }

    @Override
    public boolean isBroken(){
        return false;
    }

    @Override
    public boolean isIneffective(){
        return false;
    }
    @Override
    public boolean isEffective(){return true;}
}
