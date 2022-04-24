package id.ac.ui.cs.advprog.tkadpro.controller;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.service.PlayGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class BaseController {
    @Autowired
    private PlayGameService playGameService;

    @RequestMapping(path="/login", method = RequestMethod.GET)
    public String loginPage(){return "login/login";}

    @RequestMapping(path="", method=RequestMethod.GET)
    public String homePage(){return "homepage/homepage";}

    @RequestMapping(path="/wordsblank/start", method=RequestMethod.GET)
    public String Wordsblank(Model model){
        var questionInfo = playGameService.startGame(TypeGame.WORDSBLANK);

        model.addAttribute("numOfQuest", questionInfo.getQuestionNumber());
        model.addAttribute("score", questionInfo.getScore());
        model.addAttribute("ans", questionInfo.getNumberOfAnswer());
        model.addAttribute("level", questionInfo.getLevel());
        model.addAttribute("txt", questionInfo.getQuestion());
        model.addAttribute("hp", questionInfo.getHp());

        return "wordsblank/base_wordsblank";
    }

    @RequestMapping(path="/titleque", method=RequestMethod.GET)
    public String Titleque(Model model){
        int num = 18;
        int score = 97;
        int numOfAns = 5;
        String level = "HARD";
        String text = "Implementing lyrics here";

        model.addAttribute("numOfQuest", num);
        model.addAttribute("score", score);
        model.addAttribute("ans", numOfAns);
        model.addAttribute("level", level);
        model.addAttribute("txt", text);

        return "titleque/base_titleque";
    }

    @RequestMapping(path="/starguess", method=RequestMethod.GET)
    public String Starguess(Model model){
        int num = 6;
        int score = 53;
        int numOfAns = 3;
        String level = "MEDIUM";
        String text = "Implementing lyrics here";

        model.addAttribute("numOfQuest", num);
        model.addAttribute("score", score);
        model.addAttribute("ans", numOfAns);
        model.addAttribute("level", level);
        model.addAttribute("txt", text);

        return "starguess/base_starguess";
    }

    @RequestMapping(path="/lyricspatch/start", method=RequestMethod.GET)
    public String Lyricspatch(Model model){
        var questionInfo = playGameService.startGame(TypeGame.LYRICSPATCH);

        model.addAttribute("numOfQuest", questionInfo.getQuestionNumber());
        model.addAttribute("score", questionInfo.getScore());
        model.addAttribute("ans", questionInfo.getNumberOfAnswer());
        model.addAttribute("level", questionInfo.getLevel());
        model.addAttribute("txt", questionInfo.getQuestion());
        model.addAttribute("hp", questionInfo.getHp());

        return "lyricspatch/base_lyricspatch";
    }

    @RequestMapping(path="/test-start-cancel-modal", method=RequestMethod.GET)
    public String ModalTest(){
        return "start_cancel_modal";
    }

    @RequestMapping(path="/test-true-ans-modal", method=RequestMethod.GET)
    public String ModalTestTrue(){
        return "modal/true_ans_modal";
    }

    @RequestMapping(path="/test-false-ans-modal", method=RequestMethod.GET)
    public String ModalTestFalse(){
        return "modal/false_ans_modal";
    }

    @RequestMapping(path="/test-stop-confirm-modal", method=RequestMethod.GET)
    public String ModalTestConfirm(){
        return "modal/confirm_modal";
    }
}
