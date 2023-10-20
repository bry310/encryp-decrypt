package encryptdecrypt.impl;

import encryptdecrypt.Cypher;
import encryptdecrypt.Input;
import encryptdecrypt.Mapper;
import encryptdecrypt.Output;

class CypherMapper implements Mapper {


    private final Cypher cypher;

    public CypherMapper(Cypher cypher) {
        this.cypher = cypher;
    }

    @Override
    public void map(Input in, Output out) {
        out.write(cypher.cypher(in.read()));

    }
}
