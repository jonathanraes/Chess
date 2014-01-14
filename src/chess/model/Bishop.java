package chess.model;

public class Bishop extends ChessPiece {
ChessBoard board;

	public Bishop(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}

	@Override
	public boolean move(int fromrow, int fromcol, int destrow, int destcol) {
		if(Math.abs((destcol - fromcol)/(destrow-fromrow)) == 1){
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
			System.out.println("Invalid move!");
			return false;
		}

	@Override
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow,
			int destcol) {
		try{
			if(Math.abs(( (double)destcol - (double)fromcol)/((double)destrow-(double)fromrow)) == 1.0){
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
