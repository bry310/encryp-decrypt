package encryptdecrypt;

public interface Encryptor {

    abstract String encrypt(String msg);
    abstract String decrypt(String code);
}
