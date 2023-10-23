/**
 * This class implements a game environment
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */

package main;

import Battle.BattleManager;
import GUI.battleManagerScreen;
import GUI.mainScreen;
import GUI.setupScreen;
import GUI.shopScreen;
import GUI.viewInventory;
import GUI.viewTeamScreen;
import Items.*;
import Shop.Shop;
import monster.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * game environment class to run the game 
 * and implement functionality for the game
 */
public class gameEnvironment {
    /**
     * Initialize Variables and Constants
     */

    /**
     * The player object
     */
    Player player;
    /**
     * The inital monsters to choose from
     * at the start of the game
     */
    MonsterManager initialMonsters;
    /**
     * The enemy monsters 
     */
    MonsterManager enemyMonsters;
    /**
     *the shop items inventory
     */
    Inventory shopInventory;
    /**
     * New shop object
     */
    Shop shop;
    /**
     * Number of days in the game
     */
    Integer gameDays;
    /**
     * The current day
     */
    Integer currDay;
    /**
     * a battle
     */
    BattleManager battle;
    /**
     * the difficulty of the game
     */
    String difficulty = "";

    /**
     * if the player has battled or not
     */
    Boolean hasBattled = false;

    /**
     * if ramdom update happen add to the arraylist
     */
    ArrayList<String> ramdomUpdate;

    // Constants
    /**
     * Maximum number of the DAYS
     */
    private Integer MAXDAYS = 15;
    /**
     * Minimum number of the DAYS
     */
    private Integer MINDAYS = 5;
    /**
     * Game environment methods
     */

     /**
     * set the difficulty 
     * @param difficult difficulty of the game
     */
    public void setDifficulty(String difficult){
        difficulty = difficult;
    }
   /**
    * Get the difficulty 
    * 
    * @return difficulty Return the difficulty 
    */
    public String getDifficulty() {
       return difficulty;
    }

    /**
     * set the has battled boolean flag
     * @param battled boolean flag to set whether the player has battled or not
     */
    public void setHasBattled(Boolean battled){
        hasBattled = battled;
    }
   /**
    * Get the has battled boolean flag
    * 
    * @return hasBattled Return the has battled boolean flag
    */
    public Boolean getHasBattled() {
       return hasBattled;
    }

     /**
     * set the player object
     * @param newPlayer player object in the current game
     */
     public void setPlayer(Player newPlayer){
         player = newPlayer;
     }
    /**
     * Get the player object
     * 
     * @return player Return the player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the shop object
     * 
     * @return shop Return the shop object
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * set the shop object
     * 
     * @param newShop set the shop object
     */
    public void setShop(Shop newShop) {
        shop = newShop;
    }



    /**
     * Get the number of days in the game
     * 
     * @return gameDays Return number of days in the game
     */
    public Integer getGameDays() {
        return gameDays;
    }

    /**
     * Set the number of days in the game
     * 
     * @param days The number of days in the game
     */
    public void setGameDays(Integer days) {
        gameDays = days;
    }

    /**
     * Get the current day in the game
     * 
     * @return currDay Return the current day
     */
    public Integer getCurrentDay() {
        return currDay;
    }

    /**
     * Set the current day
     * 
     * @param currentDay The number of days in the game
     */
    public void setCurrentDay(Integer currentDay) {
        currDay = currentDay;
    }

    /**
     * Get the max days allowed
     * 
     * @return MAXDAYS Return the max days allowed in the game
     */
    public Integer getMaxDay() {
        return MAXDAYS;
    }

    /**
     * Get the min days allowed
     * 
     * @return MINDAYS Return the min days allowed in the game
     */
    public Integer getMinDay() {
        return MINDAYS;
    }

    /**
     * Get the initial monster list
     * 
     * @return initialMonsters Return the initial monster list
     */
    public MonsterManager getInitialMonsters() {
        return initialMonsters;
    }

    /**
     * Get the update that has accured in sleep method
     * 
     * @return ramdomUpdate  Return the update of ramdom event
     */
    public ArrayList<String> getRamdomUpdate(){
        return ramdomUpdate;
    }

    /**
     * Create the enemy monster list
     * 
     */
    public void createEnemyMonsterList() {
        battle = new BattleManager(player);
        ArrayList<Monster> monsters = new ArrayList<Monster>(Arrays.asList(
            new Erazor(),
            new Grizz(),
            new Mamba(),
            new Sparky(),
            new Thunder(),
            new Tyrone()
        ));
        enemyMonsters = new MonsterManager();
        for(Monster m : monsters){
            enemyMonsters.addMonster(m);
        }
        battle.setEmenyMonsterList(enemyMonsters);

    }

    /**
     * Get the current battleManager
     * 
     * @return battle Returns a battle manager object
     */
    public BattleManager getBattle() {
        return battle;
    }

    /**
     * create a monster lists full of enemy monsters
     * then generates opponent teams from that list
     */
    public void makeBattles(){
        createEnemyMonsterList();
        battle.generateOpponents();
    }


    /**
     * Setup the game environment
     * 
     */
    public void setup() {
        /**
         * Initialise the monster list for the player to choose from
         * at the start of the game
         */
        ArrayList<Monster> monsters = new ArrayList<Monster>(Arrays.asList(
            new Erazor(),
            new Grizz(),
            new Mamba(),
            new Sparky(),
            new Thunder(),
            new Tyrone()
        ));
        initialMonsters = new MonsterManager();
        for(Monster m : monsters){
            initialMonsters.addMonster(m);
        }
    }

