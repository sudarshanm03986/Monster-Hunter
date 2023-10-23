package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Items.Inventory;
import Items.Item;
import Shop.Shop;
import main.gameEnvironment;
import monster.Monster;
import monster.MonsterManager;

/**
 * Shop screen window
 */
public class shopScreen {

	/*
	 * Game environment object
	 */
	private gameEnvironment game;
	/**
	 * name of the frame
	 */
	private JFrame frame;
	/**
	 * list of monsters in the shop
	 */
	private MonsterManager monsterShop;
	/**
	 * the players items
	 */
	private Inventory playersItems;
	/**
	 * the list of items in the shop
	 */
	private Inventory shopInventory;
	/**
	 * the players monster team
	 */
	private MonsterManager playersTeam;
	/**
	 * shop object
	 */
	private Shop shop;
	/**
	 * current selected monster to buy
	 */
	private Monster selectedBuyMonster;
	/**
	 * current selected monster to sell
	 */
	private Monster selectedSellMonster;
	/**
	 * current selected item to buy
	 */
	private Item selectedBuyItem;
	/**
	 * current selected item to sell
	 */
	private Item selectedSellItem;

	/**
	 * Create the application.
	 * @param gameManager game environment object
	 */
	public shopScreen(gameEnvironment gameManager) {
		
		game = gameManager;
		
		//shop
		shop = game.getShop();

		shopInventory = shop.getShopItems();
		monsterShop = shop.getMonsterInventory();


		playersItems = game.getPlayer().getInventory();
		playersTeam = game.getPlayer().getTeam();

		initialize();
		frame.setVisible(true);
	}

	/**
	 * close the shop window
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * call the closeShopScreen
	 * which closes the shop window
	 * using the closeWindow method
	 */
	public void finishWindow(){
		game.closeShopScreen(this);
	}

