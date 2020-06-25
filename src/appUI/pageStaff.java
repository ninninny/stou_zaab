package appUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.tableStaff;
import javax.swing.*;

public class pageStaff extends styleSetter {
	
	JPanel pageStaff, btnPanel;
	JButton btnAdd;
	
	public  JPanel setPage() {
		
		pageStaff = new JPanel();
		setPanel(pageStaff,0, 0, 375, 587,colorWhite);
		setLabel ("ข้อมูลพนักงาน", "h1",20, 30, 200, 24,colorBlack, pageStaff);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(335,420));
		
		tableStaff tStaff = new tableStaff();
	
		scrollTable.setViewportView(tStaff.dataTable());
		scrollTable.setBounds(20,70,335,420);
		scrollTable.setBorder(BorderFactory.createEmptyBorder());
		pageStaff.add(scrollTable);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, pageStaff);
		
		btnAdd = new JButton("เพิ่มพนักงาน");
		setButton(btnAdd,130, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toAddStaff();
			}
		});
		
		return pageStaff;
	} 

}
