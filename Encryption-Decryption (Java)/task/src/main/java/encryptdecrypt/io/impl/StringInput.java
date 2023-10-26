package encryptdecrypt.io.impl;

import encryptdecrypt.io.Input;

public class StringInput implements Input {
    private final String string;

    public StringInput(String string) {
        this.string = string;
    }

    @Override
    public String read() {
        return string;
    }

}
