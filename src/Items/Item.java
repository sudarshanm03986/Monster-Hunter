/**
 * This class implements items
 * 
 * @author Sudarshan Malla, Nathan Fronda
 * @version 1.0, 02/05/2022
 */

package Items;

import monster.Monster;

/**
 * abstract class for items
 * each item has a different use ability
 */
 public abstract class Item {
    /**
     * The name of the item
     */
    String nameItems;

    /**
     * The description of items
     */
    String descripsionOfItem;
    /**
     * The price of items
     */
    Double priceItems;

    /**
     * Abstract class for each item
     * has different uses
     * @param monster monster that will use the item
     */
    public abstract void useItems(Monster monster);


    /**
     * set the item nameItems and descriptionsOfItem and priceItems
     * 
     * @param name name of the item
     * @param description description of the item
     * @param price price of the item
     */
    public Item(String name, String description, double price){
        nameItems = name;
        descripsionOfItem = description;
        priceItems = price;
    }

    /**
     * Get the name of the item
     * 
     * @return nameItems 
     */
    public String getItemName(){
        return nameItems;
    }

    /**
     * Get the description of the item
     * 
     * @return descripsionOfItem
     */
    public String getDescription() {
        return descripsionOfItem;
    }

    /**
     * Get the price of the item
     * 
     * @return priceItems
     */
    public double getPrice() {
        return priceItems;
    }

    public String toString(){
        return nameItems;
    }

 }