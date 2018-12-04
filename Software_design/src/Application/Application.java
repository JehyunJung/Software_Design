package Application;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Bulletin.Bulletin;
import Person.*;
import Status.Status;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
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
		//makeCOURSE_DB();
		//makeLOGIN_DB();
		//setSTATUS_DB();
		//setBULLETIN_DB();
		//setDISPATCH_RECORD_DB();
	}
	public static void setSTATUS_DB() {
		try(ObjectOutputStream oo= new ObjectOutputStream(new FileOutputStream("STATUS.bin"))) {
				oo.writeObject(new Status(null, null, 5, 0, 0, null));
				oo.writeObject(null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setBULLETIN_DB() {
		try(ObjectOutputStream oo= new ObjectOutputStream(new FileOutputStream("BULLETIN.bin"))) {
				oo.writeObject(null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setDISPATCH_RECORD_DB() {
		try(ObjectOutputStream oo= new ObjectOutputStream(new FileOutputStream("DISPATCH_RECORD.bin"))) {
				oo.writeObject(null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void makeCOURSE_DB() {
		LinkedList<String/* classTYPE */> list = new LinkedList<>();

		/* class Fields */
		String corName;
		/* class Fields */

		Scanner sc = new Scanner(System.in);

		try (BufferedWriter fw = new BufferedWriter(new FileWriter("COURSE.txt"))) {
			while (true) {
				/* input data */
				System.out.print(" INPUT REGISETER COURSE NAME  : ");
				corName = sc.next();
				if (corName.equals("quit"))
					break;

				/* add to list */
				list.add(corName);
			}
			/* write to file */
			for (String b : list) {
				fw.write(b, 0, b.length());
				fw.newLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void makeLOGIN_DB()
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
	         ID = sc.next();
	         if (ID.equals("quit"))         break;
	         System.out.print(" INPUT REGISETER PSWRD : ");
	         PW = sc.next();
	         System.out.print(" INPUT REGISETER TYPE  : ");
	         type = sc.nextInt();         
	         sc.next();
	         System.out.print(" INPUT REGISETER NAME  : ");
	         name = sc.next();         
	         System.out.print(" INPUT REGISETER NUM   : ");
	         num = sc.next();
	         System.out.print(" INPUT REGISETER SCORE : ");
	         score = sc.next();
	         
	         
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
	   

	}
	
	
	public static void login() throws NoSuchElementException{
		String ID, PW;
		boolean find_flag = false;
		boolean logout_flag=false;
		int count=0;
		String c;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("STATUS ( STEP : " + Status.step + ")" );
		
		while (true) {
			System.out.println("If you want to quit login insert 'quit'");
			System.out.println("Input ID : ");
			ID = sc.next();
			if (ID.equals("quit")) {
				System.out.println("System off~");
				return;
			}

			System.out.println("Input PW : ");
			PW = sc.next();
			if (PW.equals("quit")) {
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
