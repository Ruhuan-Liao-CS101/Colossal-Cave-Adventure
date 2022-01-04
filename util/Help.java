package util;

public class Help{

  //Class that consist of information that the user might want to know or reread from the gameplay

  public static String defaultHelpCommandMenu(){
    return "\nHere are some help commands that could help along the way! Please enter 1, 2, or 3 to access more" +
            " info or enter \"help\" at any time to see this menu again \n1. Get directions" +
            "\n2. Get Game Information \n3. Display Remaining Items \n4. Quit";
  }

  public static String getDirections(){
    return "You can go North, East, South, or West, casing doesnt matter";
  }

  public static String getGameInformation(){
    return "The objective of this game is to escape the dungeon. " +
            "In the process you will defeat monsters and solve puzzles. " +
            "\nIf you run out of health the monster will eat you to shreds. " +
            "The more health you have, the easier it is to escape. \nGood Luck! ";
  }
}