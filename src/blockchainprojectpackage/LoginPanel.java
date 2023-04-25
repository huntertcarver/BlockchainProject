package blockchainprojectpackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class LoginPanel extends JFrame implements ActionListener {
	//public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JLabel label = new JLabel("test");
	public JLabel passLabel = new JLabel("Password");
	public JTextField passField = new JTextField(20);
	public JButton loginButton = new JButton("Login");
	//private JComboBox candidateComboBox;
	private JButton infoButton = new JButton("Enter Candidate Info");
	private JButton resultsButton = new JButton("View Results");
	
	
	LoginPanel()
	{
		//candidateComboBox = new JComboBox(numOfCandidates);
		//candidateComboBox.setVisible(Boolean.FALSE);
		infoButton.setVisible(Boolean.FALSE);
		resultsButton.setVisible(Boolean.FALSE);
		
		//SETTING BOUNDS FOR ALL THE BUTTONS IN THE FRAME.
		//candidateComboBox.setBounds(80, 90, 60, 30);
		passField.setBounds(100, 20, 180, 30);
		loginButton.setBounds(290, 20, 80, 30);
		passLabel.setBounds(35, 18, 60, 30);
		infoButton.setBounds(20, 280, 150, 40);
		//infoButton.setBounds(160, 90, 180, 30);
		resultsButton.setBounds(210, 280, 150, 40);
		panel.setBounds(0, 0, 400, 400);
		
		//ADDING ELEMENTS TO THE PANEL AND SETTING THE DEFAULT PROTOCOL OF THE FRAME.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		panel.setLayout(null);
		panel.add(passLabel);
		panel.add(passField);
		panel.add(loginButton);
		//panel.add(candidateComboBox);
		panel.add(infoButton);
		panel.add(resultsButton);
		setVisible(true);
		add(panel);
		
		//--------------------loginButton EVENT HANDLING----------------------------------
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String password = passField.getText();			
				
				if(password.equals("admin"))
				{
					//Create a combobox and add it to frame (max number of six candidates)
					//candidateComboBox.setVisible(Boolean.TRUE);
					infoButton.setVisible(Boolean.TRUE);
					resultsButton.setVisible(Boolean.TRUE);
				}
			}
		});	
		
		//Add a second action listener for the enter key.
		KeyStroke enterButton = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		passField.getInputMap().put(enterButton, "ENTER"); 
		passField.getActionMap().put("ENTER", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String password = passField.getText();	
				if(password.equals("admin"))
				{
					//candidateComboBox.setVisible(Boolean.TRUE);
					infoButton.setVisible(Boolean.TRUE);
					resultsButton.setVisible(Boolean.TRUE);
				}
			}
		});
	
		//---------------------infoButton EVENT HANDLING-------------------------
		infoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				//Opens panel to enter info for the number of candidates entered in the comboBox.
				//figure out how to check for the value inside of the comboBox and then setVisible that many textFields in the new frame 
				//make new frame tomorrow and just have 6 possible candidates and however many displayed based on the comboBox answer.
				if (e.getSource() == infoButton) {
					CandidateInfoPanel adminInfoPanel = new CandidateInfoPanel();
				}
			}
		});
		
		//---------------------resultsButton EVENT HANDLING----------------------
		resultsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.out.print("test"); //PLACEHOLDER
				//Add event handling so that when the button gets pressed it opens the frame that Christian was working on.
			}
		});
	}
}