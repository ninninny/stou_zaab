package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.tableCustomer;

public class addCustomer extends styleSetter implements ActionListener{
	
	JPanel addCustomer, btnPanel;
	JTextField cName, cPhone;
	JButton btnEdit, btnDelete;
	
	public  JPanel setPage() {
		
		addCustomer = new JPanel();
		setPanel (addCustomer,0, 0, 375, 587,colorWhite);
		setLabel ("เพิ่มข้อมูลสมาชิก", "h1",20, 30, 200, 24,colorBlack, addCustomer);
		setLabel ("ชื่อ-นามสกุล",null,20, 100, 200, 24,colorGray, addCustomer);
		setLabel ("เบอร์โทรศัพท์",null,20, 200, 200, 24,colorGray, addCustomer);
		
		cName = new JTextField();
		setTextField(cName, 20, 130,330,40,addCustomer);
		
		cPhone = new JTextField();
		setTextField(cPhone, 20, 230,330,40,addCustomer);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, addCustomer);
		
		btnEdit = new JButton("ตกลง");
		setButton(btnEdit,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableCustomer t = new tableCustomer();
				t.insertData(cName.getText().trim(), cPhone.getText().trim());
			}
		});
		
		btnDelete = new JButton("ยกเลิก");
		setButton(btnDelete,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toCustomer();
			}
		});
	
		return addCustomer;
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
