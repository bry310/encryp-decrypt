package encryptdecrypt.impl;

import encryptdecrypt.Cypher;

public class CypherFactory {
    private CypherFactory() {

    }

    public static Cypher create(String alg, int key, String mode) {
        if ("shift".equals(alg)) {
            return new ShiftCypher(key, "dec".equals(mode));
        } else {
            return new UnicodeCypher(key, "dec".equals(mode));
        }
    }
}
