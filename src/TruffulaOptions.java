import java.io.File;
import java.io.FileNotFoundException;

public class TruffulaOptions  {
  private final File root;
  private final boolean showHidden;
  private final boolean useColor;

  public File getRoot() {
    return root;
  }


  public boolean isShowHidden() {
    return showHidden;
  }


  public boolean isUseColor() {
    return useColor;
  }


  // Structure [-h] [-nc] path
  // -h show hidden files (defaults to false)
  // -nc do not use color (uses color by default)
  // If color is not used then all text is white
  // Throws IllegalArgumentException if unkown arguments or missing filepath
  // Throws FileNotFoundException if the directory cannot be found or if the path points to a file
  // Examples:
  // ['-nc', '-h' '/path/to/directory'] don't use color, do show hidden files
  // ['-h', '-nc' '/path/to/directory'] don't use color, do show hidden files (order of flags unimportant)
  // ['/path/to/file'] use color, don't show hidden files
  public TruffulaOptions (String[] args) throws IllegalArgumentException, FileNotFoundException  {
    // TODO: Replace the below lines with your implementation
    root = null;
    showHidden = false;
    useColor = false;
  }


  public TruffulaOptions (File root, boolean showHidden, boolean useColor) {
    // You do not need to modify this constructor
    this.root = root;
    this.showHidden = showHidden;
    this.useColor = useColor;
  }
}
