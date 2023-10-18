package encryptdecrypt;

public interface Factory {

    public Object create();

    Cypher create(String alg, int key);
}
