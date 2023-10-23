/**
 * 
 * 
 * @author Sudarshan Malla, Nathan Fronda
 * @version 1.0, 06/05/2022
 */

package Items;

import monster.Monster;

/**
 * Super class for Damge item
 */
public class Damage extends Item{
    /**
     * Constructor for the damage item class
     */
    public Damage(){
        super("Damage", "The item damage allow you to boost your monster's attack power", 50); 
    }

    /**
     * When the armour item is used
     * the monster attack damage will increase
     */
    public void useItems(Monster monster){
        monster.setMonsterAttackDamage(10.0);
    }
    

}