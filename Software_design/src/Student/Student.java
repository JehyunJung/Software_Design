package Student;
//학생 package
import Bulletin.Bulletin;
class Student{
	String stu_name;			//학생 이름
	String stu_number;			//학번
	public Student(String name, String num) {
		stu_name=name;
		stu_number=num;
	}
	
	public void see_cur_record() {			//현재 상태 조회
		
	}
	public boolean register_documnet() {	//서류 등록
		
	}
	public boolean apply_transfercredit() {	//학점 인정 신청 
		
	}
	public boolean cancel_apply() {			//신청 취소
		
	}
	public boolean see_appliable_record() {	//지원 가능한 공고 조회
		
	}
	public void see_dispatch_record() {		//파견 싱적 조회
		
	}
	public boolean apply_exchangestudent() {	//교환 학샹 지원 신청
		
	}
}

class Status{
	int step;					//신청 단계		
	int first_stat;			//1차 상태
	int final_stat;			//최종 상태
	int transfer_stat;		//학점 인정 신청 상태
	Bulletin application;		//지원 정보
	String course;				//강좌명
	public Status(int step,	int stat1, int stat2, int stat3, Bulletin application, String course) {
		this.step=step;
		first_stat=stat1;
		final_stat=stat2;
		transfer_stat=stat3;
		this.application=application;
		this.course=course;
	}
	
	public boolean see_course() {		//강좌 조회
		
	}	
	public boolean add_record() {		//실적 기록
		
	}
	public void show_info() {			//상태 정보 출력
		
	}
	public boolean first_application_check() {	//기간이 1차가 맞는 지 확인
		
	}	
	public boolean final_application_check() {	//기간이 1차가 맞는 지 확인
		
	}
	public boolean transfer_credit_application_check() {	//기간이 1차가 맞는 지 확인
	
	}
	public boolean first_modify() {			//학생의 1차 지원 상태 변경
		
	}
	public boolean second_modify() {			//학생의 최종 지원 상태 변경
		
	}
	public boolean final_modify() {			//학점 인정 신청 상태 변경
		
	}
	public boolean upload() {	//인스턴스를 DB에 저장
		
	}
	public Status download() {	//인스턴스를 DB에서 가져온다.
		
	}
	public void print(){		//현재 상태 출력
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}
class Document{
	String stu_num;			//학생 학번
	String stu_name;		//학생 이름
	String col_name;		//신청 대학명
	String doc_type;		//서류 분류
	public Document(String stu_num, String stu_name, String col_name, String doc_type) {
		this.stu_num=stu_num;
		this.stu_name=stu_name;
		this.col_name=col_name;
		this.doc_type=doc_type;
	}
}

class Major_course{
	String course_name;		//강좌 이름
	boolean major;			//전공 여부
	char score;				//성적
	
	public Major_course(String name, boolean major, char score) {
		course_name=name;
		this.major=major;
		this.score=score;
		
	}
}