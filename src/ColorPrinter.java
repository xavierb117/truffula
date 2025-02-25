import java.io.PrintStream;

public class ColorPrinter {
  // Reset
  private static final String RESET = "\033[0m";

  private ConsoleColor currentColor;
  private final PrintStream printStream;


  public ConsoleColor getCurrentColor() {
    return currentColor;
  }

  public void setCurrentColor(ConsoleColor color) {
    this.currentColor = color;
  }

  // Sets the terminal's color to currentColor, prints the message, resets the color, then has a new line
  public void println(String message) {
    println(message, true);
  }

  public void println(String message, boolean reset) {
    
  }

  public void print(String message) {
    print(message, true);
  }


  public void print(String message, boolean reset) {

  }

  public ColorPrinter(PrintStream printStream) {
    this(printStream, ConsoleColor.WHITE);
  }

  public ColorPrinter(PrintStream printStream, ConsoleColor color) {
    this.printStream = printStream;
    this.currentColor = color;
  }
}
