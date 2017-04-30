import javax.swing.*;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



public class printSchedule {
	
	JFrame frame;
	JTable table;
	DefaultTableModel model;
	String mainLabel = "Timetable- ";
	JButton send = new JButton("Get Notification");
	JTextField tf = new JTextField();
	Scheduler sol;
	Object[] r1 = new Object[10];
	Object[] r2 = new Object[10];
	Object[] r3 = new Object[10];
	Object[] r4 = new Object[10];
	Object[] r5 = new Object[10];
	
	public printSchedule(Scheduler s, String type, Object id) {
		System.out.println(type + " " + id);
		this.sol = s;
		mainLabel = mainLabel + type + ":" + id.toString();
		frame = new JFrame("Automatically Generated Timetable");//frame settings
		frame.setBounds(100,100,1260,700);
		send.setBounds(100,500,200,50);
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==send && tf.getText().equals("+918903367202")){
					String ACCOUNT_SID = "ACd28c4735c6bf0bdc2abf8e0588b5f315";
					String AUTH_TOKEN = "e0ad51708d5388ff2b8faadca1c511d1";

					    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
					    Message message = Message.creator(new PhoneNumber("+918903367202"),//9943622203
					        new PhoneNumber("+16143899818"), 
					        "Dear User. Your timetable has been generated. Please Check!").create();
					    //QRmMJP/EHyL6mj3hW4X05hP1q78ElytBEthaIuWd
					    
					    System.out.println(message.getSid());
				}
			}
			
		});
		frame.add(send);
		tf.setBounds(100,560,200,50);
		tf.setText("+918903367202");
		frame.add(tf);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		
		JLabel label = new JLabel(mainLabel);//main timetable label
		label.setBounds(300, 10, 400, 50);
		label.setFont(new Font("Arial",Font.BOLD,20));
		frame.add(label);
		
		table =  new JTable();//Timetable as a table
		model = new DefaultTableModel();
		table.setDefaultEditor(Object.class, null);
		String[] timings = {"Days/Time","9am-10am","10am-11am","11am-12noon","12noon-1pm","1pm-2pm","2pm-3pm","3pm-4pm","4pm-5pm","5pm-6pm"};//1st row
		model.setColumnIdentifiers(timings);
		table.setModel(model);
		
		
		switch(type){
			case "Professor" :	getProfObjects(id);
								break;
								
			case "Student" 	 :	getStudObjects(id);
								break;
				
			case "Room"      :	getRoomObjects(id);
								break;
		}
		//adding row
		model.addRow(r1);
		model.addRow(r2);
		model.addRow(r3);
		model.addRow(r4);
		model.addRow(r5);
		
		//modifying table
		table.setBackground(Color.LIGHT_GRAY);
		for(int col_i =0 ; col_i<table.getColumnCount(); ++col_i){
			TableColumn col = table.getColumnModel().getColumn(col_i);
			col.setCellRenderer(new CustomTableCellRenderer());
		}
		JTableHeader head = table.getTableHeader();
		head.setPreferredSize(new Dimension(100,table.getRowHeight()+50));
		head.setBackground(Color.CYAN);
		for(int row_i=0 ; row_i<table.getRowCount(); ++row_i){
			table.setRowHeight(row_i, 70);
		}
		
		
		//adding to a scroll
		JScrollPane scroller = new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setBounds(60, 60, 1150, 400);
		frame.add(scroller);
		
		frame.setVisible(true);
	}
	
	private void getRoomObjects(Object id) {
		int roomNo=0,roomId = (int)id;
		for(int i=0; i<sol.inputData.crD.size();++i){
			if(sol.inputData.crD.get(i).number == roomId){
				roomNo = i;
				break;
			}
		}
		Object[] row1 = new Object[10];
		Object[] row2 = new Object[10];
		Object[] row3 = new Object[10];
		Object[] row4 = new Object[10];
		Object[] row5 = new Object[10];
		for(int i=0; i<10; ++i){
			row1[i]="-";
			row2[i]="-";
			row3[i]="-";
			row4[i]="-";
			row5[i]="-";
		}
		r1 = row1; r2 = row2;
		r3 = row3; r4 = row4;
		r5 = row5;
		
		row1[0] = "MONDAY";
		row2[0] = "TUESDAY";
		row3[0] = "WEDNESDAY";
		row4[0] = "THURSDAY";
		row5[0] = "FRIDAY";
		
		row1[5] = "L";
		row2[5] = "U";
		row3[5] = "N";
		row4[5] = "C";
		row5[5] = "H";
		
		for(int i=0; i<sol.nClass; ++i){
			if(getRoomNo(sol.map[i]) == roomNo){
				int index;
				switch(getDayNo(sol.map[i])){
					case 0: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row1[index] = sol.inputData.cD.get(i).batch_id + "-" +sol.inputData.cD.get(i).professor_id + "-" + sol.inputData.cD.get(i).course_code;
							break;
					case 1: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row2[index] = sol.inputData.cD.get(i).batch_id + "-" +sol.inputData.cD.get(i).professor_id + "-" + sol.inputData.cD.get(i).course_code;
							break;
					case 2: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row3[index] = sol.inputData.cD.get(i).batch_id + "-" +sol.inputData.cD.get(i).professor_id + "-" + sol.inputData.cD.get(i).course_code;
							break;
					case 3: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row4[index] = sol.inputData.cD.get(i).batch_id + "-" + sol.inputData.cD.get(i).professor_id + "-" + sol.inputData.cD.get(i).course_code;
							break;
					case 4: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row5[index] = sol.inputData.cD.get(i).batch_id + "-" + sol.inputData.cD.get(i).professor_id + "-" + sol.inputData.cD.get(i).course_code;
							break;
				}
			}
		}
	}
	public int getRoomNo(int x){
		x=x%(8*sol.nRoom);
		x=x/8;
		return x;
	}
	public int getDayNo(int x){
		x = x/(8*sol.nRoom);
		return x;
	}
	public int getTimeSlot(int x){
		x = x%(8*sol.nRoom);
		x = x%8;
		return x;
	}

	private void getStudObjects(Object id) {
		String batchId = (String)id;
		Object[] row1 = new Object[10];
		Object[] row2 = new Object[10];
		Object[] row3 = new Object[10];
		Object[] row4 = new Object[10];
		Object[] row5 = new Object[10];
		for(int i=0; i<10; ++i){
			row1[i]="-";
			row2[i]="-";
			row3[i]="-";
			row4[i]="-";
			row5[i]="-";
		}
		r1 = row1; r2 = row2;
		r3 = row3; r4 = row4;
		r5 = row5;
		
		row1[0] = "MONDAY";
		row2[0] = "TUESDAY";
		row3[0] = "WEDNESDAY";
		row4[0] = "THURSDAY";
		row5[0] = "FRIDAY";
		
		row1[5] = "L";
		row2[5] = "U";
		row3[5] = "N";
		row4[5] = "C";
		row5[5] = "H";
		
		for(int i=0; i<sol.nClass; ++i){
			if(batchId.equals(sol.inputData.cD.get(i).batch_id)){
				int index;
				switch(getDayNo(sol.map[i])){
				
					case 0: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row1[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 1: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row2[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 2: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row3[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 3: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row4[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 4: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row5[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
														
							break;
				}
			}
		}
		
	}

	private void getProfObjects(Object id) {
		int profId = (int)id;
		Object[] row1 = new Object[10];
		Object[] row2 = new Object[10];
		Object[] row3 = new Object[10];
		Object[] row4 = new Object[10];
		Object[] row5 = new Object[10];
		for(int i=0; i<10; ++i){
			row1[i]="-";
			row2[i]="-";
			row3[i]="-";
			row4[i]="-";
			row5[i]="-";
		}
		r1 = row1; r2 = row2;
		r3 = row3; r4 = row4;
		r5 = row5;
		
		row1[0] = "MONDAY";
		row2[0] = "TUESDAY";
		row3[0] = "WEDNESDAY";
		row4[0] = "THURSDAY";
		row5[0] = "FRIDAY";
		
		row1[5] = "L";
		row2[5] = "U";
		row3[5] = "N";
		row4[5] = "C";
		row5[5] = "H";
		
		for(int i=0; i<sol.nClass; ++i){
			if(sol.inputData.cD.get(i).professor_id == profId){
				int index;
				switch(getDayNo(sol.map[i])){
					case 0: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row1[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 1: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row2[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 2: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row3[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 3: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row4[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
					case 4: index = getTimeSlot(sol.map[i])+1;
							if(index >= 5)
							index++;
							row5[index] = sol.inputData.cD.get(i).course_code + "-" + sol.inputData.crD.get(getRoomNo(sol.map[i])).number;
							break;
				}
			}
		}
		

		
	}

	public Object[] modifiedRow(Object[] row){
		
		for(int i=0;i<5;++i){
			
		}
		return row;
	}
	public class CustomTableCellRenderer extends DefaultTableCellRenderer{
		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent (JTable table, 
		Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
			this.setHorizontalAlignment(SwingConstants.CENTER);
			
		Component cell = super.getTableCellRendererComponent(
		   table, obj, isSelected, hasFocus, row, column);
		  
		  if (column == 0) {
		  cell.setBackground(Color.YELLOW);
		  }
		  	return cell;
		  }
	}
}