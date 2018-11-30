package Person;

public class Head_Of_Department extends Person{
	//String dep_name;			//Department name
	
	
	public Head_Of_Department(String name, String number) { //constructor
		super(name, number);
	}
	public boolean handle_transfercredits_apply() {		//handle with tranfer_credits applications
		return false;	
	}
	
}