package id.ac.ui.cs.advprog.tkadpro.model;

import lombok.Data;

@Data
public class QuestionInfo {
    private int questionNumber;
    private int score;
    private int numberOfAnswer;
    private String level;
    private String question;
    private int hp;

    public QuestionInfo(int questionNumber, int score, int numberOfAnswer, String level, String question, int hp) {
        this.questionNumber = questionNumber;
        this.score = score;
        this.numberOfAnswer = numberOfAnswer;
        this.level = level;
        this.question = question;
        this.hp = hp;
    }
}
