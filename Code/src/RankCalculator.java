import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RankCalculator {
	public static String getTeamName(String[] teamArray) {
		StringBuilder teamName = new StringBuilder();
		for(int i=0;i<teamArray.length-1;i++) {
			teamName.append(teamArray[i]+" ");
		}
		return teamName.substring(0, teamName.length()-1);
	}
	public static Map<String,Integer> determineGamePoints(String game) {
		Map<String,Integer> result=new HashMap<String,Integer>();
		String[] gameScore = game.split(", ");
		String[] homeScore = gameScore[0].split(" ");
		String[] awayScore = gameScore[1].split(" ");
		int homePoints = Integer.parseInt(homeScore[homeScore.length-1]);
		int awayPoints = Integer.parseInt(awayScore[awayScore.length-1]);
		if(homePoints>awayPoints) {
			result.put(getTeamName(homeScore),3);
			result.put(getTeamName(awayScore),0);
		}
		else if(homePoints==awayPoints) {
			result.put(getTeamName(homeScore),1);
			result.put(getTeamName(awayScore),1);
		}
		else {
			result.put(getTeamName(homeScore),0);
			result.put(getTeamName(awayScore),3);
		}
		return result;
	}
	public static Map<String,Integer> countLeaguePoints(List<String> games) {
		Map<String,Integer> leaguePoints=new HashMap<String,Integer>();
		for(String game:games) {
			Map<String,Integer> gameResult = determineGamePoints(game);
			Set<String> teams = gameResult.keySet();
			for(String team:teams) {
				if(leaguePoints.containsKey(team)) {
					int totalPoints = leaguePoints.get(team)+gameResult.get(team);
					leaguePoints.put(team, totalPoints);
				}
				else {
					leaguePoints.put(team, gameResult.get(team));
				}
			}
		}
		return leaguePoints;
	}
	public static List<List<String>> leaguePlacements(Map<String,Integer> games) {
		List<List<String>> result=new LinkedList<List<String>>();
		return result;
	}
}
