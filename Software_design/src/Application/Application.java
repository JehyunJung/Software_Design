package Application;

import java.util.Scanner;
import Person.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Information_class implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ID;
	String PW;
	int type;
	String name;
	String num;
	String score;

	public Information_class(String ID, String PW, int type, String name, String num, String score) {
		this.ID = ID;
		this.PW = PW;
		this.type = type;
		this.name = name;
		this.num = num;
		this.score = score;
	}
	public void show_info() {
		System.out.println(ID);
		System.out.println(PW);
		System.out.println(type);
		System.out.println(name);
		System.out.println(num);
		System.out.println(score);
	}
}
public class Application {
	public static void main(String[] args) {
		System.out.println("**********Login Section***********");
		 
		if (!login()) {
			System.out.println("System off~~");
			return;
		}
		
		

	}

	public static boolean login() {
		String ID, PW;
		boolean find_flag = false;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("If you want to quit login insert 'quit'");
			System.out.println("Input ID : ");
			ID = sc.next();
			if (ID.equals("quit")) {
				sc.close();
				return false;
			}

			System.out.println("Input PW : ");
			PW = sc.next();
			if (PW.equals("quit")) {
				sc.close();
				return false;
			}
				

			try (ObjectInputStream oi = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("LOGIN_DB.bin")))) {

				while (true) {
					Information_class info = (Information_class) oi.readObject();
					if (info == null)
						break;

					if (ID.equals(info.ID)) {
						if (PW.equals(info.PW)) {
							System.out.println("Login successed");
							find_flag = true;
							switch (info.type) {
							case 0:
								Student student = new Student(info.name, info.num, info.score);
								student.student_option();
								break;
							case 1:
								Manager manager = new Manager(info.name, info.num);
								manager.manager_option();
								break;
							case 2:
								Head_Of_Department head = new Head_Of_Department(info.name, info.num);
								head.head_option();
								break;
							}
							sc.close();
							return true;
						} else {
							System.out.println("Password is wrong\n");
							break;
						}
					}
					continue;
				}
				if (find_flag == false) {
					System.out.println("ID doesn't exists");
					continue;
				}
			}

			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public static void logout() {
		login();
	}
}
