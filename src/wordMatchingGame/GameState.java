package wordMatchingGame;

public abstract class GameState {

	private Match match;
	
	public GameState(Match match) {
		this.match = match;
	}
	
	public Match getMatch() {
		return match;
	}
	public abstract GameState run();
}
