import java.util.Scanner;
public class ownProgram {

	public static void main(String[] args) {
		Scanner firstNumber=new Scanner(System.in);
		Scanner secondNumber=new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num1=firstNumber.nextInt();
		System.out.print("Enter a second number: ");
		int num2=secondNumber.nextInt();
		int result=num1+num2;
		System.out.println("Addition of " +num1 +" and " +num2+ " = "+result);
	

	}

}
