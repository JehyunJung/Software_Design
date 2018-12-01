package Person;

import java.util.ListIterator;
import java.util.Scanner;

import Bulletin.*;
import Status.*;
//import Application.missing;

public class Manager extends Person { // faculty class
	Scanner sc = new Scanner(System.in);
	String a,b,c,d,e,f; // input value(quit or info)
	public Manager(String name, String number) {
		super(name, number);
	}

	public boolean print_bull(){ // print bull
		Bulletin.download();
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
		}
	}
	public boolean add_bull() { // post bull
		Bulletin.download();
		ListIterator<Bulletin> itr=Bulletin.bulletin.listIterator();
		while(true) {
			//print bull
			while(itr.hasNext()) {
				itr.next().show_info();
			}
			itr=Bulletin.bulletin.listIterator();
			
			System.out.println("Don't input space in the one info member");
			System.out.println("1. Input add bull name : ");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'add bull' quit");
				Bulletin.upload();
				return false;
			}	
			else
			{
				while(itr.hasNext())
				{
					Bulletin temp = itr.next();
					if(a.equals(temp.getName())){
						System.out.println("same bull exist");
						continue;
					}
					else
						System.out.println("same bull not exist");
				}
				
			}
			System.out.println("2. Input add country : ");
			b = sc.nextLine();
			System.out.println("3. Input add school name : ");
			c = sc.nextLine();
			System.out.println("4. Input add required grade : ");
			d = sc.nextLine();
			System.out.println("5. Input add period : ");
			e = sc.nextLine();
			System.out.println("6. Input add major : ");
			f = sc.nextLine();	
			Bulletin temp = new Bulletin(a,b,c,d,e,f);
			itr.add(temp);
		}
	}

	public boolean del_bull() { // delete bull
		Bulletin.download();
		ListIterator<Bulletin> itr=Bulletin.bulletin.listIterator();
		while(true) {
			while(itr.hasNext()) {
				itr.next().show_info();
			}
			itr=Bulletin.bulletin.listIterator();
			
			System.out.println("Input delete bull name");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'delete bull' quit");
				Bulletin.upload();
				return false;
			}
			else
			{
				while(itr.hasNext())
				{
					Bulletin temp = itr.next();
					if(a.equals(temp.getName())){
						System.out.println("delete bull complete");
						itr.remove();
					}
					else
						System.out.println("input bull not exist");
				}
			}
		}
	}

	public boolean handle_first_apply() { // record first result
		Bulletin.download();
		ListIterator<Status> itr=Status.status.listIterator();
		while(true) {
			while(itr.hasNext()) {
				itr.next().show_info();
			}
			itr=Status.status.listIterator();
			
			System.out.println("Input first apply pass student number");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'handle_first_apply' quit");
				Status.upload();
				return false;
			}
			else
			{
				while(itr.hasNext())
				{
					Status temp = itr.next();
					if(a.equals(temp.getNumber())){
						System.out.println(a+"is passed first apply");
						Status temp1 = new Status(temp.getName(),temp.getNumber(),2,temp.getStat2(),temp.getStat3(),temp.getApplication());
						itr.remove();
						itr.add(temp1);	
					}
					else
						System.out.println("input student number not exist");
				}
			}
		}
	}

	public boolean handle_final_apply() { // record final result
		Bulletin.download();
		ListIterator<Status> itr=Status.status.listIterator();
		while(true) {
			while(itr.hasNext()) {
				itr.next().show_info();
			}
			itr=Status.status.listIterator();
			System.out.println("Input final apply pass student number");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'handle_final_apply' quit");
				Status.upload();
				return false;
			}	
			else
			{
				while(itr.hasNext())
				{
					Status temp = itr.next();
					if(a.equals(temp.getNumber())){
						System.out.println(a+"is passed final apply");
						Status temp1 = new Status(temp.getName(),temp.getNumber(),temp.getStat1(),2,temp.getStat3(),temp.getApplication());
						itr.remove();
						itr.add(temp1);	
					}
					else
						System.out.println("input student number not exist");
				}
			}
		}
	}

	public boolean handle_transfercredit_apply() { // record transfer_credit
		Bulletin.download();
		ListIterator<Status> itr=Status.status.listIterator();

		while(true) {
			while(itr.hasNext()) {
				itr.next().show_info();
			}
			itr=Status.status.listIterator();
			System.out.println("Input transfercredit apply pass student number");
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'handle_transfercredit_apply' quit");
				Status.upload();
				return false;
			}	
			else
			{
				while(itr.hasNext())
				{
					Status temp = itr.next();
					if(a.equals(temp.getNumber())){
						System.out.println(a+"is passed transfercredit apply");
						Status temp1 = new Status(temp.getName(),temp.getNumber(),temp.getStat1(),temp.getStat2(),2,temp.getApplication());
						itr.remove();
						itr.add(temp1);	
					}
					else
						System.out.println("input student number not exist");
				}
			}
		}
	}

	public boolean see_dispatch_rec() { // see dispatch record
		Dispatch_Record.download();
		ListIterator<Dispatch_Record> itr= Dispatch_Record.dispatch_record.listIterator();
		while(itr.hasNext()) {
			itr.next().show_info();
		}
		while(true) {
			System.out.println("If you want to quit, Input quit");
			a = sc.nextLine();
			if(a.equals("quit")){
				System.out.println("'see dispatch record' quit");
				return false;
			}	
			else
				System.out.println("Input value is not quit");
		}
	}

	public boolean manager_option() {
		int menu_option;

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