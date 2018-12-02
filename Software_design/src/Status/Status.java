package Status;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;

//Student package
import Bulletin.*;



public class Status {
	String stu_name;
	String stu_num;

	static int step; // Current application step

	int first_stat; // first application status
	int final_stat; // final application status
	int transfer_stat; // transfer_credit status
	Bulletin application; // application information
	LinkedList<Course> course;
	public static LinkedList<Status> status = new LinkedList<>();

	public Status(String name, String number, int stat1, int stat2, int stat3, Bulletin application) {
		this.stu_name = name;
		this.stu_num = number;
		first_stat = stat1;
		final_stat = stat2;
		transfer_stat = stat3;
		this.application = application;
	}
	
	public LinkedList<Course> getCourse(){
		return course;
	}
	public String getName()	{
		return this.stu_name;
	}
	public String getNumber(){
		return this.stu_num;
	}
	public int getStat1(){
		return this.first_stat;
	}
	public int getStat2(){
		return this.final_stat;
	}
	public int getStat3(){
		return this.transfer_stat;
	}

	public Bulletin getApplication() {		//getter of Bulletin
		return this.application;
	}
	public void setCourse(LinkedList<Course> c){
		this.course=c;
	}
	
	public void see_course() { // print course info 
		//it is available to see the courses when the step is 3;
		if (step == 3) {
			int count = -1;
			System.out.println("**********Course info***********");
			for(Course c: course)
			{
				System.out.print( ++count + ": ");
				System.out.println(c.getName());
			}
		} 
		else			//when the step is not in 3 , seeing courses is not available
			System.out.println("Not allowed to see courses\n" + "Check if the step is right");

	}

	public static void add_status_to_list(String name, String number, int stat1, int stat2, int stat3,
			Bulletin application) {// add status to list;
		
		//create status and insert to list;
		Status myStatus = new Status(name, number, 0, 0, 0, application);
		Status.status.add(myStatus);
	}

	public void show_first_applicant_info() {
		if(first_stat==1) {
			System.out.print("\tStudent name: " + stu_name);
			System.out.println("\t Student number: " + stu_num);
		}
	}
	public void show_final_applicant_info() {
		if(final_stat==1) {
			System.out.print("\tStudent name: " + stu_name);
			System.out.println("\t Student number: " + stu_num);
		}
	}
	public void show_transfercredit_applicant_info() {
		if(transfer_stat==1) {
			System.out.print("\tStudent name: " + stu_name);
			System.out.println("\t Student number: " + stu_num);
		}
	}
	public void show_info() { // print status
		System.out.print("Step: " + Status.step);
		System.out.print("\tFirst Stat: " + first_stat);
		System.out.print("\tSecond Stat: " + final_stat);
		System.out.println("\tTransfer Stat: " + transfer_stat);
		
		see_course();
	}

	public static boolean first_application_check() { // check if the step is in first application step
		if (step == 1)
			return true;
		return false;
	}

	public static boolean final_application_check() { // check if the step is in the final application step
		if (step == 2)
			return true;
		return false;
	}

	public static boolean transfer_credit_application_check() { // check if the step is in the transfer application step
		if (step == 3)
			return true;
		return false;
	}

	
	 public boolean first_modify(int i) { // set STEP -> 1
		 
		 this.first_stat = i;
		 return true;	  
	 } 
	 public boolean second_modify(int i) { // set STEP -> 2
		 
		 this.final_stat = i; // "sim-sa-jung"
		 return true;	  
	  } 
	 public boolean final_modify(int i) { // set STEP ->
		 this.transfer_stat = i;
		 return true;
	  }
	public static void upload() { // Upload status data to DB
		Iterator<Status> itr=status.iterator();
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("Status.bin"))) {
			//first status data is used to represent the step
			Status myStatus=new Status(null,null,Status.step,0,0,null);				
			oo.writeObject(myStatus);
			//upload the status data from list to DB
			while(itr.hasNext())
				oo.writeObject(itr.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void download() { // Download status from DB with Student ID
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Status.bin"))) {
			//first status data is used to represent the step
			Status.step = ((Status) oi.readObject()).first_stat;
			//download the status data from DB to list
			while (true) {
				if (oi.readObject() == null)
					break;
				Status.status.add((Status) oi.readObject());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void makeCourses() {
		int count=0,index=0;
		int i=0;
		SecureRandom sr=new SecureRandom();
		LinkedList<String> string=new LinkedList<>();
		try(BufferedReader fr=new BufferedReader(new FileReader("Courses.txt"))){
			while(true) {
			if(fr.readLine()==null)
				break;
			count++;
			string.add(fr.readLine());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		for(i=0;i<6;i++) {
			index=sr.nextInt()%count;
			course.add(new Course(string.get(index)));
		}
		
		
	}

}
