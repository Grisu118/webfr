package ch.fhnw.webfr.flashcard.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@ManagedBean
@RequestScoped
@Component
public class QuestionnaireBean {
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
    private Questionnaire actualQuestionnaire;

    public List<Questionnaire> getQuestionnaires() {
		return questionnaireRepository.findAll();
	}

    public Questionnaire getActualQuestionnaire() {
        return actualQuestionnaire;
    }

	public String createForm() {
        actualQuestionnaire = new Questionnaire();
		return "/pages/create";
	}

    public String cancel() {
        //actualQuestionnaire = null;
        return "/pages/questionnaires?faces-redirect=true";
    }

    public String create() {
        questionnaireRepository.save(actualQuestionnaire);
        //actualQuestionnaire = null;
        return "/pages/questionnaires?faces-redirect=true";
    }
}
