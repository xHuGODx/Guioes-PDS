/**
 * The TextFilterDecorator class is an abstract class that implements the TextReaderInterface interface.
 * It serves as a base class for decorators that add filtering functionality to a text reader.
 */
public abstract class TextFilterDecorator implements TextReaderInterface{
    private TextReaderInterface textReader;

    protected TextFilterDecorator(TextReaderInterface textReader){
        this.textReader = textReader;
    }

    public TextReaderInterface getTextReader(){
        return textReader;
    }

    @Override
    public String getCurLine(){
        return textReader.getCurLine();
    }
}
