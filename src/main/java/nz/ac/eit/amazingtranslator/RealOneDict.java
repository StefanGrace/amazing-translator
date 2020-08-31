package nz.ac.eit.amazingtranslator;

public class RealOneDict implements IDictionaries {

    private String[] frenchNumbers = new String[30];
    private String[] germanNumbers = new String[30];

    @Override
    public void initializeDataSouce() {
        String[] frenchNumbers = {"une/un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuve/neuf", "dix",
                "elfique", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf", "vingt",
                "vingt et un", "vingt-deux", "vingt trois", "vingt quatre", "vingt cinq", "vingt-six", "vingt sept", "vingt-huit", "vingt-neuf", "trente"};
        String[] germanNumbers = {"einer", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn",
                "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechszehn", "siebzehn", "achtzehn", "neunzehn", "zwanzig",
                "einundzwanzig", "zweiundzwanzig", "dreiundzwanzig", "vierundzwanzig", "fünfundzwanzig", "sechsundzwanzig", "siebenundzwanzig", "achtundzwanzig", "neunundzwanzig", "dreißig"};
    }

    @Override
    public String getFromDataSource(int number, String language) throws InputOutOfRangeException, UnsupportedLanguageException {
        try {
            switch (language) {
                case "french":
                    return frenchNumbers[number - 1];
                case "german":
                    return germanNumbers[number - 1];
                default:
                    throw new UnsupportedLanguageException();
            }
        } catch (IndexOutOfBoundsException ioobe) {
            throw new InputOutOfRangeException();
        }
    }

    @Override
    public boolean isInitialized() {
        if (frenchNumbers.length == 30 && germanNumbers.length == 30) {
            return frenchNumbers[29].length() > 0 && germanNumbers[29].length() > 0;
        } else {
            return false;
        }

    }
}
