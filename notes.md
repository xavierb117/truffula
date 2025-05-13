# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
- This is the application for printing a directory tree, must be done manually
- There are options to show hidden files that start with a dot, and handle colored output
- OOP Heavy, create TruffulaOptions using args and pass it to TruffulaPrinter

## ConsoleColor.java
- This is an Enum representing ANSI escape codes for colored output
- Used to format console output by applying colors to texts
- Makes use of Enum, which will be researched in order to solve

## ColorPrinter.java / ColorPrinterTest.java

## TruffulaOptions.java / TruffulaOptionsTest.java

## TruffulaPrinter.java / TruffulaPrinterTest.java
TrufullaPrinter:
    - Prints out the directory and optional colors if selected/inputted
    - Same methods with different signature/parameters; Whichever argument is selected is the method that will be used

## AlphabeticalFileSorter.java
- Looks over the files, grabs two at a time and compares sorts them alphabetically, then repeats for the entire file directory you're in. 
    - What happens to the method if there's only one file in the directory?
