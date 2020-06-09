package appUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.tableFood;
import javax.swing.*;

public class pageFood extends styleSetter {
	
	JPanel pageFood, btnPanel;
	JButton btnAdd;
	
	public  JPanel setPage() {
		
		pageFood = new JPanel();
		setPanel(pageFood,0, 0, 375, 587,colorWhite);
		setLabel ("ข้อมูลเมนูอาหาร", "h1",20, 30, 200, 24,colorBlack, pageFood);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(335,420));
		
		tableFood tFood = new tableFood();
	
		scrollTable.setViewportView(tFood.dataTable());
		scrollTable.setBounds(20,70,335,420);
		scrollTable.setBorder(BorderFactory.createEmptyBorder());
		pageFood.add(scrollTable);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, pageFood);
		
		btnAdd = new JButton("เพิ่มเมนู");
		setButton(btnAdd,130, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toAddFood();
			}
		});
		
		return pageFood;
	} 

}
