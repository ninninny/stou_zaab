package appUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import data.tableOrder;
import data.tableBill;
import data.tableFood;

public class addOrder extends styleSetter {
	
	JPanel addOrder, btnPanel;
	JTextField amount;
	JButton btnEdit, btnDelete;
	JRadioButton rdBillEx, rdBillNew;
	
	public  JPanel setPage() {
		
		addOrder = new JPanel();
		setPanel (addOrder,0, 0, 375, 587,colorWhite);
		setLabel ("เพิ่มคำสั่งซื้อ", "h1",20, 25, 200, 30,colorBlack, addOrder);
		setLabel ("อาหาร",null,20, 250, 200, 24,colorGray, addOrder);
		setLabel ("จำนวน",null,20, 350, 200, 24,colorGray, addOrder);
		
		rdBillEx = new JRadioButton("เลือกบิลเดิม");
		setRadioBtn(rdBillEx,20, 100, 100, 40, addOrder);
		rdBillNew = new JRadioButton("เปิดบิลใหม่");
		setRadioBtn(rdBillNew,20, 180, 100, 40, addOrder);
		ButtonGroup groupBill = new ButtonGroup();
		groupBill.add(rdBillEx);
		groupBill.add(rdBillNew);
		
		Vector<Integer> billExID = new Vector<Integer>();
		tableBill dataBill = new tableBill();
		int d = dataBill.listBill().size();
		for( int i=0 ; i<d ; i++) {	
			billExID.addElement(dataBill.billList.get(i));
		}
		
		JComboBox<Integer> comboExBill = new JComboBox<>(billExID);
		setComboBox(comboExBill,"เลือก",150, 100, 200, 40,addOrder);
		
		Vector<String> foodMenu = new Vector<String>();
		tableFood dataFood = new tableFood();
		int c = dataFood.listFood().size();
		for( int i=0 ; i<c ; i++) {	
			foodMenu.addElement(dataFood.foodList.get(i));
		}
		
		JComboBox<String> comboFood = new JComboBox<>(foodMenu);
		setComboBox(comboFood,"เลือกอาหาร",20, 280, 330, 40,addOrder);
		
		amount = new JTextField();
		setTextField(amount, 20, 380,330,40,addOrder);
		
		btnPanel = new JPanel();
		setPanel(btnPanel,0, 500, 375, 60,colorWhite, addOrder);
		
		btnEdit = new JButton("ตกลง");
		setButton(btnEdit,95, 0,84, 40,colorOrange1, colorWhite, btnPanel);
		btnEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String f = comboFood.getSelectedItem().toString();
				int c = Integer.parseInt(amount.getText());
				if(rdBillEx.isSelected()) {
					int b = (int) comboExBill.getSelectedItem();
					tableOrder t = new tableOrder();
					t.insertData(f,c,b);
					System.out.println(f+" x "+c+" to bill: "+b);
				} else if(rdBillNew.isSelected()) {
					tableBill b = new tableBill();
					b.insertData(f,c);
				}
				
			}
		});
		
		btnDelete = new JButton("ยกเลิก");
		setButton(btnDelete,190, 0,84, 40,colorRed1, colorWhite, btnPanel);
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mainMenu.toOrder();
			}
		});
	
		return addOrder;
	} 

}
