/**
 * This class implements a battle 
 *
 * @author Nathan Fronda, Sudarshan Malla
 * @version 1.0, May 2022.
 */

package Battle;

import monster.Monster;
import monster.MonsterManager;

import java.util.ArrayList;
import java.util.Random;
/**
 * Battle class which 
 * handles a battle between
 * the players monster and 
 * the opponnents monster
 */
public class Battle {
    /**
     * Initialize Variables
     */

    /**
     * Players Team
     */
    MonsterManager playersTeam;
    /**
     * Opponents Team
     */
    MonsterManager opponentsTeam;
    /**
     * the battle state
     * true if monsters are battling
     * false if either player or opponents 
     * monsters are all fainted
     */
    Boolean gameState = true;
    /**
     * Current player monster
     */
    Monster currPlayerMonster;
    /**
     * Current Opponent monster
     */
    Monster currOpponentMonster;
    /**
     * Players win count
     */
    Integer playersWin = 0;
    /**
     * Opponents win count
     */
    Integer opponentsWin = 0;
    /**
     * First monster to attack
     */
    Monster firstAttackMonster;
     /**
     * Next monster to attack
     */
    Monster secondAttackMonster;
    /**
     * Dodge count
     */
    Integer dodgeCount = 1;
    /**
     * Battle steps using arraylist of strings
     */
    ArrayList<String> battleSteps;

    /**
     * Get the battle steps
     * @return battleSteps
     */
    public ArrayList<String> getBattleSteps() {
        return battleSteps;
    }

