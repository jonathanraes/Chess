package chess.model;

import java.util.ArrayList;

public class Bishop extends ChessPiece {

	public Bishop(String name, String team, ChessBoard board) {
		super(name, team, board);
	}

	@Override
	public boolean move(int fromrow, int fromcol, int destrow, int destcol) {
		if(isPossibleMove(fromrow, fromcol, destrow, destcol, false)){
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
						if(isPossibleMove(fromrow, fromcol, destrow, destcol, false)){
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
			int destcol, boolean checker) {
			try{
			if(Math.abs(( (double)destcol - (double)fromcol)/((double)destrow-(double)fromrow)) == 1.0){
				if(destrow-fromrow > 0 && destcol - fromcol > 0){ //up right
					for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
						if(fromrow + i == destrow && fromcol + i == destcol){ 
							if(board.getPiece(destrow, destcol) == null){
								return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
							}
							else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
								return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
							}
							else{
								return false;
							}
						}
						else if(board.getPiece(fromrow+i, fromcol+i) == null){
							
						}
						else {
							//ENCOUNTER
							return false;
						}
					}
					return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
				}
				else if(destrow - fromrow < 0 && destcol - fromcol > 0){ //up left
						for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
							if(fromrow - i == destrow && fromcol + i == destcol){ 
								if(board.getPiece(destrow, destcol) == null){
									return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
								}
								else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
									return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
								}
								else{
									return false;
								}
							}
							else if(board.getPiece(fromrow-i, fromcol+i) == null){
								
							}
							else {
								//ENCOUNTER
								return false;
							}
						}
					return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
				}
				else if(destrow-fromrow < 0 && destcol - fromcol < 0){ //down left
					for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
						if(fromrow - i == destrow && fromcol - i == destcol){ 
							if(board.getPiece(destrow, destcol) == null){
								return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
							}
							else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
								return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
							}
							else{
								return false;
							}
						}
						else if(board.getPiece(fromrow-i, fromcol-i) == null){
							
						}
						else {
							//ENCOUNTER
							return false;
						}
					}
				return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
			}
				else if(destrow-fromrow > 0 && destcol - fromcol < 0){ //down right
					for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
						if(fromrow + i == destrow && fromcol - i == destcol){ 
							if(board.getPiece(destrow, destcol) == null){
								return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
							}
							else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
								return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
							}
							else{
								return false;
							}
						}
						else if(board.getPiece(fromrow+i, fromcol-i) == null){
							
						}
						else {
							//ENCOUNTER
							return false;
						}
					}
				return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
			}
			System.err.println("ERROR CHECK BISHOP");
			return false;
		}
			return false;
		}
		catch(ArithmeticException e){
			return false;
		}
		catch(NumberFormatException e){
			System.out.println("NFE BISHOP");
			return false;
		}
	}
}
