import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Click_opt extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = -7219531196212947276L;
	
	static JFrame opt;
	public void actionPerformed (ActionEvent event) {
		opt = new JFrame("Настройки");
		opt.setVisible(true);	
		opt.setSize(480, 250);
		opt.setResizable(false);
		opt.setLocationRelativeTo(Main.myWindow);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(500,200);
		final JCheckBox chckip = new JCheckBox ("IP");
		chckip.setSize(40,20);
		chckip.setLocation(10,25);
		if (Click.chckip.equals("1")) {
			chckip.setSelected (true);
		} else {
			chckip.setSelected (false);
		}
		chckip.addItemListener(new ItemListener(){
		      public void itemStateChanged(ItemEvent e){
		        if(chckip.isSelected())
		        {
		          Click.chckip = "1";
		        }
		        else
		        {
		        	Click.chckip = "0";
		        }
		      }
		    });
		panel.add(chckip);
		final JCheckBox chckuser = new JCheckBox ("Username");
		chckuser.setSize(105,20);
		chckuser.setLocation(60,25);
		if (Click.chckuser.equals("1")) {
			chckuser.setSelected (true);
		} else {
			chckuser.setSelected (false);
		}
		chckuser.addItemListener(new ItemListener(){
		      public void itemStateChanged(ItemEvent e){
		        if(chckuser.isSelected())
		        {
		        	Click.chckuser = "1";
		        }
		        else
		        {
		        	Click.chckuser = "0";
		        }
		      }
		    });
		panel.add(chckuser);
		final JCheckBox chckcpu = new JCheckBox ("CPU");
		chckcpu.setSize(60,20);
		chckcpu.setLocation(165,25);
		if (Click.chckcpu.equals("1")) {
			chckcpu.setSelected (true);
		} else {
			chckcpu.setSelected (false);
		}
		chckcpu.addItemListener(new ItemListener(){
		      public void itemStateChanged(ItemEvent e){
		        if(chckcpu.isSelected())
		        {
		        	Click.chckcpu = "1";
		        }
		        else
		        {
		        	Click.chckcpu = "0";
		        }
		      }
		    });
		panel.add(chckcpu);
		final JCheckBox chckmem = new JCheckBox ("Memory");
		chckmem.setSize(85,20);
		chckmem.setLocation(225,25);
		if (Click.chckmem.equals("1")) {
			chckmem.setSelected (true);
		} else {
			chckmem.setSelected (false);
		}
		chckmem.addItemListener(new ItemListener(){
		      public void itemStateChanged(ItemEvent e){
		        if(chckmem.isSelected())
		        {
		        	Click.chckmem = "1";
		        }
		        else
		        {
		        	Click.chckmem = "0";
		        }
		      }
		    });
		panel.add(chckmem);
		final JCheckBox chcksys = new JCheckBox ("System");
		chcksys.setSize(80,20);
		chcksys.setLocation(310,25);
		if (Click.chcksys.equals("1")) {
			chcksys.setSelected (true);
		} else {
			chcksys.setSelected (false);
		}
		chcksys.addItemListener(new ItemListener(){
		      public void itemStateChanged(ItemEvent e){
		        if(chcksys.isSelected())
		        {
		        	Click.chcksys = "1";
		        }
		        else
		        {
		        	Click.chcksys = "0";
		        }
		      }
		    });
		panel.add(chcksys);
		final JCheckBox chckrec = new JCheckBox ("Record");
		chckrec.setSize(80,20);
		chckrec.setLocation(390,25);
		if (Click.chckrec.equals("1")) {
			chckrec.setSelected (true);
		} else {
			chckrec.setSelected (false);
		}
		chckrec.addItemListener(new ItemListener(){
		      public void itemStateChanged(ItemEvent e){
		        if(chckrec.isSelected())
		        {
		        	Click.chckrec = "1";
		        }
		        else
		        {
		        	Click.chckrec = "0";
		        }
		      }
		    });
		panel.add(chckrec);
		JLabel label = new JLabel ("Введите путь к файлам:");
		label.setSize(200, 25);
		label.setLocation(10, 70);
		panel.add(label);
		final JTextField input = new JTextField();
		input.setSize(180, 25);
		input.setLocation(185, 70);
		input.setText(Click.path);
		panel.add(input);
		final JButton view = new JButton("Обзор");
		view.setSize(80,25);
		view.setLocation(380,70);
		view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JFileChooser fc = new JFileChooser ();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setAcceptAllFileFilterUsed(false);
				fc.setCurrentDirectory(new java.io.File("."));
				fc.showOpenDialog(view);
				input.setText(fc.getSelectedFile().toString());
			}
		});
		JLabel pings = new JLabel ("Кол-во ping:");
		pings.setSize(90,25);
		pings.setLocation(10,115);
		panel.add(pings);
		JLabel pings2 = new JLabel ("(0 - unlimited)");
		pings2.setSize(100,25);
		pings2.setLocation(10,135);
		panel.add(pings2);
		final JTextField pingin = new JTextField();
		pingin.setSize(40,25);
		pingin.setLocation(110, 115);
		pingin.setText(Click.ping);
		panel.add(pingin);
		panel.add(view);
		JButton bok = new JButton("Сохранить");
		bok.setSize(110,30);
		bok.setLocation(200,175);
		bok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try {
				FileWriter fw = new FileWriter (Click.pathconf);
				BufferedWriter br = new BufferedWriter (fw);
				br.write("show_ip=" + Click.chckip + "\n" + "show_user=" + Click.chckuser + "\n" + "show_cpu=" + Click.chckcpu + "\n"
						+ "show_mem=" + Click.chckmem + "\n" + "show_sys=" + Click.chcksys + "\n" + "show_rec=" + Click.chckrec + "\n"
						+ "path=" + input.getText() + "\n" + "ping=" + pingin.getText());
				br.close();
				opt.setVisible(false);
				} catch(IOException e){
		    		//e.printStackTrace();
		    	}
				Click.path = input.getText();
				Click.ping = pingin.getText();
			}
		});
		panel.add(bok);
		JButton bcancel = new JButton("Отменить");
		bcancel.setSize(110,30);
		bcancel.setLocation(350,175);
		bcancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				opt.setVisible(false);
			}
		});
		panel.add(bcancel);
		
		opt.add(panel);
	}
	
}
