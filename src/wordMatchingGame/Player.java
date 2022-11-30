package wordMatchingGame;

public class Player {

	private String id;
	private Match game;
	private String word;
	
	public Player(String id) {   
		this.id = id;
	}
	
	public void sayAWord(String word) {
		if(this.word == null ||!this.word.equals(word)) {
			this.word = word;
		}
		this.game.saveWord(word);
	}
	
	public void setGame(Match match) {
		if(this.game == null) {
			this.game = match;
		}
	}
	
	
	@Override
	public boolean equals(Object o) {
		try {
			Player other = (Player) o;
			if(this.id.equals(other.getId())) {
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}

	private Object getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\t" + id + "\n";
	}	
	
	
}
