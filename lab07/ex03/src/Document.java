import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class Document {
    private static final int CHARACTERS_PER_PAGE = 500;
    String title;
    String text[];

    private Document(String title, String[] text){
        this.title = title;
        this.text = text;
    }

    public static Document createDocument(String title, String[] text){
        return new Document(title, text);
    }

    public static Document createDocument(String fileName){
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            int page = 1;
            String[] pages = new String[(content.length() / CHARACTERS_PER_PAGE) + 1];
            while ((page-1) * CHARACTERS_PER_PAGE < content.length()){
                pages[page-1] = content.substring((page-1) * CHARACTERS_PER_PAGE, Math.min(page * CHARACTERS_PER_PAGE, content.length()));
                page++;
            }
            return new Document(fileName, pages);
        } catch (IOException e) {
            System.out.println("argh");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "\"" + this.text[0].substring(0, (this.text[0].length() > 30) ? 30 : this.text[0].length()) + ((this.text[0].length() > 30) ? "...\"" : "\"");
    }
}