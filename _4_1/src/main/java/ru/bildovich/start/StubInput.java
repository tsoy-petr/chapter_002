package ru.bildovich.start;

import ru.bildovich.models.Input;

/**
 * bildovich
 * 06.03.2017.
 */
public class StubInput implements Input{

    private String[] answers;

    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position ++];
    }

    @Override
    public void print(String data) {

    }
}
