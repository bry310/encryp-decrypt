package encryptdecrypt.impl;

import encryptdecrypt.cypher.Cypher;
import encryptdecrypt.cypher.impl.CypherFactory;
import encryptdecrypt.io.Input;
import encryptdecrypt.io.Output;
import encryptdecrypt.io.impl.*;

class Configuration {

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
        if (clArgs.getData().isPresent()) {
            return new StringInput(clArgs.getData().get());
        } else if (clArgs.getIn().isPresent()) {

            return new FileIO(clArgs.getIn().get());
        } else {
            return new StringInput("");
        }
    }

    private Output makeOutput(CLArgs clArgs) {
        // make output
        if (clArgs.getOut().isPresent()) {
            return new FileIO(clArgs.getOut().get());
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
