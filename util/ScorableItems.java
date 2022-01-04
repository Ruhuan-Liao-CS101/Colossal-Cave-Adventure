package util;

import java.util.*;

public class ScorableItems {
    private Map<String, Integer> items;

    public ScorableItems(){

        items = new HashMap<>();

        items.put("bracelet", 20);
        items.put("necklace", 20);
        items.put("gold bar", 20);
        items.put("sword", 20);
        items.put("bear trap", -20);

    }

    //Prints the undiscovered items that are remaining in the map
    public void displayCurrentItems(){

        Set<String> keys = items.keySet();
        Iterator<String> it = keys.iterator();

        while (it.hasNext()){
            String myKey = it.next();
            int n = items.get(myKey);
            System.out.println(myKey);
        }
    }

    //Returns the found item's point value and removes the item from the map of current remaining items
    public int getItem(String foundItem){

        int itemValue = 0;
        if(items.containsKey(foundItem.toLowerCase())){
            itemValue = items.get(foundItem);
            items.remove(foundItem);
        }
        return itemValue;
    }

}
