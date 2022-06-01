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
		int numberOfTeams=1;
		for(List<String> rank:ranking) {
			printRank(rank,leaguePoints,numberOfTeams);
			numberOfTeams+=rank.size();
		}
	};
	public void printRank(List<String> rank,Map<String,Integer> leaguePoints,int placement) {
		for(String team:rank) {
			StringBuilder str = new StringBuilder();
			str.append(placement);
			str.append(". ");
			str.append(team);
			str.append(", ");
			str.append(leaguePoints.get(team));
			str.append(" pts");
			System.out.println(str.toString());
		}
	}
}