    /**
     * handles a fight for 
     * individual monsters
     * in the team
     * @param playersTeam the players monster team
     * @param opponentsTeam the opponents monster team
     * @return true if the player won, false otherwise
     */
    public boolean fight(MonsterManager playersTeam,MonsterManager opponentsTeam) {
        battleSteps = new ArrayList<String>();
        Random rand = new Random();
        for (int i = 0; i < playersTeam.getMonsterList().size(); i++) {
            currPlayerMonster  = playersTeam.getMonsterList().get(i);
            currOpponentMonster = opponentsTeam.getMonsterList().get(i);

            System.out.println();
            battleSteps.add("Player's monster: " + currPlayerMonster.getMonsterName() + " vs " + "Opponent's monster: " + currOpponentMonster.getMonsterName());
            System.out.println("Player's monster: " + currPlayerMonster.getMonsterName() + " vs " + "Opponent's monster: " + currOpponentMonster.getMonsterName());
            System.out.println();


            int random = rand.nextInt(2);
            //The players monster will attack first
            if (random == 0) {
                firstAttackMonster = currPlayerMonster;
                secondAttackMonster = currOpponentMonster; 
                battleSteps.add("Player's monster attacks first");
                System.out.println("Player's monster attacks first");
            //the opponents monster will attack first
            } else {
                battleSteps.add("Opponent's monster attacks first");
                System.out.println("Opponent's monster attacks first");
                firstAttackMonster = currOpponentMonster;
                secondAttackMonster = currPlayerMonster;
            }
            
            if (currPlayerMonster.getHasArmour() == true) {
                battleSteps.add(currPlayerMonster.getMonsterName() + " has armour");
                System.out.println(currPlayerMonster.getMonsterName() + " has armour");
            }
            if (currPlayerMonster.getHasDodge() == true) {
                battleSteps.add(currPlayerMonster.getMonsterName() + " has dodge ability");
                System.out.println(currPlayerMonster.getMonsterName() + " has dodge ability");
            }
            System.out.println();
            
            //monster fights
            while (firstAttackMonster.getMonsterCurrentHealth() > 0 && secondAttackMonster.getMonsterCurrentHealth() > 0){
                //monster attakcs monster
                battleSteps.add(firstAttackMonster.getMonsterName() + " attcked " + secondAttackMonster.getMonsterName());
                System.out.println(firstAttackMonster.getMonsterName() + " attcked " + secondAttackMonster.getMonsterName());
                secondAttackMonster.setMonsterCurrentHealth(secondAttackMonster.getMonsterCurrentHealth() - firstAttackMonster.getMonsterAttackDamage());
                if (secondAttackMonster.getHasDodge() == true && dodgeCount %3 == 0) {
                    battleSteps.add(secondAttackMonster.getMonsterName() + " used dodge");
                    System.out.println(secondAttackMonster.getMonsterName() + " used dodge");
                    secondAttackMonster.setMonsterCurrentHealth(secondAttackMonster.getMonsterCurrentHealth() + firstAttackMonster.getMonsterAttackDamage());
                }
                else {
                    if (secondAttackMonster.getHasArmour() == true && secondAttackMonster.getMonsterCurrentHealth() > 0) {
                        secondAttackMonster.setMonsterCurrentHealth(secondAttackMonster.getMonsterCurrentHealth() + firstAttackMonster.getMonsterAttackDamage()*0.2);
                    }
                }
                battleSteps.add(secondAttackMonster.getMonsterName() + " health is now " + secondAttackMonster.getMonsterCurrentHealth());
                System.out.println(secondAttackMonster.getMonsterName() + " health is now " + secondAttackMonster.getMonsterCurrentHealth());
                System.out.println();
             
                
                //check if the monster is not fainted after the attack
                if (secondAttackMonster.getMonsterCurrentHealth() > 0) {
                    //The opposing monster attacks
                    battleSteps.add(secondAttackMonster.getMonsterName() + " attcked " + firstAttackMonster.getMonsterName());
                    System.out.println(secondAttackMonster.getMonsterName() + " attcked " + firstAttackMonster.getMonsterName());

                    firstAttackMonster.setMonsterCurrentHealth(firstAttackMonster.getMonsterCurrentHealth() - secondAttackMonster.getMonsterAttackDamage());
                    if (firstAttackMonster.getHasDodge() == true && dodgeCount %3 == 0) {
                        battleSteps.add(firstAttackMonster.getMonsterName() + " used dodge");
                        System.out.println(firstAttackMonster.getMonsterName() + " used dodge");
                        firstAttackMonster.setMonsterCurrentHealth(firstAttackMonster.getMonsterCurrentHealth() + secondAttackMonster.getMonsterAttackDamage());
                    } else {
                        if (firstAttackMonster.getHasArmour() == true && firstAttackMonster.getMonsterCurrentHealth() > 0) {
                            firstAttackMonster.setMonsterCurrentHealth(firstAttackMonster.getMonsterCurrentHealth() + secondAttackMonster.getMonsterAttackDamage()*0.2);
                        }
                    }
                    battleSteps.add(firstAttackMonster.getMonsterName() + " health is now " + firstAttackMonster.getMonsterCurrentHealth());
                    System.out.println(firstAttackMonster.getMonsterName() + " health is now " + firstAttackMonster.getMonsterCurrentHealth());
                    System.out.println();
                 
                    //checks if the monster is not fainted after the attack
                    if (!(firstAttackMonster.getMonsterCurrentHealth() > 0)) {
                        
                        if (random == 0) {
                            opponentsWin += 1;
                        } else {
                            playersWin += 1;
                        }
                        break;
                    }
                } else {
                    
                    if (random == 0) {
                        playersWin += 1;
                    } else {
                        opponentsWin += 1;
                    }
                    break;
                }
                dodgeCount += 1;
            }

            if (currPlayerMonster.getHasArmour() == true) {
                currPlayerMonster.setHasArmour(false);
            }
            if (currPlayerMonster.getHasDodge() == true) {
                currPlayerMonster.setHasDodge(false);
            }

            if (currPlayerMonster.getIsFainted() == true) {
                battleSteps.add("Your monster fainted");
                System.out.println("Your monster fainted");
            } else {
                battleSteps.add("Opponents monster fainted");
                System.out.println("Opponents monster fainted");
            }
            System.out.println();

        }
        if (playersWin == opponentsWin) {
            battleSteps.add("DRAW");
            System.out.println("DRAW");
            return false;
        } else if (playersWin > opponentsWin) {
            battleSteps.add("CONGRATS YOU HAVE WON THIS BATTLE");
            System.out.println("CONGRATS YOU HAVE WON THIS BATTLE");
            return true;
        }
         else {
            battleSteps.add("SORRY YOU HAVE LOST THIS BATTLE");
            System.out.println("SORRY YOU HAVE LOST THIS BATTLE");
            return false;
        }
    }
}