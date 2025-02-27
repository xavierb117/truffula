import java.io.File;
import java.util.Arrays;

/**
 * Utility class for sorting an array of files alphabetically by name, 
 * ignoring case differences.
 */
public class AlphabeticalFileSorter {

  /**
   * Sorts an array of files alphabetically by name, ignoring case.
   *
   * @param files the array of files to be sorted
   * @return the sorted array of files
   */
  public static File[] sort(File[] files) {
    // This uses lambdas, which we haven't yet covered
    // Look at it with curiosity, but you don't need to edit anything here
    Arrays.sort(files, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
    return files;
  }
}
