package id.ac.ui.cs.advprog.tkadpro.controller;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.model.UserAnswer;
import id.ac.ui.cs.advprog.tkadpro.service.PlayGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("")
public class BaseController {
    @Autowired
    private PlayGameService playGameService;

    @RequestMapping(path="/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login/login";
    }

    @RequestMapping(path="", method=RequestMethod.GET)
    public String homePage(){
        return "homepage/homepage";
    }

    @GetMapping(value="/wordsblank/start")
    public String wordsblank(Model model){
        var questionInfo = playGameService.startGame(TypeGame.WORDSBLANK);
        generateModel(model, questionInfo, "wordsblank");

        return "wordsblank/base_wordsblank";
    }

    @GetMapping(value="/wordsblank/next")
    public String wordsblankNext(Model model){
        var questionInfo = playGameService.generateQuestion();
        generateModel(model, questionInfo, "wordsblank");

        return "wordsblank/base_wordsblank";
    }

    @GetMapping(value="/lyricspatch/start")
    public String lyricspatch(Model model){
        var questionInfo = playGameService.startGame(TypeGame.LYRICSPATCH);
        generateModel(model, questionInfo, "lyricspatch");

        return "lyricspatch/base_lyricspatch";
    }

    @GetMapping(value="/lyricspatch/next")
    public String lyricspatchNext(Model model){
        var questionInfo = playGameService.generateQuestion();
        generateModel(model, questionInfo, "lyricspatch");

        return "lyricspatch/base_lyricspatch";
    }

    @GetMapping(value="/rules/{rules_id}")
    public String rulesView(Model model, @PathVariable int rules_id) {
        model.addAttribute("rulesId", rules_id);
        String gameType;
        if (rules_id == 1) gameType = "starguess";
        else if (rules_id == 2) gameType = "titleque";
        else if (rules_id == 3) gameType = "wordsblank";
        else gameType = "lyricspatch";
        model.addAttribute("gameType", gameType);

        return "modal/rules_modal";
    }

    @PostMapping(value="/wordsblank/check")
    public String wordsblankCheck(@RequestParam(value="ans") String[] playerAnswers, Model model) {
        var feedback = playGameService.checkAnswer(Arrays.asList(playerAnswers));
        generateModelCheck(model, feedback, "wordsblank");

        return "modal/feedback_modal";
    }

    @PostMapping(value="/lyricspatch/check")
    public String lyricspatchCheck(@RequestParam(value="ans") String[] playerAnswers, Model model){
        String feedback = playGameService.checkAnswer(Arrays.asList(playerAnswers));
        generateModelCheck(model, feedback, "lyricspatch");

        return "modal/feedback_modal";
    }

    @RequestMapping(path="/titleque", method=RequestMethod.GET)
    public String titleque(Model model) {
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
    public String starguess(Model model) {
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

    @RequestMapping(path="/rules", method=RequestMethod.GET)
    public String modalTest(){
        return "modal/rules_modal";
    }

    @RequestMapping(path="/test-true-ans-modal", method=RequestMethod.GET)
    public String modalTestTrue(){
        return "modal/feedback_modal";
    }

    @GetMapping(value="/{type_game}/confirm")
    public String confirmModalView(Model model, @PathVariable String type_game) {
        model.addAttribute("typeGame", type_game);
        return "modal/confirm_modal";
    }

    public void generateModel(Model model, QuestionInfo questionInfo, String gameType) {
        model.addAttribute("numOfQuest", questionInfo.getQuestionNumber());
        model.addAttribute("score", questionInfo.getScore());
        model.addAttribute("numberOfAns", questionInfo.getNumberOfAnswer());
        model.addAttribute("level", questionInfo.getLevel());
        model.addAttribute("txt", questionInfo.getQuestion().split("\n"));
        model.addAttribute("hp", questionInfo.getHp());
        model.addAttribute("gameType", gameType);
    }

    public void generateModelCheck(Model model, String feedback, String gameType) {
        model.addAttribute("feedback", feedback);
        model.addAttribute("gameType", gameType);

        if(feedback.equals("CORRECT"))
            model.addAttribute("message", "Congrats, you have solved this question");
        else
            model.addAttribute("message","Sorry, your answer is still wrong");
    }
}
