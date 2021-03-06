package chess.model;


public class Pawn extends ChessPiece {

	public Pawn(String name, String team, ChessBoard board) {
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
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow, int destcol, boolean checker){
		if(this.getTeam().equals("White")){
			if(destrow == fromrow && destcol == fromcol+1){ //straight ahead 
				if(board.getPiece(destrow, destcol) == null){
					return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
				}
				else {
					return false;
				}
			}
			if(fromcol == 1 && destcol == 3 && fromrow == destrow){
				if(board.getPiece(destrow, 2) == null){
					if(board.getPiece(destrow, 3) == null){ //straight from start 2 spaces
						return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
					}
				}
				return false;
			}
			if((destrow == fromrow-1 && destcol == fromcol+1) || (destrow == fromrow+1 && destcol == fromcol+1)){ //diagonal 
				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("Black")){
					//encounter
					return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
				}
			}
		} 
		else if(this.getTeam().equals("Black")){
			if(destrow == fromrow && destcol == fromcol-1){ //straight down 
				if(board.getPiece(destrow, destcol) == null){
					return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
				}
				else{
					return false;
				}
						
			}
			if(fromcol == 6 && destcol == 4 && fromrow == destrow){ //straight down from start 2 spaces
				if(board.getPiece(destrow, 5) == null){
					if(board.getPiece(destrow, 4) == null){
						return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
					}
				}
				return false;
			}
			if((destrow == fromrow-1 && destcol == fromcol-1) || (destrow == fromrow+1 && destcol == fromcol-1)){
				if(board.getPiece(destrow, destcol) != null && board.getPiece(destrow, destcol).getTeam().equals("White")){
					//encounter
					return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
					}
			}
		}
		return false;
	}
	


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
