package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import appUI.editFood;
import appUI.mainMenu; 
import appUI.styleSetter;

public class tableFood extends styleSetter{
	
	private DefaultTableModel modelFood;
	JTable tFood;
	Connection conn = MyConnect.getConnection();
	int foodID;
	String foodName, foodPrice;
	public ArrayList<String> foodList;
	
	public JTable dataTable() {
		
		tFood = new JTable();
		Object data[][] = {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}
		};
		String columns[] = {"","Menu","Price", ""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tFood.setModel(tableModel);
		setStyle(tFood);
		
		modelFood = (DefaultTableModel)tFood.getModel();
		showData();
		//System.out.print(foodList);
		
		tFood.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int rowClick = tFood.getSelectedRow();
				foodID = (int) tFood.getValueAt(rowClick, 0);
	            foodName = tFood.getValueAt(rowClick, 1).toString();
	            foodPrice = tFood.getValueAt(rowClick, 2).toString();
	            editFood.getData(foodID,foodName,foodPrice);
	            mainMenu.toEditFood();
			}
		});

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
			
			foodList = new ArrayList<String>();
			int row = 0;
			while(rs.next()) {
				modelFood.addRow(new Object[0]);
				modelFood.setValueAt(rs.getInt("food_id"), row, 0);
				modelFood.setValueAt(rs.getString("food_name"), row, 1);
				modelFood.setValueAt(rs.getString("food_cost"), row, 2);
				modelFood.setValueAt("·°È‰¢", row, 3);
				foodList.add(rs.getString("food_name"));
				row++;
			}
			tFood.setModel(modelFood);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	public ArrayList<String> listFood() {
		try {
			String sql = "SELECT * FROM food";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			foodList = new ArrayList<String>();
			while(rs.next()) {
				foodList.add(rs.getString("food_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return foodList; 
	}
	
	public void insertData(String name, String price) {
		try {
			String sql = "INSERT INTO food  (food_id, food_name, food_cost) values(null,?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,name);
			pre.setString(2,price);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toFood();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editData(int id, String name, String price) {
		try {
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
		}
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
