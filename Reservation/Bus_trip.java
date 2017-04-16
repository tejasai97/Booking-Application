package Reservation;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
public class Bus_trip extends Bus_Reservation implements Comparable<Bus_trip>,Serializable//,Runnable
{
	
	String source,destination,name;
	boolean avaliability;
	int book_for=0;
	int amount;
	Random randomGenerator = new Random(System.currentTimeMillis());
	double rn  = randomGenerator.nextDouble();
    int costs = (int)(rn * (1000-100)),
    cost = 100 + costs;
    //Thread t1=new Thread(this,"1");
	/*private Scanner s1;
	private Scanner s;
	private Scanner s12;*/
	Bus_trip(){
		//cost = 300;
		/*s12 = new Scanner(System.in);
		System.out.println("enter the source"); 
		source =s12.nextLine();
		System.out.println("enter the destination"); 
		destination =s12.nextLine();*/
	}
	Bus_trip(String sourc,String dest,String nam,int number){
		source=sourc;
		destination=dest;
		name=nam;
		book_for=number;
	}
	synchronized void enter_data(){
	/*s = new Scanner(System.in);
	System.out.println("enter the number of seats"); 
	book_for =s.nextInt();
	amount = (cost)*(book_for);
	s1 = new Scanner(System.in);
	System.out.println("enter your name"); 
	String name=s1.next();*/
		for(int i=0;i<book_for;i++){
			book(name);
		}
	//t1.start();
	//System.out.println("total cost:"+amount); 
	}
	
	@Override
	public int compareTo(Bus_trip o) {
		// TODO Auto-generated method stub
		if(this.cost<o.cost){
            return 1;
        } else {
            return -1;
        }
	}
	/*void save(){
		
	}*/
	
	/*public void run() {
		// TODO Auto-generated method stub
		synchronized(database){//only one can access the database at a time,so simultaneous booking is'nt possible :(
		for(int i=0;i<book_for;i++){
			book(name);
			}
		}
	}*/
}
