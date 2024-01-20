package me.guillaume.recruitment.tournament.characters;

import me.guillaume.recruitment.tournament.Armor;
import me.guillaume.recruitment.tournament.buckler.Buckler;
import me.guillaume.recruitment.tournament.weapons.Greatsword;
import me.guillaume.recruitment.tournament.weapons.Weapon;

public abstract class Character {
    //hit points are the number of damage they can take ebfore dying
    protected int hitPoints;
    protected Weapon weapon;

    protected Buckler buckler;
    protected Armor armor;
    protected int baseDamageEveryBlow;
    protected boolean immunityToDamage;

        //from Fighter interface
    public void engage(Character opponent){
        opponent.takeDamage(getDamageEveryBlow(), weapon);
        if (opponent.hitPoints() > 0){
            opponent.engage(this);
        }
    }

    public int hitPoints(){
        return hitPoints;
    }

    public Character equip(String equipment) {
        if (equipment == "buckler") {
            buckler = new Buckler();
        }
        else if(equipment == "armor"){
            armor = new Armor();
        }
        return this;
    }
    //from Fighter interface
    public void takeDamage(int damageTaken, Weapon weapon) {
        boolean isGreatswordThirdAttack = false;
        if(armor != null){
           damageTaken = Armor.damageAfterArmorResistance(damageTaken);
        }
        if (weapon instanceof Greatsword) {
            Greatsword greatsword = (Greatsword) weapon;
            if(greatsword.getCount() % 3 == 0){
                damageTaken = 0;
                isGreatswordThirdAttack = true;
            }
            ((Greatsword) weapon).upCount();
        }

        if(buckler!=null && !isGreatswordThirdAttack) {
            // Cast to Buckler and call block
            buckler.block(this, weapon);

        }
        if(!immunityToDamage){
            hitPoints = hitPoints - damageTaken;
            // on s'assure de ne pas avoir de pv négatif pour les tests
            if(hitPoints < 0 ) hitPoints = 0;
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor(){
        return armor;
    }

    public int getDamageEveryBlow() {
        if (armor!=null){
            return Armor.debuffDamage(baseDamageEveryBlow);
        }
        return baseDamageEveryBlow;
    }

    public void setImmunityToDamage(boolean bool){
        immunityToDamage = bool;
    }
}
