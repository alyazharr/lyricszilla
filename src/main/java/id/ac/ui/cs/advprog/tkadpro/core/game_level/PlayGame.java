package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PlayGame {
    private EasyLevelState easyLevelState = new EasyLevelState(this);
    private MediumLevelState mediumLevelState = new MediumLevelState(this);
    private HardLevelState hardLevelState = new HardLevelState(this);
    private GameLevel currentState;
    private int questionCounter = 0;
    private int hintCounter = 0;
    private int points = 0;
    private int hp = 100;
    private boolean isFinished;

    public String play() {
        questionCounter++;
        hintCounter = 0;
        changeState();
        return currentState.play();
    }

    public boolean checkAnswer(List<String> playerAnswer){
        return currentState.checkAnswer(playerAnswer);
    }

    public void changeState() {
        currentState.changeState();
    }

    public List<String> useHint() {
        List<String> listOfAnswer = currentState.getAnswers();
        List<String> listOfHint = currentState.getHintAnswers();
        hintCounter++;
        if (currentState.getLevel().equals("EASY")) {
            System.out.println("MASUK EASY");
            if (hintCounter == 1) {
                System.out.println("MASUK EASY 0");
                points -= 3;

            } else if (hintCounter == 2) {
                System.out.println("MASUK 2");
                points -= 5;
                for (int i = 0; i < listOfAnswer.size(); i++) {
                    if (listOfAnswer.get(i).length() > 1) {
                        listOfHint.set(i, listOfAnswer.get(i).substring(0, 2));
                    }
                }

            } else if (hintCounter == 3) {
                System.out.println("MASUK 3");
                points -= 8;
                for (int i = 0; i < listOfAnswer.size(); i++) {
                    if (listOfAnswer.get(i).length() > 2) {
                        listOfHint.set(i, listOfAnswer.get(i).substring(0, 3));
                    }
                }

            }
        } else if (currentState.getLevel().equals("MEDIUM")) {
            System.out.println("MASUK MEDIUM");
            if (hintCounter == 1) {
                System.out.println("MASUK MEDIUM 1");
                points -= 5;

            } else  if (hintCounter == 2) {
                System.out.println("MASUK MEDIUM 2");
                for (int i = 0; i < listOfAnswer.size(); i++) {
                    if (listOfAnswer.get(i).length() > 1) {
                        listOfHint.set(i, listOfAnswer.get(i).substring(0, 2));
                    }
                }
                points -= 8;

            } else  if (hintCounter == 3) {
                System.out.println("MASUK MEDIUM 3");
                for (int i = 0; i < listOfAnswer.size(); i++) {
                    if (listOfAnswer.get(i).length() > 2) {
                        listOfHint.set(i, listOfAnswer.get(i).substring(0, 3));
                    }
                }
                points -= 12;

            }
        } else if (currentState.getLevel().equals("HARD")) {
            if (hintCounter == 0) {
                points -= 7;

            } else  if (hintCounter == 1) {
                for (int i = 0; i < listOfAnswer.size(); i++) {
                    if (listOfAnswer.get(i).length() > 1) {
                        listOfHint.set(i, listOfAnswer.get(i).substring(0, 2));
                    }
                }
                points -= 10;

            } else  if (hintCounter == 2) {
                for (int i = 0; i < listOfAnswer.size(); i++) {
                    if (listOfAnswer.get(i).length() > 2) {
                        listOfHint.set(i, listOfAnswer.get(i).substring(0, 3));
                    }
                }
                points -= 15;

            }
        }
        System.out.println("currentState.getHintAnswers(): " + currentState.getHintAnswers());
        return currentState.getHintAnswers();
    }

    public void setGameType(GameType gameType){
        easyLevelState.setGameType(gameType);
        mediumLevelState.setGameType(gameType);
        hardLevelState.setGameType(gameType);
    }

    public int getNumberOfAnswer(){
        return currentState.getNumberOfAnswer();
    }
}
