package entity;

public class Minitour extends Monster {

    public Minitour(String name) {
        super(name);
    }

    public void specialPower() {
        log.debug("shoot beam of light");
    }
}
