import java.lang.Math;

public class primitiveTests {

	public static void main(String[] args) {
		System.out.println('A'*2);
		System.out.println('A'*2.0);
		System.out.println('A'*'A');
		foo('A');
		//bin(65);
		int i = 10;
		int n = (i++)+1;
		System.out.println((i++)+1 % 5);
	}

	public static void foo(int bar)
	{
		System.out.println(bar);
	}
	
	public static void bin(char go)
	{
		System.out.println(go);
	}
}
