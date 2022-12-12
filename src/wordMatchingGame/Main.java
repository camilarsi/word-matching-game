package wordMatchingGame;

public class Main {

	public static void main(String[] args) {
		
		GameState gs = new Menu();
		
		while(gs!= null) {
			gs = gs.run();
		}
		
	}

}
