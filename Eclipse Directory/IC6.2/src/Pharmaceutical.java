
public class Pharmaceutical extends Product
{
	int price;
	int amount;
	boolean perscription;
	String name;
	
	public Pharmaceutical()
	{
		price = 0;
		amount = 0;
		perscription = false;
		name = "";
	}

	public Pharmaceutical(int price, int amount, boolean perscription, String name, int barCodeID)
	{
		super(barCodeID);
		this.price = price;
		this.amount = amount;
		this.perscription = perscription;
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
	 * @return the amount
	 */
	public int getAmount()
	{
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the perscription
	 */
	public boolean isPerscription()
	{
		return perscription;
	}

	/**
	 * @param perscription the perscription to set
	 */
	public void setPerscription(boolean perscription)
	{
		this.perscription = perscription;
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
		return price * amount;
	}

}
