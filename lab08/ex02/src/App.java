public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Testing TextReader ---");
        TextReaderInterface textReader = TextReader.createTextReader(args[0]);
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }
        System.out.println("--- TEST ENDED ---");
        System.out.println("--- Testing TermFilter ---");
        textReader = TermFilter.addTermFilter(TextReader.createTextReader(args[0]));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }
        System.out.println("--- TEST ENDED ---");
        System.out.println("--- Testing VowelFilter ---");
        textReader = VowelFilter.addVowelFilter(TextReader.createTextReader(args[0]));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }
        System.out.println("--- TEST ENDED ---");
        System.out.println("--- Testing NormalizationFilter ---");
        textReader = NormalizationFilter.addNormalizationFilter(TextReader.createTextReader(args[0]));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }
        System.out.println("--- TEST ENDED ---");
        System.out.println("--- Testing CapitalizationFilter ---");
        textReader = CapitalizationFilter.addCapitalizationFilter(TextReader.createTextReader(args[0]));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }
        System.out.println("--- TEST ENDED ---");
        System.out.println("--- Testing TermFilter -> VowelFilter -> NormalizationFilter -> CapitalizationFilter ---");
        textReader = CapitalizationFilter.addCapitalizationFilter(NormalizationFilter.addNormalizationFilter(VowelFilter.addVowelFilter(TermFilter.addTermFilter(TextReader.createTextReader(args[0])))));
        while (textReader.hasNext()) {
            System.out.println(textReader.next());
        }
        System.out.println("--- TEST ENDED ---");
    }
}
