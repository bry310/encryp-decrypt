package encryptdecrypt.io.impl;

import encryptdecrypt.io.IO;

import java.io.BufferedReader;
import java.io.IOException;

public class TerminalIO implements IO {

    private final BufferedReader bufferedReader;

    public TerminalIO() {
        bufferedReader = new BufferedReader(System.console().reader());
    }

    @Override
    public String read() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new JustException("error");
        }
    }

    @Override
    public void write(String string) {
        System.out.print(string);

    }
}
