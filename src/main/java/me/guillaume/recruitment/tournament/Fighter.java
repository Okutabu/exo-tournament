package me.guillaume.recruitment.tournament;

public interface Fighter {

    public void engage(Fighter opponent);

    public void takeDamage(int damageTaken);
    public int hitPoints();
}
