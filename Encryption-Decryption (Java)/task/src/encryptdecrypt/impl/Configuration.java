package encryptdecrypt.impl;

import encryptdecrypt.Cypher;
import encryptdecrypt.Input;
import encryptdecrypt.Mapper;
import encryptdecrypt.Output;

public class Configuration {

    private final Input input;
    private final Output output;
    private final Mapper mapper;

    public Configuration(CLArgs clArgs) {

        // make input
        if (clArgs.getData() != null) {
            input = new StringInput(clArgs.getData());
        } else if (clArgs.getIn() != null) {

            input = new FileIO(clArgs.getIn());
        } else {
            input = new StringInput("");
        }

        // make output
        if (clArgs.getOut() != null) {
            output = new FileIO(clArgs.getOut());
        } else {
            output = new TerminalIO();
        }


        Cypher cypher = CypherFactory.create(clArgs.getAlg(), clArgs.getKey(), clArgs.getMode());

        mapper = new CypherMapper(cypher);

    }

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }

    public Mapper getMapper() {
        return mapper;
    }
}
