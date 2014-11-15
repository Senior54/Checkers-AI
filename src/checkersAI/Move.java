package checkersAI;

//this class is to store a move, which it records the row
//and col of a move, so when AI generating moves, this obj can be
//created and add to arrayList
public class Move {
private int row;
private int col;

public Move(int row, int col){
	this.row = row;
	this.col = col;
}
public int getMovesRow()
{
	return row;
}
public int getMovesCol(){
	return col;
}
}
