import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminLog{
	private JFrame mainFrame;
	private JButton newData,oldData,logout;
	private JLabel label;
	
	public AdminLog(){
		mainFrame = new JFrame("ADMIN");
		mainFrame.setResizable(true);
		mainFrame.setBounds(100, 100, 820, 520);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(null);
		
		
		label = new JLabel("Please choose one of the following option");
		label.setBounds(50, 100, 1000, 30);
		label.setFont(new Font("Courier New", Font.BOLD, 24));
		newData = new JButton("New Data");
		oldData = new JButton("Existing Data");
		logout = new JButton(new ImageIcon("imgs\\exit.jpg"));
		logout.setToolTipText("LOG OUT");
		logout.setContentAreaFilled(false);
		
		newData.setBounds(100, 250, 150, 30);
		oldData.setBounds(100, 300, 150, 30);
		logout.setBounds(600, 300, 200, 200);
		
		newData.addActionListener(new buttonListener());
		oldData.addActionListener(new buttonListener());
		logout.addActionListener(new buttonListener());
		
		mainFrame.add(newData);
		mainFrame.add(oldData);
		mainFrame.add(logout);
		mainFrame.add(label);
		
		
		mainFrame.setVisible(true);
	}
	
	public class buttonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			mainFrame.dispose();
			if(e.getSource() == newData){
				//System.out.println("Call the new data frame");
				new adminInput();
			}
			else if(e.getSource()== oldData){
				new databaseInput();
				//System.out.println("Call the old data frame");
			}
			else if(e.getSource() == logout){
				mainFrame.dispose();
				new Start();
			}
				
		}
	}
}