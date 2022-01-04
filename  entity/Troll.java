package entity;

public class Troll extends Monster {

    public Troll(String name) {
        super(name);
    }

    public void specialPower() {
        log.debug("shoot beam of light?");
    }
}
