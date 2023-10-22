package encryptdecrypt.impl;

import encryptdecrypt.Cypher;
import encryptdecrypt.Output;

class EncryptWriter implements Output {
    private final Output target;
    private final Cypher encryptor;

    EncryptWriter(Output output, Cypher encryptor) {
        this.target = output;
        this.encryptor = encryptor;
    }

    /**
     * @param string
     */
    @Override
    public void write(String string) {
        target.write(encryptor.cypher(string));
    }
}
