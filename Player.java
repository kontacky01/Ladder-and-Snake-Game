/** -------------------------------------------------------
 * Assignment (1)
 * Due February 07th
 * Written by: (Natasha Uwase)
 * For COMP 249 Section (WW) – Winter 2022
 * --------------------------------------------------------
 * this class determines characteristics of each player
 * it takes on attributes
 * @param name which stores the name of player
 * @param square which stores the position of player
 * @param rolledNbr which stores the rolled value of player from rolling the dice
 * players generated by this class will be used to play ladder and snake
 * with the use of laderand snake class
 */
public class Player {
	private String name;
	private int square;
	private int rolledNbr;
	//constructors
	public Player() {}
	public Player(String name) {
		this.name = name;
	}
	//accessor and mutator methods
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return square;
	}
	public void setPosition(int square) {
		this.square = square;
	}
	public int getRolledNbr() {
		return rolledNbr;
	}
	public void setRolledNbr(int rolledNbr) {
		this.rolledNbr = rolledNbr;
	}
}
