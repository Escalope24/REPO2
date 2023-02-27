package es.salesianos.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import es.salesianos.Model.Letter;
@Profile("hard")
@Repository
public class WHardRepository implements IWRepository {
	    private List<Letter> word = List.of(
			new Letter(true, 'a', 0, 0),
			new Letter(true, 'b', 1, 1),
			new Letter(true, 'd', 2, 2),
			new Letter(true, 'u', 3, 3),
			new Letter(true, 'z', 4, 4),
			new Letter(true, 'c', 5, 5),
			new Letter(true, 'a', 6, 6),
			new Letter(true, 'n', 7, 7)
		);

		private List<String> history = new ArrayList<>();

		private int attempts = 6;

		public int numAttempts() {
			return attempts;
		}

		public void failAttempts() {
			this.attempts = this. attempts - 1;
		}

		public List<String> allHistory() {
			return history;
		}

		public List<Letter> getWord(){
			return word;
		}
		


	}
		