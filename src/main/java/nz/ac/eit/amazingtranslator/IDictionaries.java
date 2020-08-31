package nz.ac.eit.amazingtranslator;

public interface IDictionaries {

    void initializeDataSouce();
    String getFromDataSource(int number, String language) throws InputOutOfRangeException, UnsupportedLanguageException;
    boolean isInitialized();

}
