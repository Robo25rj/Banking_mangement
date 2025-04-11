package bank_project;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

interface Signup{
	public void signIn();
	
}
public class bank_project {
	static {

		System.out.println("//////////////////////////////////////////");
		System.err.println("==========================================");
		System.err.println("========= Welcome to Bank Wala ===========");
		System.err.println("==========================================");
		System.out.println("//////////////////////////////////////////");
		

	}

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in); 
		Bank_wala ref = new Bank_wala();
		
		System.out.println("Press 1 for sign up");
		System.out.println("Press 2 for exit");
		
		int x=sc.nextInt();
		switch(x) {
		case 1:
			ref.signIn();
			break;
		case 2:
			System.out.println("===Thank you for visiting===");
			System.exit(0);
			break;
		default:
			System.err.println("Invalid input!!! please try again");
			main(null);
		}
		ref.Bank_menu();
		
		
		

		//
		
		System.out.println("========DETAILS======");
		System.out.println("Your Name: " + ref.getName());
		System.out.println("Your Mobile number: " + ref.getMob_num());
	
		// ref.setAc_number();
		System.out.println("Your special genarated AC number is : " + ref.getAc_number());
		System.out.println("Your Bank Branch is: " + ref.branch);
		System.out.println("Your Bank IFSC code is: " + ref.IFSC_code);

		System.out.println("YOr AC balance is: " + ref.getAC_balance()); 
		System.out.println("==========================================");
		


		// ref.nextLine()--->to get new line
		// System.err.println("err sentence")
		// do recursion
	}

}

class Bank_wala implements Signup
{
	static private String name;
	static private long Mob_num = 899822534l;
	static private String Ac_number;
	String branch;
	String IFSC_code = "UBIN5795";
	static private double AC_balance;
	static private String email;
	static private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMob_num() {
		return Mob_num;
	}

