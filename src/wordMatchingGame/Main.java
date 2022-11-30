package wordMatchingGame;

public class Main {

	public static void main(String[] args) {
		
		Player p1 = new Player("Camila");
		Player p2 = new Player("José");

		Match match1 = new Match(2, 3);
		
		match1.addPlayer(p1);
		match1.addPlayer(p2);
		
		System.err.println(match1);
		
		p1.sayAWord("Tree");
		p2.sayAWord("Tree");
		
		System.out.println(match1);
	}

}
