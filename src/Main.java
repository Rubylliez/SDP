import TextEditor.TextEditor;
import TextEditor.TextEditorManager;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = TextEditor.getInstance();
        TextEditorManager editorManager = new TextEditorManager(editor);
        editorManager.processInputAndSave();
    }
}