/**
 * A decorator class that adds capitalization filtering to a given text reader.
 * This class extends the TextFilterDecorator class and overrides the hasNext() and next() methods.
 */
public class CapitalizationFilter extends TextFilterDecorator{
    private CapitalizationFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    public static TextReaderInterface addCapitalizationFilter(TextReaderInterface textReader) {
        return new CapitalizationFilter(textReader);
    }

    /**
     * Filters the capitalization of a word.
     *
     * @param word the word to be filtered
     * @return the filtered word with the first and last characters capitalized and the rest in lowercase
     */
    private static String filterCapitalization(String word) {
        if (word.length() < 2)
            return word.toUpperCase();
        return Character.toString(word.charAt(0)).toUpperCase() + word.substring(1, word.length()-1).toLowerCase() + Character.toString(word.charAt(word.length()-1)).toUpperCase();
    }

    @Override
    public boolean hasNext() {
        return this.getTextReader().hasNext();
    }

    @Override
    public String next() {
        return filterCapitalization(this.getTextReader().next());
    }
}
