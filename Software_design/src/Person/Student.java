package Person;

import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Application.*;
import Bulletin.*;
import Status.*;

public class Student extends Person {
	String score;
	

	public Student(String name, String number, String score) {
		super(name, number);
		this.score = score;
	}

	public void see_cur_record() { // search for student's current status
	}

	public boolean register_document() { // register document
		return true;
	}

	public boolean apply_transfercredits() { // apply for transfer credit
		return true;
	}

	public boolean cancel_apply() { // canceling application
		return true;
	}

	public boolean firstapply() { // see appliable Bulletin and apply
		
		if (Status.first_application_check() == false)
			return false;

		int length, select;
		length = see_Appliable_bull(); // from 'appliable bulletin : database'
										// read until EOF, and measure the database length
		Scanner sc = new Scanner(System.in);
		select = sc.nextInt();

		if (select <= 0 || select > length)
			return false; // Select val. error catch-> do - while until proper val.

		firstapply(select);

		return true;
	}

	public void see_dispatch_record() { // see dispatch record

	}

	public boolean finalapply() { // final application
		return true;
	}

	public void firstapply(int select) {
		int count = 0;
		String col_name; // college name
		String req_score; // required score
		String country; // country
		String period; // exchange student period
		String major; // exchange student major
		File file = new File("bulletins.txt");
		Scanner sc = new Scanner(System.in);
		Status myStatus = null;
		
		
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (sc.hasNext()) {
			col_name = sc.next();
			req_score = sc.next();
			country = sc.next();
			period = sc.next();
			major = sc.next();

			count++;

			if (select == count) // apply this! bulletin
			{
				Bulletin apply_info = new Bulletin(col_name, req_score, country, period, major);
				List<Course> course = new LinkedList<>();
				
				//Create myStatus in 
				myStatus = new Status(this.name, this.number, -1, -1, -1, apply_info, course);
				
				
				// upload status to DB
				 try {
					FileWriter fw = new FileWriter("C:\\Users\\TG\\eclipse-workspace\\Software_design\\src\\Person\\StatusDB.txt",true);
					 fw.write(this.name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			//	 fw.write(myStatus);
				 
				 
				 
			}
		}

		sc.close();
	}

	public int see_Appliable_bull() {
		int count = 0;
		String col_name; // college name
		String req_score; // required score
		String country; // country
		String period; // exchange student period
		String major; // exchange student major
		File file = new File("bulletins.txt");
		Scanner sc = new Scanner(System.in);
		try {
			sc = new Scanner(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (sc.hasNext()) {
			col_name = sc.next();
			req_score = sc.next();
			country = sc.next();
			period = sc.next();
			major = sc.next();

			count++;

			if (score.compareTo(req_score) < 0) {
				System.out.println(count + col_name + req_score + country + period + major);

			}
		}

		sc.close();
		return count;
	}

	public boolean student_option() {
		int menu_option;
		Scanner sc = new Scanner(System.in);

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
		switch (menu_option) {
		case 1:
			see_cur_record();
		case 2:
			firstapply();
		case 3:
			register_document();
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
	}

}
