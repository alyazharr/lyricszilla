//package id.ac.ui.cs.advprog.tkadpro.controller;
//
//import id.ac.ui.cs.advprog.tkadpro.service.PlayGameService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import org.springframework.ui.Model;
//
//@WebMvcTest(controllers = BaseController.class)
//public class BaseControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private PlayGameService playGameService;
//
//    private BaseController baseController;
//
//    @Mock
//    private Model model;
//
//    @BeforeEach
//    public void setUp() {
//        baseController = new BaseController();
//    }
//
//    @Test
//    public void LoginTest() throws Exception{
//        mockMvc.perform(get("/login"))
//                .andExpect(status().isOk())
//                .andExpect((handler().methodName("loginPage")))
//                .andExpect(view().name("login/login"));
//    }
//
//    @Test
//    public void HomepageTest() throws Exception{
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect((handler().methodName("homePage")))
//                .andExpect(view().name("homepage/homepage"));
//    }
//
//    @Test
//    public void WordsblankTest() throws Exception {
////        var questionInfo = playGameService.startGame(TypeGame.WORDSBLANK);
////        when(playGameService.startGame(TypeGame.WORDSBLANK)).thenReturn(questionInfo);
////        verify(playGameService, times(1)).startGame(TypeGame.WORDSBLANK);
////
//////        String returnValue = baseController.wordsblank(model);
////        verify(baseController, times(1)).generateModel(model, questionInfo, "wordsblank");
//////        assertEquals("wordsblank/start",returnValue);
//    }
//
//    @Test
//    public void WordsblankNextTest() throws Exception {
////        var questionInfo = playGameService.generateQuestion();
////        when(playGameService.generateQuestion()).thenReturn(questionInfo);
////        verify(playGameService, times(1)).generateQuestion();
//    }
//
//    @Test
//    public void WordsBlankCheckTest() throws Exception {
////        String[] playerAnswers = {"I","survive","love"};
////        var questionInfo = playGameService.checkAnswer(Arrays.asList(playerAnswers));
////        when(playGameService.checkAnswer(Arrays.asList(playerAnswers))).thenReturn(questionInfo);
////        verify(playGameService, times(1)).checkAnswer(Arrays.asList(playerAnswers));
//    }
//
//    @Test
//    public void LyricspatchTest(){
////        var questionInfo = playGameService.startGame(TypeGame.LYRICSPATCH);
////        when(playGameService.startGame(TypeGame.LYRICSPATCH)).thenReturn(questionInfo);
////        verify(playGameService, times(1)).startGame(TypeGame.LYRICSPATCH);
//    }
//
//    @Test
//    public void LyricspatchNextTest(){
////        var questionInfo = playGameService.generateQuestion();
////        when(playGameService.generateQuestion()).thenReturn(questionInfo);
////        verify(playGameService, times(1)).generateQuestion();
//    }
//
//    @Test
//    public void LyricspatchCheckTest(){
////        String[] playerAnswers = {"I know that I can't survive without you"};
////        var questionInfo = playGameService.checkAnswer(Arrays.asList(playerAnswers));
////        when(playGameService.checkAnswer(Arrays.asList(playerAnswers))).thenReturn(questionInfo);
////        verify(playGameService, times(1)).checkAnswer(Arrays.asList(playerAnswers));
//    }
//
//    @Test
//    public void RulesViewTest() throws Exception {
////        int rulesId = 3;
////
////        mockMvc.perform(get("/rules/3"))
////                .andExpect(status().isOk())
////                .andExpect((handler().methodName("rulesView")))
////                .andExpect(view().name("modal/rules_modal"));
//    }
//
//
//    @Test
//    public void generateModel() throws Exception {
//
//    }
//}
