import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class databaseInput {
	JFrame dbFrame;
	JMenuBar bar = new JMenuBar();
	JMenu option = new JMenu("Options");
	JTable table1,table2,table3,table4,table5;
	DefaultTableModel model1,model2,model3,model4,model5;
	JTabbedPane pane;
	JPanel panel1,panel2,panel3,panel4,panel5;
	String url = "jdbc:mysql://localhost:3306/timetabledata1";

	Vector<stud_group> stud_group_data;
	Vector<course> course_data;
	Vector<professor> professor_data;
	Vector<class_> class_data;
	Vector<classroom> classroom_data;
	
	public databaseInput(){
		//setting frame
		dbFrame = new JFrame("DATABASE");
		
		dbFrame.setJMenuBar(bar);
        bar.add(option);
        JMenuItem i1 = new JMenuItem("Back");
        i1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dbFrame.dispose();
				new AdminLog();
			}
        }
        );
        JMenuItem i2 = new JMenuItem("Log Out");
        i2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dbFrame.dispose();
				new Start();
			}
        }
        );
        JMenuItem i3 = new JMenuItem("Create Timetable");
        i3.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				data d = new data(stud_group_data, course_data, professor_data,class_data,classroom_data);
				GeneticAlgorithm g = new GeneticAlgorithm(d);
				//Scheduler s = new Scheduler(d);
				//dbFrame.dispose();
				//new Start();
			}
        }
        );
        option.add(i1);
        option.add(i2);
        option.add(i3);
		
		
		
		dbFrame.setSize(960,600);
		dbFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbFrame.setLocationRelativeTo(null);
		//setting frame content
		pane = new JTabbedPane();
		panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        pane.addTab("Course", panel1);
        pane.addTab("Professor",panel2);
        pane.addTab("Classroom",panel3);
        pane.addTab("Student Group",panel4);
        pane.addTab("Class",panel5);
        
        table1 = new JTable();
        table2 = new JTable(); 
        table3 = new JTable(); 
        table4 = new JTable(); 
        table5 = new JTable(); 
		
        Object[] columns1 = {"Code","Name","Department"};
        Object[] columns2 = {"ID","Name","Age"};
        Object[] columns3 = {"Number","Size","Computer"};
        Object[] columns4 = {"Batch ID","Name","Strength"};
        Object[] columns5 = {"Batch ID","Course Code","Duration","Professor ID","Computer Required"};
        
        model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columns1);
        model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(columns2);
        model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(columns3);
        model4 = new DefaultTableModel();
        model4.setColumnIdentifiers(columns4);
        model5 = new DefaultTableModel();
        model5.setColumnIdentifiers(columns5);
        //table ready to be filled now
		
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection c = DriverManager.getConnection(url,"root","dotapro");
        	String q2 = "select * from professor";
        	String q1 = "select * from course";
        	String q3 = "select * from classroom";
        	String q4 = "select * from stud_group";
        	String q5 = "select * from class";
        	
        	Statement s = c.createStatement();
        	ResultSet res1 = s.executeQuery(q1);
        	
        	
        	professor_data = new Vector<professor>();
        	class_data = new Vector<class_>();
        	course_data = new Vector<course>();
        	stud_group_data = new Vector<stud_group>();
        	classroom_data = new Vector<classroom>();
        	
        	while(res1.next()){
        		String code =res1.getString(1);
        		String name = res1.getString(2);	
        		String department = res1.getString(3);
        		course temp = new course(code,name,department);
        		course_data.add(temp);
        	}
        	ResultSet res3 = s.executeQuery(q3);
        	while(res3.next()){
        		int number =res3.getInt(1);
        		int size = res3.getInt(2);	
        		boolean computer = res3.getBoolean(3);
        		classroom temp = new classroom(number,size,computer);
        		classroom_data.add(temp);
        	}
        	ResultSet res2 = s.executeQuery(q2);
        	while(res2.next()){
        		int id =res2.getInt(1);
        		String name = res2.getString(2);	
        		int age = res2.getInt(3);
        		professor temp = new professor(id,name,age);
        		professor_data.add(temp);
        	}

        	ResultSet res4 = s.executeQuery(q4);
        	while(res4.next()){
        		String id =res4.getString(1);
        		String name = res4.getString(2);	
        		int strength = res4.getInt(3);
        		stud_group temp = new stud_group(id,name,strength);
        		stud_group_data.add(temp);
        	}
        	ResultSet res5 = s.executeQuery(q5);
        	while(res5.next()){
        		String bat_id = res5.getString(1);
        		String course_code = res5.getString(2);
        		int dur =res5.getInt(3);
        		int prof_id = res5.getInt(4);
        		boolean comp_req = res5.getBoolean(5);
        		class_ temp = new class_(bat_id,course_code,dur,prof_id,comp_req);
        		class_data.add(temp);
        	}        
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        catch(ClassNotFoundException e){
        	e.printStackTrace();
        }
        try{
        for(course i:course_data){
        	Object[] row = new Object[3];
        	row[0] = i.code;
        	row[1] = i.name;
        	row[2] = i.department;
        	model1.addRow(row);
        }
        for(professor i:professor_data){
        	Object[] row = new Object[3];
        	row[0] = i.id;
        	row[1] = i.name;
        	row[2] = i.age;
        	model2.addRow(row);
        }
        for(classroom i:classroom_data){
        	Object[] row = new Object[3];
        	row[0] = i.number;
        	row[1] = i.size;
        	row[2] = i.computer;
        	model3.addRow(row);
        }
        for(stud_group i:stud_group_data){
        	Object[] row = new Object[3];
        	row[0] = i.id;
        	row[1] = i.name;
        	row[2] = i.strength;
        	model4.addRow(row);
        }
        for(class_ i:class_data){
        	Object[] row = new Object[5];
        	row[0] = i.batch_id;
        	row[1] = i.course_code;
        	row[2] = i.duration;
        	row[3] = i.professor_id;
        	row[4] = i.computer_req;
        	model5.addRow(row);
        }
        }
        catch(NullPointerException e){
        	System.out.println("Please check database connection.");
        }
        //setting model
        table1.setModel(model1);
        table1.setRowHeight(20);
        table2.setModel(model2);
        table2.setRowHeight(20);
        table3.setModel(model3);
        table3.setRowHeight(20);
        table4.setModel(model4);
        table4.setRowHeight(20);
        table5.setModel(model5);
        table5.setRowHeight(20);
        
		
        JScrollPane pane1 = new JScrollPane(table1);
        JScrollPane pane2 = new JScrollPane(table2);
        JScrollPane pane3 = new JScrollPane(table3);
        JScrollPane pane4 = new JScrollPane(table4);
        JScrollPane pane5 = new JScrollPane(table5);
        
        pane1.setBounds(20, 20, 900, 400);
        pane2.setBounds(20, 20, 900, 400);
        pane3.setBounds(20, 20, 900, 400);
        pane4.setBounds(20, 20, 900, 400);
        pane5.setBounds(20, 20, 900, 400);
        
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
        
        panel1.add(pane1);
        panel2.add(pane2);
        panel3.add(pane3);
        panel4.add(pane4);
        panel5.add(pane5);
		
		dbFrame.add(pane);
		
		dbFrame.setVisible(true);
		
	}
}