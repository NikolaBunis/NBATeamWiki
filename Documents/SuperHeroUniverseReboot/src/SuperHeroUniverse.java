import heroInteractions.Alignment;
import heroInteractions.PowerType;
import heroInteractions.SuperPower;
import heroInteractions.Superhero;

public class SuperHeroUniverse {
    public static void main (String[] boomboom){

        SuperPower thunderStrike = new SuperPower("Thunder Strike", PowerType.MAGIC);

        Superhero Thor = new Superhero("Thor Odinson", "I have no need of such nonsense!", Alignment.GOOD, 95, thunderStrike, PowerType.CHEMICAL);


        SuperPower trickery = new SuperPower("Trickery", PowerType.INTELLIGENCE);

        Superhero Loki = new Superhero("Loki", "Many...", Alignment.NEUTRAL, 65, trickery, PowerType.MAGIC);

        Thor.getCurrentState();
        System.out.println();

        System.out.println("VERSUS");
        System.out.println();
        Loki.getCurrentState();
        System.out.println();
        System.out.println("FIGHT!");
        System.out.println();
        Thor.attack(Thor,Loki, thunderStrike);
        System.out.println();
        Loki.attack(Loki, Thor, trickery);


        while (true){

if (Thor.getLifePoints() > Loki.getLifePoints()){

    Loki.attack(Loki, Thor, trickery);
    Thor.attack(Thor, Loki, thunderStrike);
}

if (Thor.getLifePoints() <= Loki.getLifePoints()){

    Thor.attack(Thor, Loki, thunderStrike);
    Loki.attack(Loki, Thor, trickery);
}


if(Thor.getLifePoints() == 5 || Loki.getLifePoints() ==5){
    break;
}


        }

        Thor.getCurrentState();
        Loki.getCurrentState();




    }

}
