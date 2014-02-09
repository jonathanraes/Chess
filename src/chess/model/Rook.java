package chess.model;


public class Rook extends ChessPiece {
	 ChessBoard board;
	public Rook(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}

	public boolean move(int fromrow, int fromcol, int destrow, int destcol){
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
		if(fromrow == destrow && fromcol == destcol){
			return false;
		}
		if(fromrow == destrow){ 
			//vertical movement
			if(destcol < fromcol){ //moving downwards
				for(int col = fromcol; col > destcol; col--){
					if(col-1 == destcol){
						if(board.getPiece(destrow, destcol) == null){
							return true;
						}
						else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							String selected = board.getPiece(fromrow,fromcol).getTeam();
							String dest = board.getPiece(fromrow, destcol).getTeam();
							return true;
						}
						else{
							return false;
						}
					}
					else if(board.getPiece(destrow, col-1) == null){
						
					}
					else{
						//ENCOUNTER
							return false;
					}
				}
				return true;
			}
			else{ //moving upwards	
				for(int col = fromcol; col < destcol; col++){
					if(col+1 == destcol){
						if(board.getPiece(destrow, destcol) == null){
							return true;
						}
						else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							String selected = board.getPiece(fromrow,fromcol).getTeam();
							String dest = board.getPiece(fromrow, destcol).getTeam();
							return true;
						}
						else{
							return false;
						}
					}
					else if(board.getPiece(destrow, col+1) == null){
						
					}
					else {
						//ENCOUNTER
						return false;
					}
				}
				return true;
				
			}
		}
		else if(fromcol == destcol){ 
			//horizontal movement
			if(fromrow < destrow){ //moving to the right
				for(int row = fromrow; row < destrow; row++){
					if(row+1 == destrow){
						if(board.getPiece(destrow, destcol) == null){
							return true;
						}
						else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							return true;
						}
						else{
							return false;
						}
					}
					else if(board.getPiece(row+1, destcol) == null){
						
					}
					else {
						//ENCOUNTER
							return false;
					}
				}
				return true;
			}
			else{ //moving to the left
				for(int row = fromrow; row > destrow; row--){
					if(row-1 == destrow){
						if(board.getPiece(destrow, destcol) == null){
							return true;
						}
						else if(!board.getPiece(fromrow,fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							return true;
						}
						else{
							return false;
						}
					}
					if(board.getPiece(row-1, destcol) == null){
						
					}
					else {
						//ENCOUNTER
							return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
