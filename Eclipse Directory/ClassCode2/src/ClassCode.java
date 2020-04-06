import java.lang.Object;
import java.util.Scanner;

public class ClassCode {
	
	public static String printHeader()
	{
		return "This is a string";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myV = 70;
		double myD = 23.20;
		char myC = 'A';
		
		System.out.println(myV);
		System.out.println(myD);
		System.out.println((int)myD);
		System.out.println(myC);
		
		System.out.println(myD);
		System.out.println(myD*myD);
		
		System.out.println(myD*myV);
		System.out.println((int)myC);
		System.out.println((char)myV);
		System.out.println((char)177);
		
		System.out.println(printHeader());
		
//		for(int i = 0; i < 256; i++)
//		{
//			System.out.println(i + " " + (char)i);
//		}
		
		System.out.println(Math.sqrt(myV));
		System.out.printf("%.01f", Math.sqrt(myV));
		Scanner sc =  new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(++i);
		System.out.println(i);
	}

}
