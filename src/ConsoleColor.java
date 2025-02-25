/**
 * Enum representing ANSI escape codes for console text colors.
 * 
 * These colors can be used to format console output by applying the corresponding
 * ANSI escape codes. The colors affect the text color in supported terminals.
 * 
 * To apply a color, prepend the ANSI code to the text, and append the RESET code
 * ("\033[0m") after the text to reset the color back to default.
 * 
 * Supported Colors:
 * - BLACK   : Black text
 * - RED     : Red text
 * - GREEN   : Green text
 * - YELLOW  : Yellow text
 * - BLUE    : Blue text
 * - PURPLE  : Purple text
 * - CYAN    : Cyan text
 * - WHITE   : White text
 * - RESET   : Resets the text color to default
 */
public enum ConsoleColor {
  /**
   * Black text color (ANSI code: \033[0;30m).
   */
  BLACK("\033[0;30m"),

  /**
   * Red text color (ANSI code: \033[0;31m).
   */
  RED("\033[0;31m"),

  /**
   * Green text color (ANSI code: \033[0;32m).
   */
  GREEN("\033[0;32m"),

  /**
   * Yellow text color (ANSI code: \033[0;33m).
   */
  YELLOW("\033[0;33m"),

  /**
   * Blue text color (ANSI code: \033[0;34m).
   */
  BLUE("\033[0;34m"),

  /**
   * Purple text color (ANSI code: \033[0;35m).
   */
  PURPLE("\033[0;35m"),

  /**
   * Cyan text color (ANSI code: \033[0;36m).
   */
  CYAN("\033[0;36m"),

  /**
   * White text color (ANSI code: \033[0;37m).
   */
  WHITE("\033[0;37m"),

  /**
   * Resets the text color to the terminal's default color (ANSI code: \033[0m).
   */
  RESET("\033[0m");

  private final String code;

  /**
   * Constructs a ConsoleColor with the given ANSI escape code.
   *
   * @param code the ANSI escape code for the color
   */
  ConsoleColor(String code) {
    this.code = code;
  }

  /**
   * Returns the ANSI escape code associated with the color.
   *
   * @return the ANSI escape code as a String
   */
  public String getCode() {
    return code;
  }

  /**
   * Returns the ANSI escape code as a String. This allows the enum to be used
   * directly in print statements.
   *
   * @return the ANSI escape code as a String
   */
  @Override
  public String toString() {
    return code;
  }
}
