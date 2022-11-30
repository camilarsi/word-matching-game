package wordMatchingGame;

import java.util.ArrayList;

public class Match {

	private ArrayList<Player> players;
	private int playersAmount;
	private ArrayList<String> words;
	private int round;
	private int maxRounds;
	private String state = "the game has started"; 
	
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


	public void saveWord(String word) {
		if (this.round < this.maxRounds){
			if(this.words.size() < this.playersAmount) {
				this.words.add(word);
				if(this.words.size() == this.playersAmount) {
					this.checkMatching();
				}
			}
		}
		
	}


	public boolean checkMatching() {
		this.round ++;
		boolean result = false;
		for(int i = 0; i< this.words.size(); i ++) {
			String w1 = this.words.get(i);
			for(int j = i + 1; j < this.words.size(); j ++) {
				String w2 = this.words.get(j);
				if(w1.equals(w2)) {
					this.setState(w1);
					result = true; 
				}
			}
		}
		
		return result;
	}


	private void setState(String word) {
		this.state = "The winner word is '" + word + "'. The game has ended.";
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
