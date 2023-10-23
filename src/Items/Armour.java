/**
 * This class implements an Armour item
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */
package Items;

import monster.Monster;

/**
 * Super class for Armour item
 */
public class Armour extends Item{

    /**
     * Constructor for the armour item class
     */
    public Armour(){
        super("Armour", "The item Armour reduces the damage from enemy attack", 25); 
    }

    /**
     * When the armour item is used
     * the monster hasArmour parameter is set to true
     * 
     */
    public void useItems(Monster monster){
       monster.setHasArmour(true);
    }

}


