import java.util.Scanner;

/**
 * The TermFilter class is a concrete implementation of the TextFilterDecorator abstract class.
 * It represents a filter that extracts individual terms from a text.
 * 
 * This class uses a Scanner to tokenize the input text into terms, using non-word characters as delimiters.
 * It decorates a TextReaderInterface object to read the input text and provides methods to iterate over the extracted terms.
 */
public class TermFilter extends TextFilterDecorator {
    private Scanner line_sc;

    private TermFilter(TextReaderInterface textReader) {
        super(textReader);
        this.line_sc = new Scanner(textReader.getCurLine()).useDelimiter("\\W+");
    }

    public static TextReaderInterface addTermFilter(TextReaderInterface textReader) {
        return new TermFilter(textReader);
    }

    @Override
    public boolean hasNext() {
        return this.line_sc.hasNext() || this.getTextReader().hasNext();
    }

    @Override
    public String next() {
        if (this.hasNext()){
            if (this.line_sc.hasNext()){
                return this.line_sc.next();
            }
            this.line_sc = new Scanner(this.getTextReader().next()).useDelimiter("\\W+");
            return this.next();
        }
        return null;
    }

}
