package Person;
import Status.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Head_Of_Department extends Person {
	public Head_Of_Department(String name, String number) { // constructor
		super(name, number);
	}

	public boolean handle_major_apply() { // handle with tranfer_credits applications
		String corNum;
		String corName;
		LinkedList<String> courseNameList = new LinkedList<>();
		
		boolean find_flag=false; // find_flag for course_name check
		Scanner sc = new Scanner(System.in);
		if(Status.download() == false) {
			System.out.println("Status not found ");
			return false;
		}
		if (Status.transfer_credit_application_check() != true) {
			System.out.println("Not appropriate step");
			sc.close();
			return false;
		}
		
			while (true) {
				Course.count = -1;
				courseNameList.clear();
				
				System.out.println("**********Major applied course***********");
				for (Status s : Status.status) {					
					for (Course c : s.getCourse())
					{
						courseNameList.add(c.getName());
						c.see_applied_course(); // Course.count increases
					}
				}

				System.out.println("Input major course index ");
				System.out.println("If you want to quit, Input quit");
				corNum = sc.next();

				if (corNum.equals("quit")) {
					System.out.println("'handle major apply' quit");
					Status.upload();
					return true;
				}
				
				find_flag=false;
				corName = courseNameList.get(Integer.parseInt(corNum));
				System.out.println("INPUTTED COURSE NAME IS " + corName);
				
				for (Status b : Status.status) {
					for (Course c : b.getCourse()) {
						if (corName.equals(c.getName()) && c.get_major_stat() == true && c.get_major() != true) {
							c.set_major(true);
							find_flag = true;
						}
					}
					b.setCourse(b.getCourse());
				}
				if(find_flag!=true) 
					System.out.println("Input course name doesn't exists");

			}
		
	}

	public boolean head_option() {
		int menu_option;
		Scanner sc = new Scanner(System.in);
	
			while (true) {
				for(int i=0;i<10;i++)
					System.out.println();
				System.out.println("**********Head Of Department Options**********");
				System.out.println("1. handle major applications\n" + "2. logout");
				while (true) {
					System.out.print("Insert option: ");
					menu_option = sc.nextInt();
					if (menu_option >= 1 && menu_option <= 2)
						break;
					System.out.println("Wrong input\n");
				}

				switch (menu_option) {
				case 1:
					handle_major_apply();
					break;
				case 2:
					return true;
				}
			}
	}

}