
public class Checkout
{

	public static void main(String[] args)
	{
		Produce bananas = new Produce(5, .5, "Banana", 1);
		PackagedGood bread = new PackagedGood(5, 12, .8, "Whole Wheat Bread", 2);
		Pharmaceutical asprin = new Pharmaceutical(10, 50, false, "Ibuprofen", 3);
		
		Produce apples = new Produce(5, .5, "Apple", 0);
		PackagedGood beans = new PackagedGood(5, 12, .8, "Black Beans", 4);
		Pharmaceutical ibuprofen = new Pharmaceutical(10, 50, false, "Ibuprofen", 3);
		
		Scannable[] scanList = {bananas, bread, asprin};
		for(Scannable product : scanList)
		{
			System.out.println(product.scan());
		}
		
		Comparable[] compareList = {bananas, bread, asprin};
		Comparable[] compareTo = {apples, beans, ibuprofen};
		for(int i = 0; i < compareList.length; i++)
		{
			System.out.println(compareList[i].compareTo(compareTo[i]));
		}
	}

}
