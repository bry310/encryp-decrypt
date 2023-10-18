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
        String emsg = "";
        for(char c : msg.toCharArray()){
            emsg = emsg + encryptChar(c);
        }
        return emsg;
    }

    /**
     * @param code
     * @return
     */
    @Override
    public String decrypt(String code) {
        String msg = "";
        for(char c : code.toCharArray()){
            msg = msg + decryptChar(c);
        }
        return msg;
    }

    private char encryptChar(char c){
        int a = 'a';
        int from_a = c - 'a';
        int new_from_a = (from_a + key) ;
        return (char)(a + new_from_a);
    }

    private char decryptChar(char c){
        int a = 'a';
        int from_a = c - 'a';
        int new_from_a = (from_a - key) ;
        return (char)(a + new_from_a);
    }
}
