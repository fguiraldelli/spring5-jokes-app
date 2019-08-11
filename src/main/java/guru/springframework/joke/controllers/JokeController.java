package guru.springframework.joke.controllers;

import guru.springframework.joke.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fguira on 2019-08-11 at 14:18
 */
//@Controller is a Spring component, a Spring MVC controller
@Controller
public class JokeController {

    private JokeService jokeService;

    //Even though Spring automatic @Autowired the constructor was putted below just for reminder.
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    //Here map out the context root for us.
    @RequestMapping({"/", ""})

    //Append the model with property for the joke, specify this to input parameter to the method and
    //Spring Framework will pass in an instance of the model.
    public String showJoke(Model model) {

        //Add an attribute and that property is going to be from JokeService getJoke
        model.addAttribute("joke", jokeService.getJoke());

        //Here return the view
        //So now we are going to be telling the Thymeleaf template engine to show us the view.
        return "chucknorris";
    }


}
