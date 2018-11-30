package Status;
//Student package
import Bulletin.*;
import Person.*;


public class Status{
	int step;					//Current application step
	int first_stat;				//first application status
	int final_stat;				//final application status
	int transfer_stat;			//transfer_credit status
	Bulletin application;		//application information
	Course course;				//Course info
	public Status(int step,	int stat1, int stat2, int stat3, Bulletin application, Course course) {
		this.step=step;
		first_stat=stat1;
		final_stat=stat2;
		transfer_stat=stat3;
		this.application=application;
		this.course=course;
	}
	
	public boolean see_course() {		//print course info
		
	}	
	public boolean add_record() {		//add record status
		
	}
	public void show_info() {			//print status
		
	}
	public boolean first_application_check() {	//check if the step is in first application step
		
	}	
	public boolean final_application_check() {	//check if the step is in the final application step
		
	}
	public boolean transfer_credit_application_check() {	//check if the step is in the transfer application step
	
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
	public void print(){		//�쁽�옱 �긽�깭 ?��?��?��
		System.out.println("Step: " + step);
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}

