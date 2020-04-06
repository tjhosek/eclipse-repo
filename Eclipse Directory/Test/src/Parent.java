
public class Parent extends Grandparent
{
	protected int bar;
	public Parent(int foo, int bar)
	{
		super(foo);
		this.bar = bar;
	}
	
	public int getBar()
	{
		return this.bar;
	}
}
