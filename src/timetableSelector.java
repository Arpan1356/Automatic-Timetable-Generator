import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
public class timetableSelector {
	JFrame frame;
	ButtonGroup grp;
	Scheduler sol;
	JButton View;
	JRadioButton l3,l2,l1;
	@SuppressWarnings("rawtypes")
	JComboBox c3,c2,c1;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public timetableSelector(Scheduler s){
		this.sol=s;
		frame = new JFrame("Automatic Timetable Generator");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1 = new JRadioButton("Professor");
		l2 = new JRadioButton("Student");
		l3 = new JRadioButton("Room");
		JLabel l4 = new JLabel("Select the option and click \"View\"");
		
		l1.setFont(new Font("Arial",Font.PLAIN,15));
		l2.setFont(new Font("Arial",Font.PLAIN,15));
		l3.setFont(new Font("Arial",Font.PLAIN,15));
		l4.setFont(new Font("Arial",Font.BOLD,20));
		
		l1.setBounds(40,85,100,20);
		l2.setBounds(40,175,100,20);
		l3.setBounds(40,265,100,20);
		l4.setBounds(40,20,400,20);
		
		grp = new ButtonGroup();
		grp.add(l1);
		grp.add(l2);
		grp.add(l3);
		
		frame.add(l1);
		frame.add(l2);
		frame.add(l4);
		frame.add(l3);
		
		Vector<String> stud = new Vector<String>();
		for(int i=0;i<s.inputData.sgD.size() ;++i){
			stud.add(s.inputData.sgD.get(i).id);
		}
		
		Vector<Integer> prof = new Vector<Integer>();
		for(int i=0;i<s.inputData.pD.size();++i){
			prof.add(s.inputData.pD.get(i).id);
		}
		
		Vector<Integer> room = new Vector<Integer>();
		for(int i=0;i<s.inputData.crD.size();++i){
			room.add(s.inputData.crD.get(i).number);
		}
		
		
		c1 = new JComboBox(prof);
		c1.setBounds(300, 80, 100, 25);
		frame.add(c1);
		
		c2 = new JComboBox(stud);
		c2.setBounds(300, 170, 100, 25);
		frame.add(c2);
		
		c3 = new JComboBox(room);
		c3.setBounds(300, 260, 100, 25);
		frame.add(c3);
		
		View = new JButton("View");
		View.setBounds(400,300,80,30);
		frame.add(View);
		View.addActionListener(new viewAction());
		frame.setVisible(true);
	}
	
	public class viewAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==View){
				if(l1.isSelected()){
					new printSchedule(sol,"Professor",c1.getSelectedItem());
				}
				if(l2.isSelected()){
					new printSchedule(sol,"Student",c2.getSelectedItem());
				}
				if(l3.isSelected()){
					new printSchedule(sol,"Room",c3.getSelectedItem());
				}
			}
		}
		
	}
}













