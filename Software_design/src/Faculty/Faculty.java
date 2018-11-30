package Faculty;
// package
class Manager{		//교직원 class
	String man_name;	//교직원 이름
	public Manager(String name) {
		man_name=name;
	}
	
	public void add_bull() {		//공고 게시
		
	}
	public void del_bull() {		//공고 취소
		
	}
	public boolean add_first_rec() {		//1차 결과 기록
		
	}
	public boolean add_final_record() {		//최종 결과 기록
		
	}
	public boolean add_transfercredit_apply_record() {		//학점 인정 결과 기록
		
	}
	public boolean see_first_applicant() {	//1차 신청자 조회
		
	}
	public boolean see_final_applicant() {	//최종 신청자 조회
		
	}
	public  boolean see_transfercredit_applicant() {	//학점 인정 신청자 조회
		
	}
	public boolean see_doc() {		//서류 조회
		
	}
	public boolean see_dispatch_rec() {	//파견 실적 조회
		
	}
	
}

class Head_Of_Department{
	String dep_name;			//해당 학과 이름
	public Head_Of_Department(String name) {
		dep_name=name;
	}
	
	public boolean see_transfercredit_applicant() {		//학점 인정자 신청자 조회
		
	}
	public boolean approve_major() {		//전공 승인
		
	}
}