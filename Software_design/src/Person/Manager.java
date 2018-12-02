package Person;

import java.util.ListIterator;
import java.util.Scanner;

import Bulletin.*;
import Status.*;

public class Manager extends Person { // faculty class
	
	
	
	public Manager(String name, String number) {
		super(name, number);
	}

	public void print_bull(){ // print bull
		Bulletin.download();
		for(Bulletin b : Bulletin.bulletin) {
			b.show_info();
		}
		/*
		ListIterator<Bulletin> itr=Bulletin.bulletin.listIterator();
		while(true) {
		
			//print bull
			while(itr.hasNext()) {
				itr.next().show_info();
			}
			
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
		}*/
		
	}

	public boolean add_bull() { // post bull
		String bull_name;
		String col_name;
		String country;
		String req_score;
		String period;
		String major;
		boolean find_flag=false; // needed for repitition check of bulletin
		Bulletin.download();
		
		
		/*ListIterator<Bulletin> itr = Bulletin.bulletin.listIterator();

		// print bull

		
		  while(itr.hasNext()) { itr.next().show_info(); }
		  itr=Bulletin.bulletin.listIterator();
		 
*/
		Bulletin.sort_flag=false;
		for (Bulletin b : Bulletin.bulletin)
			b.show_info();

		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				find_flag=false;
				System.out.println("Don't input space in the one info member");
				System.out.println("1. Input add bull name : ");
				System.out.println("If you want to quit, Input quit");
				bull_name = sc.nextLine();

				if (bull_name.equals("quit")) {
					System.out.println("'add bull' quit");
					Bulletin.upload();
					return true;
				}
				// checking for bulletin name repitition
				for (Bulletin b : Bulletin.bulletin) {
					if (bull_name.equals(b.get_bull_name())) {
						System.out.println("Same bulletin exists");
						find_flag = true;
					}
				}
				
				if (find_flag)
					continue;

				/*
				 * while(itr.hasNext()) { Bulletin temp = itr.next();
				 * if(bull_name.equals(temp.getName())){ System.out.println("same bull exist");
				 * continue; } else System.out.println("same bull not exist"); }
				 */

				System.out.print("3. Input add college name : ");
				col_name = sc.nextLine();
				System.out.print("2. Input add country : ");
				country = sc.nextLine();
				System.out.print("5. Input add period : ");
				period = sc.nextLine();
				System.out.print("6. Input add major : ");
				major = sc.nextLine();
				System.out.print("4. Input add required grade : ");
				req_score = sc.nextLine();
				
				Bulletin.bulletin.add(new Bulletin(bull_name,col_name,country,period,major,req_score));
			}

		}
	}

	public boolean del_bull() { // delete bull
		String bull_name;
		boolean find_flag=false;	//if bulletin exists->find_flag=true;
		Bulletin.download();
		
		ListIterator<Bulletin> itr=Bulletin.bulletin.listIterator();
		try(Scanner sc=new Scanner(System.in)){
		while(true) {
			find_flag=false;
			/*while(itr.hasNext()) {
				itr.next().show_info();
			}
			itr=Bulletin.bulletin.listIterator();*/
			Bulletin.sort_flag=false;
			for(Bulletin b : Bulletin.bulletin)
				b.show_info();
			
			System.out.println("Input bull name to delete");
			System.out.println("If you want to quit, Input quit");
			bull_name = sc.nextLine();
			
			
			if(bull_name.equals("quit")){
				System.out.println("'delete bull' quit");
				Bulletin.upload();
				return true;
			}
			
			while(itr.hasNext()){
				Bulletin temp = itr.next();
				if(bull_name.equals(temp.get_bull_name())){
					System.out.println("delete bull complete");
					itr.remove();
					find_flag=true;
				}
			}
			
			if(find_flag)
				continue;	
			System.out.println("input bull not exist");
			}
		}
	}

	public boolean handle_first_apply() { // record first result
		String stu_num;
		boolean find_flag = false;
		if (Status.first_application_check() != true) {
			System.out.println("Not appropriate step");
			return false;
		}
		Status.download();
		//ListIterator<Status> itr = Status.status.listIterator();
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				find_flag=false;
				for (Status s : Status.status)
					s.show_first_applicant_info();

				//itr = Status.status.listIterator();

				System.out.println("Input first apply pass student number");
				System.out.println("If you want to quit, Input quit");
				stu_num = sc.nextLine();

				if (stu_num.equals("quit")) {
					System.out.println("'handle_first_apply' quit");
					Status.upload();
					return true;
				}
				
				for(Status s : Status.status) {
					if(stu_num.equals(s.getNumber())){
						System.out.println(stu_num + "is passed first apply");
						s.first_modify(2);
						find_flag=true;
					}
				}
				if (find_flag)
					continue;
				System.out.println("input student number not exist");
				/*while (itr.hasNext()) {
					Status temp = itr.next();
					if (stu_number.equals(temp.getNumber())) {
						System.out.println(stu_number + "is passed first apply");
						temp.first_modify(2);
						itr.remove();
						itr.add(temp);
						find_flag = true;
					}
				}
				
				if (find_flag)
					continue;
				System.out.println("input student number not exist");*/
			}
		}
	}

	public boolean handle_final_apply() { // record final result
		String stu_num;
		boolean find_flag = false;
		if (Status.transfer_credit_application_check() != true) {
			System.out.println("Not appropriate step");
			return false;
		}
		Status.download();
		//ListIterator<Status> itr = Status.status.listIterator();
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				find_flag = false;
				for (Status s : Status.status)
					s.show_final_applicant_info();

				//itr = Status.status.listIterator();

				System.out.println("Input final apply pass student number");
				System.out.println("If you want to quit, Input quit");
				stu_num = sc.nextLine();

				if (stu_num.equals("quit")) {
					System.out.println("'handle_final_apply' quit");
					Status.upload();
					return true;
				}
				for (Status s : Status.status) {
					if (stu_num.equals(s.getNumber())) {
						System.out.println(stu_num + "is passed first apply");
						s.second_modify(2);
						find_flag = true;
					}
				}
				if (find_flag)
					continue;
				System.out.println("input student number not exist");
				/*
				 * while (itr.hasNext()) { Status temp = itr.next(); if
				 * (stu_num.equals(temp.getNumber())) { System.out.println(stu_num +
				 * "is passed final apply"); temp.second_modify(2); itr.remove(); itr.add(temp);
				 * find_flag = true; } }
				 */

				if (find_flag)
					continue;
				System.out.println("input student number not exist");
			}

		}
	}

	public boolean handle_transfercredit_apply() { // record transfer_credit
		String stu_num;
		boolean find_flag = false;
		if (Status.final_application_check() != true) {
			System.out.println("Not appropriate step");
			return false;
		}
		Status.download();
		//ListIterator<Status> itr = Status.status.listIterator();
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				find_flag=false;
				for (Status s : Status.status)
					s.show_transfercredit_applicant_info();

				//itr = Status.status.listIterator();

				System.out.println("Input transfercredit apply pass student number");
				System.out.println("If you want to quit, Input quit");
				stu_num = sc.nextLine();

				if (stu_num.equals("quit")) {
					System.out.println("'handle_transfercredit_apply' quit");
					Status.upload();
					return true;
				}
				for (Status s : Status.status) {
					if (stu_num.equals(s.getNumber())) {
						System.out.println(stu_num + "is passed first apply");
						s.final_modify(2);
						find_flag = true;
					}
				}
				if (find_flag)
					continue;
				System.out.println("input student number not exist");
/*
				while (itr.hasNext()) {
					Status temp = itr.next();
					if (stu_num.equals(temp.getNumber())) {
						System.out.println(stu_num + "is passed transfercredit apply");
						temp.final_modify(2);
						itr.remove();
						itr.add(temp);
						find_flag = true;
					}
					if (find_flag)
						continue;
					System.out.println("input student number not exist");
				}
 				*/
			}
		}
	}

	public boolean see_dispatch_rec() { // see dispatch record
		String quitOption;
		Dispatch_Record.download();
		
		Dispatch_Record.sort_flag=false;
		for (Dispatch_Record d : Dispatch_Record.dispatch_record)
			d.show_info();
		
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				System.out.println("If you want to quit, Input quit");
				quitOption = sc.nextLine();
				if (quitOption.equals("quit")) {
					System.out.println("'see dispatch record' quit");
					return true;
				} 
				System.out.println("Input value is not quit");
			}
		}
	}

	public boolean manager_option() {
		int menu_option;

		System.out.println("**********Manager Options**********");
		System.out.println("1. print Bull\n"+"2. post bull\n" + "3. delete bull\n" + "4. handle_first_apply\n"
				+ "5. record final result\n" + "6. record transfer result\n" + "7. see dispatch record\n" + "8. logout");
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				System.out.print("Insert option: ");
				menu_option = sc.nextInt();
				if (menu_option >= 1 && menu_option <= 8)
					break;
				System.out.println("Wrong input\n");
			}
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