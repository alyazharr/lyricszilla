package id.ac.ui.cs.advprog.tkadpro.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HintInfo {
    private List<String> hintAnswer;
    private int numHint;
    private int point;

    public HintInfo(List<String> hintAnswer, int numHint, int point) {
        this.hintAnswer = hintAnswer;
        this.numHint = numHint;
        this.point = point;
    }
}
