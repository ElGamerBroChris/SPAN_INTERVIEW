import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInputManager extends InputManager {

	@Override
	public void getGames() {
		// TODO Auto-generated method stub
		this.games=new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String nextLine;
		System.out.println("Enter the file directory.");
		nextLine = sc.nextLine();
		System.out.println(nextLine);
		
		File file = new File(nextLine);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line=br.readLine())!=null) {
				this.games.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
