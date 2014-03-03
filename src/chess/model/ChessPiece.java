package chess.model;

public abstract class ChessPiece {
	private String name;
	private boolean alive;
	private String team;
	ChessBoard board;	
	
	public ChessPiece(String name, String team, ChessBoard board){
		this.name = name;
		this.alive = true;
		this.team = team;
		this.board = board;
	}
	
	public String getTeam(){
		return team;
	}
		
	public String getName(){
		return name;
	}
	public abstract boolean move(int fromrow, int fromcol, int destrow, int destcol);
	
	public abstract boolean isPossibleMove(int fromrow, int fromcol, int destrow, int destcol, boolean checker);
	
	public abstract boolean isPossibleCheckMove(int fromrow, int fromcol, int destrow, int destcol);
	
	public boolean checkForCheckMove(int fromrow, int fromcol, int destrow, int destcol){
		boolean result = true;
		ChessPiece movingPiece = board.getPiece(fromrow, fromcol);
		ChessPiece tmpPiece = board.getPiece(destrow, destcol);
		board.setPiece(destrow, destcol, movingPiece);
		board.setPiece(fromrow, fromcol, null);
		if(board.checkForCheck() == board.getTurn()) result = false;
		board.setPiece(fromrow, fromcol, movingPiece);
		board.setPiece(destrow, destcol, tmpPiece);
		return result;
	}
}
