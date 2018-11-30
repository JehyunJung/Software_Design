package Student;
//Student package
import Bulletin.Bulletin;
class Student{
	String stu_name;			//Student name
	String stu_number;			//Student_number

	public Student(String name, String num) {
		stu_name=name;
		stu_number=num;
	}
	public void see_cur_record() {			//search for student's current status
	}
	public boolean register_document() {	//register document
		
	}
	public boolean apply_transfercredits() {	// apply for transfer credit
		
	}
	public boolean cancel_apply() {			//canceling application
		
	}
	public boolean firstapply() {	//print appliable Bulletin and apply
		
	}
	public void see_dispatch_record() {		//see dispatch record
		
	}
	public boolean finalapply() {	 // final application
	}
}

class Course {
	String Course_name;			//course name
	boolean major;				// if the course is related to major , then this value becomes 1
	char score;					//studens's course score
	boolean applied_info; 		//if the student is trying to apply for transfer credit , this value becomes 1
}

class Status{
	int step;					//Current application step
	int first_stat;				//first application status
	int final_stat;				//final application status
	int transfer_stat;			//transfer_credit status
	Bulletin application;		//application information
	Course course[];				//Course info
	public Status(int step,	int stat1, int stat2, int stat3, Bulletin application, String course) {
		this.step=step;
		first_stat=stat1;
		final_stat=stat2;
		transfer_stat=stat3;
		this.application=application;
		this.course=course;
	}
	
	public boolean see_course() {		//print course info
		
	}	
	public boolean add_record() {		//
		
	}
	public void show_info() {			//�긽�깭 �젙蹂� 異쒕젰
		
	}
	public boolean first_application_check() {	//湲곌컙�씠 1李④� 留욌뒗 吏� �솗�씤
		
	}	
	public boolean final_application_check() {	//湲곌컙�씠 1李④� 留욌뒗 吏� �솗�씤
		
	}
	public boolean transfer_credit_application_check() {	//湲곌컙�씠 1李④� 留욌뒗 吏� �솗�씤
	
	}
	public boolean first_modify() {			//�븰�깮�쓽 1李� 吏��썝 �긽�깭 蹂�寃�
		
	}
	public boolean second_modify() {			//�븰�깮�쓽 理쒖쥌 吏��썝 �긽�깭 蹂�寃�
		
	}
	public boolean final_modify() {			//�븰�젏 �씤�젙 �떊泥� �긽�깭 蹂�寃�
		
	}
	public boolean upload() {	//�씤�뒪�꽩�뒪瑜� DB�뿉 ���옣
		
	}
	public Status download() {	//�씤�뒪�꽩�뒪瑜� DB�뿉�꽌 媛��졇�삩�떎.
		
	}
	public void print(){		//�쁽�옱 �긽�깭 異쒕젰
		System.out.println("Step: " + step);
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}
class Document{
	String stu_num;			//�븰�깮 �븰踰�
	String stu_name;		//�븰�깮 �씠由�
	String col_name;		//�떊泥� ���븰紐�
	String doc_type;		//�꽌瑜� 遺꾨쪟
	public Document(String stu_num, String stu_name, String col_name, String doc_type) {
		this.stu_num=stu_num;
		this.stu_name=stu_name;
		this.col_name=col_name;
		this.doc_type=doc_type;
	}
}

class Major_course{
	Course course;
	
	public Major_course(String name, boolean major, char score) {
		course.Course_name=name;
		course.major=major;
		course.score=score;
		
	}
}
