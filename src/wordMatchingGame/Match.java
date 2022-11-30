package wordMatchingGame;

import java.util.ArrayList;

public class Match {

	private ArrayList<Player> players;
	private int playersAmount;
	private ArrayList<String> words;
	private int round;
	private int maxRounds;
	private String state = "The game has started"; 
	private String stateEnded = "The game has become to end. Nodoby wins :(";
	private String stateWon = "The game has ended! The winner word is "; 
	
	public Match(int cantJugadores, int maxRondas) {
		this.players = new ArrayList();
		this.playersAmount = cantJugadores;
		this.words = new ArrayList();
		this.maxRounds = maxRondas;
	}


	public void addPlayer(Player p) {
		if(!this.players.contains(p) && this.playersAmount >= (this.players.size()) + 1) {
			this.players.add(p);
			p.setGame(this);
		}
	}

	public void play() {
		this.round = 1;
		this.setState(state, "");
		this.playRound();
		
	} 
	
	public void playRound() {
		if (this.round <= this.maxRounds) {
			for(Player p: this.players) {
				System.out.println("Player " + p.getId() + " say a word: ");
				p.sayAWord();
			}
			if (!this.checkMatching()) {
				this.words.clear();
				this.playRound();
			}
		} else {
			this.setState(stateEnded, "");
		}
		
	}

	public void saveWord(String word) {
		if(this.words.size() < this.playersAmount) {
			this.words.add(word);
		}
	}


	public boolean checkMatching() {
		boolean result = false;
		for(int i = 0; i< this.words.size(); i ++) {
			String w1 = this.words.get(i);
			for(int j = i + 1; j < this.words.size(); j ++) {
				String w2 = this.words.get(j);
				if(w1.equals(w2)) {
					this.setState(stateWon, w1);
					result = true;
				}
			}
		}
		this.round ++;
		return result;
	}


	private void setState(String state, String winnerWord) {
		this.state = state + winnerWord;
		System.out.println(this.state);
	}


	@Override
	public String toString() {
		String result = "Players:\n";
		for(Player p: players) {
			result += p.toString();
		}
		result += "Round: " + round + "\n" + "State: " + state; 
		return result;
	}
	
	
}
