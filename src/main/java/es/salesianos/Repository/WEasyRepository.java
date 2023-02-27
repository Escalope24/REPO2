package es.salesianos.Repository;

import org.springframework.stereotype.Repository;

import es.salesianos.Model.Letter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;

@Profile("easy")
@Repository
public class WEasyRepository implements IWRepository {
    private List<Letter> word = List.of(
        new Letter(true, 's', 0, 0),
        new Letter(true, 'o', 1, 1),
        new Letter(true, 'l', 2, 2)
    );

    private List<String> history = new ArrayList<>();

    private int attempts = 20;

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
