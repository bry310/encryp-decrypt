package encryptdecrypt;

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