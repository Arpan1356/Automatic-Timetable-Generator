import java.awt.*;
import javax.swing.*;

public class About {
	private JFrame frmAboutUs = new JFrame("About Us");
	private JPanel panel = new JPanel();
	
	public About() {
		frmAboutUs.add(panel);
		frmAboutUs.setResizable(false);
		frmAboutUs.setBounds(100, 100, 450, 450);
		frmAboutUs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAboutUs.setLocationRelativeTo(null);
		
		panel.setBackground(Color.getHSBColor(0.81F, 12F, 1.32F));
		panel.setLayout(null);

		JLabel lblAboutUs = new JLabel("ABOUT US");
		lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutUs.setFont(new Font("Chiller", Font.BOLD, 35));
		lblAboutUs.setBounds(10, 11, 274, 65);
		panel.add(lblAboutUs);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imgs\\vit.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 87, 274, 123);
		panel.add(lblNewLabel);

		JLabel nish = new JLabel("NISHANT KAUSHIK - 14BCE0398");
		nish.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nish.setBounds(10, 221, 274, 25);
		panel.add(nish);

		JLabel prak = new JLabel("PRAKHAR YADAV - 14BCE0216");
		prak.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prak.setBounds(10, 257, 274, 25);
		panel.add(prak);

		JLabel gaut = new JLabel("GAUTAM MITTAL - 14BCE0215");
		gaut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gaut.setBounds(10, 293, 274, 25);
		panel.add(gaut);

		frmAboutUs.setVisible(true);
	}
}
