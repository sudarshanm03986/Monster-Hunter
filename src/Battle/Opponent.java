/**
 * This class implements an opponent
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */

package Battle;

import java.util.ArrayList;
import java.util.Collections;

import monster.Monster;
import monster.MonsterManager;

/**
 * Opponent class to handle the opponents
 */
public class Opponent {
    /**
     * Initialize Variables
     */
    /**
     * Battle option name
     */
    private String battleName;
    /**
     * The opponent team
     */
    private MonsterManager opponentTeam = new MonsterManager();

    /**
     * Battle manager object
     */
    private BattleManager battle;

    private void generateTeam() {
        int enemyTeamSize = battle.getPlayerTeamSize();
        ArrayList<Monster> enemyList = battle.getEnemyMonsters().getMonsterList();
        Collections.shuffle(enemyList);
        for (int i = 0;i < enemyTeamSize; i++) {
            opponentTeam.addMonster(enemyList.get(i));
        }

    }

    /**
     * Opponent constructor
     * @param name name of the opponent
     * @param battle battle manager that the opponent belongs to
     */
    public Opponent(String name, BattleManager battle) {
        this.battleName = name;
        this.battle = battle;
        generateTeam();
    }

    /**
     * Get the battle name
     * 
     * @return battleName Return the name of the player
     */
    public String getBattleName() {
        return battleName;
    }

    /**
     * Get the opponent team
     * 
     * @return opponentTeam Return the opponent team
     */
    public MonsterManager getOpponentTeam() {
        return opponentTeam;
    }
}
