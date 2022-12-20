/*
 * Advent of Code 2022
 * Written by: Tim Norman
 * Created: 18 Dec 2022
 * Last modified: 18 Dec 2022
 */

/*
 * Worker class with constructor for a round of Rock-Paper-Scissors. Calculates 
 * points for result and  "shape" selected. 
 */
public class Round {
	/*
	 * Declarations
	 */
//	private String opponentChoice;
//	private String myChoice;
//
//	public String getOpponentChoice() {
//		return opponentChoice;
//	}
//
//	public void setOpponentChoice(String opponentChoice) {
//		this.opponentChoice = opponentChoice;
//	}
//
//	public String getMyChoice() {
//		return myChoice;
//	}
//
//	public void setMyChoice(String myChoice) {
//		this.myChoice = myChoice;
//	}

	private Round() {

	}
	

	
	/*
	 * This method combines points from winning a round and the shape selected 
	 * and returns pointsTotal. 
	 */
	public static int points(String opponentChoice, String myChoice) {
		int pointsTotal = 0;
		pointsTotal = result(opponentChoice, myChoice) + shapePoints(myChoice);
		return pointsTotal;
	}
	
	/*
	 * This method calculates total points based on the second method of
	 * scoring (given the opponent's choice and my strategy). 
	 */
	public static int points2(String opponentChoice, String myStrat) {
		int pointsTotal = 0;
		pointsTotal = strategyPoints(strategy(opponentChoice, myStrat)) + resultPoints(myStrat);
		return pointsTotal;
	}
	
	/*
	 * This method uses the opponent's choice and my choice to determine who 
	 * won the round and how many points I should be awarded. 
	 */
	private static int result(String opponentChoice, String myChoice) {
		int resultPoints = 0;
		
		if(opponentChoice.equals("A") && myChoice.equals("Y") ||
				opponentChoice.equals("B") && myChoice.equals("Z") ||
				opponentChoice.equals("C") && myChoice.equals("X")) {
			//Win
			resultPoints = 6;
		} else if(opponentChoice.equals("A") && myChoice.equals("Z") ||
				opponentChoice.equals("B") && myChoice.equals("X") ||
				opponentChoice.equals("C") && myChoice.equals("Y")) {
			//Loss
			resultPoints = 0;
		} else {
			//Tie
			resultPoints = 3;
		}

		return resultPoints;
	}
	
	/*
	 * This method determines how many points I should be awarded for my choice 
	 * of shape. 
	 */
	private static int shapePoints(String myChoice) {
		int shapePoints = 0;
		if(myChoice.equals("X")) {
			shapePoints = 1;
		} else if(myChoice.equals("Y")) {
			shapePoints = 2;
		} else {
			shapePoints = 3;
		}
		
		return shapePoints;
	}
	
	/*
	 * This method determines what shape I should select based on what 
	 * my opponent will play, and what result (win, loss, draw) I want. 
	 */
	private static String strategy(String opponentChoice, String myStrat) {
		String myShape = null;
		if(opponentChoice.equals("A")) {
			//Opponent chooses Rock
			if(myStrat.equals("X")) {
				//I lose
				myShape = "scissors";
			} else if(myStrat.equals("Y")) {
				//I draw
				myShape = "rock";
			} else if(myStrat.equals("Z")) {
				//I win
				myShape = "paper";
			}
		} else if(opponentChoice.equals("B")) {
			//Opponent chooses Paper
			if(myStrat.equals("X")) {
				//I lose
				myShape = "rock";
			} else if(myStrat.equals("Y")) {
				//I draw
				myShape = "paper";
			} else if(myStrat.equals("Z")) {
				//I win
				myShape = "scissors";
			}			
		} else if(opponentChoice.equals("C")) {
			//Opponent chooses Scissors
			if(myStrat.equals("X")) {
				//I lose
				myShape = "paper";
			} else if(myStrat.equals("Y")) {
				//I draw
				myShape = "scissors";
			} else if(myStrat.equals("Z")) {
				//I win
				myShape = "rock";
			}			
		}
		return myShape;
	}
	
	/*
	 * This method scores the points for the shape selected using 
	 * "strategy" method. 
	 */
	private static int strategyPoints(String myShape) {
		int points = 0;
		if(myShape.equals("rock")) {
			points = 1;
		} else if(myShape.equals("paper")) {
			points = 2;
		} else if(myShape.equals("scissors")) {
			points = 3;
		}
		return points;
	}
	
	/*
	 * This method calculates my points for win-lose-draw based on myStrat
	 */
	private static int resultPoints(String myStrat) {
		int points = 0;
		if(myStrat.equals("X")) {
			//Loss
			points = 0;
		} else if(myStrat.equals("Y")) {
			//Draw
			points = 3;
		} else if(myStrat.equals("Z")) {
			//Win
			points = 6;
		}
		return points;
	}

}
