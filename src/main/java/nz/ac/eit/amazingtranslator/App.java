package nz.ac.eit.amazingtranslator;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        // create objects
        Scanner scanner = new Scanner(System.in);
        InputCollector ic = new InputCollector();
        LanguageDict ld = new LanguageDict();


        boolean exit = false;

        while (!exit) {
            // ask user for number
            int inputNumber = 0;
            String inputWord = "";
            while (inputNumber == 0) {
                System.out.print("Provide a number: ");
                String inputString = scanner.nextLine();
                try {
                    inputNumber = ic.collectNumber(inputString);
                } catch (InputNotIntException inie) {
                    //System.out.println("You must enter an integer");
                    try {
                        inputWord = ic.collectWord(inputString);
                    } catch (WordNotInDictException wnide){
                        System.out.println("The word\" " + inputWord + " \" is not a number from 1 to 30 in French is German");
                    }
                    inputNumber = 0;
                } catch (InputOutOfRangeException ioore) {
                    System.out.println("Number must be from 1 to 30");
                    inputNumber = 0;
                }
            }

            if (inputNumber > 0) {

                // ask user for language
                String outputLanguage = "";
                while (!outputLanguage.equals("french") && !outputLanguage.equals("german")) {
                    System.out.print("What to translate to?: ");
                    try {
                        outputLanguage = ic.collectLanguage(scanner.nextLine());
                    } catch (UnsupportedLanguageException ule) {
                        System.out.println("The supported languages are French and German");
                    }
                }

                // translate the chosen number into the chosen language
                try {
                    System.out.println(ld.getTranslation(inputNumber, outputLanguage));
                } catch (Exception e) {
                    System.out.println("System error! Please report bug.");
                }
            }

            if (inputWord.length() > 0) {
                // translate word into number in French or German
                try {
                    System.out.println(ld.getNumber(inputWord));
                } catch (WordNotInDictException wnide) {
                    System.out.println("System error! Please report bug.");
                }
            }

            // ask user weather to exit or restart
            System.out.print("Enter 1 to restart, anything else to exit: ");
            exit = ic.collectExitChoice(scanner.nextLine());
        }
    }
}
