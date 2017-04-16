package Reservation;
import java.util.*;
public class treeset extends Bus_trip 
{//implements Comparable<Bus_trip> {
	/*public int compare(Bus_trip b1, Bus_trip b2) {
        if(b1.cost>b2.cost){
            return 1;
        } else {
            return -1;
        }
    }*/
	static TreeSet<Bus_trip> obj;
	treeset(){
		obj=new TreeSet<Bus_trip>();
	}
	void store(Bus_trip b){
		int i=0;
		Iterator<Bus_trip> it=obj.iterator();
		for(i=0;i<obj.size();i++)
		{
			Bus_trip test=it.next();
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
