package Person;

import java.util.Scanner;

//import Application.missing;

public class Manager extends Person { // faculty class
	Scanner sc = new Scanner(System.in);
	String a; // input value(quit or info)
	public Manager(String name, String number) {
		super(name, number);
	}

	public boolean print_bull(){
		while(true) {
			//file print bull
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'print bull' quit");
				return false;
			}	
			else
			{
				System.out.println("Input value is not quit");
			}
		}
	}
	public boolean add_bull() { // post bull
		
		while(true) {
			//file read and print
			
			System.out.println("Input add bull(bull name, country, school name, required grade, period, major)");
			System.out.println("ex) bull_name country school_name required_grade period major");
			System.out.println("Don't input space in the one info member");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'add bull' quit");
				return false;
			}	
			else
			{
				//bull info compare
				
				//if(not same)
				{
					System.out.println("add bull complete");
					//add bull
				}
				//else
					System.out.println("same bull exist");
			}
		}
	}

	public boolean del_bull() { // delete bull
		
		while(true) {
			//file read and print
			
			System.out.println("Input delete bull name");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'delete bull' quit");
				return false;
			}	
			else
			{
				//bull info compare
				
				//if(same)
				{
					System.out.println("delete bull complete");
					//delete bull
				}
				//else
					System.out.println("input bull not exist");
			}
		}
	}

	public boolean handle_first_apply() { // record first result
		while(true) {
			//file read and print
			
			System.out.println("Input first apply pass student number");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'handle_first_apply' quit");
				return false;
			}	
			else
			{
				//student number info compare
				
				//if(same)
				{
					System.out.println(/*student number+*/"is passed first apply");
					//update status info
				}
				//else
					System.out.println("input student number not exist");
			}
		}
	}

	public boolean handle_final_apply() { // record final result
		while(true) {
			//file read and print
			
			System.out.println("Input final apply pass student number");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'handle_final_apply' quit");
				return false;
			}	
			else
			{
				//student number info compare
				
				//if(same)
				{
					System.out.println(/*student number+*/"is passed final apply");
					//update status info
				}
				//else
					System.out.println("input student number not exist");
			}
		}
	}

	public boolean handle_transfercredit_apply() { // record transfer_credit
		while(true) {
			//file read and print
			
			System.out.println("Input transfercredit apply pass student number");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'handle_transfercredit_apply' quit");
				return false;
			}	
			else
			{
				//student number info compare
				
				//if(same)
				{
					System.out.println(/*student number+*/"is passed transfercredit apply");
					//update status info
				}
				//else
					System.out.println("input student number not exist");
			}
		}
	}

	public boolean see_dispatch_rec() { // see dispatch record
		while(true) {
			//file print dispatch rec
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'see dispatch record' quit");
				return false;
			}	
			else
			{
				System.out.println("Input value is not quit");
			}
		}
	}

	public boolean manager_option() {
		int menu_option;
		Scanner sc = new Scanner(System.in);

		System.out.println("**********Manager Options**********");
		System.out.println("1. print Bull\n"+"2. post bull\n" + "3. delete bull\n" + "4. handle_first_apply\n"
				+ "5. record final result\n" + "6. record transfer result\n" + "7. see dispatch record\n" + "8. logout");

		while (true) {
			System.out.print("Insert option: ");
			menu_option = sc.nextInt();
			if (menu_option >= 1 && menu_option <= 8)
				break;
			else
				System.out.println("Wrong input\n");
		}
		switch (menu_option) {
		case 1:
			print_bull();
		case 2:
			add_bull();
		case 3:
			del_bull();
		case 4:
			handle_first_apply();
		case 5:
			handle_final_apply();
		case 6:
			handle_transfercredit_apply();
		case 7:
			see_dispatch_rec();
		case 8:
			logout();
		}
		return false;
	}
	
}