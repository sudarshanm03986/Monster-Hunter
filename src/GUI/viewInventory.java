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
import main.gameEnvironment;
import monster.Monster;
import monster.MonsterManager;


/**
 * Inventory screen window
 */
public class viewInventory {

	/**
	 * Name of the frame
	 */
	private JFrame frmMonsterFighterView;
	/**
	 * Game environment object
	 */
	private gameEnvironment game;
	/**
	 * the players monster team
	 */
	private MonsterManager playersMonsters;
	/**
	 * The players items
	 */
	private Inventory playersItems;
	/**
	 * selected monster to use item on
	 */
	private Monster selectedMonster;
	/**
	 * selected item to be used
	 */
	private Item selectedItem;

	/**
	 * Create the application.
	 * @param gameManager game environment object
	 */
	public viewInventory(gameEnvironment gameManager) {
		
		game = gameManager;
		
		playersMonsters = game.getPlayer().getTeam();
		playersItems = game.getPlayer().getInventory();
		initialize();
		frmMonsterFighterView.setVisible(true);

		if (playersItems.getItemsList().size() == 0){
			JOptionPane.showMessageDialog(null, "You have no more items");
			game.launchMainScreen();
			closeWindow();
		}
	}

	/**
	 * close the inventory window
	 */
	public void closeWindow() {
		frmMonsterFighterView.dispose();
	}
	
	/**
	 * call the closeViewInventoryScreen
	 * which closes the view inventory screen window
	 * using the closeWindow method
	 */
	public void finishWindow(){
		game.closeViewInventoryScreen(this);
	}

	/**
	 * Updates the inventory screen window
	 * refreshes the window essentially
	 */
	public void updateWindow(){
		game.launchViewInventoryScreen();
		closeWindow();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonsterFighterView = new JFrame();
		frmMonsterFighterView.setTitle("Monster Fighter Inventory Screen");
		frmMonsterFighterView.setBounds(100, 100, 647, 354);
		frmMonsterFighterView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterFighterView.getContentPane().setLayout(null);
		
		JLabel lblMonsterFighterViewInventory = new JLabel("MONSTER FIGHTER INVENTORY");
		lblMonsterFighterViewInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterFighterViewInventory.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		lblMonsterFighterViewInventory.setBounds(19, 16, 613, 83);
		frmMonsterFighterView.getContentPane().add(lblMonsterFighterViewInventory);
		
		JPanel panel = new JPanel();
		panel.setBounds(337, 100, 244, 163);
		frmMonsterFighterView.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(16, 40, 194, 16);
		panel.add(lblItemName);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(null
							, "Do you want to use " + selectedItem + " on " + selectedMonster
							,"Use Item"
							,JOptionPane.YES_NO_OPTION);

			   if(output == JOptionPane.YES_OPTION) {
				   selectedItem.useItems(selectedMonster);
				   playersItems.removeItems(selectedItem);
				   JOptionPane.showMessageDialog(null, "You successfully used " + selectedItem + " on " + selectedMonster);
				   updateWindow();
			   }
			}
		});
		btnUseItem.setBounds(6, 106, 117, 29);
		panel.add(btnUseItem);
		
		JButton btnItemDescription = new JButton("Item Description");
		btnItemDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, selectedItem.getDescription());
			}
		});
		btnItemDescription.setBounds(6, 68, 162, 29);
		panel.add(btnItemDescription);
		
		JComboBox<Item> comboBoxPlayerInventory = new JComboBox<>();
		comboBoxPlayerInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) comboBoxPlayerInventory.getSelectedItem();
				lblItemName.setText("Item Name: " + item.getItemName());
				selectedItem = item;
			}
		});
		comboBoxPlayerInventory.setBounds(103, 111, 163, 27);
		frmMonsterFighterView.getContentPane().add(comboBoxPlayerInventory);

		for (Item item : playersItems.getItemsList()) {
			comboBoxPlayerInventory.addItem(item);
		}
		
		JLabel lblPlayerInventory = new JLabel("Inventory:");
		lblPlayerInventory.setBounds(19, 111, 72, 16);
		frmMonsterFighterView.getContentPane().add(lblPlayerInventory);

		JLabel lblMonsterInventory = new JLabel("Monster:");
		lblMonsterInventory.setBounds(19, 234, 72, 16);
		frmMonsterFighterView.getContentPane().add(lblMonsterInventory);
		
		JComboBox<Monster> comboBoxMonsterInventory = new JComboBox<>();
		comboBoxMonsterInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster monster = (Monster) comboBoxMonsterInventory.getSelectedItem();
				selectedMonster = monster;
			}
		});
		comboBoxMonsterInventory.setBounds(103, 230, 163, 27);
		frmMonsterFighterView.getContentPane().add(comboBoxMonsterInventory);

		for (Monster monster : playersMonsters.getMonsterList()) {
			comboBoxMonsterInventory.addItem(monster);
		}

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishWindow();
			}
		});
		btnBack.setBounds(515, 291, 117, 29);
		frmMonsterFighterView.getContentPane().add(btnBack);

	}
}
