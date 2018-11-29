package Bulletin;
// Bulletin package
public class Bulletin{
	String col_name;			//college name
	char req_score;				//required score
	String country;				//country
	String period;				//exchange student period
	String major;				//exchange student major
	public Bulletin(String name, char score, String country, String period, String major) {
		col_name=name;
		req_score=score;
		this.country=country;
		this.period=period;
		this.major=major;
		
	}
}
class Appliable_Bul{
	dsdsdsd
	String col_name;			//대학명
	char req_score;				//요구 성적
}
class Dispatch_Record{
	String stu_name;			//학생 이름	
	String col_name;			//대학 이름
	String period;				//교환학생 기간
	String major;				//전공(어떤 전공)
	
	public Dispatch_Record(String s_name, String c_name, String period, String major) {
		stu_name=s_name;
		col_name=c_name;
		this.period=period;
		this.major=major;
	}
	public void sort() {
		
	}
	public void show_info() {
		System.out.println("학생 이름: " + stu_name);		//학생 이름 출력
		System.out.println("대학명: " + col_name);		//해당 국가 출력
		System.out.println("기간: " + period);			//기간 출력
		System.out.println("전공: " + major);				//전공 출력
	}
}
