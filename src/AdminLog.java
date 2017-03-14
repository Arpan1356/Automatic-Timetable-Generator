import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminLog{
	private JFrame mainFrame;
	private JButton newData,oldData;
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
		
		newData.setBounds(50, 250, 100, 30);
		oldData.setBounds(50, 300, 100, 30);
		
		newData.addActionListener(new buttonListener());
		oldData.addActionListener(new buttonListener());
		
		mainFrame.add(newData);
		mainFrame.add(oldData);
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
				
		}
	}
}