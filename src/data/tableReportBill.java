package data;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import appUI.styleSetter;

public class tableReportBill extends styleSetter{
	
	private DefaultTableModel modelBill;
	JTable tRepBill;
	Connection conn = MyConnect.getConnection();
	int billID;
	public int totalPrice;
	public String staffName, custName;
	
	public JTable dataTable(int b) {
		
		billID = b;
		tRepBill = new JTable();
		Object data[][] = {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}
		};
		String columns[] = {"Menu","Price","Amount","Total"};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tRepBill.setModel(tableModel);
		
		tRepBill.getColumnModel().getColumn(1).setMaxWidth(80);
		tRepBill.getColumnModel().getColumn(2).setMaxWidth(60);
		tRepBill.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tRepBill.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tRepBill.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		tRepBill.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );

		setStyle(tRepBill);
		
		modelBill = (DefaultTableModel)tRepBill.getModel();
		showData();

		return tRepBill;
	}
	
	public void showData() {
		try {
			int totalRow = tRepBill.getRowCount()-1;
			while(totalRow>-1) {
				modelBill.removeRow(totalRow);
				totalRow--;
			}
			String sql = "SELECT * FROM bill " 
					+ " INNER JOIN odr ON bill.bill_id = odr.odr_bill_id " 
					+ " INNER JOIN food ON odr.odr_food_id = food.food_id " 
					+ " INNER JOIN customer ON customer.cus_id = 1 " 
					+ " INNER JOIN staff ON staff.staff_id = 1 " 
					+ " WHERE bill.bill_id = " + billID;
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			int row = 0;
			while(rs.next()) {
				modelBill.addRow(new Object[0]);
				modelBill.setValueAt(rs.getString("food_name"), row, 0);
				modelBill.setValueAt(rs.getInt("odr_price"), row, 1);
				modelBill.setValueAt(rs.getInt("odr_amount"), row, 2);
				modelBill.setValueAt(rs.getInt("odr_price")*rs.getInt("odr_amount"), row, 3);
				totalPrice += rs.getInt("odr_price")*rs.getInt("odr_amount");
				staffName = rs.getString("staff_name");
				custName = rs.getString("cus_name");
				row++;
			}
			
			System.out.println(staffName);
			
			tRepBill.setModel(modelBill);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 

}
