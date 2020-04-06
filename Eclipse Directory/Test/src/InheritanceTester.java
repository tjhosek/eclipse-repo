
public class InheritanceTester
{

	public static void main(String[] args)
	{
		Grandparent gp = new Grandparent(0);
		Parent p = new Parent(1,1);
		Child c = new Child(2,2);
		System.out.println(gp.toString() + p + c);
	}

}
