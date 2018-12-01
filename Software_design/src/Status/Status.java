package Status;
import java.util.List;
import java.util.LinkedList;

//Student package
import Bulletin.*;
import Person.*;


public class Status{
	String name;
	String number;
	
	static int step;			//Current application step
	int first_stat;				//first application status
	int final_stat;				//final application status
	int transfer_stat;			//transfer_credit status
	Bulletin application;		//application information
	List<Course> course;
	public Status(String name, String number,int stat1, int stat2, int stat3, Bulletin application,List<Course> course) {
		this.name = name;
		this.number =number;
		first_stat=stat1;
		final_stat=stat2;
		transfer_stat=stat3;
		this.application=application;
		this.course=course;			//uploading course list to DB required
		
	}
	
	public boolean see_course() {		//print course info
		
	}	
	public boolean add_record() {		//add record status
		
	}
	public void show_info() {			//print status
		
	}
	public static boolean first_application_check() {	//check if the step is in first application step
		if(step == 1)
			return true;
		
		return false;
	}	
	public static boolean final_application_check() {	//check if the step is in the final application step
		if(step == 2)
			return true;
		
		return false;
	}
	public static boolean transfer_credit_application_check() {	//check if the step is in the transfer application step
		if(step == 3)
			return true;
		
		return false;
	}
	public boolean first_modify() {			// set STEP -> 
		
	}
	public boolean second_modify() {		// set STEP -> 
		
	}
	public boolean final_modify() {			// set STEP -> 
		
	}
	public boolean upload() {	// Upload status data to DB
		
	}
	public Status download() {	// Download status from DB with Student ID
		
	}
	public void print(){		// print all
		System.out.println("Step: " + step);
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}

