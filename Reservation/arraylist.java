package Reservation;
import java.util.*;
public class arraylist{
	ArrayList<Bus_trip> obj=new ArrayList<Bus_trip>();
	void store(Bus_trip b){
		int i=0;
		for(i=0;i<obj.size();i++)
		{
			Bus_trip test=obj.get(i);
			if(b.source==test.source && b.destination==test.destination){
				b=test;
				b.enter_data();
				break;
			}
		}
		if(i==obj.size()){
			b.enter_data();
			obj.add(b);
		}
	}
}
