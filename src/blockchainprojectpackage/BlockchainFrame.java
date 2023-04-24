package blockchainprojectpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BlockchainFrame extends JFrame{
	private JTextField voteInformation;
	private JTextField partyTitle1;
	private JTextField partyTitle2;
	private JButton adminButton;
	private JButton voteButton;
	
	//Stuff to be added that we talked about during meeting 4/19
	//making first group for main panel of each party.
	private JPanel partyPanel1 = new JPanel();
	private JRadioButton firstPartyButton1;
	private JRadioButton firstPartyButton2;
	private JRadioButton firstPartyButton3;
	private ButtonGroup firstParty = new ButtonGroup();
	
	//firstParty.add(firstPartyButton1 = new JRadioButton);
	//Figure out how to instantiate and add each radio button to the button group.
	
	private JPanel partyPanel2 = new JPanel();
	private JRadioButton secondPartyButton1;
	private JRadioButton secondPartyButton2;
	private JRadioButton secondPartyButton3;
	private ButtonGroup secondParty = new ButtonGroup();
	
	
	
	
	
	public BlockchainFrame(Blockchain voteBlock) {
		super("CBlock"); //Sets title of frame to 'CBlock'
		setLayout(null); //Sets the layout of the frame to null so that buttons can be put in custom spots with setBounds() function.
		
		getContentPane().setBackground(Color.DARK_GRAY); //Changes background color of pane to grey.
		Font font = new Font("Verdana", Font.BOLD, 14); //Font for the top line of text.
		Font font2 = new Font("Verdana", Font.BOLD, 12);
		
		//----------------------Text Field-------------------------------------------
		voteInformation = new JTextField();
		voteInformation.setText("A Secure Blockchain Based Voting System");
		voteInformation.setBackground(Color.DARK_GRAY); //Changes background of text field to dark grey.
		voteInformation.setForeground(Color.WHITE); //Changes the text color to white.
		voteInformation.setFont(font); // Changes text font to font made at beginning of constructor.
		voteInformation.setBounds(45, 20, 345, 42);
		voteInformation.setEditable(false); // Makes text uneditable (people cannot change what the text says)
		
		add(voteInformation);

		//-----------------------Admin Button--------------------------------
		adminButton = new JButton("Login as Administrator");
		adminButton.setBounds(255, 365, 165, 35);
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
		
		//--------------Radio Button Groups-------------------------------------
		firstParty.add(firstPartyButton1 = new JRadioButton("Candidate 1")); //Initialize and set the name of each radio button.
		firstParty.add(firstPartyButton2 = new JRadioButton("Candidate 2"));
		firstParty.add(firstPartyButton3 = new JRadioButton("Candidate 3"));
		partyPanel1.add(firstPartyButton1); //add the radio buttons to the panel firstPartyPanel1.
		partyPanel1.add(firstPartyButton2);
		partyPanel1.add(firstPartyButton3);
		add(partyPanel1); //Add the party panel to the frame.
		partyPanel1.setBounds(40, 180, 150, 85); //change the bounds of the panel to set where the button group is on the frame.
		
		secondParty.add(secondPartyButton1 = new JRadioButton("Candidate 1")); //Initialize and set the name of each radio button.
		secondParty.add(secondPartyButton2 = new JRadioButton("Candidate 2"));
		secondParty.add(secondPartyButton3 = new JRadioButton("Candidate 3"));
		partyPanel2.add(secondPartyButton1); //add the radio buttons to the panel firstPartyPanel2.
		partyPanel2.add(secondPartyButton2);
		partyPanel2.add(secondPartyButton3);
		add(partyPanel2); //Add the party panel to the frame.
		partyPanel2.setBounds(250, 180, 150, 85 ); //change the bounds of the panel to set where the button group is on the frame.
		
		partyPanel1.setBackground(Color.DARK_GRAY); //Change the background color of each panel to dark gray.
		partyPanel2.setBackground(Color.DARK_GRAY);
		
		JRadioButton buttonArray[] = new JRadioButton[] {firstPartyButton1, firstPartyButton2, firstPartyButton3, secondPartyButton1, secondPartyButton2, secondPartyButton3}; 
		// Line above gives every radio button for the candidates to an array so it can be run through a for loop to change the color.
		for (int i = 0; i < buttonArray.length; i++) {
			buttonArray[i].setBackground(Color.DARK_GRAY);
			buttonArray[i].setForeground(Color.WHITE);
		}
		
		
		//-------------------------Party Title-------------------------------------
		partyTitle1 = new JTextField("Democratic Candidates");
		partyTitle2 = new JTextField("Republican Candidates");
		
		add(partyTitle1);
		add(partyTitle2);
		partyTitle1.setBackground(Color.DARK_GRAY);
		partyTitle2.setBackground(Color.DARK_GRAY);
		partyTitle1.setForeground(Color.RED);
		partyTitle2.setForeground(Color.BLUE);
		partyTitle1.setFont(font2);
		partyTitle2.setFont(font2);
		partyTitle1.setBounds(35, 140, 155, 25);
		partyTitle2.setBounds(250, 140, 153, 25);
		
		//---------------------vote Button---------------------------------------------
		voteButton = new JButton("Vote");
		voteButton.setBounds(172, 290, 95, 40);
		voteButton.setBackground(Color.LIGHT_GRAY);
		
		add(voteButton);
		
	}
}
