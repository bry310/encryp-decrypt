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
