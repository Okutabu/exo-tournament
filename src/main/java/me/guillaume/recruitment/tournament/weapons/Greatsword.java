package me.guillaume.recruitment.tournament.weapons;

public class Greatsword extends Weapon{

    private int count;

    public Greatsword(){
        damage = 12;
        count = 1;
    }

    public int getCount(){
        return count;
    }
    public void upCount(){
        count++;
    }
}
