package encryptdecrypt;

public class CypherMapper implements Mapper{

    public enum Mode {ENCRYPT, DECRYPT}
    public static final Mode ENCRYPT = Mode.ENCRYPT;
    public static final Mode DECRYPT = Mode.DECRYPT;
    private final Cypher cypher;
    private final Mode mode;
    public CypherMapper(Cypher cypher, Mode mode){
        this.mode = mode;
        this.cypher = cypher;
    }
    @Override
    public void map(Input in, Output out) {
        if( mode == Mode.ENCRYPT)
            out.print(cypher.encrypt(in.getInput()));
        else
            out.print(cypher.decrypt((in.getInput())));
    }
}
