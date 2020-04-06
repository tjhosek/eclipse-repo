
abstract public class Product implements Scannable, Comparable<Product>
{
	protected int barCodeID;
	public Product()
	{
		barCodeID = 0;
	}
	
	public Product(int barCodeID)
	{
		super();
		this.barCodeID = barCodeID;
	}
	
	/**
	 * @return the barCodeID
	 */
	public int getBarCodeID()
	{
		return barCodeID;
	}

	/**
	 * @param barCodeID the barCodeID to set
	 */
	public void setBarCodeID(int barCodeID)
	{
		this.barCodeID = barCodeID;
	}
	
	@Override
	public int compareTo(Product o)
	{
		return this.barCodeID - o.barCodeID;
	}
}