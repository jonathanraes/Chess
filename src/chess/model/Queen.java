package chess.model;


public class Queen extends ChessPiece {
	ChessBoard board;
	
	public Queen(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}

	@Override
	public boolean move(int fromrow, int fromcol, int destrow, int destcol) {
		if(fromrow == destrow){ 
			//vertical movement'
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
				board.move(fromrow, fromcol, destrow, destcol); //has not run into any complications
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
		if(Math.abs((destcol - fromcol)/(destrow-fromrow)) == 1){ //diagonal
			if(destrow-fromrow > 0 && destcol - fromcol > 0){ //up right
			for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
				if(board.getPiece(fromrow+i, fromcol+i) != null){
					if((board.getPiece(fromrow+i, fromcol+i).getTeam().equals("White") && (this.getTeam().equals("Black"))) || (board.getPiece(fromrow+i, fromcol+i).getTeam().equals("White") && (this.getTeam().equals("Black")))){
				//encounter
				board.encounter(fromrow, fromcol, destrow, destcol);
					}
					else{
						System.out.println("Invalid move!");
						return false;
					}
				}
				
			}
			board.move(fromrow, fromcol, destrow, destcol);	
			return true;
			}
			else if(destrow - fromrow < 0 && destcol - fromcol > 0){ //up left
					for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
						if(board.getPiece(fromrow-i, fromcol+i) != null){
							if((board.getPiece(fromrow-i, fromcol+i).getTeam().equals("White") && (this.getTeam().equals("Black"))) || (board.getPiece(fromrow-i, fromcol+i).getTeam().equals("White") && (this.getTeam().equals("Black")))){
						//encounter
						board.encounter(fromrow, fromcol, destrow, destcol);
							}
							else{
								System.out.println("Invalid move!");
								return false;
							}
						}
						
					}
					board.move(fromrow, fromcol, destrow, destcol);	
					return true;
			}
			else if(destrow-fromrow < 0 && destcol - fromcol < 0){ //down left
				for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
					if(board.getPiece(fromrow-i, fromcol-i) != null){
						if ((board.getPiece(fromrow-i, fromcol-i).getTeam().equals("White") && (this.getTeam().equals("Black"))) || (board.getPiece(fromrow-i, fromcol-i).getTeam().equals("White") && (this.getTeam().equals("Black")))){
						//encounter
						board.encounter(fromrow, fromcol, destrow, destcol);
						
						}
						else{
							System.out.println("Invalid move!");
							return false;
						}
					}
				}	
				board.move(fromrow, fromcol, destrow, destcol);
				return true;
			}
			else if(destrow-fromrow > 0 && destcol - fromcol < 0){ //down right
				for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
					if(board.getPiece(fromrow+i, fromcol-i) != null){
						if ((board.getPiece(fromrow-i, fromcol-i).getTeam().equals("White") && (this.getTeam().equals("Black"))) || (board.getPiece(fromrow-i, fromcol-i).getTeam().equals("White") && (this.getTeam().equals("Black")))){
						//encounter
						board.encounter(fromrow, fromcol, destrow, destcol);
						
						}
						else{
							System.out.println("Invalid move!");
							return false;
						}
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
		else if(Math.abs(( (double)destcol - (double)fromcol)/((double)destrow-(double)fromrow)) == 1.0){
			try{
			if(destrow-fromrow > 0 && destcol - fromcol > 0){ //up right
				for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
					if(fromrow + i == destrow && fromcol + i == destcol){ 
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
					else if(board.getPiece(fromrow+i, fromcol+i) == null){
						
					}
					else {
						//ENCOUNTER
						return false;
					}
				}
				return true;
			}
			else if(destrow - fromrow < 0 && destcol - fromcol > 0){ //up left
					for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
						if(fromrow - i == destrow && fromcol + i == destcol){ 
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
						else if(board.getPiece(fromrow-i, fromcol+i) == null){
							
						}
						else {
							//ENCOUNTER
							return false;
						}
					}
				return true;
			}
			else if(destrow-fromrow < 0 && destcol - fromcol < 0){ //down left
				for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
					if(fromrow - i == destrow && fromcol - i == destcol){ 
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
					else if(board.getPiece(fromrow-i, fromcol-i) == null){
						
					}
					else {
						//ENCOUNTER
						return false;
					}
				}
			return true;
			}
			else if(destrow-fromrow > 0 && destcol - fromcol < 0){ //down right
				for(int i = 1; i <= Math.abs(fromrow-destrow); i++){
					if(fromrow + i == destrow && fromcol - i == destcol){ 
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
					else if(board.getPiece(fromrow+i, fromcol-i) == null){
						
					}
					else {
						//ENCOUNTER
						return false;
					}
				}
			return true;
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
