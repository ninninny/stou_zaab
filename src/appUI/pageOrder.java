package appUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.tableOrder;
import javax.swing.*;

public class pageOrder extends styleSetter {
	
	JPanel pageOrder, btnPanel;
	JButton btnAdd;
	
	public  JPanel setPage() {
		
		pageOrder = new JPanel();
		setPanel(pageOrder,0, 0, 375, 587,colorWhite);
		setLabel ("�����Ť���觫���", "h1",20, 25, 200, 40,colorBlack, pageOrder);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(335,420));
		
		tableOrder tOrder = new tableOrder();
	
		scrollTable.setViewportView(tOrder.dataTable());
		scrollTable.setBounds(20,70,335,420);
		scrollTable.setBorder(BorderFactory.createEmptyBorder());
		pageOrder.add(scrollTable);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, pageOrder);
		
		btnAdd = new JButton("����������");
		setButton(btnAdd,130, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toAddOrder();
			}
		});
		
		return pageOrder;
	} 

}
