package id.ac.ui.cs.advprog.tkadpro.controller;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;
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
        model.addAttribute("txt", questionInfo.getQuestion().split("\n"));
        model.addAttribute("hp", questionInfo.getHP());

        return "wordsblank/base_wordsblank";
    }

    @RequestMapping(path="/wordsblank/next", method=RequestMethod.GET)
    public String WordsblankNext(Model model){
        var questionInfo = playGameService.generateQuestion();

        model.addAttribute("numOfQuest", questionInfo.getQuestionNumber());
        model.addAttribute("score", questionInfo.getScore());
        model.addAttribute("ans", questionInfo.getNumberOfAnswer());
        model.addAttribute("level", questionInfo.getLevel());
        model.addAttribute("txt", questionInfo.getQuestion());
        model.addAttribute("hp", questionInfo.getHP());

        return "redirect:/wordsblank/next";
    }

    @RequestMapping(path="/wordsblank/true", method=RequestMethod.GET)
    public String ModalTrue(Model model){
        return "";
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

    @RequestMapping(path="/lyricspatch", method=RequestMethod.GET)
    public String Lyricspatch(Model model){
        int num = 13;
        int score = 78;
        int numOfAns = 5;
        String level = "HARD";
        String text = "Implementing lyrics here";

        model.addAttribute("numOfQuest", num);
        model.addAttribute("score", score);
        model.addAttribute("ans", numOfAns);
        model.addAttribute("level", level);
        model.addAttribute("txt", text);

        return "lyricspatch/base_lyricspatch";
    }

    @RequestMapping(path="/wordsblank/rules", method=RequestMethod.GET)
    public String ModalTest(){
        return "modal/start_cancel_modal";
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
