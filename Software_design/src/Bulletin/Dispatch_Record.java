package Bulletin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Dispatch_Record{
	String coll_name;			//college name
	String period;				//exchange student period
	String major;				//exchange student major
	public static int count=0;
	public static boolean sort_flag=false;		//checking for sorting repitition
	public static LinkedList<Dispatch_Record> dispatch_record=new LinkedList<>();	//Linkedlist of Dispatch
	public Dispatch_Record(String c_name, String period, String major) {
		coll_name=c_name;
		this.period=period;
		this.major=major;
	}
	
	public String get_coll_name() {
		return this.coll_name;
	}
	
	public String get_period() {
		return this.period;
	}
	public String get_major() {
		return this.major;
	}
	// add bulletin to list;
	public static void add_Dispatch_to_list(String coll_name, String period, String major){
		//create Bulletin and insert to list;
		Dispatch_Record myDispatch = new Dispatch_Record(coll_name,period,major);
		dispatch_record.add(myDispatch);
	}
	
	
	
	
	public static void upload() { // Upload Dispatch data to DB
		Iterator<Dispatch_Record> itr=dispatch_record.iterator();
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("Dispatch_Record.bin"))) {
			//upload the Dispatch_Record data from list to DB
			while(itr.hasNext())
				oo.writeObject(itr.next());
			oo.writeObject(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static boolean download() { // Download Dispatch from DB with Student ID
		Dispatch_Record.dispatch_record.clear();
		
		try {
			FileInputStream fin = new FileInputStream("Dispatch_Record.bin");
			
			try {
				int c=fin.read();
				if (c== -1) {
					//System.out.println("FXXk");
					fin.close();
					return false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Dispatch_Record.bin"))) {
			// download the Dispatch_Record data from DB to list
			while (true) {
				Dispatch_Record mytemp = (Dispatch_Record) oi.readObject();
				if (mytemp == null)
					break;
				Dispatch_Record.dispatch_record.add(mytemp);
			}
			return true;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void show_info() {
		System.out.print("College_name: " + coll_name);		//print college name
		System.out.print("\tPeriod: " + period);			//print exchange student period
		System.out.println("\tMajor: " + major);				//print exchange student major
	}
}
