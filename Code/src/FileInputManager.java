import java.util.Scanner;

public class FileInputManager extends InputManager {

	@Override
	public void getGames() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String nextLine;
		System.out.println("Enter the file directory.");
		nextLine = sc.nextLine();
		System.out.println(nextLine);
	}
}
