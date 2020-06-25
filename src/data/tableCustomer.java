package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import appUI.*;

public class tableCustomer extends styleSetter{
	
	private DefaultTableModel modelCustomer;
	JTable tCustomer;
	Connection conn = MyConnect.getConnection();
	String custName, custPhone;
	int custID;
	
	public JTable dataTable() {
		
		tCustomer = new JTable();
		Object data[][] = {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}
		};
		String columns[] = {"","Name","Phone Number", ""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tCustomer.setModel(tableModel);
		tCustomer.getColumnModel().getColumn(0).setMaxWidth(40);
		tCustomer.getColumnModel().getColumn(3).setMaxWidth(50);
		tCustomer.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tCustomer.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tCustomer.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		
		setStyle(tCustomer);
		
		modelCustomer = (DefaultTableModel)tCustomer.getModel();
		showData();
		
		tCustomer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int rowClick = tCustomer.getSelectedRow();
				custID = Integer.parseInt(tCustomer.getValueAt(rowClick, 0).toString());
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
				modelCustomer.setValueAt(rs.getString("cus_id"), row, 0);
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
			String sql = "INSERT INTO customer (cus_name, cus_phone) values(?,?)";
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
	
	public void deleteData(int custID2) {
		try {
			String sql = "DELETE FROM customer WHERE cus_id = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,custID2);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toCustomer();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void editData(String custID2, String trim, String trim2) {
		// TODO Auto-generated method stub
		
	}

}
