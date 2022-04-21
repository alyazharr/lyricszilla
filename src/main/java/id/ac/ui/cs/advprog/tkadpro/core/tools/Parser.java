package id.ac.ui.cs.advprog.tkadpro.core.tools;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private final String regex;

    public Parser(String regex) {
        this.regex = regex;
    }

    public List<String> parseSentence(String sentence) {
        return Arrays.asList(sentence.split(regex));
    }
}
