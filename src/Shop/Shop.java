/**
 * This class implements the shop
 * 
 * 
 * @author Sudarshan Malla, Nathan Fronda
 * @version 1.0, 02/05/2022
 */

package Shop;


import java.util.Collections;

import Items.Inventory;
import Items.Item;
import main.Player;
import monster.Monster;
import monster.MonsterManager;

/**
 * Shop class ot handle 
 * buy and sell monsters and items
 */
public class Shop{

    /**
     * The list of all items
     */
    private Inventory shopInventory;

    /**
     * the list of all Monsters that the 
     * player is able to buy from the shop
     */
    private MonsterManager monsterShop;

    Player player;

    /**
     * Shop constructor
     * @param shopInventoryItems inventory object of items
     * @param monstersInShop inventory object of monsters
     */
    public Shop(Inventory shopInventoryItems, MonsterManager monstersInShop) {
        this.shopInventory = shopInventoryItems;
        this.monsterShop = monstersInShop;
    }

    /**
     * remove a monster from the shop
     * @return Monster
     */
    public Monster removeMonster(){
        Collections.shuffle(monsterShop.getMonsterList());
        Monster monster = monsterShop.getMonsterList().get(0);
        monsterShop.removeMonster(monster);
        return monster;

    }

    /**
     * add a monster to the shop
     * @param monster monster to be added to the shop
     */
    public void addMonster(Monster monster){
        monster.setMonsterCurrentHealth(monster.getMonsterMaxHealth());
        monsterShop.addMonster(monster);
    }

    /**
     * Reduces player's gold depending on item price
     * and adds the items into player's inventory
     * 
     * @param item item that will be bought
     * @param playerr player that the item will go too
     */
    public void buyItems(Item item, Player playerr){
        playerr.removeGold(item.getPrice());
        playerr.addItem(item);
    }

    /**
     * Remover the items from player's inventory and 
     * add the gold back to player's gold collection
     * player will only get 80% of gold 
     * they spent on the item back
     * @param item item that will be sold
     * @param playerr player where the item will be taken from
     */
    public void sellItems(Item item, Player playerr){
        playerr.removeItem(item);
        playerr.addGold(item.getPrice()*0.8); // player will only get 80% of gold back
    }

    /**
     * Reduces player's gold deppending on monster price
     * and adds the monster into player's monster collection
     * @param monster monster that wll be bought
     * @param playerr player that the monster will go too
     */
    public void buyMonster(Monster monster, Player playerr){
        monsterShop.removeMonster(monster);
        playerr.removeGold(monster.getMonsterPriceValue());
        playerr.addMonster(monster);
    }

    /**
     * Remover the monster from player's monster collection and 
     * add the gold back to player's gold collection
     * player will only get 80% of gold 
     * they spent on the monster back
     * @param monster monster that will be sold
     * @param playerr player that the monster will be taken out of
     */
    public void sellMonster(Monster monster, Player playerr){
        playerr.removeMonster(monster);
        playerr.addGold(monster.getMonsterPriceValue()*0.8); // player will only get 80% of gold back
        monsterShop.addMonster(monster); // add monster back to the shop
    }

    /**
     * Get the item inventory
     * 
     * @return shopInventory 
     */
    public Inventory getShopItems(){
        return shopInventory;
    }

    /**
     * Get the item inventory
     * 
     * @return shopInventory 
     */
    public MonsterManager getMonsterInventory(){
        return monsterShop;
    }


}