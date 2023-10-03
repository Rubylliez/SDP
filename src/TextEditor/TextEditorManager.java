package TextEditor;
import Handler.InputHandler;
import Strategies.LowerCaseStrategy;
import Strategies.TextFormattingStrategy;
import Strategies.TitleCaseStrategy;
import Strategies.UpperCaseStrategy;

public class TextEditorManager {
    private final TextEditor editor;

    public TextEditorManager(TextEditor editor) {
        this.editor = editor;
    }

    public void processInputAndSave() {
        InputHandler inputHandler = new InputHandler();

        String documentName = "sample.txt";
        editor.openDocument(documentName);

        String text = inputHandler.getUserInput();

        System.out.println("Original Text: " + text);

        TextFormattingStrategy titleCase = new TitleCaseStrategy();
        String formattedText = editor.formatText(text, titleCase);

        System.out.println("Upper Case: " + editor.formatText(text, new UpperCaseStrategy()));
        System.out.println("Lower Case: " + editor.formatText(text, new LowerCaseStrategy()));
        System.out.println("Title Case: " + formattedText);

        editor.saveDocument(documentName, formattedText);
    }
}