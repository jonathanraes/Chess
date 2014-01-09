package chess.model;


public class King extends ChessPiece {
	 ChessBoard board;
	
	public King(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}
	
	@Override
	public boolean move(int fromrow, int fromcol, int destrow, int destcol) {
		
		if(destrow == fromrow && fromrow == destrow+1){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;
		}
		else if (destrow == fromrow && fromcol == destcol-1){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;
		}
		else if(destrow == fromrow+1 && fromcol == destcol){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;

		}
		else if(destrow == fromrow-1 && fromcol == destcol){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;

		}
		else if(destrow == fromrow+1 && fromcol == destcol+1){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;

		}else if(destrow == fromrow+1 && fromcol == destcol-1){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;

		}
		else if(destrow == fromrow-1 && fromcol == destcol-1){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;

		}
		else if(destrow+1 == fromrow && fromcol+1 == destcol){
			if(board.getPiece(destrow, destcol) != null){
				//ENCOUNTER
				board.encounter(fromrow, fromcol, destrow, destcol);

			}
			board.move(fromrow, fromcol, destrow, destcol);			
			return true;

		}
		else if(destrow-1 == fromrow && fromcol-1 == destcol){
			if(board.getPiece(destrow, destcol) != null){
			//ENCOUNTER
			board.encounter(fromrow, fromcol, destrow, destcol);

		}
			board.move(fromrow, fromcol, destrow, destcol);
			return true;

		}
		else{
			System.out.println("Invalid move!");
		}
		return false;
	}
	
	public String toString(){
		return this.getName();
	}

	@Override
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow,
			int destcol) {
		// TODO Auto-generated method stub
		return false;
	}
}
