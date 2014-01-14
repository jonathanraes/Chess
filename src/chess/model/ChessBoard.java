package chess.model;

import java.util.Observable;
import java.util.Scanner;

import chess.model.King;
import chess.model.Knight;
import chess.model.Pawn;
import chess.model.Queen;
import chess.model.Rook;

public class ChessBoard extends Observable{
	public ChessPiece[][] board = new ChessPiece[8][8];
	public String turn = "White";
	public boolean play = true;
	public ChessPiece selectedPiece;
	public static byte[] colorsetting = {0,1};
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
	

	public void emptyBoard(){
		for(int a = 0; a < 8; a++){
			for(int b = 0; b < 8; b++){
				board[a][b] = null;
			}
		}
	}
	
	public void initializeBoard(){
		King blackking = new King("King","Black", this);
		Queen blackqueen = new Queen("Queen","Black", this);
		Rook blackrook0 = new Rook("Rook","Black", this);
		Rook blackrook1 = new Rook("Rook","Black", this);
		Knight blackknight0 = new Knight("Knight", "Black", this);
		Knight blackknight1 = new Knight("Knight","Black", this);
		Bishop blackbishop0 = new Bishop("Bishop","Black", this);
		Bishop blackbishop1 = new Bishop("Bishop","Black", this);
		
		Pawn blackpawn0 = new Pawn("Pawn","Black", this);
		Pawn blackpawn1 = new Pawn("Pawn","Black", this);
		Pawn blackpawn2 = new Pawn("Pawn","Black", this);
		Pawn blackpawn3 = new Pawn("Pawn","Black", this);
		Pawn blackpawn4 = new Pawn("Pawn","Black", this);
		Pawn blackpawn5 = new Pawn("Pawn","Black", this);
		Pawn blackpawn6 = new Pawn("Pawn","Black", this);
		Pawn blackpawn7 = new Pawn("Pawn","Black", this);
		
		
		King whiteking = new King("King","White", this);
		Queen whitequeen = new Queen("Queen","White", this);
		Rook whiterook0 = new Rook("Rook","White", this);
		Rook whiterook1 = new Rook("Rook","White", this);
		Knight whiteknight0 = new Knight("Knight", "White", this);
		Knight whiteknight1 = new Knight("Knight","White", this);
		Bishop whitebishop0 = new Bishop("Bishop","White", this);
		Bishop whitebishop1 = new Bishop("Bishop","White", this);
		
		Pawn whitepawn0 = new Pawn("Pawn","White", this);				
		Pawn whitepawn1 = new Pawn("Pawn","White", this);
		Pawn whitepawn2 = new Pawn("Pawn","White", this);
		Pawn whitepawn3 = new Pawn("Pawn","White", this);
		Pawn whitepawn4 = new Pawn("Pawn","White", this);
		Pawn whitepawn5 = new Pawn("Pawn","White", this);
		Pawn whitepawn6 = new Pawn("Pawn","White", this);
		Pawn whitepawn7 = new Pawn("Pawn","White", this);

		board[0][0] = whiterook0;
		board[7][0] = whiterook1;
		board[1][0] = whiteknight0;
		board[6][0] = whiteknight1;
		board[2][0] = whitebishop0;
		board[5][0] = whitebishop1;
		board[0][1] = whitepawn0;
		board[1][1] = whitepawn1;
		board[2][1] = whitepawn2;
		board[3][1] = whitepawn3;
		board[4][1] = whitepawn4;
		board[5][1] = whitepawn5;
		board[6][1] = whitepawn6;
		board[7][1] = whitepawn7;
		board[3][0] = whitequeen;
		board[4][0] = whiteking;
		
		board[0][7] = blackrook0;
		board[7][7] = blackrook1;
		board[1][7] = blackknight0;
		board[6][7] = blackknight1;
		board[2][7] = blackbishop0;
		board[5][7] = blackbishop1;
		board[0][6] = blackpawn0;
		board[1][6] = blackpawn1;
		board[2][6] = blackpawn2; 
		board[3][6] = blackpawn3;
		board[4][6] = blackpawn4;
		board[5][6] = blackpawn5;
		board[6][6] = blackpawn6;
		board[7][6] = blackpawn7;
		board[3][7] = blackqueen;
		board[4][7] = blackking;
				
	}
	
	public void move(int fromrow, int fromcol, int destrow, int destcol){
		board[destrow][destcol] = board[fromrow][fromcol];
		board[fromrow][fromcol] = null;
		setSelectedPiece(null);
	}
	
