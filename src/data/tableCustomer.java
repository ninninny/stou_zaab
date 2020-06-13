package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import appUI.*;

public class tableCustomer extends styleSetter{
	
	private DefaultTableModel modelCustomer;
	JTable tCustomer;
	Connection conn = MyConnect.getConnection();
	int custID;
	String custName, custPhone;
	
	public JTable dataTable() {
		
		tCustomer = new JTable();
		Object data[][] = {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}
		};
		String columns[] = {"","√“¬™◊ËÕ","‡∫Õ√Ï‚∑√»—æ∑Ï", ""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tCustomer.setModel(tableModel);
		setStyle(tCustomer);
		
		modelCustomer = (DefaultTableModel)tCustomer.getModel();
		showData();
		
		tCustomer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int rowClick = tCustomer.getSelectedRow();
				custID = (int) tCustomer.getValueAt(rowClick, 0);
				custName = tCustomer.getValueAt(rowClick, 1).toString();
				custPhone = tCustomer.getValueAt(rowClick, 2).toString();
	            editCustomer.getData(custID,custName,custPhone);
	            mainMenu.toEditCustomer();
			}
		});

		return tCustomer;
	}
	
	public void showData() {
		try {
			int totalRow = tCustomer.getRowCount()-1;
			while(totalRow>-1) {
				modelCustomer.removeRow(totalRow);
				totalRow--;
			}
			String sql = "SELECT * FROM customer";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			int row = 0;
			while(rs.next()) {
				modelCustomer.addRow(new Object[0]);
				modelCustomer.setValueAt(rs.getInt("cus_id"), row, 0);
				modelCustomer.setValueAt(rs.getString("cus_name"), row, 1);
				modelCustomer.setValueAt(rs.getString("cus_phone"), row, 2);
				modelCustomer.setValueAt("·°È‰¢", row, 3);
				row++;
			}
			tCustomer.setModel(modelCustomer);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	public void insertData(String name, String phone) {
		try {
			String sql = "INSERT INTO customer (cus_id, cus_name, cus_phone) values(null,?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,name);
			pre.setString(2,phone);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toCustomer();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editData(int id, String name, String phone) {
		try {
				String sql = "UPDATE customer SET  cus_name =?, cus_phone=? WHERE cus_id =?";
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setString(1,name);
				pre.setString(2,phone);
				pre.setInt(3,id);
				
				if(pre.executeUpdate() != -1) {
					mainMenu.toCustomer();
				}
				
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteData(int id) {
		try {
			String sql = "DELETE FROM customer WHERE cus_id = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toCustomer();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

}
