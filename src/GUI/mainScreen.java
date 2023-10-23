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

import main.Player;
import main.gameEnvironment;

/**
 * main screen window
 */
public class mainScreen {

	/**
	 * Name of the frame
	 */
	private JFrame frmMonsterFighterMain;
	/**
	 * the game environment current game
	 */
	private gameEnvironment game;
	/**
	 * the current player
	 */
	private Player player;
	


	/**
	 * Create the application.
	 * @param gameManager game environment object
	 */
	public mainScreen(gameEnvironment gameManager) {
		game = gameManager;
		game.main();
		player = game.getPlayer();

		initialize();
		frmMonsterFighterMain.setVisible(true);
	}
	
	/**
	 * close the main screen window
	 */
	public void closeWindow() {
		frmMonsterFighterMain.dispose();
	}
	
	/**
	 * call the closeMainScreen
	 * which closes the main screen window
	 * using the closeWindow method
	 */
	public void finishWindow(){
		game.closeMainScreen(this);
	}

	/**
	 * Updates the main screen window
	 * refreshes the window essentially
	 */
	public void updateWindow(){
		game.launchMainScreen();
		closeWindow();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonsterFighterMain = new JFrame();
		frmMonsterFighterMain.setTitle("Monster Fighter Main Screen");
		frmMonsterFighterMain.setBounds(100, 100, 990, 625);
		frmMonsterFighterMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterFighterMain.getContentPane().setLayout(null);
		
		JLabel lblGameTitle = new JLabel("MONSTER FIGHTER MAIN SCREEN");
		lblGameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		lblGameTitle.setBounds(158, 20, 673, 83);
		frmMonsterFighterMain.getContentPane().add(lblGameTitle);
		
		JPanel panelGameStats = new JPanel();
		panelGameStats.setBounds(52, 115, 885, 38);
		frmMonsterFighterMain.getContentPane().add(panelGameStats);
		panelGameStats.setLayout(null);
		
		JLabel lblScore = new JLabel("Score: " + player.getScore());
		lblScore.setBounds(227, 11, 97, 16);
		panelGameStats.add(lblScore);
		
		JLabel lblGold = new JLabel("Gold: " + player.getGold());
		lblGold.setBounds(344, 11, 111, 16);
		panelGameStats.add(lblGold);
		
		JLabel lblDay = new JLabel("Day: " + game.getCurrentDay() + "/" + game.getGameDays());
		lblDay.setBounds(768, 11, 111, 16);
		panelGameStats.add(lblDay);
		
		JLabel lblPlayerName = new JLabel("Name: "+player.getName());
		lblPlayerName.setBounds(16, 11, 97, 16);
		panelGameStats.add(lblPlayerName);
		
		JPanel panelMainOptions = new JPanel();
		panelMainOptions.setBounds(52, 178, 885, 386);
		frmMonsterFighterMain.getContentPane().add(panelMainOptions);
		panelMainOptions.setLayout(null);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlayer().getInventory().getItemsList().size() == 0) {
					int output = JOptionPane.showConfirmDialog(null
               , "Your inventory is empty. Do you want to go to the shop?"
               ,null
               ,JOptionPane.YES_NO_OPTION);

			   if(output == JOptionPane.YES_OPTION) {
					game.launchShopScreen();
					closeWindow();
			   }
				} else {
					game.launchViewInventoryScreen();
					closeWindow();
				}

				
			}
		});
		btnViewInventory.setBounds(355, 78, 175, 29);
		panelMainOptions.add(btnViewInventory);
		
		
		JButton btnVisitShop = new JButton("Visit Shop");
		btnVisitShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.launchShopScreen();
				closeWindow();
			}
		});
		btnVisitShop.setBounds(355, 25, 175, 29);
		panelMainOptions.add(btnVisitShop);
		
		JButton btnViewTeam = new JButton("View Team");
		btnViewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.launchViewTeamScreen();
				closeWindow();
			}
		});
		btnViewTeam.setBounds(355, 131, 175, 29);
		panelMainOptions.add(btnViewTeam);
		
		JButton btnBattle = new JButton("Battle");
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getHasBattled() == false) {
					game.launchBattleMangerScreen();
					closeWindow();
				} else {
					JOptionPane.showMessageDialog(null, "You have already completed a battle for today!");
				}
				
			}
		});
		btnBattle.setBounds(355, 185, 175, 29);
		panelMainOptions.add(btnBattle);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if (game.getCurrentDay() > game.getGameDays()-1) {
					JOptionPane.showMessageDialog(null, "The game has finished!\n" + "Player Name: "+game.getPlayer().getName()+"\n"+"Score: " 
					+ game.getPlayer().getScore() + "\n" + "Gold: " + game.getPlayer().getGoldGained() );
					closeWindow();
				} else {
					game.sleep();
					for (String update :game.getRamdomUpdate()){
						JOptionPane.showMessageDialog(null, update);
					}
					game.getBattle().generateOpponents();
					updateWindow();
				}

			}
		});
		btnSleep.setBounds(355, 236, 175, 29);
		panelMainOptions.add(btnSleep);


		


		
	}
}
