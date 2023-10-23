package main;
import monster.*;

import java.util.Scanner;

import Battle.Battle;
import Battle.BattleManager;
import Battle.Opponent;
import Items.Inventory;
import Items.Item;


/**
 * This class implements the COmmand Line
 * 
 * @author Sudarshan Malla, Nathan Fronda
 * @version 1.0, May 2022
 */

/**
 * Command line game
 */
public class CommandLineInterface {
    gameEnvironment game = new gameEnvironment();

    Scanner sc = new Scanner(System.in);

    String boarder = "####################################";

    String dificult = null;

    /**
     * Setup method which
     * setups the game
     */
    public void setup(){
        game.setup();
        /**
         * Get the name of the Player
         */
        System.out.println("What is your name? ");
        String playerName = sc.nextLine();
        
        //Check whether or not the players name is between 3 and 15 characters
        while (playerName.length() < 3 || playerName.length() > 15 || !playerName.matches("[A-Za-z]+")){
            System.out.println("Sorry, your player name has to be between 3 and 15 characters.");
            System.out.println("What is your name? ");
            playerName = sc.nextLine();
        }






        /**
         * Get how many day the player wants to play 
         */

        System.out.println("How many days would you like to play? ");
        String inputDays = sc.nextLine();

        //check whether or not the total days chosen to play is between 5 and 15
        //IF user put invalid input it sends a message and ask them to input again.
        while (inputDays.matches(".*[a-zA-Z].*") || inputDays.isEmpty()||Integer.parseInt(inputDays) > game.getMaxDay() || Integer.parseInt(inputDays) < game.getMinDay()){
            System.out.println("Please enter a valid integer between 5 and 15");
            System.out.println("How many days would you like to play");
            inputDays = sc.nextLine();
        }

        //set the game.gameDay for the game enviroment
        game.setGameDays(Integer.parseInt(inputDays));






        /**
         * Give the player 1000 gold to start with
         * Show options of monster that is avaiable.
         * monster options (1-lenght or initial monster list)
         * Adds the monster to playerMonsterTeam
         */

        int gold = 1000;
        MonsterManager playerMonsterTeam = new MonsterManager();

        //1000 gold message
        System.out.println(boarder);
        System.out.println("CONGRATS YOU HAVE BEEN REWARDED "+ gold + " GOLD");
        System.out.println(boarder);
        
        //gotMonster contorl the while loop
        //gotMonster will be assigend true after the player has one or more mosnterand selected the done option
        boolean gotMonster = false;
        while(gotMonster != true){

            int count = 0;

            System.out.println("CHOOSE YOUR MONSTER\n" + "YOUR BAlANCE: $" + gold +"\n"
             );

            //print the monsters
            for (Monster monster : game.initialMonsters.getMonsterList()){
                count += 1;
                System.out.println(count + " : " + monster.getMonsterName());
                System.out.println("--> $" + monster.getMonsterPriceValue());
                System.out.println("--> Damage: " + monster.getMonsterAttackDamage());
                System.out.println("--> Heal: " + monster.getMonsterHealAmount());
                System.out.println("--> Health: " + monster.getMonsterCurrentHealth());
                System.out.println("");

                
            }
            
            //check if player has atleast one monster in playerTeamMonster
            boolean isTeamEmpty = false;
            if (!playerMonsterTeam.getMonsterList().isEmpty()){
                isTeamEmpty = true;
                count += 1;
               
                System.out.println(count + " : Done");
            }

            // get option
            String input = sc.nextLine();

            // check if input is invalid 
            if (input.matches(".*[a-zA-Z].*") || Integer.parseInt(input) <= 0 || Integer.parseInt(input) > count){

                System.out.print("SORRY YOU HAVE ENTERED A INVALID INPUT!!");
                System.out.println("");
            }

            // check if player has selected "Done"
            else if (Integer.parseInt(input) == count && isTeamEmpty){
                gotMonster = true;
                System.out.println("");
            }

            //get the monster that player has selelectd
            else {
                //check if player has enough gold to purchase the monster
                int selectedMonster = Integer.parseInt(input);
                if ((gold - game.initialMonsters.getMonsterList().get(selectedMonster -1).getMonsterPriceValue()) >= 0){
                    Monster selected = game.initialMonsters.getMonsterList().get(selectedMonster -1);
                    boolean gotNameMonster = false;

                    //check if player want to change monster name
                    while (gotNameMonster != true){
                        System.out.println("WOULD LIKE TO NAME YOUR MONSTER ?\n1 : YES\n2 : NO");
                        String inputCommand = sc.nextLine();
                        boolean acceptInput = inputCommand.matches(".*[a-zA-Z].*");
                        
                        //change monster name 
                        if (!acceptInput && Integer.parseInt(inputCommand) == 1 ){
                            System.out.println("What would you like to name your monster");
                            String nameMonster = sc.nextLine();
                            System.out.println(selected.getMonsterName() +" Monster name is " + nameMonster + " :)");
                            selected.setMonsterName(nameMonster);
                            gotNameMonster = true;
                
                        }

                        //print message if player decide not to change monster name
                        else if (!acceptInput && Integer.parseInt(inputCommand) == 2){
                            gotNameMonster = true;
                            System.out.println("NO name for your monster :(");
                        }

                        // if the player input invalid input
                        else{
                            System.out.println("Sorry not a valid input >:");
                        }
                    }

                    //add the monster to player playerMonsterTeam
                    playerMonsterTeam.addMonster(selected);

                    //update the gold
                    gold -= game.initialMonsters.getMonsterList().get(selectedMonster -1).getMonsterPriceValue();

                    //remove monster from the initail monster
                    game.initialMonsters.removeMonster(selected);

                }

                // send a message when player do not have enough gold
                else {

                    System.out.println("Sorry you do not have enough gold");
                    System.out.println("");
                }
            }
        }


        

       /**
        * Set dificulty
        */
        // dificult has to be assiend to EASY or HARD to continue
        
        
        // check if dificult is NULL or not 
        while (dificult == null){

            // give player option
            System.out.println("CHOOSE YOUR DIFICULTY");
            System.out.println("1 : EASY");
            System.out.println("2 : HARD");
            String gameDifficult = sc.nextLine();

            //check for invalid input
            if (!gameDifficult.matches(".*[a-zA-Z].*")){
                //check if player selcted EASY
                if (Integer.parseInt(gameDifficult) == 1){
                    dificult = "EASY";
                    }
                //check if player selcted HARD
                if (Integer.parseInt(gameDifficult) == 2){
                    dificult = "HARD";
                    }
            }
        }  
    
    
        /**
         * Create a player and set the game.player for the game enviroment
         */
       game.player = new Player(playerName, gold, 0, playerMonsterTeam,0.0);

       System.out.println("");

       
    }   
    
