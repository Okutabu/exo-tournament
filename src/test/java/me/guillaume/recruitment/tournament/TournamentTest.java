package me.guillaume.recruitment.tournament;

import me.guillaume.recruitment.tournament.characters.Highlander;
import me.guillaume.recruitment.tournament.characters.Swordsman;
import me.guillaume.recruitment.tournament.characters.Viking;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * This is a duel simulation
 *
 * Blow exchange are sequential, A engage B means that A will give the first blow, then B will respond
 *
 */
public class TournamentTest {


    /**
     * A me.guillaume.recruitment.tournament.characters.Swordsman has 100 hit points and use a 1 hand sword that does 5 dmg
     * A me.guillaume.recruitment.tournament.characters.Viking has 120 hit points and use a 1 hand axe that does 6 dmg
     */
    @Test
    public void SwordsmanVsViking() {

        Swordsman swordsman = new Swordsman();

        Viking viking = new Viking();

        swordsman.engage(viking);

        assertThat(swordsman.hitPoints()).isEqualTo(0);
        assertThat(viking.hitPoints()).isEqualTo(35);

    }

    /**
     * a buckler cancel all the damages of a blow one time out of two
     * a buckler is destroyed after blocking 3 blow from an axe
     */
    @Test
    public void SwordsmanWithBucklerVsVikingWithBuckler() {

        Swordsman swordsman = new Swordsman()
                .equip("buckler");

        Viking viking = new Viking()
                .equip("buckler");

        swordsman.engage(viking);

        assertThat(swordsman.hitPoints()).isEqualTo(0);
        assertThat(viking.hitPoints()).isEqualTo(70);

    }

    /**
     * an Highlander as 150 hit points and fight with a Great Sword
     * a Great Sword is a two handed sword deliver 12 damages, but can attack only 2 every 3
     * an armor : reduce all received damages by 3 & reduce delivered damages by one
     */
    @Test
    public void ArmoredSwordsmanVsViking() {

        Highlander highlander = new Highlander();

        Swordsman swordsman = new Swordsman()
                .equip("buckler")
                .equip("armor");

        swordsman.engage(highlander);

        assertThat(swordsman.hitPoints()).isEqualTo(0);
        assertThat(highlander.hitPoints()).isEqualTo(10);

    }
    /**
     * a vicious Swordsman is a Swordsman that put poison on his weapon.
     * poison add 20 damages on two first blows
     * a veteran Highlander goes Berserk once his hit points are under 30% of his initial total
     * once Berserk, he doubles his damages
     */
    @Test // Bonus points :D
    public void ViciousSwordsmanVsVeteranHighlander() {

        Swordsman swordsman = new Swordsman("Vicious")
                .equip("axe")
                .equip("buckler")
                .equip("armor");

        Highlander highlander = new Highlander("Veteran");

        swordsman.engage(highlander);

        assertThat(swordsman.hitPoints()).isEqualTo(1);
        assertThat(highlander.hitPoints()).isEqualTo(0);

    }

    @Test
    public void SwordsmanBlocksEffectivelyTheFirstBlowButNotTheSecond(){
        Swordsman swordsman = new Swordsman()
                .equip("buckler");
        Viking viking = new Viking();

        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        assertThat(swordsman.hitPoints()).isEqualTo(100);
        // second blow
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        assertThat(swordsman.hitPoints()).isEqualTo(94);

    }

    @Test
    public void BucklerBreaksAfterSixBlowsFromAxeWieldingFighter(){
        Swordsman swordsman = new Swordsman()
                .equip("buckler");
        Viking viking = new Viking();

        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());

