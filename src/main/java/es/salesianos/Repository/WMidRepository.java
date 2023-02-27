package es.salesianos.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import es.salesianos.Model.Letter;

@Profile("mid")
@Repository
public class WMidRepository {
	private List<Letter> word = List.of(
			new Letter(true, 'c', 0, 0),
			new Letter(true, 'o', 1, 1),
			new Letter(true, 'c', 2, 2),
			new Letter(true, 'h', 3, 3),
			new Letter(true, 'e', 4, 4)
		);

		private List<String> history = new ArrayList<>();

		private int attempts = 10;

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
		