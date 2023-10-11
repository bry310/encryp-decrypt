package encryptdecrypt;

public interface Cypher {

    abstract String encrypt(String msg);
    abstract String decrypt(String code);
}
