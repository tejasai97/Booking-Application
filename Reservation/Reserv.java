package Reservation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reserv implements  ActionListener{
	JFrame f; 
	JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    
	
	Reserv(){
		
		JButton b1=new JButton("Bus Booking");
		b1.setBounds(50,150,150, 50);
		JButton b2=new JButton("Train Booking");
		b2.setBounds(220,150,150, 50);
		JButton b3=new JButton("Flight Booking");
		b3.setBounds(390,150,150, 50);
		f=new JFrame();
	    JLabel label = new JLabel("Welcome to booking system");

		panel1.add(label);
		panel2.add(b1);
		panel2.add(b2);
		panel2.add(b3);
		f.add(panel1,"North");
		f.add(panel2,"Center");
		//f.setLayout(null);  
		f.setSize(300,300);  
		f.setVisible(true);
		b1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display/center the jdialog when the button is pressed
			  f.dispose();
		   new BusGUI();
		  }
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {  
        new Reserv();
 }  
	
}
