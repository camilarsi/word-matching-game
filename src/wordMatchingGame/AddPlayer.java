package wordMatchingGame;

public class AddPlayer extends GameState {

	private Menu menu;
	
	public AddPlayer(Match match, Menu menu) {
		super(match);
		this.menu = menu;
	}
	
	@Override
	public GameState run() {
		System.out.println("Choose an option: /n [a]- Add New Player /n [b]- Play /n [c] -Quit");
		String option = Input.askInput();
		switch (option) {
			case "a":
				System.out.println("Player Name: /n");
				String playerName = Input.askInput();
				Player p = new Player(playerName);
				this.getMatch().addPlayer(p);
				return this;
			case "b":
				return new Play(this.getMatch());
			case "c":
				return new Quit(this.getMatch());
			default: 
				return this.menu;
		}
		

	}

}
