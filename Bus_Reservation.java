package Reservation;

import java.io.Serializable;

import Myexception.*;
public class Bus_Reservation implements Reservation,Serializable {
	String database[]=new String[30];
	int head=0;
	int tail=0;
	//Bus_trip b1;
	void enter(){
	//	b1=new Bus_trip();
	}
	public boolean availability(){
		if(tail==30)
			return false;
		else
			return true;
	}
	public void print(){
		for(int i=0;i<tail;i++)
			System.out.println(database[i]+":"+(i+1));
	}
	public void book(String name){
		if(availability()){
			database[tail]=name;
			System.out.println("bus booking on the name: "+database[tail]+" has been confirmed");
			tail++;
		}
		else{
			System.out.println("no tickets left!");
		}
	}
	public void cancel(String name){
		int i=0;
		for(i=0;i<tail;i++){
			if(name.equals(database[i])){
				for(int j=i;j<tail;j++){
					database[j]=database[j+1];
				}
				tail--;
			}
		}
		if(tail<0)
			tail=0;
		try{
		if(i==tail){
		cancelled c=new cancelled();
		throw c;
		}
		}
		catch(cancelled c){
			System.out.println(toString());
		}
	}
	/*void start_thread(){
		t1.start();
		//t2.start();
		//t3.start();
	}
	Thread t1=new Thread(this,"1");
	//Thread t2=new Thread(this,"2");
	//Thread t3=new Thread(this,"3");
	 public void run(){
		b1.enter_data();
	}*/
}
