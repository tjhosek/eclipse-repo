/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 
 * Conway's game of life. Initialized with a 2d boolean array, where true cells count as filled for the purpose of determining reproduction
 * 
 */

public class GameofLife
{
	private boolean[][] board;
	private final int NUMROW;
	private final int NUMCOL;
	
	
	public GameofLife(boolean[][] initialBoard)
	{
		NUMROW = initialBoard.length;
		NUMCOL = initialBoard[0].length;
		board = new boolean[NUMROW][NUMCOL];
		
		// Initializing the new board
		for(int i = 0; i < NUMROW; i++)
		{
			for(int j = 0; j < NUMCOL; j++)
			{
				board[i][j] = initialBoard[i][j];
			}
		}
	}
	
	public String toString()
	{
		/**
		 * Returns the string representation of the board, with o representing a filled space and + representing an empty space.
		 */
		String boardString = "";
		for(boolean[] row : this.board)
		{
			for(boolean cell : row)
			{
				if(cell)
				{
					boardString = boardString + "o ";
				}
				else
				{
					boardString = boardString + "+ ";
				}
			}
			boardString = boardString + "\n";
		}
		return boardString;
	}
	
	public void grow(int generation, int freqPrint)
	{
		/**
		 * shows the progression of the next number of specified generations, printing the results at freqPrint
		 */
		int neighboringCellCount;
		// A new board that is refreshed and then replaces the old board after every cell has been checked.
		// This prevents the newly generated/dead cells from interfering with the current generation
		boolean[][] newBoard = new boolean[NUMROW][NUMCOL]; 
		for(int i = 1; i <= generation; i++)
		{
			// Reseting the board
			newBoard = new boolean[NUMROW][NUMCOL];
			for(int j = 0; j < NUMROW; j++)
			{
				for(int k = 0; k < NUMCOL; k++)
				{
					// Checking the number of neighboring cells
					neighboringCellCount = checkNeighbor(j, k);
					if(neighboringCellCount == 3)
					{
						// If the number of neighboring cells is 3, then a new cell is generated
						newBoard[j][k] = true;
					}
					else if(neighboringCellCount < 2 || neighboringCellCount > 3)
					{
						// If the number of neighboring cells is less than 2 the cell dies from lonliness
						// If the number of neighboring cells is greater than 3 the cell dies from overcrowding
						newBoard[j][k] = false;
					}
					else
					{
						// If neither of these apply the cell stays as it is
						newBoard[j][k] = board[j][k];
					}
				}
			}
			
			// Making the new board the real one
			board = newBoard;
			
			// Printing the board if the frequency calls for it
			if(i % freqPrint == 0)
			{
				System.out.println(this.toString());
			}
		}
	}
	
	private int checkNeighbor(int x, int y)
	{
		/**
		 * Returns the number of occupied blocks around x, y
		 */
		int numTrue = 0;
		for(int i = x - 1; i <= x + 1; i++)
		{
			for(int j = y - 1; j <= y + 1; j++)
			{
				if(i >= 0 && j >= 0 && i < NUMROW && j < NUMCOL && !(i == x && j == y))
				{
					// if i and j are inside the bounds of the board and they are not equal to the point they are centered around, then the space is checked.
					if(board[i][j])
					{
						numTrue += 1;
					}
				}
			}
		}
		return numTrue;
	}
}
