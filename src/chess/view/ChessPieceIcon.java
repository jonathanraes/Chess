package chess.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chess.model.Bishop;
import chess.model.ChessBoard;
import chess.model.ChessPiece;
import chess.model.King;
import chess.model.Knight;
import chess.model.Pawn;
import chess.model.Queen;
import chess.model.Rook;

@SuppressWarnings("serial")
public class ChessPieceIcon extends JLabel{
	ImageIcon ICON;
	boolean isSelected = false;
	int number;
	boolean marked = false;
	public ChessPieceIcon(ChessPiece piece){
		/**
		 * 0 = WHITE
		 * 1 = BLACK
		 * 2 = BLUE
		 * 3 = BROWN
		 * 4 = GREEN
		 * 5 = RED
		 * 6 = VIOLET
		 * 7 = YELLOW
		 */
		String color1 = "";
		String color2 = "";
		byte[] colorsetting = ChessBoard.getColorSetting();
		
		switch (colorsetting[0]) {
		case 0:
			color1 = "White";
			break;
		case 1:
			color1 = "Black";
			break;
		case 2:
			color1 = "Blue";
			break;
		case 3:
			color1 = "Brown";
			break;
		case 4:
			color1 = "Green";
			break;
		case 5:
			color1 = "Red";
			break;
		case 6:
			color1 = "Violet";
			break;
		case 7:
			color1 = "Yellow";
			break;
		default:
			break;
		}
		
		
		switch (colorsetting[1]) {
		case 0:
			color2 = "White";
			break;
		case 1:
			color2 = "Black";
			break;
		case 2:
			color2 = "Blue";
			break;
		case 3:
			color2 = "Brown";
			break;
		case 4:
			color2 = "Green";
			break;
		case 5:
			color2 = "Red";
			break;
		case 6:
			color2 = "Violet";
			break;
		case 7:
			color2 = "Yellow";
			break;
		default:
			break;
		}		
		//if(number == 0 ){ setBackground(Color.yellow);}
		String absolutePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
			if(piece instanceof Pawn){
				if(piece.getTeam().equals("Black")){
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color2 + " P.png"));
				}
				else{
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color1 + " P.png"));
				}
				setIcon(ICON);
			}
			else if(piece instanceof Rook){
				if(piece.getTeam().equals("Black")){
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color2 + " R.png"));				
					
				}
				else{
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color1 + " R.png"));				
					}
				setIcon(ICON);
			}
			else if(piece instanceof Knight){
				if(piece.getTeam().equals("Black")){
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color2 + " N.png"));
				}
				else{
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color1 + " N.png"));				
					}
				setIcon(ICON);
			}
			else if(piece instanceof Bishop){
				if(piece.getTeam().equals("Black")){
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color2 + " B.png"));				
				
				}
				else{
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color1 + " B.png"));				
					}
				setIcon(ICON);
			}
			else if(piece instanceof King){
				if(piece.getTeam().equals("Black")){
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color2 + " K.png"));				
				}
				else{
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color1 + " K.png"));				
				}
				setIcon(ICON);
			}
			else if(piece instanceof Queen){
				if(piece.getTeam().equals("Black")){
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color2 + " Q.png"));				
				}
				else{
					ICON = new ImageIcon(getClass().getClassLoader().getResource("Icons/" + color1 + " Q.png"));				
				}
				setIcon(ICON);
			}
	}
	
	public boolean returnSelected(){
		return isSelected;
		
	}
	
	public void setSelected(boolean b){
		isSelected = b;
		return;
	}
	
	public void setMarked(boolean m){
		marked=m;
	}
	
	public boolean getMarked(){
		return marked;
	}
	
	public void removeIcon(){
		this.removeIcon();
		return;
	}
	
	

}
