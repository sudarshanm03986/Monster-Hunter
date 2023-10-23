package Test;

import static org.junit.Assert.*;

import org.junit.*;



import Items.*;
import monster.*;
import Battle.*;

/**
 * This class tests a battle and if the items are
 * being used in the battle
 */
public class BattleTest {

    private Monster erazor;
	private Monster sparky;
	private Monster thunder;
	private Monster tyrone;
	
	private Monster erazorEnemy;
	private Monster sparkyEnemy;
	private Monster thunderEnemy;
	private Monster tyroneEnemy;

    private Item armour;
    private Item damage;
    private Item dodge;
    private Item heal;

    
    /**
     * test if player monster win the battle after dodge is used.
     * */
    @Test
    public void testDodgeBattle() {


    	Battle battle = new Battle();

        MonsterManager playerTeam = new MonsterManager();
        MonsterManager enemyTeam = new MonsterManager();
        
        erazor = new Erazor();
        erazorEnemy = new Erazor();

        dodge = new Dodge();

        playerTeam.addMonster(erazor);
        enemyTeam.addMonster(erazorEnemy);

        dodge.useItems(playerTeam.getMonsterList().get(0));

        assertEquals(battle.fight(playerTeam, enemyTeam), true);

    	
    }
    
    
    
    /**
     * test if player monster win the battle after amrour is used.
     * */
    @Test
    public void testArmourBattle() {
    	

    	Battle battle = new Battle();

        MonsterManager playerTeam = new MonsterManager();
        MonsterManager enemyTeam = new MonsterManager();
        
        tyrone = new Tyrone();
        tyroneEnemy = new Tyrone();
        

        armour = new Armour();

        playerTeam.addMonster(tyrone);
        enemyTeam.addMonster(tyroneEnemy);

        armour.useItems(playerTeam.getMonsterList().get(0));

        assertEquals(battle.fight(playerTeam, enemyTeam), true);
    	
    }
    
    
    /**
     * test if monster wins after monster attack power is boosted
     * */
    @Test
    public void testDamageBattle() {
    	

    	Battle battle = new Battle();

        MonsterManager playerTeam = new MonsterManager();
        MonsterManager enemyTeam = new MonsterManager();
        
        thunder = new Thunder();
        thunderEnemy = new Thunder();

        damage = new Damage();

        playerTeam.addMonster(thunder);
        enemyTeam.addMonster(thunderEnemy);

        damage.useItems(playerTeam.getMonsterList().get(0));

        assertEquals(battle.fight(playerTeam, enemyTeam), true);
    	
    
    }

    
    /**
     * test if monster wins after monster heal has been boosted
     * */
    @Test
    public void testHealBattle() {
    	

    	Battle battle = new Battle();

        MonsterManager playerTeam = new MonsterManager();
        MonsterManager enemyTeam = new MonsterManager();
        
        sparky = new Sparky();
        sparkyEnemy = new Sparky();


        heal = new Heal();

        playerTeam.addMonster(sparky);
        enemyTeam.addMonster(sparkyEnemy);

        heal.useItems(playerTeam.getMonsterList().get(0));

        assertEquals(battle.fight(playerTeam, enemyTeam), true);
    	
    
    }


    

    
    
   }


