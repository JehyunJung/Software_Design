package Bulletin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;

// Bulletin package
public class Bulletin{
	String bull_name;			//bulletin name
	String col_name;			//college name
	String req_score;			//required score
	String country;				//country
	String period;				//exchange student period
	String major;				//exchange student major
	public static LinkedList<Bulletin> bulletin=new LinkedList<>();	//static linkedlist of Bulletin
	public Bulletin(String bull_name,String col_name, String req_score, String country, String period, String major) {
		this.bull_name=bull_name;
		this.col_name=col_name;
		this.req_score=req_score;
		this.country=country;
		this.period=period;
		this.major=major;
		
	}
	
	public String getRequiredScore() {
		return this.req_score;
	}
	
	public String getName() {
		return this.bull_name;
	}
	
	
	// add bulletin to list;
	public static void add_bulletin_to_list(String bull_name,String col_name, String score, String country, String period, String major){
		//create Bulletin and insert to list;
		Bulletin myBulletin = new Bulletin(bull_name,col_name, score,country,period,major);
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
	
	
	public void show_info() {
		System.out.print("Bull_name: " + bull_name);		//print the name of bulletin board;
		System.out.print("College_name: " + col_name);		//print the name of exchange school
		System.out.print("\tCountry: " + country);			//print the country of exchange school
		System.out.print("\tPeriod: " + period );			//print the period of exchange school
		System.out.print("\tRequired_Score: " + req_score);		//print required score
		System.out.println("\tMajor: " + major);				//print exchange student major
		
	}

}

