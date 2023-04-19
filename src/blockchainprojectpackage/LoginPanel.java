package blockchainprojectpackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JFrame implements ActionListener {
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JLabel label = new JLabel("test");
	public JLabel passLabel = new JLabel("Password");
	public JTextField passField = new JTextField(20);
	public JButton loginButton = new JButton("Login");
	
	
	LoginPanel()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(new FlowLayout());
		
		panel.add(passLabel);
		panel.add(passField);
		panel.add(loginButton);
		
		
		frame.setVisible(true);
		frame.add(panel);
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String password = passField.getText();			
				
				if(password.equals("admin"))
				{
					passLabel.setText("Success");
					// adminPanel
				}
			}
		});	
	}
	
	

}