package Student;
//Student package
import Bulletin.Bulletin;
class Student{
	String stu_name;			//Student name
<<<<<<< HEAD
	String stu_number;			//Student_number

	public Student(String name, String num) {
		stu_name=name;
		stu_number=num;
	}
	
	public void see_cur_record() {			//search for student's current record
		
	}
	public boolean register_documnet() {	//¼­·ù µî·Ï
		
	}
	public boolean apply_transfercredit() {	//ÇÐÁ¡ ÀÎÁ¤ ½ÅÃ» 
		
	}
	public boolean cancel_apply() {			//½ÅÃ» Ãë¼Ò
		
	}
	public boolean see_appliable_record() {	//Áö¿ø °¡´ÉÇÑ °ø°í Á¶È¸
		
	}
	public void see_dispatch_record() {		//ÆÄ°ß ½ÌÀû Á¶È¸
		
	}
	public boolean apply_exchangestudent() {	//±³È¯ ÇÐ¼§ Áö¿ø ½ÅÃ»
		
	}
}

class Status{
	int step;					//½ÅÃ» ´Ü°è		
	int first_stat;			//1Â÷ »óÅÂ
	int final_stat;			//ÃÖÁ¾ »óÅÂ
	int transfer_stat;		//ÇÐÁ¡ ÀÎÁ¤ ½ÅÃ» »óÅÂ
	Bulletin application;		//Áö¿ø Á¤º¸
	String course;				//°­ÁÂ¸í
	public Status(int step,	int stat1, int stat2, int stat3, Bulletin application, String course) {
		this.step=step;
		first_stat=stat1;
		final_stat=stat2;
		transfer_stat=stat3;
		this.application=application;
		this.course=course;
	}
	
	public boolean see_course() {		//°­ÁÂ Á¶È¸
		
	}	
	public boolean add_record() {		//½ÇÀû ±â·Ï
		
	}
	public void show_info() {			//»óÅÂ Á¤º¸ Ãâ·Â
		
	}
	public boolean first_application_check() {	//±â°£ÀÌ 1Â÷°¡ ¸Â´Â Áö È®ÀÎ
		
	}	
	public boolean final_application_check() {	//±â°£ÀÌ 1Â÷°¡ ¸Â´Â Áö È®ÀÎ
		
	}
	public boolean transfer_credit_application_check() {	//±â°£ÀÌ 1Â÷°¡ ¸Â´Â Áö È®ÀÎ
	
	}
	public boolean first_modify() {			//ÇÐ»ýÀÇ 1Â÷ Áö¿ø »óÅÂ º¯°æ
		
	}
	public boolean second_modify() {			//ÇÐ»ýÀÇ ÃÖÁ¾ Áö¿ø »óÅÂ º¯°æ
		
	}
	public boolean final_modify() {			//ÇÐÁ¡ ÀÎÁ¤ ½ÅÃ» »óÅÂ º¯°æ
		
	}
	public boolean upload() {	//ÀÎ½ºÅÏ½º¸¦ DB¿¡ ÀúÀå
		
	}
	public Status download() {	//ÀÎ½ºÅÏ½º¸¦ DB¿¡¼­ °¡Á®¿Â´Ù.
		
	}
	public void print(){		//ÇöÀç »óÅÂ Ãâ·Â
		System.out.println("Step: " + step);
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}
class Document{
	String stu_num;			//ÇÐ»ý ÇÐ¹ø
	String stu_name;		//ÇÐ»ý ÀÌ¸§
	String col_name;		//½ÅÃ» ´ëÇÐ¸í
	String doc_type;		//¼­·ù ºÐ·ù
	public Document(String stu_num, String stu_name, String col_name, String doc_type) {
		this.stu_num=stu_num;
		this.stu_name=stu_name;
		this.col_name=col_name;
		this.doc_type=doc_type;
	}
}

class Major_course{
	String course_name;		//°­ÁÂ ÀÌ¸§
	boolean major;			//Àü°ø ¿©ºÎ
	char score;				//¼ºÀû
	
	public Major_course(String name, boolean major, char score) {
		course_name=name;
		this.major=major;
		this.score=score;
		
	}
}
=======

	String stu_number;			//Student_number
  String stu_number;			//Student number


	public Student(String name, String num) {
		stu_name=name;
		stu_number=num;
	}
	

