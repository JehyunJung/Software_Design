package Person;
import Status.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import Application.*;
import Bulletin.Bulletin;

public class Head_Of_Department extends Person {
	// String dep_name; //Department name
	LinkedList<Course> status=new LinkedList<>();

	public Head_Of_Department(String name, String number) { // constructor
		super(name, number);
		//Status.download(status);
	}

	public boolean handle_transfercredits_apply() { // handle with tranfer_credits applications
		String course_name;
		String stu_num;
		boolean find_flag1, find_flag2; // find_flag1 for stu_num search check, find_flag2 for course_name check
		LinkedList<Course> course = new LinkedList<>();
		if (Status.transfer_credit_application_check() != true) {
			System.out.println("Not appropriate step");
			Status.upload();
			return false;
		}
		Status.download();
		try (Scanner sc = new Scanner(System.in)) {
			ListIterator<Course> itr = null;
			while (true) {
				System.out.println("**********Student list***********");
				for (Status s : Status.status) {
					// s.
				}

				find_flag1 = false;
				System.out.println("Input student number");
				System.out.println("If you want to quit, Input quit");
				stu_num = sc.nextLine();

				if (stu_num.equals("quit")) {
					System.out.println("'transfer credit course' quit");
					Status.upload();
					return true;

				}

				for (Status b : Status.status) {
					if (stu_num.equals(b.getNumber())) {
						course = b.getCourse();
						itr = course.listIterator();
						find_flag1 = true;
					} else
						continue;
					if (find_flag1) {
						while (true) {
							System.out.println("**********" + stu_num + "'s course list**********");
							for (Course c : course)
								c.see_applied_course();

							find_flag2 = false;
							System.out.println("Input transfer credit course");
							System.out.println("If you want to quit, Input quit");
							course_name = sc.nextLine();

							if (course_name.equals("quit")) {
								System.out.println("'transfer credit course name' quit");
								b.setCourse(course);
								Status.upload();
								return true;

							}

							for (Course c : course) {
								if (course_name.equals(c.getName())) {
									c.set_major(true);
									find_flag2 = true;
								}
							}
							if (find_flag2)
								continue;
							System.out.println("input transfer credit course not exist");
						}
					}
				}
				if (find_flag1)
					continue;
				System.out.println(stu_num + "doesn't exists");

			}

		}
	}

	public boolean head_option() {
		int menu_option;
		System.out.println("**********Head Of Department Options**********");
		System.out.println("1. handle with tranfer_credits applications\n" + "2. logout");
		try (Scanner sc = new Scanner(System.in)) {
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
			case 2:
				logout();
			}
			return false;
		}
	}

}