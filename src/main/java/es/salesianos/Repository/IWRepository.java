package es.salesianos.Repository;

import java.util.List;

import es.salesianos.Model.Letter;

public interface IWRepository {
    public List<String> allHistory();
    public int numAttempts();
    public void failAttempts();
    List<Letter> getWord();
}
