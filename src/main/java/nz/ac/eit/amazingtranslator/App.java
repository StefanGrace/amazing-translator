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

        // ask user for number
        boolean exit = false;
        while (!exit) {
            int inputNumber = 0;
            while (inputNumber == 0) {
                System.out.print("Provide a number: ");
                try {
                    inputNumber = ic.collectNumber(scanner.nextLine());
                    if (inputNumber < 1 || inputNumber > 30) {
                        System.out.println("Number must be from 1 to 30");
                        inputNumber = 0;
                    }
                } catch (InputNotIntException inie) {
                    System.out.println("You must enter an integer");
                    inputNumber = 0;
                } catch (InputOutOfRangeException ioore) {
                    System.out.println("Number must be from 1 to 30");
                    inputNumber = 0;
                }
            }

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

            // ask user weather to exit or restart
            System.out.print("Enter 1 to restart, anything else to exit: ");
            exit = ic.collectExitChoice(scanner.nextLine());
        }
    }
}
