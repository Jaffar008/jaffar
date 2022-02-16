package lab_book1;
//Floyds Triangle
import java.util.Scanner;
public class FloydsTriangle {
public static void main(String[] args) {
	int rows,number=1,counter,j;
	Scanner input=new Scanner(System.in);
	System.out.println("enter number of rows for Floyd's Triangle:");
	rows=input.nextInt();
	System.out.println("Floyd's Triangle");
	System.out.println("*****************");
	for(counter=1;counter<=rows;counter++) {
		for(j=1;j<=counter;j++) {
			System.out.println(number+" ");
			number++;
		}
		System.out.println();
	}
}
}
