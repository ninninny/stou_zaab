package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.tableCustomer;

public class editCustomer extends styleSetter implements ActionListener{
	
	JPanel editCustomer, btnPanel;
	JTextField cName, cPhone;
	JButton btnEdit, btnDelete;
	static int custID;
	static String custName, custPhone;
	
	public  JPanel setPage() {
		
		editCustomer = new JPanel();
		setPanel(editCustomer,0, 0, 375, 587,colorWhite);
		setLabel ("��䢢�������Ҫԡ", "h1",20, 30, 200, 24,colorBlack, editCustomer);
		setLabel ("����-���ʡ��",null,20, 100, 200, 24,colorGray, editCustomer);
		setLabel ("�������Ѿ��",null,20, 200, 200, 24,colorGray, editCustomer);
		
		cName = new JTextField();
		setTextField(cName, 20, 130,330,40,editCustomer);
		cName.setText(custName);
		
		cPhone = new JTextField();
		setTextField(cPhone, 20, 230,330,40,editCustomer);
		cPhone.setText(custPhone);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, editCustomer);
		
		btnEdit = new JButton("��ŧ");
		setButton(btnEdit,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableCustomer t = new tableCustomer();
				t.editData(custID, cName.getText().trim(), cPhone.getText().trim());
			}
		});
		
		btnDelete = new JButton("ź��Ҫԡ");
		setButton(btnDelete,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableCustomer t = new tableCustomer();
				t.deleteData(custID);
			}
		});
	
		return editCustomer;
	}
	
	public static void getData(int custID2, String b, String c) {
		custID = custID2;
		custName = b;
		custPhone = c;
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
