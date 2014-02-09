package chess.model;

public abstract class ChessPiece {
	private String name;
	private boolean alive;
	private String team;
	
	public ChessPiece(String name, String team){
		this.name = name;
		this.alive = true;
		this.team = team;
	}
	
	public String getTeam(){
		return team;
	}
		
	public String getName(){
		return name;
	}
	public abstract boolean move(int fromrow, int fromcol, int destrow, int destcol);
	
	public abstract boolean isPossibleMove(int fromrow, int fromcol, int destrow, int destcol);
	
	public abstract boolean isPossibleCheckMove(int fromrow, int fromcol, int destrow, int destcol);
}
