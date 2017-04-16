package Reservation;

public interface Reservation {
	void book(String name);
	boolean availability();
	void cancel(String name);
	void print();
	}
