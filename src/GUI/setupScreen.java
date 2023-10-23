package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Player;
import main.gameEnvironment;
import monster.Monster;
import monster.MonsterManager;

/**
 * setup screen window
 */
public class setupScreen {

	/**
	 * name of the frame
	 */
	private JFrame frmMonsterFighterSetup;
	/**
	 * text field input for the players name
	 */
	private JTextField textPlayerNameInput;
	/**
	 * text field input for the players nickname
	 */
	private JTextField txtMonsterNickname;
	/**
	 * Name of the player
	 */
	private String name;
	/**
	 * Days: duration of the game
	 */
	private Integer day;
	/**
	 * difficulty of the game
	 */
	private String difficulty;
	/*
	 * Game environment object
	 */
	private gameEnvironment game;
	/**
	 * Initial team of monsters for the setup
	 */
	private MonsterManager initialTeam;
	/**
	 * The players monster team
	 */
	private MonsterManager playerTeam = new MonsterManager();
	/**
	 * the current selected monster
	 */
	private Monster selectedMonster;
	/**
	 * the players starting gold
	 */
	private Double startingGold = 1000.0; //start with 1000 gold

	/**
	 * Create the application.
	 * @param gameManager game environment object
	 */
	public setupScreen(gameEnvironment gameManager) {
		game = gameManager;
		game.setup();
		
		initialTeam = game.getInitialMonsters();
		initialize();
		frmMonsterFighterSetup.setVisible(true);
	}

	/**
	 * close the setup window
	 */
	public void closeWindow(){
		frmMonsterFighterSetup.dispose();
	}

