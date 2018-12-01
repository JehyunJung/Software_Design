package Person;

import java.util.LinkedList;
import java.util.Scanner;
import Bulletin.*;
import Status.*;

public class Student extends Person {
	String score;
	LinkedList<Document> document=new LinkedList<>();

	public Student(String name, String number, String score) {
		super(name, number);
		this.score = score;
	}

	public void see_cur_status() { // search for student's current status

		for(Status b : Status.status)
			if(this.number.equals(b.getNumber()))
				b.show_info();		
		
	}

	public void register_document(String col_name,String doc_type) { // register document
		Document myDocument=new Document(name,number,col_name,doc_type);
		document.add(myDocument);
	}

	public boolean apply_transfercredits() { // apply for transfer credit
		return true;
	}

	public boolean cancel_apply() { // canceling application
		return true;
	}

	public boolean firstapply() { // see applicable Bulletin and apply

		if (Status.first_application_check() == false)
			return false;

		int length, select;
		length = see_Applicable_bull(); // from 'applicable bulletin : database'
										// read until EOF, and measure the database length
		try (Scanner sc = new Scanner(System.in)) {
			select = sc.nextInt();
			if (select <= 0 || select > length)
				return false; // Select val. error catch-> do - while until proper val.
			
			
			//apply selected one
			Status.add_status_to_list(name, number, 0, 0, 0, Bulletin.bulletin.get(select));
		}
		return true;
	}

	public void see_dispatch_record() { // see dispatch record
		int count = -1;
		for(Dispatch_Record b : Dispatch_Record.dispatch_record){
			count++; 
			System.out.print(count+"\t");
			b.show_info();		
		}
	}

	public boolean finalapply() { // final application
		return true;
	}

	public int see_Applicable_bull() {
		int count = -1;
		
		for(Bulletin b : Bulletin.bulletin){
			count++; 
			if (score.compareTo(b.getRequiredScore()) < 0) 
			{
				System.out.print(count+"\t");
				b.show_info();			
			}
		}
		return count;
	}

	public boolean student_option() {
		int menu_option;
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("**********Student Options**********");
			System.out.println("1. search for student's current status\n" + "2. print appliable Bulletin and apply\n"
					+ "3. register document\n" + "4. final application\n" + "5. apply for transfer credit"
					+ "6. canceling application\n" + "7. see dispatch record" + "8. logout");
			while (true) {
				System.out.print("Insert option: ");
				menu_option = sc.nextInt();
				if (menu_option >= 1 && menu_option <= 8)
					break;
				else
					System.out.println("Wrong input\n");
			}
		}
		
		switch (menu_option) {
		case 1:
			see_cur_status();
		case 2:
			firstapply();
		case 3:
			String col_name;
			String doc_type;
			try (Scanner sc = new Scanner(System.in)) {
				col_name=sc.next();
				doc_type=sc.next();
				}
			register_document(col_name,doc_type);
		case 4:
			finalapply();
		case 5:
			apply_transfercredits();
		case 6:
			cancel_apply();
		case 7:
			see_dispatch_record();
		case 8:
			logout();
		}
		
		
		//a - mu gu na return
		return false;
	}

}
