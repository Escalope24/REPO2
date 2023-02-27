package es.salesianos.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.Model.Letter;
import es.salesianos.Repository.IWRepository;
import es.salesianos.Repository.WHardRepository;
@Service
public class WService implements IWService{

    @Autowired
	private IWRepository repo;

    @Override
    public List<Letter> checkWord(String word){
        List<Letter> list = new ArrayList<Letter>();
        if(word.length() != repo.getWord().size() || repo.numAttempts() <= 0){
            return null;
        }   
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == repo.getWord().get(i).getLetter()){
                list.add(new Letter(true, word.charAt(i), i, i)) ;
                continue;
            }
                boolean found = false;
                for (int j = 0; j < repo.getWord().size(); j++) {
                    if (word.charAt(i) == repo.getWord().get(j).getLetter()){
                        list.add(new Letter(true, word.charAt(i), i, j)) ;
                        found = true;
                        break;
                    }else{
                        found = false;
                    }
                }
                if (found==false){
                    list.add(new Letter(false, word.charAt(i), i)) ;
                }
        }
        repo.allHistory().add(word);
        return list;
    }


    @Override
    public String getWordByPos(int pos){
        if (pos >= repo.allHistory().size() || pos < 0 ){
            return null;
        }
        return repo.allHistory().get(pos);
    }

    @Override
    public List<String> allHistory(){
        return repo.allHistory();
    }

    @Override
    public int numAttempts(){
        return repo.numAttempts();
    }
    @Override
    public void failAttempt(){
        repo.failAttempts();
    }

}


