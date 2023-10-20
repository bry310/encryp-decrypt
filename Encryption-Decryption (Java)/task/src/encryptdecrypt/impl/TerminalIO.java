package encryptdecrypt.impl;

import encryptdecrypt.IO;

import java.util.Scanner;

class TerminalIO implements IO {

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
