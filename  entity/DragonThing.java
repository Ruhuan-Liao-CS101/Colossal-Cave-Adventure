package entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DragonThing extends Monster{

    public DragonThing(String name) {
        super(name);
    }

    static Logger log = LogManager.getLogger(DragonThing.class);
    public void sayHello() {
        log.debug("I am a dragon thing...");
    }
}
