package wordMatchingGame;

import java.util.ArrayList;

public class Match {

	private ArrayList<Player> players;
	private ArrayList<String> words;
	private int round;
	private int maxRounds;
	private String winnerWord;
	private static int defaultMaxRounds = 10;
	
	public Match(int maxRounds) {
		this.players = new ArrayList();
		this.words = new ArrayList();
		this.round = 1;
		this.maxRounds = maxRounds; 
	}
	
	public Match() {
		this.players = new ArrayList();
		this.words = new ArrayList();
		this.round = 1;
		this.maxRounds = Match.defaultMaxRounds;
	}
	
	public void addPlayer(Player p) {
		if(!this.players.contains(p)) {
			this.players.add(p);
			p.setMatch(this);
		}
	}
	
	public void addWord(String word) {
		if(this.words.size() < this.players.size()) {
			this.words.add(word);
		}
	}


	public int getMaxRounds() {
		return maxRounds;
	}

	public void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}

	@Override
	public String toString() {
		String result = "Players:\n";
		for(Player p: players) {
			result += p.toString();
		}
		result += "Round: " + round + "\n" + "State: "; 
		return result;
	}



	public void askWordToPlayers() {
		if (this.players.size()>=2) {
			for(Player p: this.players) {
				p.sayAWord();
			}
		}
		
	}
	
	
	public void playRound() {
		if (this.round <= this.maxRounds) {
			this.askWordToPlayers();
			if (!this.checkMatching()) {
				this.words.clear();
				this.round ++;
				this.playRound();
			}else {
				System.out.println("You Win! The Winner Words is " + this.winnerWord);
			}
		} else {
			System.out.println("Nobody win :(");
		}
	}
	
	
	public boolean checkMatching() {
		boolean result = false;
		for(int i = 0; i< this.words.size(); i ++) {
			String w1 = this.words.get(i);
			for(int j = i + 1; j < this.words.size(); j ++) {
				String w2 = this.words.get(j);
				if(w1.equals(w2)) {
					result = true;
					this.winnerWord = w1;
				}
			}
		}
		return result;
	}
	
	
}
