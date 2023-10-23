package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.gameEnvironment;
import monster.Monster;
import monster.MonsterManager;

/**
 * View team window
 */
public class viewTeamScreen {

	/**
	 * name of the frame
	 */
	private JFrame frmMonsterFighterView;
	/**
	 * game environment object
	 */
	private gameEnvironment game;
	/**
	 * the players monster team
	 */
	private MonsterManager playerTeam;
	/**
	 * current selected monster
	 */
	private Monster selectedMonster;

	/**
	 * Create the application.
	 * @param gameManager game environment object
	 */
	public viewTeamScreen(gameEnvironment gameManager) {
		
		game = gameManager;
		
		playerTeam = game.getPlayer().getTeam();
		initialize();
		frmMonsterFighterView.setVisible(true);
	}


	/**
	 * close the team view window
	 */
	public void closeWindow() {
		frmMonsterFighterView.dispose();
	}
	
		
	/**
	 * call the closeViewTeamScreen
	 * which closes the view team screen window
	 * using the closeWindow method
	 */
	public void finishWindow(){
		game.closeViewTeamScreen(this);
	}

	/**
	 * Updates the team view screen window
	 * refreshes the window essentially
	 */
	public void updateWindow(){
		game.launchViewTeamScreen();
		closeWindow();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonsterFighterView = new JFrame();
		frmMonsterFighterView.setTitle("Monster Fighter View Team Screen");
		frmMonsterFighterView.setBounds(100, 100, 990, 720);
		frmMonsterFighterView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterFighterView.getContentPane().setLayout(null);
		
		JLabel lblMonsterFighterViewTeam = new JLabel("MONSTER FIGHTER TEAM");
		lblMonsterFighterViewTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterFighterViewTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		lblMonsterFighterViewTeam.setBounds(194, 19, 602, 83);
		frmMonsterFighterView.getContentPane().add(lblMonsterFighterViewTeam);
		

		//monster 1
		Monster monster1 = playerTeam.getMonsterList().get(0);

		JPanel panelMonster1Stats = new JPanel();
		panelMonster1Stats.setLayout(null);
		panelMonster1Stats.setBounds(6, 114, 474, 240);
		frmMonsterFighterView.getContentPane().add(panelMonster1Stats);

		JLabel lblMonsterImage1 = new JLabel("MonsterImg");
		lblMonsterImage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterImage1.setBounds(6, 6, 168, 245);
		panelMonster1Stats.add(lblMonsterImage1);
		lblMonsterImage1.setIcon( new ImageIcon(viewTeamScreen.class.getResource(monster1.getMonsterImg())));
		
		JLabel lblMonsterName1 = new JLabel("Monster Name: " + monster1.getMonsterName());
		lblMonsterName1.setBounds(186, 21, 212, 16);
		panelMonster1Stats.add(lblMonsterName1);
		
		JLabel lblMonsterPrice1 = new JLabel("Price: " + monster1.getMonsterPriceValue());
		lblMonsterPrice1.setBounds(186, 47, 212, 16);
		panelMonster1Stats.add(lblMonsterPrice1);
		
		JLabel lblMonsterHealth1 = new JLabel("Health: "+ monster1.getMonsterCurrentHealth() + "/" + monster1.getMonsterMaxHealth());
		lblMonsterHealth1.setBounds(186, 75, 224, 16);
		panelMonster1Stats.add(lblMonsterHealth1);
		
		JLabel lblMonsterDamage1 = new JLabel("Damage: " + monster1.getMonsterAttackDamage());
		lblMonsterDamage1.setBounds(186, 104, 224, 16);
		panelMonster1Stats.add(lblMonsterDamage1);
		
		JLabel lblMonsterHealAmount1 = new JLabel("Heal Amount:" + monster1.getMonsterHealAmount());
		lblMonsterHealAmount1.setBounds(186, 132, 193, 16);
		panelMonster1Stats.add(lblMonsterHealAmount1);

		JLabel lblMonsterFainted1 = new JLabel("Fainted: " + monster1.getIsFainted());
		lblMonsterFainted1.setBounds(184, 159, 212, 16);
		panelMonster1Stats.add(lblMonsterFainted1);
		
		JLabel lblPostion1 = new JLabel("Postion 1");
		lblPostion1.setBounds(374, 209, 110, 14);
		panelMonster1Stats.add(lblPostion1);
		
		JLabel lblMonsterArmour1 = new JLabel("Armour: " + monster1.getHasArmour());
		lblMonsterArmour1.setBounds(186, 187, 212, 16);
		panelMonster1Stats.add(lblMonsterArmour1);
		
		JLabel lblMonsterDodge1 = new JLabel("Dodge: " + monster1.getHasDodge());
		lblMonsterDodge1.setBounds(186, 208, 177, 16);
		panelMonster1Stats.add(lblMonsterDodge1);

		
		
		
		if (playerTeam.getMonsterList().size() > 1){
			Monster monster2 = playerTeam.getMonsterList().get(1);

			//monster 2
			JPanel panelMonster2Stats = new JPanel();
			panelMonster2Stats.setLayout(null);
			panelMonster2Stats.setBounds(501, 114, 474, 240);
			frmMonsterFighterView.getContentPane().add(panelMonster2Stats);
			
			JLabel lblMonsterImage2 = new JLabel("MonsterImg");
			lblMonsterImage2.setHorizontalAlignment(SwingConstants.CENTER);
			lblMonsterImage2.setBounds(6, 6, 168, 245);
			panelMonster2Stats.add(lblMonsterImage2);
			lblMonsterImage2.setIcon( new ImageIcon(viewTeamScreen.class.getResource(monster2.getMonsterImg())));
			
			JLabel lblMonsterName2 = new JLabel("Monster Name: " + monster2.getMonsterName());
			lblMonsterName2.setBounds(186, 21, 212, 16);
			panelMonster2Stats.add(lblMonsterName2);
			
			JLabel lblMonsterPrice2 = new JLabel("Price: " + monster2.getMonsterPriceValue());
			lblMonsterPrice2.setBounds(186, 47, 212, 16);
			panelMonster2Stats.add(lblMonsterPrice2);
			
			JLabel lblMonsterHealth2 = new JLabel("Health: " + monster2.getMonsterCurrentHealth() + "/" + monster2.getMonsterMaxHealth());
			lblMonsterHealth2.setBounds(186, 75, 224, 16);
			panelMonster2Stats.add(lblMonsterHealth2);
			
			JLabel lblMonsterDamage2 = new JLabel("Damage: " + monster2.getMonsterAttackDamage());
			lblMonsterDamage2.setBounds(186, 104, 224, 16);
			panelMonster2Stats.add(lblMonsterDamage2);
			
			JLabel lblMonsterHealAmount2 = new JLabel("Heal Amount: " + monster2.getMonsterHealAmount());
			lblMonsterHealAmount2.setBounds(186, 132, 193, 16);
			panelMonster2Stats.add(lblMonsterHealAmount2);

			JLabel lblMonsterFainted2 = new JLabel("Fainted: " + monster2.getIsFainted());
			lblMonsterFainted2.setBounds(186, 159, 212, 16);
			panelMonster2Stats.add(lblMonsterFainted2);
			
			JLabel lblPostion2 = new JLabel("Postion 2");
			lblPostion2.setBounds(374, 209, 110, 14);
			panelMonster2Stats.add(lblPostion2);

			JLabel lblMonsterArmour2 = new JLabel("Armour: " + monster2.getHasArmour());
			lblMonsterArmour2.setBounds(186, 187, 212, 16);
			panelMonster2Stats.add(lblMonsterArmour2);
			
			JLabel lblMonsterDodge2 = new JLabel("Dodge: " + monster2.getHasDodge());
			lblMonsterDodge2.setBounds(186, 208, 177, 16);
			panelMonster2Stats.add(lblMonsterDodge2);
			
			if (playerTeam.getMonsterList().size() > 2){
				Monster monster3 = playerTeam.getMonsterList().get(2);

				//monster3
				JPanel panelMonster3Stats = new JPanel();
				panelMonster3Stats.setLayout(null);
				panelMonster3Stats.setBounds(6, 365, 474, 240);
				frmMonsterFighterView.getContentPane().add(panelMonster3Stats);
				
				JLabel lblMonsterImage3 = new JLabel("MonsterImg");
				lblMonsterImage3.setHorizontalAlignment(SwingConstants.CENTER);
				lblMonsterImage3.setBounds(6, 6, 168, 245);
				panelMonster3Stats.add(lblMonsterImage3);
				lblMonsterImage3.setIcon( new ImageIcon(viewTeamScreen.class.getResource(monster3.getMonsterImg())));
				
				
				JLabel lblMonsterName3 = new JLabel("Monster Name: " + monster3.getMonsterName());
				lblMonsterName3.setBounds(186, 21, 212, 16);
				panelMonster3Stats.add(lblMonsterName3);
				
				JLabel lblMonsterPrice3 = new JLabel("Price: " + monster3.getMonsterPriceValue());
				lblMonsterPrice3.setBounds(186, 47, 212, 16);
				panelMonster3Stats.add(lblMonsterPrice3);
				
				JLabel lblMonsterHealth3 = new JLabel("Health: " + monster3.getMonsterCurrentHealth() + "/" + monster3.getMonsterMaxHealth());
				lblMonsterHealth3.setBounds(186, 75, 212, 16);
				panelMonster3Stats.add(lblMonsterHealth3);
				
				JLabel lblMonsterDamage3 = new JLabel("Damage: " + monster3.getMonsterAttackDamage());
				lblMonsterDamage3.setBounds(186, 104, 212, 16);
				panelMonster3Stats.add(lblMonsterDamage3);
				
				JLabel lblMonsterHealAmount3 = new JLabel("Heal Amount: " + monster3.getMonsterHealAmount());
				lblMonsterHealAmount3.setBounds(186, 132, 212, 16);
				panelMonster3Stats.add(lblMonsterHealAmount3);

				JLabel lblMonsterFainted3 = new JLabel("Fainted: " + monster3.getIsFainted());
				lblMonsterFainted3.setBounds(186, 159, 212, 16);
				panelMonster3Stats.add(lblMonsterFainted3);
				
				JLabel lblPostion3 = new JLabel("Postion 3");
				lblPostion3.setBounds(374, 209, 110, 14);
				panelMonster3Stats.add(lblPostion3);

				JLabel lblMonsterArmour3 = new JLabel("Armour: " + monster3.getHasArmour());
				lblMonsterArmour3.setBounds(186, 187, 212, 16);
				panelMonster3Stats.add(lblMonsterArmour3);
				
				JLabel lblMonsterDodge3 = new JLabel("Dodge: " + monster3.getHasDodge());
				lblMonsterDodge3.setBounds(186, 208, 177, 16);
				panelMonster3Stats.add(lblMonsterDodge3);
			}
			
			if (playerTeam.getMonsterList().size() > 3){
				Monster monster4 = playerTeam.getMonsterList().get(3);
				//monster 4
				JPanel panelMonster4Stats = new JPanel();
				panelMonster4Stats.setLayout(null);
				panelMonster4Stats.setBounds(501, 365, 474, 240);
				frmMonsterFighterView.getContentPane().add(panelMonster4Stats);
				
				JLabel lblMonsterImage4 = new JLabel("MonsterImg");
				lblMonsterImage4.setHorizontalAlignment(SwingConstants.CENTER);
				lblMonsterImage4.setBounds(6, 6, 168, 245);
				panelMonster4Stats.add(lblMonsterImage4);
				lblMonsterImage4.setIcon( new ImageIcon(viewTeamScreen.class.getResource(monster4.getMonsterImg())));
				
				JLabel lblMonsterName4 = new JLabel("Monster Name: "+ monster4.getMonsterName());
				lblMonsterName4.setBounds(186, 21, 212, 16);
				panelMonster4Stats.add(lblMonsterName4);
				
				JLabel lblMonsterPrice4 = new JLabel("Price: " + monster4.getMonsterPriceValue());
				lblMonsterPrice4.setBounds(186, 47, 212, 16);
				panelMonster4Stats.add(lblMonsterPrice4);
				
				JLabel lblMonsterHealth4 = new JLabel("Health: " + monster4.getMonsterCurrentHealth() + "/" + monster4.getMonsterMaxHealth());
				lblMonsterHealth4.setBounds(186, 75, 212, 16);
				panelMonster4Stats.add(lblMonsterHealth4);
				
				JLabel lblMonsterDamage4 = new JLabel("Damage: " + monster4.getMonsterAttackDamage());
				lblMonsterDamage4.setBounds(186, 104, 212, 16);
				panelMonster4Stats.add(lblMonsterDamage4);
				
				JLabel lblMonsterHealAmount4 = new JLabel("Heal Amount: "+ monster4.getMonsterHealAmount());
				lblMonsterHealAmount4.setBounds(186, 132, 212, 16);
				panelMonster4Stats.add(lblMonsterHealAmount4);

				JLabel lblMonsterFainted4 = new JLabel("Fainted: "+ monster4.getIsFainted());
				lblMonsterFainted4.setBounds(186, 159, 212, 16);
				panelMonster4Stats.add(lblMonsterFainted4);
				
				JLabel lblPostion4 = new JLabel("Postion 4");
				lblPostion4.setBounds(374, 209, 110, 14);
				panelMonster4Stats.add(lblPostion4);

				JLabel lblMonsterArmour4 = new JLabel("Armour: " + monster4.getHasArmour());
				lblMonsterArmour4.setBounds(186, 187, 212, 16);
				panelMonster4Stats.add(lblMonsterArmour4);
				
				JLabel lblMonsterDodge4 = new JLabel("Dodge: " + monster4.getHasDodge());
				lblMonsterDodge4.setBounds(186, 208, 177, 16);
				panelMonster4Stats.add(lblMonsterDodge4);

			}

				//combobox to pick which monster to switch
			JComboBox<Monster> comboBox = new JComboBox<>();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedMonster = (Monster) comboBox.getSelectedItem();
				}
			});
			comboBox.setBounds(309, 632, 242, 29);
			frmMonsterFighterView.getContentPane().add(comboBox);

			for (Monster monster: playerTeam.getMonsterList()){

				comboBox.addItem(monster);
			}

			//move up
			JButton btnMoveUp = new JButton("Move Up");
			btnMoveUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					playerTeam.removeMonster(selectedMonster);
					playerTeam.getMonsterList().add(0, selectedMonster);
					updateWindow();
					
				}
			});
			btnMoveUp.setBounds(573, 632, 117, 29);
			frmMonsterFighterView.getContentPane().add(btnMoveUp);


			//move down
			JButton btnMoveDown = new JButton("Move Down");
			btnMoveDown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					playerTeam.removeMonster(selectedMonster);
					playerTeam.getMonsterList().add(selectedMonster);
					updateWindow();
				}
			});
			btnMoveDown.setBounds(713, 632, 117, 29);
			frmMonsterFighterView.getContentPane().add(btnMoveDown);

			JLabel lblMoveMonster = new JLabel("Which monster do you want to move around?");
			lblMoveMonster.setBounds(55, 639, 261, 14);
			frmMonsterFighterView.getContentPane().add(lblMoveMonster);
		}

		//back button 
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishWindow();
			}
		});
		btnBack.setBounds(847, 632, 117, 29);
		frmMonsterFighterView.getContentPane().add(btnBack);
		

		
	}


}
