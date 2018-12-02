package Bulletin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

// Bulletin package
public class Bulletin  {
	String bull_name;			//bulletin name
	String coll_name;			//college name
	String country;				//country
	String period;				//exchange student period
	String major;				//exchange student major
	String req_score;			//required score
	public static boolean sort_flag=false;	//for checking sorting repitition
	public static LinkedList<Bulletin> bulletin=new LinkedList<>();	//static linkedlist of Bulletin
	public Bulletin(String bull_name,String col_name, String country,  String period, String major,String req_score) {
		this.bull_name=bull_name;
		this.coll_name=col_name;
		this.country=country;
		this.period=period;
		this.major=major;
		this.req_score=req_score;
	}

	public String getRequiredScore() {
		return this.req_score;
	}
	
	public String get_bull_name() {
		return this.bull_name;
	}
	public String get_coll_name() {
		return this.coll_name;
	}
	
	public String get_country() {
		return this.bull_name;
	}
	public String get_period() {
		return this.period;
	}
	public String get_major() {
		return this.major;
	}
	public String get_req_score() {
		return this.req_score;
	}
	
	// add bulletin to list;
	public static void add_bulletin_to_list(String bull_name,String col_name,String country, String period, String major, String score){
		//create Bulletin and insert to list;
		Bulletin myBulletin = new Bulletin(bull_name,col_name, country,period,major,score);
		bulletin.add(myBulletin);
	}
	

	
	
	public static void upload() { // Upload Bulletin data to DB
		Iterator<Bulletin> itr=bulletin.iterator();
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("Bulletin.bin"))) {
			//upload the Bulletin data from list to DB
			while(itr.hasNext())
				oo.writeObject(itr.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void download() { // Download Bulletin from DB with Student ID
		Iterator<Bulletin> itr=bulletin.iterator();
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Bulletin.bin"))) {
			//download the Bulletin data from DB to list
			while (true) {
				if (oi.readObject() == null)
					break;
				Bulletin.bulletin.add(itr.next());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public void sort() {
		int num;
		System.out.println("**********Input Sorting options**********");
		System.out.println("1. By bulletin_name\t2. By college_name\t3. By_country\t4.By_period\t5.By_required_score\n Input -1 to quit");
		try(Scanner sc=new Scanner(System.in)){
			num=sc.nextInt();
		}
		switch(num) {
		case -1:
			return;
		case 1:
			bulletin.sort((b1,b2)->b1.get_bull_name().compareTo(b2.get_bull_name()));
			break;
		case 2:
			bulletin.sort((b1,b2)->b1.get_coll_name().compareTo(b2.get_coll_name()));
			break;
		case 3:
			bulletin.sort((b1,b2)->b1.get_country().compareTo(b2.get_country()));
			break;
		case 4:
			bulletin.sort((b1,b2)->b1.get_period().compareTo(b2.get_period()));
			break;
		case 5:
			bulletin.sort((b1,b2)->b1.get_req_score().compareTo(b2.get_req_score()));
			break;
		}
		
	}
	
	public void show_info() {
		if(Bulletin.sort_flag!=true) {
			sort();
			Bulletin.sort_flag=false;
		}
		System.out.print("Bull_name: " + bull_name);		//print the name of bulletin board;
		System.out.print("College_name: " + coll_name);		//print the name of exchange school
		System.out.print("\tCountry: " + country);			//print the country of exchange school
		System.out.print("\tPeriod: " + period );			//print the period of exchange school
		System.out.print("\tMajor: " + major);				//print exchange student major
		System.out.println("\tRequired_Score: " + req_score);		//print required score
	}

}

