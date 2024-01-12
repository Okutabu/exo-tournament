package me.guillaume.recruitment.tournament;

import me.guillaume.recruitment.tournament.Fighter;
public class Viking extends Character implements Fighter {

    Viking(){
        hitPoints = 120;
        baseDamageEveryBlow = 6;
    }
    public void engage(Fighter opponent){
        opponent.takeDamage(baseDamageEveryBlow);
        if (opponent.hitPoints() > 0){
            opponent.engage(this);
        }
    }

    @Override
    public void takeDamage(int damageTaken) {
        hitPoints = hitPoints - damageTaken;
        // on s'assure de ne pas avoir de pv négatif pour les tests
        if(hitPoints < 0 ) hitPoints = 0;
    }

    @Override
    public int hitPoints() {
        return hitPoints;
    }
}
