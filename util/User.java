package util;

import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

public class User{

  private String name;
  private int score;
  private int health;

  private List<String> foundItems = new ArrayList<>();
  private ScorableItems allItems = new ScorableItems();

  public User(){

    name = " ";
    score = 0;
    health = 50;
  }

  //Sets user's name
  public void setName(String name){

    this.name = name;
  }

  //Returns user's name
  public String getName(){

    return name;
  }

  //Return's user's current score
  public int getScore(){

    return score;
  }

  //Update's user's score
  private void updateScore(int points){
    score += points;
  }

  //Return's user's current health
  public int getHealth(){

    return health;
  }

  //Returns the list of the items that the user has found
  public List getFoundItems(){
    return foundItems;
  }

  //Returns the undiscovered items that are remaining in the map
  public void getCurrentItems(){
    allItems.displayCurrentItems();
  }

  //Prints the items that the user has found
  public void displayFoundItems(){
    System.out.println("\nYour current items: ");
    for(String item: foundItems){
      System.out.print(item + ", ");
    }
  }

  //Update's user's score and list of found items based on the found item. Also removes the item from the map
  //of remaining items
  public void itemFound(String item){
    foundItems.add(item);
    int itemPoints = allItems.getItem(item);
    updateScore(itemPoints);
  }


}
