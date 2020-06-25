package appUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pageHome extends styleSetter implements ActionListener{
	
	JPanel pageHome;
	JButton btnPageFood, btnPageCustomer, btnPageEmployee, btnPageBill, btnPageOrder;
	
	public JPanel setPage() {
		
		pageHome = new JPanel();
		setPanel(pageHome,0, 0, 375, 587,colorWhite);
		
		btnPageFood = new JButton("ข้อมูลเมนูอาหาร");
		setButton(btnPageFood,30, 130, 320, 40,colorWhite,colorOrange1,pageHome);
		btnPageFood.addActionListener(this);
		
		btnPageCustomer = new JButton("ข้อมูลลูกค้าสมาชิก");
		setButton(btnPageCustomer,30, 180, 320, 40,colorWhite,colorOrange1,pageHome);
		btnPageCustomer.addActionListener(this);
		
		btnPageEmployee = new JButton("ข้อมูลพนักงาน");
		setButton(btnPageEmployee,30, 230, 320, 40,colorWhite,colorOrange1,pageHome);
		btnPageEmployee.addActionListener(this);
		
		btnPageBill = new JButton("ข้อมูลใบเสร็จ");
		setButton(btnPageBill,30, 280, 320, 40,colorWhite,colorOrange1,pageHome);
		btnPageBill.addActionListener(this);
		
		btnPageOrder = new JButton("สั่งอาหาร");
		setButton(btnPageOrder,30, 380, 320, 40,colorOrange1,colorWhite,pageHome);
		btnPageOrder.addActionListener(this);
		
		return pageHome;
	}
	
	public void actionPerformed(ActionEvent e) {  
		
		//mainMenu m = new mainMenu();
		if(e.getSource() == btnPageFood) {
			mainMenu.toFood();
		} 
		else if(e.getSource() == btnPageCustomer) {
			mainMenu.toCustomer();
		} 
		else if(e.getSource() == btnPageEmployee) {
			mainMenu.toStaff();
		} 
		else if(e.getSource() == btnPageBill) {
			mainMenu.toBill();
		}
		else if(e.getSource() == btnPageOrder) {
			mainMenu.toOrder();
		}
	}  

}
