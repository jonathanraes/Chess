package chess.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import chess.controller.Controller;
import chess.model.ChessBoard;
import chess.model.ChessPiece;
import chess.model.King;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements Observer{
	JPanel panel = new JPanel();
	JPanel informationpanel;
	JTextPane informationpane;
	JTextPane selectedpiecepane;
	ChessPieceIcon pieces;
	Tile tile;
	JMenuBar menu;
	ActionListener controller;
	MouseListener mousecontroller;
	private ChessBoard board;
	JFrame csettingframe;
	JPanel team1panel;
	JPanel team2panel;
	GridBagConstraints CONTRAINTS;
	JPanel containerPanel;
	JTextPane checkpane;
	TimePanel timepane;
	
	boolean csettingsopened = false;
	
	public MainFrame(String title, ChessBoard board, TimePanel timepane) throws HeadlessException {
		super(title);
		this.board = board;
		informationpanel = new JPanel();
		informationpane = new JTextPane();
		selectedpiecepane = new JTextPane();
		checkpane = new JTextPane();
		informationpanel.setLayout(new GridBagLayout());
		GridBagConstraints CONSTRAINTS = new GridBagConstraints();
		CONSTRAINTS.gridwidth = 2;
		CONSTRAINTS.fill = GridBagConstraints.BOTH;
		CONSTRAINTS.anchor = GridBagConstraints.LINE_START;
		informationpane.setPreferredSize(new Dimension(295, 30));
		informationpanel.add(informationpane, CONSTRAINTS);
		CONSTRAINTS.gridx = 2;
		selectedpiecepane.setPreferredSize(new Dimension(245, 30));
		informationpanel.add(selectedpiecepane, CONSTRAINTS);
		CONSTRAINTS.gridx = 4;
		checkpane.setPreferredSize(new Dimension(285, 30));
		informationpanel.add(checkpane, CONSTRAINTS);
		CONSTRAINTS.gridx = 6;
		CONSTRAINTS.gridwidth = 1;
		timepane = new TimePanel();
		timepane.setPreferredSize(getPreferredSize());
		informationpanel.add(timepane, CONSTRAINTS);
		
		informationpanel.setBackground(Color.white);
		informationpane.setEditable(false);
		selectedpiecepane.setEditable(false);
		setPaneText(board.getTurn());
		setSelctedPiecePaneText("No selected Piece");
		controller = new Controller(board, this, timepane);
		mousecontroller = new Controller(board, this, timepane);
		panel.setLayout(new GridLayout(8,8));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(970,828);
		setResizable(false);
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		JPanel fallenPiecesPanel = new JPanel();
		team1panel = new JPanel(new GridLayout(5,3));
		team2panel = new JPanel(new GridLayout(5,3));
		fallenPiecesPanel.setLayout(new GridLayout(2,1));
		fallenPiecesPanel.add(team1panel);
		fallenPiecesPanel.add(team2panel);
		team1panel.setBackground(Color.white);
		team2panel.setBackground(Color.white);
		
		createMenubar();
	
		int count = 0;
			for(int i = 0; i < 8; i++){
				for(int col = 0; col < 8; col++){
					tile = new Tile(count);
					tile.setLayout(new BorderLayout());
					pieces = new ChessPieceIcon(board.getPiece(col, i));
					int row = (count / 8) % 2;
					if (row == 0){
						tile.setBackground( count % 2 == 0 ? Color.black : Color.white );
					}
					else{
						tile.setBackground( count % 2 == 0 ? Color.white : Color.black );
					}
					tile.add(pieces, BorderLayout.CENTER);
					tile.addMouseListener(mousecontroller);
					panel.add(tile, BorderLayout.CENTER);
					tile.setVisible(true);
					count++;
				}
			}
			setLayout(new BorderLayout());
			add(informationpanel, BorderLayout.NORTH);
			panel.setBounds(0, 0, 800, 750);
			containerPanel.add(panel);
			fallenPiecesPanel.setBounds(800, 0, 170, 750);
			containerPanel.add(fallenPiecesPanel);
			
			Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
			panel.setBorder(border);
			panel.setBackground(Color.black);
			add(containerPanel, BorderLayout.CENTER);
	}
	
	public void emptyFallenPiecesPanel(){
		team1panel.removeAll();
		team2panel.removeAll();
	}
	
	public void colorSettingMenu(){
		csettingframe = new JFrame("Color Settings");
		JPanel cpanel = new JPanel(new BorderLayout());
		JPanel team1 = new JPanel();
		team1.setLayout(new BoxLayout(team1, BoxLayout.Y_AXIS));
		JPanel team2 = new JPanel();
		team2.setLayout(new BoxLayout(team2, BoxLayout.Y_AXIS));
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
		JButton okbutton = new JButton("OK");
		okbutton.addActionListener(controller);


		JRadioButton color0 = new JRadioButton("White");
		color0.setName("team1white");
		color0.setSelected(true);
		JRadioButton color1 = new JRadioButton("Black");
		color1.setName("team1black");
		JRadioButton color2 = new JRadioButton("Blue");
		color2.setName("team1blue");
		JRadioButton color3 = new JRadioButton("Brown");
		color3.setName("team1brown");
		JRadioButton color4 = new JRadioButton("Green");
		color4.setName("team1green");
		JRadioButton color5 = new JRadioButton("Red");
		color5.setName("team1red");
		JRadioButton color6 = new JRadioButton("Violet");
		color6.setName("team1violet");
		JRadioButton color7 = new JRadioButton("Yellow");
		color7.setName("team1yellow");
		JRadioButton color8 = new JRadioButton("White");
		color8.setName("team2white");
		JRadioButton color9 = new JRadioButton("Black");
		color9.setName("team2black");
		color9.setSelected(true);
		JRadioButton color10 = new JRadioButton("Blue");
		color10.setName("team2blue");
		JRadioButton color11 = new JRadioButton("Brown");
		color11.setName("team2brown");
		JRadioButton color12 = new JRadioButton("Green");
		color12.setName("team2green");
		JRadioButton color13 = new JRadioButton("Red");
		color13.setName("team2red");
		JRadioButton color14 = new JRadioButton("Violet");
		color14.setName("team2violet");
		JRadioButton color15 = new JRadioButton("Yellow");
		color15.setName("team2yellow");
		ButtonGroup team1group = new ButtonGroup();
		ButtonGroup team2group = new ButtonGroup();
		color0.addActionListener(controller);
		color1.addActionListener(controller);
		color2.addActionListener(controller);
		color3.addActionListener(controller);
		color4.addActionListener(controller);
		color5.addActionListener(controller);
		color6.addActionListener(controller);
		color7.addActionListener(controller);
		color8.addActionListener(controller);
		color9.addActionListener(controller);
		color10.addActionListener(controller);
		color11.addActionListener(controller);
		color12.addActionListener(controller);
		color13.addActionListener(controller);
		color14.addActionListener(controller);
		color15.addActionListener(controller);

		team1group.add(color0);
		team1group.add(color1);
		team1group.add(color2);
		team1group.add(color3);
		team1group.add(color4);
		team1group.add(color5);
		team1group.add(color6);
		team1group.add(color7);
		
		team2group.add(color8);
		team2group.add(color9);
		team2group.add(color10);
		team2group.add(color11);
		team2group.add(color12);
		team2group.add(color13);
		team2group.add(color14);
		team2group.add(color15);


		JTextArea textbox = new JTextArea();
		JTextArea textbox2 = new JTextArea();
	
		textbox.setText("Team 1 Color:");
		textbox2.setText("Team 2 Color:");
		textbox.setEditable(false);
		textbox2.setEditable(false);
	
		team1.add(textbox);
		team2.add(textbox2);
	
		team1.add(color0);
		team1.add(color1);
		team1.add(color2);
		team1.add(color3);
		team1.add(color4);
		team1.add(color5);
		team1.add(color6);
		team1.add(color7);
		
		team2.add(color8);
		team2.add(color9);
		team2.add(color10);
		team2.add(color11);
		team2.add(color12);
		team2.add(color13);
		team2.add(color14);
		team2.add(color15);

		buttonPanel.add(okbutton);
		cpanel.add(team1, BorderLayout.WEST);
		cpanel.add(team2, BorderLayout.EAST);	
		cpanel.add(buttonPanel, BorderLayout.SOUTH);
		csettingframe.add(cpanel);
		
		csettingframe.setSize(210, 270);
		csettingframe.setResizable(false);
		csettingframe.setVisible(true);
		csettingframe.setAlwaysOnTop(true);
		color1.addActionListener(controller);
	}
	
	public void openColorSettings(){
		csettingframe.setVisible(true);
	}
	
	public boolean getCSettingsOpened(){
		return csettingsopened;
	}
	
	public void setCSettingsOpened(boolean b){
		csettingsopened = b;
	}
	
	public void createMenubar(){
		menu = new JMenuBar();
		setJMenuBar(menu);
		JMenu gameMenu = new JMenu("Game");
	    menu.add(gameMenu);
		JMenuItem newgame = new JMenuItem("New Game");
		JMenuItem color = new JMenuItem("Color Settings");

		JMenuItem exit = new JMenuItem("Exit");
		gameMenu.add(newgame);
		gameMenu.add(color);
		gameMenu.add(exit);
		exit.addActionListener(controller);
		newgame.addActionListener(controller);
		color.addActionListener(controller);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		String ischeck = board.checkForCheck();
		board.setCheck(ischeck);
		if(!ischeck.equals("")){
			if(board.checkForCheckMate(ischeck)){
				endGame(ischeck.equals("Black") ? "White" : ischeck);		
				panel.setBackground(Color.red);
			}
			else{ 
				setCheckPane(true);
			}
		}
		else{
			setCheckPane(false);
		}
		if(board.attack){
			ChessPieceIcon fallenPiece = new ChessPieceIcon(board.dieingPiece);
			if(board.dieingPiece.getTeam().equals("White")){
				team2panel.add(fallenPiece);
			}
			else{
				team1panel.add(fallenPiece);
			}
		}
		ChessPiece selected = board.getSelectedPiece();
		int[] selectedpiecetile = {0,0};
		for(int i = 0; i < 8; i++){
			for(int col = 0; col < 8; col++){
				if(board.getSelectedPiece() != null && board.getPiece(col, i) == board.getSelectedPiece()){
					selectedpiecetile[0] = col;
					selectedpiecetile[1] = i;
					System.out.println("Setting Selected Piece tile: \nselectedpiecetile[0]= " + col + "\nselectedpiecetile[1]= " + i);
				}
			}
		}
		panel.removeAll();
		ArrayList<Integer> tileslist = board.getMarkedList();
		//Building tiles
		int count = 0;
		for(int i = 0; i < 8; i++){
			for(int col = 0; col < 8; col++){
				tile = new Tile(count);
				tile.setLayout(new BorderLayout());
//				tile.setVisible(true);
				pieces = new ChessPieceIcon(board.getPiece(col, i));
				int row = (count / 8) % 2;
//				boolean check = false;
				if (row == 0){
					if(selected instanceof ChessPiece){
						ChessPiece piece = (ChessPiece) selected;
							if(ischeck.equals("") ? piece.isPossibleMove(selectedpiecetile[0], selectedpiecetile[1], col, i, false) : piece.isPossibleCheckMove(selectedpiecetile[0], selectedpiecetile[1], col, i)){
								tile.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
//								tile.setBackground(Color.red);
								System.out.println("Setting green background for " + i + "," +col);
//								check = true;
							}
					}
					if(board.getSelectedPiece() != null && board.getPiece(col, i) == board.getSelectedPiece()){ //The Tile of the selected piece
						tile.setBackground(Color.blue);
					}
					else /*if(!check)*/{
						tile.setBackground( count % 2 == 0 ? Color.black : Color.white );
					}
					//// 
					for(int j = 0; j < tileslist.size(); j++){
						if(j % 2 == 0){
							if(tileslist.get(j) == col && tileslist.get(j+1) == i){
								tile.setBackground(Color.pink);
							}
						}
					}
					////
				}
				else{
					if(selected instanceof ChessPiece){
						ChessPiece piece = (ChessPiece) selected;
						if(ischeck.equals("") ? piece.isPossibleMove(selectedpiecetile[0], selectedpiecetile[1], col, i, false) : piece.isPossibleCheckMove(selectedpiecetile[0], selectedpiecetile[1], col, i)){
								tile.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
//								tile.setBackground(Color.red);
								System.out.println("Setting green background for " + i + "," +col);
//								check = true;
							}
					}
					if(board.getSelectedPiece() != null && board.getPiece(col, i) == board.getSelectedPiece()){ //The Tile of the selected piece
						tile.setBackground(Color.blue);
					}
					else /*if(!check)*/{
						tile.setBackground( count % 2 == 0 ? Color.white : Color.black );
					}
					//// 
					for(int j = 0; j < tileslist.size(); j++){
						if(j % 2 == 0){
							if(tileslist.get(j) == col && tileslist.get(j+1) == i){
								tile.setBackground(Color.pink);
							}
						}
					}
					////
				}
				tile.add(pieces, BorderLayout.CENTER);
				tile.addMouseListener(mousecontroller);
				panel.add(tile, BorderLayout.CENTER);
				count++;
			}
		}
		board.clearMarkedList();
		//panel.setBounds(0, 0, 800, 750);
		//containerPanel.add(panel);
		//setVisible(true);
	}			
	
	public void endGame(String winner){
		Font newFont = new Font(Font.SERIF, Font.PLAIN, 19);
		checkpane.setFont(newFont);
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.red);
		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
		checkpane.setCharacterAttributes(aset, true);
		checkpane.setText("Checkmate! " + winner + " Wins!");
	}
	
	/**
	 * 0 = WHITE
	 * 1 = BLACK
	 * 2 = BLUE
	 * 3 = BROWN
	 * 4 = GREEN
	 * 5 = RED
	 * 6 = VIOLET
	 * 7 = YELLOW
	 */
	public void setPaneText(String text){
		Font font1 = new Font("Trebuchet MS", Font.PLAIN, 19);
		byte[] color = ChessBoard.getColorSetting();
		String turn ="";
		switch (text.equals("White") ? color[0] : color[1]) {
			case 0:
				turn = "White";
				break;
			case 1:
				turn = "Black";
				break;
			case 2: 
				turn = "Blue";
				break;
			case 3:
				turn = "Brown";
				break;
			case 4:
				turn = "Green";
				break;
			case 5:
				turn = "Red";
				break;
			case 6:
				turn = "Violet";
				break;
			case 7:
				turn = "Yellow";
				break;
			default:
				break;
			}
		informationpane.setFont(font1);
		informationpane.setText(turn + "'s turn!");
	}
	
	public void setCheckPane(boolean check){
		Font newFont = new Font(Font.SERIF, Font.PLAIN, 19);
		checkpane.setFont(newFont);
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.red);
		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
		checkpane.setCharacterAttributes(aset, true);
		if(check){
			checkpane.setText("Check!");
		}
		else{
			checkpane.setText("");
		}
	}
	
	public void setSelctedPiecePaneText(String text){
		Font font1 = new Font("Trebuchet MS", Font.PLAIN, 19);
		selectedpiecepane.setFont(font1);
		selectedpiecepane.setText(text);
	}
	
	public void closeColorSettings(){
		csettingframe.dispose();
	}

}
