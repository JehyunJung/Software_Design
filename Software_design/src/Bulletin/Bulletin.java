package Bulletin;
// Bulletin package
public class Bulletin{
	String col_name;			//college name
	String req_score;				//required score
	String country;				//country
	String period;				//exchange student period
	String major;				//exchange student major
	public Bulletin(String name, String score, String country, String period, String major) {
		col_name=name;
		req_score=score;
		this.country=country;
		this.period=period;
		this.major=major;
		
	}
}
class Appliable_Bul{
	String col_name;			//college name
	char req_score;				//score requirement
}
class Dispatch_Record{
	String stu_name;			//student name
	String col_name;			//college name
	String period;				//exchange student period
	String major;				//exchange student major
	
	public Dispatch_Record(String s_name, String c_name, String period, String major) {
		stu_name=s_name;
		col_name=c_name;
		this.period=period;
		this.major=major;
	}
	public void sort() {
		
	}
	public void show_info() {
		System.out.println("�л� �̸�: " + stu_name);		//print student name
		System.out.println("���и�: " + col_name);		//print college name
		System.out.println("�Ⱓ: " + period);			//print exchange student period
		System.out.println("����: " + major);				//print exchange student major
	}
}
