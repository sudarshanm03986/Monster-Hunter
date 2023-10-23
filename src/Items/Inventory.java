/**
 * This class implements the monster manager
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */

package Items;

import java.util.ArrayList;

/**
 * Inventory class to hold items
 */
public class Inventory {
    /**
     * Initialize Variables and Constants
     */

     /**
      * Monster list to hold a players monster team
      */
    private ArrayList<Item> itemsList = new ArrayList<Item>();

    //Constants
    /**
     * Maximum monster team size
     */
    private final Integer MAXITEMS = 4;
    /**
     * Minmum monster team size
     */
    private final Integer MINITEMS = 0;

    /**
     * Inventory constructor
     */
    public Inventory() {
    }

    /**
     * MonsterMangager methods
     */

    /**
     * Get the item list 
     * 
     * @return itemsList
     */
    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    /**
     * Add item to the item list
     * 
     * @param item item to be added to the inventory 
     */
    public void addItems(Item item) {
        itemsList.add(item);
    }

    /**
     * Remove item from the item list
     * 
     * @param item item to be removed from the inventory 
     */
    public void removeItems(Item item) {
        if (itemsList.contains(item)) {
			itemsList.remove(item);
		}
    }

    /**
     * Get the max number of items in the player inventory
     * 
     * @return MAXITEMS Return the max number of items in the player inventory
     */
    public Integer getMaxItems() {
        return MAXITEMS;
    }

    /**
     * Get the min number of items in the player inventory
     * 
     * @return MINITEMS Return the min number of items in the player inventory
     */
    public Integer getMinItems() {
        return MINITEMS;
    }

}
