package finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

/**
 * Create the Chomp game GUI
 * @author Kate Sanders
 *
 */
public class GameGui extends JFrame 
{
	private ArrayList<Chocolate> squares;
	private GameBoard board;							
	private Player player1 = new Player("player 1");	
	private Player player2 = new Player("player 2");	
	private int rows = 0;
	private int columns = 0;
	private JPanel contentPane;
	private JTextField textEnterRows;
	private JTextField textEnterColumns;	
	private JLabel lblChocolateGame;
	private JPanel optionsPanel;
	private JPanel panelCenter;
	private JPanel panelInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GameGui frame = new GameGui();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameGui() 
	{
		setTitle("Chomp");
		setUpMainFrame();
		lblChocolateGame = makeMainMessage();
		panelCenter = makeCenterDisplay();
		
		//make input panel
		panelInput = makeInputPanel();
		makePlayersLabel(panelInput);
		makePlayer1Label(panelInput);
		JTextField txtEnterP1Name = makeTxtEnterP1Name(panelInput);
		makeLblPlayer2(panelInput);
		JTextField txtEnterP2Name = makeTextEnterP2Name(panelInput);
		makeBoardSizeLabel(panelInput);
		makeRowsLabel(panelInput);
		makeTxtEnterRows(panelInput);
		makeLblColumns(panelInput);
		makeTxtEnterColumns(panelInput);
		//blank label for spacing
		JLabel label_3 = new JLabel("");
		panelInput.add(label_3);
		makeEnterButton(lblChocolateGame, panelCenter, panelInput, txtEnterP1Name, txtEnterP2Name); 
		makeLoadButton();
		
		//make options panel
		optionsPanel = makeOptionsPanel(panelCenter);
		makeOptionsLbl(optionsPanel);
		//blank label for spacing
		JLabel lblSpace = new JLabel("");
		optionsPanel.add(lblSpace);
		makeSaveBtn(optionsPanel);
		makeNewGameBtn(optionsPanel);
		
		//make instructions panel
		JPanel panelInstructions = makeInstructionPanel();
		makeInstructionsLabel(panelInstructions);
		makeInstructions(panelInstructions);
	}

	private void setUpMainFrame() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(0, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private JLabel makeMainMessage() 
	{
		JLabel lblChocolateGame = new JLabel("Chomp");
		lblChocolateGame.setBorder(new EmptyBorder(20, 0, 20, 0));
		lblChocolateGame.setForeground(new java.awt.Color(255, 255, 255));
		lblChocolateGame.setOpaque(true);
		lblChocolateGame.setBackground(new java.awt.Color(102, 153, 102));
		lblChocolateGame.setFont(new Font("Viner Hand ITC", Font.PLAIN, 70));
		lblChocolateGame.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblChocolateGame, BorderLayout.NORTH);
		return lblChocolateGame;
	}
	
