import java.awt.*;
import javax.swing.*;

public class About {
	private JFrame frmAboutUs = new JFrame("About Us");
	private JPanel panel = new JPanel();
	
	public About() {
		frmAboutUs.add(panel);
		frmAboutUs.setResizable(false);
		frmAboutUs.setBounds(100, 100, 650, 450);
		frmAboutUs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAboutUs.setLocationRelativeTo(null);
		
		panel.setBackground(Color.getHSBColor(340, (float) 0.013, (float) 0.91));
		panel.setLayout(null);

		JTextArea tf = new JTextArea("The automatic timetable generator take the input from the user, either manually or using a MySQL database. The user can give all the academics details of the institution such as professor, students, classrooms, and courses.");
		tf.setEditable(false);
		tf.setLineWrap(true);
		tf.setWrapStyleWord(true);
		tf.setBounds(20, 100, 560, 140);
		panel.add(tf);
		
		JLabel lblAboutUs = new JLabel("Automatic Timetable Generator");
		lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutUs.setFont(new Font("Chiller", Font.BOLD, 35));
		lblAboutUs.setBounds(10, 11, 560, 65);
		panel.add(lblAboutUs);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imgs\\vit.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-50, 280, 274, 123);
		panel.add(lblNewLabel);
		
		JLabel dev = new JLabel("Developers:");
		dev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dev.setBounds(200, 300, 274, 25);
		panel.add(dev);
		
		JLabel nish = new JLabel("NISHANT KAUSHIK - 14BCE0398");
		nish.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nish.setBounds(200, 325, 274, 25);
		panel.add(nish);

		JLabel prak = new JLabel("PRAKHAR YADAV - 14BCE0216");
		prak.setFont(new Font("Tahoma", Font.PLAIN, 10));
		prak.setBounds(200, 349, 274, 25);
		panel.add(prak);

		JLabel gaut = new JLabel("GAUTAM MITTAL - 14BCE0215");
		gaut.setFont(new Font("Tahoma", Font.PLAIN, 10));
		gaut.setBounds(200, 373, 274, 25);
		panel.add(gaut);

		frmAboutUs.setVisible(true);
	}
}
