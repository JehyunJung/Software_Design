package Person;
import Status.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import Application.*;

public class Head_Of_Department extends Person {
	// String dep_name; //Department name
	LinkedList<Status> status=new LinkedList<>();

	public Head_Of_Department(String name, String number) { // constructor
		super(name, number);
		//Status.download(status);
	}

	public boolean handle_transfercredits_apply() { // handle with tranfer_credits applications
		Scanner sc = new Scanner(System.in);
		String tcc;
		
		while(true) {
			//file print course
			
			System.out.println("Input transfer credit course");
			System.out.println("If you want to quit, Input quit");
			tcc = sc.nextLine();
			if(tcc.equals("quit")){
				System.out.println("'transfer credit course' quit");
				return false;
			}	
			else
			{
				//course info compare
				
				//complete
				System.out.println("input transfer credit course complete");
				//fail
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