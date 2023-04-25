package blockchainprojectpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BlockchainFrame extends JFrame{
	private JTextField voteInformation;
	private JTextField electionTitle;
	private JButton adminButton;
	private JButton voteButton;
	
	//Stuff to be added that we talked about during meeting 4/19
	//making first group for main panel of each party.
	private JPanel partyPanel = new JPanel();
	private JRadioButton optionButton1;
	private JRadioButton optionButton2;
	private JRadioButton optionButton3;

	
	//firstParty.add(firstPartyButton1 = new JRadioButton);
	//Figure out how to instantiate and add each radio button to the button group.
	private JRadioButton optionButton4;
	private JRadioButton optionButton5;
	private JRadioButton optionButton6;
	private ButtonGroup partyGroup = new ButtonGroup();
	
	
	
	
	
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
		voteInformation.setHorizontalAlignment(JTextField.CENTER);
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
		partyGroup.add(optionButton1 = new JRadioButton("Candidate 1")); //Initialize and set the name of each radio button.
		partyGroup.add(optionButton2 = new JRadioButton("Candidate 2"));
		partyGroup.add(optionButton3 = new JRadioButton("Candidate 3"));
		partyGroup.add(optionButton4 = new JRadioButton("Candidate 4"));
		partyGroup.add(optionButton5 = new JRadioButton("Candidate 5"));
		partyGroup.add(optionButton6 = new JRadioButton("Candidate 6"));
		partyPanel.add(optionButton1);
		partyPanel.add(optionButton2);
		partyPanel.add(optionButton3);
		partyPanel.add(optionButton4);
		partyPanel.add(optionButton5);
		partyPanel.add(optionButton6);
		optionButton1.setVisible(false);
		optionButton2.setVisible(false);
		optionButton3.setVisible(false);
		optionButton4.setVisible(false);
		optionButton5.setVisible(false);
		optionButton6.setVisible(false);
		
		
		add(partyPanel); //Add the party panel to the frame.
		partyPanel.setBounds(45, 140, 150, 185 ); //change the bounds of the panel to set where the button group is on the frame.
		
		partyPanel.setBackground(Color.DARK_GRAY); //Change the background color of each panel to dark gray.
		
		JRadioButton buttonArray[] = new JRadioButton[] {optionButton1, optionButton2, optionButton3, optionButton4, optionButton5, optionButton6}; 
		// Line above gives every radio button for the candidates to an array so it can be run through a for loop to change the color.
		for (int i = 0; i < buttonArray.length; i++) {
			buttonArray[i].setBackground(Color.DARK_GRAY);
			buttonArray[i].setForeground(Color.WHITE);
		}
		
		
		//-------------------------Party Title-------------------------------------
		electionTitle = new JTextField("Election Candidates");
		
		add(electionTitle);
		electionTitle.setBackground(Color.DARK_GRAY);
		electionTitle.setForeground(Color.WHITE);
		electionTitle.setFont(font2);
		electionTitle.setBounds(45, 100, 155, 25);
		electionTitle.setHorizontalAlignment(JTextField.CENTER);
		
		//---------------------vote Button---------------------------------------------
		voteButton = new JButton("Vote");
		voteButton.setBounds(255, 200, 95, 40);
		voteButton.setBackground(Color.LIGHT_GRAY);
		voteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == voteButton)
				{
					
					int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to vote for this candidate?");
					
					if(confirmation == 0) // showConfirmDialog returns Yes as 0, No as 1, and Cancel as 2
					{
						for(int i = 0; i < buttonArray.length; i++)
						{
							if(buttonArray[i].isSelected())
							{
								Block voted = new Block(voteBlock.getLatestBlock().getIndex() + 1, Integer.toString(i+1), voteBlock.getLatestBlock().getHash());
								voteBlock.addBlock(voted);
								System.out.println(voteBlock.getLatestBlock().getData());
							}
						}
					}
					
				}
			}
		});
		add(voteButton);
		
	}
}
