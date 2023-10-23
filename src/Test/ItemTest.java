package Test;

import static org.junit.Assert.*;

import org.junit.*;

import Items.Armour;
import Items.Damage;
import Items.Dodge;
import Items.Heal;
import Items.Item;
import main.Player;
import monster.Erazor;
import monster.Grizz;
import monster.Mamba;
import monster.Monster;
import monster.MonsterManager;
import monster.Sparky;


/**
 * This class tests items
 * and that is is being used
 * correctly on the monsters
 */
//create item then test each of the item if their useItem method is working.
public class ItemTest {

    private Monster erazor;
	private Monster grizz;
	private Monster mamba;
	private Monster sparky;


    private Item armour;
    private Item damage;
    private Item dodge;
    private Item heal;



	private Player player;


    
    /**
     * test if dodge variable in monster class is true after 
     * the dodge item has been used
     */
    @Test
    public void dodgeTest(){

        player = new Player("suda", 400.0, 0, new MonsterManager(), 0.0);

        erazor = new Erazor();

        dodge = new Dodge();

        player.addMonster(erazor);

        player.addItem(dodge);

        player.getInventory().getItemsList().get(0).useItems(player.getTeam().getMonsterList().get(0));

        assertEquals(player.getTeam().getMonsterList().get(0).getHasDodge(), true);

    }


    
    /**
     * test if the monster attack power has increased after damage item has been used
     */
    @Test
    public void damageTest(){

        player = new Player("suda", 400.0, 0, new MonsterManager(), 0.0);

        grizz = new Grizz();

        damage = new Damage();

        player.addMonster(grizz);

        player.addItem(damage);

        player.getInventory().getItemsList().get(0).useItems(player.getTeam().getMonsterList().get(0));
        
        assertEquals(player.getTeam().getMonsterList().get(0).getMonsterAttackDamage(), 25.0, 25.0);

    }
    
   
   /**
    * Test if Armour variable in monster is true after Armour item been used
    */
    @Test
   public void armourTest() {
	   
	   player = new Player("suda", 400.0, 0, new MonsterManager(), 0.0);

       mamba = new Mamba();

       armour = new Armour();

       player.addMonster(mamba);

       player.addItem(armour);

       player.getInventory().getItemsList().get(0).useItems(player.getTeam().getMonsterList().get(0));

       assertEquals(player.getTeam().getMonsterList().get(0).getHasArmour(), true);
	   
   }
   

   
   /**
    * test if monster current healt has boosted up by 50 after using heal item
    */
    @Test
   public void healTest() {

    player = new Player("suda", 400.0, 0, new MonsterManager(), 0.0);

    sparky = new Sparky();

    heal = new Heal();

    player.addMonster(sparky);

    player.addItem(heal);

    player.getInventory().getItemsList().get(0).useItems(player.getTeam().getMonsterList().get(0));

    assertEquals(player.getTeam().getMonsterList().get(0).getMonsterCurrentHealth(), 550, 550);
   
	   
   }


    
        


    


}
