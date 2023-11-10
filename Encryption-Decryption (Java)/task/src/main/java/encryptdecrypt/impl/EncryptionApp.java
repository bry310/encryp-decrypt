package encryptdecrypt.impl;

import encryptdecrypt.io.Input;
import encryptdecrypt.io.Output;

public class EncryptionApp implements Runnable {

    Input input;
    Output output;

    public EncryptionApp(String args[]) {
        var configuration = new Configuration(args);
        this.input = configuration.getInput();
        this.output = configuration.getOutput();
    }

    public void run() {
        output.write(input.read());
    }

}
