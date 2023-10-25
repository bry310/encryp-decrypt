package encryptdecrypt.io.impl;

import encryptdecrypt.io.IO;

import java.util.Scanner;

public class TerminalIO implements IO {

    Scanner scanner;

    public TerminalIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String string) {
        System.out.print(string);

    }
}
