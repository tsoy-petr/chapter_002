package ru.bildovich.start;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mac on 24.03.17.
 * Class
 */
public class ValidateInput extends ConsoleInput {

    private final String MP = "(/d+)";

    @Override
    public String ask(String question) {
        return super.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {

        boolean invalid = true;

        int value = -1;

        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Pleas select key from menu");
            } catch(NumberFormatException nfe) {
                System.out.println("Pleas enter validate data again!");
            }
        } while (invalid);

        return value;

    }

    public String askId(String question) {
        boolean invalid = true;
        String value = "";

        do {
            value = super.ask(question);
           try {
               checkId(value);
               invalid = false;
           } catch (IdExeption ie) {
               System.out.println("Pleas enter validate ID again!");
           }
        } while (invalid);

        return value;
    }

    private boolean checkId(String id) throws IdExeption{

        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(id);

        if (m.matches()) {
            return true;
        } else {
            throw new IdExeption(id);
        }

    }
}
