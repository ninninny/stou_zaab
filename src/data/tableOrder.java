package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import appUI.editFood;
import appUI.mainMenu; 
import appUI.styleSetter;

public class tableOrder extends styleSetter{
	
	private DefaultTableModel modelOrder;
	JTable tOrder;
	Connection conn = MyConnect.getConnection();
	int foodID;
	String foodName, foodPrice;
	
	public JTable dataTable() {
		
		tOrder = new JTable();
		Object data[][] = {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}
		};
		String columns[] = {"บิลที่","อาหาร", "จำนวน", ""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tOrder.setModel(tableModel);
		setStyle(tOrder);
		
		modelOrder = (DefaultTableModel)tOrder.getModel();
		showData();
		
		/*tOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int rowClick = tOrder.getSelectedRow();
				foodID = (int) tOrder.getValueAt(rowClick, 0);
	            foodName = tOrder.getValueAt(rowClick, 1).toString();
	            foodPrice = tOrder.getValueAt(rowClick, 2).toString();
	            editFood.getData(foodID,foodName,foodPrice);
	            mainMenu.toEditFood();
			}
		});*/

		return tOrder;
	}
	
	public void showData() {
		try {
			int totalRow = tOrder.getRowCount()-1;
			while(totalRow>-1) {
				modelOrder.removeRow(totalRow);
				totalRow--;
			}
			String sql = "SELECT * FROM odr INNER JOIN food "
					+ "ON odr.odr_food_id = food.food_id";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			int row = 0;
			while(rs.next()) {
				modelOrder.addRow(new Object[0]);
				modelOrder.setValueAt(rs.getString("odr_bill_id"), row, 0);
				modelOrder.setValueAt(rs.getString("food_name"), row, 1);
				modelOrder.setValueAt(rs.getString("odr_amount"), row, 2);
				modelOrder.setValueAt("แก้ไข", row, 3);
				row++;
			}
			tOrder.setModel(modelOrder);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	public void insertData(String food, int amount, int billID) {
		try {
			String sql = "INSERT INTO order (order_id, odr_food_id, order_amount, adr_price, odr_bill_id) values(null,?,?,?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			//pre.setInt(1,foodID);
			pre.setInt(2,amount);
			//pre.setInt(3, price);
			pre.setInt(4, billID);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toFood();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editData(int id, String name, String price) {
		/*try {
				String sql = "UPDATE food SET  food_name =?, food_cost=? WHERE food_id =?";
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setString(1,name);
				pre.setString(2,price);
				pre.setInt(3,id);
				
				if(pre.executeUpdate() != -1) {
					mainMenu.toFood();
				}
				
		} catch(SQLException ex) {
			ex.printStackTrace();
		}*/
	}
	
	public void deleteData(int id) {
		try {
			String sql = "DELETE FROM food WHERE food_id = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toFood();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

}
