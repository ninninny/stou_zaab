package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.tableStaff;

public class editStaff extends styleSetter implements ActionListener{
	
	JPanel editStaff, btnPanel;
	JTextField sName, sPhone;
	JButton btnEdit, btnDelete;
	static int staffID;
	static String staffName, staffPhone;
	
	public  JPanel setPage() {
		
		editStaff = new JPanel();
		setPanel(editStaff,0, 0, 375, 587,colorWhite);
		setLabel ("แก้ไขข้อมูลพนักงาน", "h1",20, 30, 200, 24,colorBlack, editStaff);
		setLabel ("ชื่อ-นามสกุล",null,20, 100, 200, 24,colorGray, editStaff);
		setLabel ("เบอร์โทรศัพท์",null,20, 200, 200, 24,colorGray, editStaff);
		
		sName = new JTextField();
		setTextField(sName, 20, 130,330,40,editStaff);
		sName.setText(staffName);
		
		sPhone = new JTextField();
		setTextField(sPhone, 20, 230,330,40,editStaff);
		sPhone.setText(staffPhone);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, editStaff);
		
		btnEdit = new JButton("ตกลง");
		setButton(btnEdit,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableStaff t = new tableStaff();
				t.editData(staffID, sName.getText().trim(), sPhone.getText().trim());
			}
		});
		
		btnDelete = new JButton("ลบพนักงาน");
		setButton(btnDelete,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tableStaff t = new tableStaff();
				t.deleteData(staffID);
			}
		});
	
		return editStaff;
	}
	
	public static void getData(int a, String b, String c) {
		staffID = a;
		staffName = b;
		staffPhone = c;
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
