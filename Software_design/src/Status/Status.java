package Status;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;

//Student package
import Bulletin.*;



public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String stu_name;
	String stu_num;

	public static int step; // Current application step

	int first_stat; // first application status
	int final_stat; // final application status
	int transfer_stat; // transfer_credit status
	Bulletin application; // application information
	
	LinkedList<Course> course;
	LinkedList<Document> document;
	
	public static LinkedList<Status> status = new LinkedList<>();

	public Status(String name, String number, int stat1, int stat2, int stat3, Bulletin application) {
		this.stu_name = name;
		this.stu_num = number;
		first_stat = stat1;
		final_stat = stat2;
		transfer_stat = stat3;

		this.application = application;
		course=new LinkedList<Course>();
		document= new LinkedList<Document>();
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
	public void setDocument(LinkedList<Document> d) {
		this.document=d;
	}
	public void addDocument(Document d) {
		document.add(d);
	}
	public LinkedList<Document> getDocument() {
		return document;
	}
	
	public void see_course() { // print course info 
		//it is available to see the courses when the step is 3;
		if (step >= 3) {
			int count = -1;
			System.out.println("**********Course info***********");
			for(Course c: course)
			{
				System.out.print( ++count + ": ");
				System.out.print(c.getName());
				System.out.print("\tmajor stat: " + c.get_major_stat());
				System.out.print("\tmajor: " + c.get_major());
				System.out.println("\tScore: " + c.get_Score());
			}
		} 
		else			//when the step is not in 3 , seeing courses is not available
			System.out.println("Not allowed to see courses\n" + "Check if the step is right");

	}

	public static void add_status_to_list(String name, String number, int stat1, int stat2, int stat3,
			Bulletin application) {// add status to list;
		if(Status.download() == false) {
			System.out.println("Status not found ");
			return;
		}		//create status and insert to list;
		Status myStatus = new Status(name, number, stat1, stat2, stat3, application);
		System.out.println(application.get_bull_name());
		
		Status.status.add(myStatus);
		Status.upload();
	}

	public void show_first_applicant_info() {
		if(first_stat==1 || first_stat==3) {
			System.out.print("\tStudent name: " + stu_name);
			System.out.println("\t Student number: " + stu_num);
			for(Document d:document)
				d.show_info();
			first_stat=3;
		}
	}
	public void show_final_applicant_info() {
		if(final_stat==1 || final_stat==3) {
			System.out.print("\tStudent name: " + stu_name);
			System.out.println("\t Student number: " + stu_num);
			final_stat=3;
		}
	}
	public void show_transfercredit_applicant_info() {
		if(transfer_stat==1 || transfer_stat==3) {
			System.out.print("\tStudent name: " + stu_name);
			System.out.println("\t Student number: " + stu_num);
			transfer_stat=3;
		}
		transfer_stat=3;
	}
	
	public void show_info() { // print status
		if(first_stat==3 || final_stat==3 || transfer_stat==3) {
			System.out.println("You have failed to exchange school program... SORRY~~");
			return;
		}
		System.out.print("Step: " + Status.step);
		System.out.print("\tFirst Stat: " + first_stat);
		System.out.print("\tSecond Stat: " + final_stat);
		System.out.println("\tTransfer Stat: " + transfer_stat);
		System.out.println(application.get_bull_name());
		
		see_course();
	}

	public static boolean first_application_check() { // check if the step is in first application step
		System.out.println("STATUS ( STEP : " + Status.step + ")" );
		if (step == 1)
			return true;
		return false;
	}

	public static boolean final_application_check() { // check if the step is in the final application step
		System.out.println("STATUS ( STEP : " + Status.step + ")" );
		if (step == 2)
			return true;
		return false;
	}

	public static boolean transfer_credit_application_check() { // check if the step is in the transfer application step
		System.out.println("STATUS ( STEP : " + Status.step + ")" );
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
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("STATUS.bin"))) {
			//first status data is used to represent the step
			Status myStatus=new Status(null,null,Status.step,0,0,null);				
			oo.writeObject(myStatus);
			System.out.println("STATUS DOWNLOADED ( STEP : " + Status.step + ")" );
			//upload the status data from list to DB
			while(itr.hasNext())
				oo.writeObject(itr.next());
			oo.writeObject(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean download() { // Download status from DB with Student ID
		Status.status.clear();
		Status temp;
		int count=0;

		try {
			FileInputStream fin = new FileInputStream("STATUS.bin");
			
			try {
				int c=fin.read();
				if (c == -1) {
					//System.out.println("FXXk");
					fin.close();
					System.out.println("there is no reading things");
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
		
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("STATUS.bin"))) {
			//first status data is used to represent the step
			temp = (Status)oi.readObject();		
			if(temp==null) {
				if(count==0) {
					System.out.println("there is no reading things2");
					return false;
				}
				return true;
			}
			count++;
			Status.step = (int)temp.first_stat;
			System.out.println("STATUS DOWNLOADED ( STEP : " + Status.step + ")" );
			//download the status data from DB to list
			while (true) {
				Status mytemp=(Status)oi.readObject();
				if (mytemp == null) {
					System.out.println("Status.bin has reached EOF");
					break;
				}
					
				Status.status.add(mytemp);
			}
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("io Excep1");
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("classNotFound Excep1");
			return false;
		}
	}
	
	public void makeCourses() {
		int count=0,index=0;
		int course_Count=0;
		int i=0;
		String temp;
		boolean find_flag=false;
		SecureRandom sr=new SecureRandom();
		LinkedList<String> string=new LinkedList<>();
		try(BufferedReader fr=new BufferedReader(new FileReader("COURSE.txt"))){
			while(true) {
			temp = fr.readLine();
			if(temp == null)
				break;
			count++;
			string.add(temp);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		for(String s : string) {
	
			System.out.println(++i + ". " + s);
		}
		System.out.println("Count: " + count);
		while(true) {
			if(course_Count==6)
				break;
			index = Math.abs(sr.nextInt()) % count;
			System.out.println("INDEX : " + index);
			find_flag=false;
			for(Course c:course) {
				if(c.getName().equals(string.get(index))) {
					find_flag=true;
					break;
				}
					
			}
			if(find_flag!=true) {
				course_Count++;
				course.add(new Course(string.get(index)));
			}
		}
		
	}

}
