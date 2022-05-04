package id.ac.ui.cs.advprog.tkadpro.controller;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.HintInfo;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.service.PlayGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BaseController {
    @Autowired
    private PlayGameService playGameService;

    private static final String WORDSBLANK = "wordsblank";
    private static final String LYRICSPATCH = "lyricspatch";
    private static final String STARGUESS = "starquess";
    private static final String TITLEQUE = "titleque";
    private static final String GAMETYPE = "gameType";
    private static final String FEEDBACKMODAL = "modal/feedback_modal";
    private static final String RULESMODAL = "modal/rules_modal";
    private static final String BASEWORDSBLANK = "wordsblank/base_wordsblank";
    private static final String BASELYRICSPATCH = "lyricspatch/base_lyricspatch";

    @GetMapping(value="/login")
    public String loginPage(){
        return "login/login";
    }

    @GetMapping(value="")
    public String homePage(){
        return "homepage/homepage";
    }

    @GetMapping(value="/wordsblank/start")
    public String wordsblank(Model model){
        var questionInfo = playGameService.startGame(TypeGame.WORDSBLANK);
        generateModel(model, questionInfo, WORDSBLANK);

        return BASEWORDSBLANK;
    }

    @GetMapping(value="/wordsblank/next")
    public String wordsblankNext(Model model){
        var questionInfo = playGameService.generateQuestion();
        generateModel(model, questionInfo, WORDSBLANK);

        return BASEWORDSBLANK;
    }

    @GetMapping(value="/lyricspatch/start")
    public String lyricspatch(Model model){
        var questionInfo = playGameService.startGame(TypeGame.LYRICSPATCH);
        generateModel(model, questionInfo, LYRICSPATCH);

        return BASELYRICSPATCH;
    }

    @GetMapping(value="/lyricspatch/next")
    public String lyricspatchNext(Model model){
        var questionInfo = playGameService.generateQuestion();
        generateModel(model, questionInfo, LYRICSPATCH);

        return BASELYRICSPATCH;
    }

    @GetMapping(value="/rules/{rulesId}")
    public String rulesView(Model model, @PathVariable int rulesId) {
        model.addAttribute("rulesId", rulesId);
        String gameType;
        if (rulesId == 1) gameType = STARGUESS;
        else if (rulesId == 2) gameType = TITLEQUE;
        else if (rulesId == 3) gameType = WORDSBLANK;
        else gameType = LYRICSPATCH;
        model.addAttribute(GAMETYPE, gameType);

        return RULESMODAL;
    }

    @PostMapping(value="/wordsblank/check")
    public String wordsblankCheck(@RequestParam(value="ans") String[] playerAnswers, Model model) {
        var feedback = playGameService.checkAnswer(Arrays.asList(playerAnswers));
        generateModelCheck(model, feedback, WORDSBLANK);

        return FEEDBACKMODAL;
    }

    @PostMapping(value="/lyricspatch/check")
    public String lyricspatchCheck(@RequestParam(value="ans") String[] playerAnswers, Model model){
        String feedback = playGameService.checkAnswer(Arrays.asList(playerAnswers));
        generateModelCheck(model, feedback, LYRICSPATCH);

        return FEEDBACKMODAL;
    }

    @GetMapping(value="/rules")
    public String modalTest(){
        return RULESMODAL;
    }

    @GetMapping(value="/test-true-ans-modal")
    public String modalTestTrue(){
        return FEEDBACKMODAL;
    }

    @GetMapping(value="/{typeGames}/confirm")
    public String confirmModalView(Model model, @PathVariable String typeGames) {
        model.addAttribute("typeGame", typeGames);
        model.addAttribute("text", "Are you sure want to stop the game?");
        return "modal/confirm_modal";
    }

    @GetMapping(value="/hint/confirm")
    public String confirmHintModalView(Model model) {
        model.addAttribute("text", "Are you sure want to use hint?");
        return "modal/confirm_modal";
    }

    @GetMapping(value="/usingHint", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<HintInfo> usingHintForAnswer() {
        return ResponseEntity.ok(playGameService.useHint());
    }

    public void generateModel(Model model, QuestionInfo questionInfo, String gameType) {
        model.addAttribute("numOfQuest", questionInfo.getQuestionNumber());
        model.addAttribute("score", questionInfo.getScore());
        model.addAttribute("numberOfAns", questionInfo.getNumberOfAnswer());
        model.addAttribute("level", questionInfo.getLevel());
        model.addAttribute("txt", questionInfo.getQuestion().split("\n"));
        model.addAttribute("hp", questionInfo.getHp());
        model.addAttribute(GAMETYPE, gameType);
    }

    public void generateModelCheck(Model model, String feedback, String gameType) {
        model.addAttribute("feedback", feedback);
        model.addAttribute(GAMETYPE, gameType);

        if(feedback.equals("CORRECT"))
            model.addAttribute("message", "Congrats, you have solved this question");
        else
            model.addAttribute("message","Sorry, your answer is still wrong");
    }
}
