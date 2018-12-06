package finalProject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Creates GameBoard objects which have a serialVersionUID; number of rows, columns and a total number of chocolates;
 * and a board.
 * Contains methods to add Chocolate to the board and to set and get the number of rows and columns, and  to get the
 * total amount of Chocolates in the board and to get the board.
 * @author Kate Sanders
 */
public class GameBoard implements Serializable
{
	private static final long serialVersionUID = -992654250547668529L;
	private int rows;
	private int columns;
	private int total;
	private ArrayList<Chocolate> board = new ArrayList<Chocolate>();
	
	/**
	 * Constructs GameBoard objects
	 * @param int r - rows in the board
	 * @param int c - columns in the board
	 */
	public GameBoard (int r, int c)
	{
		rows = r;
		columns = c;
		total = rows*columns;
		addChocolate();
	}
	
	/**
	 * Adds a Chocolate to the board
	 */
	public void addChocolate()
	{
		int rowCount = 1;
		int columnCount = 1;
		for (int i = 0; i < total; i++)
		{
			Chocolate choc = new Chocolate();
			
			//assign row number
			choc.setRowNum(rowCount);
			if ((i+1) % columns == 0)
				rowCount++;
			
			//assign column number
			choc.setColumnNum(columnCount);
			if ((i+1) % columns == 0)
				columnCount = 1;
			else
				columnCount++;
	
			//make poison square
			if (i == (total - columns))
				choc.setPoison(true);
			
			//add square to the board
			board.add(choc);
		} 
	}

	/**
	 * Get the number of rows on the board
	 * @return int rows
	 */
	public int getRows() 
	{
		return rows;
	}

	/**
	 * Set the number of rows on the board
	 * @param int rows
	 */
	public void setRows(int rows) 
	{
		this.rows = rows;
	}

	/**
	 * Get the number of columns on the board
	 * @return int columns
	 */
	public int getColumns() 
	{
		return columns;
	}

	/**
	 * Set the number of columns on the board
	 * @param int columns
	 */
	public void setColumns(int columns) 
	{
		this.columns = columns;
	}

	/**
	 * Get the total number of Chocolates on the board
	 * @return int total
	 */
	public int getTotal() 
	{
		return total;
	}

	/**
	 * Get the board
	 * @return ArrayList<Chocolate> board
	 */
	public ArrayList<Chocolate> getBoard() 
	{
		return board;
	}
}
