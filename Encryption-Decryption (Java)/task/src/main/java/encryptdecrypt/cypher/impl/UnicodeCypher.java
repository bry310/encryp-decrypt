package encryptdecrypt.cypher.impl;

import encryptdecrypt.cypher.Cypher;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

class UnicodeCypher implements Cypher {

    private final int key;

    private final boolean decryptor;

    public UnicodeCypher(int key, boolean decryptor) {
        this.key = key;
        this.decryptor = decryptor;
    }

    private String encrypt(String msg) {
        return transformString(msg, this::encryptChar);
    }

    private String decrypt(String code) {
        return transformString(code, this::decryptChar);
    }

    private String transformString(String string, UnaryOperator<Character> mapper) {
        return string.chars()
                .mapToObj(i -> (char) (i))
                .map(mapper)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    @Override
    public String cypher(String code) {
        return decryptor ? decrypt(code) : encrypt(code);
    }

    private char encryptChar(char c) {
        int a = 'a';
        int fromA = c - 'a';
        int newFromA = (fromA + key);
        return (char) (a + newFromA);
    }

    private char decryptChar(char c) {
        int a = 'a';
        int fromA = c - 'a';
        int newFromA = (fromA - key);
        return (char) (a + newFromA);
    }
}
