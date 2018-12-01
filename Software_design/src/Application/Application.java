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
		Student student;
		Manager manager;
		Head_Of_Department head;
		String ID, PW;
		Information_class info;
		Scanner sc = new Scanner(System.in);
		String quitOption;

		while (true) {
			System.out.println("If you want to quit login insert 'quit'");
			quitOption = sc.nextLine();
			if (quitOption.equals("quit"))
				return false;

			System.out.println("Input ID : ");
			ID = sc.nextLine();

			System.out.println("Input PW : ");
			PW = sc.nextLine();

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
								student = new Student(info.name, info.num, info.score);
								break;
							case 1:
								manager = new Manager(info.name, info.num);
								break;
							case 2:
								head = new Head_Of_Department(info.name, info.num);
								break;
							}
							sc.close();
							return true;
						} else {
							System.out.println("Password is wrong\n");
							continue;
						}
					}
				}
				System.out.println("ID doesn't exists");
				sc.close();
				continue;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public static void logout() {
		login();
	}
}
