import java.io.PrintStream;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

/**
 * TruffulaPrinter is responsible for printing a directory tree structure
 * with optional colored output. It supports sorting files and directories
 * in a case-insensitive manner and cycling through colors for visual clarity.
 */
public class TruffulaPrinter {
  
  /**
   * Configuration options that determine how the tree is printed.
   */
  private TruffulaOptions options;
  
  /**
   * The sequence of colors to use when printing the tree.
   */
  private List<ConsoleColor> colorSequence;
  
  /**
   * The output printer for displaying the tree.
   */
  private ColorPrinter out;

  /**
   * Default color sequence used when no custom colors are provided.
   */
  private static final List<ConsoleColor> DEFAULT_COLOR_SEQUENCE = List.of(
      ConsoleColor.WHITE, ConsoleColor.PURPLE, ConsoleColor.YELLOW
  );

  /**
   * Constructs a TruffulaPrinter with the given options, using the default
   * output stream and the default color sequence.
   *
   * @param options the configuration options for printing the tree
   */
  public TruffulaPrinter(TruffulaOptions options) {
    this(options, System.out, DEFAULT_COLOR_SEQUENCE);
  }

  /**
   * Constructs a TruffulaPrinter with the given options and color sequence,
   * using the default output stream.
   *
   * @param options the configuration options for printing the tree
   * @param colorSequence the sequence of colors to use when printing
   */
  public TruffulaPrinter(TruffulaOptions options, List<ConsoleColor> colorSequence) {
    this(options, System.out, colorSequence);
  }

  /**
   * Constructs a TruffulaPrinter with the given options and output stream,
   * using the default color sequence.
   *
   * @param options the configuration options for printing the tree
   * @param outStream the output stream to print to
   */
  public TruffulaPrinter(TruffulaOptions options, PrintStream outStream) {
    this(options, outStream, DEFAULT_COLOR_SEQUENCE);
  }

  /**
   * Constructs a TruffulaPrinter with the given options, output stream, and color sequence.
   *
   * @param options the configuration options for printing the tree
   * @param outStream the output stream to print to
   * @param colorSequence the sequence of colors to use when printing
   */
  public TruffulaPrinter(TruffulaOptions options, PrintStream outStream, List<ConsoleColor> colorSequence) {
    this.options = options;
    this.colorSequence = colorSequence;
    out = new ColorPrinter(outStream);
  }

  /**
   * WAVE 4: Prints a tree representing the directory structure, with directories and files
   * sorted in a case-insensitive manner. The tree is displayed with 3 spaces of
   * indentation for each directory level.
   * 
   * WAVE 5: If hidden files are not to be shown, then no hidden files/folders will be shown.
   *
   * WAVE 6: If color is enabled, the output cycles through colors at each directory level
   * to visually differentiate them. If color is disabled, all output is displayed in white.
   *
   * WAVE 7: The sorting is case-insensitive. If two files have identical case-insensitive names,
   * they are sorted lexicographically (Cat.png before cat.png).
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
   */
  public void printTree() {
    // TODO: Implement this!
    // REQUIRED: ONLY use java.io, DO NOT use java.nio
    
    // Hints:
    // - Add a recursive helper method
    // - For Wave 6: Use AlphabeticalFileSorter
    // DO NOT USE SYSTEM.OUT.PRINTLN
    // USE out.println instead (will use your ColorPrinter)
    File root = options.getRoot();
    if (root == null || !root.isDirectory()) return;

    // Wave 4
    out.println(root.getName() + '/');

    printTreeHelper(root, 1, 1);

    // out.println("printTree was called!");
    // out.println("My options are: " + options);
  }

  public void printTreeHelper(File current, int depth, int color) {

    // Wave 4
    if (current != null && current.isDirectory()) {

      // Wave 7
      File[] givenFiles = current.listFiles();
      File[] files = AlphabeticalFileSorter.sort(givenFiles);

      if (files != null) {
        for (File file : files) {
          String gap = "";

          // Wave 5
          if (!options.isShowHidden()) {
            if (file.getName().charAt(0) != '.') {
              for (int i = 0; i < depth; i++) {
                gap = gap + "   ";
              }
              
              // Wave 6
              if (options.isUseColor()) {
                if (file.isDirectory()) {
                  out.setCurrentColor(colorSequence.get(color));
                  out.println(gap + file.getName() + "/");
                  int determine = (color + 1) % colorSequence.size();
                  printTreeHelper(file, depth + 1, determine);
                }
                else {
                  out.setCurrentColor(colorSequence.get(color));
                  out.println(gap + file.getName());
                }
              }
              else {
                if (file.isDirectory()) {
                  out.println(gap + file.getName() + "/");
                  printTreeHelper(file, depth + 1, 0);
                }
                else {
                  out.println(gap + file.getName());
                }
              }
            }
          }
          else {
            for (int i = 0; i < depth; i++) {
                gap = gap + "   ";
            }

            if (options.isUseColor()) {
              if (file.isDirectory()) {
                out.setCurrentColor(colorSequence.get(color));
                out.println(gap + file.getName() + "/");
                int determine = (color + 1) % colorSequence.size();
                printTreeHelper(file, depth + 1, determine);
              }
              else {
                out.setCurrentColor(colorSequence.get(color));
                out.println(gap + file.getName());
              }
            }
            else {
              if (file.isDirectory()) {
                out.println(gap + file.getName() + "/");
                printTreeHelper(file, depth + 1, 0);
              }
              else {
                out.println(gap + file.getName());
              }
            }
          }
        }
      }
    }
  }
}