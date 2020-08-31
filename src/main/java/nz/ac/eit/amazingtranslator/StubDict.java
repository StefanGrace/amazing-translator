package nz.ac.eit.amazingtranslator;

public class StubDict implements IDictionaries {
    @Override
    public void initializeDataSouce() {

    }

    @Override
    public String getFromDataSource(int number, String language) throws InputOutOfRangeException, UnsupportedLanguageException {
        if (language.equals("french")) {
            switch (number) {
                case 1:
                    return "une/un";
                case 2:
                    return "deux";
                case 12:
                    return "douze";
                default:
                    throw new InputOutOfRangeException();
            }
        } else if (language.equals("german")) {
            switch (number) {
                case 1:
                    return "einer";
                case 2:
                    return "zwei";
                case 14:
                    return "vierzehn";
                default:
                    throw new InputOutOfRangeException();
            }
        } else {
            throw new UnsupportedLanguageException();
        }
    }

    @Override
    public boolean isInitialized() {
        return true;
    }
}