	/**
	 * call the closeSetupScreen
	 * which closes the setup screen window
	 * using the closeWindow method
	 */
	public void finishWindow(){
		game.closeSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonsterFighterSetup = new JFrame();
		frmMonsterFighterSetup.setTitle("Monster Fighter Setup Screen");
		frmMonsterFighterSetup.setBounds(100, 100, 990, 624);
		frmMonsterFighterSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterFighterSetup.getContentPane().setLayout(null);
		
		JLabel lblGameTitle = new JLabel("MONSTER FIGHTER SETUP");
		lblGameTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		lblGameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameTitle.setBounds(234, 37, 521, 83);
		frmMonsterFighterSetup.getContentPane().add(lblGameTitle);
		
		JLabel lblPlayerNameInput = new JLabel("What is your name:");
		lblPlayerNameInput.setBounds(54, 132, 131, 16);
		frmMonsterFighterSetup.getContentPane().add(lblPlayerNameInput);
		
		textPlayerNameInput = new JTextField();
		textPlayerNameInput.setBounds(184, 127, 130, 26);
		frmMonsterFighterSetup.getContentPane().add(textPlayerNameInput);
		textPlayerNameInput.setColumns(10);
		
		JLabel lblDaySelector = new JLabel("How many days would you like to play?");
		lblDaySelector.setBounds(54, 160, 257, 16);
		frmMonsterFighterSetup.getContentPane().add(lblDaySelector);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(15);
		slider.setMinimum(5);
		slider.setBounds(54, 188, 260, 44);
		frmMonsterFighterSetup.getContentPane().add(slider);
		
		JPanel panelSelectMonster = new JPanel();
		panelSelectMonster.setBounds(44, 299, 382, 233);
		frmMonsterFighterSetup.getContentPane().add(panelSelectMonster);
		panelSelectMonster.setLayout(null);
		
		JLabel lblGold = new JLabel("Gold : " + startingGold);
		lblGold.setBounds(464, 104, 92, 16);
		frmMonsterFighterSetup.getContentPane().add(lblGold);
		
		Monster monster1 = initialTeam.getMonsterList().get(0);
		Monster monster2 = initialTeam.getMonsterList().get(1);
		Monster monster3 = initialTeam.getMonsterList().get(2);
		Monster monster4 = initialTeam.getMonsterList().get(3);
		Monster monster5 = initialTeam.getMonsterList().get(4);
		Monster monster6 = initialTeam.getMonsterList().get(5);
		JButton btnErazor = new JButton(monster1.getMonsterName());
		btnErazor.setBounds(47, 17, 120, 35);
		panelSelectMonster.add(btnErazor);
		
		JButton btnGrizz = new JButton(monster2.getMonsterName());
		btnGrizz.setBounds(220, 17, 120, 35);
		panelSelectMonster.add(btnGrizz);
		
		JButton btnMamba = new JButton(monster3.getMonsterName());
		btnMamba.setBounds(220, 161, 120, 35);
		panelSelectMonster.add(btnMamba);
		
		JButton btnSparky = new JButton(monster4.getMonsterName());
		btnSparky.setBounds(47, 88, 120, 35);
		panelSelectMonster.add(btnSparky);
		
		JButton btnThunder = new JButton(monster5.getMonsterName());
		btnThunder.setBounds(220, 88, 120, 35);
		panelSelectMonster.add(btnThunder);
		
		JButton btnTyrone = new JButton(monster6.getMonsterName());
		btnTyrone.setBounds(47, 161, 120, 35);
		panelSelectMonster.add(btnTyrone);
		
		JLabel lblSelectMonsters = new JLabel("Select your monsters");
		lblSelectMonsters.setBounds(149, 275, 144, 16);
		frmMonsterFighterSetup.getContentPane().add(lblSelectMonsters);
		
		JPanel panelMonsterStats = new JPanel();
		panelMonsterStats.setBounds(452, 152, 474, 380);
		frmMonsterFighterSetup.getContentPane().add(panelMonsterStats);
		panelMonsterStats.setLayout(null);
		
		JLabel lblMonsterImage = new JLabel("MonsterImg");
		lblMonsterImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterImage.setBounds(10, 28, 191, 329);
		panelMonsterStats.add(lblMonsterImage);
		
		JLabel lblMonsterName = new JLabel("Monster Name:");
		lblMonsterName.setBounds(207, 47, 216, 16);
		panelMonsterStats.add(lblMonsterName);
		
		JLabel lblMonsterPrice = new JLabel("Price:");
		lblMonsterPrice.setBounds(207, 89, 200, 16);
		panelMonsterStats.add(lblMonsterPrice);
		
		JLabel lblMonsterHealth = new JLabel("Health:");
		lblMonsterHealth.setBounds(207, 133, 200, 16);
		panelMonsterStats.add(lblMonsterHealth);
		
		JLabel lblMonsterDamage = new JLabel("Damage:");
		lblMonsterDamage.setBounds(207, 174, 216, 16);
		panelMonsterStats.add(lblMonsterDamage);
		
		JLabel lblMonsterHealAmount = new JLabel("Heal Amount:");
		lblMonsterHealAmount.setBounds(207, 214, 216, 16);
		panelMonsterStats.add(lblMonsterHealAmount);
		
		JLabel lblMonsterNickname = new JLabel("Do you want to name your monster?");
		lblMonsterNickname.setBounds(211, 254, 253, 16);
		panelMonsterStats.add(lblMonsterNickname);
		
		txtMonsterNickname = new JTextField();
		txtMonsterNickname.setBounds(207, 282, 237, 26);
		panelMonsterStats.add(txtMonsterNickname);
		txtMonsterNickname.setColumns(10);
		
		JButton btnSelectMonster = new JButton("Select Monster");
		btnSelectMonster.setBounds(271, 320, 117, 29);
		panelMonsterStats.add(btnSelectMonster);

		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(54, 244, 73, 16);
		frmMonsterFighterSetup.getContentPane().add(lblDifficulty);
		
		JRadioButton rdbtnEasy = new JRadioButton("EASY");
		rdbtnEasy.setBounds(123, 240, 85, 23);
		frmMonsterFighterSetup.getContentPane().add(rdbtnEasy);
		
		JRadioButton rdbtnHard = new JRadioButton("HARD");
		rdbtnHard.setBounds(234, 240, 85, 23);
		frmMonsterFighterSetup.getContentPane().add(rdbtnHard);

		ButtonGroup difficultyGroup = new ButtonGroup();
		difficultyGroup.add(rdbtnEasy);
		difficultyGroup.add(rdbtnHard);

		//selected monster
		btnSelectMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if monster has not been selected yet
				if (selectedMonster == null){
					JOptionPane.showMessageDialog(null, "You have not selected any monster");
				}
				// if the player has monster already
				else if (playerTeam.getMonsterList().contains(selectedMonster)){
					JOptionPane.showMessageDialog(null, "You already have got the monster");
				}
				// if the player does not have enough gold to buy monster
				else if ( (startingGold - selectedMonster.getMonsterPriceValue()) < 0 ){
					JOptionPane.showMessageDialog(null, "Sorry, you don't have enough gold");

				}
				// procced
				else{
					if (!txtMonsterNickname.getText().isEmpty()){
						selectedMonster.setMonsterName(txtMonsterNickname.getText().toString());
					}

					startingGold -= selectedMonster.getMonsterPriceValue();
					lblGold.setText("Gold : " + startingGold);
					playerTeam.addMonster(selectedMonster);
					JOptionPane.showMessageDialog(null, "You successfully bought " + selectedMonster.getMonsterName());
					txtMonsterNickname.setText("");
					
				}
			}
		});


		//monster
		btnErazor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonsterName.setText("Monster Name : " + monster1.getMonsterName());
				lblMonsterPrice.setText("Price: " + monster1.getMonsterPriceValue());
				lblMonsterHealth.setText("Health: " + monster1.getMonsterCurrentHealth());
				lblMonsterDamage.setText("Damage: " + monster1.getMonsterAttackDamage());
				lblMonsterHealAmount.setText("Heal Amount: " + monster1.getMonsterHealAmount());
				lblMonsterImage.setIcon(new ImageIcon(setupScreen.class.getResource(monster1.getMonsterImg())));
				selectedMonster = monster1;
				
			}});

		btnGrizz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonsterName.setText("Monster Name: " + monster2.getMonsterName());
				lblMonsterPrice.setText("Price: " + monster2.getMonsterPriceValue());
				lblMonsterHealth.setText("Health: " + monster2.getMonsterCurrentHealth());
				lblMonsterDamage.setText("Damage: " + monster2.getMonsterAttackDamage());
				lblMonsterHealAmount.setText("Heal Amount: " + monster2.getMonsterHealAmount());
				lblMonsterImage.setIcon(new ImageIcon(setupScreen.class.getResource(monster2.getMonsterImg())));
				selectedMonster = monster2;
			}});
		btnMamba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonsterName.setText("Monster Name: " + monster3.getMonsterName());
				lblMonsterPrice.setText("Price: " + monster3.getMonsterPriceValue());
				lblMonsterHealth.setText("Health: " + monster3.getMonsterCurrentHealth());
				lblMonsterDamage.setText("Damage: " + monster3.getMonsterAttackDamage());
				lblMonsterHealAmount.setText("Heal Amount: " + monster3.getMonsterHealAmount());
				lblMonsterImage.setIcon(new ImageIcon(setupScreen.class.getResource(monster3.getMonsterImg())));
				selectedMonster = monster3;
			}});
		btnSparky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonsterName.setText("Monster Name: " + monster4.getMonsterName());
				lblMonsterPrice.setText("Price: " + monster4.getMonsterPriceValue());
				lblMonsterHealth.setText("Health: " + monster4.getMonsterCurrentHealth());
				lblMonsterDamage.setText("Damage: " + monster4.getMonsterAttackDamage());
				lblMonsterHealAmount.setText("Heal Amount: " + monster4.getMonsterHealAmount());
				lblMonsterImage.setIcon(new ImageIcon(setupScreen.class.getResource(monster4.getMonsterImg())));
				selectedMonster = monster4;
			}});
		btnThunder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonsterName.setText("Monster Name: " + monster5.getMonsterName());
				lblMonsterPrice.setText("Price: " + monster5.getMonsterPriceValue());
				lblMonsterHealth.setText("Health: " + monster5.getMonsterCurrentHealth());
				lblMonsterDamage.setText("Damage: " + monster5.getMonsterAttackDamage());
				lblMonsterHealAmount.setText("Heal Amount: " + monster5.getMonsterHealAmount());
				lblMonsterImage.setIcon(new ImageIcon(setupScreen.class.getResource(monster5.getMonsterImg())));
				selectedMonster = monster5;
			}});
		btnTyrone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonsterName.setText("Monster Name: " + monster6.getMonsterName());
				lblMonsterPrice.setText("Price: " + monster6.getMonsterPriceValue());
				lblMonsterHealth.setText("Health: " + monster6.getMonsterCurrentHealth());
				lblMonsterDamage.setText("Damage: " + monster6.getMonsterAttackDamage());
				lblMonsterHealAmount.setText("Heal Amount: " + monster6.getMonsterHealAmount());
				lblMonsterImage.setIcon((Icon) new ImageIcon(setupScreen.class.getResource(monster6.getMonsterImg())));
				selectedMonster = monster6;
			}});

		JButton btnFinishSetup = new JButton("Finish Setup");
		btnFinishSetup.setBounds(814, 544, 117, 29);
		frmMonsterFighterSetup.getContentPane().add(btnFinishSetup);
		
		
		btnFinishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textPlayerNameInput.getText();
				day = slider.getValue();
				if (rdbtnEasy.isSelected()) {
					difficulty = rdbtnEasy.getText();
				} 
				if (rdbtnHard.isSelected()) {
					difficulty = rdbtnHard.getText();
				} 
				
				if (name.length() < 3 || name.length() > 15 || !name.matches("[A-Za-z]+")){
					JOptionPane.showMessageDialog(null, "Sorry, your player name has to be between 3 and 15 characters.");
					textPlayerNameInput.setText("");
				} 
				else if (difficulty == null){
					JOptionPane.showMessageDialog(null, "Sorry, you have not selected a difficulty");
				}
				else if (playerTeam.getMonsterList().size() == 0){
					JOptionPane.showMessageDialog(null, "Sorry you need to pick at least one monster");
				}else {
				
					Player player = new Player(name, startingGold, 0, playerTeam, 0.0);
					for(Monster monster: playerTeam.getMonsterList()) {
						initialTeam.removeMonster(monster);
					}
					game.setPlayer(player);
					game.setGameDays(day);
					game.setCurrentDay(1);
					game.makeBattles();
					game.setDifficulty(difficulty);
					
					
					finishWindow();
				}

			}
		});
		
		
	}
}
