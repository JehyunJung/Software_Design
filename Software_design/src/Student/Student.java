package Student;
//�л� package
import Bulletin.Bulletin;
class Student{
	String stu_name;			//�л� �̸�
	String stu_number;			//�й�
	public Student(String name, String num) {
		stu_name=name;
		stu_number=num;
	}
	
	public void see_cur_record() {			//���� ���� ��ȸ
		
	}
	public boolean register_documnet() {	//���� ���
		
	}
	public boolean apply_transfercredit() {	//���� ���� ��û 
		
	}
	public boolean cancel_apply() {			//��û ���
		
	}
	public boolean see_appliable_record() {	//���� ������ ���� ��ȸ
		
	}
	public void see_dispatch_record() {		//�İ� ���� ��ȸ
		
	}
	public boolean apply_exchangestudent() {	//��ȯ �м� ���� ��û
		
	}
}

class Status{
	int step;					//��û �ܰ�		
	int first_stat;			//1�� ����
	int final_stat;			//���� ����
	int transfer_stat;		//���� ���� ��û ����
	Bulletin application;		//���� ����
	String course;				//���¸�
	public Status(int step,	int stat1, int stat2, int stat3, Bulletin application, String course) {
		this.step=step;
		first_stat=stat1;
		final_stat=stat2;
		transfer_stat=stat3;
		this.application=application;
		this.course=course;
	}
	
	public boolean see_course() {		//���� ��ȸ
		
	}	
	public boolean add_record() {		//���� ���
		
	}
	public void show_info() {			//���� ���� ���
		
	}
	public boolean first_application_check() {	//�Ⱓ�� 1���� �´� �� Ȯ��
		
	}	
	public boolean final_application_check() {	//�Ⱓ�� 1���� �´� �� Ȯ��
		
	}
	public boolean transfer_credit_application_check() {	//�Ⱓ�� 1���� �´� �� Ȯ��
	
	}
	public boolean first_modify() {			//�л��� 1�� ���� ���� ����
		
	}
	public boolean second_modify() {			//�л��� ���� ���� ���� ����
		
	}
	public boolean final_modify() {			//���� ���� ��û ���� ����
		
	}
	public boolean upload() {	//�ν��Ͻ��� DB�� ����
		
	}
	public Status download() {	//�ν��Ͻ��� DB���� �����´�.
		
	}
	public void print(){		//���� ���� ���
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}
class Document{
	String stu_num;			//�л� �й�
	String stu_name;		//�л� �̸�
	String col_name;		//��û ���и�
	String doc_type;		//���� �з�
	public Document(String stu_num, String stu_name, String col_name, String doc_type) {
		this.stu_num=stu_num;
		this.stu_name=stu_name;
		this.col_name=col_name;
		this.doc_type=doc_type;
	}
}

class Major_course{
	String course_name;		//���� �̸�
	boolean major;			//���� ����
	char score;				//����
	
	public Major_course(String name, boolean major, char score) {
		course_name=name;
		this.major=major;
		this.score=score;
		
	}
}