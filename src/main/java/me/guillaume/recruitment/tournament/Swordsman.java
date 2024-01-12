package me.guillaume.recruitment.tournament;

import me.guillaume.recruitment.tournament.Fighter;

public class Swordsman extends Character implements Fighter {

    Swordsman(){
        hitPoints = 100;
        baseDamageEveryBlow = 5;
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

    public int hitPoints(){
        return hitPoints;
    }
}