	private JPanel makeCenterDisplay() 
	{
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new java.awt.Color(255, 255, 255));
		panelCenter.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		return panelCenter;
	}
	
	
	//input panel methods
	private JPanel makeInputPanel() 
	{
		JPanel panelInput = new JPanel();
		panelInput.setBackground(new java.awt.Color(102, 153, 102));
		panelInput.setBorder(new EmptyBorder(0, 30, 0, 30));
		contentPane.add(panelInput, BorderLayout.WEST);
		panelInput.setLayout(new GridLayout(14, 1, 10, 5));
		return panelInput;
	}
	
	private void makePlayersLabel(JPanel panelInput) 
	{
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setOpaque(true);
		lblPlayers.setBackground(new java.awt.Color(255, 255, 255));
		lblPlayers.setForeground(new java.awt.Color(0, 0, 0));
		lblPlayers.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblPlayers.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
		lblPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(lblPlayers);
	}

	private void makePlayer1Label(JPanel panelInput) 
	{
		JLabel lblPlayer = new JLabel("Player 1 name: ");
		lblPlayer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblPlayer.setForeground(new java.awt.Color(255, 255, 255));
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(lblPlayer);
	}
	
	private JTextField makeTxtEnterP1Name(JPanel panelInput) 
	{
		JTextField txtEnterP1Name = new JTextField();
		txtEnterP1Name.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtEnterP1Name.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterP1Name.setText("");
		panelInput.add(txtEnterP1Name);
		return txtEnterP1Name;
	}
	
	private void makeLblPlayer2(JPanel panelInput) 
	{
		JLabel lblPlayer_2 = new JLabel("Player 2 name: ");
		lblPlayer_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblPlayer_2.setForeground(new java.awt.Color(255, 255, 255));
		lblPlayer_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(lblPlayer_2);
	}
	
	private JTextField makeTextEnterP2Name(JPanel panelInput) 
	{
		JTextField txtEnterP2Name = new JTextField();
		txtEnterP2Name.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtEnterP2Name.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterP2Name.setText("");
		panelInput.add(txtEnterP2Name);
		return txtEnterP2Name;
	}

	private void makeBoardSizeLabel(JPanel panelInput) 
	{
		//label for spacing
		JLabel label_2 = new JLabel("");
		panelInput.add(label_2);
		JLabel lblBoardSize = new JLabel("Board Size");
		lblBoardSize.setBackground(new java.awt.Color(255, 255, 255));
		lblBoardSize.setOpaque(true);
		lblBoardSize.setForeground(new java.awt.Color(0, 0, 0));
		lblBoardSize.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBoardSize.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblBoardSize.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
		panelInput.add(lblBoardSize);
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void makeRowsLabel(JPanel panelInput) 
	{
		JLabel lblRows = new JLabel("Rows: (3 - 15)");
		lblRows.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblRows.setForeground(new java.awt.Color(255, 255, 255));
		panelInput.add(lblRows);
		lblRows.setHorizontalAlignment(SwingConstants.CENTER);
		lblRows.setHorizontalTextPosition(SwingConstants.CENTER);
	}
	
	private void makeTxtEnterRows(JPanel panelInput) 
	{
		textEnterRows = new JTextField();
		textEnterRows.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textEnterRows.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textEnterRows);
		textEnterRows.setColumns(10);
	}
	
	private void makeLblColumns(JPanel panelInput) 
	{
		JLabel lblColumns = new JLabel("Columns: (3 - 15)");
		lblColumns.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblColumns.setForeground(new java.awt.Color(255, 255, 255));
		panelInput.add(lblColumns);
		lblColumns.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumns.setHorizontalTextPosition(SwingConstants.CENTER);
	}
	
	private void makeTxtEnterColumns(JPanel panelInput) 
	{
		textEnterColumns = new JTextField();
		textEnterColumns.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textEnterColumns.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textEnterColumns);
		textEnterColumns.setColumns(10);
	}

	private void makeEnterButton(JLabel lblChocolateGame, JPanel panelCenter, JPanel panelInput,
			JTextField txtEnterP1Name, JTextField txtEnterP2Name) 
	{
		JButton btnEnter = new JButton("Submit");
		btnEnter.setFont(new Font("Arial", Font.PLAIN, 30));
		btnEnter.setBackground(new java.awt.Color(192, 192, 192));
		btnEnter.setForeground(new java.awt.Color(255, 255, 255));
		btnEnter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				//get game board size
				try
				{
					rows = Integer.parseInt(textEnterRows.getText());
					columns = Integer.parseInt(textEnterColumns.getText());
				}
				catch (NumberFormatException exception)
				{
					rows = 0;
					columns = 0;
				}
				
				if ( (rows > 2 && columns > 2) && (rows < 16 && columns < 16) )
				{
					//make board 
					board = new GameBoard(rows, columns);
					squares = board.getBoard();
					makeBoard(panelCenter);
					panelCenter.setBackground(new java.awt.Color(0, 0, 0));
					
					//set player names
					String p1Name = txtEnterP1Name.getText();	
					if (!p1Name.isEmpty())
						player1.setName(p1Name);
					/*else
						player1.setName("player 1");*/
					String p2Name = txtEnterP2Name.getText();
					if (!p2Name.isEmpty())
						player2.setName(p2Name);
					/*else
						player2.setName("player 2");*/
					
					//reset turns and show turn
					setNewTurns();
					lblChocolateGame.setText(player1.getName() + "'s turn");
					
					//hide input panel
					contentPane.remove(panelInput);	
					contentPane.add(optionsPanel, BorderLayout.WEST);
				}
				//clear out text boxes
				txtEnterP1Name.setText("");
				txtEnterP2Name.setText("");
				textEnterRows.setText("");
				textEnterColumns.setText("");
			}
		});
		btnEnter.setBorder(new EmptyBorder(20, 10, 20, 10));
		panelInput.add(btnEnter);
	}
	
	private void setNewTurns() 
	{
		if (player1.hasTurn() != true)
			player1.toggleTurn();
		if (player2.hasTurn() == true)
			player2.toggleTurn();
	}

	private void makeLoadButton() 
	{
		JButton btnLoad = new JButton("Load Last Save");
		btnLoad.setBackground(new java.awt.Color(192, 192, 192));
		btnLoad.setForeground(new java.awt.Color(255, 255, 255));
		btnLoad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//get board from saved file
				squares = deserializeSquares("squares.ser");
				board = deserializeBoard("gameBoard.ser");
				
				//set rows and columns
				rows = board.getRows();
				columns = board.getColumns();
				
				//make board
				makeBoard(panelCenter);
				panelCenter.setBackground(new java.awt.Color(0, 0, 0));
				
				//get players from saved file
				player1 = deserialize("player1.ser");
				player2 = deserialize("player2.ser");
				
				//get and show player's turn
				if (player1.hasTurn())
					lblChocolateGame.setText(player1.getName() + "'s turn");
				else
					lblChocolateGame.setText(player2.getName() + "'s turn");
				
				//hide input panel
				contentPane.remove(panelInput);	
				contentPane.add(optionsPanel, BorderLayout.WEST);
				
			}
		});
		btnLoad.setForeground(new Color(255, 255, 255));
		btnLoad.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		panelInput.add(btnLoad);
	}
	
	private void makeBoard(JPanel panelCenter) 
	{
		panelCenter.setLayout(new GridLayout(0, board.getColumns(), 0, 0));
		
		for (Chocolate el : squares)
		{
			JButton btnSquare = new JButton(); 
			if (el.isPoison() == true)
			{
				btnSquare.setBackground(new java.awt.Color(199, 234, 70));
				btnSquare.setText("Poison");
				btnSquare.setFont(new Font("Chiller", Font.BOLD, 25));
			}
			else	
				btnSquare.setBackground(new java.awt.Color(102, 79, 60));
			//grey out button if eaten
			if (el.isEaten() == true)
				btnSquare.setBackground(new java.awt.Color(105, 105, 105));
			btnSquare.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 3));
			el.setButton(btnSquare);
			panelCenter.add(btnSquare);	
			
			btnSquare.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					if (el.isEaten() == false)
					{
						eatSquare(el);
						if (el.isPoison())
							winGame(el);
						else
						{
							changeTurn(el);
						}
					}
				}

				private void eatSquare(Chocolate elSelected) 
				{
					//eat squares
					for (Chocolate elBeingChecked : squares)
					{
						if ( elBeingChecked.getColumnNum() >= elSelected.getColumnNum() 
								&& elBeingChecked.getRowNum() <= elSelected.getRowNum() )
							elBeingChecked.setEaten(true);
					
						//change square color
						if (elBeingChecked.isEaten() == true)
							elBeingChecked.getButton().setBackground(new java.awt.Color(105, 105, 105));
					}
				}
				
				private void changeTurn(Chocolate el)
				{
					//toggle turn
					player1.toggleTurn();
					player2.toggleTurn();
					//change display
					if (player1.hasTurn() == true)
						lblChocolateGame.setText(player1.getName() + "'s turn");
					else
						lblChocolateGame.setText(player2.getName() + "'s turn");
				}
				
				private void winGame(Chocolate el)
				{				
					if (el.isPoison())
					{
						if (player1.hasTurn() == true)
							lblChocolateGame.setText(player2.getName() + " " + "Wins");
						else
							lblChocolateGame.setText(player1.getName() + " " + "Wins");
					}
				}
			});
		}
	} 


	//instruction panel methods
	private JPanel makeInstructionPanel() 
	{
		JPanel panelInstructions = new JPanel();
		panelInstructions.setBackground(new java.awt.Color(102, 153, 102));
		panelInstructions.setBorder(new EmptyBorder(0, 30, 0, 30));
		contentPane.add(panelInstructions, BorderLayout.EAST);
		panelInstructions.setLayout(new GridLayout(9, 2, 0, 0));
		return panelInstructions;
	}

	private void makeInstructionsLabel(JPanel panelInstructions) 
	{
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setOpaque(true);
		lblInstructions.setBackground(new java.awt.Color(255, 255, 255));
		lblInstructions.setForeground(new java.awt.Color(0, 0, 0));
		lblInstructions.setBorder(new LineBorder(new java.awt.Color(255, 255, 255)));
		lblInstructions.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		panelInstructions.add(lblInstructions);
	}

	private void makeInstructions(JPanel panelInstructions) 
	{
		//make blank label for spacing
		JLabel label_4 = new JLabel("");
		panelInstructions.add(label_4);
		
		JTextArea txtrTakeTurnsEating = new JTextArea(" Take turns eating \r\n chocolate ");
		txtrTakeTurnsEating.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		panelInstructions.add(txtrTakeTurnsEating);
		
		JTextArea textArea1 = new JTextArea(" Pick a square of\n chocolate to eat");
		textArea1.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		panelInstructions.add(textArea1);
		JTextArea textArea2 = new JTextArea(" All squares above and \n right are also eaten");
		textArea2.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		panelInstructions.add(textArea2);
		JTextArea textArea3 = new JTextArea(" Squares that have been\n eaten can't be picked");
		textArea3.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		panelInstructions.add(textArea3);
		JTextArea textArea4 = new JTextArea(" Don't eat the poison \n or you lose!");
		textArea4.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		panelInstructions.add(textArea4);
	}
	
	
	
	//options panel methods
	private void makeOptionsLbl(JPanel optionsPanel) 
	{
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setOpaque(true);
		lblOptions.setBackground(new java.awt.Color(255, 255, 255));
		lblOptions.setForeground(new java.awt.Color(0, 0, 0));
		lblOptions.setBorder(new LineBorder(new java.awt.Color(255, 255, 255)));
		lblOptions.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		optionsPanel.add(lblOptions);
	}

	private JPanel makeOptionsPanel(JPanel panelCenter) 
	{
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(new java.awt.Color(102, 153, 102));
		optionsPanel.setBorder(new EmptyBorder(0, 30, 0, 30));
		optionsPanel.setLayout(new GridLayout(8, 0, 0, 10));
		return optionsPanel;
	}
	
	private void makeSaveBtn(JPanel optionsPanel) 
	{
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSaveGame.setBackground(new java.awt.Color(192, 192, 192));
		btnSaveGame.setForeground(new java.awt.Color(255, 255, 255));
		optionsPanel.add(btnSaveGame);
		btnSaveGame.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			    String fileNamePlayer1 = "player1.ser";
			    String fileNamePlayer2 = "player2.ser";
			    String fileNameSquares = "squares.ser";
			    String fileNameBoard = "gameboard.ser";
				
				serialize(player1, fileNamePlayer1);
			    serialize(player2, fileNamePlayer2);
			    serialize(squares, fileNameSquares);
			    serialize(board, fileNameBoard);
			}
		});
	}
	
	private void makeNewGameBtn(JPanel optionsPanel) 
	{
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewGame.setBackground(new java.awt.Color(192, 192, 192));
		btnNewGame.setForeground(new java.awt.Color(255, 255, 255));
		optionsPanel.add(btnNewGame);
		btnNewGame.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblChocolateGame.setText("Chomp");
				contentPane.remove(optionsPanel);
				contentPane.add(panelInput, BorderLayout.WEST);
				panelCenter.removeAll();
				panelCenter.setBackground(new java.awt.Color(255, 255, 255));
			}
		});
	}
	
	
	//methods to save and retrieve data
    public static void serialize(Player player, String fileName)
    {
    	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
    	{
    		out.writeObject(player);
		} 
    	catch (IOException e) 
    	{
			System.out.println(e.getMessage());
		} 
    } 
    public static void serialize(GameBoard gameboard, String fileName)
    {
    	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
    	{
    		out.writeObject(gameboard);
		} 
    	catch (IOException e) 
    	{
			System.out.println(e.getMessage());
		} 
    }
    public static void serialize(ArrayList<Chocolate> squares, String fileName)
    {
    	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
    	{
    		out.writeObject(squares);
		} 
    	catch (IOException e) 
    	{
			System.out.println(e.getMessage());
		} 
    }
    
    public static Player deserialize(String fileName) 
    {
    	Player player = null;
    	try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
    	{
			player = (Player) in.readObject();
		} 
    	catch (IOException | ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	return player;
    }
    public static GameBoard deserializeBoard(String fileName) 
    {
    	GameBoard gameboard = null;
    	try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
    	{
			gameboard = (GameBoard) in.readObject();
		} 
    	catch (IOException | ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	return gameboard;
    }
    public static ArrayList<Chocolate> deserializeSquares(String fileName) 
    {
    	ArrayList<Chocolate> squares = null;
    	try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
    	{
			squares = (ArrayList<Chocolate>) in.readObject();
		} 
    	catch (IOException | ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	return squares;
    }
} 

