import java.awt.event.*;
import java.io.IOException;


public class ping implements ActionListener{
	public void actionPerformed(ActionEvent event)
	{
		if (Click.os.contains("windows")){
			try {
				if (Click.ping.equals("0"))
				{
					Runtime.getRuntime().exec("cmd /c start cmd.exe /c ping " + window.ip.getText().toString() + " -t");
				} else
				{
					Runtime.getRuntime().exec("cmd /c start cmd.exe /c ping " + window.ip.getText().toString() + " -n " + Click.ping);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				if (Click.ping.equals("0"))
				{
					Runtime.getRuntime().exec("xterm -e ping " + window.ip.getText().toString());
				} else
				{
					Runtime.getRuntime().exec("xterm -e ping " + window.ip.getText().toString() + " -c " + Click.ping);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		window.comp.requestFocus();
		window.comp.selectAll();
	}

}
