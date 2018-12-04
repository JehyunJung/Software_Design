package Person;
import Status.*;

import java.util.Scanner;

public class Head_Of_Department extends Person {
	public Head_Of_Department(String name, String number) { // constructor
		super(name, number);
	}

	public boolean handle_transfercredits_apply() { // handle with tranfer_credits applications
		String course_name;
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
				System.out.println("**********Major applied course***********");
				for (Status s : Status.status) {
					for (Course c : s.getCourse())
						if(c.get_major()==false)
							c.see_applied_course();
				}

				System.out.println("Input transfer credit name");
				System.out.println("If you want to quit, Input quit");
				course_name = sc.next();

				if (course_name.equals("quit")) {
					System.out.println("'transfer credit course' quit");
					Status.upload();
					return true;
				}
				find_flag=false;
				for (Status b : Status.status) {
					for (Course c : b.getCourse()) {
						if (course_name.equals(c.getName()) && c.get_major_stat() == true && c.get_major() != true) {
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
				System.out.println("**********Head Of Department Options**********");
				System.out.println("1. handle with tranfer_credits applications\n" + "2. logout");
				while (true) {
					System.out.print("Insert option: ");
					menu_option = sc.nextInt();
					if (menu_option >= 1 && menu_option <= 2)
						break;
					System.out.println("Wrong input\n");
				}

				switch (menu_option) {
				case 1:
					handle_transfercredits_apply();
					break;
				case 2:
					return true;
				}
			}
	}

}