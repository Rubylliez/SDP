package TextEditor;

import Strategies.TextFormattingStrategy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TextEditor {
    private static TextEditor instance;
    private final Map<String, String> documents;

    private TextEditor() {
        documents = new HashMap<>();
    }
    public static TextEditor getInstance() {
        if (instance == null) {
            instance = new TextEditor();
        }
        return instance;
    }

    public void openDocument(String document) {
        File file = new File(document);
        if (file.exists() && file.isFile()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                documents.put(document, content.toString());
                System.out.println("Opened document: " + document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            documents.put(document, "");
            System.out.println("Created a new document: " + document);
        }
    }

    public void saveDocument(String document, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(document));
            writer.write(content);
            writer.close();
            System.out.println("Saved document: " + document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String formatText(String text, TextFormattingStrategy strategy) {
        return strategy.format(text);
    }
}