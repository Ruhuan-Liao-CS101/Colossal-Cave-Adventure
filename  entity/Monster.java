package entity;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Monster implements iMonster {

    static Logger log = LogManager.getLogger(Monster.class);
    private String name;

    public Monster(String name) {
        this.name = name;
    }

    public void fight() {

        doFight();

    }

    public void sayHello() {

        log.debug("I am a generic monster");

    }

    public void specialPower() {

        log.debug("I can do monster stuff.");

    }

    /**
     *
     * common battle dynamic across monsters - can be shared..
     */
    private void doFight() {

        Random rn = new Random();
        int monsterScore = rn.nextInt(10) + 1;
        int userScore = rn.nextInt(10) + 1;

        log.info("User score: " + userScore);
        log.info("Monster score: " + monsterScore);


        if(monsterScore > userScore) {
            log.info("Monster Wins!");

        }else {
            log.info("User Wins!");
        }
    }


}