import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start {
	private JFrame frmStart = new JFrame("Automatic Timetable Generator");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JLabel backImage = new JLabel(new ImageIcon("imgs\\12.jpg"));
	private JLabel title = new JLabel("VIT Academics Timetable");
	private JLabel adminLabel = new JLabel("ADMIN");
	//private JLabel studLabel = new JLabel("STUDENT");
	//private JLabel profLabel = new JLabel("PROFESSOR");
	private JButton admin = new JButton("Admin", new ImageIcon("imgs\\admin2.jpg"));
	private JButton stud = new JButton("Student", new ImageIcon("imgs\\stud123.jpg"));
	private JButton prof = new JButton("Professor", new ImageIcon("imgs\\prof123.jpg"));
	private JButton exit = new JButton("EXIT", new ImageIcon("imgs\\exit.jpg"));

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		}

		//new Start();
		//new adminInput();
		new databaseInput();
		//new timetableSelector(null);
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch(Exception e) {
		}
		//new printSchedule(null,"Room","303");
	}

	public Start() {
		//start frame
		frmStart.setJMenuBar(menuBar);
		frmStart.add(backImage);
		frmStart.setResizable(false);
		frmStart.setBounds(50, 50, 1100, 700);
		frmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStart.setLocationRelativeTo(null);

		menuBar.add(mnFile);
		//menu of start frame
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mntmAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new About();
			}
		});
		mnFile.add(mntmAboutUs);
		

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(event.getSource());
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		//start frame
		backImage.setLayout(null);
		title.setBounds(0, 50, 1100, 90);
		title.setFont(new Font("Chiller", Font.BOLD, 45));
		title.setForeground(Color.white);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		backImage.add(title);
		
		//button admin
		admin.setBounds(130, 200, 120, 120);
		admin.setToolTipText("ADMIN");
		admin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		adminLabel.setBounds(20, 200, 200, 150);
		adminLabel.setFont(new Font("Arial", Font.BOLD, 20));
		adminLabel.setForeground(Color.white);
		admin.setContentAreaFilled(false);
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.dispose();
				new Login();
			}
		});
		backImage.add(admin);
		//backImage.add(adminLabel);
		//button student
		stud.setBounds(130, 330, 120, 120);
		stud.setToolTipText("STUDENT");
		stud.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stud.setContentAreaFilled(false);
		stud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.dispose();
				new Login();
			}
		});
		backImage.add(stud);
		
		//button prof
		prof.setBounds(130, 460, 120, 120);
		prof.setToolTipText("PROFESSOR");
		prof.setCursor(new Cursor(Cursor.HAND_CURSOR));
		prof.setContentAreaFilled(false);
		prof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.dispose();
				new Login();
			}
		});
		backImage.add(prof);
		//button admin
		exit.setBounds(800, 480, 120, 100);
		exit.setToolTipText("EXIT");
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setContentAreaFilled(false);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		backImage.add(exit);
		
		frmStart.setVisible(true);
	}
}
