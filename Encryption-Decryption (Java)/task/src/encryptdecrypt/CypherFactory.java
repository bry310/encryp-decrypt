package encryptdecrypt;

public class CypherFactory {
    /**
     * @return
     */

    public Cypher create(String alg,  int key) {
        if ( "shift".equals(alg)){
            return new ShiftCypher(key);
        } else {
            return new UnicodeCypher(key);
        }
    }
}
