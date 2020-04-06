
public class SnapCode extends Code implements Scannable, Comparable<Code>
{
	private int accountNumber;
	public SnapCode(String link, int accountNumber)
	{
		super(link);
		this.accountNumber = accountNumber;
	}
	@Override
	public int compareTo(Code o)
	{
		if(o.getLink() == this.getLink())
		{
			return 0;
		}
		else
		{
			char[] oChars = o.getLink().toCharArray();
			char[] thisChars = this.getLink().toCharArray();
			int lowest = oChars.length > thisChars.length ? thisChars.length : oChars.length;
			for(int i = 0; i < lowest; i++)
			{
				if(oChars[i] > thisChars[i]) 
				{
					return 1;
				}
				else if(oChars[i] < thisChars[i])
				{
					return -1;
				}
			}
			return 0;
		}
	}
	@Override
	public Object[] scan()
	{
		Object[] scanResult = {this.accountNumber, this.getLink()};
		return scanResult;
	}

}
