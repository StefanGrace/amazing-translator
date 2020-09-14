package nz.ac.eit.amazingtranslator;

public class LanguageDict {

    private String[] frenchNumbers = {"une/un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuve/neuf", "dix",
            "elfique", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt",
            "vingt et un", "vingt-deux", "vingt trois", "vingt quatre", "vingt cinq", "vingt-six", "vingt sept", "vingt-huit", "vingt-neuf", "trente"};
    private String[] germanNumbers = {"einer", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn",
            "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechszehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig",
            "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"};

    private IDictionaries dict;

    public int[] checkDictionaries() {
        // return the size of French and German dictionaries for the purpose of testing, NOT needed for app
        return new int[]{frenchNumbers.length, germanNumbers.length};
    }

    public String[] getDict(String language) throws UnsupportedLanguageException {
        switch (language) {
            case "french":
                return frenchNumbers;
            case "german":
                return germanNumbers;
            default:
                throw new UnsupportedLanguageException();
        }
    }

    public String getTranslation (int number, String language) throws InputOutOfRangeException, UnsupportedLanguageException {
        try {
            return getDict(language)[number - 1];
        } catch (UnsupportedLanguageException ule) {
            throw ule;
        } catch (IndexOutOfBoundsException ioobe) {
            throw new InputOutOfRangeException();
        }
    }

    public int getNumber(String word) throws WordNotInDictException {
        try {
            String[] frenchNumbers = getDict("french");
            for (int i = 0; i < frenchNumbers.length; i++) {
                if (word.equals(frenchNumbers[i])) {
                    return i + 1;
                }
            }
            String[] germanNumbers = getDict("german");
            for (int i = 0; i < germanNumbers.length; i++) {
                if (word.equals(germanNumbers[i])) {
                    return i + 1;
                }
            }
        } catch (UnsupportedLanguageException ule) {
            throw new WordNotInDictException();
        }
        throw new WordNotInDictException();
    }

    public IDictionaries getDict() {
        return dict;
    }

    public void setDict(IDictionaries dict) {
        this.dict = dict;
    }
}
