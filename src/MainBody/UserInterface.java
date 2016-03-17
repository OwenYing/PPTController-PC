package MainBody;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserInterface {

	private Frame frameConnectHotspot = new Frame("Welcome to PPT Controller");
	private Frame frameUsing = new Frame("PPT Controller");
	private Button buttonDoneConnection = new Button("Connected");
	private Button buttonExitApp = new Button("Exit");
	private Label labelConnectHotspot = new Label("Connect Your PC to Your Phones'Hotspot");
	private Label labelUsing = new Label("Use It Freely!");
	
	
	public void ui()
	{
		frameConnectHotspot.add(labelConnectHotspot);
		frameConnectHotspot.add(buttonDoneConnection);
		frameConnectHotspot.setVisible(true);
		frameConnectHotspot.setBounds(500, 330, 350, 100);
		frameConnectHotspot.setLayout(new FlowLayout());

		
		frameUsing.add(labelUsing);
		frameUsing.add(buttonExitApp);
		frameUsing.setVisible(false);
		frameUsing.setBounds(500, 330, 350, 100);
		frameUsing.setLayout(new FlowLayout());
		
		
		
		frameConnectHotspot.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		buttonDoneConnection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frameConnectHotspot.setVisible(false);
				frameUsing.setVisible(true);
			}
		});
		
		frameUsing.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		buttonExitApp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	
	
	
}
