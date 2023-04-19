package blockchainprojectpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BlockchainFrame extends JFrame{
	private JTextField voteInformation;
	private JButton firstOption;
	private JButton secondOption;
	private JButton adminButton;
	
	
	public BlockchainFrame() {
		super("CBlock"); //Sets title of frame to 'CBlock'
		setLayout(null); //Sets the layout of the frame to null so that buttons can be put in custom spots with setBounds() function.
		
		getContentPane().setBackground(Color.DARK_GRAY); //Changes background color of pane to grey.
		Font font = new Font("Verdana", Font.BOLD, 14); //Font for the top line of text.
		
		//----------------------Text Field-------------------------------------------
		voteInformation = new JTextField();
		voteInformation.setText("A Secure Blockchain Based Voting System");
		voteInformation.setBackground(Color.DARK_GRAY); //Changes background of text field to dark grey.
		voteInformation.setForeground(Color.WHITE); //Changes the text color to white.
		voteInformation.setFont(font); // Changes text font to font made at beginning of constructor.
		voteInformation.setBounds(45, 20, 340, 42);
		voteInformation.setEditable(false); // Makes text uneditable (people cannot change what the text says)
		
		add(voteInformation);
		
		//---------------------Buttons----------------------------------
		firstOption = new JButton("Option 1"); //Makes button with text that says "Button 1" and changes the background to blue and text to white.
		firstOption.setBackground(Color.BLUE);
		firstOption.setForeground(Color.WHITE);
		firstOption.setBounds(40, 180, 150, 85);// Moves buttons to desired locations.
		secondOption = new JButton("Option 2"); //Makes button with text that says "Button 2" and changes the background to red and text to white.
		secondOption.setBackground(Color.RED);
		secondOption.setForeground(Color.WHITE);
		secondOption.setBounds(250, 180, 150, 85 ); // Moves buttons to desired locations.

		add(firstOption);
		add(secondOption);
		
		//-----------------------Admin Button--------------------------------
		adminButton = new JButton("Login as Administrator");
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
		
		
	}
}
