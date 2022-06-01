import java.util.List;
import java.util.Map;

public abstract class InputManager {
	
	protected List<String> games;
	
	/**
	 * @implNote getGames will set the list of games that will later be evaluated.
	 */
	public abstract void getGames();
	
	/**
	 * @implNote getPlacements will print out the league placements.
	 */
	public void getPlacements() {
		Map<String,Integer> leaguePoints = RankCalculator.countLeaguePoints(this.games);
		List<List<String>> ranking = RankCalculator.leaguePlacements(leaguePoints);
		int numberOfTeams=0;
		ranking.forEach(System.out::println);
	};
}
