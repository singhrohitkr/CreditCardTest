package emailApp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailBoxSize;
	private String altEmail;
	
	//Constructor
	
	public Email (String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		System.out.println("Email: "+this.firstName+" "+this.lastName);
		
		// Call a method to set dept, get input from user
		this.department=setDepartment();
		System.out.println("Department: "+this.department);
		
		//set a random password
		System.out.println("Enter the password length: ");
		Scanner inputPass = new Scanner(System.in);
		int passwordLength=inputPass.nextInt();
		
		this.password=randomPass(passwordLength);
		System.out.println("Password: "+password);
	}
	//Set department method
	private String setDepartment() {
		System.out.print("DEPARTMENT CODES: \n1 for Sales\n2 for development\n3 for accounting\n0 for none\nEnter the dept code:");
		Scanner input = new Scanner(System.in);
		int deptChoice=input.nextInt();
		//if(deptChoice==1||deptChoice==2||deptChoice==3) {
		if(deptChoice==1) {return "sales";}
		else if (deptChoice==2) {return "Dev";}
		else if (deptChoice==3) {return "acct";}
		else {return "";}
					
	}
	
	//Generate a random password
	private String randomPass(int length) {
		String passwordSet="ABCDEFGHIGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz1234567890!@#$";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int random= (int)(Math.random() *passwordSet.length());
			password[i]=passwordSet.charAt(random);
		}
		return new String(password);
		
	}
	

}
