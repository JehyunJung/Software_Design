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
	Scanner sc = new Scanner(System.in);
	String a;

	public Head_Of_Department(String name, String number) { // constructor
		super(name, number);
		//Status.download(status);
	}

	public boolean handle_transfercredits_apply() { // handle with tranfer_credits applications
		Status.download();
		ListIterator<Course> itr=Course.course.listIterator();
		while(true) {
			while(itr.hasNext()) {
				itr.next().show_info();
			}
			itr=Course.course.listiterator();
			
			System.out.println("Input transfer credit course");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'transfer credit course' quit");
				Course.upload();
				return false;
			}	
			else
			{
				while(itr.hasNext())
				{
					Course temp = itr.next();
					if(a.equals(temp.getName())) {
						System.out.println("input transfer credit course complete");
						Course temp1 = new Course(temp.getName(),true);
						itr.remove();
						itr.add(temp1);	
					}
					else
						System.out.println("input transfer credit course not exist");
				}
				
			}
		}
	}

	public boolean head_option() {
		int menu_option;

		System.out.println("**********Head Of Department Options**********");
		System.out.println("1. handle with tranfer_credits applications\n" + "2. logout");

		while (true) {
			System.out.print("Insert option: ");
			menu_option = sc.nextInt();
			if (menu_option >= 1 && menu_option <= 2)
				break;
			else
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