package nz.ac.eit.amazingtranslator;

public class LanguageDict {

    private String[] frenchNumbers = {"une/un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuve/neuf", "dix",
            "elfique", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt",
            "vingt et un", "vingt-deux", "vingt trois", "vingt quatre", "vingt cinq", "vingt-six", "vingt sept", "vingt-huit", "vingt-neuf", "trente"};
    private String[] germanNumbers = {"einer", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn",
            "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechszehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig",
            "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"};

    public int[] LanguageDict() {
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
            throw new UnsupportedLanguageException();
        } catch (IndexOutOfBoundsException ioobe) {
            throw new InputOutOfRangeException();
        }
    }

}
