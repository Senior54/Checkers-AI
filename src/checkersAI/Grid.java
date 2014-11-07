package checkersAI;

public class Grid {
	String str = "";
	int location;
	
	// default constructor
	public Grid(int i) {
		this.location = i;
		if (i < 10)
			this.str = "" + i + "  ";
		else
			this.str = "" + i + " ";
	}
	
	public void setStr(String piece) {
		if (this.location < 10)
			this.str = "" + piece + " ";
		else
			this.str = "" + piece + "";
		//this.str = piece;
	}
	
	public void resetStr() {
		
	}
	
	public String getGridString() {
		return this.str;
	}
}
