
/**
 * Create a class called Candle to represent a candle An integer for the height,
 * an integer for the width, a float for the price and a boolean to determine if
 * the candle is lit or not
 * 
 * @author melaniebeni
 *
 */
public class Candle {
	// instance variables
	private int height;
	private int width;
	private float price;
	private boolean lit;

	// get and set methods for variables
	public Candle(int h, int w, float p) {
		height = h;
		width = w;
		price = p;
		lit = false;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int newH) {
		height = newH;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int newW) {
		width = newW;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(int newP) {
		price = newP;
	}

	public boolean getLit() {
		return lit;
	}

	public void setLit(boolean newL) {
		lit = newL;
	}

//Override the method toString which should return the Candle information
	public String toString() {
		return height + "," + width + "," + price;
	}

//Override the CompareTo method to compare candle objects
	public boolean compareTo(Object other) {
		Candle o = (Candle) other;
		if (o.getPrice() < this.getPrice()) {
			return true;
		} else
			return false;
	}

}
