import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.*;


public class Main {
	static JFrame myWindow;

	public static void main (String [] args) {
		myWindow = new window();
		myWindow.setSize(515, 450);
		myWindow.setLocationRelativeTo(null);
		myWindow.setVisible(true);	
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setResizable(false);
		
		try {
			Click.os = System.getProperty("os.name").toLowerCase();
			if (Click.os.contains("windows")){
				Click.pathconf = "config.ini";
			} else {
				Click.pathconf = "Seeker/config.ini";
			}
			Click.reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(Click.pathconf),"Cp1251"));
			String line;
			while ((line = Click.reader2.readLine()) != null) {
				if (line.contains("ip")) {
					Click.parts2 = line.split("=");
					Click.chckip = Click.parts2[1];
				} if (line.contains("user")){
					Click.parts2 = line.split("=");
					Click.chckuser = Click.parts2[1];
				} if (line.contains("cpu")){
					Click.parts2 = line.split("=");
					Click.chckcpu = Click.parts2[1];
				} if (line.contains("mem")){
					Click.parts2 = line.split("=");
					Click.chckmem = Click.parts2[1];
				} if (line.contains("sys")){
					Click.parts2 = line.split("=");
					Click.chcksys = Click.parts2[1];
				} if (line.contains("rec")){
					Click.parts2 = line.split("=");
					Click.chckrec = Click.parts2[1];
				} if (line.contains("path=")){
					Click.parts2 = line.split("=");
					Click.path = Click.parts2[1];
				} if (line.contains("ping=")){
					Click.parts2 = line.split("=");
					Click.ping = Click.parts2[1];
				}
			}
			Click.reader2.close();
		}  catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Файл настроек не найден", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		
	}
	
}