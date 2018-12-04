package Status;

import java.io.Serializable;

public class Document implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String stu_num;			// student ID num
	String stu_name;		// student name
	String coll_name;		// college name
	String doc_type;		// document type
	public static int count=0;

	public Document(String stu_num, String stu_name, String col_name, String doc_type) {
		this.stu_num=stu_num;
		this.stu_name=stu_name;
		this.coll_name=col_name;
		this.doc_type=doc_type;
	}
	public void show_info() {
		System.out.print("Student num: " + stu_num);
		System.out.print("\tStudent name: " + stu_name);
		System.out.print("\tCollege name: " + coll_name);
		System.out.println("\tDocument type: " + doc_type);
	}
}
