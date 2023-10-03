package Handler;

import java.util.Scanner;

public class InputHandler {
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write your string: ");
        return scanner.nextLine();
    }
}
