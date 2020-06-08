package appUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.tableFood;

import javax.swing.*;

public class pageFood extends styleSetter implements ActionListener{
	
	JPanel pageFood;
	
	public  JPanel setPage() {
		
		pageFood = new JPanel();
		setPanel(pageFood,0, 0, 375, 587,colorWhite);
		setLabel ("ข้อมูลเมนูอาหาร", "h1",20, 30, 200, 24,colorBlack, pageFood);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(330,420));
		
		tableFood tFood = new tableFood();
	
		scrollTable.setViewportView(tFood.dataTable());
		scrollTable.setBounds(20,70,330,420);
		scrollTable.setBorder(BorderFactory.createEmptyBorder());
		pageFood.add(scrollTable);
		
		return pageFood;
	}

	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == null) {
			
		} 
	}  

}
