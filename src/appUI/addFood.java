package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.tableFood;

public class addFood extends styleSetter {
	
	JPanel addFood, btnPanel;
	JTextField fName, fPrice;
	JButton btnEdit, btnDelete;
	
	public  JPanel setPage() {
		
		addFood = new JPanel();
		setPanel (addFood,0, 0, 375, 587,colorWhite);
		setLabel ("�������������", "h1",20, 30, 200, 24,colorBlack, addFood);
		setLabel ("��������",null,20, 100, 200, 24,colorGray, addFood);
		setLabel ("�Ҥ� (�ҷ)",null,20, 200, 200, 24,colorGray, addFood);
		
		fName = new JTextField();
		setTextField(fName, 20, 130,330,40,addFood);
		
		fPrice = new JTextField();
		setTextField(fPrice, 20, 230,330,40,addFood);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, addFood);
		
		btnEdit = new JButton("��ŧ");
		setButton(btnEdit,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableFood t = new tableFood();
				t.insertData(fName.getText().trim(), fPrice.getText().trim());
			}
		});
		
		btnDelete = new JButton("¡��ԡ");
		setButton(btnDelete,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toFood();
			}
		});
	
		return addFood;
	}
	

}
