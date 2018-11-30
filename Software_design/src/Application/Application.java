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
		Person person=null;
		Student student=null;
		Manager manager=null;
		Head_Of_Department head= null;
	
		if(!login(person)) {
			System.out.println("System off~~");
			return;
		}
		
		
		//Creating partipant's type
		if(person instanceof Student) {
			student=(Student)person;
		}
		if(person instanceof Manager) {
			manager=(Manager)person;
		}
		if(person instanceof Head_Of_Department) {
			head=(Head_Of_Department)person;
		}
		
		if(student!=null) {
			public boolean student_option() {
				int menu_option;
				Scanner sc=new Scanner(System.in);
				
			System.out.println("**********Student Options**********");
			System.out.println("1. search for student's current status\n" + "2. print appliable Bulletin and apply\n" + 
			"3. register document\n" + "4. final application\n" + "5. apply for transfer credit" + 
					"6. canceling application\n" + "7. see dispatch record" + "8. logout");
			while(true) {
				System.out.print("Insert option: ");
				menu_option=sc.nextInt();
				if(menu_option>=1 && menu_option<=8)
					break;
				else
					System.out.println("Wrong input\n");
			}
			switch(menu_option) {
			case 1:
				see_cur_record();
			case 2:
				firstapply();
			case 3:
				register_document();
			case 4:
				finalapply();
			case 5:
				apply_transfercredits();
			case 6:
				cancel_apply();
			case 7:
				see_dispatch_record();
			case 8:	
				logout();
			}
			}
			
			
		}
		else if(manager!=null) {
			public boolean manager_option() {
				int menu_option;
				Scanner sc=new Scanner(System.in);
				
			System.out.println("**********Manager Options**********");
			System.out.println("1. post bull\n" + "2. delete bull\n" + 
			"3. handle_first_apply\n" + "4. record final result\n" + "5. record transfer result\n" + 
					"6. see dispatch record" + "7. logout");
			
			while(true) {
				System.out.print("Insert option: ");
				menu_option=sc.nextInt();
				if(menu_option>=1 && menu_option<=7)
					break;
				else
					System.out.println("Wrong input\n");
			}
			switch(menu_option) {
			case 1:
				add_bull();
			case 2:
				 del_bull();
			case 3:
				handle_first_apply();
			case 4:
				handle_final_apply();
			case 5:
				handle_transfercredit_apply();
			case 6:
				see_dispatch_rec();
			case 7:
				logout();
			}
			}
			
		}
		else if(head !=null){
			public boolean head_option() {
				int menu_option;
				Scanner sc=new Scanner(System.in);
				
				System.out.println("**********Head Of Department Options**********");
				System.out.println("1. handle with tranfer_credits applications\n" + "2. logout");
				
				while(true) {
					System.out.print("Insert option: ");
					menu_option=sc.nextInt();
					if(menu_option>=1 && menu_option<=2)
						break;
					else
						System.out.println("Wrong input\n");
				}
				switch(menu_option) {
				case 1:
					handle_transfercredits_apply();
				case 2:
					logout();
				}
			}
		}
			
	}

	public static boolean login(Person person) {
		String ID, PW;
		String info_ID, info_PW,info_name,info_num,info_score;
		int info_type;
		Scanner sc=new Scanner(System.in);
		String quitOption;
		File file;
		while (true) {
			System.out.println("If you want to quit login insert 'quit'");
			quitOption = sc.nextLine();
			if (quitOption.equals("quit"))
				return false;
			file = new File("information.txt");

			System.out.println("Input ID : ");
			ID = sc.nextLine();

			System.out.println("Input PW : ");
			PW = sc.nextLine();

			try {
				sc = new Scanner(file);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}

			while (sc.hasNext()) {
				info_ID = sc.next();
				info_PW = sc.next();
				info_name = sc.next();
				info_type = sc.nextInt();
				info_num = sc.next();
				info_score = sc.next();

				if (ID.equals(info_ID)) {
					if (PW.equals(info_PW)) {
						System.out.println("Login successed");
						switch (info_type) {
						case 0:
							person = new Student(info_name, info_num, info_score);
							break;
						case 1:
							person = new Manager(info_name, info_num);
							break;
						case 2:
							person = new Head_Of_Department(info_name, info_num);
							break;
						}
						return true;
					} else {
						System.out.println("Password is wrong\n");
						continue;
					}
				}
			}
			System.out.println("ID doesn't exists");
			continue;
		}

	}
	public static void logout() {
		login();
	}
}
