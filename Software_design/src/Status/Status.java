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
	public boolean add_record() {		//
		
	}
	public void show_info() {			//�긽�깭 �젙蹂� ?��?��?��
		
	}
	public boolean first_application_check() {	//湲곌컙�?�� 1李④�? 留욌?�� 吏� �솗�씤
		
	}	
	public boolean final_application_check() {	//湲곌컙�?�� 1李④�? 留욌?�� 吏� �솗�씤
		
	}
	public boolean transfer_credit_application_check() {	//湲곌컙�?�� 1李④�? 留욌?�� 吏� �솗�씤
	
	}
	public boolean first_modify() {			//�븰�깮�쓽 1李� 吏��썝 �긽�깭 蹂�寃�
		
	}
	public boolean second_modify() {			//�븰�깮�쓽 理쒖�? 吏��썝 �긽�깭 蹂�寃�
		
	}
	public boolean final_modify() {			//�븰�젏 �씤�젙 �떊泥� �긽�깭 蹂�寃�
		
	}
	public boolean upload() {	//�씤�뒪�꽩�뒪?���? DB�뿉 ���옣
		
	}
	public Status download() {	//�씤�뒪�꽩�뒪?���? DB�뿉�꽌 媛��졇�삩�떎.
		
	}
	public void print(){		//�쁽�옱 �긽�깭 ?��?��?��
		System.out.println("Step: " + step);
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}

