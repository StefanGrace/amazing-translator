package nz.ac.eit.amazingtranslator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LanguageDictTest {

    private LanguageDict dict;

    @Before
    public void setup() {
        dict = new LanguageDict();
        // mock
        IDictionaries mock = Mockito.mock(IDictionaries.class);
        try {
            Mockito.when(mock.getFromDataSource(12, "french")).thenReturn("douze");
            Mockito.when(mock.getFromDataSource(14, "german")).thenReturn("vierzehn");
        } catch (UnsupportedLanguageException ule) {
            ule.printStackTrace();
        } catch (InputOutOfRangeException ioore) {
            ioore.printStackTrace();
        }
        // stub
        dict.setDict(new StubDict());
    }

    @Test
    public void getTraslation_12InFrench_returnDouze() {
        LanguageDict ld = new LanguageDict();
        try {
            Assert.assertEquals("12 in French should be douze", "douze", ld.getTranslation(12, "french"));
        } catch(InputOutOfRangeException ioore) {
            Assert.fail("12 does not have any traslation available");
        } catch(UnsupportedLanguageException ule) {
            ule.printStackTrace();
        }
    }

    @Test
    public void getTraslation_12WithUnsupportedLanguage_throwsUnsupportedLanguageException() {
        LanguageDict ld = new LanguageDict();
        try {
            ld.getTranslation(12, "english");
            Assert.fail("It shoud fail with an unsupported language");
        } catch(InputOutOfRangeException ioore) {
            Assert.fail("12 does not have any traslation available");
        } catch(UnsupportedLanguageException ule) {
            // Pass
        }
    }

    @Test(expected = UnsupportedLanguageException.class)
    public void getTraslation_12WithUnsupportedLanguage_throwsUnsupportedLanguageException_betterWay() throws UnsupportedLanguageException {
        LanguageDict ld = new LanguageDict();
        try {
            ld.getTranslation(12, "english");
            Assert.fail("It shoud fail with an unsupported language");
        } catch (InputOutOfRangeException ioore) {
            Assert.fail("12 does not have any traslation available");
        }
    }

    @Test
    public void getTraslation_14InGerman_returnVierzehn() {
        LanguageDict ld = new LanguageDict();
        try {
            Assert.assertEquals("14 in German should be vierzehn", "vierzehn", ld.getTranslation(14, "german"));
        } catch(InputOutOfRangeException ioore) {
            Assert.fail("14 does not have any traslation available");
        } catch(UnsupportedLanguageException ule) {
            ule.printStackTrace();
        }
    }

    @Test(expected = InputOutOfRangeException.class)
    public void getTraslation_0InFrench_throwsInputOutOfRangeException() throws InputOutOfRangeException {
        LanguageDict ld = new LanguageDict();
        try {
            ld.getTranslation(0, "french");
            Assert.fail("0 shoud fail");
        } catch(UnsupportedLanguageException ule) {
            ule.printStackTrace();
        }
    }

    @Test(expected = InputOutOfRangeException.class)
    public void getTraslation_31InGerman_throwsInputOutOfRangeException() throws InputOutOfRangeException {
        LanguageDict ld = new LanguageDict();
        try {
            ld.getTranslation(31, "german");
            Assert.fail("31 shoud fail");
        } catch(UnsupportedLanguageException ule) {
            ule.printStackTrace();
        }
    }

    @Test
    public void checkDictionaries_returns30_30() {
        LanguageDict ld = new LanguageDict();
        Assert.assertArrayEquals(new int[] {30, 30}, ld.checkDictionaries());
    }

    @Test
    public void getDict_french() {
        LanguageDict ld = new LanguageDict();
        try {
            Assert.assertEquals("Size of French dictionary should be 30", 30, ld.getDict("french").length);
        } catch (UnsupportedLanguageException ule) {
            ule.printStackTrace();
        }
    }

    @Test
    public void getDict_german() {
        LanguageDict ld = new LanguageDict();
        try {
            Assert.assertEquals("Size of German dictionary should be 30", 30, ld.getDict("german").length);
        } catch (UnsupportedLanguageException ule) {
            ule.printStackTrace();
        }
    }

    @Test
    public void getNumber_douze_returns_12() {
        LanguageDict ld = new LanguageDict();
        try {
            Assert.assertEquals("douze shoud return 12", 12, ld.getNumber("douze"));
        } catch (WordNotInDictException wnide) {
            Assert.fail("douze should return 12");
        }
    }

    @Test (expected = WordNotInDictException.class)
    public void getNumber_a_returns_12() throws WordNotInDictException {
        LanguageDict ld = new LanguageDict();
        ld.getNumber("a");
        Assert.fail("a should fail");
    }

}
