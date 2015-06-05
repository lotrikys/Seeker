import java.awt.Color;
import java.awt.event.*;
import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.text.*;

public class Click implements ActionListener {
	private final static String newline = "\n";
	SimpleAttributeSet sasr = new SimpleAttributeSet();
	static SimpleAttributeSet sasb = new SimpleAttributeSet();
	BufferedReader reader;
	String filename;
	String sep = "---------------------------------------------------------------------------------------------------------------------";
	static Document doc;
	static String chckip = "1";
	static String chckuser = "1";
	static String chckcpu = "1";
	static String chckmem = "1";
	static String chcksys = "1";
	static String chckrec = "1";
	static String path;
	static BufferedReader reader2;
	static String pathconf;
	static String os;
	static String[] parts2;
	static String ping = "0";

	public void actionPerformed(ActionEvent event) {
		String ip = "";
		String user = "";
		String cpu = "";
		String mem = "";
		String sys = "";
		String rec = "";
		String[] parts;
		String ip1 = "";
		String ip2 = "";
		String ip3 = "";
		String ip4 = "";
		String ip5 = "";
		String ipvnc = "";
		String user1 = "";
		String user2 = "";
		File [] fileslist;
		File filespath = new java.io.File(path);
		fileslist = filespath.listFiles();
		int count = 0;
		window.output.setText("");
		
 
		
		for (int i=0; i<fileslist.length; i++) {
			filename = fileslist[i].getName().toLowerCase();
			if (filename.contains(window.comp.getText().toLowerCase())){
				count++;
				try {
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(filespath + "/" + filename),"Cp1251"));
					String line;
					while ((line = reader.readLine()) != null) {
						if (line.startsWith("IP_Addr")) {
							ip = line;
							parts = ip.split("=");
							ip1 = parts[0] + "=";
							ip2 = parts[1];
							parts = ip2.split(" ");
							ipvnc = parts[0];
							ip3 = parts[0] + " ";
							ip4 = parts[1] + " ";
							ip5 = parts[2];
						} else if (line.startsWith("Current_User")) {
							user = line;
							parts = user.split("=");
							user1 = parts[0] + "=";
							user2 = parts[1];
						} else if (line.startsWith("CPU=")) {
							cpu = line;
						} else if (line.startsWith("Memory_")) {
							mem = line;
						} else if (line.startsWith("System=")) {
							sys = line;
						} else if (line.startsWith("Record_")) {
							rec =line;
						}
					}
					window.ip.setText(ipvnc);
					doc = window.output.getDocument();
					StyleConstants.setForeground(sasr, Color.RED);
					StyleConstants.setForeground(sasb, Color.BLACK);
					if (chckip.equals("1")){
						doc.insertString(doc.getLength(),ip1, sasb);
						doc.insertString(doc.getLength(),ip3, sasr);
						doc.insertString(doc.getLength(),ip4, sasb);
						doc.insertString(doc.getLength(),ip5 + newline, sasr);
					} if (chckuser.equals("1")){
						doc.insertString(doc.getLength(),user1, sasb);
						doc.insertString(doc.getLength(),user2 + newline, sasr);
					} if (chckcpu.equals("1")){
						doc.insertString(doc.getLength(),cpu + newline, sasb);
					} if (chckmem.equals("1")){
						doc.insertString(doc.getLength(),mem + newline, sasb);
					} if (chcksys.equals("1")){
						doc.insertString(doc.getLength(),sys + newline, sasb);
					} if (chckrec.equals("1")){
						doc.insertString(doc.getLength(),rec + newline, sasb);
					}
					doc.insertString(doc.getLength(),sep + newline, sasb);
					reader.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
		}
			window.comp.requestFocus();
			window.comp.selectAll();
		}
		 if (count==0){
				JOptionPane.showMessageDialog(Main.myWindow, "Файл не найден", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}