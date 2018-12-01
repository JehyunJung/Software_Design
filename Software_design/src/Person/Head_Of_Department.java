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
	LinkedList<Status> status=new LinkedList<>();
	Scanner sc = new Scanner(System.in);
	String a;

	public Head_Of_Department(String name, String number) { // constructor
		super(name, number);
		//Status.download(status);
	}

	public boolean handle_transfercredits_apply() { // handle with tranfer_credits applications
		
		Major_course.download();
		ListIterator<Major_course> itr=Major_course.Major_course.listiterator();
		while(true) {
			while(itr.hasNext()) {
				Major_course.show_info(itr.next());
			}
			itr=Major_course.Major_course.listiterator();
			
			System.out.println("Input transfer credit course");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(tcc.equals("quit")){
				System.out.println("'transfer credit course' quit");
				Major_course.upload();
				return false;
			}	
			else
			{
				while(itr.hasNext())
				{
					itr.next();
					if(a.equals(itr.name));
						break;
				}
				if(a.equals(itr.name))
				{
					System.out.println("input transfer credit course complete");
					//상태 변경
				}
				else
					System.out.println("input transfer credit course not exist");
			}
		}
	}

	public boolean head_option() {
		int menu_option;
		Scanner sc = new Scanner(System.in);

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