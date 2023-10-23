/**
 * 
 * 
 * @author Sudarshan Malla, Nathan Fronda
 * @version 1.0, 06/05/2022
 */

package Items;

import monster.Monster;

/**
 * Super class for Heal item
 */
public class Heal extends Item{
    /**
     * Constructor for the heal item class
     * 
     */
    public Heal(){
        super("Heal", "The add more health to your monster", 10); 
    }

    /**
     * When the heal item is used
     * the monster's health will increase
     * 
     */
    public void useItems(Monster monster){
        monster.setMonsterCurrentHealth(monster.getMonsterCurrentHealth()+50.0);
        monster.setIsFainted(false);
    }


    
}