        assertThat(swordsman.hitPoints()).isEqualTo(82);
        assertThat(swordsman.getBuckler().getState().isBroken()).isEqualTo(true);
    }
    @Test
    public void BucklerDoesNotBreakAfterSixBlowsFromNonAxeWieldingFighter(){
        Swordsman swordsman = new Swordsman()
                .equip("buckler");
        Swordsman swordsman2 = new Swordsman();

        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        swordsman.takeDamage(swordsman2.getWeapon().getDamage(), swordsman2.getWeapon());
        assertThat(swordsman.hitPoints()).isEqualTo(80);
        assertThat(swordsman.getBuckler().getState().isBroken()).isEqualTo(false);
    }

    @Test
    public void BucklerRemainsBrokenNextTurnAfterBeingBroke(){
        Swordsman swordsman = new Swordsman()
                .equip("buckler");
        Viking viking = new Viking();

        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());

        assertThat(swordsman.hitPoints()).isEqualTo(82);
        assertThat(swordsman.getBuckler().getState().isBroken()).isEqualTo(true);
        swordsman.takeDamage(viking.getWeapon().getDamage(), viking.getWeapon());
        assertThat(swordsman.getBuckler().getState().isBroken()).isEqualTo(true);
    }


    @Test
    public void HighlanderAttacksTwoTurnsOutOfThree(){
        Highlander highlander = new Highlander();

        Swordsman swordsman = new Swordsman();

        swordsman.takeDamage(highlander.getWeapon().getDamage(), highlander.getWeapon());
        swordsman.takeDamage(highlander.getWeapon().getDamage(), highlander.getWeapon());
        swordsman.takeDamage(highlander.getWeapon().getDamage(), highlander.getWeapon());
        assertThat(swordsman.hitPoints()).isEqualTo(76);



    }

    @Test
    public void armorReducesDamageReceivedByThree(){
        Highlander highlander = new Highlander().equip("armor");

        Swordsman swordsman = new Swordsman()
                .equip("armor");

        swordsman.takeDamage(highlander.getWeapon().getDamage(), highlander.getWeapon());
        assertThat(swordsman.hitPoints()).isEqualTo(91);



    }

    @Test
    public void armorReducesDamageDealtByOne(){
        Highlander highlander = new Highlander().equip("armor");

        Swordsman swordsman = new Swordsman();

        swordsman.takeDamage(highlander.getDamageEveryBlow(), highlander.getWeapon());
        assertThat(swordsman.hitPoints()).isEqualTo(89);



    }

    @Test
    public void BucklerOdesNotBlockWhenGreatswordDoesNotAttack() {

        Highlander highlander = new Highlander();

        Swordsman swordsman = new Swordsman()
                .equip("buckler");

        assertThat(swordsman.getBuckler().getState().isEffective()).isEqualTo(true);
        swordsman.takeDamage(highlander.getDamageEveryBlow(), highlander.getWeapon());
        assertThat(swordsman.getBuckler().getState().isIneffective()).isEqualTo(true);
        swordsman.takeDamage(highlander.getDamageEveryBlow(), highlander.getWeapon());
        assertThat(swordsman.getBuckler().getState().isEffective()).isEqualTo(true);
        swordsman.takeDamage(highlander.getDamageEveryBlow(), highlander.getWeapon());
        assertThat(swordsman.getBuckler().getState().isEffective()).isEqualTo(true);

    }
    @Test
    public void ViciousSwordsmanDealsBonusDamageTwice() {

        Swordsman swordsman = new Swordsman("Vicious")
                .equip("axe")
                .equip("buckler")
                .equip("armor");

        Highlander highlander = new Highlander();
        // axe base damage is 6 + 20 from poison and -1 from armor should be 25 first two hits
        highlander.takeDamage(swordsman.getDamageEveryBlow(), swordsman.getWeapon());
        assertThat(highlander.hitPoints()).isEqualTo(125);
        highlander.takeDamage(swordsman.getDamageEveryBlow(), swordsman.getWeapon());
        assertThat(highlander.hitPoints()).isEqualTo(100);
        //third attack deals 5
        highlander.takeDamage(swordsman.getDamageEveryBlow(), swordsman.getWeapon());
        assertThat(highlander.hitPoints()).isEqualTo(95);

    }


}
