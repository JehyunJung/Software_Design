package Person;

import java.util.Scanner;

import Application.$missing$;

public class Manager extends Person { // faculty class

	public Manager(String name, String number) {
		super(name, number);
	}

	public void add_bull() { // post bull
		
	}

	public void del_bull() { // delete bull

	}

	public boolean handle_first_apply() { // record first result

	}

	public boolean handle_final_apply() { // record final result

	}

	public boolean handle_transfercredit_apply() { // record transfer_credit

	}

	public boolean see_dispatch_rec() { // see dispatch record

	}

	public boolean manager_option() {
		int menu_option;
		Scanner sc = new Scanner(System.in);

		System.out.println("**********Manager Options**********");
		System.out.println("1. post bull\n" + "2. delete bull\n" + "3. handle_first_apply\n"
				+ "4. record final result\n" + "5. record transfer result\n" + "6. see dispatch record" + "7. logout");

		while (true) {
			System.out.print("Insert option: ");
			menu_option = sc.nextInt();
			if (menu_option >= 1 && menu_option <= 7)
				break;
			else
				System.out.println("Wrong input\n");
		}
		switch (menu_option) {
		case 1:
			add_bull();
		case 2:
			del_bull();
		case 3:
			handle_first_apply();
		case 4:
			handle_final_apply();
		case 5:
			handle_transfercredit_apply();
		case 6:
			see_dispatch_rec();
		case 7:
			logout();
		}
	}

}