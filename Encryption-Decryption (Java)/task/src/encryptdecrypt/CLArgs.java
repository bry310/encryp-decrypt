package encryptdecrypt;

public class CLArgs {
    private int key = 0;
    private String data = "";
    private String mode = "enc";

    public CLArgs(String[] args){
        int i = 0;
        while( i < args.length ){
            String flag = args[i];

                if ("-mode".equals(flag))
                    this.mode = args[i+1];

                if ( "-key".equals(flag) )
                    this.key = Integer.parseInt(args[i+1]);

                if ("-data".equals(flag))
                    this.data = args[i+1];


            i = i + 2;

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

}
