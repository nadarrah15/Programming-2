public class Coin {
	
	//square specifies the location of the square (1D grid)
	//position specifies how high up it must be, 0 is the bottom
	private int radius, square, position;

	public Coin(int m) {
		radius = m;
	}

	public int getRadius() {
		return radius;
	}

	public void setPosition(int square, int position) throws Exception {
		this.square = square;
		if(position < 0)
			throw new Exception("Position must be >= 0");
		else
			this.position = position;
	}
	
	public boolean comparePosition(Coin o){
		if(o.square == square && o.position == position){
			return true;
		}
		else 
			return false;
	}
}