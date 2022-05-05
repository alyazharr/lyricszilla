package id.ac.ui.cs.advprog.tkadpro.controller;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.HintInfo;
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
    private static final String STARGUESS = "starguess";
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

    @GetMapping(value="/{gameType}/start")
    public String startGame(Model model, @PathVariable String gameType){
        switch (gameType) {
            case WORDSBLANK: {
                model.addAttribute("questionInfo", playGameService.startGame(TypeGame.WORDSBLANK));
                model.addAttribute(GAMETYPE, WORDSBLANK);
                return BASEWORDSBLANK;
            }

            case LYRICSPATCH: {
                model.addAttribute("questionInfo", playGameService.startGame(TypeGame.LYRICSPATCH));
                model.addAttribute(GAMETYPE, LYRICSPATCH);
                return BASELYRICSPATCH;
            }

            default: {
                return "";
            }
        }
    }

    @GetMapping(value="/{gameType}/next")
    public String wordsblankNext(Model model, @PathVariable String gameType){
        model.addAttribute("questionInfo", playGameService.generateQuestion());

        switch (gameType) {
            case WORDSBLANK: { model.addAttribute(GAMETYPE, WORDSBLANK); return BASEWORDSBLANK; }
            case LYRICSPATCH: { model.addAttribute(GAMETYPE, LYRICSPATCH); return BASELYRICSPATCH;}
            default: { return ""; }
        }

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

    @PostMapping(value="/{gameType}/check")
    public String checkingAnswer(@RequestParam(value="ans") String[] playerAnswers, Model model, @PathVariable String gameType) {
        var feedback = playGameService.checkAnswer(Arrays.asList(playerAnswers));

        switch (gameType) {
            case WORDSBLANK: { generateModelCheck(model, feedback, WORDSBLANK); }
            case LYRICSPATCH: { generateModelCheck(model, feedback, LYRICSPATCH); }
        }

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

    public void generateModelCheck(Model model, String feedback, String gameType) {
        model.addAttribute("feedback", feedback);
        model.addAttribute(GAMETYPE, gameType);

        if (feedback.equals("CORRECT")) model.addAttribute("message", "Congrats, you have solved this question");
        else model.addAttribute("message","Sorry, your answer is still wrong");
    }
}
