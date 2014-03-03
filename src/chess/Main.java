package chess;

import chess.controller.Controller;
import chess.model.ChessBoard;
import chess.view.MainFrame;
import chess.view.TimePanel;

public class Main {
	public static void main(String[] args){
		
		TimePanel timepanel = new TimePanel();
		ChessBoard board = new ChessBoard();
		board.initializeBoard();
		MainFrame mainframe = new MainFrame("Chess  by Jonathan Raes", board, timepanel);
		Controller controller = new Controller(board, mainframe, timepanel);
		
		board.addObserver(mainframe); 
		mainframe.setVisible(true);
		board.drawBoard();
	}
}
