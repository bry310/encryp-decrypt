package encryptdecrypt;

public class UnicodeCypher implements Cypher{

    private int key;

    UnicodeCypher (int key){
        this.key = key;
    }
    /**
     * @param msg
     * @return
     */
    @Override
    public String encrypt(String msg) {
        StringBuilder sb = new StringBuilder();
        for(char c : msg.toCharArray()){
            sb.append(encryptChar(c));
        }
        return sb.toString();
    }

    /**
     * @param code
     * @return
     */
    @Override
    public String decrypt(String code) {
        StringBuilder sb = new StringBuilder();
        for(char c : code.toCharArray()){
            sb.append(decryptChar(c));
        }
        return sb.toString();
    }

    private char encryptChar(char c){
        int a = 'a';
        int fromA = c - 'a';
        int newFromA = (fromA + key) ;
        return (char)(a + newFromA);
    }

    private char decryptChar(char c){
        int a = 'a';
        int fromA = c - 'a';
        int newFromA = (fromA - key) ;
        return (char)(a + newFromA);
    }
}
