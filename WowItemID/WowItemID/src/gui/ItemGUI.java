package gui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import app.ItemIDFetch;


public class ItemGUI extends Frame implements ActionListener{
	private static final String[] ITEMSLOTS = {"head", "neck", "shoulder", "back", "chest", "wrist",
					"hands", "waist", "legs", "feet", "finger1", "finger2", "trinket1", "trinket2"};
	private Choice slotList;
	private TextField itemInput;
	private Button fetchBtn;
	private TextField outPut;
	private TextField iLevelInput;
	
	public ItemGUI() {
		setLayout(new FlowLayout());
		
		Label itemSlotLabel = new Label("Item Slot:");
		add(itemSlotLabel);
		slotList = new Choice();
		for(int i = 0; i < ITEMSLOTS.length; i++) {
			slotList.add(ITEMSLOTS[i]);
		}
		add(slotList);
		slotList.select(0);
		
		Label itemInputLabel = new Label ("Item name: ");
		add(itemInputLabel);		
		itemInput = new TextField("", 30);
		add(itemInput);
		
		Label iLevelInputLabel = new Label ("Item level: ");
		add(iLevelInputLabel);		
		iLevelInput = new TextField("", 5);
		add(iLevelInput);
		
		
		fetchBtn = new Button("Fetch");
		add(fetchBtn);
		
		fetchBtn.addActionListener(this);
		
		outPut = new TextField("", 100);
		add(outPut);
		
		setTitle("Wow Item ID Fetcher");
		setSize(800, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ItemGUI();
	}
	
	public void windowClosing(WindowEvent evt) {
      System.exit(0);  // Terminate the program
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		String slot = slotList.getSelectedItem();
		String itemName = itemInput.getText();
		int iLevel = Integer.parseInt(iLevelInput.getText());
		outPut.setText(ItemIDFetch.createSimCraftStringForItem(slot, itemName, iLevel));
	}
}
