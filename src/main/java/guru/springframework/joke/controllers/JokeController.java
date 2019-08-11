package guru.springframework.joke.controllers;

import guru.springframework.joke.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fguira on 2019-08-11 at 14:18
 */
@Controller
public class JokeController {

    private JokeService jokeService;

    //Even though Spring automatic @Autowired the constructor was putted below just for reminder.
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());

        return "chucknorris";
    }


}
