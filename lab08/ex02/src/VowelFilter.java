/**
 * A decorator class that filters out vowels from the words read by the underlying text reader.
 * It extends the TextFilterDecorator class.
 */
public class VowelFilter extends TextFilterDecorator {
    private VowelFilter(TextReaderInterface textReader) {
        super(textReader);
    }

    public static TextReaderInterface addVowelFilter(TextReaderInterface textReader) {
        return new VowelFilter(textReader);
    }

    private static String filterVowels(String word) {
        return word.replaceAll("[aeiouAEIOUáéíóúÁÉÍÓÚàèìòùÀÈÌÒÙäëïöüÄËÏÖÜ]", "");
    }

    @Override
    public boolean hasNext() {
        return this.getTextReader().hasNext();
    }

    @Override
    public String next() {
        return filterVowels(this.getTextReader().next());
    }
}
