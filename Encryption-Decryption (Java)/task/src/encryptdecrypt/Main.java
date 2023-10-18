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
        if ( ! Character.isLetter(c)) {
            return (char)c;
        }
        int a = 'a';
        int from_a = c - 'a';
        int new_from_a = (from_a + key) % 26;
        return (char)(a + new_from_a);
    }

    private char decryptChar(char c){
        if ( ! Character.isLetter(c)) {
            return (char)c;
        }
        int a = 'a';
        int from_a = c - 'a';
        int new_from_a = (from_a - key) % 26;
        return (char)(a + new_from_a);
    }

}


public class Main {
    public static void main(String[] args) {



        try {

            CLArgs clArgs = new CLArgs(args);

            int key = clArgs.getKey();
            String mode = clArgs.getMode();
            String alg = clArgs.getAlg();


            Input input;
            if (clArgs.getData() != null) {
                input = new StringInput(clArgs.getData());
            } else if (clArgs.getIn() != null) {

                input = new FileIO(clArgs.getIn());
            } else {
                input = new StringInput("");
            }

            Output output;
            if (clArgs.getOut() != null) {
                output = new FileIO(clArgs.getOut());
            } else {
                output = new TerminalIO();
            }


            Cypher cypher = alg.equals("shift") ?
                    new ShiftCypher(key) :
                    new UnicodeCypher(key);

            Mapper cypherMapper = mode.equals("enc") ?
                    new CypherMapper(cypher, CypherMapper.ENCRYPT) :
                    new CypherMapper(cypher, CypherMapper.DECRYPT);

            cypherMapper.map(input, output);

        } catch (Exception e){
            System.out.print("Error");
        }

    }

}