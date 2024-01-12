package me.guillaume.recruitment.tournament;

public abstract class Character {
    //hit points are the number of damage they can take ebfore dying
    protected int hitPoints;
    protected int baseDamageEveryBlow;

    public int hitPoints(){
        return hitPoints;
    }
}
