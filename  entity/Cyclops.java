package entity;

public class Cyclops extends Monster {

    public Cyclops(String name) {
        super(name);
    }

    public void specialPower() {
        log.debug("Crazy eye laser rays...   who knew?");
    }

//    public void fight(){
//        log.debug("User gained 2 points of strength, monster gained 4 points of strength.");
//        super.fight(2, 4);
//    }
}
