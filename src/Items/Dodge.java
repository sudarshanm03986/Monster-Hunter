/**
 * 
 * 
 * @author Sudarshan Malla, Nathan Fronda
 * @version 1.0, 06/05/2022
 */

package Items;

import monster.Monster;

/**
 * Super class for Dodge item
 */
public class Dodge extends Item{
    /**
     * Constructor for the dodge item class
     */
    public Dodge(){
        super("Dodge", "The item dodge allow you to dodge enemy attacks a third of the time", 25); 
    }

    /**
     * When the dodge item is used
     * the monster will dodge half of the enemy's attacks'
     * 
     */
    public void useItems(Monster monster){
        monster.setHasDodge(true);
    }
}