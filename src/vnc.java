import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class vnc implements ActionListener {

	public void actionPerformed(ActionEvent event){
		if (Click.os.contains("windows")){
			try {
				Runtime.getRuntime().exec("vncviewer.exe" + " " + window.ip.getText().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String ssvnc = "/bin/bash ssvnc Vnc://" + window.ip.getText().toString() + ":0";
			try {
				Runtime.getRuntime().exec(ssvnc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		window.comp.requestFocus();
		window.comp.selectAll();
	}

}
