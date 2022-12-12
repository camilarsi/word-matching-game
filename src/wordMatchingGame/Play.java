package wordMatchingGame;

public class Play extends GameState {
	
	public Play(Match match) {
		super(match);
	}
	
	@Override
	public GameState run() {
		return this.play();
	}
	
	public GameState play() {
		this.getMatch().playRound();
		// end of current match
		return new Menu();
	}
	

}
