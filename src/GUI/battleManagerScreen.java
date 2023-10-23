package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Battle.Battle;
import Battle.BattleManager;
import main.Player;
import main.gameEnvironment;
import monster.MonsterManager;
import javax.swing.JTextField;

/**
 * Battle manager screen
 */
public class battleManagerScreen {

	/**
	 * Name of the frame
	 */
	private JFrame frmMonsterFighterBattle;
	/**
	 * the game environment current game
	 */
	private gameEnvironment game;
	/**
	 * the current player
	 */
	private Player player;
	/**
	 * a battle manager object
	 */
	private BattleManager battle;

	/**
	 * Create the application.
	 * @param gameManager game environment object
	 */
	public battleManagerScreen(gameEnvironment gameManager) {
		game = gameManager;
		
		battle = game.getBattle();
		
		player = game.getPlayer();
		initialize();
		frmMonsterFighterBattle.setVisible(true);
	}

	/**
	 * close the battle manager window
	 */
	public void closeWindow(){
		frmMonsterFighterBattle.dispose();
	}

	/**
	 * call the closeBattleMangerScreen
	 * which closes the battle manager window
	 * using the closeWindow method
	 */
	public void finishWindow(){
		game.closeBattleMangerScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MonsterManager opponentsTeam1 = battle.getBattleOptions().get(0).getOpponentTeam();
		MonsterManager opponentsTeam2 = battle.getBattleOptions().get(1).getOpponentTeam();
		MonsterManager opponentsTeam3 = battle.getBattleOptions().get(2).getOpponentTeam();
		frmMonsterFighterBattle = new JFrame();
		frmMonsterFighterBattle.setTitle("Monster Fighter Battle Manager");
		frmMonsterFighterBattle.setBounds(100, 100, 990, 542);
		frmMonsterFighterBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterFighterBattle.getContentPane().setLayout(null);
		
		JLabel lblMonsterFighterBattle = new JLabel("MONSTER FIGHTER BATTLE MANAGER");
		lblMonsterFighterBattle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterFighterBattle.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		lblMonsterFighterBattle.setBounds(105, 23, 779, 83);
		frmMonsterFighterBattle.getContentPane().add(lblMonsterFighterBattle);
		
		JPanel panelBattle2 = new JPanel();
		panelBattle2.setBounds(340, 118, 309, 316);
		frmMonsterFighterBattle.getContentPane().add(panelBattle2);
		panelBattle2.setLayout(null);
		
		JButton btnFightBattle2 = new JButton("Fight");
		btnFightBattle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// game.launchFightScreen();
				// closeWindow();
				Battle battle = new Battle();
				Boolean fight = battle.fight(player.getTeam(),opponentsTeam2);
			
				if (fight == true) {
					JOptionPane.showMessageDialog(null, "You have won the battle");
				} else {
					JOptionPane.showMessageDialog(null, "You have lost the battle");
				}
				game.getBattle().rewards(fight,player, game.getDifficulty());
				game.setHasBattled(true);
				game.launchMainScreen();
				closeWindow();

			}
		});
		btnFightBattle2.setBounds(96, 265, 117, 29);
		panelBattle2.add(btnFightBattle2);
		
		JLabel lblOpponent2 = new JLabel("Opponent 2");
		lblOpponent2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponent2.setBounds(76, 35, 156, 16);
		panelBattle2.add(lblOpponent2);
		
		JPanel panelBattle3 = new JPanel();
		panelBattle3.setBounds(663, 118, 309, 316);
		frmMonsterFighterBattle.getContentPane().add(panelBattle3);
		panelBattle3.setLayout(null);
		
		JButton btnFightBattle3 = new JButton("Fight");
		btnFightBattle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// game.launchFightScreen();
				// closeWindow();
				Battle battle = new Battle();
				Boolean fight = battle.fight(player.getTeam(),opponentsTeam3);
			
				if (fight == true) {
					JOptionPane.showMessageDialog(null, "You have won the battle");
				} else {
					JOptionPane.showMessageDialog(null, "You have lost the battle");
				}
				game.getBattle().rewards(fight, player, game.getDifficulty());
				game.setHasBattled(true);
				game.launchMainScreen();
				closeWindow();
				
			}
		});
		btnFightBattle3.setBounds(96, 265, 117, 29);
		panelBattle3.add(btnFightBattle3);
		
		JLabel lblOpponent3 = new JLabel("Opponent 3");
		lblOpponent3.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponent3.setBounds(76, 35, 156, 16);
		panelBattle3.add(lblOpponent3);	
		
		JPanel panelBattle1 = new JPanel();
		panelBattle1.setBounds(19, 118, 309, 316);
		frmMonsterFighterBattle.getContentPane().add(panelBattle1);
		panelBattle1.setLayout(null);
		
		JButton btnFightBattle1 = new JButton("Fight");
		btnFightBattle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Battle battle = new Battle();
				Boolean fight = battle.fight(player.getTeam(),opponentsTeam1);
			
				if (fight == true) {
					JOptionPane.showMessageDialog(null, "You have won the battle");
				} else {
					JOptionPane.showMessageDialog(null, "You have lost the battle");
				}
				game.getBattle().rewards(fight, player, game.getDifficulty());
				game.setHasBattled(true);
				game.launchMainScreen();
				closeWindow();
			}
		});
		btnFightBattle1.setBounds(96, 265, 117, 29);
		panelBattle1.add(btnFightBattle1);
		
		JLabel lblOpponent1 = new JLabel("Opponent 1");
		lblOpponent1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponent1.setBounds(76, 35, 156, 16);
		panelBattle1.add(lblOpponent1);
		
		if (battle.getBattleOptions().get(0).getOpponentTeam().getMonsterList().size() > 0) {

			JLabel lblOp1Mon1 = new JLabel("Monster 1: "+ opponentsTeam1.getMonsterList().get(0).getMonsterName());
			lblOp1Mon1.setBounds(6, 73, 207, 16);
			panelBattle1.add(lblOp1Mon1);

			JLabel lblOp2Mon1 = new JLabel("Monster 1: "+ opponentsTeam2.getMonsterList().get(0).getMonsterName());
			lblOp2Mon1.setBounds(6, 74, 207, 16);
			panelBattle2.add(lblOp2Mon1);

			JLabel lblOp3Mon1 = new JLabel("Monster 1: "+ opponentsTeam3.getMonsterList().get(0).getMonsterName());
			lblOp3Mon1.setBounds(6, 73, 207, 16);
			panelBattle3.add(lblOp3Mon1);

			if (battle.getBattleOptions().get(0).getOpponentTeam().getMonsterList().size() > 1) {

				JLabel lblOp1Mon2 = new JLabel("Monster 2: "+ opponentsTeam1.getMonsterList().get(1).getMonsterName());
				lblOp1Mon2.setBounds(6, 101, 207, 16);
				panelBattle1.add(lblOp1Mon2);

				JLabel lblOp2Mon2 = new JLabel("Monster 2: "+ opponentsTeam2.getMonsterList().get(1).getMonsterName());
				lblOp2Mon2.setBounds(6, 102, 207, 16);
				panelBattle2.add(lblOp2Mon2);

				JLabel lblOp3Mon2 = new JLabel("Monster 2: "+ opponentsTeam3.getMonsterList().get(1).getMonsterName());
				lblOp3Mon2.setBounds(6, 101, 207, 16);
				panelBattle3.add(lblOp3Mon2);

				if (battle.getBattleOptions().get(0).getOpponentTeam().getMonsterList().size() > 2) {

					JLabel lblOp1Mon3 = new JLabel("Monster 3: "+ opponentsTeam1.getMonsterList().get(2).getMonsterName());
					lblOp1Mon3.setBounds(6, 129, 207, 16);
					panelBattle1.add(lblOp1Mon3);

					JLabel lblOp2Mon3 = new JLabel("Monster 3: "+ opponentsTeam2.getMonsterList().get(2).getMonsterName());
					lblOp2Mon3.setBounds(6, 130, 207, 16);
					panelBattle2.add(lblOp2Mon3);
					
					JLabel lblOp3Mon3 = new JLabel("Monster 3: "+ opponentsTeam3.getMonsterList().get(2).getMonsterName());
					lblOp3Mon3.setBounds(6, 129, 207, 16);
					panelBattle3.add(lblOp3Mon3);

					if (battle.getBattleOptions().get(0).getOpponentTeam().getMonsterList().size() > 3) {

						JLabel lblOp1Mon4 = new JLabel("Monster 4: "+ opponentsTeam1.getMonsterList().get(3).getMonsterName());
						lblOp1Mon4.setBounds(6, 160, 207, 16);
						panelBattle1.add(lblOp1Mon4);

						JLabel lblOp2Mon4 = new JLabel("Monster 4: "+ opponentsTeam2.getMonsterList().get(3).getMonsterName());
						lblOp2Mon4.setBounds(6, 161, 207, 16);
						panelBattle2.add(lblOp2Mon4);

						JLabel lblOp3Mon4 = new JLabel("Monster 4: "+ opponentsTeam3.getMonsterList().get(3).getMonsterName());
						lblOp3Mon4.setBounds(6, 160, 207, 16);
						panelBattle3.add(lblOp3Mon4);

					}

				}
				
			}

		}
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishWindow();
			}
		});
		btnBack.setBounds(855, 464, 117, 29);
		frmMonsterFighterBattle.getContentPane().add(btnBack);
	}
}
