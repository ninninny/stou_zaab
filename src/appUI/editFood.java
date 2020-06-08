package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class editFood extends styleSetter implements ActionListener{
	
	JPanel editFood;
	
	public  JPanel setPage() {
		
		editFood = new JPanel();
		setPanel(editFood,0, 0, 375, 587,colorWhite);
		setLabel ("แก้ไขเมนูอาหาร", "h1",20, 30, 200, 24,colorBlack, editFood);
		
		
		
		return editFood;
	}

	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
