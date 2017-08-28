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
import java.awt.event.WindowListener;

import app.Item;
import app.ItemIDFetch;


public class ItemGUI extends Frame implements ActionListener, WindowListener{
	private Choice slotList;
	private TextField itemInput;
	private Button fetchBtn;
	private TextField outPut;
	private TextField iLevelInput;
	
	public ItemGUI() {
		setLayout(new FlowLayout());
				
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
		addWindowListener(this);
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

		//String slot = slotList.getSelectedItem();
		String itemName = itemInput.getText();
		try {
			Item i = ItemIDFetch.fetchItem(itemName);
			int iLevel = Integer.parseInt(iLevelInput.getText());
			String result = i.createSimCraftStringForItem(iLevel);
			if (result == null) {
				outPut.setText("That item couldn't be found");
			}
			else {
				outPut.setText(result);
			}
		}
		catch(NumberFormatException ex) {
			outPut.setText("Please enter an integer into the item level field");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
