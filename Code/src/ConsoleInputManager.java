import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInputManager extends InputManager {

	@Override
	public void getGames() {
		this.games=new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String nextLine;
		System.out.println("Enter X when done listing the games.");
		do{
			nextLine = sc.nextLine();
			if(!nextLine.equals("X")) {
				this.games.add(nextLine);
			}
		}while(!nextLine.equals("X"));
		games.forEach(System.out::println);
	}
}
