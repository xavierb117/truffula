import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TruffulaPrinterTest {

    @Test
    public void testPrintTree_ExactOutput(@TempDir File tempDir) throws IOException {
        // Build the example directory structure:
        // myFolder/
        //    .hidden.txt
        //    Apple.txt
        //    banana.txt
        //    Documents/
        //       images/
        //          Cat.png
        //          cat.png
        //          Dog.png
        //       notes.txt
        //       README.md
        //    zebra.txt
        // Hidden files (e.g. ".hidden.txt") will be created but should not appear in output.

        // Create "myFolder"
        File myFolder = new File(tempDir, "myFolder");
        assertTrue(myFolder.mkdir(), "myFolder should be created");

        // Create visible files in myFolder
        File apple = new File(myFolder, "Apple.txt");
        File banana = new File(myFolder, "banana.txt");
        File zebra = new File(myFolder, "zebra.txt");
        apple.createNewFile();
        banana.createNewFile();
        zebra.createNewFile();

        // Create a hidden file in myFolder
        File hidden = new File(myFolder, ".hidden.txt");
        hidden.createNewFile();

        // Create subdirectory "Documents" in myFolder
        File documents = new File(myFolder, "Documents");
        assertTrue(documents.mkdir(), "Documents directory should be created");

        // Create files in Documents
        File readme = new File(documents, "README.md");
        File notes = new File(documents, "notes.txt");
        readme.createNewFile();
        notes.createNewFile();

        // Create subdirectory "images" in Documents
        File images = new File(documents, "images");
        assertTrue(images.mkdir(), "images directory should be created");

        // Create files in images
        File cat1 = new File(images, "Cat.png");
        File cat2 = new File(images, "cat.png");
        File dog = new File(images, "Dog.png");
        cat1.createNewFile();
        cat2.createNewFile();
        dog.createNewFile();

        // Set up TruffulaOptions with showHidden = false and useColor = true
        // (Assuming TruffulaOptions(File, boolean, boolean) constructor exists)
        TruffulaOptions options = new TruffulaOptions(myFolder, false, true);

        // Instantiate TruffulaPrinter with default color sequence
        TruffulaPrinter printer = new TruffulaPrinter(options);

        // Capture output from printTree()
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        printer.printTree();

        System.out.flush();
        System.setOut(originalOut);

        String output = baos.toString();
        String nl = System.lineSeparator();

        // Build expected output (exactly as specified)
        String reset = "\033[0m";
        String white = "\033[0;37m";
        String purple = "\033[0;35m";
        String yellow = "\033[0;33m";

        StringBuilder expected = new StringBuilder();
        expected.append(white).append("myFolder/").append(reset).append(nl);
        expected.append(purple).append("   Apple.txt").append(reset).append(nl);
        expected.append(purple).append("   banana.txt").append(reset).append(nl);
        expected.append(purple).append("   Documents/").append(reset).append(nl);
        expected.append(yellow).append("      README.md").append(reset).append(nl);
        expected.append(yellow).append("      images/").append(reset).append(nl);
        expected.append(white).append("         Cat.png").append(reset).append(nl);
        expected.append(white).append("         cat.png").append(reset).append(nl);
        expected.append(white).append("         Dog.png").append(reset).append(nl);
        expected.append(yellow).append("      notes.txt").append(reset).append(nl);
        expected.append(purple).append("   zebra.txt").append(reset).append(nl);

        // Assert that the output from printTree() matches exactly the expected output
        assertEquals(expected.toString(), output);
    }
}
