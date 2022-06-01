import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputManager manager;
		Scanner sc = new Scanner(System.in);
		String nextLine;
		System.out.println("Do you have a file with the games? Y/N");
		do{
			nextLine = sc.nextLine();
		}while(!(nextLine.equals("Y")||nextLine.equals("N")));
		if(nextLine.equals("Y")) {
			System.out.println("Input will be with a file");
			manager=new FileInputManager();
		}
		else {
			System.out.println("Input will be through console.");
			manager=new ConsoleInputManager();
		}
		manager.getGames();
		manager.getPlacements();
	}

}
