package chess.model;


public class Pawn extends ChessPiece {
ChessBoard board;
	public Pawn(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}

	@Override
	public boolean move(int fromrow, int fromcol, int destrow, int destcol) {
		if(this.getTeam().equals("White")){
		
			if(destrow == fromrow && destcol == fromcol+1){
				if(board.getPiece(destrow, destcol) == null){
					board.move(fromrow, fromcol, destrow, destcol);
					return true;
				}
				else {
					System.out.println("Invalid move!");
					return false;
				}
						
			}
			if(fromcol == 1 && destcol == 3){
				if(board.getPiece(destrow, 2) == null){
					if(board.getPiece(destrow, 3) == null){
						board.move(fromrow, fromcol, destrow, destcol);
						return true;
					}
				}
				System.out.println("Invalid move!");
				return false;
			}
			if((destrow == fromrow-1 && destcol == fromcol+1) || (destrow == fromrow+1 && destcol == fromcol+1)){
				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("Black")){
					//encounter
					if(board.encounter(fromrow, fromcol, destrow, destcol)){
						return true;
					}
				}
			}
		} 
		else if(this.getTeam().equals("Black")){
			if(destrow == fromrow && destcol == fromcol-1){
				if(board.getPiece(destrow, destcol) == null){
					board.move(fromrow, fromcol, destrow, destcol);
					return true;
				}
				else{
					System.out.println("Invalid move!");
					return false;
				}
						
			}
			if(fromcol == 6 && destcol == 4){
				if(board.getPiece(destrow, 5) == null){
					if(board.getPiece(destrow, 4) == null){
						board.move(fromrow, fromcol, destrow, destcol);
						return true;
					}
				}
				System.out.println("Invalid move!");
				return false;
			}
			if((destrow == fromrow-1 && destcol == fromcol-1) || (destrow == fromrow+1 && destcol == fromcol-1)){
				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("White")){
					//encounter
					if(board.encounter(fromrow, fromcol, destrow, destcol)){
						return true;
					}
				}
			}
		}
		System.out.println("invalid move!");
		return false;
	}
	
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow, int destcol){
		if(this.getTeam().equals("White")){
			
			if(destrow == fromrow && destcol == fromcol+1){
				if(board.getPiece(destrow, destcol) == null){
					return true;
				}
				else {
					return false;
				}
						
			}
			if(fromcol == 1 && destcol == 3){
				if(board.getPiece(destrow, 2) == null){
					if(board.getPiece(destrow, 3) == null){
						return true;
					}
				}
				return false;
			}
			if((destrow == fromrow-1 && destcol == fromcol+1) || (destrow == fromrow+1 && destcol == fromcol+1)){
				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("Black")){
					//encounter
					return true;
				}
			}
		} 
		else if(this.getTeam().equals("Black")){
			if(destrow == fromrow && destcol == fromcol-1){
				if(board.getPiece(destrow, destcol) == null){
					return true;
				}
				else{
					return false;
				}
						
			}
			if(fromcol == 6 && destcol == 4){
				if(board.getPiece(destrow, 5) == null){
					if(board.getPiece(destrow, 4) == null){
						return true;
					}
				}
				return false;
			}
			if((destrow == fromrow-1 && destcol == fromcol-1) || (destrow == fromrow+1 && destcol == fromcol-1)){
				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("White")){
					//encounter
					return true;
					}
			}
		}
		return false;
	}
	
	public int[] getPossibleMoves(int fromrow, int fromcol){
		if(this.getTeam().equals("White")){
			if(board.getPiece(fromrow, fromcol+1) == null){ //move 1 square straight ahead
				int[] possible = {fromrow, fromcol+1};
				return possible;
			}
		}
		if(fromcol == 1){
			if(board.getPiece(fromrow, 2) == null){
				if(board.getPiece(fromrow, 3) == null){
						int[] possible = {fromrow, 3};
						return possible;
					}
				}
		}
		return null;

//		
//				return false;
//			}
//			if((destrow == fromrow-1 && destcol == fromcol+1) || (destrow == fromrow+1 && destcol == fromcol+1)){
//				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("Black")){
//					//encounter
//					return true;
//				}
//			}
//		} 
//		else if(this.getTeam().equals("Black")){
//			if(destrow == fromrow && destcol == fromcol-1){
//				if(board.getPiece(destrow, destcol) == null){
//					return true;
//				}
//				else{
//					return false;
//				}
//						
//			}
//			if(fromcol == 6 && destcol == 4){
//				if(board.getPiece(destrow, 5) == null){
//					if(board.getPiece(destrow, 4) == null){
//						return true;
//					}
//				}
//				return false;
//			}
//			if((destrow == fromrow-1 && destcol == fromcol-1) || (destrow == fromrow+1 && destcol == fromcol-1)){
//				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("White")){
//					//encounter
//					return true;
//					}
//			}
//		}
//		return false;
		
	}
}
