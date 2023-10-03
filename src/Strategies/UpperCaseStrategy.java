package Strategies;

public class UpperCaseStrategy implements TextFormattingStrategy {
    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}