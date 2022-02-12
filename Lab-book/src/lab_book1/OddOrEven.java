package lab_book1;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		int num;
		System.out.print("Enter an Integer nnumber:");
		Scanner input=new Scanner(System.in);
		num=input.nextInt();
		if(num%2==0) {
			System.out.println("Entered num is even");
		}
		else {
			System.out.println("Entered number is odd");
		}

	}

}
