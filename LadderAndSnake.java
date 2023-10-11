/** -------------------------------------------------------
 * Assignment (1)
 * Due February 07th
 * Written by: (Natasha Uwase 40212108)
 * For COMP 249 Section (WW) – Winter 2022
 * --------------------------------------------------------
 * This class has methods flip and play for playing the game
 * and takes on attributes
 * @param board array
 * @param players array
 */
public class LadderAndSnake {
	private int[][] board = new int[10][10];
	private Player[] p; //p is an array of players
	public LadderAndSnake(Player[] p) {
		this.p = p;
	}
	//method generates a random number between 1-6(rolling of the dice) and also determines the order of playing
	public int flipDice() {
		int number;
		double temp;
		do {
			temp = Math.random()*10;
		}while(temp<1 || temp>7);
		int randomNumber = (int) temp;
		number = randomNumber;
		return number;
	}
	//method that implements the game
	public void play(Player p) {
		int rolledNumber = p.getRolledNbr();
		int position = p.getPosition();
		position+= rolledNumber;
		if(position>100) {
			int a = position - 100;
			int b = 100 - a;
			position = b;
		}
		switch(position) {
			case 100: System.out.println(p.getName()+" moved to square 100. COGRATULATIONS!!! YOU WON!"); break;
		//from head of snake to tail of snake
			case 98: position = 78; System.out.println(p.getName()+" moved to square 98 then down to square 78"); break;
			case 97: position = 76; System.out.println(p.getName()+" moved to square 97 then down to square 76"); break;
			case 95: position = 24; System.out.println(p.getName()+" moved to square 95 then down to square 24"); break;
			case 93: position = 68; System.out.println(p.getName()+" moved to square 93 then down to square 68"); break;
			case 79: position = 19; System.out.println(p.getName()+" moved to square 79 then down to square 19"); break;
			case 64: position = 60; System.out.println(p.getName()+" moved to square 64 then down to square 78"); break;
			case 48: position = 30; System.out.println(p.getName()+" moved to square 48 then down to square 30"); break;
			case 16: position = 6; System.out.println(p.getName()+" moved to square 16 then down to square 6"); break;
		//from bottom of ladder to top of ladder
			case 80: position = 100; System.out.println(p.getName()+" moved to square 80 then up to square 100."+" COGRATULATIONS!!! YOU WON!"); break;
			case 71: position = 91; System.out.println(p.getName()+" moved to square 71 then up to square 91"); break;
			case 28: position = 84; System.out.println(p.getName()+" moved to square 28 then up to square 84"); break;
			case 51: position = 67; System.out.println(p.getName()+" moved to square 51 then up to square 67"); break;
			case 36: position = 44; System.out.println(p.getName()+" moved to square 36 then up to square 44"); break;
			case 21: position = 42; System.out.println(p.getName()+" moved to square 21 then up to square 42"); break;
			case 1: position = 38; System.out.println(p.getName()+" moved to square 1 then up to square 38"); break;
			case 9: position = 31; System.out.println(p.getName()+" moved to square 9 then up to square 31"); break;
			case 4: position = 14; System.out.println(p.getName()+" moved to square 4 then up to square 14"); break;
			default: System.out.println(p.getName()+" moved to square "+position);
		}
		p.setPosition(position);
	}
}