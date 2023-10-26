package encryptdecrypt.impl;

import encryptdecrypt.cypher.Cypher;
import encryptdecrypt.cypher.impl.CypherFactory;
import encryptdecrypt.io.Input;
import encryptdecrypt.io.Output;
import encryptdecrypt.io.impl.*;

public class Configuration {

    private final Input input;
    private final Output output;

    public Configuration(String[] args) {
        CLArgs clArgs = new CLArgs(args);
        Input in = makeInput(clArgs);
        Output out = makeOutput(clArgs);

        Cypher cypher = CypherFactory.create(clArgs.getAlg(), clArgs.getKey(), clArgs.getMode());

        if ("dec".equals(clArgs.getMode())) {
            this.input = new DecryptReader(in, cypher);
            this.output = out;
        } else {
            this.input = in;
            this.output = new EncryptWriter(out, cypher);
        }

    }

    private Input makeInput(CLArgs clArgs) {
        // make input
        if (clArgs.getData() != null) {
            return new StringInput(clArgs.getData());
        } else if (clArgs.getIn() != null) {

            return new FileIO(clArgs.getIn());
        } else {
            return new StringInput("");
        }
    }

    private Output makeOutput(CLArgs clArgs) {
        // make output
        if (clArgs.getOut() != null) {
            return new FileIO(clArgs.getOut());
        } else {
            return new TerminalIO();
        }
    }

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }
}
