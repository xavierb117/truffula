import java.io.File;
import java.util.Arrays;

public class AlphabeticalFileSorter {
  public static File[] sort(File[] files) {
    Arrays.sort(files, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
    return files;
  }
}
