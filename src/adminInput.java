import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class adminInput {
	JFrame frame;
	JMenuBar bar = new JMenuBar();
	JMenu option = new JMenu("Options");
	JTabbedPane tabPane;
	JTable table1,table2,table3,table4,table5;
	JLabel label11,label12,label13,label21,label22,label23,label31,label32,label33,label41,label42,label43,label51,label52,label53,label54,label55;
	JTextField text11,text12,text13,text21,text22,text23,text31,text32,text33,text41,text42,text43,text51,text52,text53,text54,text55;
	JPanel panel1, panel2, panel3, panel4, panel5;
	JButton add1,delete1,update1,add2,delete2,update2,add3,delete3,update3,add4,delete4,update4,add5,delete5,update5;
    DefaultTableModel model1,model2,model3,model4,model5;
    

    public adminInput(){
        // create JFrame and JTable
        frame = new JFrame("ADMIN");
        frame.setJMenuBar(bar);
        bar.add(option);
        JMenuItem i1 = new JMenuItem("Back");
        i1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdminLog();
			}
        }
        );
        JMenuItem i2 = new JMenuItem("Log Out");
        i2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Start();
			}
        }
        );
        JMenuItem i3 = new JMenuItem("Create Timetable");
        i3.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				trigger();
			}
        }
        );
        JMenuItem i4 = new JMenuItem("View Timetable");
        i4.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(Login.sessionSolution != null){
					new timetableSelector(Login.sessionSolution);
				}
				else
					JOptionPane.showMessageDialog(null, "Timetable not yet created");
			}			
        }
        );
        option.add(i1);
        option.add(i2);
        option.add(i3);
        option.add(i4);
        
        
        frame.setLayout(new BorderLayout());
        tabPane = new JTabbedPane();
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        tabPane.addTab("Course", panel1);
        tabPane.addTab("Professor",panel2);
        tabPane.addTab("Classroom",panel3);
        tabPane.addTab("Student Group",panel4);
        tabPane.addTab("Class",panel5);
        
        frame.add(tabPane);
        table1 = new JTable();
        table2 = new JTable(); 
        table3 = new JTable(); 
        table4 = new JTable(); 
        table5 = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns1 = {"Code","Name","Department"};
        Object[] columns2 = {"ID","Name","Age"};
        Object[] columns3 = {"Number","Size","Computer"};
        Object[] columns4 = {"Batch ID","Name","Strength"};
        Object[] columns5 = {"Batch Name","Course Code","Credits","Professor ID","Computer Required"};
        
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
        
        // set the model to the table
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
        
        // create JTextFields
        text11 = new JTextField();
        text12 = new JTextField();
        text13 = new JTextField();
        text21 = new JTextField();
        text22 = new JTextField();
        text23 = new JTextField();
        text31 = new JTextField();
        text32 = new JTextField();
        text33 = new JTextField();
        text41 = new JTextField();
        text42 = new JTextField();
        text43 = new JTextField();
        text51 = new JTextField();
        text52 = new JTextField();
        text53 = new JTextField();
        text54 = new JTextField();
        text55 = new JTextField();
        
        label11 = new JLabel("Code");
        label12 = new JLabel("Name");
        label13 = new JLabel("Department");
        label21 = new JLabel("ID");
        label22 = new JLabel("Name");
        label23 = new JLabel("Age");
        label31 = new JLabel("Number");
        label32 = new JLabel("Size");
        label33 = new JLabel("Computer (1/0)");
        label33.setToolTipText("Enter either 0 or 1");
        label41 = new JLabel("Batch ID");
        label42 = new JLabel("Name");
        label43 = new JLabel("Strength");
        label51 = new JLabel("Batch Name");
        label52 = new JLabel("Course Code");
        label53 = new JLabel("Duration");
        label54 = new JLabel("Professor ID");
        label55 = new JLabel("Computer Required");
        
        
        // create JButtons
        add1 = new JButton("Add");
        delete1 = new JButton("Delete");
        update1 = new JButton("Update");
        add2 = new JButton("Add");
        delete2 = new JButton("Delete");
        update2 = new JButton("Update");
        add3 = new JButton("Add");
        delete3 = new JButton("Delete");
        update3 = new JButton("Update");
        add4 = new JButton("Add");
        delete4 = new JButton("Delete");
        update4 = new JButton("Update");
        add5 = new JButton("Add");
        delete5 = new JButton("Delete");
        update5 = new JButton("Update");
        
        text11.setBounds(120, 320, 100, 25);text11.setText("MAT202");
        text12.setBounds(120, 350, 100, 25);text12.setText("Linear Algebra");
        text13.setBounds(120, 380, 100, 25);text13.setText("SAS");
        
        text21.setBounds(120, 320, 100, 25);text21.setText("1021");
        text22.setBounds(120, 350, 100, 25);text22.setText("NISHA");
        text23.setBounds(120, 380, 100, 25);text23.setText("23");
        
        text31.setBounds(120, 320, 100, 25);text31.setText("202");
        text32.setBounds(120, 350, 100, 25);text32.setText("40");
        text33.setBounds(120, 380, 100, 25);text33.setText("0");
        text33.setToolTipText("Enter either 0 or 1");
        
        text41.setBounds(120, 320, 100, 25);text41.setText("2031");
        text42.setBounds(120, 350, 100, 25);text42.setText("E2");
        text43.setBounds(120, 380, 100, 25);text43.setText("40");
        
        text51.setBounds(120, 320, 100, 25);text51.setText("E2");
        text52.setBounds(120, 350, 100, 25);text52.setText("MAT202");
        text53.setBounds(120, 380, 100, 25);text53.setText("1");
        text54.setBounds(120, 410, 100, 25);text54.setText("1021");
        text55.setBounds(120, 440, 100, 25);text55.setText("0");
        
        label11.setBounds(20, 320, 100, 25);
        label12.setBounds(20, 350, 100, 25);
        label13.setBounds(20, 380, 100, 25);
        
        label21.setBounds(20, 320, 100, 25);
        label22.setBounds(20, 350, 100, 25);
        label23.setBounds(20, 380, 100, 25);
        
        label31.setBounds(20, 320, 100, 25);
        label32.setBounds(20, 350, 100, 25);
        label33.setBounds(20, 380, 100, 25);
        
        label41.setBounds(20, 320, 100, 25);
        label42.setBounds(20, 350, 100, 25);
        label43.setBounds(20, 380, 100, 25);
        
        label51.setBounds(20, 320, 100, 25);
        label52.setBounds(20, 350, 100, 25);
        label53.setBounds(20, 380, 100, 25);
        label54.setBounds(20, 410, 100, 25);
        label55.setBounds(20, 440, 100, 25);
        
        add1.setBounds(350, 320, 100, 25);
        update1.setBounds(350, 365, 100, 25);
        delete1.setBounds(350, 410, 100, 25);
        add2.setBounds(350, 320, 100, 25);
        update2.setBounds(350, 365, 100, 25);
        delete2.setBounds(350, 410, 100, 25);
        add3.setBounds(350, 320, 100, 25);
        update3.setBounds(350, 365, 100, 25);
        delete3.setBounds(350, 410, 100, 25);
        add4.setBounds(350, 320, 100, 25);
        update4.setBounds(350, 365, 100, 25);
        delete4.setBounds(350, 410, 100, 25);
        add5.setBounds(350, 320, 100, 25);
        update5.setBounds(350, 365, 100, 25);
        delete5.setBounds(350, 410, 100, 25);
        
        // create JScrollPane
        JScrollPane pane1 = new JScrollPane(table1);
        JScrollPane pane2 = new JScrollPane(table2);
        JScrollPane pane3 = new JScrollPane(table3);
        JScrollPane pane4 = new JScrollPane(table4);
        JScrollPane pane5 = new JScrollPane(table5);
        
        pane1.setBounds(20, 20, 900, 280);
        pane2.setBounds(20, 20, 900, 280);
        pane3.setBounds(20, 20, 900, 280);
        pane4.setBounds(20, 20, 900, 280);
        pane5.setBounds(20, 20, 900, 280);
        
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
        
        // add JTextFields to the jframe
        panel1.add(text11);
        panel1.add(text12);
        panel1.add(text13);
        panel2.add(text21);
        panel2.add(text22);
        panel2.add(text23);
        panel3.add(text31);
        panel3.add(text32);
        panel3.add(text33);
        panel4.add(text41);
        panel4.add(text42);
        panel4.add(text43);
        panel5.add(text51);
        panel5.add(text52);
        panel5.add(text53);
        panel5.add(text54);
        panel5.add(text55);
        
        panel1.add(label11);
        panel1.add(label12);
        panel1.add(label13);
        panel2.add(label21);
        panel2.add(label22);
        panel2.add(label23);
        panel3.add(label31);
        panel3.add(label32);
        panel3.add(label33);
        panel4.add(label41);
        panel4.add(label42);
        panel4.add(label43);
        panel5.add(label51);
        panel5.add(label52);
        panel5.add(label53);
        panel5.add(label54);
        panel5.add(label55);
    
        // add JButtons to the jframe
        panel1.add(add1);
        panel1.add(delete1);
        panel1.add(update1);
        panel2.add(add2);
        panel2.add(delete2);
        panel2.add(update2);
        panel3.add(add3);
        panel3.add(delete3);
        panel3.add(update3);
        panel4.add(add4);
        panel4.add(delete4);
        panel4.add(update4);
        panel5.add(add5);
        panel5.add(delete5);
        panel5.add(update5);
        
        // create an array of objects to set the row data
        
        
        // button add row
        add1.addActionListener(new addListener());
        add2.addActionListener(new addListener());
        add3.addActionListener(new addListener());
        add4.addActionListener(new addListener());
        add5.addActionListener(new addListener());
        
        // button remove row
        delete1.addActionListener(new deleteListener());
        delete2.addActionListener(new deleteListener());
        delete3.addActionListener(new deleteListener());
        delete4.addActionListener(new deleteListener());
        delete5.addActionListener(new deleteListener());
        
        // get selected row data From table to textfields 
        MouseAdapter x =new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i1 = table1.getSelectedRow();
            int i2 = table2.getSelectedRow();
            int i3 = table3.getSelectedRow();
            int i4 = table4.getSelectedRow();
            int i5 = table5.getSelectedRow();	
            
            if(i1 != -1){
            	System.out.println(table1.getSelectedColumn());
            	text11.setText(model1.getValueAt(i1, 0).toString());
            	text12.setText(model1.getValueAt(i1, 1).toString());
            	text13.setText(model1.getValueAt(i1, 2).toString());
            }
            if(i2 != -1){
            text21.setText(model2.getValueAt(i2, 0).toString());
            text22.setText(model2.getValueAt(i2, 1).toString());
            text23.setText(model2.getValueAt(i2, 2).toString());
            }
            
            if(i3 != -1){
            text31.setText(model3.getValueAt(i3, 0).toString());
            text32.setText(model3.getValueAt(i3, 1).toString());
            text33.setText(model3.getValueAt(i3, 2).toString());
            }
            
            if(i4 != -1){
            text41.setText(model4.getValueAt(i4, 0).toString());
            text42.setText(model4.getValueAt(i4, 1).toString());
            text43.setText(model4.getValueAt(i4, 2).toString());
            }
            
            if(i5 != -1){
            text51.setText(model5.getValueAt(i5, 0).toString());
            text52.setText(model5.getValueAt(i5, 1).toString());
            text53.setText(model5.getValueAt(i5, 2).toString());
            text54.setText(model5.getValueAt(i5, 3).toString());
            text55.setText(model5.getValueAt(i5, 4).toString());
            }
        }
        };
        
        table1.addMouseListener(x);
        table5.addMouseListener(x);
        table4.addMouseListener(x);
        table3.addMouseListener(x);
        table2.addMouseListener(x);
        
        // button update row
        update1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model1.setValueAt(text11.getText(), i, 0);
                   model1.setValueAt(text12.getText(), i, 1);
                   model1.setValueAt(text13.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table2.getSelectedRow();
                if(i >= 0) 
                {
                   model2.setValueAt(text21.getText(), i, 0);
                   model2.setValueAt(text22.getText(), i, 1);
                   model2.setValueAt(text23.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table3.getSelectedRow();
                if(i >= 0) 
                {
                   model3.setValueAt(text31.getText(), i, 0);
                   model3.setValueAt(text32.getText(), i, 1);
                   model3.setValueAt(text33.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table3.getSelectedRow();
                if(i >= 0) 
                {
                   model4.setValueAt(text41.getText(), i, 0);
                   model4.setValueAt(text42.getText(), i, 1);
                   model4.setValueAt(text43.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table5.getSelectedRow();
                if(i >= 0) 
                {
                   model5.setValueAt(text51.getText(), i, 0);
                   model5.setValueAt(text52.getText(), i, 1);
                   model5.setValueAt(text53.getText(), i, 2);
                   model5.setValueAt(text54.getText(), i, 3);
                   model5.setValueAt(text55.getText(), i, 4);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        
	    frame.setSize(1000,600);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
        
    }
    public class addListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==add1){
    			Object[] row = new Object[3];
                row[0] = text11.getText();
                if(!text11.getText().matches("[A-Z]{3}[0-9]{3}")){
                	text11.setText("");
                	text11.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text12.getText();
                if(!text12.getText().matches("[a-zA-Z ]{2,20}")){
                	text12.setText("");
                	text12.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text13.getText();
                if(!text13.getText().matches("[A-Z]{3,5}") || text13.getText().length()>5){
                	text13.setText("");
                	text13.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text11.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text12.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text13.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                
                for(int i=0; i<model1.getRowCount();i++){
                	String x = (String) model1.getValueAt(i, 0);
                	if(row[0].equals(x)){
                		JOptionPane.showMessageDialog(frame, "This course is already present");
                		return;
                	}
                }
                //System.out.println(model1.getRowCount());
                model1.addRow(row);
    		}
    		if(e.getSource()==add2){
    			Object[] row = new Object[3];
                row[0] = text21.getText();
                if(!text21.getText().matches("[0-9]{4,5}")){
                	text21.setText("");
                	text21.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text22.getText();
                if(!text22.getText().matches("[a-zA-Z ]{2,20}")){
                	text22.setText("");
                	text22.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text23.getText();
                if(!text23.getText().matches("[0-9]{1,3}")){
                	text23.setText("");
                	text23.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text21.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text22.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text23.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                
                for(int i=0; i<model2.getRowCount();i++){
                	String x = (String) model2.getValueAt(i, 0);
                	if(row[0].equals(x)){
                		JOptionPane.showMessageDialog(frame, "This ID is already present");
                		return;
                	}
                }
                model2.addRow(row);
    		}
    		if(e.getSource()==add3){
    			Object[] row = new Object[3];
                row[0] = text31.getText();
                if(!text31.getText().matches("[0-9]{1,3}")){
                	text31.setText("");
                	text31.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text32.getText();
                if(!text32.getText().matches("[0-9]{1,3}")){
                	text32.setText("");
                	text32.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text33.getText();
                if(!text33.getText().matches("[01]")){
                	text33.setText("");
                	text33.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text31.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text32.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text33.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                
                for(int i=0; i<model3.getRowCount();i++){
                	String x = (String) model3.getValueAt(i, 0);
                	if(row[0].equals(x)){
                		JOptionPane.showMessageDialog(frame, "This room is already present");
                		return;
                	}
                }
                
                model3.addRow(row);
    		}
    		if(e.getSource()==add4){
    			Object[] row = new Object[3];
                row[0] = text41.getText();
                if(!text41.getText().matches("[0-9]{4,5}")){
                	text41.setText("");
                	text41.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text42.getText();
                if(!text42.getText().matches("[a-zA-Z]{1,3}[0-9]{1,2}")){
                	text42.setText("");
                	text42.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text43.getText();
                if(!text43.getText().matches("[0-9]{1,3}")){
                	text43.setText("");
                	text43.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text41.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text42.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text43.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                
                for(int i=0; i<model4.getRowCount();i++){
                	String x = (String) model4.getValueAt(i, 0);
                	if(row[0].equals(x)){
                		JOptionPane.showMessageDialog(frame, "This student group is already added");
                		return;
                	}
                }
                
                model4.addRow(row);
    		}
    		if(e.getSource()==add5){
    			Object[] row = new Object[5];
                row[0] = text51.getText();
                if(!text51.getText().matches("[a-zA-Z]{1,3}[0-9]{1,2}")){
                	text51.setText("");
                	text51.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text52.getText();
                if(!text52.getText().matches("[a-zA-Z]{3}[0-9]{3}")){
                	text52.setText("");
                	text52.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text53.getText();
                if(!text53.getText().matches("[0-9]{1,2}")){
                	text53.setText("");
                	text53.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[3] = text54.getText();
                if(!text54.getText().matches("[0-9]{4,5}")){
                	text54.setText("");
                	text54.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[4] = text55.getText();
                if(!text55.getText().matches("[01]")){
                	text55.setText("");
                	text55.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text51.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text52.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text53.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text54.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                
                for(int i=0; i<model5.getRowCount();i++){
                	String x = (String) model5.getValueAt(i, 0);
                	String y = (String) model5.getValueAt(i, 1);
                	if(row[0].equals(x) && row[1].equals(y) ){
                		JOptionPane.showMessageDialog(frame, "This class is already added");
                		return;
                	}
                }
                
                model5.addRow(row);
    		}
    	}
    }
    
    public class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==delete1){
				int i = table1.getSelectedRow();
                if(i >= 0)
                    model1.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete2){
				int i = table2.getSelectedRow();
                if(i >= 0)
                    model2.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete3){
				int i = table3.getSelectedRow();
                if(i >= 0)
                    model3.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete4){
				int i = table4.getSelectedRow();
                if(i >= 0)
                    model4.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete5){
				int i = table5.getSelectedRow();
                if(i >= 0)
                    model5.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
		}
    }
    public class updateListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==update1){
    			int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model1.setValueAt(text11.getText(), i, 0);
                   model1.setValueAt(text12.getText(), i, 1);
                   model1.setValueAt(text13.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update2){
    			int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model2.setValueAt(text21.getText(), i, 0);
                   model2.setValueAt(text22.getText(), i, 1);
                   model2.setValueAt(text23.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update3){
    			int i = table3.getSelectedRow();
                if(i >= 0) 
                {
                   model3.setValueAt(text31.getText(), i, 0);
                   model3.setValueAt(text32.getText(), i, 1);
                   model3.setValueAt(text33.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update4){
    			int i = table4.getSelectedRow();
                if(i >= 0) 
                {
                   model4.setValueAt(text41.getText(), i, 0);
                   model4.setValueAt(text42.getText(), i, 1);
                   model4.setValueAt(text43.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update5){
    			int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model5.setValueAt(text51.getText(), i, 0);
                   model5.setValueAt(text52.getText(), i, 1);
                   model5.setValueAt(text53.getText(), i, 2);
                   model5.setValueAt(text54.getText(), i, 3);
                   model5.setValueAt(text55.getText(), i, 4);
                }
                else
                    System.out.println("Update Error");
    		}
    	}
    }
    
    public void trigger(){
    	new driver(initializeData());
    }
    
    public data initializeData(){
    	Vector<course> courseV= new Vector<course>();
    	Vector<class_> classV= new Vector<class_>();
    	Vector<stud_group> stud_grpV= new Vector<stud_group>();
    	Vector<classroom> classroomV= new Vector<classroom>();
    	Vector<professor> professorV= new Vector<professor>();
    	
    	for(int i=0; i<model1.getRowCount(); ++i){
    		String a = (String) model1.getValueAt(i, 0);
    		String b = (String) model1.getValueAt(i, 1);
    		String c = (String) model1.getValueAt(i, 2);
    		course temp = new course(a,b,c);
    		courseV.add(temp);
    	}
    	
    	for(int i=0; i<model2.getRowCount(); ++i){
    		int a =  Integer.parseInt((model2.getValueAt(i, 0)).toString()) ;
    		String b = (String) model2.getValueAt(i, 1);
    		int c = Integer.parseInt(model2.getValueAt(i, 2).toString());
    		professor temp = new professor(a,b,c);
    		professorV.add(temp);
    	}
    	for(int i=0; i<model3.getRowCount(); ++i){
    		int a = Integer.parseInt(model3.getValueAt(i, 0).toString());
    		int b = Integer.parseInt(model3.getValueAt(i, 1).toString());
    		int x = Integer.parseInt(model3.getValueAt(i, 2).toString());
    		boolean c=false;
    		if(x==1)
    			c=true;
    		classroom temp = new classroom(a,b,c);
    		classroomV.add(temp);
    	}
    	
    	for(int i=0; i<model4.getRowCount(); ++i){
    		String a = (String) model4.getValueAt(i, 0);
    		String b = (String) model4.getValueAt(i, 1);
    		int c = Integer.parseInt(model4.getValueAt(i, 2).toString());
    		stud_group temp = new stud_group(a,b,c);
    		stud_grpV.add(temp);
    	}
    	
    	for(int i=0; i<model5.getRowCount(); ++i){
    		String a = (String) model5.getValueAt(i, 0);
    		String b = (String) model5.getValueAt(i, 1);
    		int c = Integer.parseInt(model5.getValueAt(i, 2).toString());
    		int d = Integer.parseInt(model5.getValueAt(i, 3).toString());
    		String x = (String) model5.getValueAt(i, 4);
    		boolean e = false;
    		if(x=="1")
    			e=true;
    		class_ temp = new class_(a,b,c,d,e);
    		classV.add(temp);
    	}
    	    	
    	data D = new data(stud_grpV,courseV,professorV,classV,classroomV);
    	return D;
    }

}


/*

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class adminInput {
	JFrame frame;
	JMenuBar bar = new JMenuBar();
	JMenu option = new JMenu("Options");
	JTabbedPane tabPane;
	JTable table1,table2,table3,table4,table5;
	JLabel label11,label12,label13,label21,label22,label23,label31,label32,label33,label41,label42,label43,label51,label52,label53,label54,label55;
	JTextField text11,text12,text13,text21,text22,text23,text31,text32,text33,text41,text42,text43,text51,text52,text53,text54,text55;
	JPanel panel1, panel2, panel3, panel4, panel5;
	JButton add1,delete1,update1,add2,delete2,update2,add3,delete3,update3,add4,delete4,update4,add5,delete5,update5;
    DefaultTableModel model1,model2,model3,model4,model5;
    

    public adminInput(){
        // create JFrame and JTable
        frame = new JFrame("ADMIN");
        frame.setJMenuBar(bar);
        bar.add(option);
        JMenuItem i1 = new JMenuItem("Back");
        i1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdminLog();
			}
        }
        );
        JMenuItem i2 = new JMenuItem("Log Out");
        i2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Start();
			}
        }
        );
        JMenuItem i3 = new JMenuItem("Create Timetable");
        i3.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				trigger();
			}
        }
        );
        JMenuItem i4 = new JMenuItem("View Timetable");
        i4.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(Login.sessionSolution != null){
					new timetableSelector(Login.sessionSolution);
				}
				else
					JOptionPane.showMessageDialog(null, "Timetable not yet created");
			}			
        }
        );
        option.add(i1);
        option.add(i2);
        option.add(i3);
        option.add(i4);
        
        
        frame.setLayout(new BorderLayout());
        tabPane = new JTabbedPane();
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        tabPane.addTab("Course", panel1);
        tabPane.addTab("Professor",panel2);
        tabPane.addTab("Classroom",panel3);
        tabPane.addTab("Student Group",panel4);
        tabPane.addTab("Class",panel5);
        
        frame.add(tabPane);
        table1 = new JTable();
        table2 = new JTable(); 
        table3 = new JTable(); 
        table4 = new JTable(); 
        table5 = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
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
        
        // set the model to the table
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
        
        // create JTextFields
        text11 = new JTextField();
        text12 = new JTextField();
        text13 = new JTextField();
        text21 = new JTextField();
        text22 = new JTextField();
        text23 = new JTextField();
        text31 = new JTextField();
        text32 = new JTextField();
        text33 = new JTextField();
        text41 = new JTextField();
        text42 = new JTextField();
        text43 = new JTextField();
        text51 = new JTextField();
        text52 = new JTextField();
        text53 = new JTextField();
        text54 = new JTextField();
        text55 = new JTextField();
        
        label11 = new JLabel("Code");
        label12 = new JLabel("Name");
        label13 = new JLabel("Department");
        label21 = new JLabel("ID");
        label22 = new JLabel("Name");
        label23 = new JLabel("Age");
        label31 = new JLabel("Number");
        label32 = new JLabel("Size");
        label33 = new JLabel("Computer (1/0)");
        label33.setToolTipText("Enter either 0 or 1");
        label41 = new JLabel("Batch ID");
        label42 = new JLabel("Name");
        label43 = new JLabel("Strength");
        label51 = new JLabel("Batch ID");
        label52 = new JLabel("Course Code");
        label53 = new JLabel("Duration");
        label54 = new JLabel("Professor ID");
        label55 = new JLabel("Computer Required");
        
        
        // create JButtons
        add1 = new JButton("Add");
        delete1 = new JButton("Delete");
        update1 = new JButton("Update");
        add2 = new JButton("Add");
        delete2 = new JButton("Delete");
        update2 = new JButton("Update");
        add3 = new JButton("Add");
        delete3 = new JButton("Delete");
        update3 = new JButton("Update");
        add4 = new JButton("Add");
        delete4 = new JButton("Delete");
        update4 = new JButton("Update");
        add5 = new JButton("Add");
        delete5 = new JButton("Delete");
        update5 = new JButton("Update");
        
        text11.setBounds(120, 320, 100, 25);text11.setText("MAT202");
        text12.setBounds(120, 350, 100, 25);text12.setText("Linear Algebra");
        text13.setBounds(120, 380, 100, 25);text13.setText("SAS");
        
        text21.setBounds(120, 320, 100, 25);text21.setText("1021");
        text22.setBounds(120, 350, 100, 25);text22.setText("NISHA");
        text23.setBounds(120, 380, 100, 25);text23.setText("23");
        
        text31.setBounds(120, 320, 100, 25);text31.setText("202");
        text32.setBounds(120, 350, 100, 25);text32.setText("40");
        text33.setBounds(120, 380, 100, 25);text33.setText("0");
        text33.setToolTipText("Enter either 0 or 1");
        
        text41.setBounds(120, 320, 100, 25);text41.setText("2031");
        text42.setBounds(120, 350, 100, 25);text42.setText("E2");
        text43.setBounds(120, 380, 100, 25);text43.setText("40");
        
        text51.setBounds(120, 320, 100, 25);text51.setText("2031");
        text52.setBounds(120, 350, 100, 25);text52.setText("MAT202");
        text53.setBounds(120, 380, 100, 25);text53.setText("1");
        text54.setBounds(120, 410, 100, 25);text54.setText("1021");
        text55.setBounds(120, 440, 100, 25);text55.setText("0");
        
        label11.setBounds(20, 320, 100, 25);
        label12.setBounds(20, 350, 100, 25);
        label13.setBounds(20, 380, 100, 25);
        
        label21.setBounds(20, 320, 100, 25);
        label22.setBounds(20, 350, 100, 25);
        label23.setBounds(20, 380, 100, 25);
        
        label31.setBounds(20, 320, 100, 25);
        label32.setBounds(20, 350, 100, 25);
        label33.setBounds(20, 380, 100, 25);
        
        label41.setBounds(20, 320, 100, 25);
        label42.setBounds(20, 350, 100, 25);
        label43.setBounds(20, 380, 100, 25);
        
        label51.setBounds(20, 320, 100, 25);
        label52.setBounds(20, 350, 100, 25);
        label53.setBounds(20, 380, 100, 25);
        label54.setBounds(20, 410, 100, 25);
        label55.setBounds(20, 440, 100, 25);
        
        add1.setBounds(350, 320, 100, 25);
        update1.setBounds(350, 365, 100, 25);
        delete1.setBounds(350, 410, 100, 25);
        add2.setBounds(350, 320, 100, 25);
        update2.setBounds(350, 365, 100, 25);
        delete2.setBounds(350, 410, 100, 25);
        add3.setBounds(350, 320, 100, 25);
        update3.setBounds(350, 365, 100, 25);
        delete3.setBounds(350, 410, 100, 25);
        add4.setBounds(350, 320, 100, 25);
        update4.setBounds(350, 365, 100, 25);
        delete4.setBounds(350, 410, 100, 25);
        add5.setBounds(350, 320, 100, 25);
        update5.setBounds(350, 365, 100, 25);
        delete5.setBounds(350, 410, 100, 25);
        
        // create JScrollPane
        JScrollPane pane1 = new JScrollPane(table1);
        JScrollPane pane2 = new JScrollPane(table2);
        JScrollPane pane3 = new JScrollPane(table3);
        JScrollPane pane4 = new JScrollPane(table4);
        JScrollPane pane5 = new JScrollPane(table5);
        
        pane1.setBounds(20, 20, 900, 280);
        pane2.setBounds(20, 20, 900, 280);
        pane3.setBounds(20, 20, 900, 280);
        pane4.setBounds(20, 20, 900, 280);
        pane5.setBounds(20, 20, 900, 280);
        
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
        
        // add JTextFields to the jframe
        panel1.add(text11);
        panel1.add(text12);
        panel1.add(text13);
        panel2.add(text21);
        panel2.add(text22);
        panel2.add(text23);
        panel3.add(text31);
        panel3.add(text32);
        panel3.add(text33);
        panel4.add(text41);
        panel4.add(text42);
        panel4.add(text43);
        panel5.add(text51);
        panel5.add(text52);
        panel5.add(text53);
        panel5.add(text54);
        panel5.add(text55);
        
        panel1.add(label11);
        panel1.add(label12);
        panel1.add(label13);
        panel2.add(label21);
        panel2.add(label22);
        panel2.add(label23);
        panel3.add(label31);
        panel3.add(label32);
        panel3.add(label33);
        panel4.add(label41);
        panel4.add(label42);
        panel4.add(label43);
        panel5.add(label51);
        panel5.add(label52);
        panel5.add(label53);
        panel5.add(label54);
        panel5.add(label55);
    
        // add JButtons to the jframe
        panel1.add(add1);
        panel1.add(delete1);
        panel1.add(update1);
        panel2.add(add2);
        panel2.add(delete2);
        panel2.add(update2);
        panel3.add(add3);
        panel3.add(delete3);
        panel3.add(update3);
        panel4.add(add4);
        panel4.add(delete4);
        panel4.add(update4);
        panel5.add(add5);
        panel5.add(delete5);
        panel5.add(update5);
        
        // create an array of objects to set the row data
        
        
        // button add row
        add1.addActionListener(new addListener());
        add2.addActionListener(new addListener());
        add3.addActionListener(new addListener());
        add4.addActionListener(new addListener());
        add5.addActionListener(new addListener());
        
        // button remove row
        delete1.addActionListener(new deleteListener());
        delete2.addActionListener(new deleteListener());
        delete3.addActionListener(new deleteListener());
        delete4.addActionListener(new deleteListener());
        delete5.addActionListener(new deleteListener());
        
        // get selected row data From table to textfields 
        MouseAdapter x =new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i1 = table1.getSelectedRow();
            int i2 = table2.getSelectedRow();
            int i3 = table3.getSelectedRow();
            int i4 = table4.getSelectedRow();
            int i5 = table5.getSelectedRow();	
            
            if(i1 != -1){
            	System.out.println(table1.getSelectedColumn());
            	text11.setText(model1.getValueAt(i1, 0).toString());
            	text12.setText(model1.getValueAt(i1, 1).toString());
            	text13.setText(model1.getValueAt(i1, 2).toString());
            }
            if(i2 != -1){
            text21.setText(model2.getValueAt(i2, 0).toString());
            text22.setText(model2.getValueAt(i2, 1).toString());
            text23.setText(model2.getValueAt(i2, 2).toString());
            }
            
            if(i3 != -1){
            text31.setText(model3.getValueAt(i3, 0).toString());
            text32.setText(model3.getValueAt(i3, 1).toString());
            text33.setText(model3.getValueAt(i3, 2).toString());
            }
            
            if(i4 != -1){
            text41.setText(model4.getValueAt(i4, 0).toString());
            text42.setText(model4.getValueAt(i4, 1).toString());
            text43.setText(model4.getValueAt(i4, 2).toString());
            }
            
            if(i5 != -1){
            text51.setText(model5.getValueAt(i5, 0).toString());
            text52.setText(model5.getValueAt(i5, 1).toString());
            text53.setText(model5.getValueAt(i5, 2).toString());
            text54.setText(model5.getValueAt(i5, 3).toString());
            text55.setText(model5.getValueAt(i5, 4).toString());
            }
        }
        };
        
        table1.addMouseListener(x);
        table5.addMouseListener(x);
        table4.addMouseListener(x);
        table3.addMouseListener(x);
        table2.addMouseListener(x);
        
        // button update row
        update1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model1.setValueAt(text11.getText(), i, 0);
                   model1.setValueAt(text12.getText(), i, 1);
                   model1.setValueAt(text13.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table2.getSelectedRow();
                if(i >= 0) 
                {
                   model2.setValueAt(text21.getText(), i, 0);
                   model2.setValueAt(text22.getText(), i, 1);
                   model2.setValueAt(text23.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table3.getSelectedRow();
                if(i >= 0) 
                {
                   model3.setValueAt(text31.getText(), i, 0);
                   model3.setValueAt(text32.getText(), i, 1);
                   model3.setValueAt(text33.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table3.getSelectedRow();
                if(i >= 0) 
                {
                   model4.setValueAt(text41.getText(), i, 0);
                   model4.setValueAt(text42.getText(), i, 1);
                   model4.setValueAt(text43.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        update5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table5.getSelectedRow();
                if(i >= 0) 
                {
                   model5.setValueAt(text51.getText(), i, 0);
                   model5.setValueAt(text52.getText(), i, 1);
                   model5.setValueAt(text53.getText(), i, 2);
                   model5.setValueAt(text54.getText(), i, 3);
                   model5.setValueAt(text55.getText(), i, 4);
                }
                else
                    System.out.println("Update Error");
            }
        });
        
        
	    frame.setSize(1000,600);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
        
    }
    public class addListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==add1){
    			Object[] row = new Object[3];
                row[0] = text11.getText();
                if(!text11.getText().matches("[A-Z]{3}[0-9]{3}")){
                	text11.setText("");
                	text11.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text12.getText();
                if(!text12.getText().matches("[a-zA-Z ]{2,20}")){
                	text12.setText("");
                	text12.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text13.getText();
                if(!text13.getText().matches("[A-Z]{3,5}") || text13.getText().length()>5){
                	text13.setText("");
                	text13.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text11.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text12.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text13.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                model1.addRow(row);
    		}
    		if(e.getSource()==add2){
    			Object[] row = new Object[3];
                row[0] = text21.getText();
                if(!text21.getText().matches("[0-9]{4,5}")){
                	text21.setText("");
                	text21.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text22.getText();
                if(!text22.getText().matches("[a-zA-Z ]{2,20}")){
                	text22.setText("");
                	text22.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text23.getText();
                if(!text23.getText().matches("[0-9]{1,3}")){
                	text23.setText("");
                	text23.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text21.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text22.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text23.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                model2.addRow(row);
    		}
    		if(e.getSource()==add3){
    			Object[] row = new Object[3];
                row[0] = text31.getText();
                if(!text31.getText().matches("[0-9]{1,3}")){
                	text31.setText("");
                	text31.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text32.getText();
                if(!text32.getText().matches("[0-9]{1,3}")){
                	text32.setText("");
                	text32.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text33.getText();
                if(!text33.getText().matches("[01]")){
                	text33.setText("");
                	text33.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text31.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text32.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text33.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                model3.addRow(row);
    		}
    		if(e.getSource()==add4){
    			Object[] row = new Object[3];
                row[0] = text41.getText();
                if(!text41.getText().matches("[0-9]{4,5}")){
                	text41.setText("");
                	text41.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text42.getText();
                if(!text42.getText().matches("[a-zA-Z]{1,3}[0-9]{1,2}")){
                	text42.setText("");
                	text42.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text43.getText();
                if(!text43.getText().matches("[0-9]{1,3}")){
                	text43.setText("");
                	text43.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text41.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text42.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text43.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                model4.addRow(row);
    		}
    		if(e.getSource()==add5){
    			Object[] row = new Object[5];
                row[0] = text51.getText();
                if(!text51.getText().matches("[0-9]{4,5}")){
                	text51.setText("");
                	text51.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[1] = text52.getText();
                if(!text52.getText().matches("[a-zA-Z]{3}[0-9]{3}")){
                	text52.setText("");
                	text52.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[2] = text53.getText();
                if(!text53.getText().matches("[0-9]{1,2}")){
                	text53.setText("");
                	text53.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[3] = text54.getText();
                if(!text54.getText().matches("[0-9]{4,5}")){
                	text54.setText("");
                	text54.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                row[4] = text55.getText();
                if(!text55.getText().matches("[01]")){
                	text55.setText("");
                	text55.setBorder(BorderFactory.createLineBorder(Color.red));
                	JOptionPane.showMessageDialog(frame, "Invalid Input");
                	return ;
                }
                // add row to the model
                text51.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text52.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text53.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                text54.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
                model5.addRow(row);
    		}
    	}
    }
    
    public class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==delete1){
				int i = table1.getSelectedRow();
                if(i >= 0)
                    model1.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete2){
				int i = table2.getSelectedRow();
                if(i >= 0)
                    model2.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete3){
				int i = table3.getSelectedRow();
                if(i >= 0)
                    model3.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete4){
				int i = table4.getSelectedRow();
                if(i >= 0)
                    model4.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
			if(e.getSource()==delete5){
				int i = table5.getSelectedRow();
                if(i >= 0)
                    model5.removeRow(i);
                else
                    System.out.println("Delete Error");
			}
		}
    }
    public class updateListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==update1){
    			int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model1.setValueAt(text11.getText(), i, 0);
                   model1.setValueAt(text12.getText(), i, 1);
                   model1.setValueAt(text13.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update2){
    			int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model2.setValueAt(text21.getText(), i, 0);
                   model2.setValueAt(text22.getText(), i, 1);
                   model2.setValueAt(text23.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update3){
    			int i = table3.getSelectedRow();
                if(i >= 0) 
                {
                   model3.setValueAt(text31.getText(), i, 0);
                   model3.setValueAt(text32.getText(), i, 1);
                   model3.setValueAt(text33.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update4){
    			int i = table4.getSelectedRow();
                if(i >= 0) 
                {
                   model4.setValueAt(text41.getText(), i, 0);
                   model4.setValueAt(text42.getText(), i, 1);
                   model4.setValueAt(text43.getText(), i, 2);
                }
                else
                    System.out.println("Update Error");
    		}
    		if(e.getSource()==update5){
    			int i = table1.getSelectedRow();
                if(i >= 0) 
                {
                   model5.setValueAt(text51.getText(), i, 0);
                   model5.setValueAt(text52.getText(), i, 1);
                   model5.setValueAt(text53.getText(), i, 2);
                   model5.setValueAt(text54.getText(), i, 3);
                   model5.setValueAt(text55.getText(), i, 4);
                }
                else
                    System.out.println("Update Error");
    		}
    	}
    }
    
    public void trigger(){
    	new driver(initializeData());
    }
    
    public data initializeData(){
    	Vector<course> courseV= new Vector<course>();
    	Vector<class_> classV= new Vector<class_>();
    	Vector<stud_group> stud_grpV= new Vector<stud_group>();
    	Vector<classroom> classroomV= new Vector<classroom>();
    	Vector<professor> professorV= new Vector<professor>();
    	
    	for(int i=0; i<model1.getRowCount(); ++i){
    		String a = (String) model1.getValueAt(i, 0);
    		String b = (String) model1.getValueAt(i, 1);
    		String c = (String) model1.getValueAt(i, 2);
    		course temp = new course(a,b,c);
    		courseV.add(temp);
    	}
    	
    	for(int i=0; i<model2.getRowCount(); ++i){
    		int a =  Integer.parseInt((model2.getValueAt(i, 0)).toString()) ;
    		String b = (String) model2.getValueAt(i, 1);
    		int c = Integer.parseInt(model2.getValueAt(i, 2).toString());
    		professor temp = new professor(a,b,c);
    		professorV.add(temp);
    	}
    	for(int i=0; i<model3.getRowCount(); ++i){
    		int a = Integer.parseInt(model3.getValueAt(i, 0).toString());
    		int b = Integer.parseInt(model3.getValueAt(i, 1).toString());
    		int x = Integer.parseInt(model3.getValueAt(i, 2).toString());
    		boolean c=false;
    		if(x==1)
    			c=true;
    		classroom temp = new classroom(a,b,c);
    		classroomV.add(temp);
    	}
    	
    	for(int i=0; i<model4.getRowCount(); ++i){
    		String a = (String) model4.getValueAt(i, 0);
    		String b = (String) model4.getValueAt(i, 1);
    		int c = Integer.parseInt(model4.getValueAt(i, 2).toString());
    		stud_group temp = new stud_group(a,b,c);
    		stud_grpV.add(temp);
    	}
    	
    	for(int i=0; i<model5.getRowCount(); ++i){
    		String a = (String) model5.getValueAt(i, 0);
    		String b = (String) model5.getValueAt(i, 1);
    		int c = Integer.parseInt(model5.getValueAt(i, 2).toString());
    		int d = Integer.parseInt(model5.getValueAt(i, 3).toString());
    		String x = (String) model5.getValueAt(i, 4);
    		boolean e = false;
    		if(x=="1")
    			e=true;
    		class_ temp = new class_(a,b,c,d,e);
    		classV.add(temp);
    	}
    	    	
    	data D = new data(stud_grpV,courseV,professorV,classV,classroomV);
    	return D;
    }

}*/