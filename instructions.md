## Pre-note:

The provided tests are VERY MINIMAL. You are expected to be adding thorough tests at every wave. You may even consider making the tests before you start implementation. You will be docked significant points if you do not test throughly.

You must NOT use the `java.nio` package for any wave! You can only use `java.io`.

## Wave 1: Color Printer
In this wave you will implement a class that can print text to the console in color. To achieve this you implement `print(String message, boolean reset)` in `ColorPrinter.java`. You do not need to alter the other methods.
Hints:
- You will make use of `ConsoleColor.java`. It is an enum, which we haven't covered in class yet. Look at it with curiosity and do some minor research on what enums are in Java. You do not need to modify this file.
- Look at `ColorPrinterTest.java` for an example of how to use `ConsoleColor`
- Consider adding a main method to `ColorPrinter.java` so you can experiment with how it works and what it looks like on the command line.

YOU MUST ALSO IMPLEMENT THOROUGH UNIT TESTS!!!

## Wave 2: TruffulaOptions
In this wave you will be implementing a command line argument parser! You will do so by implementing `TruffulaOptions(String[] args)`. You do not need to modify the other methods. There is a detailed comment at the top of the file explaining how the args should be parsed. READ IT CAREFULLY!

This will later be responsible for actually parsing the commands the user will run from the command line. For example if the user types:

```
truffula -nc -h /path/to/example/dir
```

Then your TruffulaOptions will recieve a String array that looks like:
```
["-nc", "-h", "/path/to/example/dir"]
```

Hints:
- Note that the order of -nc and -h is unimportant and that either or both may be present or not present.
- However, the path will always be the final argument in the array
- It's a really good idea to add tests before the implementation!
- You will need to use the `java.io.File` class. First, create a new `File` with the path. Then, the `.exists()` and `.isDirectory()` methods will be your friend.
- Do a little bit of research into how `java.io.File` works, but you definitely don't need to become an expert on it

You must NOT use the `java.nio` package for any wave! You can only use `java.io`.

YOU MUST ALSO IMPLEMENT THOROUGH UNIT TESTS!!!

## Wave 3: App
In this wave you will set up your main method in `App.java`. This is where your program will actually start when called from the command line! When you have it implemented, you will be able to do the following command from the command line (make sure you are in the root of the project repository):

```
java src/App.java -nc -h src
```

If it is working properly, it should print:
```
TODO(auberon): Sample output here
```

You will need to do a number of things to make it work.
1. Create a new TruffulaOptions by passing it `args`
2. Create a new TruffulaPrinter usting the TruffulaOptions.
3. Call `printTree` on the TruffulaPrinter

You do not need to handle invalid command line arguments at this point (that is an extra credit wave).

## Wave 4: Initial TruffulaPrinter
In this wave you will make it so the TruffulaPrint can print a directory tree. For this wave do not worry about colors or alphabetization. The given test will NOT yet pass because of the lack of color or alphabetical order, I STRONGLY recommend making a simpler test that does not require these to be implemented first. Look at the exisiting test to understand how to make a test.

Hints:
- You will find the following methods helpful: 
