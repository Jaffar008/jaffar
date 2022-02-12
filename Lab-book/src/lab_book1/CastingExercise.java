package lab_book1;

public class CastingExercise {

	public static void main(String[] args) {
		byte b=10;
		
		int i=b;//will accepet -automatic type promotion
		
        byte c=i;//will not accept -because lower type cannot be put in higher 
		
		byte d=39;//Typecasting makes it possible to store compatible types
		
		byte d=byte(i);
		
		byte x=10;
		byte y=20;
		 
		byte sum=x+y;//Error is thrown because when two bytes are used in arithmetic operation,the result will be intger
		
		
		

	}

}