	public void see_cur_record() {			//í˜„ìž¬ ìƒíƒœ ì¡°íšŒ
	

	public void see_cur_record() {			//search for student's current record
		

	}
	public boolean register_documnet() {	//ì„œë¥˜ ë“±ë¡
		
	}
	public boolean apply_transfercredit() {	//í•™ì  ì¸ì • ì‹ ì²­ 
		
	}
	public boolean cancel_apply() {			//ì‹ ì²­ ì·¨ì†Œ
		
	}
	public boolean see_appliable_record() {	//ì§€ì› ê°€ëŠ¥í•œ ê³µê³  ì¡°íšŒ
		
	}
	public void see_dispatch_record() {		//íŒŒê²¬ ì‹±ì  ì¡°íšŒ
		
	}
	public boolean apply_exchangestudent() {	//êµí™˜ í•™ìƒ¹ ì§€ì› ì‹ ì²­
		
	}
}

class Status{
	int step;					//ì‹ ì²­ ë‹¨ê³„		
	int first_stat;			//1ì°¨ ìƒíƒœ
	int final_stat;			//ìµœì¢… ìƒíƒœ
	int transfer_stat;		//í•™ì  ì¸ì • ì‹ ì²­ ìƒíƒœ
	Bulletin application;		//ì§€ì› ì •ë³´
	String course;				//ê°•ì¢Œëª…
	public Status(int step,	int stat1, int stat2, int stat3, Bulletin application, String course) {
		this.step=step;
		first_stat=stat1;
		final_stat=stat2;
		transfer_stat=stat3;
		this.application=application;
		this.course=course;
	}
	
	public boolean see_course() {		//ê°•ì¢Œ ì¡°íšŒ
		
	}	
	public boolean add_record() {		//ì‹¤ì  ê¸°ë¡
		
	}
	public void show_info() {			//ìƒíƒœ ì •ë³´ ì¶œë ¥
		
	}
	public boolean first_application_check() {	//ê¸°ê°„ì´ 1ì°¨ê°€ ë§žëŠ” ì§€ í™•ì¸
		
	}	
	public boolean final_application_check() {	//ê¸°ê°„ì´ 1ì°¨ê°€ ë§žëŠ” ì§€ í™•ì¸
		
	}
	public boolean transfer_credit_application_check() {	//ê¸°ê°„ì´ 1ì°¨ê°€ ë§žëŠ” ì§€ í™•ì¸
	
	}
	public boolean first_modify() {			//í•™ìƒì˜ 1ì°¨ ì§€ì› ìƒíƒœ ë³€ê²½
		
	}
	public boolean second_modify() {			//í•™ìƒì˜ ìµœì¢… ì§€ì› ìƒíƒœ ë³€ê²½
		
	}
	public boolean final_modify() {			//í•™ì  ì¸ì • ì‹ ì²­ ìƒíƒœ ë³€ê²½
		
	}
	public boolean upload() {	//ì¸ìŠ¤í„´ìŠ¤ë¥¼ DBì— ì €ìž¥
		
	}
	public Status download() {	//ì¸ìŠ¤í„´ìŠ¤ë¥¼ DBì—ì„œ ê°€ì ¸ì˜¨ë‹¤.
		
	}
	public void print(){		//í˜„ìž¬ ìƒíƒœ ì¶œë ¥
		System.out.println("Step: " + step);
		System.out.println("First Stat: " + first_stat);
		System.out.println("Second Stat: " + final_stat);
		System.out.println("Transfer Stat: " + transfer_stat);

	}
	
	
}
class Document{
	String stu_num;			//í•™ìƒ í•™ë²ˆ
	String stu_name;		//í•™ìƒ ì´ë¦„
	String col_name;		//ì‹ ì²­ ëŒ€í•™ëª…
	String doc_type;		//ì„œë¥˜ ë¶„ë¥˜
	public Document(String stu_num, String stu_name, String col_name, String doc_type) {
		this.stu_num=stu_num;
		this.stu_name=stu_name;
		this.col_name=col_name;
		this.doc_type=doc_type;
	}
}

class Major_course{
	String course_name;		//ê°•ì¢Œ ì´ë¦„
	boolean major;			//ì „ê³µ ì—¬ë¶€
	char score;				//ì„±ì 
	
	public Major_course(String name, boolean major, char score) {
		course_name=name;
		this.major=major;
		this.score=score;
		
	}
}
>>>>>>> b025b949b772ab0885affff81cc2757e40669304
