package encryptdecrypt;

public class CLArgs  {
    private int key = 0;
    private String data = null;
    private String mode = "enc";
    private String out = null;
    private String in = null;
    private String alg = "shift";

    public CLArgs(String[] args)  {

        int i = 0;
        while( i < args.length ){
            String flag = args[i];

                if ("-mode".equals(flag)) {
                    this.mode = args[i + 1];
                    i = i + 2;
                }else if ( "-key".equals(flag) ) {
                    this.key = Integer.parseInt(args[i + 1]);
                    i = i + 2;
                } else if ("-data".equals(flag)) {
                    this.data = args[i + 1];
                    i = i + 2;
                }else if ("-in".equals(flag)) {
                    this.in = args[i + 1];
                    i = i + 2;
                }else if ("-out".equals(flag)) {
                    this.out = args[i + 1];
                    i = i + 2;
                } else if ("-alg".equals(flag)){
                    this.alg = args[i + 1];
                    i = i + 2;
                }
                else {
                    throw new JustException("Error");
                }
        }
    }

    public int getKey(){
        return key;
    }

    public String getMode(){
        return mode;
    }

    public String getData(){
        return data;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public String getAlg() {
        return alg;
    }
}
