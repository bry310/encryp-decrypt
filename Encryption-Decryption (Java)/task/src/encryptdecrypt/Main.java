package encryptdecrypt;


//abcdefghijklmnopqrstuvwxyz

class DomeCypher implements Cypher {

    private int key;
    DomeCypher(int key){
        this.key = key;
    }

    @Override
    public  String encrypt(String msg) {
        String emsg = "";
        for(char c : msg.toCharArray()){
            emsg = emsg + encryptChar(c);
        }
        return emsg;
    }

    @Override
    public String decrypt(String code){
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

public class Main {
    public static void main(String[] args) {

        CLArgs clArgs = new CLArgs(args);

        int key = clArgs.getKey();
        String mode = clArgs.getMode();
        String data = clArgs.getData();

        Cypher cypher = new DomeCypher(key);
        Mapper cypherMapper = mode.equals("enc") ?
                new CypherMapper(cypher, CypherMapper.ENCRYPT) :
                new CypherMapper(cypher, CypherMapper.DECRYPT);

        Input input = new InputString(data);
        Output output = new TerminalIO();
        cypherMapper.map(input,output);

    }

}