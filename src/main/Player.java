/**
 * This class implements a player
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */

package main;

import Items.Inventory;
import Items.Item;
import monster.Monster;
import monster.MonsterManager;

/**
 * Player class to handle the player
 * and the details
 */
public class Player {
    /**
     * Initialize Variables and Constants
     */

    /**
     * The name of the player
     */
    private String playerName;
    /**
     * The players gold
     */
    private Double playersGold;
    /**
     * Gold gained during the game
     */
    private Double goldGained;
    /**
     * The players score
     */
    private Integer playersScore;
    /**
     * The players monster team
     */
    private MonsterManager monsterTeam;
    /**
     * The players inventory
     */
    private Inventory playerInventory;

    /**
     * Player constructor
     * @param name name of the player
     * @param gold gold of the player
     * @param score score of the player
     * @param team the players monster team
     * @param initialGold the initial gold of the player
     */
    public Player(String name, double gold, int score, MonsterManager team, double initialGold) {
        this.playerName = name;
        this.playersGold = gold;
        this.playersScore = score;
        this.monsterTeam = team;
        this.playerInventory = new Inventory();
        this.goldGained = initialGold;
    }

    /**
     * Player methods
     */

    /**
     * Get the player's names
     * 
     * @return playerName Return the name of the player
     */
    public String getName() {
        return playerName;
    }

    /**
     * Set the player's names
     * 
     * @param player The name of the player
     */
    public void setName(String player) {
        playerName = player;
    }

    /**
     * Get the player's inventory
     * 
     * @return Return the inventory of the player
     */
    public Inventory getInventory() {
        return playerInventory;
    }

    /**
     * Add items to the inventory
     * 
     * @param newItem item to be added to the inventory 
     */
    public void addItem(Item newItem) {
        playerInventory.addItems(newItem);
    }

    /**
     * Remove items from the inventory
     * 
     * @param removeItem item to be removed from the inventory 
     */
    public void removeItem(Item removeItem) {
        playerInventory.removeItems(removeItem);
    }

    /**
     * Get the players gold
     * 
     * @return playersGold, return the players gold
     */
    public double getGold() {
        return playersGold;
    }

    /**
     * Add gold to the players gold
     * 
     * @param addGold gold to add to the players gold
     */
    public void addGold(double addGold) {
        playersGold += addGold;
    }

    /**
     * Remove gold from the players gold
     * 
     * @param removeGold gold to be removed from the players gold
     */
    public void removeGold(double removeGold) {
        playersGold -= removeGold;
    }

    /**
     * Get the players gold 
     * gained throughout the game
     * 
     * @return goldGained, return the players gold gained
     */
    public double getGoldGained() {
        return goldGained;
    }

    /**
     * Add gold gained
     * to the players gold
     * 
     * @param gold gold to add to the players gold
     */
    public void addGoldGained(double gold) {
        goldGained += gold;
    }

    /**
     * Get the players score
     * 
     * @return playerScore, return the players score
     */
    public int getScore() {
        return playersScore;
    }

    /**
     * Increase the players score
     * 
     * @param addScore score to be added to the players score
     */
    public void addScore(int addScore) {
        playersScore += addScore;
    }

    /**
     * Get the players monster team
     * 
     * @return MonsterManager, return the players monster team
     */
    public MonsterManager getTeam() {
        return monsterTeam;
    }

    /**
     * Add monster to the players team
     * 
     * @param newMonster to be added to the players team 
     */
    public void addMonster(Monster newMonster) {
        monsterTeam.addMonster(newMonster);
    }

    /**
     * remove monster to the players team
     * 
     * @param removeMonster to be added to the players team 
     */
    public void removeMonster(Monster removeMonster) {
        monsterTeam.removeMonster(removeMonster);
    }

}
