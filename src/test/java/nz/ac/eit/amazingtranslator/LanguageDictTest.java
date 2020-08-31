package nz.ac.eit.amazingtranslator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LanguageDictTest {

    private LanguageDict dict;

    @Before
    public void setup() {
        dict = new LanguageDict();
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

}
