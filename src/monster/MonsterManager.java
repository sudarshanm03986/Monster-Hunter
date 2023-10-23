/**
 * This class implements the monster manager
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */

package monster;

import java.util.ArrayList;

/**
 * Monster manager class
 * manages a team of monsters
 */
public class MonsterManager {
    /**
     * Initialize Variables and Constants
     */

     /**
      * Monster list to hold a players monster team
      */
    private ArrayList<Monster> monsterList;

    //Constants
    /**
     * Maximum monster team size
     */
    private Integer MAXTEAMSIZE = 4;
    /**
     * Minmum monster team size
     */
    private Integer MINTEAMSIZE = 1;

    /**
     * MonsterManager constructor
     */
    public MonsterManager() {
        this.monsterList = new ArrayList<Monster>(); 
    }

    /**
     * MonsterMangager methods
     */

    /**
     * Get the monster list 
     * 
     * @return monsterList
     */
    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    /**
     * Add monsters to the monster list
     * 
     * @param monster item to be added to the inventory 
     */
    public void addMonster(Monster monster) {
        if (!(monsterList.contains(monster))) {
			monsterList.add(monster);
		}
    }

    /**
     * Remove monster from the monster list
     * 
     * @param monster monster to be removed from the inventory 
     */
    public void removeMonster(Monster monster) {
        if (monsterList.contains(monster)) {
			monsterList.remove(monster);
		}
    }

    /**
     * Get the max number of monsters allowed on a team
     * 
     * @return MAXTEAMSIZE Return the max number of monsters allowed on a team
     */
    public Integer getMaxMonsterTeamSize() {
        return MAXTEAMSIZE;
    }

    /**
     * Get the min number of monsters allowed on a team
     * 
     * @return MINTEAMSIZE Return the min number of monsters allowed on a team
     */
    public Integer getMinDay() {
        return MINTEAMSIZE;
    }



}
