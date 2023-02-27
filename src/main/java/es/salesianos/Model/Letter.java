package es.salesianos.Model;

public class Letter {
	private char letter;
	private boolean correct;
	private int position;
	private int correctPosition;
    public Letter(boolean correct, char letter, int position, int correctPosition) {
        this.letter = letter;
        this.position = position;
        this.correct = true;
        this.correctPosition = correctPosition;
    }
    public Letter(boolean correct, char letter, int position) {
        this.letter = letter;
        this.position = position;
        this.correct = true;
        this.correctPosition = correctPosition;
    }
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getCorrectPosition() {
		return correctPosition;
	}
	public void setCorrectPosition(int correctPosition) {
		this.correctPosition = correctPosition;
	}
	
}
