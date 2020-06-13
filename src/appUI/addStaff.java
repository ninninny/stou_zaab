package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.tableStaff;

public class addStaff extends styleSetter implements ActionListener{
	
	JPanel addStaff, btnPanel;
	JTextField sName, sPhone;
	JButton btnEdit, btnDelete;
	
	public  JPanel setPage() {
		
		addStaff = new JPanel();
		setPanel (addStaff,0, 0, 375, 587,colorWhite);
		setLabel ("เพิ่มข้อมูลพนักงาน", "h1",20, 30, 200, 24,colorBlack, addStaff);
		setLabel ("ชื่อ-นามสกุล",null,20, 100, 200, 24,colorGray, addStaff);
		setLabel ("เบอร์โทรศัพท์",null,20, 200, 200, 24,colorGray, addStaff);
		
		sName = new JTextField();
		setTextField(sName, 20, 130,330,40,addStaff);
		
		sPhone = new JTextField();
		setTextField(sPhone, 20, 230,330,40,addStaff);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, addStaff);
		
		btnEdit = new JButton("ตกลง");
		setButton(btnEdit,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableStaff t = new tableStaff();
				t.insertData(sName.getText().trim(), sPhone.getText().trim());
			}
		});
		
		btnDelete = new JButton("ยกเลิก");
		setButton(btnDelete,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toStaff();
			}
		});
	
		return addStaff;
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
