package nz.ac.eit.amazingtranslator;

import org.junit.Assert;
import org.junit.Test;

public class InputCollectorTest {

    @Test
    public void collectNumber_12_returns12() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("The string \"12\" should return the number 12", 12, ic.collectNumber("12"));
        } catch (InputOutOfRangeException ioore) {
            Assert.fail("12 should be in range");
        } catch (InputNotIntException inie) {
            inie.printStackTrace();
        }
    }

    @Test(expected = InputOutOfRangeException.class)
    public void collectNumber_0_throwsInputOutOfRangeException() throws InputOutOfRangeException {
        InputCollector ic = new InputCollector();
        try {
            ic.collectNumber("0");
            Assert.fail("0 should fail");
        } catch(InputNotIntException inie) {
            inie.printStackTrace();
        }
    }

    @Test(expected = InputOutOfRangeException.class)
    public void collectNumber_31_throwsInputOutOfRangeException() throws InputOutOfRangeException {
        InputCollector ic = new InputCollector();
        try {
            ic.collectNumber("31");
            Assert.fail("31 should fail");
        } catch(InputNotIntException inie) {
            inie.printStackTrace();
        }
    }

    @Test(expected = InputNotIntException.class)
    public void collectNumber_one_throwsInputNotIntException() throws InputNotIntException {
        InputCollector ic = new InputCollector();
        try {
            ic.collectNumber("one");
            Assert.fail("\"one\" should fail");
        } catch(InputOutOfRangeException ioore) {
            ioore.printStackTrace();
        }
    }

    @Test(expected = InputNotIntException.class)
    public void collectNumber_1point5_throwsInputNotIntException() throws InputNotIntException {
        InputCollector ic = new InputCollector();
        try {
            ic.collectNumber("1.5");
            Assert.fail("1.5 should fail");
        } catch(InputOutOfRangeException ioore) {
            ioore.printStackTrace();
        }
    }

    @Test
    public void collectLanguage_french_returnsFrench() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("french should return french", "french", ic.collectLanguage("french"));
        } catch (UnsupportedLanguageException ule) {
            Assert.fail("french should be supported");
        }
    }

    @Test
    public void collectLanguage_german_returnsGerman() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("german should return gemran", "german", ic.collectLanguage("german"));
        } catch (UnsupportedLanguageException ule) {
            Assert.fail("german should be supported");
        }
    }

    @Test
    public void collectLanguage_French_returnsFrench() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("French should return french", "french", ic.collectLanguage("French"));
        } catch (UnsupportedLanguageException ule) {
            Assert.fail("French should be supported");
        }
    }

    @Test
    public void collectLanguage_German_returnsGerman() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("German should return gemran", "german", ic.collectLanguage("German"));
        } catch (UnsupportedLanguageException ule) {
            Assert.fail("German should be supported");
        }
    }

    @Test
    public void collectLanguage_FRENCH_returnsFrench() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("FRENCH should return french", "french", ic.collectLanguage("FRENCH"));
        } catch (UnsupportedLanguageException ule) {
            Assert.fail("FRENCH should be supported");
        }
    }

    @Test
    public void collectLanguage_GERMAN_returnsGerman() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("GERMAN should return gemran", "german", ic.collectLanguage("GERMAN"));
        } catch (UnsupportedLanguageException ule) {
            Assert.fail("GERMAN should be supported");
        }
    }

    @Test(expected = UnsupportedLanguageException.class)
    public void collectLanguage_spanish_throwsUnsupportedLanguageException() throws UnsupportedLanguageException {
        InputCollector ic = new InputCollector();
        ic.collectLanguage("spanish");
        Assert.fail("spanish should fail");
    }

    @Test(expected = UnsupportedLanguageException.class)
    public void collectLanguage_1_throwsUnsupportedLanguageException() throws UnsupportedLanguageException {
        InputCollector ic = new InputCollector();
        ic.collectLanguage("1");
        Assert.fail("1 should fail");
    }

    @Test
    public void collectExitChoice_1_returnsFlase() {
        InputCollector ic = new InputCollector();
        Assert.assertFalse(ic.collectExitChoice("1"));
    }

    @Test
    public void collectExitChoice_0_returnsTrue() {
        InputCollector ic = new InputCollector();
        Assert.assertTrue(ic.collectExitChoice("0"));
    }

    @Test
    public void collectExitChoice_2_returnsTrue() {
        InputCollector ic = new InputCollector();
        Assert.assertTrue(ic.collectExitChoice("2"));
    }

    @Test
    public void collectExitChoice_e_returnsTrue() {
        InputCollector ic = new InputCollector();
        Assert.assertTrue(ic.collectExitChoice("e"));
    }

    @Test
    public void collectWord_douze_returns_douze() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("douze shoud return douze", "douze", ic.collectWord("douze"));
        } catch (WordNotInDictException wnide) {
            Assert.fail("douze shoud return douze");
        }
    }

    @Test
    public void collectWord_Douze_returns_douze() {
        InputCollector ic = new InputCollector();
        try {
            Assert.assertEquals("Douze shoud return douze", "douze", ic.collectWord("Douze"));
        } catch (WordNotInDictException wnide) {
            Assert.fail("Douze shoud return douze");
        }
    }

    @Test (expected = WordNotInDictException.class)
    public void collectWord_a_throws_WordNotInDictException() throws WordNotInDictException {
        InputCollector ic = new InputCollector();
        ic.collectWord("a");
        Assert.fail("a shoud fail");
    }


}
