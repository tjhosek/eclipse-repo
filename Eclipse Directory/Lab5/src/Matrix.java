/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 2/14/2020
 * C212
 * 
 * A class that implements functions for a two dimensional array
 */


public class Matrix
{
	private boolean[][] matrix;
	private final int NUMROW;
	private final int NUMCOL;
	
	public Matrix()
	{
		this.NUMROW = 0;
		this.NUMCOL = 0;
		this.matrix = new boolean[0][0];
	}
	
	public Matrix(boolean[][] m)
	{
		this.NUMROW = m.length;
		this.NUMCOL = m[0].length;
		this.matrix = m;
	}
	
	public String toString()
	{
		/**
		 * Returns a string representation of the matrix
		 */
		String stringRep = "[";
		for(int i = 0; i < this.NUMROW; i++)
		{
			if(i > 0)
			{
				stringRep = stringRep + " "; //Initial indent on each line except the first
			}
			for(int j = 0; j < this.NUMCOL; j++)
			{
				if(this.matrix[i][j])
				{
					stringRep = stringRep + "1"; //1 for a true cell
				}
				else
				{
					stringRep = stringRep + "0"; //0 for a false cell
				}
				if(j != this.NUMCOL - 1)
				{
					stringRep = stringRep + ", "; //adds a , for each cell except the last on each row
				}
			}
			if(i < this.NUMROW - 1)
			{
				stringRep = stringRep + "\n"; //adds a new line for each new row except the last
			}
		}
		stringRep = stringRep + "]"; //closing bracket
		return stringRep;
	}
	
	public Matrix transposeMatrix()
	{
		/**
		 * Returns a transposed version of the matrix
		 */
		boolean[][] transposedArray = new boolean[this.NUMCOL][this.NUMROW];
		for(int i = 0; i < NUMROW; i++)
		{
			for(int j = 0; j < NUMCOL; j++)
			{
				transposedArray[j][i] = this.matrix[i][j];
			}
		}
		Matrix transposedMatrix = new Matrix(transposedArray);
		return transposedMatrix;
	}
	
	public boolean isSquareMatrix()
	{
		/**
		 * Returns true if the matrix is square, that is if the number of columns and the number of rows are equal
		 */
		return this.NUMROW == this.NUMCOL;
	}
	
	public Matrix rotateClockwise()
	{
		/**
		 * Rotatest the matrix 90 degrees to the right
		 */
		boolean[][] rotatedArray = new boolean[NUMCOL][NUMROW];
		for(int i = 0; i < NUMROW; i++)
		{
			for(int j = 0; j < NUMCOL; j++)
			{
				rotatedArray[j][i] = this.matrix[NUMROW - i - 1][j];
			}
		}
		
		Matrix rotatedMatrix = new Matrix(rotatedArray);
		return rotatedMatrix;
	}
	
	public Matrix rotateCounterClockwise()
	{
		/**
		 * Rotates the matrix 90 degrees to the left
		 */
		boolean[][] rotatedArray = new boolean[NUMCOL][NUMROW];
		for(int i = 0; i < NUMROW; i++)
		{
			for(int j = 0; j < NUMCOL; j++)
			{
				rotatedArray[j][i] = this.matrix[i][NUMCOL - j - 1];
			}
		}
		
		Matrix rotatedMatrix = new Matrix(rotatedArray);
		return rotatedMatrix;
	}
	
	public String percentageTrue()
	{
		/**
		 * Returns the percentage of elements in the matrix that are true, rounding up to the nearest whole percent.
		 */
		int numElements = this.NUMCOL*this.NUMROW;
		int numTrue = 0;
		for(int i = 0; i < NUMROW; i++)
		{
			for(int j = 0; j < NUMCOL; j++)
			{
				if(this.matrix[i][j])
				{
					numTrue = numTrue + 1;
				}
			}
		}
		double percentage = 100.0*numTrue/numElements;
		
		return (int)Math.ceil(percentage) + "%";
	}
	
	public boolean isEqual(Matrix m)
	{
		/**
		 * Returns false if the passed matrix does not have the same number of rows or columns, or if any of the elements in the passed matrix are not equal to their respective elements in the called matrix.
		 * Returns true otherwise
		 */
		//Dimension Mismatch
		if(this.NUMROW != m.NUMROW || this.NUMCOL != m.NUMCOL)
		{
			return false;
		}
		
		for(int i = 0; i < this.NUMROW; i++)
		{
			for(int j = 0; j < this.NUMCOL; j++)
			{
				if(this.matrix[i][j] != m.matrix[i][j])
				{
					//Element mismatch
					return false;
				}
			}
		}
		
		//Matricies are the same
		return true;
	}
}
