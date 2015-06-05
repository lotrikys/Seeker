import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class window extends JFrame{
	private static final long serialVersionUID = -6101548397373541431L;
	static JTextField comp;
	static JTextField ip;
	static JTextPane output;
	static JLabel label;
	static JLabel label2;
	static JButton exec;
	static JButton vnc;
	static JButton ping;
	static JScrollPane sp;
	static String str1 = "";
	static JMenuItem option;

	window() {
		super ("Seeker...");
		Box mainbox = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		label = new JLabel ("Введите инв № ПК:");
		label.setSize(180, 30);
		label.setLocation(10, 15);
		comp = new JTextField ();
		comp.setSize(200,30);
		comp.setLocation(160, 15);
		comp.addActionListener (new Click());
		exec = new JButton ("Найти");
		exec.setSize(90, 30);
		exec.setLocation(390, 15);
		exec.addActionListener(new Click());
		label2 = new JLabel ("Введите IP:");
		label2.setSize(180, 30);
		label2.setLocation(30, 60);
		ip = new JTextField ();
		ip.setSize(200, 30);
		ip.setLocation(160,60);
		ip.addActionListener(new vnc());
		vnc = new JButton ("VNC");
		vnc.setSize(65, 30);
		vnc.setLocation(365, 60);
		vnc.addActionListener(new vnc());
		ping = new JButton ("PING");
		ping.setSize(70, 30);
		ping.setLocation(435, 60);
		ping.addActionListener(new ping());
		output = new JTextPane ();
		output.setBorder(new TitledBorder("Вывод информации"));
		output.setEditable(false);
		JScrollPane jsp = new JScrollPane (output);
		jsp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setPreferredSize(new Dimension (200,200));
		JMenuBar menu = new JMenuBar ();
		JMenu file = new JMenu ("Файл");
		option = new JMenuItem("Настройки");
		option.addActionListener (new Click_opt());
		file.addSeparator();
		JMenuItem exit = new JMenuItem ("Выйти");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		JMenu help = new JMenu ("Справка");
		final JMenuItem about = new JMenuItem ("О программе");
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JOptionPane.showMessageDialog(Main.myWindow, "Seeker v1.2.3\nИщущий да найдет...\n(c) Copyright lotrik 2015. All rights reserved.", "О программе Seeker", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menu.add(file);
		menu.add(help);
		help.add(about);
		file.add(option);
		file.add(exit);
		setJMenuBar(menu);
		mainbox.add(box1);
		mainbox.add(box2);
		box1.add(panel);
		panel.add(label);
		panel.add(label2);
		panel.add(comp);
		panel.add(ip);
		panel.add(exec);
		panel.add(vnc);
		panel.add(ping);
		box2.add(jsp);
		setContentPane(mainbox);
	}

}