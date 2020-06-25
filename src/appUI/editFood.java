package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.tableFood;

public class editFood extends styleSetter implements ActionListener{
	
	JPanel editFood, btnPanel;
	JTextField fName, fPrice;
	JButton btnEdit, btnDelete;
	static int foodID;
	static String foodName, foodPrice;
	
	public  JPanel setPage() {
		
		editFood = new JPanel();
		setPanel(editFood,0, 0, 375, 587,colorWhite);
		setLabel ("������������", "h1",20, 30, 200, 24,colorBlack, editFood);
		setLabel ("��������",null,20, 100, 200, 24,colorGray, editFood);
		setLabel ("�Ҥ� (�ҷ)",null,20, 200, 200, 24,colorGray, editFood);
		
		fName = new JTextField();
		setTextField(fName, 20, 130,330,40,editFood);
		fName.setText(foodName);
		
		fPrice = new JTextField();
		setTextField(fPrice, 20, 230,330,40,editFood);
		fPrice.setText(foodPrice);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, editFood);
		
		btnEdit = new JButton("��ŧ");
		setButton(btnEdit,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableFood t = new tableFood();
				t.editData(foodID, fName.getText().trim(), fPrice.getText().trim());
			}
		});
		
		btnDelete = new JButton("ź����");
		setButton(btnDelete,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableFood t = new tableFood();
				t.deleteData(foodID);
			}
		});
	
		return editFood;
	}
	
	public static void getData(int a, String b, String c) {
		foodID = a;
		foodName = b;
		foodPrice = c;
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
