package chess.model;


public class Queen extends ChessPiece {
	
	public Queen(String name, String team, ChessBoard board) {
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
		if(fromrow == destrow && fromcol == destcol){
			return false;
		}
		if(fromrow == destrow){ 
			//vertical movement
			if(destcol < fromcol){ //moving downwards
				for(int col = fromcol; col > destcol; col--){
					if(col-1 == destcol){
						if(board.getPiece(destrow, destcol) == null){
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
						}
						else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							String selected = board.getPiece(fromrow, fromcol).getTeam();
							String dest = board.getPiece(fromrow, destcol).getTeam();
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
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
				return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
			}
			else{ //moving upwards	
				for(int col = fromcol; col < destcol; col++){
					if(col+1 == destcol){
						if(board.getPiece(destrow, destcol) == null){
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
						}
						else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							String selected = board.getPiece(fromrow, fromcol).getTeam();
							String dest = board.getPiece(fromrow, destcol).getTeam();
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
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
				return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
				
			}
		}
		else if(fromcol == destcol){ 
			//horizontal movement
			if(fromrow < destrow){ //moving to the right
				for(int row = fromrow; row < destrow; row++){
					if(row+1 == destrow){
						if(board.getPiece(destrow, destcol) == null){
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
						}
						else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
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
				return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
			}
			else{ //moving to the left
				for(int row = fromrow; row > destrow; row--){
					if(row-1 == destrow){
						if(board.getPiece(destrow, destcol) == null){
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
						}
						else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
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
				return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
			}
		}
		else if(Math.abs(( (double)destcol - (double)fromcol)/((double)destrow-(double)fromrow)) == 1.0){
			try{
			if(destrow-fromrow > 0 && destcol - fromcol > 0){ //up right
				for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
					if(fromrow + i == destrow && fromcol + i == destcol){ 
						if(board.getPiece(destrow, destcol) == null){
							return checker ? true : checkForCheckMove(fromrow, fromcol, destrow, destcol);
						}
						else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
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
							else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
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
						else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
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
						else if(!board.getPiece(fromrow, fromcol).getTeam().equals(board.getPiece(destrow, destcol).getTeam())){
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
		catch(ArithmeticException e){
			return false;
		}
		catch(NumberFormatException e){
			System.out.println("NFE QUEEN");
			return false;
		}
	}
	return false;
	}
}
