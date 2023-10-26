package encryptdecrypt.io.impl;

import encryptdecrypt.cypher.Cypher;
import encryptdecrypt.io.Input;

public class DecryptReader implements Input {

    private final Input source;
    private final Cypher decrypter;

    public DecryptReader(Input source, Cypher decryptor) {
        this.source = source;
        this.decrypter = decryptor;
    }

    @Override
    public String read() {
        return decrypter.cypher(source.read());
    }


}