    /**
     * Run the main game loop
     */
    public void main() {
        
        /**
         * Load shop with all the items
         * add monsters that the player does not have
         * to the shop
         */
        Item damage = new Damage();
        Item armour = new Armour();
        Item dodge = new Dodge();
        Item heal = new Heal();

        shopInventory = new Inventory();

        shopInventory.addItems(damage);
        shopInventory.addItems(armour);
        shopInventory.addItems(dodge);
        shopInventory.addItems(heal);

        shop = new Shop(shopInventory,initialMonsters);
        
         
    }

    /**
     * Sleep method
     * 
     * 
     */
    public void sleep() { 
        //set the new current day
        setCurrentDay(getCurrentDay() + 1);


        //ramdom update
        ramdomUpdate = new ArrayList<String>();

        /**
         * Gets all player monster and give monster monster health up if it down
         * and decided if fainted monster stays or leave 
         */
        ArrayList<Monster> removeMonster = new ArrayList<Monster>();

        for(Monster monster : player.getTeam().getMonsterList()){
            if(monster.getIsFainted()){
                Random rand = new Random();
                int random = rand.nextInt(4);

                if (random > 2){
                    removeMonster.add(monster);
                    
                }
            }
        }

        //remove
        for(Monster monster: removeMonster){
            if (player.getTeam().getMonsterList().size()> 1){
    
                player.getTeam().removeMonster(monster);
                shop.addMonster(monster);

                System.out.print("OHH NOOO!!! "+ monster.getMonsterName().toUpperCase()+" GAVE UP ON YOU\n");
                ramdomUpdate.add("OHH NOOO!!! "+ monster.getMonsterName().toUpperCase()+" GAVE UP ON YOU\n");
            }

        }

        //add new monster
        if (player.getTeam().getMonsterList().size()<player.getTeam().getMaxMonsterTeamSize()){
            Random rand = new Random();
            int random = rand.nextInt(4);
            if ((random > 2)){
                Monster monster = shop.removeMonster();
                System.out.println("SAY HELLO TO YOUR NEW MONSTER "+ monster.getMonsterName().toUpperCase());
                ramdomUpdate.add("SAY HELLO TO YOUR NEW MONSTER "+ monster.getMonsterName().toUpperCase());

                player.getTeam().addMonster(monster);
            }

        }

        //level up a monster
        // monster's attack damage will increase
        Random rand = new Random();
        int random = rand.nextInt(4);
        if (random > 2){
            Random randMonster = new Random();
            int randomMonster = randMonster.nextInt(player.getTeam().getMonsterList().size()-1);
            player.getTeam().getMonsterList().get(randomMonster).setMonsterAttackDamage(10.0);
            System.out.println(player.getTeam().getMonsterList().get(randomMonster).getMonsterName() + " has Leveled up");
            ramdomUpdate.add(player.getTeam().getMonsterList().get(randomMonster).getMonsterName() + " has Leveled up");
        }

        // add power to enemy team
        for(Monster monster : enemyMonsters.getMonsterList()){
            monster.setMonsterAttackDamage(10.0);
        }

        setHasBattled(false);

        

        // heal player team 
        for(Monster monster : player.getTeam().getMonsterList()){
            double max = monster.getMonsterMaxHealth();
            double curr = monster.getMonsterCurrentHealth();
            double add = max/2;

            if ((curr + add) <= max){
                monster.setMonsterCurrentHealth(curr + add);  
            } 
            else{
                monster.setMonsterCurrentHealth(max);
            }            
        }

    }

    /**
     * launch the setup screen
     */
    public void launchSetupScreen(){
        new setupScreen(this);
    }
    /**
     * Close the setup screen
     * and launch the main scren
     * @param setupWindow the setup window
     */
    public void closeSetupScreen(setupScreen setupWindow){
        setupWindow.closeWindow();
		launchMainScreen(); 
    }
    /**
     * launch the main screen window
     */
    public void launchMainScreen(){
        new mainScreen(this);
    }
    /**
     * close the main screen window
     * @param mainWindow mainWindow of the game
     */
    public void closeMainScreen(mainScreen mainWindow){
        mainWindow.closeWindow();
    }

    /**
     * launch the shop screen window
     */
    public void launchShopScreen(){
        new shopScreen(this);
        
    }

    /**
     * close the shop screen window
     * and launch the main screen window
     * @param shopWindow current shop window
     */
    public void closeShopScreen(shopScreen shopWindow){
        shopWindow.closeWindow();
        launchMainScreen(); 
    }

    /**
     * launch the inventory screen window
     */
    public void launchViewInventoryScreen(){
        new viewInventory(this);
    }
    /**
     * close the inventory screen window
     * and launch the main screen window
     * @param inventoryWindow current inventory window
     */
    public void closeViewInventoryScreen(viewInventory inventoryWindow){
        inventoryWindow.closeWindow();
        launchMainScreen(); 
    }

    /**
     * launch the view team screen window
     */
    public void launchViewTeamScreen(){
        new viewTeamScreen(this);
    }
    /**
     * close the view team screen Window
     * and launch the main team screen
     * @param teamWindow current team window
     */
    public void closeViewTeamScreen(viewTeamScreen teamWindow){
        teamWindow.closeWindow();
        launchMainScreen(); 
    }

    /**
     * Launch the battle manager screen window
     */
    public void launchBattleMangerScreen(){
        new battleManagerScreen(this);
    }
    /**
     * close the battle manager screen Window
     * and launch the main battle screen
     * @param battleManagerWindow current battle manager window
     */
    public void closeBattleMangerScreen(battleManagerScreen battleManagerWindow){
        battleManagerWindow.closeWindow();
        launchMainScreen(); 
    }

    /**
     * Main method for the game environment
     * @param args optional arguments
     */
    public static void main(String[] args){    
        gameEnvironment game = new gameEnvironment();
        game.launchSetupScreen();
    }
}
