package chess.view;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tile extends JPanel{
	private int tilenumber;

	public Tile(int number){
		this.tilenumber = number;
	}
	
	public String getTileNumber(){
		return "" +tilenumber;
	}
	
	public int getNumber(){
		return tilenumber;
	}
	public String toString(){
		String tile = "" + tilenumber;
		return tile;
	}
}
