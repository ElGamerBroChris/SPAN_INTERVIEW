import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitTest {
	private static String SUCCESS="SUCCESS";
	private static String FAILED="SUCCESS";
	public static void assertGetTeamName() {
		String[] teamArray1 = "FC Awesome 0".split(" ");
		String result1 = ("FC Awesome".equals(RankCalculator.getTeamName(teamArray1)))?SUCCESS:FAILED;
		System.out.println(result1);
		String[] teamArray2 = "Tarantulas 0".split(" ");
		String result2 = ("Tarantulas".equals(RankCalculator.getTeamName(teamArray2)))?SUCCESS:FAILED;
		System.out.println(result2);
	}
	public static void assertDetermineGamePoints() {
		Map<String,Integer> result = RankCalculator.determineGamePoints("Lions 3, Snakes 3");
		String evaluation = (result.get("Lions")==1&&result.get("Snakes")==1)?SUCCESS:FAILED;
		System.out.println("TEST CASE 'Lions 3, Snakes 3':"+evaluation);
		result = RankCalculator.determineGamePoints("Tarantulas 1, FC Awesome 0");
		evaluation = (result.get("Tarantulas")==3&&result.get("FC Awesome")==0)?SUCCESS:FAILED;
		System.out.println("TEST CASE 'Tarantulas 1, FC Awesome 0':"+evaluation);
		result = RankCalculator.determineGamePoints("Tarantulas 0, Snakes 1");
		evaluation = (result.get("Tarantulas")==0&&result.get("Snakes")==3)?SUCCESS:FAILED;
		System.out.println("TEST CASE 'Tarantulas 0, Snakes 1':"+evaluation);
	}
	public static void assertCountLeaguePoints() {
		// TODO Auto-generated method stub
		List<String> games = new ArrayList<String>();
		games.add("Lions 3, Snakes 3");
		games.add("Tarantulas 1, FC Awesome 0");
		games.add("Lions 1, FC Awesome 1");
		games.add("Tarantulas 3, Snakes 1");
		games.add("Lions 4, Grouches 0");
		Map<String,Integer> leagueResults = RankCalculator.countLeaguePoints(games);
		String testResult = (leagueResults.get("Grouches")==0
							&&leagueResults.get("Snakes")==1
							&&leagueResults.get("FC Awesome")==1
							&&leagueResults.get("Lions")==5
							&&leagueResults.get("Tarantulas")==6
							)?SUCCESS:FAILED;
		System.out.println(testResult);
	}
	public static void assertFindAlphabeticalPosition() {
		List<String> teams = new ArrayList<String>();
		teams.add("FC Awesome");
		teams.add("Lions");
		teams.add("Snakes");
		teams.add("Tarantulas");
		System.out.println(teams);
		RankCalculator.findAlphabeticalPosition(teams, "Atlanta");
		String test1="[Atlanta, FC Awesome, Lions, Snakes, Tarantulas]";
		System.out.println((test1.equals(teams.toString()))?SUCCESS:FAILED);
		RankCalculator.findAlphabeticalPosition(teams, "Zeroes");
		String test2="[Atlanta, FC Awesome, Lions, Snakes, Tarantulas, Zeroes]";
		System.out.println((test2.equals(teams.toString()))?SUCCESS:FAILED);
		RankCalculator.findAlphabeticalPosition(teams, "Hawks");
		String test3="[Atlanta, FC Awesome, Hawks, Lions, Snakes, Tarantulas, Zeroes]";
		System.out.println((test3.equals(teams.toString()))?SUCCESS:FAILED);
	}
	public static void assertLeaguePlacements() {
		// TODO Auto-generated method stub
		Map<String,Integer> testData = new HashMap<String,Integer>();
		testData.put("Grouches", 0);
		testData.put("Snakes", 1);
		testData.put("FC Awesome", 1);
		testData.put("Lions", 5);
		testData.put("Tarantulas", 6);
		List<List<String>> results = RankCalculator.leaguePlacements(testData);
		String test = "[[Tarantulas], [Lions], [FC Awesome, Snakes], [Grouches]]";
		System.out.println(results);
		System.out.println((test.equals(results.toString()))?SUCCESS:FAILED);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------assertGetTeamName-------------");
		assertGetTeamName();
		System.out.println("---------assertDetermineGamePoints---------");
		assertDetermineGamePoints();
		System.out.println("----------assertCountLeaguePoints----------");
		assertCountLeaguePoints();
		System.out.println("----------assertFindAlphabeticalPosition----------");
		assertFindAlphabeticalPosition();
		System.out.println("----------assertLeaguePlacements----------");
		assertLeaguePlacements();
	}
	
	
}
