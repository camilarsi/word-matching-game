package wordMatchingGame;

public class Player {

	private String id;
	private Match match;
	private String word;
	
	public Player(String id) {   
		this.id = id;
	}
	
	public void sayAWord() {
		System.out.println("Player " + this.id + " say a word: ");
		String word = Input.askInput();
		if(this.word == null ||!this.word.equals(word)) {
			this.word = word;
		}
		this.match.addWord(word);
	}
	
	public void setMatch(Match match) {
		if(this.match == null) {
			this.match = match;
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

	public Object getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\t" + id + "\n";
	}	
	
	
}
