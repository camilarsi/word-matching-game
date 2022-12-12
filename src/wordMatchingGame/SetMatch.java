package wordMatchingGame;

public class SetMatch extends GameState {

	private Menu menu;
	
	public SetMatch(Match match, Menu menu) {
		super(match);
		this.menu = menu;
	}
	
	@Override
	public GameState run() {
		System.out.println("Choose an option: \n [a]- Add New Player \n [b]- Play \n [c] -Quit");
		String option = Input.askInput();
		switch (option) {
			case "a":
				System.out.println("Player Name: \n");
				String playerName = Input.askInput();
				Player p = new Player(playerName);
				this.getMatch().addPlayer(p);
				return this;
			case "b":
				if (this.getMatch().getPlayersAmount()<2) {
					System.out.println("At least two players are needed. Please, add a new player:\n");
					System.out.println("Player Name: \n");
					String SecondPlayerName = Input.askInput();
					Player sp = new Player(SecondPlayerName);
					this.getMatch().addPlayer(sp);
					return this;
				}
				return new Play(this.getMatch());
			case "c":
				return new Quit(this.getMatch());
			default: 
				return this.menu;
		}
	}
}