	public void changeTurn(){
		if(turn.equals("Black")){
			turn = "White";
		}
		else{
			turn = "Black";
		}
	}
	
	public ChessPiece getPiece(int row, int col){
		ChessPiece dd = board[row][col];
		return board[row][col];
	}
	
	public void drawBoard(){
		System.out.println(" [  A   ]| [  B   ]| [  C   ]| [  D   ]| [  E   ]| [  F   ]| [  G   ]| [  H   ]|");
		for(int col = 7; col > -1; col--){
			for(int row = 0; row < 8; row++){
				if(board[row][col] != null && !(board[row][col].getName().equals("Queen")) && !(board[row][col].getName().equals("Rook")) && !(board[row][col].getName().equals("King")) && !(board[row][col].getName().equals("Bishop"))  && !(board[row][col].getName().equals("Knight"))){
					System.out.print(col+1 + "[ " + board[row][col].getName() + " ]|");
				}
				else if(board[row][col] == null){
					System.out.print(col+1 + "[      ]|");
				}
				else {
					if(board[row][col].getName().equals("Rook") || board[row][col].getName().equals("King")){
						System.out.print(col+1 + "[ " + board[row][col].getName() + " ]|");
					}
					else if(board[row][col].getName().equals("Queen")){
						System.out.print(col+1 +"[" + board[row][col].getName() + " ]|");
					}
					else{
						System.out.print(col+1 +"[" + board[row][col].getName() + "]|");
					}
				}
			}
			System.out.println();
		}
		System.out.println(" [  A   ]| [  B   ]| [  C   ]| [  D   ]| [  E   ]| [  F   ]| [  G   ]| [  H   ]|");
	}
	
	public boolean playMove(Scanner sc){
		do{
		int fromcol, fromrow, destcol, destrow;
		String from,dest = "";
		fromrow = 99;fromcol = 99;destrow=99;destcol=99;
		System.out.println("Move: " + turn);
		System.out.println("Enter piece to move");
		from = sc.next();
		for(Board tiles: Board.values()){
			if(from.equalsIgnoreCase(tiles.name())){
				fromrow = tiles.getRow();
				fromcol = tiles.getCol();
			}
		}
		if(fromrow != 99){
			if(board[fromrow][fromcol] != null && board[fromrow][fromcol].getTeam().equals(turn)){
			System.out.println(board[fromrow][fromcol].getName() + " Selected");
			System.out.println("Enter where to move to:");
			dest = sc.next();
			for(Board tiles2: Board.values()){
				if(dest.equalsIgnoreCase(tiles2.name())){
					destrow = tiles2.getRow();
					destcol = tiles2.getCol();
				}
			}
			if(destrow != 99 && board[fromrow][fromcol].move(fromrow, fromcol, destrow, destcol)){
				return true;
			}
			}
			else{
				System.out.println("You can only move you own pieces!");
			}
		}
		if(from.equalsIgnoreCase("quit") || dest.equalsIgnoreCase("quit")){
			endGame();
			return false;
		}
		if(destrow == 99 || fromrow == 99){
			System.out.println("Invalid input!");
		}
		}while(true);
		}
	
	public boolean encounter(int fromrow, int fromcol, int destrow, int destcol){
		if(board[destrow][destcol] instanceof King){
			endGame();
			return true;
		}
			move(fromrow, fromcol, destrow, destcol);
			setSelectedPiece(null);
			return true;
		}
		
		
	public boolean endGame(){
			emptyBoard();
			initializeBoard();
			if(getTurn().equals("Black")){
				changeTurn();
			}
			setChanged();
			notifyObservers();
			return true;
	}
	
	public void setPlay(boolean play){
		this.play = play;
	}
	
	public ChessPiece[][] getBoardContent(){
		return board;
	}
	
	public static byte[] getColorSetting(){
		return colorsetting;
	}
	
	public void setColorSetting(byte player1, byte player2){
		colorsetting[0] = player1;
		colorsetting[1] = player2;
		setChanged();
		notifyObservers();
		return;
	}
	
	public void setSelectedPiece(ChessPiece piece){
		selectedPiece = piece;

		return;
	}
	
	public ChessPiece getSelectedPiece(){
		return selectedPiece;
	}
	
	public String getTurn(){
		return turn;
	}
	
	public void setChangedandNotify(){
		setChanged();
		notifyObservers();
		return;
	}
	
}
	
