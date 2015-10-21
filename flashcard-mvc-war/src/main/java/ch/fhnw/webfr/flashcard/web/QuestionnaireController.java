package ch.fhnw.webfr.flashcard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
		return "questionnaires/list";
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		return "questionnaires/create";
	}
	
	// Without any validation support from the framework!
	@RequestMapping(method = RequestMethod.POST)
	public String create(Questionnaire questionnaire, Model model) {
		if ((questionnaire.getTitle() != null) && (questionnaire.getTitle().length() > 0) &&
			(questionnaire.getDescription() != null) && (questionnaire.getDescription().length() > 0)) {
			questionnaireRepository.save(questionnaire);
		}
		return "redirect:/questionnaires";
	}	

}
