package data;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import appUI.styleSetter;

public class tableFood extends styleSetter{
	
	private DefaultTableModel modelFood;
	JTable tFood;
	Connection conn = MyConnect.getConnection();
	
	public JTable dataTable() {
		
		tFood = new JTable();
		Object data[][] = {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null}
		};
		String columns[] = {"ชื่อเมนู","ราคา", ""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tFood.setModel(tableModel);
		setUIfont(tFood);
		
		modelFood = (DefaultTableModel)tFood.getModel();
		showData();
		
		return tFood;
		
	}
	
	public void showData() {
		try {
			int totalRow = tFood.getRowCount()-1;
			while(totalRow>-1) {
				modelFood.removeRow(totalRow);
				totalRow--;
			}
			String sql = "SELECT * FROM food";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			int row = 0;
			while(rs.next()) {
				modelFood.addRow(new Object[0]);
				modelFood.setValueAt(rs.getString("food_name"), row, 0);
				modelFood.setValueAt(rs.getString("food_cost"), row, 1);
				row++;
			}
			tFood.setModel(modelFood);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 

}
