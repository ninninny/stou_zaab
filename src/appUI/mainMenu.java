package appUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mainMenu  extends styleSetter implements ActionListener{
	
	private JFrame frame = new JFrame("STOU ZAAB : In-house Operation App");
	
	JButton btnMainMenu, btnMainMenu2;
	JPanel topMenu;

	static JPanel mainBody;
	JTable tFood;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu window = new mainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public mainMenu() {
		frame.setBounds(100, 50, 395, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*topMenu*/
		topMenu = new JPanel();
		setPanel(topMenu,0, 0, 375, 80,colorRed1,frame);
		setLabel ("STOU ZAAB", "h3",20, 40, 200, 24,colorWhite, topMenu);
		
		btnMainMenu = new JButton("เมนูหลัก");
		setButton(btnMainMenu,264, 30, 100, 40,colorRed1,colorWhite,topMenu);
		btnMainMenu.addActionListener(this);
		
		/*mainBody*/
		mainBody = new JPanel();
		setPanel(mainBody,0,80,375,587,colorWhite,frame);
		pageHome pHome = new pageHome();
		mainBody.add(pHome.setPage());
		
	} //END mainMenu
	
	/*public void goTo(Class p) throws InstantiationException, IllegalAccessException {
		mainBody.removeAll();
		Object page = p.newInstance();
		mainBody.add(((pageHome) page).setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}*/
	
	public void toHome() {
		mainBody.removeAll();
		pageHome p = new pageHome();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toFood() {
		mainBody.removeAll();
		pageFood p = new pageFood();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toEditFood() {
		mainBody.removeAll();
		editFood p = new editFood();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toAddFood() {
		mainBody.removeAll();
		addFood p = new addFood();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toCustomer() {
		mainBody.removeAll();
		pageCustomer p = new pageCustomer();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toEditCustomer() {
		mainBody.removeAll();
		editCustomer eCust = new editCustomer();
		mainBody.add(eCust.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toAddCustomer() {
		mainBody.removeAll();
		addCustomer aCust = new addCustomer();
		mainBody.add(aCust.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toStaff() {
		mainBody.removeAll();
		pageStaff p = new pageStaff();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toEditStaff() {
		mainBody.removeAll();
		editStaff p = new editStaff();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toAddStaff() {
		mainBody.removeAll();
		addStaff p = new addStaff();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toOrder() {
		mainBody.removeAll();
		pageStaff p = new pageStaff();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toEditOrder() {
		mainBody.removeAll();
		editStaff p = new editStaff();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toAddOreder() {
		mainBody.removeAll();
		addStaff p = new addStaff();
		mainBody.add(p.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toBill() {
		
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == btnMainMenu) {
			toHome();
		}
	};
	
}


