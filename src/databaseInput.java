import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class databaseInput {
	JFrame dbFrame;
	JTable table1,table2,table3,table4,table5;
	DefaultTableModel model1,model2,model3,model4,model5;
	JTabbedPane pane;
	JPanel panel1,panel2,panel3,panel4,panel5;
	String url = "jdbc:mysql://localhost:3306/timetabledata1";
	course[] courses_data;
	stud_group[] stud_group_data;
	professor[] professor_data;
	class_[] class_data;
	classroom[] classroom_data;
	
	public databaseInput(){
		//setting frame
		dbFrame = new JFrame("DATABASE");
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
        Object[] columns5 = {"Batch ID","Course Code","Student Group","Duration"};
        
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
		/*
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
        	ResultSet res2 = s.executeQuery(q2);
        	ResultSet res3 = s.executeQuery(q3);
        	ResultSet res4 = s.executeQuery(q4);
        	ResultSet res5 = s.executeQuery(q5);
        	

        
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        catch(ClassNotFoundException e){
        	e.printStackTrace();
        }
        
        
        */
        
        
        
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