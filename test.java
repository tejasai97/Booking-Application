package Reservation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class test {

	String hb=new String("C:\\Users\\tejag\\Desktop\\x\\hb.txt");
	String hc=new String("C:\\Users\\tejag\\Desktop\\x\\hc.txt");
	String cb=new String("C:\\Users\\tejag\\Desktop\\x\\cb.txt");
	String ch=new String("C:\\Users\\tejag\\Desktop\\x\\ch.txt");
	String bh=new String("C:\\Users\\tejag\\Desktop\\x\\bh.txt");
	String bc=new String("C:\\Users\\tejag\\Desktop\\x\\bc.txt");
	public static void main(String arg[]) throws ClassNotFoundException, IOException{
		Bus_trip b1=new Bus_trip("bangalore","hyderabad","sai",4);
		test t=new test();
		b1.enter_data();
		Bus_trip b2=t.save("bangalore","hyderabad",b1);
		System.out.println(b1.source);
		
		//b2.enter_data();
		//Bus_trip b3=new Bus_trip();
		//b3.enter_data();
		/*Bus_trip b4=new Bus_trip();
		b4.enter_data();*/
		//treeset te=new treeset();
		//te.store(b1);
		//te.store(b2);
		//te.store(b3);
		//t.restore("bangalore", "hyderabad", "sai", 5, b2);
		System.out.println(b2.tail);
		//te.store(b4);
	}



Bus_trip  save(String source,String Destination,Bus_trip b) throws IOException, ClassNotFoundException{
	try {
		/*FileOutputStream hbo = new FileOutputStream(hb);
		FileOutputStream hco = new FileOutputStream(hc);
		FileOutputStream cbo = new FileOutputStream(cb);
		FileOutputStream cho = new FileOutputStream(ch);
		FileOutputStream bho = new FileOutputStream(bh);
		FileOutputStream bco = new FileOutputStream(bc);*/
		FileOutputStream f = new FileOutputStream(hb);
		/*if(b.source=="hyderabad" && b.destination=="bangalore"){
			f=hbo;
		}
		if(b.source=="hyderabad" && b.destination=="chennai"){
			f=hco;
		}
		if(b.source=="bangalore" && b.destination=="hyderabad"){
			f=bho;
		}
		if(b.source=="bangalore" && b.destination=="chennai"){
			f=bco;
		}
		if(b.source=="chennai" && b.destination=="bangalore"){
			f=cbo;
		}
		if(b.source=="chennai" && b.destination=="hyderabad"){
			f=cho;
		}*/
		ObjectOutputStream oos=new ObjectOutputStream(f);
		oos.writeObject(b);
		oos.flush();
		oos.close();
		f.close();
		}
	catch(Exception e){
		System.out.println("error");
		}
	FileInputStream f1 = new FileInputStream(hb);
	ObjectInputStream ois=new ObjectInputStream(f1);
	Bus_trip b2=(Bus_trip) ois.readObject();
	return b2;
	
	}
	/*void restore(String source,String destination,String name,int number,Bus_trip b) throws ClassNotFoundException{
    	try {
    		/*FileInputStream hbi = new FileInputStream(hb);
    		FileInputStream hci = new FileInputStream(hc);
    		FileInputStream cbi = new FileInputStream(cb);
    		FileInputStream chi = new FileInputStream(ch);
    		FileInputStream bhi = new FileInputStream(bh);
    		FileInputStream bci = new FileInputStream(bc);
    		FileInputStream f = new FileInputStream(hb);
    		/*if(source=="hyderabad" && destination=="bangalore"){
    			f=hbi;
    		}
    		if(source=="hyderabad" && destination=="chennai"){
    			f=hci;
    		}
    		if(source=="bangalore" && destination=="hyderabad"){
    			f=bhi;
    		}
    		if(source=="bangalore" && destination=="chennai"){
    			f=bci;
    		}
    		if(source=="chennai" && destination=="banglaore"){
    			f=cbi;
    		}
    		if(source=="chennai" && destination=="hyderabad"){
    			f=chi;
    		}
    		FileInputStream s = f;
    		
    		ObjectInputStream ois=new ObjectInputStream(f);
    		b=(Bus_trip) ois.readObject();
    		ois.close();
    		
    			//System.out.println("new entry");
    		
    		f.close();
    	}
	catch(IOException e) {
		System.out.println("Exception during serialization: " + e);
		System.exit(0);
	}
	}	*/
}