import java.io.PrintStream;
import java.util.List;

public class TruffulaPrinter {
  private TruffulaOptions options;
  private List<ConsoleColor> colorSequence;
  private ColorPrinter out;

  // Default Color Sequence
  private static final List<ConsoleColor> DEFAULT_COLOR_SEQUENCE = List.of(
      ConsoleColor.WHITE, ConsoleColor.PURPLE, ConsoleColor.YELLOW
  );

  public TruffulaPrinter(TruffulaOptions options) {
    this(options, System.out, DEFAULT_COLOR_SEQUENCE);
  }

  public TruffulaPrinter(TruffulaOptions options, List<ConsoleColor> colorSequence) {
    this(options, System.out, colorSequence);
  }

  public TruffulaPrinter(TruffulaOptions options, PrintStream outStream) {
    this(options, outStream, DEFAULT_COLOR_SEQUENCE);
  }

  public TruffulaPrinter(TruffulaOptions options, PrintStream outStream, List<ConsoleColor> colorSequence) {
    this.options = options;
    this.colorSequence = colorSequence;
    out = new ColorPrinter(outStream);
  }

  /**
   * Prints a tree representing the directory structure, with directories and files
   * sorted in a case-insensitive manner. The tree is displayed with 3 spaces of
   * indentation for each directory level.
   *
   * If color is enabled, the output cycles through colors at each directory level
   * to visually differentiate them. If color is disabled, all output is displayed in white.
   *
   * The sorting is case-insensitive. If two files have identical case insensitive names
   * then they are sorted lexicographically (Cat.png before cat.png)
   *
   * Example Output:
   *
   * myFolder/
   *    Apple.txt
   *    banana.txt
   *    Documents/
   *       images/
   *          Cat.png
   *          cat.png
   *          Dog.png
   *       notes.txt
   *       README.md
   *    zebra.txt
   *
   */
  public void printTree() {

  }
}
