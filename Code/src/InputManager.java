import java.util.List;

public abstract class InputManager {
	
	protected List<String> games;
	
	/**
	 * @implNote getGames will set the list of games that will later be evaluated.
	 */
	public abstract void getGames();
	
	/**
	 * @implNote getPlacements will print out the league placements.
	 */
	public abstract void getPlacements();
}