	public void setMob_num() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Plz enter your mobile number");
		Mob_num = sc.nextLong();
		if (Mob_num > 999999999 && Mob_num < 10000000000l) {
			System.out.println("Mobile number is valid");
		} else {
			System.err.println("MObile number is Invalid..!!  Try Again");
			setMob_num();
		}
       ////sc.close();
	}

	public String getAc_number() {

		return Ac_number;
	}

	public void setAc_number() {

		Random r = new Random();
		int Ac_number = r.nextInt(10000);
		if (Ac_number > 999) {
			this.Ac_number = "1001" + Ac_number + "UBIN";
			System.out.println("Your special genarated AC number is : 1001" + Ac_number + "UBIN");
			

		} else {
			System.out.println("Try again");

			setAc_number();
		}

	}

	public double getAC_balance() {
		return AC_balance;
	}

	public void setAC_balance(double AC_balance) {
		this.AC_balance = AC_balance;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		//System.out.println(email.endsWith("@gmail.com"));
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void signIn() {
		Scanner ref = new Scanner(System.in);
		System.out.println("Plz enter ur name..");
		name = ref.nextLine();

		setMob_num();
		setAc_number();

		System.out.println("plz enter branch name..");
		branch = ref.nextLine();

		System.out.println("plz enter AC balance ");
		AC_balance = ref.nextDouble();
		ref.nextLine();

		System.out.println("plz enter your E-mail ID..");
		email = ref.nextLine();

		System.out.println("plz create STRONG password..");
		password = ref.nextLine();

		System.out.println("Sign up is completed successfully ..");
		System.out.println("Plz Proceed for login..");

		login();
		 //ref.close();

	}

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================================");
		System.out.println("click 1 to use contact number and password for login");
		System.out.println("Click 2 to use contact number and AC number for login");
		System.out.println("Click 3 to use E-mail and password for login");
		System.out.println("Click 4 to use e-mail  and AC number for login");
		System.out.println("==========================================");
		try {
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println("plz enter your contact number...");
			long contact = sc.nextLong();
			sc.nextLine();

			System.out.println("Plz enter your password...");
			String pass = sc.nextLine();

			if (this.Mob_num == contact && this.password.equals(pass)) {
				System.out.println("Login Successful... :)");

			} else {
				System.err.println("Login credentials are incorect....TRY AGAIN!!");
				login();

			}

		} else if (n == 2) {
			System.out.println("plz enter your contact number...");
			long contact = sc.nextLong();
			sc.nextLine();

			System.out.println("Plz enter your Genarated AC number...");
			String Account_num = sc.nextLine();

			if (this.Mob_num == contact && this.Ac_number.equals(Account_num)) {
				System.out.println("Login Successful... :)");

			} else {
				System.err.println("Login credentials are incorect....TRY AGAIN!!");
				login();

			}

		} else if (n == 3) {
			sc.nextLine();
			System.out.println("plz enter your E-mail Id...");
			String E_ID = sc.nextLine();

			System.out.println("Plz enter your Password...");
			String pass = sc.nextLine();

			if (this.email.equals(E_ID) && this.password.equals(pass)) {
				System.out.println("Login Successful... :)");

			} else {
				System.err.println("Login credentials are incorect....TRY AGAIN!!");
				login();

			}

		} else if (n == 4) {
			sc.nextLine();
			System.out.println("plz enter your E-mail id...");
			String E_id = sc.nextLine();

			System.out.println("Plz enter your Genarated AC number...");
			String Account_num = sc.nextLine();

			if (this.email.equals(E_id) && this.Ac_number.equals(Account_num)) {
				System.out.println("Login Successful... :)");

			} else {
				System.err.println("Login credentials are incorect....TRY AGAIN!!");
				login();

			}

		} else {
			System.err.println("===Invalid inpute....plz try again!!!===");
			login();
		}
		}
		catch(InputMismatchException e) {
			System.out.println("input is invalid....try again!!!");
			login();
			
		}
		////sc.close();
	}

	public void Bank_menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================================");
		System.out.println("welcome to our  bank");
		System.out.println("press 1 for deposit money into AC");
		System.out.println("press 2 for withdraw moeny from AC");
		System.out.println("press 3 for checking Ac balance");
		System.out.println("press 4 for fixed deposit");
		System.out.println("press 5 for passbook print");
		System.out.println("press 6 for loans facility");
		System.out.println("press 7 for Transactions");
		System.out.println("press 8 for Exit");
		try {
		int x = sc.nextInt();
		switch (x) {
		case 1:
			Deposite dept = new Deposite();
			dept.deposite();
			break;
		case 2:
			withdraw w =new withdraw();
			w.Withdraw();
			break;
		case 3:
			checking check=new checking();
			check.check_balance();
			break;
		case 4:
			fixedDeposit fix=new fixedDeposit();
			fix.FX_deposit();
			break;
		
		case 5:
			printPassbook passbook=new printPassbook();
			System.out.println(passbook);
			break;
			
		case 6:
			loans lon=new loans();
			lon.Loans();
			break;
			
		case 7:
			transaction tranx= new transaction();
			tranx.Transaction();
			break;
			
		case 8:
			System.out.println("Thank You for visiting");
			System.exit(0);
			break;
		default:
			System.err.println("Try Again!!!");
			Bank_menu();
			break;

		}
		}
		catch(InputMismatchException e) {
			System.out.println("worng inpute!!! plzz enter number as input");
			Bank_menu();
		}
		Bank_menu();
	//sc.close();

	}

}

class Deposite extends Bank_wala {

	public void deposite() {
		Scanner sc = new Scanner(System.in);
		double money;
		System.out.println("enter the amount to be deposited..");
		money = sc.nextDouble();
	
	    setAC_balance(getAC_balance()+money);
		//double account_balance = getAC_balance()+money;
		//setAC_balance(money);
		//setAC_balance(getAC_balance() + money);
		System.out.println("AC balance after deposit: " + getAC_balance());

		Bank_menu();
		//sc.close();
		

	}

}

class withdraw extends Bank_wala {
	public void Withdraw() {
		Scanner sc = new Scanner(System.in);
		double money;

		System.out.println("enter the amount to be withdraw..");
		money = sc.nextDouble();
		double withdraw = this.getAC_balance()-money;
		
		setAC_balance(withdraw);
		System.out.println("AC balance after deposit: " + getAC_balance());

		Bank_menu();

		//sc.close();

	}
}

class checking extends Bank_wala {
	public void check_balance() {
		System.out.println("Ac holder name: " +getName());
		System.out.println("AC holder's unique AC number: " +getAc_number());
		System.out.println("AC holders Bank balance: " +getAC_balance());
		Bank_menu();
	}
}

class fixedDeposit extends Bank_wala {
	public void FX_deposit() {
		// logic for deposit with new variable
		Scanner sc = new Scanner(System.in);
		double fixedDeposit=0.0;
		System.out.println("Enter the amount you want to Fixed deposite");
		 double money=sc.nextDouble();
		fixedDeposit=fixedDeposit+money;
		System.out.println("Your Fixed Deposit Amount is:.."+fixedDeposit);
		//sc.close();
		
		
	}
}

