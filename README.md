# amazing-translator
The program translates a given number between 1 and 30 (inclusive) to French or German.

* REQ_1: Prompt number to translate - Given the program has been started, When the program is up and running, Then the following sentence should be displayed "Provide a number" and the user is given the opportunity to type a number

* REQ_2: Valid number inputted - Given the "Provide a number" prompt has been shown, When a user enters a number from 1 to 30, Then the following sentence should be displayed "What to translate to?" and the user is given the opportunity to type the name of a language

* REQ_3: Valid language inputted - Given the "What to translate to?" prompt has been shown, When a user enters "French" or "German", Then translate the given number to that Language.

* REQ_4: Invalid number inputted - Given the "Provide a number" prompt has been shown, When a user enters a number that is NOT from 1 to 30, Then the following message should be displayed to the console "Number must be from 1 to 30"

* REQ_5: Text inputted instead of number - Given the "Provide a number" prompt has been shown, When a user enters text, Then the following message should be displayed to the console "You must enter an integer”

* REQ_6: Invalid language inputted - Given the "What to translate to?" prompt has been shown, When a user enters a language other than "French" or "German", Then the following message should be displayed to the console “Sorry, we don’t support that language”

* REQ_7: Done translating - Given the program has displayed the translated output to the console, Then the following sentence should be displayed "Enter 1 to restart, anything else to exit"

* REQ_8: Given the message - "Enter 1 to restart, anything else to exit" is displayed, When the user enters 1, Then the program should restart

* REQ_9: Exit requested - Given the message "Enter 1 to restart, anything else to exit" is displayed, When the user enters anything exept 1, exit the program
