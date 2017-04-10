import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.Arrays;

public class Login {
	public static Scheduler sessionSolution;
	public static int timetableMade = 0;
	private JFrame frmLogin = new JFrame("LOGIN");
	private JTextField textField;
	private JPasswordField passwordField;
	private String dialogMessage, dialogs;
	private JProgressBar progressBar;

	public Login() {
		//frame setting
		frmLogin.setResizable(false);
		frmLogin.setBackground(Color.WHITE);
		frmLogin.setBounds(0, 0, 330, 305);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLayout(new BorderLayout(0, 0));
		frmLogin.setLocationRelativeTo(null);
		
		//background
		JLabel backImage = new JLabel(new ImageIcon("imgs\\12.png"));
		frmLogin.add(backImage);
		backImage.setLayout(null);
		
		//frame content
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 135, 78, 14);
		backImage.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 172, 78, 14);
		backImage.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(98, 134, 206, 20);
		backImage.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(98, 171, 206, 20);
		backImage.add(passwordField);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginname;
				char[] loginpass;
				loginname = textField.getText();
				loginpass = passwordField.getPassword();
				dialogMessage = "Welcome - " + loginname.toUpperCase();
				if( (loginname.equals("admin") && Arrays.equals("admin".toCharArray(), loginpass)) ) {
					new Thread(new PBar(loginname)).start();
				}
				else if(checkStudent(loginname)){
					new Thread(new PBar("student")).start();
				}
				else if(checkProfessor(loginname)){
					new Thread(new PBar("professor")).start();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invaild User Name and Password!" , "ERROR!!!", JOptionPane.INFORMATION_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}	
			}
		});
		btnNewButton.setBounds(50, 208, 89, 23);
		backImage.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setBounds(185, 208, 89, 23);
		backImage.add(btnNewButton_1);

		progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(10, 242, 294, 14);
		backImage.add(progressBar);
		
		frmLogin.setVisible(true);
	}
	
	public boolean checkStudent(String s){ // username is batch name  password is id
		if(sessionSolution!= null)
		for(int i=0; i<sessionSolution.inputData.sgD.size();++i){
			if(sessionSolution.inputData.sgD.get(i).id.equals(s) && sessionSolution.inputData.sgD.get(i).name.equals(new String(passwordField.getPassword()))){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkProfessor(String s){ // username is professor name and password is id
		if(sessionSolution!= null)
		for(int i=0; i<sessionSolution.inputData.pD.size();++i){
			if(sessionSolution.inputData.pD.get(i).name.equals(s) && sessionSolution.inputData.pD.get(i).id== Integer.parseInt(new String(passwordField.getPassword()))){
				return true;
			}
		}
		return false;
	}

	class PBar implements Runnable {
		String name;
		public PBar(String s) {
			name = s;
		}

		public void run() {
			for (int i=0; i<=100; i++) { 
				progressBar.setValue(i);
				progressBar.repaint();
				try {
					Thread.sleep(5);
				}	 
				catch (Exception e) {
				}
			}
			
			JOptionPane.showMessageDialog(null, dialogMessage, dialogs, JOptionPane.INFORMATION_MESSAGE);
			frmLogin.dispose();
			
			if(name.equals("student")){
				try{
					System.out.println(passwordField.getPassword());
					String pass = new String(passwordField.getPassword());
					new Login();
					try {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					}
					catch(Exception e) {
					}
					new printSchedule(sessionSolution,"Student",pass);
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					catch(Exception e) {
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Not available. Contact ADMIN");
				}
				
			}
			else if(name.equals("professor")){
				
					if(sessionSolution != null){
					String tpass = new String(passwordField.getPassword());
					int pass = Integer.parseInt(tpass);
					new Login();
					try {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					}
					catch(Exception e) {
					}
					new printSchedule(sessionSolution,"Professor",pass);
					}
					else
						JOptionPane.showMessageDialog(null, "Not available. Contact ADMIN");
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					catch(Exception e) {
					}
			}
			else if(name.equals("admin"))
				new AdminLog();
		}
	}
}
