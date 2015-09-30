package ch.fhnw.webfr.flashcard.web;

import org.springframework.stereotype.Controller;
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
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@RequestParam("name") String name) {
        return "Hello to " + name;
    }
}