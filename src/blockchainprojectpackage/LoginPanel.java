package blockchainprojectpackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class LoginPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JLabel label = new JLabel("test");
	public JLabel passLabel = new JLabel("Password");
	public JTextField passField = new JTextField(20);
	public JButton loginButton = new JButton("Login");
	private JButton resultsButton = new JButton("View Results");
	private JButton candidateButton = new JButton("Enter Candidate Info");
	
	
	LoginPanel(Blockchain mainChain, BlockchainFrame mainFrame)
	{
		resultsButton.setVisible(Boolean.FALSE);
		candidateButton.setVisible(Boolean.FALSE);
		
		//SETTING BOUNDS FOR ALL THE BUTTONS IN THE FRAME.
		passField.setBounds(100, 20, 180, 30);
		loginButton.setBounds(290, 20, 80, 30);
		passLabel.setBounds(35, 18, 60, 30);
		resultsButton.setBounds(20, 80, 150, 40);
		candidateButton.setBounds(190, 80, 180, 40);
		panel.setBounds(0, 0, 400, 200);
		
		//ADDING ELEMENTS TO THE PANEL AND SETTING THE DEFAULT PROTOCOL OF THE FRAME.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		panel.setLayout(null);
		panel.add(passLabel);
		panel.add(passField);
		panel.add(loginButton);
		panel.add(resultsButton);
		panel.add(candidateButton);
		setVisible(true);
		add(panel);
		
		//Changing the color of the elements in the frame.
		panel.setBackground(Color.DARK_GRAY);
		loginButton.setBackground(Color.LIGHT_GRAY);
		candidateButton.setBackground(Color.LIGHT_GRAY);
		resultsButton.setBackground(Color.LIGHT_GRAY);
		passLabel.setForeground(Color.WHITE);
		
		//--------------------loginButton EVENT HANDLING----------------------------------
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String password = passField.getText();			
				
				if(password.equals("admin"))
				{
					resultsButton.setVisible(Boolean.TRUE);
					candidateButton.setVisible(Boolean.TRUE);
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
					resultsButton.setVisible(Boolean.TRUE);
					candidateButton.setVisible(Boolean.TRUE);
				}
			}
		});
	
		//---------------------resultsButton EVENT HANDLING----------------------
		resultsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				dispose();
				ResultsPanel finalPanel = new ResultsPanel(mainChain);
				//Add event handling so that when the button gets pressed it opens the frame that Christian was working on.
			}
		});
		
		//----------------------candidateButton EVENT HANDLING-----------------------------
		candidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == candidateButton) {
					dispose();
					CandidateInfoPanel adminInfoPanel = new CandidateInfoPanel(mainFrame, mainChain);
					adminInfoPanel.setVisible(true);
					adminInfoPanel.setSize(380, 320);
				}
			}
		});
	}
}