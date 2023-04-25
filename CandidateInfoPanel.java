package blockchainprojectpackage;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class CandidateInfoPanel extends JFrame{
	
	//need 6 text field because that is the max number of candidates 
	private JButton submitButton = new JButton("Submit Candidates");
	private JTextField firstCandidate = new JTextField(30);
	private JTextField secondCandidate = new JTextField(30);
	private JTextField thirdCandidate = new JTextField(30);
	private JTextField fourthCandidate = new JTextField(30);
	private JTextField fifthCandidate = new JTextField(30);
	private JTextField sixthCandidate = new JTextField(30);
	
	//Two JLabels for each class.
	private JLabel repParty = new JLabel("Election Candidates");
	
	CandidateInfoPanel(BlockchainFrame mainFrame, Blockchain mainChain){
		//Set the layout to null and change the setBounds of each element.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		Font font = new Font("Verdana", Font.BOLD, 14);
		repParty.setFont(font);
		setSize(400,290);
		//bounds for each element.
		submitButton.setBounds(100, 200, 160, 40);
		repParty.setBounds(110, 20, 180, 20);
		firstCandidate.setBounds(30, 60, 140, 25);
		secondCandidate.setBounds(30, 100, 140, 25);
		thirdCandidate.setBounds(30, 140, 140, 25);
		fourthCandidate.setBounds(190, 60, 140, 25);
		fifthCandidate.setBounds(190, 100, 140, 25);
		sixthCandidate.setBounds(190, 140, 140, 25);
		
		//Make an array of JTextFields to hold each value of the text fields admins can enter in.
		JTextField textArray[] = new JTextField[] {firstCandidate, secondCandidate, thirdCandidate, fourthCandidate, fifthCandidate, sixthCandidate};
		
		//add each to the frame.
		add(submitButton);
		add(repParty);
		add(firstCandidate);
		add(secondCandidate);
		add(thirdCandidate);
		add(fourthCandidate);
		add(fifthCandidate);
		add(sixthCandidate);
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < textArray.length; i++) {
					if (!textArray[i].getText().equals("")) {
						mainFrame.buttonArray[i].setText(textArray[i].getText());
						mainFrame.buttonArray[i].setVisible(true);
					}
				}
				mainFrame.setVisible(true);
				mainFrame.setSize(450, 400);
				//mainFrame.buttonArray[i].setText(textArray[i].getText());
			}
		});
		
	}
}
