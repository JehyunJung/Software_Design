package Status;

import java.security.SecureRandom;
public class Course {
	String Course_name; // course name
	boolean major_stat; // if the student ask for approval for major then this value becomes 1
	boolean major; // if the course is related to major , then this value becomes 1
	char score; // studens's course score

	public Course(String name) {
		this.Course_name=name;
		int rnum;
		SecureRandom raf=new SecureRandom();
		rnum=raf.nextInt()%100;
		
		if(rnum>70)
			this.score='A';
		else if(rnum>60)
			this.score='B';
		else if(rnum>50)
			this.score='C';
		else if(rnum>40)
			this.score='D';
		else
			this.score='F';
		this.major_stat=false;
		this.major=false;
		
	}
	public String getName() {
		return Course_name;
	}
	public boolean get_major_stat() {
		return this.major_stat;
	}

	public boolean get_major() {
		return this.major;
	}

	public void set_major(boolean b) {
		major=b;
	}

	public void set_major_stat(boolean b) {
		major_stat = b;
	}
	public void see_applied_course() {
		if(this.major_stat && !this.major)
			System.out.println("Course_name: " + Course_name);
	}	
}
