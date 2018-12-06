package finalProject;

import java.io.Serializable;

import javax.swing.JButton;

/**
 * Creates Chocolate objects which have a serialVersionUID, can be eaten or poisoned, a rowNum, columNum, and a button
 * contains methods to see if a chocolate has been eaten, is poison, eat a chocolate,poison a chocolate, get and set
 * column number, row number, and button
 * @author Kate Sanders
 */
public class Chocolate implements Serializable
{
	private static final long serialVersionUID = -5714681517338071155L;
	private boolean eaten = false;
	private boolean poison = false;
	private int rowNum;
	private int columnNum;
	private JButton button;
	
	/**
	 * Shows if a chocolate has been eaten
	 * @return boolean eaten
	 */
	public boolean isEaten()
	{
		return eaten;
	}
	
	/**
	 * Shows if a chocolate is poison
	 * @return boolean poison
	 */
	public boolean isPoison()
	{
		return poison;
	}
	
	/**
	 * Change eaten status of a chocolate
	 * @param boolean eat
	 */
	public void setEaten(boolean eat)
	{
		eaten = eat;
	}
	
	/**
	 * Change poison status of a chocolate
	 * @param boolean pois
	 */
	public void setPoison(boolean pois)
	{
		poison = pois;
	}

	/**
	 * Get the row number of a chocolate
	 * @return int rowNum
	 */
	public int getRowNum()
	{
		return rowNum;
	}
	
	/**
	 * Set the row number of a chocolate
	 * @param int row
	 */
	public void setRowNum(int row)
	{
		rowNum = row;
	}
	
	/**
	 * Get the column number of a chocolate
	 * @return int columnNum
	 */
	public int getColumnNum()
	{
		return columnNum;
	}
	
	/**
	 * Set the column number of a chocolate
	 * @param int column
	 */
	public void setColumnNum(int column)
	{
		columnNum = column;
	}
	
	/**
	 * Set a button for a chocolate
	 * @param JButton b
	 */
	public void setButton(JButton b)
	{
		button = b;
	}
	
	/**
	 * Get the JButton associated with a chocolate
	 * @return JButton button
	 */
	public JButton getButton()
	{
		return button;
	}
}
