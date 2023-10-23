package Test;

import static org.junit.Assert.*;
import org.junit.*;

import Items.*;
import monster.*;
import Shop.*;
import main.Player;

/**
 * This class tests the shop functionality
 */
public class ShopTest {

    private Monster erazor;

    private Item armour;


    private MonsterManager shopMonster;
    private Inventory shopItem;

    private Shop shop;

    private Player player;

    
    /**
     * test if gold get deducted from player gold after they 
     * have purchased item or monster and test if the item 
     * or monster get added to player inventory or player team
     */
    @Test
    public void testBuy(){

        shopMonster = new MonsterManager();
        shopItem = new Inventory();

        erazor = new Erazor();
        armour = new Armour();

        shopMonster.addMonster(erazor);
        shopItem.addItems(armour);

        shop = new Shop(shopItem, shopMonster);

        player = new Player("Bob", 1000.0, 0, new MonsterManager(), 0.0);



        // buy item 
        shop.buyItems(new Armour(), player);
        
        //check if gold has been deducted from player gold
        assertEquals(player.getGold(), 975.0, 975.0);
        
        // check if item has been added
        assertEquals(1 , player.getInventory().getItemsList().size());



        // buy monster 
        shop.buyMonster(new Erazor(), player);
        
        //check if gold has been deducted from player gold
        assertEquals(player.getGold(),775.0, 775.0 );
        
        //check if monster has been added 
        assertEquals(1, player.getTeam().getMonsterList().size());



    }

    
    /**
     * test if buy selling item or monster gold get add back to 
     * player gold collections and monster or item gets removed
     */
    @Test
    public void testSell(){

        shopMonster = new MonsterManager();
        shopItem = new Inventory();

        erazor = new Erazor();
        armour = new Armour();

        shop = new Shop(shopItem, shopMonster);



        player = new Player("Bob", 0.0, 0, new MonsterManager(), 0.0);
        player.addMonster(erazor);
        player.addItem(armour);


        // sell items
        shop.sellItems(armour, player);

        //check if money is added in player gold collection
        assertEquals(player.getGold(), 20, 20);

        //check if item has been removed to of the player invetory
        assertEquals(player.getInventory().getItemsList().size(), 0);


        //sell Monster
        shop.sellMonster(erazor, player);

        //check if money is added in player gold collection
        assertEquals(player.getGold(), 180, 180);

        //check if monster has been removed to of the player Monster team
        assertEquals(player.getTeam().getMonsterList().size(), 0);



    }




}

