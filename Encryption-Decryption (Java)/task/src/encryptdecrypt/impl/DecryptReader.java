package encryptdecrypt.impl;

import encryptdecrypt.Cypher;
import encryptdecrypt.Input;

class DecryptReader implements Input {

    private final Input source;
    private final Cypher decrypter;

    DecryptReader(Input source, Cypher decryptor) {
        this.source = source;
        this.decrypter = decryptor;
    }

    @Override
    public String read() {
        return decrypter.cypher(source.read());
    }


}