	/**
	 * Updates the shop screen window
	 * refreshes the window essentially
	 */
	public void updateWindow(){
		game.launchShopScreen();
		closeWindow();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 986, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblGold = new JLabel("Gold : " + game.getPlayer().getGold());
		lblGold.setBounds(6, 93, 92, 16);
		frame.getContentPane().add(lblGold);
		
		JLabel lblMonsterFighterShop = new JLabel("MONSTER SHOP");
		lblMonsterFighterShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterFighterShop.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		lblMonsterFighterShop.setBounds(320, 6, 329, 83);
		frame.getContentPane().add(lblMonsterFighterShop);
		
		JPanel panelMonsterBuyShop = new JPanel();
		panelMonsterBuyShop.setLayout(null);
		panelMonsterBuyShop.setBounds(6, 125, 470, 219);
		frame.getContentPane().add(panelMonsterBuyShop);
		
		JLabel lblMonsterBuyName = new JLabel("Monster Name:");
		lblMonsterBuyName.setBounds(186, 21, 222, 16);
		panelMonsterBuyShop.add(lblMonsterBuyName);
		
		JLabel lblMonsterBuyPrice = new JLabel("Price:");
		lblMonsterBuyPrice.setBounds(186, 47, 222, 16);
		panelMonsterBuyShop.add(lblMonsterBuyPrice);
		
		JLabel lblMonsterBuyHealth = new JLabel("Health:");
		lblMonsterBuyHealth.setBounds(186, 75, 242, 16);
		panelMonsterBuyShop.add(lblMonsterBuyHealth);
		
		JLabel lblMonsterBuyDamage = new JLabel("Damage:");
		lblMonsterBuyDamage.setBounds(186, 104, 222, 16);
		panelMonsterBuyShop.add(lblMonsterBuyDamage);
		
		JLabel lblMonsterBuyHealAmount = new JLabel("Heal Amount:");
		lblMonsterBuyHealAmount.setBounds(186, 132, 242, 16);
		panelMonsterBuyShop.add(lblMonsterBuyHealAmount);
		
		JButton btnBuyMonster = new JButton("Buy Monster");
		btnBuyMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if the player has monster already
				if (playersTeam.getMonsterList().contains(selectedBuyMonster)){
					JOptionPane.showMessageDialog(null, "You already have got the monster");
				} else if ( (game.getPlayer().getGold() - selectedBuyMonster.getMonsterPriceValue()) < 0 ) {
					JOptionPane.showMessageDialog(null, "Sorry, you don't have enough gold");
				} else {
					String nickanme = JOptionPane.showInputDialog(null, "Do you want to name your Monster?");
					if (nickanme != null && nickanme.length() > 0) {
						selectedBuyMonster.setMonsterName(nickanme);
					}
					shop.buyMonster(selectedBuyMonster, game.getPlayer());
					playersTeam.addMonster(selectedBuyMonster);
					lblGold.setText("Gold : " + game.getPlayer().getGold());
					JOptionPane.showMessageDialog(null, "You successfully bought "+selectedBuyMonster);
					game.getBattle().generateOpponents();
					updateWindow();
				}
			}
		});
		btnBuyMonster.setBounds(180, 160, 117, 29);
		panelMonsterBuyShop.add(btnBuyMonster);
		
		JComboBox<Monster> comboBoxBuyMonsters = new JComboBox<>();
		comboBoxBuyMonsters.setBounds(6, 43, 151, 27);
		panelMonsterBuyShop.add(comboBoxBuyMonsters);
		comboBoxBuyMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster monster = (Monster) comboBoxBuyMonsters.getSelectedItem();
				lblMonsterBuyName.setText("Monster Name: " + monster.getMonsterName());
				lblMonsterBuyPrice.setText("Price: " + monster.getMonsterPriceValue());
				lblMonsterBuyHealth.setText("Health: " + monster.getMonsterCurrentHealth());
				lblMonsterBuyDamage.setText("Damage: " + monster.getMonsterAttackDamage());
				lblMonsterBuyHealAmount.setText("Heal Amount: " + monster.getMonsterHealAmount());
				selectedBuyMonster = monster;
			}
		});

		for (Monster monster : monsterShop.getMonsterList()) {
			comboBoxBuyMonsters.addItem(monster);
		}
		
		JLabel lblMonsterBuyShop = new JLabel("Buy Monsters");
		lblMonsterBuyShop.setBounds(6, 15, 128, 16);
		panelMonsterBuyShop.add(lblMonsterBuyShop);
		
		JPanel panelMonsterSellShop_1 = new JPanel();
		panelMonsterSellShop_1.setLayout(null);
		panelMonsterSellShop_1.setBounds(6, 356, 470, 200);
		frame.getContentPane().add(panelMonsterSellShop_1);
		
		JLabel lblMonsterSellName = new JLabel("Monster Name:");
		lblMonsterSellName.setBounds(186, 21, 246, 16);
		panelMonsterSellShop_1.add(lblMonsterSellName);
		
		JLabel lblMonsterSellPrice = new JLabel("Price:");
		lblMonsterSellPrice.setBounds(186, 47, 207, 16);
		panelMonsterSellShop_1.add(lblMonsterSellPrice);
		
		JButton btnSellMonster = new JButton("Sell Monster");
		btnSellMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(playersTeam.getMonsterList().size()>1)) {
					JOptionPane.showMessageDialog(null, "Sorry you need to have at least one monster");
				}
				else {
					shop.sellMonster(selectedSellMonster, game.getPlayer());
					JOptionPane.showMessageDialog(null, "You successfully sold "+selectedSellMonster);
					game.getBattle().generateOpponents();
					updateWindow();
				}
				
				
			}
		});
		btnSellMonster.setBounds(183, 99, 117, 29);
		panelMonsterSellShop_1.add(btnSellMonster);
		
		JComboBox<Monster> comboBoxSellMonsters = new JComboBox<>();
		comboBoxSellMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster monster = (Monster) comboBoxSellMonsters.getSelectedItem();
				lblMonsterSellName.setText("Monster Name: " + monster.getMonsterName());
				lblMonsterSellPrice.setText("Price: " + monster.getMonsterPriceValue()*0.8);
				selectedSellMonster = monster;
			}
		});
		comboBoxSellMonsters.setBounds(6, 43, 151, 27);
		panelMonsterSellShop_1.add(comboBoxSellMonsters);

		for (Monster monster : playersTeam.getMonsterList()) {
			comboBoxSellMonsters.addItem(monster);
		}
		
		JLabel lblSellMonsters = new JLabel("Sell Monsters");
		lblSellMonsters.setBounds(6, 15, 128, 16);
		panelMonsterSellShop_1.add(lblSellMonsters);
		
		JPanel panelItemBuyShop = new JPanel();
		panelItemBuyShop.setLayout(null);
		panelItemBuyShop.setBounds(497, 126, 371, 218);
		frame.getContentPane().add(panelItemBuyShop);
		
		JLabel lblItemPriceBuy = new JLabel("Price: ");
		lblItemPriceBuy.setBounds(187, 27, 167, 16);
		panelItemBuyShop.add(lblItemPriceBuy);
		
		JButton btnBuyItem = new JButton("Buy Item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((game.getPlayer().getGold() - selectedBuyItem.getPrice()) < 0 ) {
					JOptionPane.showMessageDialog(null, "Sorry, you don't have enough gold");
				} else {
					shop.buyItems(selectedBuyItem, game.getPlayer());
					lblGold.setText("Gold : " + game.getPlayer().getGold());
					JOptionPane.showMessageDialog(null, "You successfully bought "+selectedBuyItem);
					updateWindow();
				}
			}
		});
		btnBuyItem.setBounds(128, 168, 117, 29);
		panelItemBuyShop.add(btnBuyItem);


		
		
		JButton btnItemDescriptionBuy = new JButton("Item Description");
		btnItemDescriptionBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, selectedBuyItem.getDescription());
			}
		});
		btnItemDescriptionBuy.setBounds(165, 55, 162, 29);
		panelItemBuyShop.add(btnItemDescriptionBuy);
		
		JLabel lblBuyItems = new JLabel("Buy Items");
		lblBuyItems.setBounds(6, 12, 128, 16);
		panelItemBuyShop.add(lblBuyItems);
		
		JComboBox<Item> comboBoxBuyItems = new JComboBox<>();
		comboBoxBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) comboBoxBuyItems.getSelectedItem();
				lblItemPriceBuy.setText("Price: " + item.getPrice());
				selectedBuyItem = item;
			}
		});
		comboBoxBuyItems.setBounds(0, 36, 151, 27);
		panelItemBuyShop.add(comboBoxBuyItems);

		for (Item item : shopInventory.getItemsList()) {
			comboBoxBuyItems.addItem(item);
		}


		
		JPanel panelItemShellShop = new JPanel();
		panelItemShellShop.setLayout(null);
		panelItemShellShop.setBounds(496, 355, 371, 201);
		frame.getContentPane().add(panelItemShellShop);
		
		JLabel lblItemPriceSell = new JLabel("Sell Price: ");
		lblItemPriceSell.setBounds(187, 27, 151, 16);
		panelItemShellShop.add(lblItemPriceSell);
		
		JButton btnSellItem = new JButton("Sell Item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.sellItems(selectedSellItem, game.getPlayer());
				JOptionPane.showMessageDialog(null, "You successfully sold "+selectedSellItem);
				updateWindow();
			}
		});
		btnSellItem.setBounds(175, 107, 117, 29);
		panelItemShellShop.add(btnSellItem);
		
		JButton btnItemDescriptionSell = new JButton("Item Description");
		btnItemDescriptionSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, selectedSellItem.getDescription());
			}
		});
		btnItemDescriptionSell.setBounds(165, 55, 162, 29);
		panelItemShellShop.add(btnItemDescriptionSell);
		
		JLabel lblSellItems_1 = new JLabel("Sell Items");
		lblSellItems_1.setBounds(6, 12, 128, 16);
		panelItemShellShop.add(lblSellItems_1);
		
		JComboBox<Item> comboBoxSellItems = new JComboBox<>();
		comboBoxSellItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) comboBoxSellItems.getSelectedItem();
				lblItemPriceSell.setText("Sell Price: " + item.getPrice()*0.8);
				selectedSellItem = item;
			}
		});
		comboBoxSellItems.setBounds(0, 36, 151, 27);
		panelItemShellShop.add(comboBoxSellItems);

		for (Item item : playersItems.getItemsList()) {
			comboBoxSellItems.addItem(item);
		}
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishWindow();
			}
		});
		btnBack.setBounds(863, 570, 117, 29);
		frame.getContentPane().add(btnBack);

		
	}
}
