package encryptdecrypt;

import encryptdecrypt.impl.Configuration;
import encryptdecrypt.io.Input;
import encryptdecrypt.io.Output;

public class App implements Runnable {

    Input input;
    Output output;

    public App(Configuration configuration) {
        this.input = configuration.getInput();
        this.output = configuration.getOutput();
    }

    public void run() {
        output.write(input.read());
    }

}
