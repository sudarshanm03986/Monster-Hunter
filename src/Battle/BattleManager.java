/**
 * This class implements the battle manager
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */

package Battle;

import java.util.ArrayList;

import main.Player;
import monster.*;

/**
 * Battle manager class
 * create opponents and handles
 * battles
 */
public class BattleManager {
    /**
     * Initialize Variables and Constants
     */

    /**
     * Player in game
     */
    private Player player;
    /**
     * Get the list of enemy monsters
     */
    private MonsterManager emenyMonsterList;

    /**
     * opponent list to hold enemy teams
     * battle options for the player
     * to choose from
     */
    private ArrayList<Opponent> battleOptions;
    /**
     * the gold reward
     */
    Double goldReward;
    /**
     * the score reward
     */
    Integer scoreReward;

    /**
     * BattleManager methods
     */

    

    public void generateOpponents() {
        Opponent opponent1 = new Opponent("Opponent 1", this);
        Opponent opponent2 = new Opponent("Opponent 2", this);
        Opponent opponent3 = new Opponent("Opponent 3", this);
        battleOptions = new ArrayList<Opponent>();
        battleOptions.add(opponent1);
        battleOptions.add(opponent2);
        battleOptions.add(opponent3);
    }

     /**
      * Battle Manager constructor
      * @param playerInGame current player in game
      */
    public BattleManager(Player playerInGame) {
        this.player = playerInGame;
    }

    /**
     * Get the enemy monster list 
     * 
     * @return emenyMonsterList
     */
    public MonsterManager getEnemyMonsters() {
 
        return emenyMonsterList;
    }

    /**
     * Set the enemy monster list 
     * 
     * @param enemyMonster the enemy monster team
     */
    public void setEmenyMonsterList(MonsterManager enemyMonster) {
        emenyMonsterList = enemyMonster;
    }



    /**
     * Get the team size of the player
     * @return playerTeamSize
     */
    public int getPlayerTeamSize() {
        return player.getTeam().getMonsterList().size();
    }

    /**
     * Get the battle options
     * 
     * @return battleOptions
     */
    public ArrayList<Opponent> getBattleOptions() {
        return battleOptions;
    }

    /**
     * 
     * @param win boolean value indicating if the player wins
     * @param player current player in the game
     * @param difficulty difficulty of the game
     */
    public void rewards(Boolean win, Player player,String difficulty) {
        scoreReward = 250;
        if (difficulty == "EASY") {
            goldReward = 250.0;
        } else {
            goldReward = 150.0;
        }

        if (win == true) {
            player.addGold(goldReward);
            player.addScore(scoreReward);
            player.addGoldGained(goldReward);
        }

    }

}
