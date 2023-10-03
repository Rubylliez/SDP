package Strategies;

public class LowerCaseStrategy implements TextFormattingStrategy {
    @Override
    public String format(String text) {
        return text.toLowerCase();
    }
}