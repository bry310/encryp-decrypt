package encryptdecrypt.cypher.impl;

import encryptdecrypt.cypher.Cypher;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

class ShiftCypher implements Cypher {

    private final int key;
    private final boolean decryptor;

    public ShiftCypher(int key, boolean decryptor) {
        this.key = key;
        this.decryptor = decryptor;
    }

    @Override
    public String cypher(String code) {
        return decryptor ? decrypt(code) : encrypt(code);
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

    private char encryptChar(char c) {
        if (!Character.isLetter(c)) {
            return c;
        } else {
            boolean wasUpper = Character.isUpperCase(c);
            int a = wasUpper ? 'A' : 'a';
            int fromA = c - a;
            int newFromA = (fromA + key) % 26;
            return (char) (a + newFromA);
        }
    }

    private char decryptChar(char c) {
        if (!Character.isLetter(c)) {
            return c;
        } else {
            boolean wasUpper = Character.isUpperCase(c);
            int z = wasUpper ? 'Z' : 'z';
            int fromZ = z - c;
            int newFromZ = (fromZ + key) % 26;
            return (char) (z - newFromZ);
        }
    }
}
