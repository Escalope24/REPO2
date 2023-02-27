package es.salesianos.Services;

import java.util.List;

import es.salesianos.Model.Letter;

public interface IWService {
    public List<Letter> checkWord(String word);
    public List<String> allHistory();
    public String getWordByPos(int pos);
    public int numAttempts();
    public void failAttempt();
} 
