package blockchainprojectpackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel mainPanel = new JPanel();
	public JLabel mainLabel = new JLabel("Menu");
	public JButton loginButton = new JButton("Start Voting");
	public JButton adminButton = new JButton("Admin Login");
	public JTextField passField = new JTextField(20);
	
	
	//CHANGE SET BOUNDS OF EACH BUTTON AND MENU JLABEL SO START FRAME LOOKS NICE.
	StartFrame(BlockchainFrame mainFrame, Blockchain mainChain){
		super("CBlock");
		setSize(365, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//Changing the color of the frame.
		mainLabel.setForeground(Color.WHITE);
		getContentPane().setBackground(Color.DARK_GRAY);
		loginButton.setBackground(Color.LIGHT_GRAY);
		adminButton.setBackground(Color.LIGHT_GRAY);
		
		//setting the bounds of the frame.
		mainLabel.setBounds(160, 10, 40, 20);
		loginButton.setBounds(10, 40, 160, 30);
		adminButton.setBounds(180, 40, 160, 30);
		
		//add the elements to the frame.
		add(mainLabel);
		add(loginButton);
		
		//-----------------------ADMIN BUTTON--------------------------------------
		//adds and sets the listener for the admin button to go to the login panel
		adminButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == adminButton)
				{
					
					LoginPanel newAdmin = new LoginPanel(mainChain, mainFrame);
				}
			}
		});
		
		//---------------------------------VOTE BUTTON-----------------------------
		add(adminButton);
		//loginButton.setBounds(200,200,180,85);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == loginButton) {
					//BlockchainFrame updatedFrame = new BlockchainFrame(mainChain);
					mainFrame.partyGroup.clearSelection();
					mainFrame.setVisible(true);
					mainFrame.setSize(450, 400);
					//System.out.println("dog");
				}
			}
		});
		
		
		
		
	}
}
