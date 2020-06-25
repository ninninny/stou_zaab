package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import appUI.editFood;
import appUI.mainMenu; 
import appUI.styleSetter;

public class tableBill extends styleSetter{
	
	private DefaultTableModel modelBill;
	JTable tBill;
	Connection conn = MyConnect.getConnection();
	int foodID;
	String foodName, foodPrice;
	public ArrayList<Integer> billList;
	
	public JTable dataTable() {
		
		tBill = new JTable();
		Object data[][] = {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null}
		};
		String columns[] = {"Bill.no","Total",""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tBill.setModel(tableModel);
		setStyle(tBill);
		
		modelBill = (DefaultTableModel)tBill.getModel();
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

		return tBill;
	}
	
	public void showData() {
		try {
			int totalRow = tBill.getRowCount()-1;
			while(totalRow>-1) {
				modelBill.removeRow(totalRow);
				totalRow--;
			}
			String sql = "SELECT * FROM bill ";
					//+ " INNER JOIN odr ON bill.bill_odr_id = odr.odr_id"
					//+" INNER JOIN customer ON bill_cust_id = customer.cus_id"
					//+ " INNER JOIN staff ON bill_staff_id = staff.staff_id";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			int row = 0;
			while(rs.next()) {
				modelBill.addRow(new Object[0]);
				modelBill.setValueAt(rs.getString("bill_id"), row, 0);
				String total = rs.getString("bill_total");
				if(Integer.parseInt(total)== 0) {
					total = "ÂÑ§äÁèä´éªÓÃÐ";
				}
				modelBill.setValueAt(total, row, 1);
                modelBill.setValueAt("Detail", row, 2);

				row++;
			}
			tBill.setModel(modelBill);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	public ArrayList<Integer> listBill() {
		billList = new ArrayList<Integer>();
		try {
			String sql = "SELECT * FROM bill";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				billList.add(rs.getInt("bill_id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return billList; 
	}
	
	public void insertData(String name, int amount) {
		try {
			String sqlSearchFood = "SELECT * FROM food";
			System.out.println(sqlSearchFood);
			ResultSet searchFood  = conn.createStatement().executeQuery(sqlSearchFood);
			while(searchFood.next()) {
				String food_name = searchFood.getString(2);
				if(food_name.contentEquals(name)) {
					int food_id = searchFood.getInt(1);
					int food_cost = searchFood.getInt(3);
					System.out.println(food_id+food_name+food_cost);
					
					String sql1 = "INSERT INTO bill  (bill_id, bill_total) values(null,0)";
					PreparedStatement pre1 = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
					
					if(pre1.executeUpdate() < 1) {
						throw new SQLException("Cannot insert into bill");
					}
					try(ResultSet generatedKey = pre1.getGeneratedKeys() ) {
						if(generatedKey.next()) {
							 int  bill_id = generatedKey.getInt(1);
							 System.out.println(bill_id);//for debug
							 String sql2 = "INSERT INTO odr (odr_id, odr_food_id, odr_amount, odr_price, odr_bill_id) values(null,?,?,?,?)";
								PreparedStatement pre2 = conn.prepareStatement(sql2);
								pre2.setInt(1,food_id);
								pre2.setInt(2,amount);
								pre2.setDouble(3, food_cost);
								pre2.setInt(4, bill_id);
							
								if(pre2.executeUpdate() != -1) {
									mainMenu.toOrder();
								}
						}
					}
					
					return;
				}
			}
			throw new SQLException("Cannot find food_name:"+name);
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteData(int id) {
		/*try {
			String sql = "DELETE FROM food WHERE food_id = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			
			if(pre.executeUpdate() != -1) {
				mainMenu.toFood();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}*/
	}

}
