package Application;

import java.util.LinkedList;
import java.util.Scanner;
import Person.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Information_class implements Serializable{
	private static final long serialVersionUID = 1L;
	String ID;
	String PW;
	int type;
	String name;
	String num;
	String score;

	public Information_class(String ID, String PW, int type, String name, String num, String score) {
		this.ID = ID;
		this.PW = PW;
		this.type = type;
		this.name = name;
		this.num = num;
		this.score = score;
	}
	public void show_info() {
		System.out.println(ID);
		System.out.println(PW);
		System.out.println(type);
		System.out.println(name);
		System.out.println(num);
		System.out.println(score);
	}
}
public class Application {
	public static void main(String[] args) {
		System.out.println("**********Login Section***********");
		login();
		
		
		//makeCOURSEDB();
		//makeLOGINDB();
		//makeSTATUSDB();
	}
	public static void makeSTATUSDB() {
		try(ObjectOutputStream oo= new ObjectOutputStream(new FileOutputStream("STATUS.bin"))) {
				oo.writeObject(null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void makeCOURSEDB() {
	      LinkedList<String/* classTYPE */> list = new LinkedList<>();

	      /* class Fields */
	      String corName;
	      /* class Fields */

	      Scanner sc = new Scanner(System.in);
	      File file = new File("COURSE.bin");
	      FileWriter fw=null;
		try {
			fw = new FileWriter(file,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	         while (true) {
	            /* input data */
	            System.out.print(" INPUT REGISETER COURSE NAME  : ");
	            corName = sc.nextLine();
	            if (corName.equals("quit"))
	               break;

	            /* add to list */
	            list.add(corName);
	         }
	         /* write to file */
	         for (String b : list) {
	            try {
					fw.write(b);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
	      

	      sc.close();
	   }
	
	public static void makeLOGINDB()
	{
	   LinkedList<Information_class/*classTYPE*/> list = new LinkedList<>();
	   
	   /*class Fields*/
	   String ID;
	   String PW;
	   int type;
	   String name;
	   String num;
	   String score;
	   /*class Fields*/
	   
	   Scanner sc = new Scanner(System.in);

	   try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("LOGIN.bin"/*filename*/))) {
	      // first status data is used to represent the step

	      while (true) {
	         /*input data*/
	         System.out.print(" INPUT REGISETER ID    : ");
	         ID = sc.nextLine();
	         if (ID.equals("quit"))         break;
	         System.out.print(" INPUT REGISETER PSWRD : ");
	         PW = sc.nextLine();
	         System.out.print(" INPUT REGISETER TYPE  : ");
	         type = sc.nextInt();         
	         sc.nextLine();
	         System.out.print(" INPUT REGISETER NAME  : ");
	         name = sc.nextLine();         
	         System.out.print(" INPUT REGISETER NUM   : ");
	         num = sc.nextLine();
	         System.out.print(" INPUT REGISETER SCORE : ");
	         score = sc.nextLine();
	         
	         
	         /*add to list*/
	         Information_class temp = new Information_class(ID, PW, type, name, num, score);
	         list.add(temp);
	      }
	      /*write to file*/
	      for(Information_class b : list){
	         oo.writeObject(b);
	      }
	      oo.writeObject(null);
	   } 
	   catch (IOException e) {
	      e.printStackTrace();
	   }
	   
	   sc.close();
	}
	
	public static void login() {
		String ID, PW;
		boolean find_flag = false;
		boolean logout_flag=false;
		int count=0;
		Scanner sc=new Scanner(System.in);
		while (true) {
	
			System.out.println("If you want to quit login insert 'quit'");
			System.out.println("Input ID : ");
			ID = sc.next();
			if (ID.equals("quit")) {
				sc.close();
				System.out.println("System off~");
				return;
			}

			System.out.println("Input PW : ");
			PW = sc.next();
			if (PW.equals("quit")) {
				sc.close();
				System.out.println("System off~");
				return;
			}

			logout_flag=false;
			find_flag = false;
			try (ObjectInputStream oi = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("LOGIN.bin")))) {

				while (true) {
					Information_class info = (Information_class) oi.readObject();
					if (info == null) {
						if(count==0)
							return;
						break;
					}
					count++;

					if (ID.equals(info.ID)) {
						if (PW.equals(info.PW)) {
							System.out.println("Login successed");
							find_flag = true;
							switch (info.type) {
							case 0:
								Student student = new Student(info.name, info.num, info.score);
								if(student.student_option())
									logout_flag=true;
								break;
							case 1:
								Manager manager = new Manager(info.name, info.num);
								if(manager.manager_option())
									logout_flag=true;
								break;
							case 2:
								Head_Of_Department head = new Head_Of_Department(info.name, info.num);
								if(head.head_option())
									logout_flag=true;
								break;
							}
						} else {
							System.out.println("Password is wrong\n");
							break;
						}
					}
					continue;
				}
				if (find_flag == false) {
					System.out.println("ID doesn't exists");
					continue;
				}
				if(find_flag==true && logout_flag==true) {
					System.out.println("You pressed logout");
					continue;
				}
			}

			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
