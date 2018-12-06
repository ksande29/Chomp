package finalProject;

import java.io.Serializable;

/**
 * Creates Player objects which have a name and a turn
 * Contains methods to toggle the turn, set the Player name, get the Player name, and see if it is a Players turn
 * @author Kate Sanders
 */
public class Player implements Serializable
{
	private static final long serialVersionUID = 1768961841600718600L;
	private String name;
	private boolean hasTurn;
	
	/**
	 * Creates Player objects and defaults turn to false
	 * @param playerName name 
	 */
	public Player (String playerName)
	{
		name = playerName;
		hasTurn = false;
	}
	
	/**
	 * Toggles a player's turn
	 */
	public void toggleTurn()
	{
		if (hasTurn == true)
			hasTurn = false;
		else
			hasTurn = true;
	}
	
	/**
	 * Sets a Player's name
	 * @param String n
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * Gets a Player's name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/** 
	 * Checks if a player has the turn
	 * @return boolean hasTurn
	 */
	public boolean hasTurn()
	{
		return hasTurn;
	}
}
