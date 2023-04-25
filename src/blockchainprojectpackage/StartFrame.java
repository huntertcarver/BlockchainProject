package blockchainprojectpackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartFrame extends JFrame {
	public JPanel mainPanel = new JPanel();
	public JLabel mainLabel = new JLabel("test");
	public JButton loginButton = new JButton("Start Voting");
	public JButton adminButton = new JButton("Admin Login");
	
	StartFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add(mainLabel);
		add(loginButton);
		
		
		//adds and sets the listener for the admin button to go to the login panel
		adminButton.setBounds(240, 360, 180, 40);
		adminButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == adminButton)
				{
					
					LoginPanel newAdmin = new LoginPanel();
				}
			}
		});
		
		add(adminButton);
		loginButton.setBounds(200,200,180,85);
	}
}
