package chess.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import chess.model.Board;
import chess.model.ChessBoard;
import chess.view.MainFrame;
import chess.view.Tile;
import chess.view.TilesEnum;
import chess.view.TimePanel;

public class Controller extends MouseAdapter implements ActionListener, KeyListener{
	int fromrow;
	int fromcol;
	int destrow;
	int destcol;
	byte[] cs;
	ChessBoard board;
	MainFrame mainframe;
	TimePanel timepanel;
	
	public Controller(ChessBoard board, MainFrame mainframe, TimePanel timepanel) {
		this.board = board;
		this.mainframe = mainframe;	
		this.timepanel = timepanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Tile clickedtile = (Tile) e.getSource();
		for(TilesEnum tiles: TilesEnum.values()){
			if(tiles.name().substring(1).equals(clickedtile.getTileNumber())){
				if(board.getPiece(tiles.getCol(),tiles.getRow()) != null){
					//A piece is clicked
					if(board.getSelectedPiece() == null){
						//there is no selected piece
						fromrow = tiles.getCol();
						fromcol = tiles.getRow();
						if(board.getPiece(fromrow, fromcol).getTeam().equals(board.getTurn())){//checking if the piece to select is the right team
							board.setSelectedPiece(board.getPiece(tiles.getCol(),tiles.getRow()));
							mainframe.setSelctedPiecePaneText(board.getSelectedPiece().getName() +" is selected");
							board.setChangedandNotify();
							return;
						}
						else{
							//TODO pop up window/message
						}
					}
					else{//There is a selected piece
						destrow = tiles.getCol();
						destcol = tiles.getRow();
						if(board.getPiece(destrow, destcol).getTeam().equals(board.getSelectedPiece().getTeam())){
							//own team member is clicked
							board.setSelectedPiece(null);
							mainframe.setSelctedPiecePaneText("No selected piece");
							board.setChangedandNotify();
							return;
							//TODO message saying impossible move
						}
						else{//moving to another piece
							if(board.getSelectedPiece().move(fromrow, fromcol, destrow, destcol)){//trying t move
								//succesful move
								board.setSelectedPiece(null);
								board.setChangedandNotify();
								mainframe.setSelctedPiecePaneText("No selected piece");
								board.changeTurn();
								mainframe.setPaneText(board.getTurn());
								return;
							}
							else{
								return;
								//unsuccesful move
								//TODO message saying impossible move
							}
						}
					}
				}
				else{
					//no piece is clicked
					if(board.getSelectedPiece() != null){
						//there is a selected piece
						destcol = tiles.getRow();
						destrow = tiles.getCol();
						if(board.getSelectedPiece().move(fromrow, fromcol, destrow, destcol)){//trying to move
							//succesful move
							board.setSelectedPiece(null);
							board.setChangedandNotify();
							mainframe.setSelctedPiecePaneText("No selected piece");
							board.changeTurn();
							mainframe.setPaneText(board.getTurn());
							return;
						}
						else{
							//unsuccesful move
							//TODO message saying impossible move
							return;
						}
					}
				}
				
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New Game")){
			board.endGame();
			mainframe.setPaneText(board.getTurn());
			mainframe.emptyFallenPiecesPanel();
			timepanel.resetTimer();
		}
		if(e.getActionCommand().equals("Exit")){
			System.exit(0);
		}
		if(e.getActionCommand().equals("Color Settings")){
			if(mainframe.getCSettingsOpened()){
				mainframe.openColorSettings();
			}else{
				mainframe.colorSettingMenu();
				mainframe.setCSettingsOpened(true);
			}
		}
		if(e.getActionCommand().equals("OK")){
			mainframe.closeColorSettings();
			mainframe.setPaneText(board.getTurn());
		}
		if(e.getSource() instanceof JRadioButton){
			cs = ChessBoard.getColorSetting();
			byte t1 = cs[0];
			byte t2 = cs[1];
			String actioncommand = ((JRadioButton) e.getSource()).getName();
			switch (actioncommand) {
				case "team1white":
					board.setColorSetting((byte)0,t2);
					break;
				case "team1black":
					board.setColorSetting((byte)1, t2);
					break;
				case "team1blue":
					board.setColorSetting((byte)2, t2);
					break;
				case "team1brown":
					board.setColorSetting((byte)3, t2);
					break;
				case "team1green":
					board.setColorSetting((byte)4, t2);
					break;
				case "team1red":
					board.setColorSetting((byte)5, t2);
					break;
				case "team1violet":
					board.setColorSetting((byte)6, t2);
					break;
				case "team1yellow":
					board.setColorSetting((byte)7, t2);
					break;
				case "team2white":
					board.setColorSetting(t1,(byte)0);
					break;
				case "team2black":
					board.setColorSetting(t1,(byte)1);
					break;
				case "team2blue":
					board.setColorSetting(t1,(byte)2);
					break;
				case "team2brown":
					board.setColorSetting(t1,(byte)3);
					break;
				case "team2green":
					board.setColorSetting(t1,(byte)4);
					break;
				case "team2red":
					board.setColorSetting(t1,(byte)5);
					break;
				case "team2violet":
					board.setColorSetting(t1,(byte)6);
					break;
				case "team2yellow":
					board.setColorSetting(t1,(byte)7);
					break;
			}
//			if (f.getText().equals("Enable")){
//				
//			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	char typedchar;
	byte typednumber;
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		if(String.valueOf(arg0.getKeyChar()).matches("[a-hA-H]")){
			typedchar = arg0.getKeyChar();
		}
		else if(String.valueOf(arg0.getKeyChar()).matches("[1-9]")){
			byte typednumber = (byte)arg0.getKeyChar();
			String tile = "" + typedchar + typednumber;
			for(Board places: Board.values()){
				if(places.name().equals(tile)){
					if(board.getPiece(places.getRow(), places.getCol()) != null){
						
					}
				}
			}
		}
	}
}
