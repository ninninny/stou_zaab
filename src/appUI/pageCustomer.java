package appUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.tableCustomer;
import javax.swing.*;

public class pageCustomer extends styleSetter {
	
	JPanel pageCustomer, btnPanel;
	JButton btnAdd;
	
	public  JPanel setPage() {
		
		pageCustomer = new JPanel();
		setPanel(pageCustomer,0, 0, 375, 587,colorWhite);
		setLabel ("ข้อมูลลูกค้าสมาชิก", "h1",20, 30, 200, 24,colorBlack, pageCustomer);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(335,420));
		
		tableCustomer tCust = new tableCustomer();
	
		scrollTable.setViewportView(tCust.dataTable());
		scrollTable.setBounds(20,70,335,420);
		scrollTable.setBorder(BorderFactory.createEmptyBorder());
		pageCustomer.add(scrollTable);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, pageCustomer);
		
		btnAdd = new JButton("เพิ่มสมาชิก");
		setButton(btnAdd,130, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toAddCustomer();
			}
		});
		
		return pageCustomer;
	} 

}
