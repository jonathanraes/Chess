package chess.model;


public class King extends ChessPiece {
	 ChessBoard board;
	
	public King(String name, String team, ChessBoard board) {
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
		
	public String toString(){
		return this.getName();
	}

	@Override
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow,
			int destcol) {
		if((destrow == fromrow && fromcol == destcol+1)|| //up
				(destrow == fromrow && fromcol == destcol-1)|| //down
				(destrow == fromrow+1 && fromcol == destcol)|| //right
				(destrow == fromrow-1 && fromcol == destcol)|| //left
				(destrow == fromrow-1 && fromcol == destcol+1)|| //up-left
				(destrow == fromrow+1 && fromcol == destcol+1)|| //right-up
				(destrow == fromrow+1 && fromcol == destcol-1)|| //right-down
				(destrow == fromrow-1 && fromcol == destcol-1) //left-down
				){
			
			if(board.getPiece(destrow, destcol) == null){
				if(board.canAnyoneHit(destrow, destcol, getTeam())){
					return false;
				}
				return true;
			}
			else{
				if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
					//encounter
					if(board.canAnyoneHit(destrow, destcol, getTeam())){
						return false;
					}
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
