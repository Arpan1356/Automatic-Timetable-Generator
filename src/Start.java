import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start {
	private JFrame frmStart = new JFrame("Automatic Timetable Generator");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JLabel backImage = new JLabel(new ImageIcon("imgs\\1.jpg"));
	private JLabel title = new JLabel("VIT Academics Timetable");
	private JButton admin = new JButton("Admin", new ImageIcon("imgs\\licon.png"));
	private JButton stud = new JButton("Student", new ImageIcon("imgs\\stud.png"));
	private JButton prof = new JButton("Professor", new ImageIcon("imgs\\prof.png"));
	private JButton exit = new JButton("EXIT", new ImageIcon("imgs\\exit.png"));

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		}

		new Start();
		//new databaseInput();
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
		admin.setBounds(100, 300, 200, 50);
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.dispose();
				new Login();
			}
		});
		//admin.setBorder(BorderFactory.createEmptyBorder());
		//admin.setContentAreaFilled(false);
		backImage.add(admin);
		//button student
		stud.setBounds(100, 360, 200, 50);
		stud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.dispose();
				new Login();
			}
		});
		backImage.add(stud);
		//button prof
		prof.setBounds(100, 420, 200, 50);
		prof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStart.dispose();
				new Login();
			}
		});
		backImage.add(prof);
		//button admin
		exit.setBounds(100, 480, 200, 50);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		backImage.add(exit);
		
		frmStart.setVisible(true);
	}
}
