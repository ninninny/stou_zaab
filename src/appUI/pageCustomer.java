package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pageCustomer extends styleSetter implements ActionListener{
	
	JPanel pageCustomer;
	
	public  JPanel setPage() {
		
		pageCustomer = new JPanel();
		setPanel(pageCustomer,0, 0, 375, 587,colorWhite);
		setLabel ("ข้อมูลลูกค้าสมาชิก", "h1",20, 40, 200, 24,colorBlack, pageCustomer);
		
		return pageCustomer;
	}

	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
