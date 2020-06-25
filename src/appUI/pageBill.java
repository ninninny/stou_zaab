package appUI;

import java.awt.Dimension;
import data.tableBill;
import javax.swing.*;

public class pageBill extends styleSetter {
	
	JPanel pageBill, btnPanel;
	JButton btnAdd;
	
	public  JPanel setPage() {
		
		pageBill = new JPanel();
		setPanel(pageBill,0, 0, 375, 587,colorWhite);
		setLabel ("ข้อมูลใบเรียกเก็บเงิน", "h1",20, 30, 200, 24,colorBlack, pageBill);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(335,420));
		
		tableBill tBill = new tableBill();
	
		scrollTable.setViewportView(tBill.dataTable());
		scrollTable.setBounds(20,70,335,420);
		scrollTable.setBorder(BorderFactory.createEmptyBorder());
		pageBill.add(scrollTable);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, pageBill);
		
		return pageBill;
	} 

}