    /**
     * Main method to run the main 
     * part of the game
     */
    public void main() {
        game.main();
        
        boolean hasBattled = false;

        game.createEnemyMonsterList();
        BattleManager battleManager = game.getBattle();
        battleManager.generateOpponents();


        String input;
        game.setCurrentDay(1);
        //loop for the main interface menus 
        while (game.getCurrentDay() <= game.getGameDays()){
            
            //introdution
            System.out.println(boarder);
            System.out.println("WELCOME TO MONSTER GAME PLAYER -> " + game.player.getName());
            System.out.println(boarder);
            System.out.println("Score : " + game.player.getScore()  +"   GOLD : " + game.player.getGold()  +"   Day : " +game.getCurrentDay() +"/" + game.getGameDays() + "   " );
            System.out.println(boarder);
            System.out.println("");

            //option 
            System.out.print("1 : VISIT SHOP\n");
            System.out.print("2 : VIEW INVENTORY\n");
            System.out.print("3 : VIEW TEAM\n");
            System.out.print("4 : BATTLE\n");
            System.out.print("5 : SLEEP\n");

            input = sc.nextLine();
            
            if (!input.matches(".*[a-zA-Z].*")&& !input.isEmpty()){ 
                switch (Integer.parseInt(input)){
                    //shop
                    case 1:
                        //to stop the loop to exit shop menu
                        boolean shopExit = false;
                        //loop
                        while(shopExit != true){
                            System.out.println("\nWELCOME TO MONSTER SHOP\n");
                            System.out.println("1 : BUY ITEMS\n2 : SELL ITEMS\n3 : BUY MONSTERS\n4 : SELL MONSTERS\n5 : EXIT");
                            String inputCommandShop = sc.nextLine();

                            if (!inputCommandShop.matches(".*[a-zA-Z].*")&& !inputCommandShop.isEmpty() && (Integer.parseInt(inputCommandShop) >= 1 && Integer.parseInt(inputCommandShop) <= 5)){

                                // get the shop monster and items
                                MonsterManager shopMonster = game.shop.getMonsterInventory();
                                Inventory shopItem = game.shop.getShopItems();

                                //player monster and items
                                MonsterManager playerMonster = game.player.getTeam();
                                Inventory playerItem = game.player.getInventory();

                            
                                switch (Integer.parseInt(inputCommandShop)){

                                    //buy items 
                                    case 1:
                                        //show what is in stock for item and have number on them so player can pick
                                        System.out.println("\nITEMS WE HAVE IN STOCK !!! \nYOUR BALANCE : " + game.player.getGold());
                                        int count = 0;
                                        for (Item item : shopItem.getItemsList()){
                                            count += 1;
                                            System.out.println("--------------------------------"+count+"------------------------------");
                                            System.out.println("NAME : " + item.getItemName());
                                            System.out.println("DICRIPTION : " + item.getDescription());
                                            System.out.println("COST : $" + item.getPrice());
                                            System.out.println("----------------------------------------------------------------");
                                        }

                                        //give player some option to pick from
                                        System.out.println("\n1 : Buy Items\n2 : Exit");
                                        String commandShopItem = sc.nextLine();

                                        //check if player want to buy any item or not
                                        if (!commandShopItem.matches(".*[a-zA-Z].*")&& !commandShopItem.isEmpty() && Integer.parseInt(commandShopItem) == 1){
                                            // get what item player would want
                                            System.out.println("\nWHICH ITEM WOULD YOU LIKE TO BUY?");
                                            String innerCommandShopItem = sc.nextLine();

                                            // check If invalid input
                                            if (!innerCommandShopItem.matches(".*[a-zA-Z].*")&& !innerCommandShopItem.isEmpty() && Integer.parseInt(innerCommandShopItem) <= count && Integer.parseInt(innerCommandShopItem) >= 1){
                                                int intinnerCommandShopItem = Integer.parseInt(innerCommandShopItem);
                                                Item itemPicked = shopItem.getItemsList().get(intinnerCommandShopItem-1);

                                                // check if player has enough gold
                                                if((game.player.getGold() - itemPicked.getPrice()) >= 0){
                                                    game.shop.buyItems(itemPicked, game.player);
                                                    System.out.println("YOUR HAVE PURCHASED " + itemPicked.getItemName());
                                                }
                                                else{
                                                    System.out.println("Sorry not enought of gold");
                                                }
                                        
                                            }  
                                            // send message if invalid input
                                            else{
                                                System.out.println("SORRY INVALID INPUT TRYAGAIN");
                                                }
                                        }
                                        // exit
                                        else if (!commandShopItem.matches(".*[a-zA-Z].*")&& !commandShopItem.isEmpty() && Integer.parseInt(commandShopItem) == 2){
                                                
                                        }
                                        // invalid input message
                                        else{
                                                System.out.println("SORRY INVALID INPUT TRYAGAIN");
                                        }
                                        break;


                                    //sell items
                                    case 2:
                                        //check if there is any item in player inventroy
                                        if(playerItem.getItemsList().size() > 0){
                                            
                                            //check if player want to exit
                                            boolean exitSellItems = false;
                                            while(exitSellItems != true){

                                                //Introduction
                                                System.out.println("WHICH ITEM WOULD YOU LIKE TO SELL");
                                                System.out.println("YOU HAVE $"+ game.player.getGold() + "\n");
                                                int sellItemCount = 0;

                                                // show the option of items that can be sold from player inventory
                                                for(Item item : playerItem.getItemsList()){
                                                    sellItemCount += 1;
                                                    System.out.println("-------"+sellItemCount+"-------");
                                                    System.out.println("NAME : " + item.getItemName());
                                                    System.out.println("SELL : $" + item.getPrice()*0.8);
                                                    System.out.println("---------------------");
                                                }
                                                
                                                // exit option
                                                System.out.println("------"+(sellItemCount+1)+"------");
                                                System.out.println("  EXIT");
                                                System.out.println("--------------------\n");

                                                //command input
                                                String commandSellItem = sc.nextLine();

                                                // check if command input is valid
                                                if(!commandSellItem.matches(".*[a-zA-Z].*")&& !commandSellItem.isEmpty()){

                                                    //exit
                                                    if (Integer.parseInt(commandSellItem) == (sellItemCount+1)){
                                                        exitSellItems = true;
                                                    }

                                                    //sell
                                                    else if(Integer.parseInt(commandSellItem) > 0 && Integer.parseInt(commandSellItem) <= sellItemCount){
                                                        game.shop.sellItems(playerItem.getItemsList().get(Integer.parseInt(commandSellItem)-1), game.player);
                                                    }
                                                }
                                                // if INVALID send a message
                                                else {
                                                    System.out.println("SORRY INVALID INPUT");
                                                }
                                            }



                                        }
                                        else{
                                            System.out.println("SORRY THERE IS NOTHING IN YOUR INVENTORY");
                                        }
                                        break;


                                    //buy monsters
                                    case 3:
                                        //check if player has reached its max team size
                                        if (game.player.getTeam().getMaxMonsterTeamSize() > game.player.getTeam().getMonsterList().size()){
                                            //show what is in stock for monster and have number on them so player can pick
                                            System.out.println("\nMONSTER WE HAVE IN STOCK !!! \nYOUR BALANCE : " + game.player.getGold());
                                            int countMonster = 0;
                                            for (Monster monster : shopMonster.getMonsterList() ){
                                                countMonster += 1;
                                                System.out.println("--------------------------------"+countMonster+"------------------------------");
                                                System.out.println("NAME : " + monster.getMonsterName());
                                                System.out.println("COST : $" + monster.getMonsterPriceValue());
                                                System.out.println("ATTACK : " + monster.getMonsterAttackDamage());
                                                System.out.println("HEAL : " + monster.getMonsterHealAmount());
                                                System.out.println("HEALTH : " + monster.getMonsterCurrentHealth() +"/"+ monster.getMonsterMaxHealth());
                                                System.out.println("----------------------------------------------------------------");
                                            }
    
                                            //give player some option to pick from
                                            System.out.println("\n1 : BUY MONSTER\n2 : Exit");
                                            String commandShopMonster = sc.nextLine();
    
                                            //check if player want to buy any Monster or not
                                            if (!commandShopMonster.matches(".*[a-zA-Z].*")&& !commandShopMonster.isEmpty() && Integer.parseInt(commandShopMonster) == 1){
                                                // get what monster player would want
                                                System.out.println("\nWHICH MONSTER WOULD YOU LIKE TO BUY?");
                                                String innerCommandShopMonster = sc.nextLine();
    
                                                // check If invalid input
                                                if (!innerCommandShopMonster.matches(".*[a-zA-Z].*")&& !innerCommandShopMonster.isEmpty() && Integer.parseInt(innerCommandShopMonster) <= countMonster && Integer.parseInt(innerCommandShopMonster) >= 1){
                                                    int intinnerCommandShopMonster = Integer.parseInt(innerCommandShopMonster);
                                                    Monster monsterPicked = shopMonster.getMonsterList().get(intinnerCommandShopMonster-1);
    
                                                    // check if player has enough gold
                                                    if((game.player.getGold() - monsterPicked.getMonsterPriceValue()) >= 0){
                                                        System.out.print("WOULD YOU LIKE TO NAME " + monsterPicked.getMonsterName() + "\n");
                                                        System.out.println("1 : YES\n2 : NO");
                                                        String nameMonster = sc.nextLine();
                                                        if (!nameMonster.matches(".*[a-zA-Z].*")&& !nameMonster.isEmpty() && (Integer.parseInt(nameMonster) == 1 || Integer.parseInt(nameMonster) == 2)){
                                                            if(Integer.parseInt(nameMonster) == 1){
                                                                
                                                                boolean hasName = false;
                                                                while (hasName != true){
                                                                    System.out.print("What would you like to name " + monsterPicked.getMonsterName()+ "\n");
                                                                    nameMonster = sc.nextLine();
                                                                    if(!nameMonster.isEmpty()){
                                                                        monsterPicked.setMonsterName(nameMonster);
                                                                        hasName = true;
                                                                    }
                                                                    else{
                                                                        System.out.println("INVALID INPUT");
                                                                    }
                                                                }
                                                                
                                                            }

                                                            game.shop.buyMonster(monsterPicked, game.player);
                                                            System.out.println("YOUR HAVE PURCHASED " + monsterPicked.getMonsterName());
                                                            battleManager.generateOpponents();
                                                        }
                                                        

                                                    }
                                                    else{
                                                        System.out.println("Sorry not enought of gold");
                                                    }
                                            
                                                }  
                                                // send message if invalid input
                                                else{
                                                    System.out.println("SORRY INVALID INPUT TRYAGAIN");
                                                    }
                                            }
                                            // exit
                                            else if (!commandShopMonster.matches(".*[a-zA-Z].*")&& !commandShopMonster.isEmpty() && Integer.parseInt(commandShopMonster) == 2){
                                                    
                                            }
                                            // invalid input message
                                            else{
                                                    System.out.println("SORRY INVALID INPUT TRYAGAIN");
                                            }
                                        }
                                        //let user know that they have reached their limit to buy monster
                                        else{
                                            System.out.println("SORRY YOU CAN'T HAVE MORE THEN "+ game.player.getTeam().getMaxMonsterTeamSize());
                                        }
                                          break;



                                    //sell monster
                                    case 4:

                                        //check if player want to exit
                                        boolean exitSellMonster = false;
                                        while(exitSellMonster != true){

                                            //check if there is any item in player monster team
                                            if(playerMonster.getMonsterList().size() > 1){
                                            
                                                //Introduction
                                                System.out.println("WHICH MONSTER WOULD YOU LIKE TO SELL");
                                                System.out.println("YOU HAVE $"+ game.player.getGold() + "\n");
                                                int sellMonsterCount = 0;

                                                // show the option of items that can be sold from player monster team
                                                for(Monster monster : playerMonster.getMonsterList()){
                                                    sellMonsterCount += 1;
                                                    System.out.println("-------"+sellMonsterCount+"-------");
                                                    System.out.println("NAME : " + monster.getMonsterName());
                                                    System.out.println("SELL : $" + monster.getMonsterPriceValue()*0.8);
                                                    System.out.println("---------------------");
                                                }
                                                
                                                // exit option
                                                System.out.println("------"+(sellMonsterCount+1)+"------");
                                                System.out.println("   EXIT");
                                                System.out.println("--------------------\n");

                                                //command input
                                                String commandSellMonster = sc.nextLine();

                                                // check if command input is valid
                                                if(!commandSellMonster.matches(".*[a-zA-Z].*")&& !commandSellMonster.isEmpty()){

                                                    //exit
                                                    if (Integer.parseInt(commandSellMonster) == (sellMonsterCount+1)){
                                                        exitSellMonster = true;
                                                    }

                                                    //sell
                                                    else if(Integer.parseInt(commandSellMonster) > 0 && Integer.parseInt(commandSellMonster) <= sellMonsterCount){
                                                        game.shop.sellMonster(playerMonster.getMonsterList().get(Integer.parseInt(commandSellMonster)-1), game.player);
                                                        exitSellMonster = true;  
                                                        battleManager.generateOpponents();
                                                    }
                                                }
                                                // if INVALID send a message
                                                else {
                                                    System.out.println("SORRY INVALID INPUT");
                                                }
                                            }  
                                            //send a message if player try to sell their last monster 
                                            else {
                                                System.out.println("SORRY YOU ONLY HAVE ONE MONSTER");
                                                exitSellMonster = true;   
                                            }
                                        }



                                         
                                    
                                        break;
                                    
                                    // exit to  main screen 
                                    case 5:
                                        shopExit = true;
                                        break;

                                }
                            }
                        }
                        break;

                    //Inventory
                    case 2:
                        // get player inventory
                        Inventory playerInventory = game.player.getInventory();
                        MonsterManager playerMonster = game.player.getTeam();

                        //Loop for the option
                        boolean exitInventory = false;
                        while (exitInventory != true){
                            //check if player has items in player inventory
                            if (playerInventory.getItemsList().size() > 0){
                                
                                //title
                                System.out.println("\n----YOUR INVENTORY----\n");
                                int count = 0;

                                //list of item
                                for (Item item :playerInventory.getItemsList()){
                                    count += 1;
                                    System.out.println("----------"+ count +"----------");
                                    System.out.println("NAME : "+ item.getItemName());
                                    System.out.println("DISCRIPTION : "+ item.getDescription());
                                    System.out.println("---------------------");
                                }

                                //option
                                System.out.println("1 : USE ITEMS\n2 : EXIT");
                                String commandInventory = sc.nextLine();

                                //check if command is valid
                                if (!commandInventory.matches(".*[a-zA-Z].*")&& !commandInventory.isEmpty()){
                                    //exit
                                    if (Integer.parseInt(commandInventory) == 2){
                                        exitInventory = true ;
                                    }
                                    //Use Item
                                    else if (Integer.parseInt(commandInventory) == 1){
                                        System.out.println("WHICH ITEM YOU WOULD LIKE TO USE");
                                        String innerCommandInventory = sc.nextLine();
                                        //check if command is valid
                                        if (!innerCommandInventory.matches(".*[a-zA-Z].*")&& !innerCommandInventory.isEmpty()&& Integer.parseInt(innerCommandInventory) > 0 && Integer.parseInt(innerCommandInventory) <= count){
                                            //get the item that user picked
                                            Item item = playerInventory.getItemsList().get(Integer.parseInt(innerCommandInventory)-1);
                                            
                                            //choose which monster the item get used on
                                            System.out.println("WHICH MONSTER WOULD YOU LIKE TO USE THE ITEM ON");
                                            int monsterCount = 0;

                                            // print all user monster
                                            for(Monster monster : playerMonster.getMonsterList()){
                                                monsterCount += 1;
                                                System.out.println("---------"+ monsterCount + "---------");
                                                System.out.println("NAME : " + monster.getMonsterName());
                                                System.out.println("FAINTED : " + monster.getIsFainted());
                                                System.out.println("DAMAGE : " + monster.getMonsterAttackDamage());
                                                System.out.println("ARMOUR : " + monster.getHasArmour());
                                                System.out.println("DODGE : " + monster.getHasDodge());
                                                System.out.println("HEAL : " + monster.getMonsterHealAmount());
                                                System.out.println("HEALTH : " + monster.getMonsterCurrentHealth()+ "/" + monster.getMonsterMaxHealth());
                                                System.out.println("--------------------");

                                            }
                                            
                                            String chooseMonsterCommand = sc.nextLine();
                                            //check if command is valid
                                            if (!chooseMonsterCommand.matches(".*[a-zA-Z].*")&& !chooseMonsterCommand.isEmpty()&& Integer.parseInt(chooseMonsterCommand) > 0 && Integer.parseInt(chooseMonsterCommand)  <= monsterCount){
                                                // get the monster user picked
                                                Monster pickedMonster = playerMonster.getMonsterList().get(Integer.parseInt(chooseMonsterCommand)-1);
                                                //use the item in monster
                                                item.useItems(pickedMonster);
                                                // remove the item of player inventory
                                                playerInventory.removeItems(item);

                                            }
                                            //print invalid input
                                            else {

                                                System.out.println("INVALID INPUT");
                                            }

                                        }
                                        //print invalid input
                                        else{
                                            System.out.println("INVALID INPUT");
                                        }



                                    }
                                }
                            }
                            //if there is nothing in player inventory 
                            else {
                            System.out.println("\nYOU HAVE NOTHING IN YOU INVENTORY\n");
                            exitInventory = true;
                            }
                        }
                            

            
                        
                        break;

                    //Team
                    case 3:
                        /**
                         * Display all the monster team and their information in order.
                         * option to change the order around if the monster team.
                         */

                        //get all the monster team in team variable
                        MonsterManager team = game.player.getTeam();

                       

                        //check if it player wants to retrun to main scrren 
                        boolean finishWithTeam = false;
                        while (finishWithTeam != true){

                            int count = 0;
                            System.out.println("---YOUR MONSTER---\n");
                            //dispaly the team with their Placement
                            for(Monster monster :team.getMonsterList()){
                                count += 1;
                                System.out.println("---------"+ count + "---------");
                                System.out.println("NAME : " + monster.getMonsterName());
                                System.out.println("DAMAGE : " + monster.getMonsterAttackDamage());
                                System.out.println("ARMOUR : " + monster.getHasArmour());
                                System.out.println("DODGE : " + monster.getHasDodge());
                                System.out.println("HEAL : " + monster.getMonsterHealAmount());
                                System.out.println("FAINTED : " + monster.getIsFainted());
                                System.out.println("HEALTH : " + monster.getMonsterCurrentHealth() + "/" + monster.getMonsterMaxHealth());
                                System.out.println("-------------------");
                                System.out.println("");
                            }

                            // Display option for player to choose from
                            System.out.println("1 : CHANGE MONSTER AROUND\n2 : EXIT");

                            //commad from the user
                            String inputCommand = sc.nextLine();

                            if (!inputCommand.matches(".*[a-zA-Z].*")&& !inputCommand.isEmpty() && (Integer.parseInt(inputCommand) == 1 || Integer.parseInt(inputCommand) == 2 )){
                                switch(Integer.parseInt(inputCommand)){

                                    // option to change the monster around
                                    case 1:
                                        
                                        System.out.println("Which moster would you like to move?");
                                        String inputCommandMove = sc.nextLine();
                                        System.out.println("");
                                        if (!inputCommandMove.matches(".*[a-zA-Z].*")&& !inputCommandMove.isEmpty() && (Integer.parseInt(inputCommandMove) >= 1 && Integer.parseInt(inputCommandMove) <= team.getMaxMonsterTeamSize())){
                                            //Index of selected mosnter
                                            int monsterSelcted =  Integer.parseInt(inputCommandMove)-1;
                                            //what to do with moster 
                                            System.out.println("1 : Move up\n2 : Move down");
                                            String inputCommandInnerMove = sc.nextLine();

                                            if (!inputCommandInnerMove.matches(".*[a-zA-Z].*")&& !inputCommandInnerMove.isEmpty() && (Integer.parseInt(inputCommandInnerMove) == 1 || Integer.parseInt(inputCommandInnerMove) == 2 )){
                                                int commandOfInnerMove = Integer.parseInt(inputCommandInnerMove);

                        

                                                //move up
                                                if (commandOfInnerMove == 1){
                                                    Monster moveMonster = team.getMonsterList().get(monsterSelcted);
                                                    team.getMonsterList().remove(monsterSelcted);
                                                    team.getMonsterList().add(0,moveMonster);
                                                }
                                                // move down
                                                else{
                                                    Monster moveMonster = team.getMonsterList().get(monsterSelcted);
                                                    team.getMonsterList().remove(monsterSelcted);
                                                    team.getMonsterList().add(moveMonster);

                                                }
                                            }
                                        }

                                        else{
                                            System.out.println("-------------------");
                                            System.out.println("SORRY INVALID INPUT");
                                            System.out.println("-------------------");
                                        }


                            
                                        break;
                                    //Exit 
                                    case 2:
                                        finishWithTeam = true;
                                        break;
                                }
                            }
                            else{
                                System.out.println("-------------------");
                                System.out.println("SORRY INVALID INPUT");
                                System.out.println("-------------------");
                            }

                            
                        }
                        break;

                    //Battle
                    case 4:
                        boolean exitBattle = false; 
                        while (exitBattle != true && hasBattled != true){
                            
                           
                            for (Opponent o: battleManager.getBattleOptions()){
                                System.out.println("-----------------------------");
                                System.out.println("BATTLE : " + o.getBattleName());
                                System.out.println("--------BATTLE MONSTER--------");
                                for(Monster monster: o.getOpponentTeam().getMonsterList()){
                                    System.out.println("MONSTER NAME : " + monster.getMonsterName());
                                }
                            }
                            System.out.println("-----------------------------");
                            System.out.println("4 : EXIT");
                            System.out.println("-----------------------------");
                            

                            System.out.println("WHO DO YOU WANT TO BATTLE?");
                            String commandBattle = sc.nextLine();
                            
                            if (!commandBattle.matches(".*[a-zA-Z].*") && !commandBattle.isEmpty()){
                                if (Integer.parseInt(commandBattle) == 4){
                                    exitBattle = true;
                                }
                                else if (Integer.parseInt(commandBattle) > 0 && Integer.parseInt(commandBattle) <= 3 ){
                                    int battleInt = Integer.parseInt(commandBattle)-1;
                                    Battle battle = new Battle();
                                    Boolean fight = battle.fight(game.player.getTeam(), battleManager.getBattleOptions().get(battleInt).getOpponentTeam());
                                    battleManager.rewards(fight, game.player,dificult);
                                    hasBattled= true;
                                    exitBattle = true;
                                    

                                    
                                }
                            }

                        }
                        if(hasBattled == true && exitBattle == false){
                            System.out.println("SORRY YOU HAVE ALREADY BATTLED TODAY");
                            System.out.println();
                        }
                        break;
                    
                    //Sleep
                    case 5:
                        game.createEnemyMonsterList();
                        game.sleep();
                        battleManager = game.getBattle();
                        battleManager.generateOpponents();
                        hasBattled = false;

            
                        break;

                }
            }
        }
        
        System.out.println("THE GAME HAS ENDED!!!");
        System.out.println(game.player.getName()+" you have played "+ (game.getCurrentDay()-1)+" days and your score is "+ game.player.getScore()+ " and recived $" + game.player.getGoldGained() + " gold");

    }

    
    
    /**
     * Main method for the comman line
     * @param args optional arguments
     */
    public static void main(String[] args){
        CommandLineInterface commandgame  = new CommandLineInterface();
        commandgame.setup();
        commandgame.main();

    } 
}




