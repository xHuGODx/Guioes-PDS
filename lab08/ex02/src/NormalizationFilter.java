import java.text.Normalizer;

/**
 * The `NormalizationFilter` class is a decorator that normalizes the text read by a `TextReaderInterface`
 * by removing diacritical marks and converting it to lowercase.
 */
public class NormalizationFilter extends TextFilterDecorator {
    private NormalizationFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    public static TextReaderInterface addNormalizationFilter(TextReaderInterface textReader) {
        return new NormalizationFilter(textReader);
    }

    /**
     * Normalizes a given word by removing diacritical marks and converting it to lowercase.
     *
     * @param word the word to be normalized
     * @return the normalized word
     */
    private static String normalize(String word) {
        String normalized = Normalizer.normalize(word, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("[^\\p{ASCII}]", "");
        return normalized.toLowerCase();
    }

    @Override
    public boolean hasNext() {
        return this.getTextReader().hasNext();
    }

    @Override
    public String next() {
        return normalize(this.getTextReader().next());
    }
}
