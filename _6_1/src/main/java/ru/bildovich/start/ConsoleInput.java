package ru.bildovich.start;

import ru.bildovich.models.Input;

import java.util.Scanner;

/**
 * bildovich
 * 05.03.2017.
 */
public class ConsoleInput implements Input{

    /**
     * Private Scanner scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public void print(String data) {

    }
}
