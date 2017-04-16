package Reservation;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;


public class BusGUI {
	
	JFrame f; 
	
		String hb=new String("C:\\Users\\tejag\\Desktop\\x\\hb.txt");
		String hc=new String("C:\\Users\\tejag\\Desktop\\x\\hc.txt");
		String cb=new String("C:\\Users\\tejag\\Desktop\\x\\cb.txt");
		String ch=new String("C:\\Users\\tejag\\Desktop\\x\\ch.txt");
		String bh=new String("C:\\Users\\tejag\\Desktop\\x\\bh.txt");
		String bc=new String("C:\\Users\\tejag\\Desktop\\x\\bc.txt");
		String source=new String();
		String destination=new String();
		int number;
		String name=new String();
	
	JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3=new JPanel();
    JPanel panel4=new JPanel();
    JPanel panel5=new JPanel();
    JComboBox<String> jcb;
    JComboBox<String> jcb2;
    JComboBox<Integer> jcb3;
    JTextField t=new JTextField("name",15);
    public void save(String source,String Destination,Bus_trip b){
    	try {
    		FileOutputStream hbo = new FileOutputStream(hb);
    		FileOutputStream hco = new FileOutputStream(hc);
    		FileOutputStream cbo = new FileOutputStream(cb);
    		FileOutputStream cho = new FileOutputStream(ch);
    		FileOutputStream bho = new FileOutputStream(bh);
    		FileOutputStream bco = new FileOutputStream(bc);
    		FileOutputStream f = new FileOutputStream(hb);
    		if(b.source=="hyderabad" && b.destination=="bangalore"){
    			f = new FileOutputStream(hb);
    		}
    		if(b.source=="hyderabad" && b.destination=="chennai"){
    			f = new FileOutputStream(hc);
    		}
    		if(b.source=="bangalore" && b.destination=="hyderabad"){
    			f = new FileOutputStream(bh);
    		}
    		if(b.source=="bangalore" && b.destination=="chennai"){
    			f = new FileOutputStream(bc);
    		}
    		if(b.source=="chennai" && b.destination=="bangalore"){
    			f = new FileOutputStream(cb);
    		}
    		if(b.source=="chennai" && b.destination=="hyderabad"){
    			f = new FileOutputStream(ch);
    		}
    		ObjectOutputStream oos=new ObjectOutputStream(f);
    		oos.writeObject(b);
    	}
    	catch(Exception e){
    		System.out.println("error");
    	}
    	}
    	Bus_trip restore(String source,String destination,String name,int number) throws ClassNotFoundException{
        	try {
        		System.out.println(number);
        		FileInputStream hbi = new FileInputStream(hb);
        		FileInputStream hci = new FileInputStream(hc);
        		FileInputStream cbi = new FileInputStream(cb);
        		FileInputStream chi = new FileInputStream(ch);
        		FileInputStream bhi = new FileInputStream(bh);
        		FileInputStream bci = new FileInputStream(bc);
        		FileInputStream f = new FileInputStream(hb);
        		if(source=="hyderabad" && destination=="bangalore"){
        			f=new FileInputStream(hb);
        		}
        		if(source=="hyderabad" && destination=="chennai"){
        			f=new FileInputStream(hc);
        			System.out.println("h-c");
        		}
        		if(source=="bangalore" && destination=="hyderabad"){
        			f=new FileInputStream(bh);
        		}
        		if(source=="bangalore" && destination=="chennai"){
        			f=new FileInputStream(bc);
        		}
        		if(source=="chennai" && destination=="banglaore"){
        			f=new FileInputStream(cb);
        		}
        		if(source=="chennai" && destination=="hyderabad"){
        			f=new FileInputStream(ch);
        		}
        		FileInputStream s = f;
        		if(s.getChannel().size() != 0){
        		ObjectInputStream ois=new ObjectInputStream(f);
        		return (Bus_trip) ois.readObject();
        		//ois.close();}
        		}
        		else{
        			return new Bus_trip(source,destination,name,number);
        		}
        		//f.close();
        	}
    	catch(IOException e) {
    		System.out.println("Exception during serialization: " + e);
    		System.exit(0);
    	}
			return null;
    		
    }
    BusGUI(){
    	String[] cities={"bangalore","hyderabad","chennai"};
    	JLabel j=new JLabel("choose the source city:");
    	JLabel j2=new JLabel("choose the destination city:");
    	JLabel j3=new JLabel("select number of tickets:");
    	JLabel j4=new JLabel("enter your name:");
    	
    	jcb=new JComboBox<String>(cities);
    	
    	jcb2=new JComboBox<String>(cities);
    	
    	jcb3=new JComboBox<Integer>();
    	int numbers_to_add_max = 30;
    	for (int i = 1; i <= numbers_to_add_max; i++) {
    	    jcb3.addItem(new Integer(i));
    	}
		JButton b1=new JButton("Book");
		b1.setBounds(50,150,10, 50);
		JButton b2=new JButton("Cancel Ticket");
		b2.setBounds(50,150,10, 50);
    	panel1.add(j);
    	panel1.add(jcb);
    	panel2.add(j2);
    	panel2.add(jcb2);
    	panel3.add(j3);
    	panel3.add(jcb3);
    	panel4.add(j4);
    	panel4.add(t);
    	panel5.add(b1);
    	panel5.add(b2);
    	f=new JFrame();
    	f.setLayout(new GridLayout(10,10));
    	f.add(panel1);
    	f.add(panel2);
    	f.add(panel3);
    	f.add(panel4);
    	f.add(panel5);
    	f.setSize(700,700);
    	f.setVisible(true);
    	b2.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display/center the jdialog when the button is pressed
			  f.dispose();
		   new BusCancel();
		  }
		});
    	b1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
				
			source=(String) jcb.getSelectedItem();
			destination=(String) jcb2.getSelectedItem();
			number=(int) jcb3.getSelectedItem();
			
			name=(String)t.getText();
			if(source==destination){
				JOptionPane.showMessageDialog(new JFrame(), "source and destination cannot be same", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				f.dispose();
			}
			else{
			try {
				Bus_trip b=restore(source,destination,name,number);
				System.out.println(b.tail);
				   int result = JOptionPane.showConfirmDialog(new JFrame(), "the cost is:"+b.cost,
					        "alert", JOptionPane.OK_CANCEL_OPTION);
				   //System.out.println(result);
				   if(result==0){
				b.book_for=number;
				b.name=name;
				b.enter_data();
				
				System.out.println("saving data...");
				save(source, destination, b);
				JOptionPane.showMessageDialog(new JFrame(), "booking completed!", "booking completed",
				        JOptionPane.INFORMATION_MESSAGE);
				/*JOptionPane.showMessageDialog(new JFrame(), "Data Saved", "Save",
				        JOptionPane.INFORMATION_MESSAGE);*/
				System.out.println(b.tail);}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//b=new Bus_trip(source,destination,name,number);
			
			
			}
		  }
		});
    	
    }
    public static void main(String[] args) {  
        new BusGUI();
 }  
}
