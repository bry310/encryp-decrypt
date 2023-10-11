package encryptdecrypt;

import java.util.Scanner;

public class TerminalIO implements IO {

    Scanner scanner;
    public TerminalIO(){
        scanner = new Scanner(System.in);
    }
    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void print(String string) {
        System.out.print(string);

    }
}
