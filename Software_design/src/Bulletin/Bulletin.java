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
	String col_name;			//���и�
	char req_score;				//�䱸 ����
}
class Dispatch_Record{
	String stu_name;			//�л� �̸�	
	String col_name;			//���� �̸�
	String period;				//��ȯ�л� �Ⱓ
	String major;				//����(� ����)
	
	public Dispatch_Record(String s_name, String c_name, String period, String major) {
		stu_name=s_name;
		col_name=c_name;
		this.period=period;
		this.major=major;
	}
	public void sort() {
		
	}
	public void show_info() {
		System.out.println("�л� �̸�: " + stu_name);		//�л� �̸� ���
		System.out.println("���и�: " + col_name);		//�ش� ���� ���
		System.out.println("�Ⱓ: " + period);			//�Ⱓ ���
		System.out.println("����: " + major);				//���� ���
	}
}
