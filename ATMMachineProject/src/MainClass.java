import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		AtmOperationInterf op=new AtmOperationImpl();		
		//Step 1 - Validation 
		int atmnumber=12345;
		int atmpin=123;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome ATM Machine!!!!");
		System.out.print("Enter ATM Number :");
		int atmNumber=sc.nextInt();
		System.out.print("Enter Pin :");
		int pin=sc.nextInt();
		System.out.println(" ");
		if((atmnumber==atmNumber)&&(atmpin==pin)) {
			while(true) {
				System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
				System.out.println(" ");
				System.out.println("Enter Choice :");
				int ch=sc.nextInt();
				if(ch==1) {
					op.viewBalance();
				}
				else if(ch==2) {
					System.out.println("Enter amount to withdraw:");
					double withdrawAmount=sc.nextDouble();
					op.WithdrawAmount(withdrawAmount);
					System.out.println(" ");
				}
				else if(ch==3) {
					System.out.println("Enter amount to deposit:");
					double depositAmount=sc.nextDouble();
					op.depositAmount(depositAmount);
					System.out.println(" ");
				}
				else if(ch==4) {
					
					op.viewMiniStatement();
					System.out.println(" ");
				   	System.out.println("Enter 1 to print and end");
				   	int p=sc.nextInt();
				   	if(p==1) {
				   		//String n=op.viewMiniStatement();
				   		try {
							PrintStream ps= new PrintStream(new File("D:\\Mini statement\\Ministatement2.txt"));
							System.setOut(ps);
							ps.print(op.viewMiniStatement());					
							System.out.println("\nThanks for using ATM\n collect your ATM card");
							System.exit(p);
							}
						catch(FileNotFoundException ft) {
							System.out.println(ft);
						}
				   	
				   	}
				   	else {
				   		continue;
				   	}
				}
				else if(ch==5) {
					System.out.println("Collect your ATM card\nThank you for using ATM Machine");
					System.exit(0);
				}
				else {
					System.out.println("Please enter correct choice");
				}
			}
		}
		else {
			System.out.println("Incorrect Atm number  or pin");
			System.exit(0);
		}
		sc.close();	
		
	}
}
