package Person;

import java.util.Scanner;

import Application.$missing$;

public class Head_Of_Department extends Person {
	// String dep_name; //Department name

	public Head_Of_Department(String name, String number) { // constructor
		super(name, number);
	}

	public boolean handle_transfercredits_apply() { // handle with tranfer_credits applications
		return false;
	}

	public boolean head_option() {
		int menu_option;
		Scanner sc = new Scanner(System.in);

		System.out.println("**********Head Of Department Options**********");
		System.out.println("1. handle with tranfer_credits applications\n" + "2. logout");

		while (true) {
			System.out.print("Insert option: ");
			menu_option = sc.nextInt();
			if (menu_option >= 1 && menu_option <= 2)
				break;
			else
				System.out.println("Wrong input\n");
		}
		switch (menu_option) {
		case 1:
			handle_transfercredits_apply();
		case 2:
			logout();
		}
	}

}