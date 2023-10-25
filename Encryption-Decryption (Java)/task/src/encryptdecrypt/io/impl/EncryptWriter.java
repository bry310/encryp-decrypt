package encryptdecrypt.io.impl;

import encryptdecrypt.cypher.Cypher;
import encryptdecrypt.io.Output;

public class EncryptWriter implements Output {
    private final Output target;
    private final Cypher encryptor;

    public EncryptWriter(Output output, Cypher encryptor) {
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
