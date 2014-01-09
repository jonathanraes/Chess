package chess.model;


public class Knight extends ChessPiece {
	 ChessBoard board;
	public Knight(String name, String team, ChessBoard board) {
		super(name, team);
		this.board = board;
	}

	@Override
	public boolean move(int fromrow, int fromcol, int destrow, int destcol) {
		board.move(fromrow, fromcol, destrow, destcol);
		return true;
	}

	@Override
	public boolean isPossibleMove(int fromrow, int fromcol, int destrow,
			int destcol) {
		// TODO Auto-generated method stub
		return false;
	}

}
