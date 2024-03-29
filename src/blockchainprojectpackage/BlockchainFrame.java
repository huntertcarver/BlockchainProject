package blockchainprojectpackage;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;

public class BlockchainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField voteInformation;
	private JTextField electionTitle;
	private JButton adminButton;
	private JButton voteButton;
	
	//Stuff to be added that we talked about during meeting 4/19
	//making first group for main panel of each party.
	private JPanel partyPanel = new JPanel();
	private JRadioButton optionButton1 = new JRadioButton();
	private JRadioButton optionButton2 = new JRadioButton();
	private JRadioButton optionButton3 = new JRadioButton();
	private JRadioButton optionButton4 = new JRadioButton();
	private JRadioButton optionButton5 = new JRadioButton();
	private JRadioButton optionButton6 = new JRadioButton();
	public ButtonGroup partyGroup = new ButtonGroup();
	public JRadioButton buttonArray[] = new JRadioButton[6]; 
	
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
		
		//--------------Radio Button Groups-------------------------------------
		
		for(int i = 0; i < 6;i++) {
			buttonArray[i] = new JRadioButton("Candidate" + (i+1));
			partyGroup.add(buttonArray[i]);
			partyPanel.add(buttonArray[i]);
			buttonArray[i].setVisible(false);
		}		
		
		add(partyPanel); //Add the party panel to the frame.
		partyPanel.setBounds(45, 140, 150, 185 ); //change the bounds of the panel to set where the button group is on the frame.
		partyPanel.setLayout(new BoxLayout(partyPanel,BoxLayout.Y_AXIS));
		
		partyPanel.setBackground(Color.DARK_GRAY); //Change the background color of each panel to dark gray.
		
		
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
		voteButton.setBounds(245, 160, 130, 100);
		voteButton.setBackground(Color.LIGHT_GRAY);
		
		Timer timer = new Timer();
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
								Block voted = new Block(voteBlock.getLatestBlock().getIndex() + 1, buttonArray[i].getText(), voteBlock.getLatestBlock().getHash());
								voteBlock.addBlock(voted);
								System.out.println(voteBlock.getLatestBlock().getData());
							}
							//closes the frame after the user votes for their candidate.
							dispose();
						}
					}
					
				}
			}
		});
		add(voteButton);
		
	}
}

