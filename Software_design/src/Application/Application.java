package Application;

import java.util.Scanner;
import Person.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

class Information_class {
	 String ID;
	 String PW;
	 int type;
	 String name;
	 String num;
	 String score;
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
		Information_class info;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("If you want to quit login insert 'quit'");
			System.out.println("Input ID : ");
			ID = sc.nextLine();
			if (ID.equals("quit"))
				return false;
			
			System.out.println("Input PW : ");
			PW = sc.nextLine();
			if (PW.equals("quit"))
				return false;
			
			try (ObjectInputStream oi = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("information.txt")))) {
				info = (Information_class) oi.readObject();
				while (true) {

					if (info == null)
						break;

					if (ID.equals(info.ID)) {
						if (PW.equals(info.PW)) {
							System.out.println("Login successed");
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
					else {
						System.out.println("ID doesn't exists");
						sc.close();
						break;
					}
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
