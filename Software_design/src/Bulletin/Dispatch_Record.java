package Bulletin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class Dispatch_Record{
	String stu_name;			//student name
	String col_name;			//college name
	String period;				//exchange student period
	String major;				//exchange student major
	public static LinkedList<Dispatch_Record> dispatch_record=new LinkedList<>();	//Linkedlist of Dispatch
	public Dispatch_Record(String s_name, String c_name, String period, String major) {
		stu_name=s_name;
		col_name=c_name;
		this.period=period;
		this.major=major;
	}

	// add bulletin to list;
	public static void add_Dispatch_to_list(String name, String score, String period, String major){
		//create Bulletin and insert to list;
		Dispatch_Record myDispatch = new Dispatch_Record(name, score,period,major);
		dispatch_record.add(myDispatch);
	}
	
	
	
	
	public static void upload() { // Upload Dispatch data to DB
		Iterator<Dispatch_Record> itr=dispatch_record.iterator();
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("Dispatch_Record.bin"))) {
			//upload the Dispatch_Record data from list to DB
			while(itr.hasNext())
				oo.writeObject(itr.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void download() { // Download Dispatch from DB with Student ID
		Iterator<Dispatch_Record> itr=dispatch_record.iterator();
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Dispatch_Record.bin"))) {
			//download the Dispatch_Record data from DB to list
			while (true) {
				if (oi.readObject() == null)
					break;
				Dispatch_Record.dispatch_record.add(itr.next());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void show_info() {
		System.out.print("Student_name: " + stu_name);		//print student name
		System.out.print("\tCollege_name: " + col_name);		//print college name
		System.out.print("\tPeriod: " + period);			//print exchange student period
		System.out.println("\tMajor: " + major);				//print exchange student major
	}
}
