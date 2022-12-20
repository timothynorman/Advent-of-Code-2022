import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileInput {
	
	/*
	 * Reads input for first part of problem. 
	 * i.e. Opponent's Choice and My Choice of shapes to play
	 */
	static int fileReader() throws IOException {
		File file = new File("input02.txt");
		Scanner scan = new Scanner(file);
		String opponentChoice = null;
		String myChoice = null;
		int total = 0;
				
		while(scan.hasNext()) {
			opponentChoice = scan.next();
			myChoice = scan.next();
						
			total = total + Round.points(opponentChoice, myChoice);
		}
		scan.close();
		return total;
	}
	
	/*
	 * Reads input for second part of problem. 
	 * i.e. Opponent's Choice and My Strategy 
	 */
	static int fileReader2() throws IOException {
		File file = new File("input02.txt");
		Scanner scan = new Scanner(file);
		String opponentChoice = null;
		String myStrat = null;
		int total = 0;
				
		while(scan.hasNext()) {
			opponentChoice = scan.next();
			myStrat = scan.next();
						
			total = total + Round.points2(opponentChoice, myStrat);
		}
		scan.close();
		return total;
	}

}
