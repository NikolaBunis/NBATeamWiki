package heroInteractions;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.List;

public class Superhero {


    private final int NAME_MIN_VALUE = 3;
    private final int NAME_MAX_VALUE = 60;

    private final int SECRET_IDENTITY_MIN_VALUE = 3;
    private final int SECRET_IDENTITY_MAX_VALUE = 60;

    private final int LIFE_POINTS_MIN = 1;
    private final int LIFE_POINTS_MAX = 100;

    private String name;

    private String secretIdentity;

    private Alignment alignment;

    private int lifePoints;

    private List<PowerType> immunities;

    private List<SuperPower> powers;


    public Superhero(String name, String secretIdentity, Alignment alignment, int lifePoints) {
        this.name = name;
        this.secretIdentity = secretIdentity;
        this.alignment = alignment;
        this.lifePoints = lifePoints;
    }

    public Superhero(String name, String secretIdentity, Alignment alignment, int lifePoints, SuperPower power, PowerType immunity) {
        this.name = name;
        this.secretIdentity = secretIdentity;
        this.alignment = alignment;
        this.lifePoints = lifePoints;

        powers = new LinkedList<SuperPower>();
        powers.add(power);
        immunities = new LinkedList<PowerType>();
        immunities.add(immunity);


    }


        public Superhero(SuperPower power) {

        powers.add(power);
    }

    public Superhero(PowerType immunity) {

        immunities.add(immunity);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name.length() < NAME_MIN_VALUE || name.length() > NAME_MAX_VALUE) {
            System.out.println("Names can be no shorter than 3 characters and no longer than 60.");
            return;
        }

        this.name = name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {

        if (secretIdentity.length() < SECRET_IDENTITY_MIN_VALUE || secretIdentity.length() > SECRET_IDENTITY_MAX_VALUE) {
            System.out.println("Secret identities can be no shorter than 3 characters and no longer than 60.");
            return;
        }
        this.secretIdentity = secretIdentity;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
if(lifePoints < LIFE_POINTS_MIN || lifePoints > LIFE_POINTS_MAX){

    System.out.println("Life points can be no fewer than 3 and no more than 100");
    return;
}

this.lifePoints = lifePoints;


    }

    public List<PowerType> getImmunities() {
        return immunities;
    }

    public void setImmunities(PowerType immunity) {
        immunities.add(immunity);
    }

    public void getPowers() {
        for (int i = 0; i < powers.size() ; i++) {

            powers.get(i).getCurrentState();
        }

        }



    public void addPower(SuperPower power) {

        powers.add(power);
    }


    public void getCurrentState() {


        System.out.println("Name: " + name + "\n Secret Identity: " + secretIdentity + "\n Alignment: " + alignment);
        System.out.println("Starting life points: " + lifePoints);
        System.out.println("Powers: ");
        for (int i = 0; i < powers.size() ; i++) {

            powers.get(i).getCurrentState();
        }

        System.out.println("Immunities: ");

        for (int i = 0; i < immunities.size(); i++) {

            System.out.println(immunities.get(i));

        }

        }


     public void attack(Superhero attacker, Superhero target, SuperPower power){

         System.out.println(attacker.getName() + " attacks " + target.getName() + " with " + power.getName() + "!");


        if(target.immunities.contains(power.getType())){

            System.out.println(target.getName() + " is immune to " +  power.getName() + "'s power type!" );
            System.out.println(target.getName() + "'s current life points are " + target.getLifePoints());
        }

        else if(!target.immunities.contains(power.getType())) {
            System.out.println(target.getName() + " suffers 10 damage from the " + power.getName() + " attack");
            target.setLifePoints(target.lifePoints - 10);
            System.out.println(target.getName() + "'s current life points are " + target.getLifePoints());
        }

     }






    }

