package objects;

public class Brick {

	// les attibuts
	private int x , y, width,height; // les coordonnees x, y, la largeur, la hauteur de la brique 

	private  int type;  // le type de la brique

	private  int value; // la valeur de la brique ou son score

	private int numberOfColision; //nombre de collision que doit avoir une brique avant d'etre detruite

	public int note; // le son de la brique lors de la collision

	/**
	 * constructeur init une brique
	 * @param x la coordonnee x de la brique
	 * @param y la coordonnee  y de la brique
	 * @param width la largeur de la brique
	 * @param height la hauteur de la brique
	 * @param type le type de la brique
	 * @param value la valeur de la brique ou son score
	 * @param numberOfColision nombre de collision que doit avoir une brique avant d'etre detruite
	 * @param note le son de la brique lors de la collision
	 */
	public Brick(int x, int y, int width, int height, int type,int value,int numberOfColision,int note) {

		this.x = x;

		this.y = y;

		this.width = width;

		this.height = height;

		this.type = type;

		this.value = value*10;

		this.note = note;

		this.numberOfColision = numberOfColision ;

	}

	/**
	 * @return x la coordonnee x de la brique
	 */

	public int getX() {

		return x;
	}

	/**
	 * @param x met a jour la coordonnee x de la brique
	 */
	public void setX(int x) {

		this.x = x;

	}

	/**
	 * @param y met a jour la coordonne y 
	 */
	public void setY(int y) {

		this.y = y;

	}
	
	/**
	 * @return y la coordonnee y de la brique
	 */
	public int getY() {

		return y;

	}



	/**
	 * @return height la hauteur de la brique
	 */

	public int getHeight(){

		return this.height;

	}

	/**
	 * @return width la largeur de la brique
	 */

	public int  getWidth() {

		return this.width;

	}

	/**
	 * @param width met a jour la largeur de la brique
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	public int getType() {

		return type;

	}

	/**
	 * @param type met a jour le type de la brique
	 */
	public void setType(int type) {

		this.type = type;

	}

	/**
	 * @return value la valeur de la brique
	 */
	public int getValue() {

		return value;

	}

	/**
	 * @param value met a jour la valeur de la brique
	 */
	public void setValue(int value) {

		this.value = value;

	}


	/**
	 * @return numberOfColision le nombre collision que peut avoir une brique
	 */
	public int getNumberOfColision() {

		return numberOfColision;
	}

	/**
	 * @param numberOfColision met a jour le nombre de collision que peut avoir une brique
	 */
	public void setNumberOfColision(int numberOfColision) {

		this.numberOfColision = numberOfColision;
	}



}
