/**
 * This class implements a monster
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */


package monster;
/**
 * Monster class
 */
public class Monster {
    /**
     * Initialize Variables
     */

    /**
     * Name of the monster
     */
    private String monsterName;
    /**
     * Max health of the monster
     */
    private Double mosnterMaxHealth;
    /**
     * Monsters attack damage amount
     */
    private Double mosnterAttackDamage;
    /**
     * Monsters heal amount
     */
    private Double mosnterHealAmount;
    /**
     * The current health of the monster
     */
    private Double mosnterCurrentHealth;
    /**
     * Whether or not the monster is fainted
     */
    private Boolean isFainted;
    /**
     * Price of the monster
     */
    private Double monsterPriceValue;
    /**
     * Armour
     */
    private Boolean monsterHasArmour;
    /**
     * Dodge ability
     */
    private Boolean monsterHasDodgeAbility;
    /**
     * Picture of Monster
     */
    private String monsterImgString;

    /**
     * Monster methods
     */

     /**
      * Monster constructor
      * @param name name of the monster
      * @param health health of the monster
      * @param attack attack damage of the monster
      * @param heal heal amount of the monster
      * @param price price of the monster
      * @param monsterImg monster image
      */
    public Monster(String name, Double health, Double attack, Double heal, Double price, String monsterImg) {
        this.monsterName = name;
        this.mosnterMaxHealth = health;
        this.mosnterAttackDamage = attack;
        this.mosnterHealAmount = heal;
        this.mosnterCurrentHealth = mosnterMaxHealth;
        this.isFainted = false;
        this.monsterPriceValue = price;
        this.monsterHasArmour = false;
        this.monsterHasDodgeAbility = false;
        this.monsterImgString = monsterImg;

    }

    /**
     * Get the Monsters Image
     * 
     * @return monsterImgString Return the Image of the monster
     */
    public String getMonsterImg(){
        return monsterImgString;
    }

    /**
     * Get the Monsters names
     * 
     * @return monsterName Return the name of the monster
     */
    public String getMonsterName() {
        return monsterName;
    }

    /**
     * Set the Monsters names
     * 
     * @param name The name of the monster
     */
    public void setMonsterName(String name) {
        monsterName = name;
    }

    /**
     * Get the Monsters max health
     * 
     * @return mosnterMaxHealth Return the max health of the monster
     */
    public Double getMonsterMaxHealth() {
        return mosnterMaxHealth;
    }

    /**
     * Set the Monsters names
     * 
     * @param maxHealth The max health of the monster
     */
    public void setMonsterMaxHealth(Double maxHealth) {
        mosnterMaxHealth = maxHealth;
    }

    /**
     * Get the Monsters damage
     * 
     * @return mosnterAttackDamage Return the damage amount of the monster
     */
    public Double getMonsterAttackDamage() {
        return mosnterAttackDamage;
    }

    /**
     * Set the Monsters attack damage
     * 
     * @param attackDamage The attack damage of the monster
     */
    public void setMonsterAttackDamage(Double attackDamage) {
        mosnterAttackDamage += attackDamage;
    }

    /**
     * Get the Monsters heal amount
     * 
     * @return mosnterHealAmount Return the heal amount of the monster
     */
    public Double getMonsterHealAmount() { 
        return mosnterHealAmount;
    }

    /**
     * Set the Monsters heal amount
     * 
     * @param healAmount The heal amount of the monster
     */
    public void setMonsterHealAmount(Double healAmount) {
        mosnterHealAmount = healAmount;
    }

    /**
     * Get the Monsters current health
     * 
     * @return mosnterCurrentHealth Return the current health of the monster
     */
    public Double getMonsterCurrentHealth() { 
        return mosnterCurrentHealth;
    }

    /**
     * Set the Monsters current health
     * 
     * @param currentHealth The current health of the monster
     */
    public void setMonsterCurrentHealth(Double currentHealth) {
        mosnterCurrentHealth = currentHealth;
        if (getMonsterCurrentHealth() <= 0){
            mosnterCurrentHealth = 0.0;
            setIsFainted(true);
        } else {
            setIsFainted(false);
        }
        
    }

    /**
     * Heal the monster
     * 
     */
    public void heal() {
        Double heal = getMonsterHealAmount();
        mosnterCurrentHealth += heal;
    }

    /**
     * Get whether or not the monster has fainted or not
     * 
     * @return isFainted
     */
    public boolean getIsFainted() {
        return isFainted;
    }

    /**
     * Set the monsters current stats (fainted/not fainted)
     * 
     * @param fainted boolean flag to indicate if the monster is fainted or not
     */
    public void setIsFainted(boolean fainted) {
        isFainted = fainted;
    }

    /**
     * Get the Monsters price value
     * 
     * @return mosnterPriceValue Return the price value of the monster
     */
    public Double getMonsterPriceValue() { 
        return monsterPriceValue;
    }

    /**
     * Set the Monsters price value
     * 
     * @param value The price value of the monster
     */
    public void setMonsterPriceValue(Double value) {
        monsterPriceValue = value;
    }

    /**
     * Get whether or not the monster has armour or not
     * 
     * @return monsterHasArmour
     */
    public boolean getHasArmour() {
        return monsterHasArmour;
    }

    /**
     * Set whether or not the monster has armour or not
     * 
     * @param hasArmour monster armour or not
     */
    public void setHasArmour(Boolean hasArmour) {
        monsterHasArmour = hasArmour;
    }

    /**
     * Get whether or not the monster has dodge ability or not
     * 
     * @return monsterHasDodgeAbility
     */
    public boolean getHasDodge() {
        return monsterHasDodgeAbility;
    }

    /**
     * Set whether or not the monster has dodge ability or not
     * 
     * @param hasDodge monster ability to dodge
     */
    public void setHasDodge(Boolean hasDodge) {
        monsterHasDodgeAbility = hasDodge;
    }

    public String toString() {
        return monsterName;
    }

}
