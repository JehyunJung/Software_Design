package Person;

import java.util.ListIterator;
import java.util.Scanner;

import Bulletin.*;
import Status.*;

public class Manager extends Person { // faculty class
	public Manager(String name, String number) {
		super(name, number);
	}

	public void dispatch_add() {
		Dispatch_Record.download();
		if(Status.download() == false) {
			System.out.println("Status not found ");
			return;
		}for(Status s : Status.status) {
			if(s.getStat2() == 2)
				Dispatch_Record.add_Dispatch_to_list((s.getApplication()).get_coll_name(),(s.getApplication()).get_period(), (s.getApplication()).get_major());
		}
		Dispatch_Record.upload();
	}
	
	public boolean print_bull() { // print bull
		String quitOption;
		Bulletin.download();
		for (Bulletin b : Bulletin.bulletin) {
			b.show_info();
		}
		Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("If you want to quit, Input quit");
				quitOption = sc.nextLine();
				
				if (quitOption.equals("quit")) {
					System.out.println("'print bull' quit");
					sc.close();
					return false;
				}
				System.out.println("Input value is not quit");
			}
		
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
		
		Bulletin.sort_flag=false;
		for (Bulletin b : Bulletin.bulletin)
			b.show_info();

		Scanner sc = new Scanner(System.in);
			while (true) {
				find_flag=false;
				System.out.println("Don't input space in the one info member");
				System.out.println("1. Input add bull name : ");
				System.out.println("If you want to quit, Input quit");
				bull_name = sc.nextLine();

				if (bull_name.equals("quit")) {
					System.out.println("'add bull' quit");
					Bulletin.upload();
					sc.close();
					return true;
				}
				// checking for bulletin name repitition
				for (Bulletin b : Bulletin.bulletin) {
					if (bull_name.equals(b.get_bull_name())) {
						System.out.println("Same bulletin exists");
						find_flag = true;
						break;
					}
				}
				
				if (find_flag)
					continue;

				System.out.print("2. Input add college name : ");
				col_name = sc.nextLine();
				System.out.print("3. Input add country : ");
				country = sc.nextLine();
				System.out.print("4. Input add period : ");
				period = sc.nextLine();
				System.out.print("5. Input add major : ");
				major = sc.nextLine();
				System.out.print("6. Input add required grade : ");
				req_score = sc.nextLine();
				
				Bulletin.bulletin.add(new Bulletin(bull_name,col_name,country,period,major,req_score));
			}

		
	}

	public boolean del_bull() { // delete bull
		String bull_name;
		boolean find_flag=false;	//if bulletin exists->find_flag=true;
		Bulletin.download();
		
		ListIterator<Bulletin> itr=Bulletin.bulletin.listIterator();
		Scanner sc=new Scanner(System.in);
		while(true) {
			find_flag=false;
			
			Bulletin.sort_flag=false;
			for(Bulletin b : Bulletin.bulletin)
				b.show_info();
			
			System.out.println("Input bull name to delete");
			System.out.println("If you want to quit, Input quit");
			bull_name = sc.nextLine();
			
			
			if(bull_name.equals("quit")){
				System.out.println("'delete bull' quit");
				Bulletin.upload();
				sc.close();
				return true;
			}
			itr=Bulletin.bulletin.listIterator();
			while(itr.hasNext()){
				Bulletin temp = itr.next();
				if(bull_name.equals(temp.get_bull_name())){
					System.out.println("delete bull complete");
					itr.remove();
					find_flag=true;
					break;
				}
			}
			
			if(find_flag)
				continue;	
			System.out.println("input bull not exist");
			}
		
	}

	public boolean handle_first_apply() { // record first result
		String stu_num;
		boolean find_flag = false;
		
		if(Status.download() == false) {
			System.out.println("Status not found ");
			return false;
		}
		
		if (Status.first_application_check() != true) {
			System.out.println("Not appropriate step");
			Status.upload();
			return false;
		}
		Scanner sc = new Scanner(System.in);
			while (true) {
				find_flag=false;
				for (Status s : Status.status)
					s.show_first_applicant_info();

		

				System.out.println("Input first apply pass student number");
				System.out.println("If you want to quit, Input quit");
				stu_num = sc.nextLine();

				if (stu_num.equals("quit")) {
					System.out.println("'handle_first_apply' quit");
					Status.upload();
					Status.step = 2;
					sc.close();
					return true;
				}
				
				for(Status s : Status.status) {
					if(stu_num.equals(s.getNumber())){
						System.out.println(stu_num + "is passed first apply");
						s.first_modify(2);
						find_flag=true;
						break;
					}
				}
				if (find_flag)
					continue;
				System.out.println("input student number not exist");
				
			}
		
	}

	public boolean handle_final_apply() { // record final result
		String stu_num;
		boolean find_flag = false;
		if(Status.download() == false) {
			System.out.println("Status not found ");
			return false;
		}
		if (Status.final_application_check() != true) {
			System.out.println("Not appropriate step");
			Status.upload();
			return false;
		}
		Scanner sc = new Scanner(System.in);
			while (true) {
				find_flag = false;
				for (Status s : Status.status)
					s.show_final_applicant_info();


				System.out.println("Input final apply pass student number");
				System.out.println("If you want to quit, Input quit");
				stu_num = sc.nextLine();

				if (stu_num.equals("quit")) {
					System.out.println("'handle_final_apply' quit");
					Status.upload();
					Status.step = 3;
					sc.close();
					return true;
				}
				for (Status s : Status.status) {
					if (stu_num.equals(s.getNumber())) {
						System.out.println(stu_num + "is passed final apply");
						s.second_modify(2);
						find_flag = true;
						break;
					}
				}
				if (find_flag)
					continue;
				System.out.println("input student number not exist");

			}

		
	}

	public boolean handle_transfercredit_apply() { // record transfer_credit
		String stu_num;
		boolean find_flag = false;
		if(Status.download() == false) {
			System.out.println("Status not found ");
			return false;
		}
		
		if (Status.transfer_credit_application_check() != true) {
			System.out.println("Not appropriate step");
			Status.upload();
			return false;
		}
		Scanner sc = new Scanner(System.in) ;
			while (true) {
				find_flag=false;
				for (Status s : Status.status)
					s.show_transfercredit_applicant_info();		

				System.out.println("Input transfercredit apply pass student number");
				System.out.println("If you want to quit, Input quit");
				stu_num = sc.nextLine();

				if (stu_num.equals("quit")) {
					System.out.println("'handle_transfercredit_apply' quit");
					Status.upload();
					Status.step = 5;
					dispatch_add();
					sc.close();
					return true;
				}
				for (Status s : Status.status) {
					if (stu_num.equals(s.getNumber())) {
						System.out.println(stu_num + "is passed transfercredit apply");
						s.final_modify(2);
						find_flag = true;
						break;
					}
				}
				if (find_flag)
					continue;
				System.out.println("input student number not exist");
			}
		
	}

	public boolean see_dispatch_rec() { // see dispatch record
		String a;
		int count=0;
		Dispatch_Record.download();
		Dispatch_Record.sort_flag=false;
		
		Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("Input dispatch record period you want");
				System.out.println("ex) 2018_1");
				System.out.println("If you want to quit, Input quit");
				a = sc.nextLine();
				if (a.equals("quit")) {
					System.out.println("'see dispatch record' quit");
					sc.close();
					return true;
				} 
				else {
					for (Dispatch_Record d : Dispatch_Record.dispatch_record)
					{
						if((d.get_period()).equals(a))
						{
							d.show_info();
							count++;
						}
					}	
					if(count==0)
						System.out.println("Input value is error");
					count=0;
					continue;
				}	
			}
		
	}

	public boolean manager_option() {
		int menu_option;
		Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("**********Manager Options**********");
				System.out.println("1. print Bull\n" + "2. post bull\n" + "3. delete bull\n" + "4. handle_first_apply\n"
						+ "5. record final result\n" + "6. record transfer result\n" + "7. see dispatch record\n"
						+ "8. logout");

				while (true) {
					System.out.print("Insert option: ");
					menu_option = sc.nextInt();
					if (menu_option >= 1 && menu_option <= 8)
						break;
					System.out.println("Wrong input\n");
				}

				switch (menu_option) {
				case 1:
					print_bull();
					break;
				case 2:
					add_bull();
					break;
				case 3:
					del_bull();
					break;
				case 4:
					handle_first_apply();
					break;
				case 5:
					handle_final_apply();
					break;
				case 6:
					handle_transfercredit_apply();
					break;
				case 7:
					see_dispatch_rec();
					break;
				case 8:
					sc.close();
					return true;
				}


			}

		
	}
}