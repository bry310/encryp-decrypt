package encryptdecrypt;

public class CypherMapper implements Mapper{

    public enum Mode { encrypt, decrypt}
    public static final Mode ENCRYPT = Mode.encrypt;
    public static final Mode DECRYPT = Mode.decrypt;
    private Cypher cypher;
    private Mode mode;
    public CypherMapper(Cypher cypher, Mode mode){
        this.mode = mode;
        this.cypher = cypher;
    }
    @Override
    public void map(Input in, Output out) {

        if( mode == Mode.encrypt)
            out.print(cypher.encrypt(in.getInput()));
        else
            out.print(cypher.decrypt((in.getInput()))) ;

    }
}
