import java.io.File;
import java.util.Scanner;

/**
 * The TextReader class is responsible for reading text from a file.
 * It implements the TextReaderInterface interface.
 */
public class TextReader implements TextReaderInterface {
    private File file;
    private Scanner file_sc;
    private String curLine;

    /**
     * Constructs a TextReader object with the specified file name.
     * 
     * @param fileName the name of the file to be read
     */
    private TextReader(String fileName) {
        this.file = new File(fileName);
        try {
            this.file_sc = new Scanner(this.file);
            curLine = (this.file_sc.hasNext()) ? file_sc.nextLine() : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    
    /**
     * Creates a TextReader object with the specified file name.
     * 
     * @param fileName the name of the file to be read
     * @return a TextReaderInterface object
     */
    public static TextReaderInterface createTextReader(String fileName) {
        return new TextReader(fileName);
    }

    /**
     * Returns the current line being read.
     * 
     * @return the current line being read
     */
    @Override
    public String getCurLine() {
        return this.curLine;
    }

    /**
     * Checks if there is a next line to be read.
     * 
     * @return true if there is a next line, false otherwise
     */
    @Override
    public boolean hasNext() {
        return this.curLine != null;
    }

    /**
     * Reads the next line from the file and returns it.
     * 
     * @return the next line from the file
     */
    @Override
    public String next() { 
        String temp = this.curLine;
        this.curLine = (this.file_sc.hasNext()) ? file_sc.nextLine() : null;
        return temp;
    }
}
