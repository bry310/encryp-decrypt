package encryptdecrypt;

import encryptdecrypt.impl.Configuration;
import encryptdecrypt.io.Input;
import encryptdecrypt.io.Output;

public class EncryptionApp implements Runnable {

    Input input;
    Output output;

    public EncryptionApp(Configuration configuration) {
        this.input = configuration.getInput();
        this.output = configuration.getOutput();
    }

    public void run() {
        output.write(input.read());
    }

}
