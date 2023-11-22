/** -------------------------------------------------------
 * Assignment (1)
 * Due February 07th
 * Written by: (Natasha Uwase)
 * For COMP 249 Section (WW) – Winter 2022
 * --------------------------------------------------------
 * this is a testing class for classes player and ladderandsnake
 * main feature is that the programm asks user to enter the number of players and their names
 * and then implements the two classes player and ladderandsnake
 */
import java.util.Scanner;
import java.util.Random;
public class Driver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbrplayers;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of players: ");
		//loop to ask user number and names of players and store the info
		do{
			nbrplayers = scanner.nextInt();
			if(nbrplayers<2 || nbrplayers>4) {
				System.out.println("Please enter a number that is between 2 and 4 inclusive. Please enter the number of players: ");
			}
		}while(nbrplayers<2 || nbrplayers>4);
		System.out.println("Please enter the names of the players separated by a space(ex: natasha stella ange): ");
		String[] myNames = new String[nbrplayers];
		Player[] myPlayers = new Player[nbrplayers];
		for(int i=0;i<myNames.length;i++) {
			myNames[i] = scanner.next();
			Player myplayer = new Player(myNames[i]);
			myPlayers[i] = myplayer;
		}
		LadderAndSnake playersLAS = new LadderAndSnake(myPlayers);
		int currentRoll = 0;
		int count = 0;
		boolean checker = false;
		//do while loop to determine for players to roll until there are no ties
		do {//loop for first round dice flipping
			for(int k=0;k<myPlayers.length;k++) {
				if(myPlayers[k].getRolledNbr()==0) {
					currentRoll = playersLAS.flipDice();
					myPlayers[k].setRolledNbr(currentRoll);
					System.out.println(myPlayers[k].getName()+" rolled "+currentRoll+".");
				}
			}//loop for reseting the tied players as a way to track the tied players
			for(int i=0;i<myPlayers.length;i++) {
				for(int j=0;j<myPlayers.length;j++) {
					if(i!=j && i<j && myPlayers[i].getRolledNbr() == myPlayers[j].getRolledNbr()){
						System.out.println("A tie was achieved between "+myPlayers[i].getName()+" and "+myPlayers[j].getName());
						myPlayers[i].setRolledNbr(0);
						myPlayers[j].setRolledNbr(0);
					}
				}
			}//loop to keep track if no players are tied to exist the do while loop
			for(int k=0;k<myPlayers.length;k++) {
				if(myPlayers[k].getRolledNbr() == 0) {checker = true;count = 0;}
				if(myPlayers[k].getRolledNbr() != 0) {count+=1;}
			}//statement to exit do while loop if no players are tied
			if(count == myPlayers.length+1) {checker = false;break;}
		}while(checker);
		//sorting the players according to their rolls to determine the order
		System.out.print("NO TIES AMONG PLAYERS. Reached final decision on order of playing: ");
		for(int i=0;i<myPlayers.length;i++) {
			Player temp = new Player();
			for(int j=i+1;j<myPlayers.length;j++) {
				if(myPlayers[i].getRolledNbr() < myPlayers[j].getRolledNbr()) {
					temp = myPlayers[i];
					myPlayers[i] = myPlayers[j];
					myPlayers[j] = temp;
				}
			}
		}
		//loop to print the order of playing
		for(int i=0;i<myPlayers.length;i++) {
			System.out.print(myPlayers[i].getName()+" ");
		}
		System.out.println();
		//assiging levels to players after dice rolling with no ties
		for(int i=0;i<myPlayers.length;i++) {
			int postionafterflip = myPlayers[i].getRolledNbr();
			myPlayers[i].setRolledNbr(postionafterflip);
			playersLAS.play(myPlayers[i]);
		}
		//part which is the actual game playing or remainder of the game until players decide to end the game or someone wins
		String answer;
		boolean continueGame = true;
		do {//loop to ensure the game ends if there is a winner
			for(int k=0;k<myPlayers.length;k++) {
				if(myPlayers[k].getPosition() == 100) {
					System.out.println(myPlayers[k].getName()+" HAS WON, THE GAME IS OVER!");continueGame = false;}
			}
			if(continueGame == false) {break;}
		System.out.println("Would you like to roll the dice and continue the game??? Type yes or no: ");
		answer = scanner.next();
		if(answer.equalsIgnoreCase("yes")) {
			for(int k=0;k<myPlayers.length;k++) {
				currentRoll = playersLAS.flipDice();
				myPlayers[k].setRolledNbr(currentRoll);
				playersLAS.play(myPlayers[k]);
			}
		}
		else{System.out.println("You're exiting the game. Goodbye.");}
		}while(answer.equalsIgnoreCase("yes") && continueGame);
		scanner.close();
	}

}
