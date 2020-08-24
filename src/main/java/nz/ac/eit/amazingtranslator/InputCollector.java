package nz.ac.eit.amazingtranslator;

public class InputCollector {

    public int collectNumber(String input) throws InputNotIntException, InputOutOfRangeException {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(input);
            if (inputNumber < 1 || inputNumber > 30) {
                throw new InputOutOfRangeException();
            }
        } catch (NumberFormatException nfe) {
            throw new InputNotIntException();
        }
        return inputNumber;
    }

    public String collectLanguage(String input) throws UnsupportedLanguageException {
        String language = input.toLowerCase();
        if (language.equals("french") || language.equals("german")) {
            return language;
        } else {
            throw new UnsupportedLanguageException();
        }
    }

    public boolean collectExitChoice(String input) {
        return !input.equals("1"); // return true for input "1", false for anything else
    }
}
