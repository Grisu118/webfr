package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by benjamin on 30.09.2015.
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name,
                           Model model) {
        model.addAttribute("message", "Hello to " + name);
        model.addAttribute("questionnaires",
                questionnaireRepository.findAll());
        return "hello";
    }
}