class printPassbook extends Bank_wala {
	
    
	
	@Override
	public String toString() {
		return Passbook() + "";

	}

	public String Passbook() {
		Bank_wala b1=new Bank_wala();
 
		System.out.println("========PASSBOOK DETAILS======");
		System.out.println("YOUR NAME " +b1.getName());
		System.out.println("REGISTRED MOBILE NUMBER: " +b1.getMob_num());

		System.out.println(" AC NUMBER : " +b1.getAc_number());
		System.out.println("BRANCH OF BANK: " + b1.branch);
		System.out.println(" IFSC CODE: " +b1.IFSC_code);
	

		System.out.println(" AC balance : $" +b1.getAC_balance());
		System.out.println("==========================================");
		// make details
		return "";

	}
}

class loans extends Bank_wala {
	public void Loans() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================================");
		System.out.println("press 1 for Home loan");
		System.out.println("press 2 for Car loan");
		System.out.println("press 3 for edjucation loan");
		System.out.println("press 4 for self loan");
		System.out.println("press 0 for go back to bank menu");
		System.out.println("==========================================");
		int x = sc.nextInt();

		switch (x) {
		case 1:
			Homeloan ref = new Homeloan();
			ref.home_loan();

			break;
		case 2:
			Carloan ref1 = new Carloan();
			ref1.car_loan();
			break;
		case 3:
			educationloan ref2 = new educationloan();
			ref2.education_loan();
			break;
		case 4:
			selfloan ref3 = new selfloan();
			ref3.self_loan();
			break;
		case 0:
			Bank_menu();
			break;
		default:
			System.err.println("Try Again!!!");
			Loans();
			break;
		}
		Loans();
		//sc.close();

	}

}
class transaction extends Bank_wala{
	
	
	public void Transaction() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter amount for transactions: ");
		double amount=sc.nextDouble();
	
		sc.nextLine();
		System.out.println("enter 12 digit AC number where u want to send amount:  ");
		String Ac_num=sc.nextLine();
		
		
		if(Ac_num !=null && Ac_num.length()==12) 
		{
			System.out.println("Ac number is valid...");
		}
		else {
			System.out.println("you are entering null value or no following instructions..");
		}
		
		this.setAC_balance(this.getAC_balance()-amount);
		
		System.out.println("=========================================");
		
		System.out.println("Amount deducted from AC balance: "+amount);
		
		System.out.println("=========================================");
		
		System.out.println("AC balance after transaction: "+getAC_balance());
		
		
	}
}

class Homeloan extends loans
{
	public void home_loan() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==========================================");
		double salary;
		System.out.println("plz enter ur monthly salary");
		salary=sc.nextDouble();
		
		if(salary>50000) {
		 System.out.println("You are eligible for Home loan..plz procced further");
		 
		 System.out.print("Enter loan amount: $");
	        double loanAmount = sc.nextDouble();
	        
	        System.out.print("Enter loan term (in years): ");
	        int loanTermInYears = sc.nextInt();
	        double annualInterestRate; 
	        
	        if(loanTermInYears>20) {
	        	System.out.print(" annual interest rate (in percentage) will be: ");
	        	 annualInterestRate = 10;
	
	        }
	        else {
	        	System.out.println("Annual interest rate will be: ");
	            annualInterestRate = 5;
	        	
	        }
	        
	            // Monthly interest rate calculation
	            double monthlyInterestRate = annualInterestRate / 100 / 12;

	            // Number of monthly payments calculation
	            int numberOfPayments = loanTermInYears * 12;

	            // Monthly payment calculation using the formula for a fixed-rate mortgage
	            double monthlyPayment = (loanAmount * monthlyInterestRate) /
	                    (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

	            System.out.println("\nLoan Summary:");
	            System.out.println("Loan Amount: $" + loanAmount);
	            System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
	            System.out.println("Loan Term: " + loanTermInYears + " years");
	            System.out.println("Monthly Payment: $" + monthlyPayment);	
		}
		else {
			System.err.println("Your are not eligible for home loan...we are sorry!!");
			Loans();
		}
		
		

	}

}

