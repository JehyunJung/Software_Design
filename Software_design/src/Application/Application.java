package Application;

import java.util.Scanner;
import Person.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;





public class Application{
	public static void main(String[] args) {
		Person person=new Person(null,null);
		Student student=new Student(null,null,null);
		Manager manager=new Manager(null,null);
		Head_Of_Department head= new Head_Of_Department(null,null);
		
		Scanner sc=new Scanner(System.in);
		String quitOption;
		while(true) {
		if(login(person))
			break;
		else {
			System.out.println("If you want to quit login insert 'quit'");
			quitOption=sc.nextLine();
			if(quitOption.equals("quit"))
				break;
			}
		}
		
		if(person instanceof Student) {
			student=(Student)person;
		}
		if(person instanceof Manager) {
			manager=(Manager)person;
		}
		if(person instanceof Head_Of_Department) {
			head=(Head_Of_Department)person;
		}
		
		
	}
	
	public static boolean login(Person person) {
		String ID, PW;
		String info_ID, info_PW,info_name,info_num,info_score;
		int info_type;
		File file=new File("information.txt");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input ID : ");
		ID=sc.nextLine();
		
		System.out.println("Input PW : ");
		PW=sc.nextLine();
		
		try {
			sc =new Scanner(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		while(sc.hasNext()) {
			info_ID=sc.next();
			info_PW=sc.next();
			info_name=sc.next();
			info_type=sc.nextInt();
			info_num=sc.next();
			info_score=sc.next();
			
			if(ID.equals(info_ID)) {
				if(PW.equals(info_PW)) {
					System.out.println("Login successed");
					switch(info_type) {
					case 0:
						person=new Student(info_name,info_num,info_score);
						break;
					case 1:
						person=new Manager(info_name,info_num);
						break;
					case 2:
						person=new Head_Of_Department(info_name,info_num);
						break;
					}
					return true;
				}
				else {
					System.out.println("Password is wrong\n");
					return false;
				}
			}
		}
		System.out.println("ID doesn't exists");
		return false;
	}

}
