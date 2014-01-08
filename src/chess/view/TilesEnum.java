package chess.view;

public enum TilesEnum {

	T56(0,7),  T57(1,7),  T58(2,7),	T59(3,7),	T60(4,7),	T61(5,7),	T62(6,7),	T63(7,7),
	T48(0,6), T49(1,6), T50(2,6), T51(3,6), T52(4,6), T53(5,6), T54(6,6), T55(7,6),
	T40(0,5), T41(1,5), T42(2,5), T43(3,5), T44(4,5), T45(5,5), T46(6,5), T47(7,5),
	T32(0,4), T33(1,4), T34(2,4), T35(3,4), T36(4,4), T37(5,4), T38(6,4), T39(7,4),
	T24(0,3), T25(1,3), T26(2,3), T27(3,3), T28(4,3), T29(5,3), T30(6,3), T31(7,3),
  	T16(0,2), T17(1,2), T18(2,2), T19(3,2), T20(4,2), T21(5,2), T22(6,2), T23(7,2),
 	T8(0,1), T9(1,1), T10(2,1), T11(3,1), T12(4,1), T13(5,1), T14(6,1), T15(7,1),
 	T0(0,0), T1(1,0), T2(2,0), T3(3,0), T4(4,0), T5(5,0), T6(6,0), T7(7,0);
	
	
	private final int col;
	private final int row;
	
	TilesEnum(int col,int row){
		this.col = col;
		this.row = row;
	}

	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public static int getall(String nr){
		
		return 0;
	}
}
