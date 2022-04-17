package id.ac.ui.cs.advprog.tkadpro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lyriczilla")
public class BaseController {

    @RequestMapping(path="/login", method = RequestMethod.GET)
    public String loginPage(){return "login/login";}

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String homePage(){return "homepage/homepage";}


}
