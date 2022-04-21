package id.ac.ui.cs.advprog.tkadpro.core.tools;

import java.util.List;

public class Joiner {
    private final String regex;

    public Joiner(String regex) {
        this.regex = regex;
    }

    public String join(List<String> lyrics) {
        return String.join(regex, lyrics);
    }
}
