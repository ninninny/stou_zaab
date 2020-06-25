package appUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import data.*;

public class reportBill extends styleSetter {
	
	JPanel reportBill, btnPanel;
	static int billID;
	static String stringBill;
	JButton btnBack, btnCheckout;
	
	public  JPanel setPage() {
		
		reportBill = new JPanel();
		setPanel(reportBill,0, 0, 375, 587,colorWhite);
		setLabel ("รายละเอียดใบเรียกเก็บเงิน", "h1",20, 30, 300, 24,colorBlack, reportBill);
		
		setLabel ("เลขที่บิล", "small",20, 70, 50, 24,colorGray, reportBill);
		setLabel (Integer.toString(billID), null,20, 90, 50, 24,colorBlack, reportBill);
		setLabel ("ลูกค้า", "small",100, 70, 250, 24,colorGray, reportBill);
		
		setLabel ("พนักงานเก็บเงิน", "small",100, 130, 250, 24,colorGray, reportBill);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setPreferredSize(new Dimension(335,420));
		
		tableReportBill tRepBill = new tableReportBill();
	
		scrollTable.setViewportView(tRepBill.dataTable(billID));
		scrollTable.setBounds(20,210,335,220);
		scrollTable.setBorder(BorderFactory.createEmptyBorder());
		reportBill.add(scrollTable);
		
		setLabel (tRepBill.custName, null,100, 90, 250, 24,colorBlack, reportBill);
		setLabel (tRepBill.staffName, null,100, 150, 250, 24,colorBlack, reportBill);
		setLabel ("ยอดเงินรวม", "small",100, 450, 250, 24,colorGray, reportBill);
		setLabel (Integer.toString(tRepBill.totalPrice)+" บาท", "h1",180, 450, 100, 24,colorBlack, reportBill);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, reportBill);
		
		btnBack = new JButton("กลับ");
		setButton(btnBack,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toBill();
			}
		});
		
		btnCheckout = new JButton("เช็คบิล");
		setButton(btnCheckout,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnCheckout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		return reportBill;
	} 
	
	public static void getData(int a) {
		billID = a;
	}

}
