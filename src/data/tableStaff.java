package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import appUI.*;

public class tableStaff extends styleSetter{
	
	private DefaultTableModel modelStaff;
	JTable tStaff;
	Connection conn = MyConnect.getConnection();
	int staffID;
	String staffName, staffPhone;
	
	public JTable dataTable() {
		
		tStaff = new JTable();
		Object data[][] = {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}
		};
		String columns[] = {"","Name","Phone", ""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tStaff.setModel(tableModel);
		
		tStaff.getColumnModel().getColumn(0).setMaxWidth(40);
		tStaff.getColumnModel().getColumn(3).setMaxWidth(50);
		tStaff.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tStaff.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tStaff.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		
		setStyle(tStaff);
		
		modelStaff = (DefaultTableModel)tStaff.getModel();
		showData();
		
		tStaff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int rowClick = tStaff.getSelectedRow();
				staffID = Integer.parseInt (tStaff.getValueAt(rowClick, 0).toString());
				staffName = tStaff.getValueAt(rowClick, 1).toString();
				staffPhone = tStaff.getValueAt(rowClick, 2).toString();
	            editStaff.getData(staffID,staffName,staffPhone);
	            mainMenu.toEditStaff();
			}
		});

		return tStaff;
	}
	
	public void showData() {
		try {
			int totalRow = tStaff.getRowCount()-1;
			while(totalRow>-1) {
				modelStaff.removeRow(totalRow);
				totalRow--;
			}
			String sql = "SELECT * FROM staff";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			int row = 0;
			while(rs.next()) {
				modelStaff.addRow(new Object[0]);
				modelStaff.setValueAt(rs.getString("staff_id"), row, 0);
				modelStaff.setValueAt(rs.getString("staff_name"), row, 1);
				modelStaff.setValueAt(rs.getString("staff_phone"), row, 2);
				modelStaff.setValueAt("·°È‰¢", row, 3);
				row++;
			}
			tStaff.setModel(modelStaff);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	public void insertData(String name, String phone) {
		try {
			String sql = "INSERT INTO staff (staff_name, staff_phone) values(?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,name);
			pre.setString(2,phone);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toStaff();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editData(int id, String name, String phone) {
		try {
				String sql = "UPDATE staff SET  staff_name =?, staff_phone=? WHERE staff_id =?";
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setString(1,name);
				pre.setString(2,phone);
				pre.setInt(3,id);
				
				if(pre.executeUpdate() != -1) {
					mainMenu.toStaff();
				}
				
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteData(int id) {
		try {
			String sql = "DELETE FROM staff WHERE staff_id = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toStaff();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

}
