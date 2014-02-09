package chess;

import java.util.Scanner;

import chess.controller.Controller;
import chess.model.ChessBoard;
import chess.view.MainFrame;

public class Main {
	public static void main(String[] args){
		
		
		ChessBoard board = new ChessBoard();
		board.initializeBoard();
		MainFrame mainframe = new MainFrame("Chess  by Jonathan Raes", board);
		Controller controller = new Controller(board, mainframe);
		
		board.addObserver(mainframe); 
		mainframe.setVisible(true);
		board.drawBoard();
	}
}
