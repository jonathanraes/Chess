package chess.model;


public class Rook extends ChessPiece {
	 ChessBoard board;
	public Rook(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}

	public boolean move(int fromrow, int fromcol, int destrow, int destcol){
		if(fromrow == destrow){ 
			//vertical movement
			if(destcol < fromcol){ //moving downwards
				for(int col = fromcol; col > destcol; col--){
					if(board.getPiece(destrow, col-1) == null){
						
					}
					else if((board.getPiece(destrow, col-1).getTeam().equals("Black") && this.getTeam().equals("White")) || (board.getPiece(destrow, col-1).getTeam().equals("White") && this.getTeam().equals("Black"))){
						//ENCOUNTER
						if(board.encounter(fromrow, fromcol, destrow, col-1)){
							return true;
						}
						else{ //failed to move (error message)
							System.err.println("Fail!"); 
							return false;
						}
					}
					else{
						System.out.println("Invalid move!");
						return false;
					}
				}
				board.move(fromrow, fromcol, destrow, destcol);
				return true;
				
			}
			else{ //moving upwards	
				for(int col = fromcol; col < destcol; col++){
					if(board.getPiece(destrow, col+1) == null){
						
					}
					else if((board.getPiece(destrow, col+1).getTeam().equals("Black") && this.getTeam().equals("White")) || (board.getPiece(destrow, col+1).getTeam().equals("White") && this.getTeam().equals("Black"))){
						//ENCOUNTER
						if(board.encounter(fromrow, fromcol, destrow, col+1)){
							return true;
						}
						else{ //failed to move (error message)
							System.out.println("Fail!"); 
							return false;
						}
					}
					else{ //either there is a own teams piece in the way or move is against the rules
						System.out.println("Invalid move!");
						return false;
					}
				}
				board.move(fromrow, fromcol, destrow, destcol);
				return true;
				
			}
		}
		else if(fromcol == destcol){ 
			//horizontal movement
			if(fromrow < destrow){ //moving to the right
				for(int row = fromrow; row < destrow; row++){
					if(board.getPiece(row+1, fromcol) == null){
						
					}
					else if((board.getPiece(row+1, destcol).getTeam().equals("Black") && this.getTeam().equals("White")) || (board.getPiece(row+1, destcol).getTeam().equals("White") && this.getTeam().equals("Black"))){
						//ENCOUNTER
						if(board.encounter(fromrow, fromcol, row+1, destcol)){
							return true;
						}
					}
					else{
						System.out.println("Invalid move!");
						return false;
					}
				}
				board.move(fromrow, fromcol, destrow, destcol);
				return true;
			}
			else{ //moving to the left
				for(int row = fromrow; row > destrow; row--){
					if(board.getPiece(row-1, fromcol) == null){
						
					}
					else if((board.getPiece(row-1, destcol).getTeam().equals("Black") && this.getTeam().equals("White")) || (board.getPiece(row-1, destcol).getTeam().equals("White") && this.getTeam().equals("Black"))){
						//ENCOUNTER
						if(board.encounter(fromrow, fromcol, row-1, destcol)){
							return true;
						}
					}
					else{
						System.out.println("Invalid move!");
						return false;
					}
				}
				board.move(fromrow, fromcol, destrow, destcol);
				return true;
			}
		}
		System.out.println("Invalid move!");
		return false;
	}

	@Override
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow,
			int destcol) {
		if(fromrow == destrow){ 
			//vertical movement
			if(destcol < fromcol){ //moving downwards
				for(int col = fromcol; col > destcol; col--){
					if(col-1 == destcol){
						if(board.getPiece(destrow, destcol) == null){
							return true;
						}
						else if(!board.getSelectedPiece().getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							String selected = board.getSelectedPiece().getTeam();
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
						else if(!board.getSelectedPiece().getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							String selected = board.getSelectedPiece().getTeam();
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
						else if(!board.getSelectedPiece().getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
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
						else if(!board.getSelectedPiece().getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
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
		System.out.println("Invalid move!");
		return false;
	}
}
