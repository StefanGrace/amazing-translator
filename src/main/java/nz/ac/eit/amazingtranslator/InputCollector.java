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
        return !input.equals("1"); // return false for input "1", true for anything else
    }

    public String collectWord(String input) throws WordNotInDictException {
        LanguageDict ld = new LanguageDict();
        String word = input.toLowerCase();
        boolean wordInDict = false;
        try {
            String[] frenchWords = ld.getDict("french");
            for (int i = 0; i < frenchWords.length; i++) {
                if (word.equals(frenchWords[i])) {
                    wordInDict = true;
                }
            }
            String[] germanWords = ld.getDict("german");
            for (int i = 0; i < germanWords.length; i++) {
                if (word.equals(germanWords[i])) {
                    wordInDict = true;
                }
            }
        } catch (UnsupportedLanguageException ule) {
            throw new WordNotInDictException();
        }
        if (wordInDict) {
            return word;
        } else {
            throw new WordNotInDictException();
        }
    }
}