class Carloan extends loans {
	public void car_loan() {
		System.out.println("==========================================");
		Scanner sc=new Scanner(System.in);
		double salary;
		System.out.println("plz enter ur monthly salary");
		salary=sc.nextDouble();
		
		if(salary>50000) {
		 System.out.println("You are eligible for Car loan..plz procced further");
		 
		 System.out.print("Enter loan amount: $");
	        double loanAmount = sc.nextDouble();
	        
	        System.out.print("Enter loan term (in years): ");
	        int loanTermInYears = sc.nextInt();
	        double annualInterestRate; 
	        
	        if(loanTermInYears>20) {
	        	System.out.print(" annual interest rate  will be 15%: ");
	        	 annualInterestRate = 15;
	
	        }
	        else {
	        	System.out.println("Annual interest rate will be 9%: ");
	            annualInterestRate = 9;
	        	
	        }
	        
	            // Monthly interest rate calculation
	            double monthlyInterestRate = annualInterestRate / 100 / 12;

	            // Number of monthly payments calculation
	            int numberOfPayments = loanTermInYears * 12;

	            // Monthly payment calculation using the formula for a fixed-rate mortgage
	            double monthlyPayment = (loanAmount * monthlyInterestRate) /
	                    (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

	            System.out.println("\nLoan Summary:");
	            System.out.println("Loan Amount: $" + loanAmount);
	            System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
	            System.out.println("Loan Term: " + loanTermInYears + " years");
	            System.out.println("Monthly Payment: $" + monthlyPayment);	
		}
		else {
			System.err.println("Your are not eligible for home loan...we are sorry!!");
			Loans();
		}
		

	}

}

class educationloan extends loans {
	public void education_loan() {
		System.out.println("==========================================");
		Scanner sc=new Scanner(System.in);
		int age ;
		System.out.println("plz enter ur age");
		age=sc.nextInt();
		
		if(age<21) {
		 System.out.println("You are eligible for education loan..plz procced further");
		 
		 System.out.print("Enter loan amount: $");
	        double loanAmount = sc.nextDouble();
	        
	        System.out.print("Enter loan term (in years): ");
	        int loanTermInYears = sc.nextInt();
	        double annualInterestRate; 
	        
	        if(loanTermInYears>20) {
	        	System.out.print(" annual interest rate (in percentage) will be: ");
	        	 annualInterestRate = 5;
	
	        }
	        else {
	        	System.out.println("Annual interest rate will be: ");
	            annualInterestRate = 9;
	        	
	        }
	        
	            // Monthly interest rate calculation
	            double monthlyInterestRate = annualInterestRate / 100 / 12;

	            // Number of monthly payments calculation
	            int numberOfPayments = loanTermInYears * 12;

	            // Monthly payment calculation using the formula for a fixed-rate mortgage
	            double monthlyPayment = (loanAmount * monthlyInterestRate) /
	              
	           (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

	            System.out.println("==========================================");
	            System.out.println("\nLoan Summary:");
	            System.out.println("Loan Amount: $" + loanAmount);
	            System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
	            System.out.println("Loan Term: " + loanTermInYears + " years");
	            System.out.println("Monthly Payment: $" + monthlyPayment);	
		}
		else {
			System.err.println("Your are not eligible for home loan...we are sorry!!");
			Loans();
		}
		

	}
}

class selfloan extends loans {
	public void self_loan() {
		
		Scanner sc=new Scanner(System.in);
		double salary;
		System.out.println("plz enter ur monthly salary");
		salary=sc.nextDouble();
		
		if(salary>50000) {
		 System.out.println("You are eligible for self loan..plz procced further");
		 
		 System.out.print("Enter loan amount: $");
	        double loanAmount = sc.nextDouble();
	        
	        System.out.print("Enter loan term (in years): ");
	        int loanTermInYears = sc.nextInt();
	        double annualInterestRate; 
	        
	        if(loanTermInYears>20) {
	        	System.out.print(" annual interest rate (in percentage) will be: ");
	        	 annualInterestRate = 7;
	
	        }
	        else {
	        	System.out.println("Annual interest rate will be: ");
	            annualInterestRate = 5;
	        	
	        }
	        
	            // Monthly interest rate calculation
	            double monthlyInterestRate = annualInterestRate / 100 / 12;

	            // Number of monthly payments calculation
	            int numberOfPayments = loanTermInYears * 12;

	            // Monthly payment calculation using the formula for a fixed-rate mortgage
	            double monthlyPayment = (loanAmount * monthlyInterestRate) /
	                    (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

	            System.out.println("==========================================");
	            System.out.println("\nLoan Summary:");
	            System.out.println("Loan Amount: $" + loanAmount);
	            System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
	            System.out.println("Loan Term: " + loanTermInYears + " years");
	            System.out.println("Monthly Payment: $" + monthlyPayment);	
		}
		else {
			System.err.println("Your are not eligible for home loan...we are sorry!!");
			Loans();
		}
		

	}

}
