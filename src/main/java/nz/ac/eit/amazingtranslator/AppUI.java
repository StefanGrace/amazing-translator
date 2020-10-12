package nz.ac.eit.amazingtranslator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class AppUI
{


    public static void main( String[] args )
    {

        LanguageDict ld = new LanguageDict();
        //TranslationDictionary dictionary=new InMemoryTranslationsDictionary();
        //dictionary.intializeTranslations();
        //ld.setDictionary(dictionary);

        InputCollector ic = new InputCollector();

        JFrame frame = new JFrame();

        frame.setTitle("Amazing Translator");

        frame.setSize(400, 500);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();
        frame.setContentPane(panel);
        JLabel numberLabel=new JLabel("What is the number to translate?");
        JTextField tf=new JTextField(2);
        JButton translateButton=new JButton("Translate");
        ButtonGroup group=new ButtonGroup();
        JRadioButton german=new JRadioButton("German");
        german.setSelected(true);
        JRadioButton french=new JRadioButton("French");
        group.add(french);
        group.add(german);

        JLabel translated = new JLabel();

        panel.add(numberLabel);
        panel.add(tf);
        panel.add(french);
        panel.add(german);
        panel.add(translateButton);
        panel.add(translated);

        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String numberAsString=tf.getText();
                int numberToTranslate=0;
                try {
                    numberToTranslate = ic.collectNumber(numberAsString);
                }
                catch (InputNotIntException inie){
                    System.out.println(inie.getMessage());
                    translated.setText("Input should be an integer");
                    //System.exit(1);
                }
                catch (InputOutOfRangeException ioore){
                    System.out.println(ioore.getMessage());
                    translated.setText("Number should be from 1 to 30");
                    //System.exit(1);
                }

                String language = null;

                String languageAsString = french.isSelected() ? "french" : "german";
                try {
                    language = ic.collectLanguage(languageAsString);
                }
                catch (UnsupportedLanguageException ule){
                    System.out.println(ule.getMessage());
                    System.exit(1);
                }

                try {
                    translated.setText(ld.getTranslation(numberToTranslate, language));
                }
                catch (InputOutOfRangeException ioore){
                    System.out.println(ioore.getMessage());
                    //System.exit(1);
                }
                catch (UnsupportedLanguageException ule) {
                    System.out.println(ule.getMessage());
                    //System.exit(1);
                }
            }
        });


        frame.setVisible(true);




    }
}
