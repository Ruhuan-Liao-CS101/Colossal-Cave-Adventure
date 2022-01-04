package app;
import java.util.Scanner;

import util.Help;
import util.Location;
import util.User;

public class App {

  public static void main(String[] args) {
    //Game introduction dialogue
    System.out.println();
    System.out.println("________________________________________________");


    System.out.println("Welcome to Dungeon Escape! The objective of this game is to escape the dungeon. " +
            "\nIn the process you will try to find items. Some items give you points and some make you lose points. " +
            "Once you have 50 points you will fight a monster.\nGood Luck! ");

    //Creating user and setting name of user
    Scanner scan = new Scanner(System.in);
    String name;
    System.out.print("\nEnter your name to continue: ");
    name = scan.nextLine();
    User user1 = new User();
    user1.setName(name);

    System.out.println("Welcome " + user1.getName() + ", nice to meet you! Best of luck once more!");

    System.out.println("As of starting this game you have " + user1.getScore() + " points");

    System.out.println(Help.defaultHelpCommandMenu());
    System.out.println("\n{0,0,0,0}\n{0,1,0,0}\n{0,0,0,0}");
    System.out.println("Your location is 1");


    //Creating a user location object that displays map and handles user interaction
    Location user1Location = new Location();
    user1Location.move();


  }
}