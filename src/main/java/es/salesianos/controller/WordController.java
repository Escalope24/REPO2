package es.salesianos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.Model.Letter;
import es.salesianos.Services.IWService;

@Controller
public class WordController {
	  @Autowired
		IWService service;


	    @GetMapping("/")
		public ModelAndView checkword1() {
			ModelAndView modelAndView = new ModelAndView("index");
	        modelAndView.addObject("Attempts", service.numAttempts());
	        return modelAndView;
		}
	    @PostMapping("/check")
		public ModelAndView checkword(String word) {
			List<String> history = service.allHistory();
			List<Letter> list = service.checkWord(word);
			service.failAttempt();
	        boolean win = false;
	        if (list != null) {
	            for (Letter leter : list) {
	                if(leter.isCorrect() && leter.getPosition() == leter.getCorrectPosition()){
	                    win = true;
	                }else{
	                    win = false;
	                    break;
	                }
	            }
	        }
	        ModelAndView modelAndView;
	        if (win) {
	            modelAndView = new ModelAndView("end");
	        }else{
	            modelAndView = new ModelAndView("index");
	        }

	
	        modelAndView.addObject("word", list);
			modelAndView.addObject("history",history);
			modelAndView.addObject("history2", service.checkWord(history.get(0)));				
	        modelAndView.addObject("Attempts", service.numAttempts());
	        return modelAndView;
		}
	    @PostMapping("/search")
		public ModelAndView checkword(int number) {
			String word = service.getWordByPos(number);
	        if (word == null) {
	            word = "No hay ninguna palabra en la posicion" +number;
	        }
			ModelAndView modelAndView = new ModelAndView("win");
	        modelAndView.addObject("pos", number);
	        modelAndView.addObject("word", word);
	        modelAndView.addObject("Attempts", service.numAttempts());
	        return modelAndView;
		}
	    
	}
