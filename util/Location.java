package util;

import entity.CREATURE;
import entity.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Location{

    //Starting user coordinates
    private int x;
    private int y;
    private String currentLocation = "";

    public Location(){
        x = 1;
        y = 1;
    }

    //Empty map of the dungeon that will be updated as the user moves
    int[][] blankMap = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
    };

    //1 - Kitchen
    //2 - Basement
    //3 - backdoor
    //4 - cave 1
    // 5 - cave 2
    //Map of same dimensions as first map that stores values of locations the user can discover
    int[][] map1Locations = {
            {0,5,0,4},
            {1,0,0,3},
            {0,0,2,0}
    };

    User user1 = new User();

    //Method that handles the user's movements/inputs
    public void move(){

        while(true && user1.getScore() < 50) {

            Scanner scan = new Scanner(System.in);
            System.out.println("\nWhat direction do you want to move: ");
            String moveDirection = scan.nextLine();

            //logic for moving around the and displaying the map via user entering directions, also includes
            //if statements to display help class information
            if (moveDirection.equalsIgnoreCase("North")) {
                blankMap[x][y] = 0;
                x = x - 1;
                if (x < 0) {
                    System.out.println("You reached the edge, choose a different direction");
                    x = x + 1;
                    continue;
                }
                blankMap[x][y] = 1;
            } else if (moveDirection.equalsIgnoreCase("South")) {
                blankMap[x][y] = 0;
                x = x + 1;
                if (x > blankMap.length - 1) {
                    System.out.println("You reached the edge, choose a different direction");
                    x = x - 1;
                    continue;
                }
                blankMap[x][y] = 1;
            } else if (moveDirection.equalsIgnoreCase("West")) {
                blankMap[x][y] = 0;
                y = y - 1;
                if (y < 0) {
                    System.out.println("You reached the edge, choose a different direction");
                    y = y + 1;
                    continue;
                }
                blankMap[x][y] = 1;
            } else if (moveDirection.equalsIgnoreCase("East")) {
                blankMap[x][y] = 0;
                y = y + 1;
                if (y > blankMap[1].length - 1) {
                    System.out.println("You reached the edge, choose a different direction");
                    y = y - 1;
                    continue;
                }
                blankMap[x][y] = 1;
            } else if (moveDirection.equalsIgnoreCase("util.Help")) {
                System.out.println(Help.defaultHelpCommandMenu());
                continue;
            } else if (moveDirection.equals("1")) {
                System.out.println(Help.getDirections());
                continue;
            } else if (moveDirection.equals("2")) {
                System.out.println(Help.getGameInformation());
                continue;
            } else if (moveDirection.equals("3")) {
                System.out.println("The following items are still available to be found: ");
                user1.getCurrentItems();
                continue;
            } else if (moveDirection.equals("4")) {
                System.out.println("\nThank you for playing!");
                break;
            } else {
                System.out.println("That is not an option! try again or use the help command");
                continue;
            }
            //Prints out an updated map of where the user has moved to
            for (int i = 0; i < blankMap.length; i++) {
                for (int j = 0; j < blankMap[i].length; j++) {
                    System.out.print(blankMap[i][j] + " ");
                }
                System.out.println();
            }
            //Method for checking user location in comparison to map
            if (checkMapForLocation() == true) {
                exploreLocation();
            }
            user1.displayFoundItems();
            System.out.printf("\nYour current point total is: %d\n", user1.getScore());

        }
        if (user1.getScore() >= 50){
            System.out.println("\nYou've reached 50 points! Now, you will fight a monster.\n");
            process();
        }
    }


    public static void process(){

        Logger log = LogManager.getLogger(Location.class);
        Monster monster = null;

        Scanner s = ScannerUtil.getInstance();
        log.info("gimmie a good monster name: ");
        String mName = s.nextLine();

        List<CREATURE> l = new ArrayList<>();

        l.add(CREATURE.CYCLOPS);
        l.add(CREATURE.MINITOUR);
        l.add(CREATURE.TROLL);

        int index = (int)(Math.random() * l.size());

        log.debug("The monster is :" + l.get(index));
        monster = MonsterFactory.create(l.get(index), "monster" + mName );

        try {
            doMonsterMayhem(monster);
        } catch (Exception e) {
            log.error("Monster problem..." + e.getMessage());
        }
    }

    public static void doMonsterMayhem(Monster monster) throws Exception {

        if (monster == null)
            throw new Exception("no monsters");

        monster.sayHello();
        monster.specialPower();
        monster.fight();
    }


    //This method looks to see if there is a location where the user moved to
    public boolean checkMapForLocation(){

        int mapLocation = map1Locations[x][y];

        boolean locationFound = false;

        if(mapLocation == 1){
            currentLocation = "kitchen";
            locationFound = true;
        }else if(mapLocation == 2){
            currentLocation = "basement";
            locationFound = true;
        }else if(mapLocation == 3){
            currentLocation = "back door";
            locationFound = true;
        }else if(mapLocation == 4){
            currentLocation = "east cave";
            locationFound = true;
        }else if(mapLocation == 5){
            currentLocation = "west cave";
            locationFound = true;
        }
        return locationFound;
    }

    //Method to detect what item the user gets if they choose to explore the location. Returns the found item
    private String locationItems(){
        String foundItem = "";
        if (currentLocation.equalsIgnoreCase("kitchen")){
            foundItem = "bracelet";
            if (!user1.getFoundItems().contains(foundItem)) {
                System.out.println("\nYou found a bracelet worth 20 points!");
                user1.itemFound(foundItem);
            }
            else{
                System.out.println("\nNo items were found here. You may have already explored this location...");
            }
        }
        else if (currentLocation.equalsIgnoreCase("basement")){
            foundItem = "necklace";
            if (!user1.getFoundItems().contains(foundItem)) {
                System.out.println("\nYou found a necklace worth 20 points!");
                user1.itemFound(foundItem);
            }
            else{
                System.out.println("\nNo items were found here. You may have already explored this location...");
            }
        }
        else if (currentLocation.equalsIgnoreCase("back door")){
            foundItem = "sword";
            if (!user1.getFoundItems().contains(foundItem)) {
                System.out.println("\nYou found a sword worth 20 points!");
                user1.itemFound(foundItem);
            }
            else{
                System.out.println("\nNo items were found here. You may have already explored this location...");
            }
        }
        else if (currentLocation.equalsIgnoreCase("east cave")){
            foundItem = "gold bar";
            if (!user1.getFoundItems().contains(foundItem)) {
                System.out.println("\nYou found a gold bar worth 20 points!");
                user1.itemFound(foundItem);
            }
            else{
                System.out.println("\nNo items were found here. You may have already explored this location...");
            }
        }
        else if (currentLocation.equalsIgnoreCase("west cave")){
            foundItem = "bear trap";
            if (!user1.getFoundItems().contains(foundItem)) {
                System.out.println("\nOh no you found a bear trap, you lost 20 points!");
                user1.itemFound(foundItem);
            }
            else{
                System.out.println("\nNo items were found here. You may have already explored this location...");
            }
        }
        return foundItem;
    }

    //Method to ask the user if they want to explore a location. If yes, the item is added to their inventory.
    public String exploreLocation(){
        String choice = "";
        String foundItem = "";

        while(!choice.equalsIgnoreCase("Yes") && !choice.equalsIgnoreCase("No")){
            System.out.printf("You reached the %s! Do you want to explore it? (Yes/No): ", currentLocation);
            Scanner scan2 = new Scanner(System.in);
            choice = scan2.next();
            if(choice.equalsIgnoreCase("Yes")){
                foundItem = locationItems();
            }
            else if(choice.equalsIgnoreCase("No")){
                System.out.printf("\nYou leave without exploring, you coward.");
            }
            else{
                System.out.println("Not a valid option, please try again.");
            }
        }
        return foundItem;
    }

}
