package encryptdecrypt;

public class ShiftCypher implements Cypher{

    private int key;
    ShiftCypher (int key){
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
        if (!Character.isLetter(c)){
            return c;
        }else {
            boolean wasUpper = Character.isUpperCase(c);
            int a = wasUpper ? 'A' :  'a';
            int fromA = c - a;
            int newFromA = (fromA + key)%26;
            return (char) (a + newFromA);
        }
    }

    private char decryptChar(char c){
        if ( !Character.isLetter(c)){
            return c;
        }else {
            boolean wasUpper = Character.isUpperCase(c);
            int z = wasUpper ? 'Z' : 'z';
            int fromZ =  z - c;
            int newFromZ = (fromZ + key)%26;
            return (char) (z - newFromZ);
        }
    }
}
