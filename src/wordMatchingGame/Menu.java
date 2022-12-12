package wordMatchingGame;

public class Menu extends GameState {
	
	public Menu() {
		super(new Match());
	}

	
	@Override
	public GameState run() {
		System.out.println("Welcome! Choose an option: \n  [a]- Start New Game \n  [b]- Quit");
		String input = Input.askInput();
		switch(input) {
		  case "a":
		    return new SetMatch(this.getMatch(), this);
		  case "b":
		    return new Quit(this.getMatch());
		  default:
		    return this;
		}
	}

}
