package id.ac.ui.cs.advprog.tkadpro.controller;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.service.PlayGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.ui.Model;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@WebMvcTest(BaseController.class)
class BaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayGameService playGameService;

    private BaseController baseController;

    private Class<?> baseControllerClass;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() throws ClassNotFoundException {
        baseController = new BaseController();
        baseControllerClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.controller.BaseController");
    }

    @Test
    void LoginTest() throws Exception{
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect((handler().methodName("loginPage")))
                .andExpect(view().name("login/login"));
    }

    @Test
    void HomepageTest() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect((handler().methodName("homePage")))
                .andExpect(view().name("homepage/homepage"));
    }

    @Test
    void WordsblankTest() throws Exception {
        var questionInfo = playGameService.startGame(TypeGame.WORDSBLANK);
        when(playGameService.startGame(TypeGame.WORDSBLANK)).thenReturn(questionInfo);
        verify(playGameService, times(1)).startGame(TypeGame.WORDSBLANK);
    }

    @Test
    void WordsblankNextTest() throws Exception {
        var questionInfo = playGameService.generateQuestion();
        when(playGameService.generateQuestion()).thenReturn(questionInfo);
        verify(playGameService, times(1)).generateQuestion();
    }

    @Test
    void WordsBlankCheckTest() throws Exception {
        String[] playerAnswers = {"I","survive","love"};
        var questionInfo = playGameService.checkAnswer(Arrays.asList(playerAnswers));
        when(playGameService.checkAnswer(Arrays.asList(playerAnswers))).thenReturn(questionInfo);
        verify(playGameService, times(1)).checkAnswer(Arrays.asList(playerAnswers));
    }

    @Test
    void LyricspatchTest(){
        var questionInfo = playGameService.startGame(TypeGame.LYRICSPATCH);
        when(playGameService.startGame(TypeGame.LYRICSPATCH)).thenReturn(questionInfo);
        verify(playGameService, times(1)).startGame(TypeGame.LYRICSPATCH);
    }

    @Test
    void LyricspatchNextTest(){
        var questionInfo = playGameService.generateQuestion();
        when(playGameService.generateQuestion()).thenReturn(questionInfo);
        verify(playGameService, times(1)).generateQuestion();
    }

    @Test
    void LyricspatchCheckTest(){
        String[] playerAnswers = {"I know that I can't survive without you"};
        var questionInfo = playGameService.checkAnswer(Arrays.asList(playerAnswers));
        when(playGameService.checkAnswer(Arrays.asList(playerAnswers))).thenReturn(questionInfo);
        verify(playGameService, times(1)).checkAnswer(Arrays.asList(playerAnswers));
    }

    @Test
    void RulesViewTest() throws Exception {
        int rulesId = 3;

        String rulesMap = "/rules/{rulesId}";
        mockMvc.perform(get(rulesMap, rulesId))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("gameType"))
                .andExpect(model().attributeExists("rulesId"));
    }

    @Test
    void generateModelCheckTest() throws Exception{
        Class<?>[] countParam = new Class[3];
        countParam[0] = Model.class;
        countParam[1] = String.class;
        countParam[2] = String.class;

        Method generateModelCheck = baseControllerClass.getDeclaredMethod("generateModelCheck",countParam);

        assertEquals(3, generateModelCheck.getParameterCount());
        assertTrue(Modifier.isPublic(generateModelCheck.getModifiers()));
    }
}
