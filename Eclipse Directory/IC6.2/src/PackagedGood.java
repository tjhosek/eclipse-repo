
public class PackagedGood extends Product
{
	int price;
	int pieces;
	double salePercent;
	String name;
	
	public PackagedGood()
	{
		super();
		price = 0;
		pieces = 0;
		salePercent = 0;
		name = "";
	}

	public PackagedGood(int price, int pieces, double salePercent, String name, int barCodeID)
	{
		super(barCodeID);
		this.price = price;
		this.pieces = pieces;
		this.salePercent = salePercent;
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice()
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price)
	{
		this.price = price;
	}

	/**
	 * @return the pieces
	 */
	public int getPieces()
	{
		return pieces;
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(int pieces)
	{
		this.pieces = pieces;
	}

	/**
	 * @return the salePercent
	 */
	public double getSalePercent()
	{
		return salePercent;
	}

	/**
	 * @param salePercent the salePercent to set
	 */
	public void setSalePercent(double salePercent)
	{
		this.salePercent = salePercent;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public double scan()
	{
		return price * salePercent;
	}

	
	
}
