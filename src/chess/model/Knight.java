package chess.model;

import java.awt.Color;


public class Knight extends ChessPiece {
	 ChessBoard board;
	public Knight(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}

	@Override
	public boolean move(int fromrow, int fromcol, int destrow, int destcol) {
		if(isPossibleMove(fromrow, fromcol, destrow, destcol)){
			board.move(fromrow, fromcol, destrow, destcol);
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isPossibleCheckMove(int fromrow, int fromcol, int destrow,
			int destcol) {
		if(!board.getCheck().equals("")){
			for(int i = 0; i < board.getMarkedList().size(); i++){
				if(i % 2 ==0){
					if((destrow == board.getMarkedList().get(i)) && (destcol == board.getMarkedList().get(i+1))){
						if(isPossibleMove(fromrow, fromcol, destrow, destcol)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	@Override
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow,
			int destcol) {
		/*
		 * options:
		 * up-up-left
		 * up-up-right
		 * left-left-up
		 * left-left-down
		 * down-down-right
		 * down-down-left
		 * right-right-up
		 * right-right-down
		 */
		if((fromrow +1 == destrow && fromcol + 2 == destcol) ||//up up right
				(fromrow - 1 == destrow && fromcol + 2 == destcol)|| //up up left
				(fromrow + 2 == destrow && fromcol + 1 == destcol)|| //left-left-up
				(fromrow + 2 == destrow && fromcol - 1 == destcol)|| //left-left-down
				(fromrow + 1 == destrow && fromcol - 2 == destcol)|| //down-down-left
				(fromrow - 1 == destrow && fromcol - 2 == destcol)|| //down-down-right
				(fromrow - 2 == destrow && fromcol + 1 == destcol)|| //right-right-up
				(fromrow - 2 == destrow && fromcol - 1 == destcol)){ //right-right-down
		
				if(board.getPiece(destrow, destcol) == null){
					return true;
				}
				else{
					if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
						//encounter
						return true;
					}
					else{
						return false;
					}
				}
	 		}
			return false;
	}

}
