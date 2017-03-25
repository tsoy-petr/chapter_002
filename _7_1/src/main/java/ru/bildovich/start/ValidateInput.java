package ru.bildovich.start;

/**
 * Created by mac on 24.03.17.
 * Class
 */
public class ValidateInput extends ConsoleInput {

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
        try {
            Integer.valueOf(id);
            return true;
        } catch (NumberFormatException ie) {
            throw new IdExeption(id);
        }
    }
}
