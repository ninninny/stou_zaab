package appUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

public class styleSetter {
	
	Color colorOrange1 = new Color(238,122,5);
	Color colorOrange2 = new Color(250,220,188);
	Color colorRed1 = new Color(238,81,63);
	Color colorGray = new Color(129,138,145);
	Color colorLightGray = new Color(226,226,226);
	Color colorWhite = Color.white;
	Color colorBlack = Color.black;
	String themeFont = "Tahoma";
	
	/* ELEMENTS SETUP */
	public void setLabel (String text, String type,int x, int y, int w, int h, Color c, JPanel target) {
		JLabel id = new JLabel(text);
		setUIfont(id, type);
		id.setBounds(x, y, w, h);
		id.setForeground(c);
		target.add(id);
	}
	
	public void setButton(JButton id,int x, int y, int w, int h,Color c, Color fc, JPanel target) {
		setUIfont(id);
		id.setBounds(x, y, w, h);
		id.setForeground(fc);
		id.setBorder(new LineBorder(fc,2));
		id.setBackground(c);
		id.setContentAreaFilled(false);
		id.setOpaque(true);
		id.setFocusPainted(false);
		target.add(id);
	}
	public void setPanel(JPanel id,int x, int y, int w, int h,Color c) {
		id.setBounds(x, y, w, h);
		id.setBackground(c);
		id.setLayout(null);
		id.setBorder(BorderFactory.createLineBorder(colorWhite));
	}
	public void setPanel(JPanel id,int x, int y, int w, int h,Color c, JPanel target) {
		id.setBounds(x, y, w, h);
		id.setBackground(c);
		id.setLayout(null);
		id.setBorder(BorderFactory.createLineBorder(colorWhite));
		target.add(id);
	}
	public void setPanel(JPanel id,int x, int y, int w, int h,Color c, JFrame target) {
		id.setBounds(x, y, w, h);
		id.setBackground(c);
		id.setLayout(null);
		id.setBorder(BorderFactory.createLineBorder(colorWhite));
		target.getContentPane().add(id);
	}
	protected void setTextField(JTextField id,int x, int y, int w, int h, JPanel target) {
		setUIfont(id);
		id.setBounds(x, y, w, h);
		target.add(id);
	}
	public void setStyle(JTable t) {
		setUIfont(t);
		t.setBackground(colorWhite);
		t.setForeground(colorBlack);
		t.setSelectionBackground(colorOrange2);
		t.setRowHeight(40);
		t.setShowGrid(false);
		t.setShowHorizontalLines(true);
		t.setGridColor(colorLightGray);
		
		JTableHeader header = t.getTableHeader();
	    header.setBackground(colorWhite);
	    header.setForeground(colorBlack);
	    
	}

	/* SET FONT STYLE FOR ALL UI ELEMENT */
	public void setUIfont(JLabel e, String t) {
		if(t=="h1") {
			e.setFont(new Font(themeFont, Font.BOLD, 21));
		} else if(t=="h2") {
			e.setFont(new Font(themeFont, Font.PLAIN, 16));
		} else if(t=="h3") {
			e.setFont(new Font(themeFont, Font.BOLD, 14));
		} else if(t=="small") {
			e.setFont(new Font(themeFont, Font.PLAIN, 11));
		} else {
			e.setFont(new Font(themeFont, Font.PLAIN, 12));
		}
	}

	public void setUIfont(JButton e) {
		e.setFont(new Font(themeFont, Font.BOLD, 12));
	}
	public void setUIfont(JTextField e) {
		e.setFont(new Font(themeFont, Font.BOLD, 12));
	}
	public void setUIfont(JTable e) {
		e.setFont(new Font(themeFont, Font.PLAIN, 14));
	}
}
